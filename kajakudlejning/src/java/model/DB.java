/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




/**
 *
 * @author Z
 */
public class DB {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/kajakudlejning";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection conn = null;
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
//    
//    public static void main(String[] args) throws SQLException {
//        Statement stmt = getConnection().createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM user");
//        while(rs.next()){
//            int id = rs.getInt("id");
//            String username = rs.getString("username");
//            String password = rs.getString("password");
//            System.out.println("Here is the data: ID = " +id+ " username = " +username+ " password = " +password );
//        }
//        
//    }    
}
