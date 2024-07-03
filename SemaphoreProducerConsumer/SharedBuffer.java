package SemaphoreProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity;

    private final Semaphore empty;
    private final Semaphore full;
    private final Semaphore mutex;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
        this.empty = new Semaphore(capacity);
        this.full = new Semaphore(0);
        this.mutex = new Semaphore(1);
    }

    public void produce(int item) throws InterruptedException {
        empty.acquire(); // Wait for an empty slot
        mutex.acquire(); // Wait for exclusive access to the buffer

        buffer.add(item); // Add the item to the buffer
        System.out.println("Produced: " + item);

        mutex.release(); // Release the lock
        full.release(); // Indicate that an item has been added
    }

    public int consume() throws InterruptedException {
        full.acquire(); // Wait for a filled slot
        mutex.acquire(); // Wait for exclusive access to the buffer

        int item = buffer.poll(); // Remove the item from the buffer
        System.out.println("Consumed: " + item);

        mutex.release(); // Release the lock
        empty.release(); // Indicate that an empty slot is available

        return item;
    }
}

//The buffer queue represents the buffer
//capacity represents the capacity of the buffer
//empty is the semaphore representing the number of empty slots
//full is the semaphore that represents the number of filled slots 
//mutex is the semaphore for mutual exclusion

//The method produce(int item) - waits for an empty slot and mutual exclusion, adds an item to the buffer, then signals that an item has been added and releases mutual exclusion
//The consume() method - waits for a filled slot and mutual exclusion, removes an item from the buffer, then signals that an empty slot is available and releases mutual exclusion