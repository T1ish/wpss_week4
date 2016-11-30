/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Kayak;
import control.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BookingMapper;
import model.KayakMapper;

/**
 *
 * @author Z
 */
@WebServlet(name = "BookKayaks", urlPatterns = {"/BookKayaks"})
public class BookKayaks extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        KayakMapper km = new KayakMapper();
        BookingMapper bm = new BookingMapper(); 
        
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        
        Date date = java.sql.Date.valueOf(request.getParameter("date"));
        
        int kayakId = Integer.parseInt(request.getParameter("kayakId"));
        Kayak kayak = km.getKayakById(kayakId);
        
        if(bm.isBooked(date, kayak)){
           response.getWriter().println("Kajakken er allerede booket og kan ikke bruges denne dato. Prøv en anden kajak eller en anden dag.");
        }else {
            bm.createBooking(date, kayak, user);
            response.getWriter().println(kayak.getName() + " er nu booked til dig den " + date);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("THERE!");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ALLOVERTHEPLACE!");
        processRequest(request, response);
    }

}
