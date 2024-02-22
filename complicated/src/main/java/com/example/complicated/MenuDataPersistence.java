package com.example.complicated;
import javafx.scene.control.MenuItem;

import java.io.*;
import java.util.List;

public class MenuDataPersistence {
    private static final String FILENAME = "menu_data.ser";

    public static void saveMenuItems(List<MenuItem> menuItems) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            outputStream.writeObject(menuItems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<MenuItem> loadMenuItems() {
        List<MenuItem> menuItems = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            menuItems = (List<MenuItem>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return menuItems;
    }
}
