/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet(urlPatterns = { "/editProduct" })
public class EditarJugadorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditarJugadorServlet() {
        super();
    }
 
    // Show product edit page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        int codJug =  Integer.valueOf(request.getParameter("codJug"));
 
        Jugador jugador = null;
 
        String errorString = null;
        List<Equipo> liste = null;
        
            
        try {
            liste =DBUtils.queryEquipo(conn);
            jugador = DBUtils.findJugador(conn, codJug);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && jugador == null) {
            response.sendRedirect(request.getServletPath() + "/JugadorListaServlet");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("jugador", jugador);
         request.setAttribute("liste", liste);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/EditarJugadorView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        int codJug = Integer.valueOf(request.getParameter("codJug"));
        String nomJug = request.getParameter("nomJug");
        String rol = request.getParameter("rol");
        int telefono = Integer.valueOf(request.getParameter("telefono"));
        int codEquipo = Integer.valueOf(request.getParameter("codEquipo"));
        int anoNac  =   Integer.valueOf(request.getParameter("anoNac"));
        
         Jugador jugador = new Jugador(codJug,nomJug,rol,telefono,anoNac,codEquipo);
        String errorString = null;
 
        try {
            DBUtils.updateJugador(conn,jugador);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("jugador", jugador);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/EditarJugadorView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/JugadorListaServlet");
        }
    }
 
}