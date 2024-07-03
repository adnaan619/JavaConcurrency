package ProducerConsumer;

class Producer implements Runnable{
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        for (int i = 0; i < 10; i++){
            buffer.put(i);
            System.out.println("Produced: " + i);
            try{
                Thread.sleep(500);
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}