package Lecture4;

public class ThreadDemo {
    public static void main(String[] args) {
        // Create threads using the extended Thread class
        Thread t1 = new NumberThread("NumberThread-1");
        Thread t2 = new NumberThread("NumberThread-2");

        // Create a thread using the Runnable implementation
        Runnable r1 = new RunnableThread();
        Thread t3 = new Thread(r1, "RunnableThread");

        // Start the threads
        t1.start();
        t2.start();
        t3.start();

        // Main thread work
        for (int i = 0; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : Main " + i);
            try {
                Thread.sleep(100); // Sleep to simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
