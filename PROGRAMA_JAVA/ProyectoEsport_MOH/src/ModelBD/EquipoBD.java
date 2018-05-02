package ModelBD;

import ModelUML.*;
import Exceptions.EquipoNoExiste;

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

        String consultaSQL = "SELECT codEquipo, dni, nombre, apellido, codLogin FROM equipo WHERE nombre = ?";
        
        PreparedStatement pS=con.prepareStatement(consultaSQL);

        pS.setString(1, nombre.toUpperCase());

        try (ResultSet datosRS = pS.executeQuery()) {
            if (!datosRS.next()) {
                throw new EquipoNoExiste();
            } else {
                equipo.setCodEquipo(datosRS.getInt("codEquipo"));
                equipo.setNombre(datosRS.getString("nombre"));
                equipo.setPresupuesto(datosRS.getInt("presupuesto"));
                equipo.setAnioFundacion(datosRS.getString("anioFundacion"));
                equipo.setCiudad(datosRS.getString("ciudad"));
                equipo.setNombreEstadio(datosRS.getString("nombreEstadio"));
                
            }
        }
        con.close();
        return equipo;

    }
    
    
    
}


    
   
