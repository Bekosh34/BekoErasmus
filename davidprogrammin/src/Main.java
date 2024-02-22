public class Main {
    public static void main(String[] args) {
        // Test Order Management functionality
        testOrderManagement();

        // Test Table Management functionality
        testTableManagement();

        // Test Customer Management functionality
        testCustomerManagement();

        // Test Inventory Management functionality
        testInventoryManagement();
    }

    private static void testOrderManagement() {
        // Create OrderManager object
        OrderManager orderManager = new OrderManager();

        // Create a new order for table 1
        orderManager.createOrder(1);

        // Create some sample menu items
        MenuItem menuItem1 = new MenuItem("Burger", "Delicious burger", 9.99, "Main Course");
        MenuItem menuItem2 = new MenuItem("Pizza", "Cheesy pizza", 12.99, "Main Course");

        // Add items to the order
        orderManager.addItemToOrder(1, menuItem1);
        orderManager.addItemToOrder(1, menuItem2);
    }

    private static void testTableManagement() {
        // Create TableManager object
        TableManager tableManager = new TableManager();

        // Add some sample tables
        Table table1 = new Table(1, 4); // Table number 1 with capacity 4
        Table table2 = new Table(2, 6); // Table number 2 with capacity 6
        Table table3 = new Table(3, 2); // Table number 3 with capacity 2
        tableManager.addTable(table1);
        tableManager.addTable(table2);
        tableManager.addTable(table3);

        // Assign table to customers
        tableManager.assignTable(1); // Assign table 1 to customers

        // Vacate table
        tableManager.vacateTable(2); // Mark table 2 as vacant
    }

    private static void testCustomerManagement() {
        // Create CustomerManager object
        CustomerManager customerManager = new CustomerManager();

        // Add some sample customers
        customerManager.addCustomer("Bekzat Kumar", "+351 777 777 777");
        customerManager.addCustomer("Davide Rua Carneiro", "+351 707 777 777");

        // Retrieve customer information
        Customer customer = customerManager.getCustomer(1);
        if (customer != null) {
            System.out.println("Customer Information:");
            System.out.println("ID: " + customer.getCustomerId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Phone Number: " + customer.getPhoneNumber());
        }
    }

    private static void testInventoryManagement() {
        // Create InventoryManager object
        InventoryManager inventoryManager = new InventoryManager();

        // Add some sample inventory items
        inventoryManager.addInventoryItem("Tomatoes", 20);
        inventoryManager.addInventoryItem("Cheese", 10);

        // Retrieve inventory item information
        InventoryItem item = inventoryManager.getInventoryItem(1);
        if (item != null) {
            System.out.println("Inventory Item Information:");
            System.out.println("ID: " + item.getItemId());
            System.out.println("Name: " + item.getName());
            System.out.println("Quantity: " + item.getQuantity());
        }
    }
}
