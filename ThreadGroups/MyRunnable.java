package ThreadGroups;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
            try{
                while(true){
                    System.out.println(Thread.currentThread().getName()+ " is running");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName()+ " has interrupted");
            }
    }
}