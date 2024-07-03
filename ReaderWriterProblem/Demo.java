package ReaderWriterProblem;

public class Demo {
    public static void main(String[] args) {
        Account account = new Account(1000);

        Thread writer1 = new Thread(new Writer(account), "Writer-1");
        Thread writer2 = new Thread(new Writer(account), "Writer-2");
        Thread writer3 = new Thread(new Writer(account), "Writer-3");
        Thread reader1 = new Thread(new Reader(account), "Reader-1");
        Thread reader2 = new Thread(new Reader(account), "Reader-2");
        Thread reader3 = new Thread(new Reader(account), "Reader-3");

        writer1.start();
        writer2.start();
        writer3.start();
        reader1.start();
        reader2.start();
        reader3.start();

        try{
            writer1.join();
            writer2.join();
            writer3.join();
            reader1.join();
            reader2.join();
            reader3.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+ "Account final balance: "+ account.getBalance());

    }
}
