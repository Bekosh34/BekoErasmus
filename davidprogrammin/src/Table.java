public class Table {
    private int tableNumber;
    private int capacity;
    private boolean isOccupied;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isOccupied = false; // Initially, table is vacant
    }

    // Getter method for tableNumber
    public int getTableNumber() {
        return tableNumber;
    }

    // Method to mark table as occupied
    public void occupyTable() {
        isOccupied = true;
        System.out.println("Table #" + tableNumber + " is now occupied.");
    }

    // Method to mark table as vacant
    public void vacateTable() {
        isOccupied = false;
        System.out.println("Table #" + tableNumber + " is now vacant.");
    }
}
