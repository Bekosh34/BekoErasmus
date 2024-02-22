public class InventoryItem {
    private int itemId;
    private String name;
    private int quantity;

    public InventoryItem(int itemId, String name, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
    }

    // Getter methods for itemId, name, and quantity
    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
