package PhilosophersDiningProblem;

public class Philosopher implements Runnable {
    private final Object leftFork;
    private final Object rightFork;
    private final int philosopherNumber;

    public Philosopher(int philosopherNumber, Object rightFork, Object leftFork){
        this.philosopherNumber = philosopherNumber;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public void run(){
        try{
            while(true){
                think();
                synchronized (leftFork){
                    pickUpLeftFork();
                    synchronized (rightFork){
                        pickUpRightFork();
                        eat();
                        putDownRightFork();
                    }
                    putDownLeftFork();
                }
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException{
        System.out.println("Philo " + philosopherNumber + " is thinking.");
        Thread.sleep(((int) (Math.random() * 100)));
    }

    private void pickUpLeftFork() {
        System.out.println("Philosopher " + philosopherNumber + " picked up left fork.");
    }

    private void pickUpRightFork() {
        System.out.println("Philosopher " + philosopherNumber + " picked up right fork.");
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + philosopherNumber + " is eating.");
        Thread.sleep(((int) (Math.random() * 100)));
    }

    private void putDownRightFork() {
        System.out.println("Philosopher " + philosopherNumber + " put down right fork.");
    }

    private void putDownLeftFork() {
        System.out.println("Philosopher " + philosopherNumber + " put down left fork.");
    }
}
