package BankingApp;

public class App {
    public static void main(String[] args) {
        Account account = new Account("1sw234", 200);
        Husband husband = new Husband("Adrian", account);
        Wife wife = new Wife("Sara", account);

        Thread husbandThread = new Thread(husband, husband.getName());
        Thread wifeThread = new Thread(wife, wife.getName());

        husbandThread.start();
        wifeThread.start();
    }
}
