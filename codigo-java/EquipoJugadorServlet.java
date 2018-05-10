
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 6001016
 */
public class EquipoJugadorServlet extends HttpServlet {

    public EquipoJugadorServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //creo el Map primero porque es el general y te sirve para usar las demás funciones de Map, seguidamente creamos un nuevo mapa en mi caso de estilo Tree porque me viene mejor.
//        Map<Integer, ArrayList<Jugador>> jugadoresPorEquipo = new TreeMap<>();
//
//        //aqui ya supongo que he rellenado el Jugador con el RessultSet de BBDD
//        Jugador jugador = new Jugador(1, "Pepe", 1);
//        ArrayList<Jugador> jugadores = jugadoresPorEquipo.get(jugador.getEquipo().getCodEquipo());
//        //Si esta no esta vacio que me lo añada
//        if (jugadores != null) {
//            jugadores.add(jugador);
//        } else /* Aquí si no estuviera creada la clave del Map me la crea y me introduce el valor del Jugador en mi caso */{
//            ArrayList<Jugador> nuevaJugadores = new ArrayList<Jugador>();
//            // Añade jugador a la lista
//            nuevaJugadores.add(jugador);
//            // Añade al Map la lista de(Jugador) 
//            jugadoresPorEquipo.put(jugador.getEquipo().getCodEquipo(), nuevaJugadores);
//        }
//
//        //imprimir
//        List<Jugador> listaCompleta = new ArrayList<>();
//        Set<Integer> equipos = jugadoresPorEquipo.keySet();
//        for (Integer codEquipo : equipos) {
//            System.out.println(String.format("Equipo: %s", codEquipo));
//            ArrayList<Jugador> jugadoresImprimir = jugadoresPorEquipo.get(codEquipo);
//            //para añadir una lista el contenido de otra lista siempre que sea igual
//            listaCompleta.addAll(jugadoresImprimir);
//            for (Jugador jugadorImprimir : jugadoresImprimir) {
//                System.out.println(String.format("\t%s", jugadorImprimir));
//            }
//        }
        Connection conn = MyUtils.getStoredConnection(request);
        Jugador jugador = new Jugador();
        String errorString = null;
        List<Jugador> liste = null;
        Map<Integer, ArrayList<Jugador>> jugadorPorEquipo = null;
        try {
            liste = DBUtils.queryJugador(conn);
            jugadorPorEquipo = DBUtils.jugadorPorEquipo(conn, jugador.getcodEquipo());
        } catch (SQLException e) {
            Logger.getLogger(JugadorListaServlet.class.getName()).log(Level.SEVERE, null, e);
            errorString = e.getMessage();
        }
        request.setAttribute("liste", liste);
        request.setAttribute("jugadorPorEquipo", jugadorPorEquipo);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/EquipoJugadorView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        Jugador jugador = new Jugador();
        Connection conn = MyUtils.getStoredConnection(request);
        List<Jugador> liste = null;
        String errorString = null;
        Map<Integer, ArrayList<Jugador>> jugadorPorEquipo = null;
        try {
            liste = DBUtils.queryJugador(conn);
            jugadorPorEquipo = DBUtils.jugadorPorEquipo(conn, jugador.getcodEquipo());
        } catch (SQLException e) {
            Logger.getLogger(JugadorListaServlet.class.getName()).log(Level.SEVERE, null, e);
            errorString = e.getMessage();
        }
        request.setAttribute("liste", liste);
        request.setAttribute("jugadorPorEquipo", jugadorPorEquipo);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/EquipoJugadorVIew.jsp");
        dispatcher.forward(request, resp);
    }

}
