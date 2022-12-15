package com.example.pokemonjfx.controller;

import com.example.pokemonjfx.MainApplication;
import com.example.pokemonjfx.model.Pokemon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PokemonController implements Initializable {

    @FXML
    private TableView<Pokemon> pokemonList;

    @FXML
    private Button pokemonRegisterButton;

    private ArrayList<Pokemon> pokemon;

    @FXML
    void toHome(MouseEvent event) {
        try{
            MainApplication.setRoot("start");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private void createTable() {
        pokemonList.setEditable(true);
        pokemonList.getColumns().removeAll();
        TableColumn<Pokemon, String> colNumber = new TableColumn<>("Number");
        TableColumn<Pokemon, String> colName = new TableColumn<>("Name");
        TableColumn<Pokemon, Boolean> colPrimaryType = new TableColumn<>("PrimaryType");
        TableColumn<Pokemon, Boolean> colSecondaryType = new TableColumn<>("SecondaryType");
        colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrimaryType.setCellValueFactory(new PropertyValueFactory<>("primaryType"));
        colSecondaryType.setCellValueFactory(new PropertyValueFactory<>("secondaryType"));
        pokemonList.getColumns().addAll(colNumber, colName, colPrimaryType, colSecondaryType);

    }

    private ArrayList<Pokemon> loadPokemon() {
        Pokemon auxPokemon = new Pokemon();
        ArrayList<Pokemon> pokemons;
        try {
            pokemons = auxPokemon.getAll();
        }catch (Exception e) {
            pokemons = new ArrayList<Pokemon>();
            throw new RuntimeException(e);
        }
        return pokemons;
    }

    private void fillTable(ArrayList<Pokemon> pokemon){
        ObservableList<Pokemon> observablePokemonList = FXCollections.observableArrayList(pokemon);
        this.pokemonList.setItems(observablePokemonList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pokemonRegisterButton.setOnAction(actionEvent -> {
            try{
                MainApplication.setRoot("pokemonRegister");
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        });
        this.pokemon = loadPokemon();
        createTable();
        fillTable(this.pokemon);
    }

}
