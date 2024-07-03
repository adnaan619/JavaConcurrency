package BasicThreadSynchronization;

public class ThreadB extends Thread{
    private final SharedCounter sharedCounter;

    public ThreadB(SharedCounter sharedCounter){
        this.sharedCounter = sharedCounter;
    }

    public void run(){
        for (int i=0; i<100; i++){
            sharedCounter.increment();
        }
    }
}
