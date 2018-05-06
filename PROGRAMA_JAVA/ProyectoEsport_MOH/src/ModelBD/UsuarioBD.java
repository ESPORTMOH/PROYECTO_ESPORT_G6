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
public class UsuarioBD {

    private Connection con;

    // INSERTAR USUARIO
    public void insertarUsuarioBD(Usuario usuario, String tipo) throws SQLException, ClassNotFoundException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        LoginBD loginBD = new LoginBD();
        Integer codLogin = loginBD.generarLogin(usuario.getDni(), usuario.getNombre(), usuario.getApellido(), tipo);

        PreparedStatement pS = con.prepareStatement("INSERT INTO usuario (dni, nombre, apellido, codLogin) VALUES (?,?,?,?)");
        pS.setString(1, usuario.getDni());
        pS.setString(2, usuario.getNombre());
        pS.setString(3, usuario.getApellido());
        pS.setInt(4, codLogin);
        pS.executeUpdate();

        con.close();
    }

    // CONSULTAR
    public Usuario localizaUsuario(String dni) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        Usuario usuario = new Usuario();

        String consultaSQL = "SELECT codUsuario, dni, nombre, apellido, codLogin FROM usuario WHERE dni = ?";

        PreparedStatement pS = con.prepareStatement(consultaSQL);

        pS.setString(1, dni.toUpperCase());

        try (ResultSet datosRS = pS.executeQuery()) {
            if (!datosRS.next()) {
                throw new DuenioNoExiste();
            } else {

                usuario.setCodUsuario(datosRS.getInt("codUsuario"));
                usuario.setDni(datosRS.getString("dni"));
                usuario.setNombre(datosRS.getString("nombre"));
                usuario.setApellido(datosRS.getString("apellido"));

                usuario.setLogin(new Login(datosRS.getInt("codLogin")));
            }
        }
        con.close();
        return usuario;

    }

}
