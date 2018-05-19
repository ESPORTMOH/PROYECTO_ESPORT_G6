package ModelBD;

import Exceptions.ConexionProblemas;
import ModelUML.Partido;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

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

}
