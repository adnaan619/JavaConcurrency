package MonitorCoffeeShop;

public class CoffeeShopSimulation {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();

        Thread baristaThread = new Thread(new Barista(coffeeShop), "Barista");
        baristaThread.start();

        Thread customer1 = new Thread(new Customer(coffeeShop, "Alice"));
        Thread customer2 = new Thread(new Customer(coffeeShop, "Nasthya"));
        Thread customer3 = new Thread(new Customer(coffeeShop, "Bob"));

        customer1.start();
        customer2.start();
        customer3.start();

        try{
            customer1.join();
            customer2.join();
            customer3.join();
            baristaThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
