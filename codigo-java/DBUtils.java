/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 6001016
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import User.UserAccount;
import java.util.Map;
import java.util.TreeMap;

public class DBUtils {

    public static UserAccount findUser(Connection conn, //
            String userName, String password) throws SQLException {

        String sql = "Select a.NomUsu, a.password from usuario a " //
                + " where a.NomUsu = ? and a.password= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setNomUsu(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }

    public static UserAccount findUser(Connection conn, String userName) throws SQLException {

        String sql = "Select a.NomUsu, a.password from usuario a "//
                + " where a.NomUsu = ? ";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);

        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            String password = rs.getString("password");
            UserAccount user = new UserAccount();
            user.setNomUsu(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }

    public static List<Jugador> queryJugador(Connection conn) throws SQLException {
        String sql = "SELECT CodJug, NomJug, Rol, Telefono, AnoNac, FotoJug, equipo.CodEquipo, equipo.NomEquipo, equipo.AnoCreacion, equipo.Comunidad, equipo.eSport FROM jugador INNER JOIN EQUIPO ON jugador.CodEquipo = equipo.CodEquipo order by CodJug";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        List<Jugador> list = new ArrayList<Jugador>();
        while (rs.next()) {
            // Obtengo los datos de la consulta
            int codJug = rs.getInt("CodJug");
            String nomJug = rs.getString("NomJug");
            String rol = rs.getString("Rol");
            int telefono = rs.getInt("Telefono");
            int anoNac = rs.getInt("AnoNac");
            String nomEquipo = rs.getString("NomEquipo");
            String eSport = rs.getString("eSport");
            int codEquipo = rs.getInt("CodEquipo");
            String comunidad = rs.getString("Comunidad");
            int anoCreacion = rs.getInt("AnoCreacion");
            String fotoJug = rs.getString("FotoJug");
            // Creo los objetos y los relleno con su información de la consulta
            Equipo equipo = new Equipo();
            equipo.setAnoCreacion(anoCreacion);
            equipo.setCodEquipo(codEquipo);
            equipo.setNomEquipo(nomEquipo);
            equipo.seteSport(eSport);
            Jugador jugador = new Jugador(codJug, nomJug, rol, telefono, anoNac, equipo, codEquipo,fotoJug);
            // Añade el jugador a la lista
            list.add(jugador);
        }
        return list;
    }

    public static List<Equipo> queryEquipo(Connection conn) throws SQLException {
        String sql = "SELECT * From Equipo order by CodEquipo";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        List<Equipo> liste = new ArrayList<Equipo>();
        while (rs.next()) {

            // Obtengo los datos de la consulta           
            String nomEquipo = rs.getString("NomEquipo");
            String eSport = rs.getString("eSport");
            int codEquipo = rs.getInt("CodEquipo");
            String comunidad = rs.getString("Comunidad");
            int anoCreacion = rs.getInt("AnoCreacion");

            // Creo los objetos y los relleno con su información de la consulta
            Equipo equipo = new Equipo();
            equipo.setAnoCreacion(anoCreacion);
            equipo.setCodEquipo(codEquipo);
            equipo.setNomEquipo(nomEquipo);
            equipo.setComunidad(comunidad);
            equipo.seteSport(eSport);

            // Añade el jugador a la lista
            liste.add(equipo);
        }
        return liste;
    }

    public static int totalJugador(Connection conn) throws SQLException {
        int total = 0;

        String sql = "Select count(*) as total from jugador";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery(sql);

        if (rs.next()) {
            total = rs.getInt(1);
        }
        pstm.close();

        return total;
    }

    public static Jugador findJugador(Connection conn, int codJug) throws SQLException {
        String sql = "Select CodJug, NomJug, Rol, Telefono, AnoNac, jugador.CodEquipo, equipo.NomEquipo from jugador  INNER JOIN EQUIPO ON jugador.CodEquipo = equipo.CodEquipo where codJug=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, codJug);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int codJuga = rs.getInt("CodJug");
            String nomJug = rs.getString("NomJug");
            String rol = rs.getString("Rol");
            int telefono = rs.getInt("Telefono");
            int anoNac = rs.getInt("AnoNac");
            String nomEquipo = rs.getString("NomEquipo");
            int codEquipo = rs.getInt("CodEquipo");
            Equipo equipo = new Equipo();
            Jugador jugador = new Jugador(codJuga, nomJug, rol, telefono, anoNac, equipo, codEquipo);

            return jugador;
        }
        return null;
    }

    public static void updateJugador(Connection conn, Jugador jugador) throws SQLException {
        String sql = "Update jugador set NomJug =?, Rol =?, Telefono =?, AnoNac =?, CodEquipo =? where CodJug =? ";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, jugador.getNomJug());
        pstm.setString(2, jugador.getRol());
        pstm.setInt(3, jugador.getTelefono());
        pstm.setInt(4, jugador.getAnoNac());
        pstm.setInt(5, jugador.getcodEquipo());
        pstm.setInt(6, jugador.getCodJug());
        pstm.executeUpdate();
    }

    public static void insertJugador(Connection conn, Jugador jugador) throws SQLException {
        String sql = "Insert into Jugador(NomJug,Rol,Telefono, AnoNac, CodEquipo) values (?,?,?,?,?)";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, jugador.getNomJug());
        pstm.setString(2, jugador.getRol());
        pstm.setInt(3, jugador.getTelefono());
        pstm.setInt(4, jugador.getAnoNac());
        pstm.setInt(5, jugador.getcodEquipo());

        pstm.executeUpdate();
    }

    public static void deleteJugador(Connection conn, int codJug) throws SQLException {
        String sql = "Delete From jugador where CodJug= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setInt(1, codJug);

        pstm.executeUpdate();
    }

    public static Map<Integer, ArrayList<Jugador>> jugadorPorEquipo(Connection conn, Integer codEquipo) throws SQLException {
        String sql = "Select CodJug, NomJug, Rol, Telefono, AnoNac, jugador.CodEquipo, equipo.NomEquipo from jugador INNER JOIN EQUIPO ON jugador.CodEquipo = equipo.CodEquipo  order by CodEquipo";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
//        Jugador jugador = new Jugador();
        List<Jugador> list = new ArrayList<Jugador>();
        Map<Integer, ArrayList<Jugador>> jugadoresPorEquipo = new TreeMap<>();
        
        while (rs.next()) {
            int codJug = rs.getInt("CodJug");
            String nomJug = rs.getString("NomJug");
            String rol = rs.getString("Rol");
            int telefono = rs.getInt("Telefono");
            int anoNac = rs.getInt("AnoNac");
            String nomEquipo = rs.getString("NomEquipo");
            codEquipo = rs.getInt("CodEquipo");
            Equipo equipo = new Equipo();
            equipo.getNomEquipo();
            Jugador jugador = new Jugador(codJug, nomJug, rol, telefono, anoNac, equipo, codEquipo);
            

            //aqui ya supongo que he rellenado el Jugador con el RessultSet de BBDD
            //for(int eq = 0 ; eq < codEquipo; eq++){
            ArrayList<Jugador> jugadores = jugadoresPorEquipo.get(jugador.getCodEquipo());
            //Si esta no esta vacio que me lo añada
            if (jugadores != null) {
                jugadores.add(jugador);
            } else /* Aquí si no estuviera creada la clave del Map me la crea y me introduce el valor del Jugador en mi caso */ {
                ArrayList<Jugador> nuevaJugadores = new ArrayList<Jugador>();
                // Añade jugador a la lista
                nuevaJugadores.add(jugador);
                // Añade al Map la lista de(Jugador) 
                jugadoresPorEquipo.put(jugador.getCodEquipo(), nuevaJugadores);
            }
            //codEquipo++;
            //}
        }
        return jugadoresPorEquipo;
    }
}
