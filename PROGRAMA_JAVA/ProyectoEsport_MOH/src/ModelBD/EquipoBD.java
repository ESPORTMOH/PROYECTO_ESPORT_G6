package ModelBD;

import Exceptions.DuenioNoExiste;
import Exceptions.EquipoNoExiste;
import ModelUML.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author MIGUEL
 */
public class EquipoBD {

    private Connection con;
    
    public Equipo localizaEquipo(String nombre) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        Equipo equipo = new Equipo();

        String consultaSQL = "SELECT codEquipo, nombre, presupuesto, anioFundacion, ciudad, nombreEstadio FROM equipo WHERE nombre = ? and anioFundacion = ?";
        

        PreparedStatement pS = con.prepareStatement(consultaSQL);

        pS.setString(1, nombre.toUpperCase());
        pS.setString(1, anioFundacion.toUpperCase());

        try (ResultSet datosRS = pS.executeQuery()) {
            if (!datosRS.next()) {
                throw new EquipoNoExiste();
            } else {

                equipo.setCodEquipo(datosRS.getInt("codEquipo"));
                equipo.setNombre(datosRS.getString("nombre"));
               /* equipo.setPresupuesto
                equipo.setAnioFundacion
                equipo.setCiudad(datosRS.getString
                equipo.setNombreEstadio(datosRS.getString
*/
                
            }
        }

        con.close();

        return equipo;

    }
