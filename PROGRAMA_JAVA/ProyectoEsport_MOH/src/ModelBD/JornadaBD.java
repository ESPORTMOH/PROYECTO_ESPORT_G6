package ModelBD;

import Exceptions.*;
import ModelUML.Equipo;
import ModelUML.Jornada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MIGUEL OLMO HERNANDO
 */
public class JornadaBD extends GenericoBD {

    private Connection con;

    /**
     * INSERTAR JORNADA
     *
     * @param jornadas
     * @param jornadas2
     * @param numeroTemporada
     * @param numeroEquipos
     * @throws SQLException
     * @throws ConexionProblemas
     */
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

    /**
     * LOCALIZAR JORNADA
     *
     * @param numTemporada
     * @return respuesta
     * @throws SQLException
     * @throws ConexionProblemas
     * @throws TemporadaNoExiste
     */
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
            } else {
                throw new TemporadaNoExiste();
            }
        }
        cerrarConexion(con);

        return respuesta;
    }

    /**
     * LOCALIZAR JORNADA
     *
     * @param temporada
     * @param numeroJornada
     * @param equipoLocal
     * @param equipoVisitantendex
     * @return jornada
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public Jornada localizarCodJornada(String temporada, String numeroJornada, Equipo equipoLocal, Equipo equipoVisitantendex) throws SQLException, ConexionProblemas {
        Jornada jornada = new Jornada();

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("SELECT CODJORNADA FROM jornada WHERE CODEQUIPOLOCAL = ? AND  CODEQUIPOVISITANTE = ? AND NUMEROJORNADA = ? AND NUMEROTEMPORADA = ?");
        pS.setInt(1, equipoLocal.getCodEquipo());
        pS.setInt(2, equipoVisitantendex.getCodEquipo());
        pS.setString(3, numeroJornada.toUpperCase());
        pS.setString(4, temporada.toUpperCase());

        ResultSet datosRS = pS.executeQuery();
        if (!datosRS.next()) {
            System.out.println("Jornada no localizada");
        } else {
            jornada.setCodJornada(datosRS.getInt("codjornada"));
        }

        cerrarConexion(con);
        return jornada;
    }

}
