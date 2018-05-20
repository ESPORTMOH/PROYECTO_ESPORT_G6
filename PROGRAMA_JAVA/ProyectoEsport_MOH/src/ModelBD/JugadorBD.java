package ModelBD;

import Exceptions.ConexionProblemas;
import ModelUML.*;
import Exceptions.JugadorNoExiste;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author MIGUEL OLMO HERNANDO
 */
public class JugadorBD extends GenericoBD {

    private Connection con;

    /**
     * COMPROBACION EXISTE O NO PARA DAR DE ALTA O NO
     *
     * @param dni
     * @return localizado
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public boolean localizarSiexixteDniJugador(String dni) throws SQLException, ConexionProblemas {
        Boolean localizado = false;
        int records;

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("SELECT COUNT(1) FROM jugador WHERE dni = ?");
        pS.setString(1, dni);

        ResultSet datosRS = pS.executeQuery();
        if (datosRS.next()) {
            records = datosRS.getInt(1);
            if (records > 0) {
                localizado = true;
            }
        }
        cerrarConexion(con);
        return localizado;
    }

    /**
     * INSERTAR JUGADOR
     *
     * @param jugador
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public void insertarJugadorEnBD(Jugador jugador) throws SQLException, ConexionProblemas {
        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("INSERT INTO jugador (dni, nombre, apellido, nickname, sueldo, fechanacimiento, nacionalidad, posicion, estado, codequipo) VALUES (?,?,?,?,?,?,?,?,0,1)");
        pS.setString(1, jugador.getDni().toUpperCase());
        pS.setString(2, jugador.getNombre());
        pS.setString(3, jugador.getApellido());
        pS.setString(4, jugador.getNickname());
        pS.setDouble(5, jugador.getSueldo());
        pS.setDate(6, new java.sql.Date(jugador.getFechaNacimiento().getTime()));
        pS.setString(7, jugador.getNacionalidad());
        pS.setString(8, jugador.getPosicion());
        System.out.println(pS.getParameterMetaData().toString());
        pS.executeUpdate();

        cerrarConexion(con);
    }

    /**
     * LOCALIZAR JUGADOR
     *
     * @param dni
     * @return jugador
     * @throws SQLException
     * @throws Exception
     */
    public Jugador localizarJugador(String dni) throws SQLException, Exception {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        Jugador jugador = new Jugador();

        String consultaSQL = "SELECT codJugador, dni, nombre, apellido, nickname, sueldo, fechaNacimiento, nacionalidad, posicion, estado, codEquipo FROM jugador WHERE dni = ?";

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
            jugador.setFechaNacimiento(datosRS.getDate("fechaNacimiento"));
            jugador.setNacionalidad(datosRS.getString("nacionalidad"));
            jugador.setPosicion(datosRS.getString("posicion"));
            jugador.setEstado(datosRS.getInt("estado"));
            jugador.setEquipo(new Equipo(datosRS.getInt("codEquipo")));

        }

        cerrarConexion(con);

        return jugador;
    }

    /**
     * LOCALIZAR TODOS LOS JUGADORES PARA RELLENAR EL COMBO EN EQUIPO / ALTA
     *
     * @return
     * @throws SQLException
     * @throws ConexionProblemas
     */
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
        cerrarConexion(con);
        return listaJugadores;
    }

    /**
     * EDITAR JUGADOR
     *
     * @param jugador
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public void editarJugadorEnBD(Jugador jugador) throws SQLException, ConexionProblemas {

        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("UPDATE jugador SET nacionalidad = ?, posicion = ? WHERE dni = ? ");

        pS.setString(1, jugador.getNacionalidad());
        pS.setString(2, jugador.getPosicion());
        pS.setString(3, jugador.getDni());

        pS.executeUpdate();

        cerrarConexion(con);
    }

    /**
     * ELIMINAR JUGADOR
     *
     * @param dni
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public void eliminarJugadorDelaBD(String dni) throws SQLException, ConexionProblemas {
        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("DELETE FROM JUGADOR WHERE dni = ? ");
        pS.setString(1, dni);

        pS.executeUpdate();

        cerrarConexion(con);
    }

    /**
     * ACTUALIZAR DATOS
     *
     * @param jugador
     * @param equipo
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public void actualizarDatosJugador(Jugador jugador, Equipo equipo) throws SQLException, ConexionProblemas {
        GenericoBD genericoBD = new GenericoBD();
        con = genericoBD.abrirConexion(con);

        PreparedStatement pS = con.prepareStatement("UPDATE jugador SET estado = 1 , codEquipo = ? WHERE codJugador = ?");
        pS.setInt(1, equipo.getCodEquipo());
        pS.setInt(2, jugador.getCodJugador());

        pS.executeUpdate();

        cerrarConexion(con);

    }

}
