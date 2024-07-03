package ProducerConsumer;

public class MonitorExample {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
        Thread producer = new Thread(new Producer(buffer), "Producer");
        Thread consumer = new Thread(new Consumer(buffer), "Consumer");

        producer.start();
        consumer.start();
    }
}