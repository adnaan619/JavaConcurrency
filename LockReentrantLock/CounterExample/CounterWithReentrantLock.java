package LockReentrantLock.CounterExample;

import java.util.concurrent.locks.ReentrantLock;

public class CounterWithReentrantLock {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try{
            count++;
            System.out.println(Thread.currentThread().getName() + " counter incremented to: " + count);
        } finally{
            lock.unlock();
        }
    }

    public int getCount(){
        return count;
    }
}
