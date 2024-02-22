import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<Integer, InventoryItem> inventoryItems;
    private int nextItemId;

    public InventoryManager() {
        this.inventoryItems = new HashMap<>();
        this.nextItemId = 1;
    }

    // Method to add a new inventory item
    public void addInventoryItem(String name, int quantity) {
        InventoryItem newItem = new InventoryItem(nextItemId, name, quantity);
        inventoryItems.put(nextItemId, newItem);
        nextItemId++;
        System.out.println("Inventory item added: " + newItem.getName());
    }

    // Method to retrieve inventory item information by itemId
    public InventoryItem getInventoryItem(int itemId) {
        return inventoryItems.get(itemId);
    }
}
