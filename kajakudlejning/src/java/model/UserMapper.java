/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Z
 */
public class UserMapper {
    public void createUser(String username, String password){
        User user = null;
        // INSERT INTO user(username, password) VALUES ('testuser1', 'password123')
        String sqlQuery = "INSERT INTO user(username, password) VALUES (? , ?)";
        Connection con = DB.getConnection();
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sqlQuery);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public User getUser(String username, String password){
        User user = null;
        String sqlQuery = "SELECT id, username FROM user WHERE username = ? and password = ?";
        Connection con = DB.getConnection();
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sqlQuery);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()){
                int userid = result.getInt("id");
                String dbusername = result.getString("username");
                user = new User(userid, dbusername);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }       
        return user;
    }
    
    public List<User> getAllUsers(){
        List<User> users = new ArrayList();
        String sqlQuery = "Select id, username FROM user";
        Connection con = DB.getConnection();
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sqlQuery);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                int id = result.getInt("id");
                String username = result.getString("username");
                User user = new User(id, username);
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }
    
    public boolean authenticateUser(String username, String password){
        String sqlQuery = "SELECT username, password FROM user WHERE username = ?";
        Connection con = DB.getConnection();
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sqlQuery);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if (result.next()){
                String DBPassword = result.getString("password");
                if (DBPassword.equals(password)){
                    return true;
                }else {
                    return false;
                }
            }       
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
//    public static void main(String[] args){
//        UserMapper um = new UserMapper();
//       
//        System.out.println(um.authenticateUser("Hans", "No pass"));
//        
//    }

}
