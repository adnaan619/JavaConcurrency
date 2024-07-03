package ReentrantBanking;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private final ReentrantLock lock = new ReentrantLock(); //Reentrant instance

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        lock.lock(); //Acquire the lock
        try{
            balance = balance + amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ",new balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount){
        lock.lock(); //Acquire the lock
        try{
            if (balance >= amount){
                balance = balance - amount;
                System.out.println(Thread.currentThread().getName() + " - withdrew " + amount + ", new balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " due to insufficient funds");
            }
        } finally{
            lock.unlock();  //Release the lock
        }
    }

    public void transfer(BankAccount toAccount, double amount){
        lock.lock();
        try{
            if (balance >= amount){
                withdraw(amount);
                toAccount.deposit(amount);
                System.out.println(Thread.currentThread().getName() + " transferred amount " + amount + " to " + toAccount);
            } else {
                System.out.println(Thread.currentThread().getName() + " tried to transfer " + amount + " but insufficient funds in account");
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString(){
        return "BankAccount{balance=" + balance + '}';
    }
}
