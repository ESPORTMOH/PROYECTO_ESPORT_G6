package ModelBD;

import ModelUML.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author MIGUEL
 */
public class AdministradorBD extends GenericoBD {

    public Administrador localizaAdministrador(String dni) throws SQLException, Exception {

        Administrador administrador = new Administrador();

        PreparedStatement pS = abrirConexion().prepareStatement("SELECT codAdministrador, dni, nombre, apellido, codLogin FROM administrador WHERE dni = ?");

        pS.setString(1, dni.toUpperCase());

        try (ResultSet datosRS = pS.executeQuery()) {
            if (!datosRS.next()) {
                //throw new UserNotExist();
                System.out.println("no");
            } else {

                administrador.setCodAdministrador(datosRS.getInt("codAdministrador"));
                administrador.setDni(datosRS.getString("dni"));
                administrador.setNombre(datosRS.getString("nombre"));
                administrador.setApellido(datosRS.getString("apellido"));
                administrador.setLogin(new Login(datosRS.getInt("codLogin")));
            }
        }

        cerrarConexion();

        return administrador;

    }
}
