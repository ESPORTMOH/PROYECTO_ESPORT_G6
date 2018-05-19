package ModelBD;

import Exceptions.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author MIGUEL
 */
public class GenericoBD {

/*   
    // CONEXIONES / DESCONEXIONES A LA BD MEDIANTE SRVORACLE / EN CLASE
    public Connection abrirConexion(Connection conexion) throws SQLException, ConexionProblemas {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@172.20.225.114:1521:orcl", "eqdaw06", "eqdaw06");

            if (conexion != null) {
                System.out.println("Conexion Establecida");
                return conexion;
            } else {
                System.out.println("Error Estableciendo Conexion");
                return null;
            }
        } catch (ClassNotFoundException | SQLException E) {
            return null;
        }

    }

    public void cerrarConexion(Connection conexion) throws SQLException, ConexionProblemas {
        try {
            System.out.println("Conexion Cerrada");
            conexion.close();
        } catch (SQLException E) {
        }
    }

}
*/

 
////////////////////////////////////////////////////////////////////////////////////////////////
// DATOS PARA LA CONEXION EN MI CASA CON VAGRANT
//Class.forName("oracle.jdbc.OracleDriver");
//String user = "system";
//String pass = "oracle";
//String url = "jdbc:oracle:thin:@10.10.10.9:1521:db12102";
    public Connection abrirConexion(Connection conexion) throws SQLException, ConexionProblemas {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.9:1521:db12102", "SCOTT", "miguel");

            if (conexion != null) {
                System.out.println("Conexion Establecida");
                return conexion;
            } else {
                System.out.println("Error Estableciendo Conexion");
                return null;
            }
        } catch (ClassNotFoundException | SQLException E) {
            return null;
        }

    }

    public void cerrarConexion(Connection conexion) throws SQLException, ConexionProblemas {
        try {
            System.out.println("Conexion Cerrada");
            conexion.close();
        } catch (SQLException E) {
        }
    }

}

 
////////////////////////////////////////////////////////////////////////////////////////////////

/*
    // CONEXIONES / DESCONEXIONES A LA BD MEDIANTE USBWEBSERVER / MYSQL
    
    private Connection con;

    private String nombreBD = "esportmoh";

    private String url = "jdbc:mysql://localhost:3307/" + nombreBD;
    private String user = "root";
    private String pass = "usbw";

    
    // FUNCION PARA ESTABLECER CONEXION CON LA BD EN MYSQL
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

    // FUNCION PARA CERRAR CONEXION CON LA BD EN MYSQL
    public Connection cerrarConexion() throws SQLException, ProblemasConexion {
        try {
            con.close();
            System.out.println("Conexion Cerrada");
            return null;
        } catch (Exception e) {
            throw new ProblemasConexion("mensajeCierraConexion");
        }
    }
 */
////////////////////////////////////////////////////////////////////////////////////////////////

