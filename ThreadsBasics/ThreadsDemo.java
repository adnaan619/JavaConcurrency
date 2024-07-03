package ThreadsBasics;

public class ThreadsDemo{
    public static void main(String[] args){
        MyThread thread1 = new MyThread();
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();

        for (int i=0; i<5; i++){
            System.out.println("Main Thread: "+ i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


//The advantages of using the extending of the thread is that it allows the 
//easyness of accessing methods like getName, getId and so on.
//The disadvantages of using the extending thread is that it only allows single
//inheritance and cannot implement other interfaces or other classes while it is 
//possible with the use of implementing of the runnable.
//Slightly more code implementing the runnable in comparison to the extending

