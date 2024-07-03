package BankingApp;

public class Wife implements Runnable {
    private String name;
    private Account account;

    public Wife(String name, Account account) {
        this.account = account;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
                account.deposit(200.00);
        }
    }
}
