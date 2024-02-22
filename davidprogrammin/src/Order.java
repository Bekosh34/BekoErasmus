import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private int tableNumber;
    private List<MenuItem> orderItems;
    private double totalPrice;

    public Order(int orderId, int tableNumber) {
        this.orderId = orderId;
        this.tableNumber = tableNumber;
        this.orderItems = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    // Method to add an item to the order
    public void addItem(MenuItem item) {
        orderItems.add(item);
        totalPrice += item.getPrice();
    }

    // Method to remove an item from the order
    public void removeItem(MenuItem item) {
        orderItems.remove(item);
        totalPrice -= item.getPrice();
    }

    // Getters and setters for orderId, tableNumber, totalPrice
    // Add getters and setters here
}

