module com.example.complicated {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.complicated to javafx.fxml;
    exports com.example.complicated;
}