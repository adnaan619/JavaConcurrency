package ProducerConsumer;

class Consumer implements Runnable{
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        for (int i = 0; i < 10; i++){
            int value = buffer.get();
            System.out.println("Consumed: " + value);
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}