package Lecture4;

public class RunnableThread implements Runnable {
    @Override
    public void run(){
        for (int i=65; i<=90; i++){
            System.out.println(Thread.currentThread().getName() + " : " + ((char) i));
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
