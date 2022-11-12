module com.example.bakeryass2gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bakeryass2gui to javafx.fxml;
    exports com.example.bakeryass2gui;
}