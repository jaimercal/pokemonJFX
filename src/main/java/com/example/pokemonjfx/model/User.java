package com.example.pokemonjfx.model;

import com.example.pokemonjfx.MainApplication;
import com.example.pokemonjfx.daoImp.UserDaoImp;
import com.example.pokemonjfx.exceptions.UserException;
import com.example.pokemonjfx.exceptions.UserNotFoundException;
import javafx.scene.control.Button;

import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private int idUser;
    private String nickname;
    private String email;
    private String password;
    private boolean admin;
    private boolean banned;
    private Button deleteButton;

    public User(int idUser, String nickname, String email, String password, boolean admin, boolean banned) {
        this.idUser = idUser;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.banned = banned;
    }

    public User(int idUser, String nickname, String email, boolean admin) {
        this.idUser = idUser;
        this.nickname = nickname;
        this.email = email;
        this.admin = admin;
        this.deleteButton = new Button("delete");
        this.deleteButton.setOnAction(actionEvent -> {
            this.banned = !this.banned;
            try {
                this.delete();
                MainApplication.setRoot("users");
            }catch (Exception ignored) {

            }
        });
    }

    public User(int idUser, String email, boolean banned) {
        this.idUser = idUser;
        this.email = email;
        this.banned = banned;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public User logIn() throws SQLException, ClassNotFoundException, UserException, UserNotFoundException {
        return UserDaoImp.getInstance().logIn(this);
    }

    public User register() throws SQLException, ClassNotFoundException, UserException, UserNotFoundException {
        return UserDaoImp.getInstance().add(this);
    }

    public boolean delete() throws SQLException, ClassNotFoundException, UserException {
        return UserDaoImp.getInstance().delete(this);
    }

    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return UserDaoImp.getInstance().getAll();
    }

    public User get() throws SQLException, ClassNotFoundException, UserNotFoundException {
        return UserDaoImp.getInstance().get(this.idUser);
    }
}
