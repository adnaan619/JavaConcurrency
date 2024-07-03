package SemaphoreProducerConsumer;

class Producer implements Runnable {
    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.produce(i);
                Thread.sleep((int) (Math.random() * 100));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

//calls the produce method on the SharedBuffer object
//Implements Runnable to produce items