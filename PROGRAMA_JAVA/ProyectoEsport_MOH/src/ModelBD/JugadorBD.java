package ModelBD;

import ModelUML.*;
import Exceptions.JugadorNoExiste;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MIGUEL
 */
public class JugadorBD {

    private Connection con;

    public Jugador localizaJugador(String dni) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        Jugador jugador = new Jugador();

        String consultaSQL = "SELECT codJugador, dni, nombre, apellido, nickname, sueldo, fechaNacimiento, nacionalidad, posicion, codEquipo FROM jugador WHERE dni = ?";

        PreparedStatement pS = con.prepareStatement(consultaSQL);

        pS.setString(1, dni.toUpperCase());

        ResultSet datosRS = pS.executeQuery();
        if (!datosRS.next()) {
            throw new JugadorNoExiste();
        } else {

            jugador.setCodJugador(datosRS.getInt("codJugador"));
            jugador.setDni(datosRS.getString("dni"));
            jugador.setNombre(datosRS.getString("nombre"));
            jugador.setApellido(datosRS.getString("apellido"));
            jugador.setNickname(datosRS.getString("nickname"));

            jugador.setSueldo(datosRS.getDouble("sueldo"));

            jugador.setFechaNacimiento((datosRS.getDate("fechaNacimiento")));

            jugador.setNacionalidad(datosRS.getString("nacionalidad"));
            jugador.setPosicion(datosRS.getString("posicion"));

            jugador.setEquipo(new Equipo(datosRS.getInt("codEquipo")));
        }

        con.close();
        return jugador;

    }

}
