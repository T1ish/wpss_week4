/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Date;

/**
 *
 * @author Z
 */
public class Booking {
    private int userid;
    private int kayakid;
    private Date date; // Probably not using the right date format

    public Booking() {
    }

    public Booking(Date date, int kayakid) {
        this.kayakid = kayakid;
        this.date = date;
    }
    
    public Booking(Date date, int kayakid, int userid) {
        this.userid = userid;
        this.kayakid = kayakid;
        this.date = date;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getKayakid() {
        return kayakid;
    }

    public void setKayakid(int kayakid) {
        this.kayakid = kayakid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
