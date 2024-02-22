public class MenuItem {
    private String name;
    private String description;
    private double price;
    private String category;

    public MenuItem(String name, String description, double price, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
        // Add getters and setters for description, price, and category here
    }
}
