package TrafficLightSystemApp;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;

public class TrafficLightSystem {
    public static void main(String[] args) {
        try {
            TrafficLightController controller1 = new TrafficLightController("controller1.log");
            TrafficLightController controller2 = new TrafficLightController("controller2.log");
            PedestrianSignal pedestrianSignal1 = new PedestrianSignal(controller1, "pedestrianSignal1.log");
            PedestrianSignal pedestrianSignal2 = new PedestrianSignal(controller2, "pedestrianSignal2.log");
            CarSensor carSensor1 = new CarSensor(controller1, "carSensor1.log");
            CarSensor carSensor2 = new CarSensor(controller2, "carSensor2.log");

            ExecutorService executor = Executors.newFixedThreadPool(6);
            executor.execute(() -> {
                Thread.currentThread().setName("Controller1");
                controller1.run();
            });
            executor.execute(() -> {
                Thread.currentThread().setName("Pedestrian1");
                pedestrianSignal1.run();
            });
            executor.execute(() -> {
                Thread.currentThread().setName("Controller2");
                controller2.run();
            });
            executor.execute(() -> {
                Thread.currentThread().setName("Pedestrian2");
                pedestrianSignal2.run();
            });
            executor.execute(() -> {
                Thread.currentThread().setName("CarSensor1");
                carSensor1.run();
            });
            executor.execute(() -> {
                Thread.currentThread().setName("CarSensor2");
                carSensor2.run();
            });

            executor.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
