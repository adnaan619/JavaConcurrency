package BankingApp;

public class Husband implements Runnable {
    private String name;
    private Account account;

    public Husband(String name, Account account){
        this.account = account;
        this.name = name;
    }

    public String getName(){
        return name;
    }
    
    public void run(){
        for ( int i=0; i<10; i++){
            try{
                account.withdraw(600.00);
            } catch (IllegalArgumentException e){
                System.out.println(Thread.currentThread().getName() + " Insufficient Funds");
            }
        }
    }
}
