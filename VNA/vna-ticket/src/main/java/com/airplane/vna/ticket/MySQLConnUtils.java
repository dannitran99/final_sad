package com.airplane.vna.ticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class MySQLConnUtils {
 
 // Kết nối vào MySQL.
 public static Connection getMySQLConnection() throws SQLException,
         ClassNotFoundException {
     String hostName = "localhost";
 
     String dbName = "vna-ticket";
     String userName = "root";
     String password = "1636";
 
     return getMySQLConnection(hostName, dbName, userName, password);
 }
 
 public static Connection getMySQLConnection(String hostName, String dbName,
         String userName, String password) throws SQLException,
         ClassNotFoundException {
     Class.forName("com.mysql.cj.jdbc.Driver");
 
     String connectionURL = "jdbc:mysql://" + hostName + ":1636/" + dbName;
 
     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }
}
