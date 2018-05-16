package ModelBD;

import Exceptions.ConexionProblemas;
import ModelUML.*;
import Exceptions.JugadorNoExiste;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author MIGUEL
 */
public class JugadorBD extends GenericoBD {

    private Connection con;

    // INSERTAR JUGADOR
    public void insertarJugadorEnBD(Jugador jugador) throws SQLException, ConexionProblemas {
        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("INSERT INTO jugador (dni, nombre, apellido, nickname, sueldo, fechanacimiento, nacionalidad, posicion, codequipo) VALUES (?,?,?,?,?,?,?,?,?)");
        pS.setString(1, jugador.getDni().toUpperCase());
        pS.setString(2, jugador.getNombre());
        pS.setString(3, jugador.getApellido());
        pS.setString(4, jugador.getNickname());
        pS.setDouble(5, jugador.getSueldo());
        pS.setDate(6, new java.sql.Date(jugador.getFechaNacimiento().getTime()));
        pS.setString(7, jugador.getNacionalidad());
        pS.setString(8, jugador.getPosicion());
        
        pS.setInt(9, (jugador.getEquipo() != null ? jugador.getEquipo().getCodEquipo() : 41));
        pS.executeUpdate();

        cerrarConexion(con);
    }

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

            //jugador.setEquipo(new Equipo(datosRS.getInt("codEquipo")));
        }

        con.close();
        return jugador;

    }

    public ArrayList<Jugador> getAllJugadorEnBD() throws SQLException, ConexionProblemas {
        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        ArrayList<Jugador> listaJugadores = new ArrayList();
        String consultaSQL = "SELECT * FROM jugador";

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(consultaSQL);
        while (rs.next()) {
            Jugador ju = new Jugador();

            ju.setCodJugador(rs.getInt("CODJUGADOR"));
            ju.setDni(rs.getString("DNI"));
            ju.setNombre(rs.getString("NOMBRE"));
            ju.setApellido(rs.getString("APELLIDO"));
            ju.setNickname(rs.getString("NICKNAME"));
            ju.setSueldo(rs.getDouble("SUELDO"));
            ju.setFechaNacimiento(rs.getDate("FECHANACIMIENTO"));
            ju.setNacionalidad(rs.getString("NACIONALIDAD"));
            ju.setPosicion(rs.getString("POSICION"));
            //ju.setEquipo(new Equipo(rs.getInt("CODEQUIPO")));

            listaJugadores.add(ju);
        }

        con.close();

        return listaJugadores;

    }

    // LOCALIZAR TODOS LOS DUENIOS PARA RELLENAR EL COMBO EN EQUIPO / ALTA
    public ArrayList traerTodosLosJuagdoresBD() throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        ArrayList<Jugador> listaJugadores = new ArrayList();

        try {

            CallableStatement cS = con.prepareCall("{call ESPORT_MOH_2.PROCE_rellenarcomboJugadores(?)}");

            // CADENA DEVUELTA POR EL CURSOR
            cS.registerOutParameter(1, OracleTypes.CURSOR);

            // EJECUTO EL PROCEDIMIENTO
            cS.execute();
            ResultSet rS = (ResultSet) cS.getObject(1);

            if (rS.next()) {
                do {
                    Jugador jUg = new Jugador();
                    jUg.setDni(rS.getString("dni"));
                    jUg.setNombre(rS.getString("nombre"));
                    jUg.setApellido(rS.getString("apellido"));
                    jUg.setSueldo(rS.getDouble("sueldo"));

                    listaJugadores.add(jUg);
                } while (rS.next());
            } else {
                System.out.println("No hay nada");
            }

            cerrarConexion(con);
        } catch (Exception e) {
            System.out.println(e);

        }

        return listaJugadores;
    }

}
