package ReaderWriterProblem;

public class Writer implements Runnable{
    private Account account;

    public Writer(Account account){
        this.account = account;
    }

    @Override 
    public void run(){
        for (int i=0; i<5; i++){
            double amount = (int) (Math.random() * 100); 
            if (Math.random() > 0.5){
                account.deposit(amount);
            } else{
                account.withdraw(amount);
            }
            try{
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
