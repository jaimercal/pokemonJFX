package com.example.pokemonjfx.services;

import java.sql.*;

public class DBConnection {

    private static Connection connection = null;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/shinyDex";
    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, "root", "12345");
        }
        return connection;
    }
}
