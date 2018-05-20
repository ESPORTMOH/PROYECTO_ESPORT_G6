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
        
        PreparedStatement pS = con.prepareStatement("INSERT INTO partido (FECHAPARTIDO, PUNTOSLOCAL, PUNTOSVISITANTE, CODLOCAL, CODVISITANTE, CODJORNADA) VALUES (?,?,?,?,?,?)");
        pS.setDate(1, new java.sql.Date(partido.getFechaPartido().getTime()));
        pS.setInt(2, partido.getPuntosLocal());
        pS.setInt(3, partido.getPuntosVisitante());
        pS.setInt(4, partido.getCodLocal().getCodEquipo());
        pS.setInt(5, partido.getCodVisitante().getCodEquipo());
        pS.setInt(6, partido.getCodJornada().getCodJornada());
        
         pS.executeUpdate();
        
    }
    
}
