package MonitorCoffeeShop;

public class Barista implements Runnable{
    private final CoffeeShop coffeeShop;

    public Barista(CoffeeShop coffeeShop){
        this.coffeeShop = coffeeShop;
    }

    @Override
    public void run(){
        for (int i=0; i<9; i++){
            coffeeShop.serveOrder();
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
