package com.example.pokemonjfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PokemonRegisterController {

    @FXML
    private TextField pokemonId;

    @FXML
    private TextField pokemonName;

    @FXML
    private ChoiceBox<?> pokemonPrimaryType;

    @FXML
    private ChoiceBox<?> pokemonSecondaryType;

    @FXML
    private Button registerPokemon;

    @FXML
    void onRegisterPokemon(ActionEvent event) {

    }

    @FXML
    void toHome(MouseEvent event) {

    }

}
