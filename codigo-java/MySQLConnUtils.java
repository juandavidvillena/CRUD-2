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
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

    //private static Connection conn;
/*
    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException {

        if (conn == null) {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://" + Ctes.HOST_NAME + ":3306/" + Ctes.DB_NAME;
  
            conn = DriverManager.getConnection(connectionURL);
        }
        
        return conn;
    }
*/

 public static Connection getMySQLConnection()
         throws ClassNotFoundException, SQLException {
     // Note: Change the connection parameters accordingly.
     String hostName = "localhost";
     String dbName = "crud_avanzado";
     String userName = "root";
     String password = "root";
     return getMySQLConnection(hostName, dbName, userName, password);
 }
  
 public static Connection getMySQLConnection(String hostName, String dbName,
         String userName, String password) throws SQLException,
         ClassNotFoundException {
    
     Class.forName("com.mysql.jdbc.Driver");
  
     // URL Connection for MySQL:
     // Example: 
     // jdbc:mysql://localhost:3306/simplehr
     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
  
     Connection conn = DriverManager.getConnection(connectionURL, userName,
             password);
     return conn;
 }
}