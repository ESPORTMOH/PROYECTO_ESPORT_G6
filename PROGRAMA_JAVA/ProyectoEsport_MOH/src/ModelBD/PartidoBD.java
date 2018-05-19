package ModelBD;

import Exceptions.ConexionProblemas;
import ModelUML.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MIGUEL OLMO HERNANDO
 */
public class PartidoBD extends GenericoBD{
    
    private Connection con;
    /**
     * INSERTAR RESULTADOS
     * 
     * @param partido
     * @throws SQLException
     * @throws ConexionProblemas 
     */
    public void insertarResultados(Partido partido) throws SQLException, ConexionProblemas {
        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);
        
        PreparedStatement pS = con.prepareStatement("INSERT INTO partido (FECHAPARTIDO, HORAINICIO, PUNTOSLOCAL, PUNTOSVISITANTE, CODLOCAL, CODVISITANTE, CODJORNADA) VALUES (?,?,?,?,?,?,?)");
        pS.setDate(1, new java.sql.Date(partido.getFechaPartido().getTime()));
        pS.setDate(2, new java.sql.Date(partido.getHoraInicio().getTime()));
        pS.setInt(3, partido.getPuntosLocal());
        pS.setInt(4, partido.getPuntosVisitante());
        pS.setInt(5, partido.getCodLocal().getCodEquipo());
        pS.setInt(6, partido.getCodVisitante().getCodEquipo());
        pS.setInt(7, partido.getCodJornada().getCodJornada());
        
         pS.executeUpdate();
        
    }
    
}
