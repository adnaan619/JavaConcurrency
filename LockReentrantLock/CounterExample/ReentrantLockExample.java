package LockReentrantLock.CounterExample;

import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockExample{
    public static void main(String[] args){
        Counter counter = new Counter();
        CounterWithReentrantLock reentrantCounter = new CounterWithReentrantLock();

        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++){
                counter.increment();
                reentrantCounter.increment();
            }
        };

        Thread thread1 = new Thread(task1, "Thread1");
        Thread thread2 = new Thread(task1, "Thread2");

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch ( InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final count for counter: " + counter.getCount());
        System.out.println("Final count for counter: " + reentrantCounter.getCount());

    }
}