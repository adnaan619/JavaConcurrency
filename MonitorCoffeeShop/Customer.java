package MonitorCoffeeShop;

public class Customer implements Runnable {
    private final CoffeeShop coffeeShop;
    private final String customerName;

    public Customer(CoffeeShop coffeeShop, String customerName){
        this.coffeeShop = coffeeShop;
        this.customerName = customerName;
    }

    @Override
    public void run(){
        for (int i=0; i<3; i++){
            String coffeeType = "Coffee #" + i;
            coffeeShop.placeOrder(new Order(customerName, coffeeType));
            try{
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
