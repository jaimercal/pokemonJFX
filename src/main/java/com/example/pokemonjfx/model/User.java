package com.example.pokemonjfx.model;

public class User {
    private int idUser;
    private String nickname;
    private String email;
    private String password;
    private boolean admin;
    private boolean banned;

    public User(int idUser, String nickname, String email, String password, boolean admin, boolean banned) {
        this.idUser = idUser;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.banned = banned;
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
}
