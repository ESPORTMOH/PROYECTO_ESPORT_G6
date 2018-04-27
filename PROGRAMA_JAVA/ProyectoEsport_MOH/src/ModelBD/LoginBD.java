package ModelBD;

import ModelBD.*;
import ModelUML.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Exceptions.*;
import java.sql.Connection;

/**
 * @author MIGUEL
 */
public class LoginBD extends GenericoBD {

    private Connection con;

    //VALIDAR LOGIN
    public Login validarLogin(Login loginUML) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        // COMPROBACION DEL RETORNO DE LA CONEXION, SI ES NULA SALTA MI EXCEPCION PARA QUE EL USUARIO SE DE CUENTA
        if (con == null) {
            throw new ProblemasEstablecerConexion();
        }
        
        // CREO OBJETO DE TIPOLOG QUE ME PERMITIRA ALMACENAR EL TIPO DE LOGIN QUE CONSULTO EN LA BD
        Login tipolog = new Login();

        String consultaSQL = "SELECT usuario, passwd, tipo FROM login WHERE usuario = ? and passwd = ?";

        PreparedStatement pS = con.prepareStatement(consultaSQL);

        pS.setString(1, loginUML.getUser());
        pS.setString(2, loginUML.getPassword());

        try (ResultSet datosRS = pS.executeQuery()) {
            if (!datosRS.next()) {
                throw new UsuarioLogNoExiste();

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
