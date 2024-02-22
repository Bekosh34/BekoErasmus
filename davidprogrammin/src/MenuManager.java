import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private List<MenuItem> menuItems;

    public MenuManager() {
        this.menuItems = new ArrayList<>();
    }

    // Method to add a new menu item
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
        System.out.println("Menu item added successfully: " + item.getName());
    }

    // Method to update an existing menu item
    public void updateMenuItem(String itemName, MenuItem newItem) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getName().equals(itemName)) {
                menuItems.set(i, newItem);
                System.out.println("Menu item updated successfully: " + newItem.getName());
                return;
            }
        }
        System.out.println("Menu item not found: " + itemName);
    }

    // Method to remove a menu item
    public void removeMenuItem(String itemName) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getName().equals(itemName)) {
                menuItems.remove(i);
                System.out.println("Menu item removed successfully: " + itemName);
                return;
            }
        }
        System.out.println("Menu item not found: " + itemName);
    }
}

