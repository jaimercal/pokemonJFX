package com.example.pokemonjfx.daoImp;

import com.example.pokemonjfx.dao.GenericDao;
import com.example.pokemonjfx.exceptions.UserException;
import com.example.pokemonjfx.exceptions.UserNotFoundException;
import com.example.pokemonjfx.model.User;
import com.example.pokemonjfx.services.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImp implements GenericDao<User> {
    private Connection connection;
    public static UserDaoImp instance = null;

    private UserDaoImp() throws SQLException, ClassNotFoundException {
        this.connection = DBConnection.getConnection();
    }

    public static UserDaoImp getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null){
            instance = new UserDaoImp();
        }
        return instance;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(User user) throws SQLException, UserException {
        boolean result;
        String query = "update shinyDex.users set banned=? where id_user=?;";
        PreparedStatement stmt = this.connection.prepareStatement(query);
        stmt.setBoolean(1, user.isBanned());
        stmt.setInt(2, user.getIdUser());
        int rs = stmt.executeUpdate();
        if(rs>0){
            result = true;
        }else {
            result = false;
            throw new UserException("Invalid credentials");
        }
        return result;
    }

    @Override
    public User add(User user) throws SQLException, UserException, UserNotFoundException {
        User result;
        String query = "select id_user from shinyDex.users where email=? or nickname=?";
        PreparedStatement stmt = this.connection.prepareStatement(query);
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getNickname());
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()){
            query = "insert into shinyDex.users (email, nickname, password, admin, banned) values (?,?,?,0,0);";
            PreparedStatement stmt2 = this.connection.prepareStatement(query);
            stmt2.setString(1, user.getEmail());
            stmt2.setString(2, user.getNickname());
            stmt2.setString(3, user.getPassword());
            int rs2 = stmt2.executeUpdate();
            if (rs2>0){
                query = "select id_user from shinyDex.users where email=?";
                stmt = this.connection.prepareStatement(query);
                stmt.setString(1, user.getEmail());
                rs = stmt.executeQuery();
                if (rs.next()){
                    result = this.get(rs.getInt("id_user"));
                }else {
                    result = null;
                    throw new UserException("Invalid credentials");
                }
            }else {
                result = null;
                throw new UserException("Invalid credentials");
            }
        }else {
            result = null;
            throw new UserException("Invalid credentials");
        }
        return result;
    }

    @Override
    public ArrayList getAll() throws SQLException {
        ArrayList<User> result = new ArrayList<User>();
        String query = "select id_user, email, nickname, admin from shinyDex.users;";
        PreparedStatement stmt = this.connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            result.add(new User(rs.getInt("id_user"), rs.getString("nickname"),
                    rs.getString("email"), rs.getBoolean("admin")));
        }
        return result;
    }

    @Override
    public ArrayList search(int idx, int pag, String term) throws SQLException {
        return null;
    }

    @Override
    public User get(int id) throws SQLException, UserNotFoundException {
        User result=null;
        String query = "select id_user, email, nickname, admin from shinyDex.users where id_user=?";
        PreparedStatement stmt2 = this.connection.prepareStatement(query);
        stmt2.setInt(1, id);
        ResultSet rs2 = stmt2.executeQuery();
        if (rs2.next()){
            result = new User(rs2.getInt("id_user"), rs2.getString("nickname"),
                    rs2.getString("email"), rs2.getBoolean("admin"));
        }else{
            result = null;
            throw new UserNotFoundException("Invalid credentials");
        }
        return result;
    }

    @Override
    public int count(String term) throws SQLException {
        return 0;
    }

    public User adminLogIn(User userNotLogged) throws SQLException, UserException, UserNotFoundException, ClassNotFoundException {
        User result;
        String query = "select id_user, email, banned, admin from shinyDex.users where email=? and password=?";
        PreparedStatement stmt = this.connection.prepareStatement(query);
        stmt.setString(1, userNotLogged.getEmail());
        stmt.setString(2, userNotLogged.getPassword());
        ResultSet rs = stmt.executeQuery();
        if (rs.next()){
            User userExists = new User(rs.getInt("id_user"), rs.getString("email") ,rs.getBoolean("banned"), rs.getBoolean("admin"));

            if (userExists.isBanned()){
                result = null;
                throw new UserNotFoundException("Banned account");
            }else if(!userExists.isAdmin()){
                result = null;
                throw new UserNotFoundException("Account not admin");
            }else{
                result = userExists.get();
            }
        }else{
            result = null;
            throw new UserNotFoundException("Invalid credentials");
        }
        return result;
    }
}
