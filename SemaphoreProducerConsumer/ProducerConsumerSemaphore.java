package SemaphoreProducerConsumer;

public class ProducerConsumerSemaphore {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5); // Buffer with capacity of 5

        Thread producer1 = new Thread(new Producer(buffer), "Producer-1");
        Thread consumer1 = new Thread(new Consumer(buffer), "Consumer-1");

        producer1.start();
        consumer1.start();
    }
}

//Creates a SharedBuffer instance with a capacity of 5
//Creates and starts producer and consumer threads

//By using semaphores the Producer consumer problem is solved efficiently
//ensuring that producers do not overflow the buffer and consumers do not underflow it.
//The semaphores empty, full and mutex work together to manage the buffers state,
//providing a safe and synchronized solution to the problem.