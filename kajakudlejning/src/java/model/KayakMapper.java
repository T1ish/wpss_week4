/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.Kayak;
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
public class KayakMapper {
    public void createKayak(String name, String model, String description, int year, String color, double length){
        String sqlQuery = "INSERT INTO kayak(name, model, description, year, color, length) VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = DB.getConnection();
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sqlQuery);
            statement.setString(1, name);
            statement.setString(2, model);
            statement.setString(3, description);
            statement.setInt(4, year);
            statement.setString(5, color);
            statement.setDouble(6, length);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Kayak getKayakByName(String name){
        Kayak kayak = null;
        String sqlQuery = "SELECT id, name, model, description, year, color, length FROM kayak WHERE name = ?";
        Connection con = DB.getConnection();
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sqlQuery);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                int id = result.getInt("id");
                String kayakname = result.getString("name");
                String model = result.getString("model");
                String description = result.getString("description");
                int year = result.getInt("year");
                String color = result.getString("color");
                Double length = result.getDouble("length");
                kayak = new Kayak(id, kayakname, model, description, year, color, length);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kayak;
    }
    
        public Kayak getKayakById(int id){
        Kayak kayak = null;
        String sqlQuery = "SELECT id, name, model, description, year, color, length FROM kayak WHERE id = ?";
        Connection con = DB.getConnection();
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sqlQuery);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                int kayakid = result.getInt("id");
                String name = result.getString("name");
                String model = result.getString("model");
                String description = result.getString("description");
                int year = result.getInt("year");
                String color = result.getString("color");
                Double length = result.getDouble("length");
                kayak = new Kayak(kayakid, name, model, description, year, color, length);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kayak;
    }
        
    public List<Kayak> getAllKayaks(){
        List<Kayak> kayaks = new ArrayList();
        String sqlQuery = "SELECT id, name, model, description, year, color, length FROM kayak";
        Connection con = DB.getConnection();
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sqlQuery);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                String model = result.getString("model");
                String description = result.getString("description");
                int year = result.getInt("year");
                String color = result.getString("color");
                Double length = result.getDouble("length");
                Kayak kayak = new Kayak(id, name, model, description, year, color, length);
                kayaks.add(kayak);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kayaks;
    }
    
//    public static void main(String[] args){
//        KayakMapper km = new KayakMapper();
        
//        km.createKayak("Eagle", "birdie", "Flyvende royalitet", 2016, "yellow", 5.11);
//        List<Kayak> kayaks = km.getAllKayaks();
//        
//        for(Kayak kayak : kayaks){
//            System.out.println(kayak.getId() + " " + kayak.getName() + " " + kayak.getDescription() 
//                    + " " + kayak.getYear()+ " " + kayak.getColor() + " " + kayak.getLength());
//        }
//    }
}
