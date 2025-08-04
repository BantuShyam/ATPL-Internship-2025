package com.aaslin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://192.168.71.15:3306/intern";
    private static final String USERNAME = "intern2025";
    private static final String PASSWORD = "intern2025";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver NOT Found!");
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
