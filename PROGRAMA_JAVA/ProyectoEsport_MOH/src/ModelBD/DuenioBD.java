package ModelBD;

import Exceptions.DuenioNoExiste;
import ModelUML.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MIGUEL
 */
public class DuenioBD {

    private Connection con;

    // INSERTAR DUENIO
    public void insertarDuenioBD(Duenio duenio, String tipo) throws SQLException, ClassNotFoundException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        LoginBD loginBD = new LoginBD();
        Integer codLogin = loginBD.generarLogin(duenio.getDni(), duenio.getNombre(), duenio.getApellido(), tipo);

        PreparedStatement pS = con.prepareStatement("INSERT INTO duenio (dni, nombre, apellido, codLogin) VALUES (?,?,?,?)");
        pS.setString(1, duenio.getDni());
        pS.setString(2, duenio.getNombre());
        pS.setString(3, duenio.getApellido());
        pS.setInt(4, codLogin);
        pS.executeUpdate();

        con.close();
    }

    // CONSULTAR
    public Duenio localizaDuenio(String dni) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        Duenio duenio = new Duenio();

        String consultaSQL = "SELECT codDuenio, dni, nombre, apellido, codLogin FROM duenio WHERE dni = ?";

        PreparedStatement pS = con.prepareStatement(consultaSQL);

        pS.setString(1, dni.toUpperCase());

        try (ResultSet datosRS = pS.executeQuery()) {
            if (!datosRS.next()) {
                throw new DuenioNoExiste();
            } else {

                duenio.setCodDuenio(datosRS.getInt("codDuenio"));
                duenio.setDni(datosRS.getString("dni"));
                duenio.setNombre(datosRS.getString("nombre"));
                duenio.setApellido(datosRS.getString("apellido"));

                duenio.setLogin(new Login(datosRS.getInt("codLogin")));
            }
        }

        con.close();

        return duenio;

    }

}
