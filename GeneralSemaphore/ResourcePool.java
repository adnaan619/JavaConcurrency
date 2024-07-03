package GeneralSemaphore;

import java.util.concurrent.Semaphore;

public class ResourcePool {
    private final Semaphore semaphore;

    public ResourcePool(int poolSize){
        semaphore = new Semaphore(poolSize);
    }

    public void accessResource(String threadName){
        try{
            semaphore.acquire();
            System.out.println(threadName + " acquired a permit");
            Thread.sleep(1000);
            System.out.println(threadName + " released a permit");
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}
