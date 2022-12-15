package com.example.pokemonjfx.model;

import com.example.pokemonjfx.daoImp.PokemonDaoImp;
import com.example.pokemonjfx.exceptions.PokemonException;
import com.example.pokemonjfx.exceptions.PokemonNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;

public class Pokemon {
    private int number;
    private String name;
    private String primaryType;
    private String secondaryType;
    private String normalImage;
    private String shinyImage;

    public Pokemon(int idPokemon, String name, String primaryType, String secondaryType, String normalImage, String shinyImage) {
        this.number = idPokemon;
        this.name = name;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.normalImage = normalImage;
        this.shinyImage = shinyImage;
    }

    public Pokemon(int number, String name, String primaryType, String secondaryType) {
        this.number = number;
        this.name = name;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
    }

    public Pokemon() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
    }

    public String getSecondaryType() {
        return secondaryType;
    }

    public void setSecondaryType(String secondaryType) {
        this.secondaryType = secondaryType;
    }

    public String getNormalImage() {
        return normalImage;
    }

    public void setNormalImage(String normalImage) {
        this.normalImage = normalImage;
    }

    public String getShinyImage() {
        return shinyImage;
    }

    public void setShinyImage(String shinyImage) {
        this.shinyImage = shinyImage;
    }

    public Pokemon add() throws SQLException, ClassNotFoundException, PokemonException, PokemonNotFoundException {
        return PokemonDaoImp.getInstance().add(this);
    }

    public boolean delete() throws SQLException, ClassNotFoundException, PokemonException {
        return PokemonDaoImp.getInstance().delete(this);
    }

    public ArrayList<Pokemon> getAll() throws SQLException, ClassNotFoundException {
        return PokemonDaoImp.getInstance().getAll();
    }
    public Pokemon get() throws SQLException, ClassNotFoundException, PokemonNotFoundException {
        return PokemonDaoImp.getInstance().get(this.number);
    }
}
