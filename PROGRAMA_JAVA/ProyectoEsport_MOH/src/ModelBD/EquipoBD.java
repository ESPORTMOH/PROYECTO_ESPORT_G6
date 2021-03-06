package ModelBD;

import Exceptions.ConexionProblemas;
import ModelUML.*;
import Exceptions.EquipoNoExiste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author MIGUEL OLMO HERNANDO
 */
public class EquipoBD extends GenericoBD {

    private Connection con;

    /**
     * INSERTAR EQUIPO
     *
     * @param equipo
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public void insertarEquipoBD(Equipo equipo) throws SQLException, ClassNotFoundException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("INSERT INTO equipo e(e.nombre, e.presupuesto, e.anioFundacion, e.ciudad, e.nombreEstadio, e.codDuenio) VALUES (?,?,?,?,?,?)");
        pS.setString(1, equipo.getNombre().toUpperCase());
        pS.setDouble(2, equipo.getPresupuesto());
        pS.setString(3, equipo.getAnioFundacion());
        pS.setString(4, equipo.getCiudad());
        pS.setString(5, equipo.getNombreEstadio());
        pS.setInt(6, equipo.getDuenio().getCodDuenio());

        pS.executeUpdate();

        cerrarConexion(con);
    }

    /**
     * LOCALIZAR EQUIPO
     *
     * @param nombre
     * @return equipo
     * @throws SQLException
     * @throws Exception
     */
    public Equipo localizarEquipo(String nombre) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        Equipo equipo = new Equipo();

        String consultaSQL = "SELECT e.codEquipo, e.nombre, e.presupuesto, e.anioFundacion, e.ciudad, e.nombreEstadio, e.codDuenio, d.codDuenio, d.dni, d.nombre FROM equipo e, duenio d  WHERE (e.codDuenio = d.codDuenio) AND e.nombre = ?";

        PreparedStatement pS = con.prepareStatement(consultaSQL);

        pS.setString(1, nombre.toUpperCase());

        ResultSet datosRS = pS.executeQuery();
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

        cerrarConexion(con);
        return equipo;
    }

    /**
     * EDITAR EQUIPO
     *
     * @param nombre
     * @param ciudad
     * @param estadio
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public void ejecutarModificacionBDEquipo(String nombre, String ciudad, String estadio) throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        String editaSQL = "UPDATE equipo e SET e.ciudad = ?, e.nombreEstadio = ? WHERE e.nombre = ?";

        PreparedStatement pS = con.prepareStatement(editaSQL);

        pS.setString(1, ciudad);
        pS.setString(2, estadio);
        pS.setString(3, nombre);
        // me falta pasarle un parametro

        pS.executeUpdate();

        cerrarConexion(con);

    }

    /**
     * ELIMINAR EQUIPO
     *
     * @param nombre
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public void eliminarDeLaBDEquipo(String nombre) throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("DELETE FROM equipo e WHERE e.nombre = ?");
        pS.setString(1, nombre);

        pS.executeUpdate();

        cerrarConexion(con);

    }

    /**
     * TRAER TODOS LOS EQUIPOS
     *
     * @return listaEquipos
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<Equipo> getAllEquipos() throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        ArrayList<Equipo> listaEquipos = new ArrayList();
        String consultaSQL = "SELECT codequipo, nombre, presupuesto, aniofundacion, ciudad, nombreestadio, codduenio FROM equipo WHERE codequipo <> 1 ";

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(consultaSQL);
        while (rs.next()) {
            Equipo eq = new Equipo();
            eq.setCodEquipo(rs.getInt("codequipo"));
            eq.setNombre(rs.getString("nombre"));
            eq.setPresupuesto(rs.getDouble("presupuesto"));
            //eq.setAnioFundacion(rs.getDate("ANIOFUNDACION"));
            eq.setCiudad(rs.getString("ciudad"));
            eq.setNombreEstadio(rs.getString("nombreestadio"));
            eq.setDuenio(new Duenio(rs.getInt("codduenio")));

            listaEquipos.add(eq);
        }

        cerrarConexion(con);

        return listaEquipos;
    }

    /**
     * RECOGER DATOS DE EQUIPO
     *
     * @param utilizarDuenioEnSesion
     * @return eq
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public Equipo recogerDatosEquipo(Duenio utilizarDuenioEnSesion) throws SQLException, ConexionProblemas {

        Equipo equ = new Equipo();

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        System.out.println("Codigo del Duenio en sesion: "+utilizarDuenioEnSesion.getCodDuenio()
                           + " Y el codigo de Login Duenio: " + utilizarDuenioEnSesion.getLogin().getCodLogin());
        
        PreparedStatement pS = con.prepareStatement("SELECT CODEQUIPO FROM equipo WHERE codDuenio = ?");
        pS.setInt(1, utilizarDuenioEnSesion.getCodDuenio());    
        ResultSet rs = pS.executeQuery();
        while (rs.next()) {
            equ = new Equipo();
            equ.setCodEquipo(rs.getInt("CODEQUIPO"));
        }
        cerrarConexion(con);

        return equ;
    }

}
