package ModelBD;

import ModelBD.*;
import ModelUML.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Exceptions.*;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 * @author MIGUEL
 */
public class LoginBD extends GenericoBD {

    private Connection con;

    // LLAMADA AL PROCEDIMIENTO PARA GENERAR AUTO USER / PASSWD 
    public Integer generarLogin(String dni, String nombre, String apellido, String tipo) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        CallableStatement cS = con.prepareCall("{call generarAutoUserPass(?,?,?,?,?)}");

        cS.setString(1, dni);
        cS.setString(2, nombre);
        cS.setString(3, apellido);
        cS.setString(4, tipo);

        cS.registerOutParameter(5, java.sql.Types.INTEGER);
        cS.execute();
        
        Integer id = cS.getInt(5);

        con.close();

        return id;

    }

    //VALIDAR LOGIN
    public Login validarLogin(Login loginUML) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        // COMPROBACION DEL RETORNO DE LA CONEXION, SI ES NULA SALTA MI EXCEPCION PARA QUE EL USUARIO SE DE CUENTA
        if (con == null) {
            throw new ConexionProblemas();
        }

        // CREO OBJETO DE TIPOLOG QUE ME PERMITIRA ALMACENAR EL TIPO DE LOGIN QUE CONSULTO EN LA BD
        Login tipolog = new Login();

        String consultaSQL = "SELECT usuario, passwd, tipo FROM login WHERE usuario = ? and passwd = ?";

        PreparedStatement pS = con.prepareStatement(consultaSQL);

        pS.setString(1, loginUML.getUser());
        pS.setString(2, loginUML.getPassword());

        try (ResultSet datosRS = pS.executeQuery()) {
            if (!datosRS.next()) {
                throw new LogAccesoNoExiste();

            } else {

                tipolog.setUser(datosRS.getString("usuario"));
                tipolog.setPassword(datosRS.getString("passwd"));
                tipolog.setTipo(datosRS.getString("tipo"));
            }
        }

        // CIERRA CONEXION
        con.close();

        // RETORNO TIPO LOG A / D / U
        return tipolog;

    }

}
