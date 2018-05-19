package ModelBD;

import Exceptions.*;
import ModelUML.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author MIGUEL OLMO HERNANDO
 */
public class AdministradorBD extends GenericoBD {

    private Connection con;

    /**
     * COMPROBACION EXISTE O NO PARA DAR DE ALTA O NO
     *
     * @param dni
     * @return localizado
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public boolean localizarSiexixteDniAdmin(String dni) throws SQLException, ConexionProblemas {
        Boolean localizado = false;
        int records;

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("SELECT COUNT(1) FROM administrador WHERE dni = ?");
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

    /**
     * INSERTAR ADMINISTRADOR
     *
     * @param administrador
     * @param tipo
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public void insertarAdministradorBD(Administrador administrador, String tipo) throws SQLException, ClassNotFoundException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        LoginBD loginBD = new LoginBD();
        Integer codLogin = loginBD.generarLogin(administrador.getDni(), administrador.getNombre(), administrador.getApellido(), tipo);

        PreparedStatement pS = con.prepareStatement("INSERT INTO administrador (dni, nombre, apellido, codLogin) VALUES (?,?,?,?)");
        pS.setString(1, administrador.getDni().toUpperCase());
        pS.setString(2, administrador.getNombre());
        pS.setString(3, administrador.getApellido());
        pS.setInt(4, codLogin);
        pS.executeUpdate();

        cerrarConexion(con);
    }

    /**
     * LOCALIZAR ADMINISTRADOR
     *
     * @param dni
     * @return administrador
     * @throws Exception
     */
    public Administrador localizarAdministrador(String dni) throws Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        Administrador administrador = new Administrador();

        String consultaSQL = "SELECT a.codAdministrador, a.dni, a.nombre, a.apellido, a.codLogin, l.codLogin, l.usuario, l.passwd FROM administrador a, login l  WHERE (a.codLogin = l.codLogin) AND a.dni = ?";

        PreparedStatement pS = con.prepareStatement(consultaSQL);

        pS.setString(1, dni.toUpperCase());

        ResultSet datosRS = pS.executeQuery();
        if (!datosRS.next()) {
            throw new AdminNoExiste();
        } else {

            administrador.setCodAdministrador(datosRS.getInt("codAdministrador"));
            administrador.setDni(datosRS.getString("dni"));
            administrador.setNombre(datosRS.getString("nombre"));
            administrador.setApellido(datosRS.getString("apellido"));
            administrador.setLogin(new Login(datosRS.getInt("codLogin")));
            administrador.getLogin().setUser(datosRS.getString("usuario"));
            administrador.getLogin().setPassword(datosRS.getString("passwd"));
        }

        cerrarConexion(con);

        return administrador;
    }

    /**
     * ELIMINAR ADMINISTRADOR
     *
     * @param dni
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public void eliminarDeLaBDAdmin(String dni) throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("DELETE FROM administrador WHERE dni = ?");
        pS.setString(1, dni);

        pS.executeUpdate();

        cerrarConexion(con);
    }

}
