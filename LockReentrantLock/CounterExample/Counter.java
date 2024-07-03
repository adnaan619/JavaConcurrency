package LockReentrantLock.CounterExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter{
    private int count = 0;
    private Lock lock = new ReentrantLock();

    //Increment the counter and display the count value
    public void increment(){
        lock.lock();
        try{
            count++;
            System.out.println(Thread.currentThread().getName() + "incremented count to: " + count);
        } finally {
            lock.unlock();
        }
    }

    public int getCount(){
        return count;
    }
}