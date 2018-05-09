package ModelBD;

import Exceptions.ConexionProblemas;
import ModelUML.*;
import Exceptions.EquipoNoExiste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author MIGUEL
 */
public class EquipoBD extends GenericoBD {

    private Connection con;

    // INSERTAR EQUIPO
    public void insertarEquipoBD(Equipo equipo) throws SQLException, ClassNotFoundException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("INSERT INTO equipo e(e.nombre, e.presupuesto, e.anioFundacion, e.ciudad, e.nombreEstadio) VALUES (?,?,?,?,?)");
        pS.setString(1, equipo.getNombre().toUpperCase());
        pS.setDouble(2, equipo.getPresupuesto());
        pS.setString(3, equipo.getAnioFundacion());
        pS.setString(4, equipo.getCiudad());
        pS.setString(5, equipo.getNombreEstadio());

        pS.executeUpdate();

        cerrarConexion(con);
    }

    // LOCALIZAR EQUIPO
    public Equipo localizarEquipo(String nombre) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        Equipo equipo = new Equipo();

        String consultaSQL = "SELECT e.codEquipo, e.nombre, e.presupuesto, e.anioFundacion, e.ciudad, e.nombreEstadio, e.codDuenio, d.codDuenio, d.dni, d.nombre FROM equipo e, duenio d  WHERE (e.codDuenio = d.codDuenio) AND e.nombre = ?";

        PreparedStatement pS = con.prepareStatement(consultaSQL);

        pS.setString(1, nombre.toUpperCase());

        try (ResultSet datosRS = pS.executeQuery()) {
            if (!datosRS.next()) {
                throw new EquipoNoExiste();
            } else {
                equipo.setCodEquipo(datosRS.getInt("codEquipo"));
                equipo.setNombre(datosRS.getString("nombre"));
                equipo.setPresupuesto(datosRS.getDouble("presupuesto"));
                equipo.setAnioFundacion(datosRS.getString("anioFundacion"));
                equipo.setCiudad(datosRS.getString("ciudad"));
                equipo.setNombreEstadio(datosRS.getString("nombreEstadio"));
                equipo.setDuenio(new Duenio(datosRS.getInt("codDuenio")));
                equipo.getDuenio().setDni(datosRS.getString("dni"));
                equipo.getDuenio().setNombre(datosRS.getString("nombre"));
            }
        }
        cerrarConexion(con);
        return equipo;
    }

    // ELIMINAR ADMINISTRADOR
    public void eliminarDeLaBDEquipo(String nombre) throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("DELETE FROM equipo e WHERE e.nombre = ?");
        pS.setString(1, nombre);

        pS.executeUpdate();

        cerrarConexion(con);

    }

}
