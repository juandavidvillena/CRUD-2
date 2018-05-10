/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 6001016
 */
public class HashMap extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public HashMap() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        Jugador jugador = new Jugador();
        //Aquí tengo que mirar como puedo cambiar en vez de que sea un solo equipo el que coja acceder a todos los equipos

        Equipo equipo = new Equipo();
        Connection conn = MyUtils.getStoredConnection(request);
        String errorString = null;
        List<Equipo> liste = null;
        List<Jugador> list = null;
        Map<Integer, ArrayList<Jugador>> jugadorPorEquipo = null;
        try {

            liste = DBUtils.queryEquipo(conn);
            list = DBUtils.queryJugador(conn);
            //jugadorPorEquipo = DBUtils.jugadorPorEquipo(conn, CodEquipo);

        } catch (SQLException e) {
            Logger.getLogger(HashMap.class.getName()).log(Level.SEVERE, null, e);
            errorString = e.getMessage();
        }
        request.setAttribute("list", list);
        request.setAttribute("jugadorPorEquipo", jugadorPorEquipo);
        request.setAttribute("liste", liste);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/HashMapView.jsp");
        dispatcher.forward(request, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        Jugador jugador = new Jugador();
        Connection conn = MyUtils.getStoredConnection(request);
        String errorString = null;
        List<Equipo> liste = null;
        List<Jugador> list = null;
        Map<Integer, ArrayList<Jugador>> jugadorPorEquipo = null;
        int codEquipo = Integer.valueOf(request.getParameter("codEquipo"));
        try {
            liste = DBUtils.queryEquipo(conn);
            list = DBUtils.queryJugador(conn);
            jugadorPorEquipo = DBUtils.jugadorPorEquipo(conn, codEquipo);
        } catch (SQLException e) {
            Logger.getLogger(HashMap.class.getName()).log(Level.SEVERE, null, e);
            errorString = e.getMessage();
        }
//        request.setAttribute("jugadorPorEquipo", jugadorPorEquipo);
        request.setAttribute("liste", liste);
        request.setAttribute("jugadorPorEquipo", jugadorPorEquipo);
        request.setAttribute("listaJugadorMap", jugadorPorEquipo.get(codEquipo));
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/HashMapView.jsp");
        dispatcher.forward(request, resp);
    }
}
