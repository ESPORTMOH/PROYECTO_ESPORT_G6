package ModelBD;

import Exceptions.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MIGUEL
 */
public class GenericoBD {

    private static Connection con;
    
    private static String nombreBD = "esportmoh";
    
    private static String url = "jdbc:mysql://localhost:3307/" + nombreBD;
    private static String user = "root";
    private static String pass = "usbw";
    

    public Connection abrirConexion() throws ClassNotFoundException, SQLException, ProblemasConexion {

        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection(url, user, pass);

        try {
            if (con != null) {
                System.out.println("Conexion Establecida");
                return con;
            } else {
                System.out.println("Error Estableciendo Conexion");
                return null;
            }
        } catch (Exception e) {
            throw new ProblemasConexion("mensajeEstableceConexion");
        }
    }

    public Connection cerrarConexion() throws SQLException, ProblemasConexion {
        try {
            con.close();
            System.out.println("Conexion Cerrada");
            return null;
        } catch (Exception e) {
            throw new ProblemasConexion("mensajeCierraConexion");
            
        }

    }
    
    /*
    private static String nombreBD = "esportmoh";
    private static String url = "jdbc:mysql://localhost:3307/" + nombreBD;
    private static String user = "root";
    private static String pass = "usbw";
    private static Connection con;
   

    //ESTABLECER CONEXION
    public static Connection abrirConexion() throws ClassNotFoundException, SQLException, Exception {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);

            if (con == null) {
                throw new ProblemasConexion("mensaje");
            }
        } catch (ProblemasConexion | ClassNotFoundException | SQLException E) {
            return null;
        }
        System.out.println("Conexion Establecida");
        return con;
    }

    //CERRAR CONEXION
    public static void cerrarConexion() throws SQLException, Exception {
        System.out.println("Conexion Cerrada");
        con.close();
    }
     */
    
}
