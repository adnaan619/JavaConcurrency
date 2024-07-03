package MonitorCoffeeShop;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {
    private final Queue<Order> orderQueue = new LinkedList<>();
    private final int MAX_ORDERS = 5; // Maximum orders the shop can handle at a time

    public synchronized void placeOrder(Order order) {
        while (orderQueue.size() == MAX_ORDERS) {
            try {
                System.out.println(order.getCustomerName() + " is waiting to place order: " + order.getCoffeeType());
                wait(); // Wait if the queue is full
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        orderQueue.add(order);
        System.out.println(order.getCustomerName() + " placed order: " + order.getCoffeeType());
        notifyAll(); // Notify the barista that a new order is available
    }

    public synchronized Order serveOrder() {
        while (orderQueue.isEmpty()) {
            try {
                System.out.println("Barista is waiting for orders...");
                wait(); // Wait if the queue is empty
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Order order = orderQueue.poll();
        System.out.println("Barista is preparing order: " + order.getCoffeeType() + " for " + order.getCustomerName());
        notifyAll(); // Notify customers that there is space for new orders
        return order;
    }
}
