package MonitorJava;

public class ConcurrentMonitorProgram {
    public static void main(String[] args) {
        SharedResource sharedResoure = new SharedResource();

        //Creating multiple threads that access the shared resource
        Thread thread1 = new SharedResourceUser(sharedResoure);
        Thread thread2 = new SharedResourceUser(sharedResoure);

        thread1.start();
        thread2.start();
    }
}
