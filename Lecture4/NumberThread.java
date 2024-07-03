package Lecture4;

public class NumberThread extends Thread {
    public NumberThread(String name){
        super(name);
    }

    public void run(){
        for (int i=0; i<=10; i++){  //Reduce the count for simplicity
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try{
                Thread.sleep(100); //Sleep for 100ms to simulate work
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
