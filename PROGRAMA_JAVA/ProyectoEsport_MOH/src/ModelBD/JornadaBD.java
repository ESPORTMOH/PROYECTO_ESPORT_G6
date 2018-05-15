package ModelBD;

import Exceptions.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MIGUEL
 */
public class JornadaBD extends GenericoBD{

    private Connection con;

    // INSERTAR JORNADA
    public void insertJornadas(String[][] jornadas, String[][] jornadas2, String numeroTemporada, int numeroEquipos) throws SQLException, ConexionProblemas {

        int jorn = 1;
        for (int i = 0; i < numeroEquipos - 1; i++) {
            for (int j = 0; j < numeroEquipos / 2; j++) {

                GenericoBD genericoBD = new GenericoBD();
                con = genericoBD.abrirConexion(con);

                PreparedStatement pS = con.prepareStatement("INSERT INTO jornada (numerojornada, numerotemporada, codequipolocal, codequipovisitante) VALUES (?,?,?,?)");
                pS.setString(1, "J" + jorn);
                pS.setString(2, numeroTemporada.toUpperCase());
                String[] parts = jornadas[i][j].split("-");
                pS.setInt(3, Integer.parseInt(parts[0]));
                pS.setInt(4, Integer.parseInt(parts[1]));
                pS.executeUpdate();

                cerrarConexion(con);
        
            }
            jorn++;
        }

        jorn = numeroEquipos;
        for (int i = 0; i < numeroEquipos - 1; i++) {
            for (int j = 0; j < numeroEquipos / 2; j++) {

                GenericoBD genericoBD = new GenericoBD();
                con = genericoBD.abrirConexion(con);

                PreparedStatement pS = con.prepareStatement("INSERT INTO jornada (numerojornada, numerotemporada, codequipolocal, codequipovisitante) VALUES (?,?,?,?)");
                pS.setString(1, "J" + jorn);
                pS.setString(2, numeroTemporada.toUpperCase());
                String[] parts = jornadas2[i][j].split("-");
                pS.setInt(3, Integer.parseInt(parts[0]));
                pS.setInt(4, Integer.parseInt(parts[1]));
                pS.executeUpdate();

                cerrarConexion(con);
            }
            jorn++;
        }
    }

    // LOCALIZAR JORNADA
    public Boolean localizarTemporadaEnJornadaBD(String numTemporada) throws SQLException, ConexionProblemas, TemporadaNoExiste {
        Boolean respuesta = false;
        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("select count(*) from jornada where numerotemporada=?");
        pS.setString(1, numTemporada.toUpperCase());

        ResultSet datosRS = pS.executeQuery();

        if (datosRS.next()) {

            int numberOfRows = datosRS.getInt(1);
                if (numberOfRows != 0) {
                    respuesta = true;
                    System.out.println("existe temporada: " + numberOfRows);
                }else{
                    throw new TemporadaNoExiste();
                }
            }  
        cerrarConexion(con);

        return respuesta;
    }
    

}
