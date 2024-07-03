package ProducerConsumer;

class SharedBuffer {
    private int contents;
    private boolean available = false;

    // Synchronized method for consumer to get data
    public synchronized int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        available = false;
        notifyAll();
        return contents;
    }

    // Synchronized method for producer to put data
    public synchronized void put(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        contents = value;
        available = true;
        notifyAll();
    }
}