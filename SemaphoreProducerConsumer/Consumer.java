package SemaphoreProducerConsumer;

class Consumer implements Runnable {
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.consume();
                Thread.sleep((int) (Math.random() * 150));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

//Implements Runnable to consume items
//Calls the consume method on the SharedBuffer object