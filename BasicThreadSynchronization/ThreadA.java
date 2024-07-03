package BasicThreadSynchronization;

public class ThreadA extends Thread {
    private final SharedCounter sharedCounter;

    public ThreadA(SharedCounter sharedCounter){
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run(){
        for (int i=0; i<100; i++){
            sharedCounter.increment();
        }
    }
}
