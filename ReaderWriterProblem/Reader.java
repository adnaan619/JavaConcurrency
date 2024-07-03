package ReaderWriterProblem;

public class Reader implements Runnable {

    private final Account account;

    public Reader(Account account){
        this.account = account;
    }

    @Override
    public void run(){
        for (int i=0; i<5; i++){
            account.getBalance();
            try{
                Thread.sleep((int)(Math.random() * 1000)); //Simulate time taken to read
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
