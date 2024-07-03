package BasicThreadSynchronization;

public class SharedCounter {
    private int counter = 0;

    //Synchronized method to increment the counter
    public synchronized void increment(){
        counter++;
    }

    //Getter method to retrieve the current value of the counter
    public int getCounter(){
        return counter;
    }
}
