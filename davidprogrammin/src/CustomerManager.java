import java.util.HashMap;
import java.util.Map;

public class CustomerManager {
    private Map<Integer, Customer> customers;
    private int nextCustomerId;

    public CustomerManager() {
        this.customers = new HashMap<>();
        this.nextCustomerId = 1;
    }

    // Method to add a new customer
    public void addCustomer(String name, String phoneNumber) {
        Customer newCustomer = new Customer(nextCustomerId, name, phoneNumber);
        customers.put(nextCustomerId, newCustomer);
        nextCustomerId++;
        System.out.println("Customer added: " + newCustomer.getName());
    }

    // Method to retrieve customer information by customerId
    public Customer getCustomer(int customerId) {
        return customers.get(customerId);
    }
}
