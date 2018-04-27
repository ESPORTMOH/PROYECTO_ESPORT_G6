package ModelBD;

import Exceptions.*;
import ModelUML.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author MIGUEL
 */


public class AdministradorBD extends GenericoBD {
    
    private Connection con;

    public Administrador localizaAdministrador(String dni) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        Administrador administrador = new Administrador();

        String consultaSQL = "SELECT codAdministrador, dni, nombre, apellido, codLogin FROM administrador WHERE dni = ?";
        
        PreparedStatement pS=con.prepareStatement(consultaSQL);

        pS.setString(1, dni.toUpperCase());

        try (ResultSet datosRS = pS.executeQuery()) {
            if (!datosRS.next()) {
                throw new DuenioNoExiste();
            } else {

                administrador.setCodAdministrador(datosRS.getInt("codAdministrador"));
                administrador.setDni(datosRS.getString("dni"));
                administrador.setNombre(datosRS.getString("nombre"));
                administrador.setApellido(datosRS.getString("apellido"));
                administrador.setLogin(new Login(datosRS.getInt("codLogin")));
            }
        }

        con.close();

        return administrador;

    }

}
