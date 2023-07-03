module com.example.lab_13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_13 to javafx.fxml;
    exports com.example.lab_13;
}