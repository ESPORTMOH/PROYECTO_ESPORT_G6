package ModelBD;

import ModelBD.*;
import ModelUML.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Exceptions.*;

/**
 * @author MIGUEL
 */
public class LoginBD extends GenericoBD {

    //VALIDAR LOGIN
    public Login validarLogin(Login loginUML) throws SQLException, Exception {

        Login log = new Login();

        PreparedStatement pS = abrirConexion().prepareStatement("SELECT usuario, passwd, tipo FROM login WHERE usuario = ? and passwd = ?");

        pS.setString(1, loginUML.getUser());
        pS.setString(2, loginUML.getPassword());

        try (ResultSet datosRS = pS.executeQuery()) {
            if (!datosRS.next()) {
                //throw new UserNotExist();
                System.out.println("no");
            } else {

                log.setUser(datosRS.getString("usuario"));
                log.setPassword(datosRS.getString("passwd"));
                log.setTipo(datosRS.getString("tipo"));

            }
        }

        cerrarConexion();

        return log;

    }

}
