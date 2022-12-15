package com.example.pokemonjfx.controller;

import com.example.pokemonjfx.MainApplication;
import com.example.pokemonjfx.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UsersController implements Initializable {

    @FXML
    private TableView<User> usersList;

    private ArrayList<User> users;

    @FXML
    void toHome(MouseEvent event) {
        try{
            MainApplication.setRoot("start");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private void createTable() {
        usersList.setEditable(true);
        usersList.getColumns().removeAll();
        TableColumn<User, String> colNickname = new TableColumn<>("Nickname");
        TableColumn<User, String> colEmail = new TableColumn<>("Email");
        TableColumn<User, Boolean> colAdmin = new TableColumn<>("Admin");
        TableColumn<User, Boolean> colBanned = new TableColumn<>("Banned");
        colNickname.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAdmin.setCellValueFactory(new PropertyValueFactory<>("admin"));
        colBanned.setCellValueFactory(new PropertyValueFactory<>("banned"));
        usersList.getColumns().addAll(colNickname, colEmail, colAdmin, colBanned);

    }

    private ArrayList<User> loadUsers() {
        User auxUser = new User();
        ArrayList<User> users;
        try {
            users = auxUser.getAll();
        }catch (Exception e) {
            users = new ArrayList<User>();
            throw new RuntimeException(e);
        }
        return users;
    }

    private void fillTable(ArrayList<User> users){
        ObservableList<User> observableUsersList = FXCollections.observableArrayList(users);
        this.usersList.setItems(observableUsersList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.users = loadUsers();
        createTable();
        fillTable(this.users);
    }

}
