package com.example.pokemonjfx.daoImp;

import com.example.pokemonjfx.dao.GenericDao;
import com.example.pokemonjfx.model.Pokemon;

import java.sql.SQLException;
import java.util.ArrayList;

public class PokemonDaoImp implements GenericDao<Pokemon> {
    @Override
    public boolean update(Pokemon pokemon) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Pokemon pokemon) throws SQLException {
        return false;
    }

    @Override
    public Pokemon add(Pokemon pokemon) throws SQLException {
        return null;
    }

    @Override
    public ArrayList getAll() throws SQLException {
        return null;
    }

    @Override
    public ArrayList search(int idx, int pag, String term) throws SQLException {
        return null;
    }

    @Override
    public Pokemon get(int id) throws SQLException {
        return null;
    }

    @Override
    public int count(String term) throws SQLException {
        return 0;
    }
}
