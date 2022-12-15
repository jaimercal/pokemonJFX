package com.example.pokemonjfx.controller;

import com.example.pokemonjfx.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Button pokemonButton;

    @FXML
    private Button userButton;

    @FXML
    private Button logoutButton;

    @FXML
    void toHome(MouseEvent event) {
        try{
            MainApplication.setRoot("home");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pokemonButton.setOnAction(actionEvent -> {
            try{
                MainApplication.setRoot("pokemon");
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        });
        userButton.setOnAction(actionEvent -> {
            try{
                MainApplication.setRoot("users");
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        });
        logoutButton.setOnAction(actionEvent -> {
            try{
                MainApplication.setRoot("start");
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        });
    }
}
