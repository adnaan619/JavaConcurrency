package MonitorJava;

public class SharedResource{
    private int counter = 0;

    public synchronized void increment(){
        int oldValue = counter;
        System.out.println(Thread.currentThread().getName()+ " - Before Increment - " + oldValue);

        try{
            Thread.sleep(100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        counter++;
        int newValue = counter;
        System.out.println(Thread.currentThread().getName()+ " - After Increment - " + newValue);
    }
}