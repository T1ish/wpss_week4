/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.Booking;
import control.Kayak;
import control.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Z
 */
public class BookingMapper {
     //public Booking(int id, int userid, int kayakid, Date date)
    public void createBooking(Date booking, Kayak kayak, User user){
        String sqlQuery = "INSERT INTO booking(date, kayakid, userid) VALUES(?, ?, ?)";
        Connection con = DB.getConnection();
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sqlQuery);
            statement.setDate(1, booking);
            statement.setInt(2, kayak.getId());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("We got problems");
            ex.printStackTrace();
        }
    }
    
    public boolean isBooked(Date date, Kayak kayak){
        String sqlQuery = "SELECT date, kayakid FROM booking WHERE date = ? AND kayakid = ?";
        Connection con = DB.getConnection();
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sqlQuery);
            statement.setDate(1, date);
            statement.setInt(2, kayak.getId());
            ResultSet result = statement.executeQuery();
            if (result.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Dude what happened");
            ex.printStackTrace();
        }
        return false;
    }
    
    public List<Kayak> getAvailableKayaks(Date date){
        KayakMapper km = new KayakMapper();
        BookingMapper mb = new BookingMapper();
        
        List<Kayak> allKayaks = km.getAllKayaks();
        List<Booking> bookedKayaks = new ArrayList();
        List<Kayak> availableKayaks = new ArrayList();
        List<Kayak> busyKayaks = new ArrayList();
        
        String sqlQuery = "SELECT date, kayakid, userid FROM booking";
        
        Connection con = DB.getConnection();
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sqlQuery);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Date bookingdate = result.getDate("date");
                int kayakid = result.getInt("kayakid");
                int userid = result.getInt("userid");
                Booking booking = new Booking(bookingdate, kayakid, userid);
                bookedKayaks.add(booking);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        for (Kayak localKayak : allKayaks){
            for (Booking bookKayak: bookedKayaks){
                if(localKayak.getId() == bookKayak.getKayakid()){
                    busyKayaks.add(localKayak);
                }
            }
        }   
        allKayaks.removeAll(busyKayaks);
        
        return allKayaks;
    }
    
//    public static void main(String[] args){
//        BookingMapper bm = new BookingMapper();
//        UserMapper mp = new UserMapper();
//        KayakMapper km = new KayakMapper();
//        
//        User user = mp.getUser(2);
//        Kayak kayak = km.getKayakById(2);
//        java.sql.Date jsqlD = java.sql.Date.valueOf("2010-01-31");
//      //  bm.createBooking(jsqlD, kayak, user);
//        user = mp.getUser(1);
//        kayak = km.getKayakById(1);
//        jsqlD = java.sql.Date.valueOf("2010-01-31");
//       // bm.createBooking(jsqlD, kayak, user);
//        user = mp.getUser(3);
//        kayak = km.getKayakById(3);
//        jsqlD = java.sql.Date.valueOf("2010-01-31");
//        bm.createBooking(jsqlD, kayak, user);
//        //System.out.println(bm.isBooked(jsqlD, kayak));
//        
//        List<Kayak> aviKayaks = bm.getAvailableKayaks(jsqlD);
//        
//        for (Kayak tskayak : aviKayaks){
//            System.out.println(tskayak.getName());
//        }
//    }
}
