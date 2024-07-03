package TrafficLightSystemApp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PedestrianSignal implements Runnable{
    private final TrafficLightController trafficLightController;
    private final PrintWriter logger;

    public PedestrianSignal(TrafficLightController controller, String logFileName) throws IOException{
        this.trafficLightController = controller;
        logger = new PrintWriter(new FileWriter(logFileName, true));
    }

    @Override
    public void run(){
        try{
            while(true){
                trafficLightController.waitForRed();
                logger.println("Pedestrian Signal: WALK");
                logger.flush();
                System.out.println(Thread.currentThread().getName() + " Pedestrian signal: WALK ");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " Pedestrian signal: STOP");
                logger.flush();
                System.out.println(Thread.currentThread().getName() + "Pedestrain signal: STOP");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally{
            logger.close();
        }
    }
}