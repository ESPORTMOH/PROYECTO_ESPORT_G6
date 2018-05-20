package ModelBD;

import Exceptions.ClasiNoExiste;
import Exceptions.ConexionProblemas;
import ModelUML.Clasificacion;
import ModelUML.Equipo;
import ModelUML.Partido;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MIGUEL OLMO HERNANDO
 */
public class ClasificacionBD extends GenericoBD {

    private Connection con;

    /**
     * INSERTAR RESULTADOS
     *
     * @param partido
     * @param temporada
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public void insertarResultados(Partido partido, String temporada) throws SQLException, ConexionProblemas {
        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        CallableStatement cS = con.prepareCall("{call actualizarClasificacion(?,?,?,?,?)}");
        cS.setInt(1, partido.getPuntosLocal());
        cS.setInt(2, partido.getPuntosVisitante());
        cS.setInt(3, partido.getCodLocal().getCodEquipo());
        cS.setInt(4, partido.getCodVisitante().getCodEquipo());
        cS.setString(5, temporada);

        cS.execute();

        cerrarConexion(con);

    }

    public void crearClasificacion(ArrayList<Equipo> listaEquipos, String nT) throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();

        for (int i = 0; i < listaEquipos.size(); i++) {

            con = genericoBD.abrirConexion(con);

            PreparedStatement pS = con.prepareStatement("INSERT INTO clasificacion (CODEQUIPO, PUNTOS, NUMEROTEMPORADA) VALUES (?,?,?) ");

            pS.setInt(1, listaEquipos.get(i).getCodEquipo());
            pS.setInt(2, 0);
            pS.setString(3, nT);

            pS.executeUpdate();

            cerrarConexion(con);

        }
    }

    public ArrayList<Clasificacion> traerClasificacion(String temporada) throws SQLException, ConexionProblemas, ClasiNoExiste {
        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        ArrayList<Clasificacion> listaCP = new ArrayList();

        System.out.println("Parametro de temporada es:  "+temporada);
        //SELECT e.NOMBRE, c.PUNTOS FROM clasificacion c, equipo e WHERE e.codequipo = c.codequipo AND c.numerotemporada = ? ORDER BY PUNTOS DESC
       
        PreparedStatement pS = con.prepareStatement("SELECT e.NOMBRE, c.PUNTOS FROM clasificacion c, equipo e WHERE e.codequipo = c.codequipo AND c.numerotemporada = ? ORDER BY PUNTOS DESC");
        pS.setString(1, temporada);

        ResultSet datosRS = pS.executeQuery();

        while (datosRS.next()) {
            Clasificacion cl = new Clasificacion();
            Equipo e = new Equipo();
            e.setNombre(datosRS.getString("nombre"));
            cl.setEquipo(e);
            cl.setPuntos(datosRS.getInt("puntos"));
            listaCP.add(cl);
        }

        cerrarConexion(con);

        return listaCP;
    }

}
