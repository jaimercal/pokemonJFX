package com.example.pokemonjfx.dao;

import com.example.pokemonjfx.exceptions.PokemonException;
import com.example.pokemonjfx.exceptions.PokemonNotFoundException;
import com.example.pokemonjfx.exceptions.UserException;
import com.example.pokemonjfx.exceptions.UserNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GenericDao<G> {
    public boolean update(G obj) throws SQLException;
    public boolean delete(G obj) throws SQLException, UserException, PokemonException;
    public G add(G obj) throws SQLException, UserException, PokemonException, UserNotFoundException, PokemonNotFoundException;
    public ArrayList<G> getAll() throws SQLException;
    public ArrayList<G> search(int idx, int pag, String term) throws SQLException;
    public G get(int id) throws SQLException, UserNotFoundException, PokemonNotFoundException;
    public int count(String term) throws SQLException;
}
