package com.example.pokemonjfx.daoImp;

import com.example.pokemonjfx.dao.GenericDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImp implements GenericDao {
    @Override
    public boolean update(Object obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Object obj) throws SQLException {
        return false;
    }

    @Override
    public Object add(Object obj) throws SQLException {
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
    public Object get(int id) throws SQLException {
        return null;
    }

    @Override
    public int count(String term) throws SQLException {
        return 0;
    }
}
