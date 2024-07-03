package BasicThreadSynchronization;

public class SharedCounterExample {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        //Creating two threads, ThreadA and ThreadB, sharing the same counter
        ThreadA thread1 = new ThreadA(sharedCounter);
        ThreadB thread2 = new ThreadB(sharedCounter);

        thread1.start();
        thread2.start();

        //Waiting for both of the threads to complete
        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        //Displaying the final value of the counter
        System.out.println("Final Counter Value: " + sharedCounter.getCounter());
    }
}
