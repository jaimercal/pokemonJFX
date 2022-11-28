module com.example.pokemonjfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pokemonjfx to javafx.fxml;
    exports com.example.pokemonjfx;
}