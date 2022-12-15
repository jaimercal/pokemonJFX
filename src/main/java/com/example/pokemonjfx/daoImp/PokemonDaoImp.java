package com.example.pokemonjfx.daoImp;

import com.example.pokemonjfx.dao.GenericDao;
import com.example.pokemonjfx.exceptions.PokemonException;
import com.example.pokemonjfx.exceptions.PokemonNotFoundException;
import com.example.pokemonjfx.exceptions.UserException;
import com.example.pokemonjfx.exceptions.UserNotFoundException;
import com.example.pokemonjfx.model.Pokemon;
import com.example.pokemonjfx.model.User;
import com.example.pokemonjfx.services.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PokemonDaoImp implements GenericDao<Pokemon> {
    private Connection connection;
    public static PokemonDaoImp instance = null;

    private PokemonDaoImp() throws SQLException, ClassNotFoundException {
        this.connection = DBConnection.getConnection();
    }

    public static PokemonDaoImp getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null){
            instance = new PokemonDaoImp();
        }
        return instance;
    }

    @Override
    public boolean update(Pokemon pokemon) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Pokemon pokemon) throws SQLException, PokemonException {
        boolean result;
        String query = "delete from shinyDex.pokemon where number=?;";
        PreparedStatement stmt = this.connection.prepareStatement(query);
        stmt.setInt(1, pokemon.getNumber());
        int rs = stmt.executeUpdate();
        if(rs>0){
            result = true;
        }else {
            result = false;
            throw new PokemonException("An error was found");
        }
        return result;
    }

    @Override
    public Pokemon add(Pokemon pokemon) throws SQLException, PokemonException, PokemonNotFoundException {
        Pokemon result;
        String query = "select number from shinyDex.pokemon where name=?";
        PreparedStatement stmt = this.connection.prepareStatement(query);
        stmt.setString(1, pokemon.getName());
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()){
            query = "insert into shinyDex.pokemon (number, name, primary_type, secondary_type) values (?,?,?,?);";
            PreparedStatement stmt2 = this.connection.prepareStatement(query);
            stmt2.setInt(1, pokemon.getNumber());
            stmt2.setString(2, pokemon.getName());
            stmt2.setString(3, pokemon.getPrimaryType());
            stmt2.setString(4, pokemon.getSecondaryType());
            int rs2 = stmt2.executeUpdate();
            if (rs2>0){
                query = "select number from shinyDex.pokemon where name=?";
                stmt = this.connection.prepareStatement(query);
                stmt.setString(1, pokemon.getName());
                rs = stmt.executeQuery();
                if (rs.next()){
                    result = this.get(rs.getInt("id_user"));
                }else {
                    result = null;
                    throw new PokemonException("An error was found");
                }
            }else {
                result = null;
                throw new PokemonException("An error was found");
            }
        }else {
            result = null;
            throw new PokemonException("An error was found");
        }
        return result;
    }

    @Override
    public ArrayList getAll() throws SQLException {
        ArrayList<Pokemon> result = new ArrayList<Pokemon>();
        String query = "select number, name, primary_type, secondary_type, normal_photo, shiny_photo from shinyDex.pokemon;";
        PreparedStatement stmt = this.connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            result.add(new Pokemon(rs.getInt("number"), rs.getString("name"),
                    rs.getString("primary_type"), rs.getString("secondary_type"),
                    rs.getString("normal_photo"), rs.getString("shiny_photo")));
        }
        return result;
    }

    @Override
    public ArrayList search(int idx, int pag, String term) throws SQLException {
        return null;
    }

    @Override
    public Pokemon get(int id) throws SQLException, PokemonNotFoundException {
        Pokemon result=null;
        String query = "select number, name, primary_type, secondary_type, normal_photo, shiny_photo from shinyDex.pokemon where number=?";
        PreparedStatement stmt2 = this.connection.prepareStatement(query);
        stmt2.setInt(1, id);
        ResultSet rs2 = stmt2.executeQuery();
        if (rs2.next()){
            result = new Pokemon(rs2.getInt("number"), rs2.getString("name"),
                    rs2.getString("primary_type"), rs2.getString("secondary_type"),
                    rs2.getString("normal_photo"), rs2.getString("shiny_photo"));
        }else{
            result = null;
            throw new PokemonNotFoundException("Invalid credentials");
        }
        return result;
    }

    @Override
    public int count(String term) throws SQLException {
        return 0;
    }
}
