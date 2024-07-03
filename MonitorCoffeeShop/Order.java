package MonitorCoffeeShop;

public class Order {
    private String customerName;
    private String coffeeType;

    public Order(String customerName, String coffeeType){
        this.customerName = customerName;
        this.coffeeType = coffeeType;
    }

    public String getCustomerName(){
        return customerName;
    } 

    public String getCoffeeType(){
        return coffeeType;
    }
}
