package ModelBD;

import ModelBD.*;
import ModelUML.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Exceptions.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author MIGUEL
 */
public class LoginBD extends GenericoBD {

    private Connection con;

    // LLAMADA AL PROCEDIMIENTO PARA GENERAR AUTO USER / PASSWD 
    public Integer generarLogin(String dni, String nombre, String apellido, String tipo) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        CallableStatement cS = con.prepareCall("{call ESPORT_MOH_1.PROCE_generarAutoUserPass(?,?,?,?,?)}");

        cS.setString(1, dni);
        cS.setString(2, nombre);
        cS.setString(3, apellido);
        cS.setString(4, tipo);

        cS.registerOutParameter(5, java.sql.Types.INTEGER);
        cS.execute();

        Integer id = cS.getInt(5);

        cerrarConexion(con);

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
        cerrarConexion(con);

        // RETORNO TIPO LOG A / D / U
        return tipolog;
    }

    // EDITAR LOGIN
    public void ejecutarModificacionLog(String passwd, Integer codLoginADM) throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        String editaSQL = "UPDATE login l SET l.passwd = ? WHERE (l.codLogin = ?)";
        PreparedStatement pS = con.prepareStatement(editaSQL);

        pS.setString(1, passwd);
        pS.setString(2, codLoginADM.toString());

        pS.executeUpdate();

        cerrarConexion(con);
    }

    // ELIMINAR ADMIN LOGIN
    public void eliminarDeLaBDAdminLog(Integer codLogin) throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("DELETE FROM login WHERE codLogin = ?");
        pS.setInt(1, codLogin);

        pS.executeUpdate();

        cerrarConexion(con);
    }
    
    // ELIMINAR DUENIO LOGIN
    public void eliminarDeLaBDDuenioLog(Integer codLogin) throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("DELETE FROM login WHERE codLogin = ?");
        pS.setInt(1, codLogin);

        pS.executeUpdate();

        cerrarConexion(con);
    }
    
    // ELIMINAR USUARIO LOGIN
    public void eliminarDeLaBDUsuarioLog(Integer codLogin) throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("DELETE FROM login WHERE codLogin = ?");
        pS.setInt(1, codLogin);

        pS.executeUpdate();

        cerrarConexion(con);
    }

}
