module com.example.pokemonjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.pokemonjfx to javafx.fxml;
    exports com.example.pokemonjfx;
    exports com.example.pokemonjfx.controller;
    opens com.example.pokemonjfx.controller to javafx.fxml;
    exports com.example.pokemonjfx.model;
    exports com.example.pokemonjfx.exceptions;
    exports com.example.pokemonjfx.services;
}