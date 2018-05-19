package ModelBD;

import ModelUML.*;
import Exceptions.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MIGUEL
 */
public class UsuarioBD extends GenericoBD {

    private Connection con;

    // COMPROBACION EXISTE O NO PARA DAR DE ALTA O NO
    public boolean localizarSiexixteDniUsuario(String dni) throws SQLException, ConexionProblemas {
        Boolean localizado = false;
        int records;

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("SELECT COUNT(1) FROM usuario WHERE dni = ?");
        pS.setString(1, dni);

        ResultSet datosRS = pS.executeQuery();
        if (datosRS.next()) {
            records = datosRS.getInt(1);
            if (records > 0) {
                localizado = true;
            }
        }
        cerrarConexion(con);
        return localizado;
    }

    // INSERTAR USUARIO
    public void insertarUsuarioBD(Usuario usuario, String tipo) throws SQLException, ClassNotFoundException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        LoginBD loginBD = new LoginBD();
        Integer codLogin = loginBD.generarLogin(usuario.getDni(), usuario.getNombre(), usuario.getApellido(), tipo);

        PreparedStatement pS = con.prepareStatement("INSERT INTO usuario u(u.dni, u.nombre, u.apellido, u.codLogin) VALUES (?,?,?,?)");
        pS.setString(1, usuario.getDni().toUpperCase());
        pS.setString(2, usuario.getNombre());
        pS.setString(3, usuario.getApellido());
        pS.setInt(4, codLogin);
        pS.executeUpdate();

        cerrarConexion(con);
    }

    // LOCALIZAR USUARIO
    public Usuario localizarUsuario(String dni) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        Usuario usuario = new Usuario();

        String consultaSQL = "SELECT u.codUsuario, u.dni, u.nombre, u.apellido, u.codLogin, l.codLogin, l.usuario, l.passwd FROM usuario u, login l  WHERE (u.codLogin = l.codLogin) AND u.dni = ?";

        PreparedStatement pS = con.prepareStatement(consultaSQL);

        pS.setString(1, dni.toUpperCase());

        ResultSet datosRS = pS.executeQuery();
        if (!datosRS.next()) {
            throw new UsuarioNoExiste();
        } else {

            usuario.setCodUsuario(datosRS.getInt("codUsuario"));
            usuario.setDni(datosRS.getString("dni"));
            usuario.setNombre(datosRS.getString("nombre"));
            usuario.setApellido(datosRS.getString("apellido"));
            usuario.setLogin(new Login(datosRS.getInt("codLogin")));
            usuario.getLogin().setUser(datosRS.getString("usuario"));
            usuario.getLogin().setPassword(datosRS.getString("passwd"));
        }

        cerrarConexion(con);

        return usuario;
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

    // ELIMINAR USUARIO
    public void eliminarUsuarioDelaBD(String dni) throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("DELETE FROM usuario WHERE dni = ?");
        pS.setString(1, dni);

        pS.executeUpdate();

        cerrarConexion(con);
    }

}
