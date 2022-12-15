package com.example.pokemonjfx.controller;

import com.example.pokemonjfx.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @FXML
    private Button loginButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(event -> {
            try{
                MainApplication.setRoot("login");
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        });
    }

}
