package LockReentrantLock.AdvancedSynchronization;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void waitForCondition(int targetValue) throws InterruptedException {
        lock.lock();
        try{
            while (counter < targetValue){
                //wait until the counter reaches the target value
                condition.await();
            }
        } finally{
            lock.unlock();
        }
    }

    public void incrementCounter(){
        lock.lock();
        try{
            counter++;
            System.out.println(Thread.currentThread().getName() + " - Counter Incremented: " + counter);

            //signal waiting threads when the counter is incremented
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
