package ReaderWriterProblem;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Account {
    private double balance;

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public Account(double initialBalance){
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        lock.writeLock().lock();
        try{
            balance = balance + amount;
            System.out.println(Thread.currentThread().getName()+ " deposited " + amount + " New balance: " + balance);
        } finally{
            lock.writeLock().unlock();
        }
    }

    public void withdraw(double amount){
        lock.writeLock().lock();
        try{
            if (balance >= amount){
                balance = balance - amount;
                System.out.println(Thread.currentThread().getName() + " - withdrew " + amount + " New balance: " + balance);
            } else{
                System.out.println(Thread.currentThread().getName()+ " insufficient funds for withdrawal of "+ balance);
            }
        } finally{
            lock.writeLock().unlock();
        }
    }

    public double getBalance(){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+ " read balance: " + balance);
            return balance;
        } finally{
            lock.readLock().unlock();
        }
    }
}
