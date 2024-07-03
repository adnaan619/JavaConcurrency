package TrafficLightSystemApp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class TrafficLightController implements Runnable {
    private TrafficLightState currentState;
    private final Lock lock = new ReentrantLock();
    private final Condition redCondition = lock.newCondition();
    private final PrintWriter logger;

    public TrafficLightController(String logFileName) throws IOException {
        currentState = TrafficLightState.RED; // Initial state
        logger = new PrintWriter(new FileWriter(logFileName, true));
    }

    public void changeState() {
        lock.lock();
        try {
            switch (currentState) {
                case RED:
                    currentState = TrafficLightState.GREEN;
                    break;
                case GREEN:
                    currentState = TrafficLightState.YELLOW;
                    break;
                case YELLOW:
                    currentState = TrafficLightState.RED;
                    redCondition.signalAll(); // signals the pedestrians when the light changes red
                    break;
            }
            logger.println("Traffic Light changed to: " + currentState);
            logger.flush();
            System.out.println(Thread.currentThread().getName() + " Traffic Light changed to: " + currentState);
        } finally {
            lock.unlock();
        }
    }

    public TrafficLightState getCurrentState() {
        lock.lock();
        try {
            return currentState;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                switch (currentState) {
                    case RED:
                        Thread.sleep(5000); //Red light duration
                        break;
                    case GREEN:
                        Thread.sleep(3000); //Green light duration
                        break;
                    case YELLOW:
                        Thread.sleep(2000); //Yellow light duration
                        break;
                }
                changeState();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            logger.close();
        }
    }

    public void waitForRed() throws InterruptedException {
        lock.lock();
        try {
            while (currentState != TrafficLightState.RED) {
                redCondition.await();
            }
        } finally {
            lock.unlock();
        }
    }
}
