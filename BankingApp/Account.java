package BankingApp;

public class Account {
    private String accNo;
    private double balance;

    public Account(String accNo, double balance){
        super();
        this.accNo = accNo;
        this.balance = balance;
    }

    public synchronized double withdraw(double amount){
        if ( balance >= amount){
            balance = balance - amount;
            System.out.println(Thread.currentThread().getName() + " withdrew :" + amount + " and new balance is : " + balance);
            return balance;
        } else{
            throw new IllegalArgumentException("Insufficient Balance");
        }
    }

    public synchronized double deposit(double amount){
        balance = balance + amount;
        System.out.println(Thread.currentThread().getName()+ " deposited: " + amount + " and the balance is: " + balance);
        return balance;
    }

    public synchronized double getBalance(){
        return balance;
    }

    public String getAccNo(){
        return accNo;
    }

}
