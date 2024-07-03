package SchedulingYieldingThreads;

public class ThreadSchedulingDemo {
    public static void main(String[] args) {
        //Create multiple threads with0 varying properties
        Thread highPriorityThread = new Thread(new Task("High-Priority Thread"));
        Thread mediumPriorityThread = new Thread(new Task("Medium-Priority Thread"));
        Thread lowPriorityThread = new Thread(new Task("Low-Priority Thread"));

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        mediumPriorityThread.setPriority(Thread.NORM_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        //start all the threads
        highPriorityThread.start();
        mediumPriorityThread.start();
        lowPriorityThread.start();
    }
}
