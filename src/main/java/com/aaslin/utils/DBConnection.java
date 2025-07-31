package com.aaslin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	 private static final String url="jdbc:mysql://localhost:3306/Studentdb";
     private static String username="root";
     private static String password="shyam@1773";
     static {
     try {
     	Class.forName("com.mysql.cj.jdbc.Driver");
     }catch(ClassNotFoundException e) {
         throw new RuntimeException(e);
     }
     }
     public static Connection getConnection() throws SQLException {
    	 return DriverManager.getConnection(url, username, password);
    	 
     }
}


