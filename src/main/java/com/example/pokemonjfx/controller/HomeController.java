package com.example.pokemonjfx.controller;

import com.example.pokemonjfx.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button pokemonButton;

    @FXML
    private Button userButton;

    @FXML
    void onPokemonClick(ActionEvent event) {
        try{
            MainApplication.setRoot("pokemon");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onUserClick(ActionEvent event) {
        try{
            MainApplication.setRoot("users");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void toHome(MouseEvent event) {
        try{
            MainApplication.setRoot("start");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
