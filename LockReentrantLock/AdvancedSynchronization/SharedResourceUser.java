package LockReentrantLock.AdvancedSynchronization;

public class SharedResourceUser extends Thread {
    private final SharedResource sharedResource;

    public SharedResourceUser(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run(){
        try{
            //wait for the condition (counter value) to be met
            sharedResource.waitForCondition(5);
            System.out.println(Thread.currentThread().getName() + " - Condition met!");

            //Perform some of the tasks after the condition is met
            System.out.println(Thread.currentThread().getName() + " - Task Completed!");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
