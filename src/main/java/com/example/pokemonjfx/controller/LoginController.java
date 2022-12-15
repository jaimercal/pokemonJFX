package com.example.pokemonjfx.controller;

import com.example.pokemonjfx.MainApplication;
import com.example.pokemonjfx.exceptions.UserException;
import com.example.pokemonjfx.exceptions.UserNotFoundException;
import com.example.pokemonjfx.model.User;
import com.example.pokemonjfx.services.HashService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Button login;

    @FXML
    private TextField loginNick;

    @FXML
    private TextField loginPassword;

    @FXML
    void onLogin(ActionEvent event) {
        HashService hashService = new HashService();
        User user = new User(loginNick.getText(), hashService.toHash(loginPassword.getText()));
        try{
            user.logIn();
            MainApplication.setRoot("home");
        }catch (UserException | IOException e){
            throw new RuntimeException(e);
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
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

}
