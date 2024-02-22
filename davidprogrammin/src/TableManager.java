import java.util.HashMap;
import java.util.Map;

public class TableManager {
    private Map<Integer, Table> tables;

    public TableManager() {
        this.tables = new HashMap<>();
    }

    // Method to add a new table
    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
        System.out.println("Table #" + table.getTableNumber() + " added.");
    }

    // Method to assign a table to customers
    public void assignTable(int tableNumber) {
        Table table = tables.get(tableNumber);
        if (table != null) {
            table.occupyTable();
        } else {
            System.out.println("Table not found: " + tableNumber);
        }
    }

    // Method to mark a table as vacant
    public void vacateTable(int tableNumber) {
        Table table = tables.get(tableNumber);
        if (table != null) {
            table.vacateTable();
        } else {
            System.out.println("Table not found: " + tableNumber);
        }
    }
}
