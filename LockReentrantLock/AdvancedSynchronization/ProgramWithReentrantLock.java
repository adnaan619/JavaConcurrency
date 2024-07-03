package LockReentrantLock.AdvancedSynchronization;

public class ProgramWithReentrantLock {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new SharedResourceUser(sharedResource);
        Thread thread2 = new SharedResourceUser(sharedResource);

        thread1.start();
        thread2.start();

        for ( int i=0; i<5; i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            sharedResource.incrementCounter();
        }
    }
}
