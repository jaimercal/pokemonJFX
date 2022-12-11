package com.example.pokemonjfx.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GenericDao<G> {
    public boolean update(G obj) throws SQLException;
    public boolean delete(G obj) throws SQLException;
    public G add(G obj) throws SQLException;
    public ArrayList<G> getAll() throws SQLException;
    public ArrayList<G> search(int idx, int pag, String term) throws SQLException;
    public G get(int id) throws SQLException;
    public int count(String term) throws SQLException;
}