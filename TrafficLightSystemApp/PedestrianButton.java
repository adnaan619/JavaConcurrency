package TrafficLightSystemApp;

public class PedestrianButton implements Runnable {
    private final TrafficLightController trafficLightController;

    public PedestrianButton(TrafficLightController controller){
        this.trafficLightController = controller;
    }

    @Override
    public void run(){
        try{
            while(true){
                Thread.sleep((int) (Math.random() * 15000));  //Simulate random button press
                System.out.println("Pedestrian button pressed at " + Thread.currentThread().getName());
                synchronized (trafficLightController){
                    if (trafficLightController.getCurrentState() != TrafficLightState.RED){
                        trafficLightController.notifyAll();
                    }
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
