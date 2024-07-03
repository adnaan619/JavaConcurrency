package ThreadLifecycle;

public class ThreadLifeCycleDemo{
    public static void main(String[] args) {
        //NEW state
        Thread newThread = new Thread(() -> {
            //Runnable State
            System.out.println("Thread in Runnable state");

            //Simulating some task
            for ( int i=0; i<3; i++){
                System.out.println("Executing the task in the Runnable state." + i);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            //Blocked State (synchronized block)
            synchronized (ThreadLifeCycleDemo.class){
                System.out.println("Thread is in the Blocked state");
            }

            //Waiting state
            synchronized (ThreadLifeCycleDemo.class){
                try{
                System.out.println("Thread in the waiting state");
                ThreadLifeCycleDemo.class.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            //Timed waiting state
            try{
                System.out.println("Thread in the timed waiting state");
                Thread.sleep(3000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            //Terminated state
            System.out.println("Thread is in the terminated state");
        });

        //Starting the thread
        newThread.start();

        //Main thread
        for (int i=0; i<5; i++){
            System.out.println("Main thread is executing");
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        //Notify the waiting thread to move from to the runable state
        synchronized (ThreadLifeCycleDemo.class){
            System.out.println("Notifying the waiting thread");
            ThreadLifeCycleDemo.class.notify();
        }

        //Waiting for the new thread to finish
        try{
            newThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Main thread is Terminated");
    }
}