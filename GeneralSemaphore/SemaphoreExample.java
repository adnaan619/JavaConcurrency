package GeneralSemaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        ResourcePool pool = new ResourcePool(3);

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            pool.accessResource(threadName);
        };

        for ( int i=0; i<6; i++){
            new Thread(task, "Thread-" + i).start();
        }
    }
}
