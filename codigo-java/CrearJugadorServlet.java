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
//@WebServlet(urlPatterns = {"/crearJugador"})
public class CrearJugadorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CrearJugadorServlet() {
        super();
    }

    // Show product creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);

        List<Equipo> liste = null;
        try {
            liste = DBUtils.queryEquipo(conn);
        } catch (SQLException e) {
            Logger.getLogger(CrearJugadorServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        request.setAttribute("liste", liste);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/crearJugadorView.jsp");
        dispatcher.forward(request, response);

    }
//        RequestDispatcher dispatcher = request.getServletContext()
//                .getRequestDispatcher("crearJugadorView.jsp");
//        dispatcher.forward(request, response);

    // When the user enters the product information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        int codJug = 0;
        try {
            codJug = (DBUtils.totalJugador(conn) + 1);

        } catch (SQLException ex) {
            Logger.getLogger(CrearJugadorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nomJug = request.getParameter("nomJug");
        String rol = request.getParameter("rol");
        int anoNac = Integer.valueOf(request.getParameter("anoNac"));
        int telefono = Integer.valueOf(request.getParameter("telefono"));
        int codEquipo = Integer.valueOf(request.getParameter("codEquipo"));
        String Comunidad = null/* = request.getParameter("comunidad")*/;
        String nomEquipo = null/* = request.getParameter("nomEquipo")*/;
        String eSport = null/* = request.getParameter("eSport")*/;
        int anoCreacion = 0 /* = Integer.valueOf(request.getParameter("anoCreacion"))*/;
        int CodEquipo = Integer.valueOf(request.getParameter("codEquipo"));

        Jugador jugador = new Jugador(codJug, nomJug, rol,  telefono, anoNac, codEquipo);
        Equipo equipo = new Equipo(Comunidad, nomEquipo, eSport, anoCreacion, codEquipo);
        String errorString = null;
        // Store infomation to request attribute, before forward to views.
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("errorString", errorString);
        if (errorString == null) {
            try {
                DBUtils.insertJugador(conn, jugador);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/crearJugadorView.jsp");
            dispatcher.forward(request, response);
        } // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/JugadorListaServlet");
        }
    }

}
