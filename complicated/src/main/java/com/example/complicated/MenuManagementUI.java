package com.example.complicated;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;

/**
 * This class represents the main user interface for managing menu items in the application.
 *
 * @author Bekzat
 * @done on 22-02-2024
 */
public class MenuManagementUI extends Application {

    private TableView<MenuItem> menuItemTable;
    private ObservableList<MenuItem> menuItems;

    /**
     * The main entry point of the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes and sets up the user interface.
     *
     * @param primaryStage the primary stage for the application
     */
    @Override
    public void start(Stage primaryStage) {
        // Initialize menu item table
        menuItemTable = new TableView<>();
        menuItems = FXCollections.observableArrayList();
        menuItemTable.setItems(menuItems);

        // Define table columns
        TableColumn<MenuItem, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<MenuItem, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

        menuItemTable.getColumns().addAll(nameColumn, priceColumn);

        // Menu management buttons
        Button addButton = new Button();
        addButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/add_icon.png"))));
        Button editButton = new Button();
        editButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/edit_icon.png"))));
        Button deleteButton = new Button();
        deleteButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/delete_icon.png"))));

        // Set preferred size for icons
        int iconSize = 20; // Adjust the size as needed
        ((ImageView) addButton.getGraphic()).setFitWidth(iconSize);
        ((ImageView) addButton.getGraphic()).setFitHeight(iconSize);
        ((ImageView) editButton.getGraphic()).setFitWidth(iconSize);
        ((ImageView) editButton.getGraphic()).setFitHeight(iconSize);
        ((ImageView) deleteButton.getGraphic()).setFitWidth(iconSize);
        ((ImageView) deleteButton.getGraphic()).setFitHeight(iconSize);

        addButton.setOnAction(event -> {
            // Handle add button action
            showAddMenuItemDialog();
        });

        editButton.setOnAction(event -> {
            // Handle edit button action
            MenuItem selectedItem = menuItemTable.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                showEditMenuItemDialog(selectedItem);
            } else {
                showAlert("Error", "No item selected for editing.");
            }
        });

        deleteButton.setOnAction(event -> {
            // Handle delete button action
            MenuItem selectedItem = menuItemTable.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                menuItems.remove(selectedItem);
            } else {
                showAlert("Error", "No item selected for deletion.");
            }
        });

        // Layout
        BorderPane root = new BorderPane();
        VBox buttonBox = new VBox(10);
        buttonBox.setPadding(new Insets(10));
        buttonBox.getChildren().addAll(addButton, editButton, deleteButton);

        root.setCenter(menuItemTable);
        root.setRight(buttonBox);

        // Scene
        Scene scene = new Scene(root, 600, 400);

        // Set up stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Menu Management");
        primaryStage.show();
    }

    /**
     * Displays a dialog for adding a new menu item.
     */
    private void showAddMenuItemDialog() {
        // Create dialog components
        Dialog<MenuItem> dialog = new Dialog<>();
        dialog.setTitle("Add Menu Item");

        // Set the button types (OK and Cancel)
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        // Create dialog content
        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        TextField priceField = new TextField();
        priceField.setPromptText("Price");

        // Add content to dialog layout
        VBox content = new VBox(10);
        content.getChildren().addAll(new Label("Name:"), nameField, new Label("Price:"), priceField);
        dialog.getDialogPane().setContent(content);

        // Convert the result to a MenuItem object when the add button is clicked
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                try {
                    String name = nameField.getText();
                    double price = Double.parseDouble(priceField.getText());
                    return new MenuItem(name, price);
                } catch (NumberFormatException e) {
                    showAlert("Error", "Invalid price format. Please enter a valid number.");
                    return null;
                }
            }
            return null;
        });

        // Show the dialog and handle the result
        dialog.showAndWait().ifPresent(newMenuItem -> {
            if (newMenuItem != null) {
                menuItems.add(newMenuItem);
            }
        });
    }

    /**
     * Displays a dialog for editing an existing menu item.
     *
     * @param menuItem the menu item to edit
     */
    private void showEditMenuItemDialog(MenuItem menuItem) {
        // Create dialog components
        Dialog<MenuItem> dialog = new Dialog<>();
        dialog.setTitle("Edit Menu Item");

        // Set the button types (OK and Cancel)
        ButtonType editButton = new ButtonType("Edit", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(editButton, ButtonType.CANCEL);

        // Create dialog content
        TextField nameField = new TextField(menuItem.getName());
        nameField.setPromptText("Name");
        TextField priceField = new TextField(Double.toString(menuItem.getPrice()));
        priceField.setPromptText("Price");

        // Add content to dialog layout
        VBox content = new VBox(10);
        content.getChildren().addAll(new Label("Name:"), nameField, new Label("Price:"), priceField);
        dialog.getDialogPane().setContent(content);

        // Convert the result to a MenuItem object when the edit button is clicked
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == editButton) {
                try {
                    String name = nameField.getText();
                    double price = Double.parseDouble(priceField.getText());
                    menuItem.setName(name);
                    menuItem.setPrice(price);
                    return menuItem;
                } catch (NumberFormatException e) {
                    showAlert("Error", "Invalid price format. Please enter a valid number.");
                    return null;
                }
            }
            return null;
        });

        // Show the dialog and handle the result
        dialog.showAndWait().ifPresent(updatedMenuItem -> {
            if (updatedMenuItem != null) {
                menuItemTable.refresh(); // Refresh the table to reflect the changes
            }
        });
    }

    /**
     * Displays an alert dialog with the specified title and message.
     *
     * @param title   the title of the alert
     * @param message the message to display
     */
    private void showAlert(String title, String message) {
        // Implement alert dialog for displaying messages
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

/**
 * Represents a menu item in the system.
 */
class MenuItem implements Serializable {
    private final StringProperty name;
    private final DoubleProperty price;

    /**
     * Constructs a new menu item with the given name and price.
     *
     * @param name  the name of the menu item
     * @param price the price of the menu item
     */
    public MenuItem(String name, double price) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
    }

    // Getter and setter methods for properties

    /**
     * Gets the name property of the menu item.
     *
     * @return the name property
     */
    public StringProperty nameProperty() {
        return name;
    }

    /**
     * Gets the price property of the menu item.
     *
     * @return the price property
     */
    public DoubleProperty priceProperty() {
        return price;
    }

    /**
     * Gets the name of the menu item.
     *
     * @return the name of the menu item
     */
    public String getName() {
        return name.get();
    }

    /**
     * Sets the name of the menu item.
     *
     * @param name the new name of the menu item
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * Gets the price of the menu item.
     *
     * @return the price of the menu item
     */
    public double getPrice() {
        return price.get();
    }

    /**
     * Sets the price of the menu item.
     *
     * @param price the new price of the menu item
     */
    public void setPrice(double price) {
        this.price.set(price);
    }
}
