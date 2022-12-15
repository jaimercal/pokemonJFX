package com.example.pokemonjfx.controller;

import com.example.pokemonjfx.MainApplication;
import com.example.pokemonjfx.exceptions.PokemonException;
import com.example.pokemonjfx.exceptions.PokemonNotFoundException;
import com.example.pokemonjfx.model.Pokemon;
import com.example.pokemonjfx.model.Types;
import com.example.pokemonjfx.services.ConvertToTitle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PokemonRegisterController implements Initializable {

    @FXML
    private TextField pokemonId;

    @FXML
    private TextField pokemonName;

    @FXML
    private ChoiceBox<Types> pokemonPrimaryType = new ChoiceBox<>();

    @FXML
    private ChoiceBox<Types> pokemonSecondaryType;

    @FXML
    private Button registerPokemon;

    private Pokemon validatePokemon(){
        try{
            Integer.parseInt(pokemonId.getText());
        }catch (NumberFormatException e){
            throw new RuntimeException(e);
        }
        ConvertToTitle convertToTitle = new ConvertToTitle();
        String secondary;
        if(pokemonSecondaryType.getValue().toString().equals("None")){
            secondary = "";
        }else{
            secondary = pokemonSecondaryType.getValue().toString();
        }
        return new Pokemon(Integer.parseInt(pokemonId.getText()), convertToTitle.convertToTitleCaseIteratingChars(pokemonName.getText()), pokemonPrimaryType.getValue().toString(), secondary);
    }

    private void onRegisterPokemon(ActionEvent event) {
        Pokemon pokemon = validatePokemon();
        try{
            pokemon.add();
            MainApplication.setRoot("pokemon");
        }catch (IOException e){
            throw new RuntimeException(e);
        } catch (PokemonNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (PokemonException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pokemonPrimaryType.getItems().setAll(Types.values());
        pokemonSecondaryType.getItems().setAll(Types.values());

        registerPokemon.setOnAction(this::onRegisterPokemon);
    }
}
