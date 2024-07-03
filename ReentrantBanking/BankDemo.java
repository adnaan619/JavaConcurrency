package ReentrantBanking;

public class BankDemo {
    public static void main(String[] args) {
        BankAccount accountA = new BankAccount(500);
        BankAccount accountB = new BankAccount(1100);

        Runnable transferTask = () -> {
            for ( int i=0; i<5; i++){
                accountA.transfer(accountB, 100);
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread thread1 = new Thread(transferTask, "Thread-1");
        Thread thread2 = new Thread(transferTask, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
