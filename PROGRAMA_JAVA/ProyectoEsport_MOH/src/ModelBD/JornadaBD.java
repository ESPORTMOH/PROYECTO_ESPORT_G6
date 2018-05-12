/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBD;

import Exceptions.ConexionProblemas;
import Exceptions.TempNoExiste;
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
    
    public void insertJornadas(String[][] jornadas, String[][] jornadas2, String numeroTemporada, int numeroEquipos) throws SQLException, ConexionProblemas {
        
        int jorn = 1;
        for(int i=0;i<numeroEquipos-1;i++){
                for(int j=0;j<numeroEquipos/2;j++){

                    GenericoBD genericoBD = new GenericoBD();
                    con = genericoBD.abrirConexion(con);

                    PreparedStatement pS = con.prepareStatement("INSERT INTO jornada (NUMEROJORNADA, NUMEROTEMPORADA, CODEQUIPOLOCAL, CODEQUIPOVISITANTE) VALUES (?,?,?,?)");
                    pS.setString(1, "J"+jorn);
                    pS.setString(2, numeroTemporada);
                    String[] parts = jornadas[i][j].split("-");
                    pS.setInt(3, Integer.parseInt(parts[0]));
                    pS.setInt(4, Integer.parseInt(parts[1]));
                    pS.executeUpdate();

                     cerrarConexion(con);
                }
                jorn++;
        }

        jorn = numeroEquipos;
        for(int i=0;i<numeroEquipos-1;i++){
                for(int j=0;j<numeroEquipos/2;j++){

                    GenericoBD genericoBD = new GenericoBD();
                    con = genericoBD.abrirConexion(con);

                    PreparedStatement pS = con.prepareStatement("INSERT INTO jornada (NUMEROJORNADA, NUMEROTEMPORADA, CODEQUIPOLOCAL, CODEQUIPOVISITANTE) VALUES (?,?,?,?)");
                    pS.setString(1, "J"+jorn);
                    pS.setString(2, numeroTemporada);
                    String[] parts = jornadas2[i][j].split("-");
                    pS.setInt(3, Integer.parseInt(parts[0]));
                    pS.setInt(4, Integer.parseInt(parts[1]));
                    pS.executeUpdate();

                     cerrarConexion(con);
                }
                jorn++;
        }

    }

    public void localizarTemporadaEnJornadaBD(String numTemporada) throws SQLException, ConexionProblemas {
         GenericoBD genericoBD = new GenericoBD();
                    con = genericoBD.abrirConexion(con);

                    PreparedStatement pS = con.prepareStatement("select count(*) from jornada where NUMEROTEMPORADA=?");
                    pS.setString(1, numTemporada.toUpperCase());

                     ResultSet datosRS = pS.executeQuery();
                    
                    if (!datosRS.next()) {
                         int numberOfRows = datosRS.getInt(1);
        System.out.println("existe temporada: " + numberOfRows);
      } else {
        System.err.println("eer");
      }
            
                     cerrarConexion(con);
    }
    
}
