package Semaphore;

import java.util.concurrent.Semaphore;

public class ParkingLot {
    //Create a Semaphore
    private final Semaphore parkingSpaces = new Semaphore(5);

    public void parkCar(){
        try{
            System.out.println(Thread.currentThread().getName() + " is trying to park.");
            parkingSpaces.acquire(); //Acquire the permit
            System.out.println(Thread.currentThread().getName() + " has parked.");
            Thread.sleep(1000); //Simulate the parking time
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " is leaving.");
            parkingSpaces.release();  //Release the permit
        }
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        for (int i=0; i<10; i++){
            Thread car = new Thread(() -> parkingLot.parkCar(), "Car " + i);
            car.start();
        }
    }
}
