package ThreadTransitions;

public class ThreadStateExamples {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);

        // NEW state
        System.out.println("The thread is currently not started but created and is in the : " + thread.getState()); // NEW

        thread.start();
        // Runnable state
        System.out.println("The thread has started and is in the runnable state: " + thread.getState()); // RUNNABLE

        try {
            Thread.sleep(500); // Main thread sleeps to let the new thread start

            System.out.println("The thread is in the sleeping state: " + thread.getState()); // TIMED_WAITING

            // Creating a blocker thread to demonstrate BLOCKED state
            Thread blockerThread = new Thread(() -> {
                synchronized (myRunnable){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });

            synchronized (myRunnable) {
                // Start the blocker thread while holding the lock to force the main thread into BLOCKED state
                blockerThread.start();
                Thread.sleep(100); // Ensure the blocker thread has acquired the lock

                System.out.println("Before notify, the main thread should be in BLOCKED state when trying to synchronize: " + thread.getState()); // BLOCKED

                myRunnable.notify(); // Notify the waiting thread (if any)
            }

            Thread.sleep(500);

            System.out.println("The thread is notified: " + thread.getState()); // RUNNABLE or TIMED_WAITING

            thread.join(); // Wait for the thread to finish

            System.out.println("The thread is terminated and is in the : " + thread.getState()); // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}