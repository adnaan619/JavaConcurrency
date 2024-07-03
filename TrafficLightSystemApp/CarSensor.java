package TrafficLightSystemApp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CarSensor implements Runnable {
    private final TrafficLightController trafficLightController;
    private final PrintWriter logger;

    public CarSensor(TrafficLightController controller, String logFileName) throws IOException {
        this.trafficLightController = controller;
        logger = new PrintWriter(new FileWriter(logFileName, true));
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((int) (Math.random() * 10000)); // Simulate random car arrival
                logger.println("Car arrived at " + Thread.currentThread().getName());
                logger.flush();
                System.out.println("Car arrived at " + Thread.currentThread().getName());
                synchronized (trafficLightController) {
                    if (trafficLightController.getCurrentState() == TrafficLightState.RED) {
                        trafficLightController.notifyAll();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            logger.close();
        }
    }
}
