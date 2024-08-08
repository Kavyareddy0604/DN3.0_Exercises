module com.example.librarymanagent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.librarymanagent to javafx.fxml;
    exports com.example.librarymanagent;
}