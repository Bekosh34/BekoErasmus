import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    private Map<Integer, Order> orders;
    private int nextOrderId;

    public OrderManager() {
        this.orders = new HashMap<>();
        this.nextOrderId = 1;
    }

    // Method to create a new order
    public void createOrder(int tableNumber) {
        Order newOrder = new Order(nextOrderId, tableNumber);
        orders.put(nextOrderId, newOrder);
        nextOrderId++;
        System.out.println("New order created for table " + tableNumber);
    }

    // Method to add an item to an existing order
    public void addItemToOrder(int orderId, MenuItem item) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.addItem(item);
            System.out.println("Item added to order #" + orderId);
        } else {
            System.out.println("Order not found: " + orderId);
        }
    }

    // Method to remove an item from an existing order
    public void removeItemFromOrder(int orderId, MenuItem item) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.removeItem(item);
            System.out.println("Item removed from order #" + orderId);
        } else {
            System.out.println("Order not found: " + orderId);
        }
    }
}

