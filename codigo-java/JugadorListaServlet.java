/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 *
 * @author 6001016
 */
public class JugadorListaServlet extends HttpServlet {


//@WebServlet(urlPatterns = { "/productList" })
    private static final long serialVersionUID = 1L;
 
    public JugadorListaServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String errorString = null;
        List<Jugador> list = null;
        List<Equipo> liste = null;
        try {
            liste =DBUtils.queryEquipo(conn);
            list = DBUtils.queryJugador(conn);
        } catch (SQLException e) {
            Logger.getLogger(JugadorListaServlet.class.getName()).log(Level.SEVERE, null, e);
            errorString = e.getMessage();
        }
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("list", list);
        request.setAttribute("liste", liste);
         
        // Forward to /WEB-INF/views/productListView.jsp
        request.getRequestDispatcher("/JugadorListaView.jsp").forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}