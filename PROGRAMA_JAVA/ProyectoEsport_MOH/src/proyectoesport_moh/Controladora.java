/*
 * PROYECTO DAW 2017 - 2018
 */
package proyectoesport_moh;

import Exceptions.*;
import ModelUML.*;
import ModelBD.*;
import Views.*;
import Views.Administradores.*;
import Views.Duenios.*;
import Views.Equipos.*;
import Views.Jugadores.*;
import Views.Usuarios.*;
import Views.Jornada.VAltaJornadas;
import Views.Jornada.VBajaJornadas;
import Views.Jornada.VPanelCrudJornadas;
import java.sql.*;
import java.util.*;

/**
 * @author MIGUEL OLMO HERNANDO
 */
public class Controladora {

    /**
     * @param args the command line arguments
     */
    //VISTA MENU
    private static VHome vHo;

    // VISTA LOGIN
    private static VLogin vLo;

    // VISTAS ADMINISTRADOR
    private static VPanelAdministracion vpanelAdministracion;
    private static VPanelCrudAdministradores vpanelCrudAdministradores;
    private static VAltaAdmins vAltaAdmins;
    private static VBajaAdmins vBajaAdmins;
    private static VEditarAdmins vEditarAdmins;
    private static VConsultarAdmins vConsultarAdmins;

    // VISTAS USUARIOS
    private static VPanelUsuarios vpanelUsuarios;
    private static VPanelCrudUsuarios vpanelCrudUsuarios;
    private static VAltaUsuarios vAltaUsuarios;
    private static VBajaUsuarios vBajaUsuarios;
    private static VEditarUsuarios vEditarUsuarios;
    private static VConsultaUsuarios vConsultarUsuarios;

    //VISTAS DUENIOS
    private static VPanelDuenios vpanelDuenios;
    private static VPanelCrudDuenios vpanelCrudDuenios;
    private static VAltaDuenios vAltaDuenios;
    private static VBajaDuenios vBajaDuenios;
    private static VEditarDuenios vEditarDuenios;
    private static VConsultaDuenios vConsultarDuenios;

    // VISTAS JUGADORES
    private static VPanelCrudJugadores vpanelJugadores;
    private static VAltaJugadores vAltaJugadores;
    private static VBajaJugadores vBajaJugadores;
    private static VAltaJugadores vEditarJugadores;
    private static VConsultarJugadores vConsultarJugadores;

    // VISTAS EQUIPOS
    private static VPanelCrudEquipos vpanelCrudEquipos;
    private static VAltaEquipos vAltaEquipos;
    private static VBajaEquipos vBajaEquipos;
    private static VEditarEquipos vEditarEquipos;
    private static VConsultaEquipos vConsultarEquipos;

    // VISTAS JORNADAS
    private static VPanelCrudJornadas vpanelCrudJornadas;
    private static VAltaJornadas vAltaJornadas;
    private static VBajaJornadas vBajaJornadas;
    private static VConsultarJornadas vConsultarJornadas;

    // VISTAS PARTIDOS
    // DECLARACION DE OBJETOS
    // LOGIN
    private static Login loginUML;
    private static LoginBD loginBD;

    // ADMIN
    private static Administrador administradorUML;
    private static AdministradorBD administradorBD;

    // USER
    private static UsuarioBD usuarioBD;
    private static Usuario usuarioUML;

    // DUEÑO
    private static DuenioBD duenioBD;
    private static Duenio duenioUML;
    //private static ArrayList<Duenio> listaDuenios;

    // JUGADOR
    private static JugadorBD jugadorBD;
    private static Jugador jugadorUML;

    // EQUIPO
    private static EquipoBD equipoBD;
    private static Equipo equipoUML;

    // PARTIDO
    private static PartidoBD partidoBD;
    private static Partido partidoUML;

    // JORNADA
    private static JornadaBD jornadaBD;
    private static Jornada jornadaUML;

    public static void main(String[] args) {

        /// INICIO GENERICO DE VENTANAS
        // ABRIR INICIO MAIN
        abrirHome(vHo = new VHome());
    }

    // ABRIR HOME
    public static void abrirHome(VHome vHome) {
        vHo.setVisible(true);
        abrirInicioSesion();
    }

    // ABRIR VISTA LOGIN
    public static void abrirInicioSesion() {

        vLo = new VLogin();
        vLo.setVisible(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // APERTURA DE PANELES PARA EL MENU
    // ABRIR PANEL TIPO ADMINISTRADOR - A
    public static void abrirPanelAdministracion(VPanelAdministracion vpanelAdministracion) {
        vpanelAdministracion.setVisible(true);
    }

    // ABRIR PANEL TIPO USUARIO - U
    private static void abrirPanelUsuarios(VPanelUsuarios vpanelUsuarios) {
        vpanelUsuarios.setVisible(true);
    }

    // ABRIR PANEL TIPO DUENIO - D 
    private static void abrirPanelDuenios(VPanelDuenios vpanelDuenios) {
        vpanelDuenios.setVisible(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //ABRIR PANELES CRUD / ADMINISTRADORES / USUARIOS / DUENOS / JUGADORES / EQUIPOS
    //ABRIR PANEL CRUD ADMINISTRADORES
    public static void abrirCrudAdministradores() {
        vpanelCrudAdministradores = new VPanelCrudAdministradores();
        vpanelCrudAdministradores.setVisible(true);
    }

    // ABRIR PANEL CRUD USUARIOS
    public static void abrirCrudUsuarios() {
        vpanelCrudUsuarios = new VPanelCrudUsuarios();
        vpanelCrudUsuarios.setVisible(true);
    }

    // ABRIR PANEL CRUD DUENIOS
    public static void abrirCrudDuenios() {
        vpanelCrudDuenios = new VPanelCrudDuenios();
        vpanelCrudDuenios.setVisible(true);
    }

    // ABRIR PANEL CRUD JUGADORES
    public static void abrirCrudJugadores() {
        vpanelJugadores = new VPanelCrudJugadores();
        vpanelJugadores.setVisible(true);
    }

    // ABRIR PANEL CRUD EQUIPOS
    public static void abrirCrudEquipos() {
        vpanelCrudEquipos = new VPanelCrudEquipos();
        vpanelCrudEquipos.setVisible(true);
    }

    // ABRIR PANEL CRUD JORNADAS
    public static void abrirCrudJornadas() {
        vpanelCrudJornadas = new VPanelCrudJornadas();
        vpanelCrudJornadas.setVisible(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > ADMINISTRADORES 
    // ALTA ADMINS
    public static void VAltaAdmins() {
        vAltaAdmins = new VAltaAdmins();
        vAltaAdmins.setVisible(true);
    }

    // BAJA ADMINS
    public static void VBajaAdmins() {
        vBajaAdmins = new VBajaAdmins();
        vBajaAdmins.setVisible(true);
    }

    // CONSULTA ADMINS
    public static void VConsultaAdmins() {
        vConsultarAdmins = new VConsultarAdmins();
        vConsultarAdmins.setVisible(true);
    }

    // MODIFICA ADMINS
    public static void VModificaAdmins() {
        vEditarAdmins = new VEditarAdmins();
        vEditarAdmins.setVisible(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > USUARIOS
    // ALTA USUARIOS
    public static void VAltaUsuarios() {
        vAltaUsuarios = new VAltaUsuarios();
        vAltaUsuarios.setVisible(true);
    }

    // BAJA USUARIOS
    public static void VBajaUsuarios() {
        vBajaUsuarios = new VBajaUsuarios();
        vBajaUsuarios.setVisible(true);
    }

    // CONSULTA USUARIOS
    public static void VConsultaUsuarios() {
        vConsultarUsuarios = new VConsultaUsuarios();
        vConsultarUsuarios.setVisible(true);
    }

    // MODIFICA USUARIOS
    public static void VModificaUsuarios() {
        vEditarUsuarios = new VEditarUsuarios();
        vEditarUsuarios.setVisible(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > DUENIOS
    // ALTA DUENIOS
    public static void VAltaDuenios() {
        vAltaDuenios = new VAltaDuenios();
        vAltaDuenios.setVisible(true);
    }

    // BAJA DUENIOS
    public static void VBajaDuenios() {
        vBajaDuenios = new VBajaDuenios();
        vBajaDuenios.setVisible(true);
    }

    // CONSULTA DUENIOS
    public static void VConsultaDuenios() {
        vConsultarDuenios = new VConsultaDuenios();
        vConsultarDuenios.setVisible(true);
    }

    // MODIFICA DUENIOS
    public static void VModificaDuenios() {
        vEditarDuenios = new VEditarDuenios();
        vEditarDuenios.setVisible(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > JUGADORES
    // ALTA JUGADORES
    public static void VAltaJugadores() {
        vAltaJugadores = new VAltaJugadores();
        vAltaJugadores.setVisible(true);
    }

    // BAJA JUGADORES
    public static void VBajaJugadores() {
        vBajaJugadores = new VBajaJugadores();
        vBajaJugadores.setVisible(true);
    }

    // CONSULTA JUGADORES
    public static void VConsultaJugadores() {
        vConsultarJugadores = new VConsultarJugadores();
        vConsultarJugadores.setVisible(true);
    }

    // MODIFICA JUGADORES
    public static void VModificaJugadores() {
        vEditarJugadores = new VAltaJugadores();
        vEditarJugadores.setVisible(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > EQUIPOS
    // ALTA EQUIPOS
    public static void VAltaEquipos() throws SQLException, ConexionProblemas {
        DuenioBD duenioBD = new DuenioBD();
        vAltaEquipos = new VAltaEquipos(duenioBD.traerTodosLosDueniosBD());
        vAltaEquipos.setVisible(true);
    }

    // BAJA EQUIPOS
    public static void VBajaEquipos() {
        vBajaEquipos = new VBajaEquipos();
        vBajaEquipos.setVisible(true);
    }

    // CONSULTA EQUIPOS
    public static void VConsultaEquipos() {
        vConsultarEquipos = new VConsultaEquipos();
        vConsultarEquipos.setVisible(true);
    }

    // MODIFICA EQUIPOS
    public static void VModificaEquipos() {
        vEditarEquipos = new VEditarEquipos();
        vEditarEquipos.setVisible(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ABRIR PANELES GESTION / CALENDARIO / JORNADAS
    // ALTA JORNADA
    public static void ValtaJorandas() {
        vAltaJornadas = new VAltaJornadas();
        vAltaJornadas.setVisible(true);
    }

    // BAJA JORNADAS
    public static void VbajaJorandas() {
        vBajaJornadas = new VBajaJornadas();
        vBajaJornadas.setVisible(true);
    }

    //REINICIAR VISTA LOGIN
    public static void reiniciarVistaLogin() {
        vLo.dispose();
        abrirHome(vHo);
    }

    // SALIR DE LA APLICACION
    public static void salirAplicacion() {
        System.exit(0);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // CONTROL GENERICO DE VENTANAS
    // CERRAR VENTANAS ADMINISTRADORES
    public static void cierraTipoVentanas(String tipoVentana) throws Exception {
        switch (tipoVentana) {
            case "VPanelAdmins": {
                vpanelAdministracion.dispose();
                break;
            }
            case "VCrudAdmins": {
                vpanelCrudAdministradores.dispose();
                break;
            }
            case "VAltaAdmins": {
                vAltaAdmins.dispose();
                break;
            }
            case "VBajaAdmins": {
                vBajaAdmins.dispose();
                break;
            }
            case "VEditarAdmins": {
                vEditarAdmins.dispose();
                break;
            }
            case "VConsultarAdmins": {
                vConsultarAdmins.dispose();
                break;
            }
            case "VCrudDuenios": {
                vpanelCrudDuenios.dispose();
                break;
            }
            case "VAltaDuenios": {
                vAltaDuenios.dispose();
                break;
            }
            case "VBajaDuenios": {
                vBajaDuenios.dispose();
                break;
            }
            case "VConsultarDuenios": {
                vConsultarDuenios.dispose();
                break;
            }
            case "VEditarDuenios": {
                vEditarDuenios.dispose();
                break;
            }
            case "VCrudEquipos": {
                vpanelCrudEquipos.dispose();
                break;
            }
            case "VAltaEquipos": {
                vAltaEquipos.dispose();
                break;
            }
            case "VBajaEquipos": {
                vBajaEquipos.dispose();
                break;
            }
            case "VConsultarEquipos": {
                vConsultarEquipos.dispose();
                break;
            }
            case "VEditarEquipos": {
                vEditarEquipos.dispose();
                break;
            }
            case "VCrudUsuarios": {
                vpanelCrudUsuarios.dispose();
                break;
            }
            case "VAltaUsuarios": {
                vAltaUsuarios.dispose();
                break;
            }
            case "VBajaUsuarios": {
                vBajaUsuarios.dispose();
                break;
            }
            case "VConsultarUsuarios": {
                vConsultarUsuarios.dispose();
                break;
            }
            case "VEditarUsuarios": {
                vEditarUsuarios.dispose();
                break;
            }
            case "VCrudJornadas": {
                vpanelCrudJornadas.dispose();
                break;
            }
            case "VAltaJornadas": {
                vAltaJornadas.dispose();
                break;
            }
            case "VBajaJornadas": {
                vBajaJornadas.dispose();
                break;
            }
            case "VConsultarJornadas": {
                vConsultarJornadas.dispose();
                break;
            }
            default:
                System.err.println("Error critico en el cierre de las ventanas");
                throw new CierreVError();
        }
    }

    // ABRIR TIPO VENTANAS ADMINISTRADORES              
    // CERRAR VENTANA
    public static void abreTipoVentanas(String tipoVentana) throws Exception {
        switch (tipoVentana) {
            case "VCrudAdmins": {
                vpanelAdministracion.setVisible(true);
                break;
            }
            case "VAltaAdmins": {
                vpanelCrudAdministradores.setVisible(true);
                break;
            }
            case "VBajaAdmins": {
                vpanelCrudAdministradores.setVisible(true);
                break;
            }
            case "VEditarAdmins": {
                vpanelCrudAdministradores.setVisible(true);
                break;
            }
            case "VConsultarAdmins": {
                vpanelCrudAdministradores.setVisible(true);
                break;
            }
            case "VCrudDuenios": {
                vpanelAdministracion.setVisible(true);
                break;
            }
            case "VAltaDuenios": {
                vpanelCrudDuenios.setVisible(true);
                break;
            }
            case "VBajaDuenios": {
                vpanelCrudDuenios.setVisible(true);
                break;
            }
            case "VConsultarDuenios": {
                vpanelCrudDuenios.setVisible(true);
                break;
            }
            case "VEditarDuenios": {
                vpanelCrudDuenios.setVisible(true);
                break;
            }
            case "VCrudEquipos": {
                vpanelAdministracion.setVisible(true);
                break;
            }
            case "VAltaEquipos": {
                vpanelCrudEquipos.setVisible(true);
                break;
            }
            case "VBajaEquipos": {
                vpanelCrudEquipos.setVisible(true);
                break;
            }
            case "VConsultarEquipos": {
                vpanelCrudEquipos.setVisible(true);
                break;
            }
            case "VEditarEquipos": {
                vpanelCrudEquipos.setVisible(true);
                break;
            }
            case "VCrudUsuarios": {
                vpanelAdministracion.setVisible(true);
                break;
            }
            case "VAltaUsuarios": {
                vpanelCrudUsuarios.setVisible(true);
                break;
            }
            case "VBajaUsuarios": {
                vpanelCrudUsuarios.setVisible(true);
                break;
            }
            case "VConsultarUsuarios": {
                vpanelCrudUsuarios.setVisible(true);
                break;
            }
            case "VEditarUsuarios": {
                vpanelCrudUsuarios.setVisible(true);
                break;
            }
            case "VCrudJornadas": {
                vpanelAdministracion.setVisible(true);
                break;
            }
            case "VAltaJornadas": {
                vpanelCrudJornadas.setVisible(true);
                break;
            }
            case "VBajaJornadas": {
                vpanelCrudJornadas.setVisible(true);
                break;
            }
            case "VConsultarJornadas": {
                vpanelCrudJornadas.setVisible(true);
                break;
            }
            default:
                System.err.println("Error critico en la apertura de las ventanas");
                throw new AbreVError();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //CONSULTA PARA SOLICITAR ACCESO
    public static void consultarLogin(String usuario, String password) throws Exception {

        loginBD = new LoginBD();

        loginUML = new Login(usuario, password);

        Login usuarioLogeado = loginBD.validarLogin(loginUML);

        System.out.println("Acceso Login como Tipo: " + usuarioLogeado.getTipo());

        cargarPanelTipo(usuarioLogeado.getTipo());

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // MENU DE CARGA SEGUN EL TIPO DE LOGIN
    public static void cargarPanelTipo(String tipo) throws Exception {

        switch (tipo.toUpperCase()) {
            case "A":
                vpanelAdministracion = new VPanelAdministracion();
                vLo.dispose();
                abrirPanelAdministracion(vpanelAdministracion);
                break;
            case "D":
                vpanelDuenios = new VPanelDuenios();
                vLo.dispose();
                abrirPanelDuenios(vpanelDuenios);
                break;
            case "U":
                vpanelUsuarios = new VPanelUsuarios();
                vLo.dispose();
                abrirPanelUsuarios(vpanelUsuarios);
                break;
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > ADMINISTRADOR
    // ALTA
    public static void altaAdministradorBD(String dni, String nombre, String apellido, String tipo) throws Exception {
        administradorBD = new AdministradorBD();
        administradorUML = new Administrador(dni, nombre, apellido);
        administradorBD.insertarAdministradorBD(administradorUML, tipo);
    }

    // LOCALIZA
    public static void localizarAdministradorEnBD(String tipoVentana, String dni) throws Exception {
        switch (tipoVentana) {
            case "VBajaAdmins": {
                administradorBD = new AdministradorBD();
                administradorUML = administradorBD.localizarAdministrador(dni);
                vBajaAdmins.rellenarCamposVentana(administradorUML.getDni(), administradorUML.getNombre(), administradorUML.getApellido(), administradorUML.getLogin().getCodLogin());
                break;
            }
            case "VConsultarAdmins": {
                administradorBD = new AdministradorBD();
                administradorUML = administradorBD.localizarAdministrador(dni);
                vConsultarAdmins.rellenarCamposVentana(administradorUML.getDni(), administradorUML.getNombre(), administradorUML.getApellido());
                break;
            }
            case "VEditarAdmins": {
                administradorBD = new AdministradorBD();
                administradorUML = administradorBD.localizarAdministrador(dni);
                vEditarAdmins.rellenarCamposVentana(administradorUML.getDni(), administradorUML.getNombre(), administradorUML.getApellido(), administradorUML.getLogin().getUser(), administradorUML.getLogin().getPassword());
                break;
            }
            default:
                System.err.println("Error critico en el CRUD de Administradores");
                throw new AdminCRUDError();
        }
    }

    // BAJA
    public static void eliminarAdministradorDelaBD(String dni, Integer codLogin) throws SQLException, ConexionProblemas {
        administradorBD = new AdministradorBD();
        loginBD = new LoginBD();

        administradorBD.eliminarDeLaBDAdmin(dni);
        loginBD.eliminarDeLaBDAdminLog(codLogin);
    }

    // EDITAR
    public static void pedirActualizarAdministrador(String passwd) throws SQLException, ConexionProblemas {
        loginUML.setPassword(passwd);
        loginBD.ejecutarModificacionLog(loginUML.getPassword(), administradorUML.getLogin().getCodLogin());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > USUARIO
    // ALTA
    public static void altaUsuarioBD(String dni, String nombre, String apellido, String tipo) throws Exception {
        usuarioBD = new UsuarioBD();
        Usuario usuario = new Usuario(dni, nombre, apellido);
        usuarioBD.insertarUsuarioBD(usuario, tipo);
    }

    // LOCALIZA
    public static void localizarUsuarioEnBD(String tipoVentana, String dni) throws Exception {
        switch (tipoVentana) {
            case "VBajaUsuarios": {
                usuarioBD = new UsuarioBD();
                usuarioUML = usuarioBD.localizarUsuario(dni);
                vBajaUsuarios.rellenarCamposVentana(usuarioUML.getDni(), usuarioUML.getNombre(), usuarioUML.getApellido(), usuarioUML.getLogin().getCodLogin());
                break;
            }
            case "VConsultarUsuarios": {
                usuarioBD = new UsuarioBD();
                usuarioUML = usuarioBD.localizarUsuario(dni);
                vConsultarUsuarios.rellenarCamposVentana(usuarioUML.getDni(), usuarioUML.getNombre(), usuarioUML.getApellido(), usuarioUML.getLogin().getUser(), usuarioUML.getLogin().getPassword());
                break;
            }
            case "VEditarUsuarios": {
                usuarioBD = new UsuarioBD();
                usuarioUML = usuarioBD.localizarUsuario(dni);
                vEditarUsuarios.rellenarCamposVentana(usuarioUML.getDni(), usuarioUML.getNombre(), usuarioUML.getApellido(), usuarioUML.getLogin().getUser(), usuarioUML.getLogin().getPassword());
                break;
            }
            default:
                System.err.println("Error critico en el CRUD de Usuarios");
                throw new UsuarioCRUDError();
        }
    }

    // EDITAR
    public static void pedirActualizarUsuario(String passwd) throws SQLException, ConexionProblemas {
        loginUML.setPassword(passwd);
        loginBD.ejecutarModificacionLog(loginUML.getPassword(), duenioUML.getLogin().getCodLogin());
    }

    // BAJA
    public static void eliminarUsuarioDelaBD(String dni) {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > DUENIO
    // ALTA
    public static void altaDuenioBD(String dni, String nombre, String apellido, String tipo) throws Exception {
        duenioBD = new DuenioBD();
        duenioUML = new Duenio(dni, nombre, apellido);
        duenioBD.insertarDuenioBD(duenioUML, tipo);
    }

    // LOCALIZA
    public static void localizarDuenioEnBD(String tipoVentana, String dni) throws Exception {
        switch (tipoVentana) {
            case "VBajaDuenios": {
                duenioBD = new DuenioBD();
                duenioUML = duenioBD.localizarDuenio(dni);
                vBajaDuenios.rellenarCamposVentana(duenioUML.getDni(), duenioUML.getNombre(), duenioUML.getApellido(), duenioUML.getLogin().getCodLogin());
                break;
            }
            case "VConsultarDuenios": {
                duenioBD = new DuenioBD();
                duenioUML = duenioBD.localizarDuenio(dni);
                vConsultarDuenios.rellenarCamposVentana(duenioUML.getDni(), duenioUML.getNombre(), duenioUML.getApellido());
                break;
            }
            case "VEditarDuenios": {
                duenioBD = new DuenioBD();
                duenioUML = duenioBD.localizarDuenio(dni);
                vEditarDuenios.rellenarCamposVentana(duenioUML.getDni(), duenioUML.getNombre(), duenioUML.getApellido(), duenioUML.getLogin().getUser(), duenioUML.getLogin().getPassword());
                break;
            }
            default:
                System.err.println("Error critico en el CRUD de Dueños");
                throw new DuenioCRUDError();
        }
    }

    // EDITAR
    public static void pedirActualizarDuenio(String passwd) throws SQLException, ConexionProblemas {
        loginUML.setPassword(passwd);
        loginBD.ejecutarModificacionLog(loginUML.getPassword(), duenioUML.getLogin().getCodLogin());
    }

    // BAJA
    public static void eliminarDuenioDelaBD(String dni, Integer codLogin) throws SQLException, ConexionProblemas {
        duenioBD = new DuenioBD();
        loginBD = new LoginBD();

        duenioBD.eliminarDeLaBDDuenio(dni);
        loginBD.eliminarDeLaBDDuenioLog(codLogin);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > JUGADOR
    public static void localizarJugadorEnBD(String dni) throws Exception {
        jugadorBD = new JugadorBD();
        Jugador jugador = jugadorBD.localizaJugador(dni);

        //JOptionPane.showMessageDialog(null, jugador.getFechaNacimiento());
        vBajaJugadores.rellenarCamposVentana(jugador.getDni(), jugador.getNombre(), jugador.getApellido(), jugador.getNickname(), jugador.getSueldo(), jugador.getFechaNacimiento(), jugador.getNacionalidad(), jugador.getPosicion());
    }

    public static void eliminarJugadorDelaBD(String dni) {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > EQUIPO
    // ALTA
    public static void altaEquipoBD(String nombre, String presupuesto, String anioFundacion, String ciudad, String nombreEstadio, String dniDuenio) throws Exception {
        equipoBD = new EquipoBD();
        Duenio duenio = duenioBD.localizarDuenio(dniDuenio);
        equipoUML = new Equipo(nombre, Double.parseDouble(presupuesto), anioFundacion, ciudad, nombreEstadio,duenio);
        equipoBD.insertarEquipoBD(equipoUML);
    }

    // LOCALIZA
    public static void localizarEquipoEnBD(String tipoVentana, String nombre) throws Exception {
        switch (tipoVentana) {
            case "VBajaEquipos": {
                equipoBD = new EquipoBD();
                equipoUML = equipoBD.localizarEquipo(nombre);
                vBajaEquipos.rellenarCamposVentana(equipoUML.getNombre(), equipoUML.getPresupuesto(), equipoUML.getAnioFundacion(), equipoUML.getCiudad(), equipoUML.getNombreEstadio());
                break;
            }
            case "VConsultarEquipos": {
                equipoBD = new EquipoBD();
                equipoUML = equipoBD.localizarEquipo(nombre);
                vConsultarEquipos.rellenarCamposVentana(equipoUML.getNombre(), equipoUML.getPresupuesto(), equipoUML.getAnioFundacion(), equipoUML.getCiudad(), equipoUML.getNombreEstadio(), equipoUML.getDuenio().getDni());
                break;
            }
            case "VEditarEquipos": {
                equipoBD = new EquipoBD();
                equipoUML = equipoBD.localizarEquipo(nombre);
                vEditarEquipos.rellenarCamposVentana(equipoUML.getNombre(), equipoUML.getPresupuesto(), equipoUML.getAnioFundacion(), equipoUML.getCiudad(), equipoUML.getNombreEstadio());
                break;
            }
            default:
                System.err.println("Error critico en el CRUD de Equipos");
                throw new DuenioCRUDError();
        }
    }

    // EDITAR
    public static void pedirActualizarEquipo(String nombre, String ciudad, String estadio) throws SQLException, ConexionProblemas {
        equipoBD = new EquipoBD();
        equipoBD.ejecutarModificacionBDEquipo(nombre, ciudad, estadio);
    }

    // BAJA
    public static void eliminarEquipoDelaBD(String nombre) throws SQLException, ConexionProblemas {
        equipoBD = new EquipoBD();
        equipoBD.eliminarDeLaBDEquipo(nombre);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > PARTIDO
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA > JORNADA
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ALTA
    public static void generarJornadas(String numeroTemporada) throws Exception {
        equipoBD = new EquipoBD();
        jornadaBD = new JornadaBD();

        ArrayList<Equipo> listaEquipos = equipoBD.getAllEquipos();
        System.out.println("Arraylist : " + listaEquipos.size());

        int[] listacodEquipos = new int[listaEquipos.size()];

        for (int i = 0; i < listacodEquipos.length; i++) {
            listacodEquipos[i] = listaEquipos.get(i).getCodEquipo();
        }
        int N = listacodEquipos.length;
        System.out.println("array: " + listacodEquipos.length);
        String[][] matriz1, matriz2, jornadas, jornadas2;

        matriz1 = new String[N - 1][N / 2];
        matriz2 = new String[N - 1][N / 2];
        jornadas = new String[N - 1][N / 2]; //primera vuelta
        jornadas2 = new String[N - 1][N / 2]; //segunda vuelta

        int cont = 0;
        int cont2 = N - 2;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N / 2; j++) {
                //matriz1
                matriz1[i][j] = String.valueOf(listacodEquipos[cont]);
                cont++;
                if (cont == (N - 1)) {
                    cont = 0;
                }

                //matriz2
                if (j == 0) {
                    matriz2[i][j] = String.valueOf(N);
                } else {
                    matriz2[i][j] = String.valueOf(listacodEquipos[cont2]);
                    cont2--;
                    if (cont2 == -1) {
                        cont2 = N - 2;
                    }
                }

                //Elaboro la matriz final de enfrentamientos por jornada (primera vuelta)
                if (j == 0) {
                    if (i % 2 == 0) {
                        jornadas[i][j] = matriz2[i][j] + "-" + matriz1[i][j];
                    } else {
                        jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j];
                    }
                } else {
                    jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j];
                }

                //segunda vuelta - al reves que la primera
                if (j == 0) {
                    if (i % 2 == 0) {
                        jornadas2[i][j] = matriz1[i][j] + "-" + matriz2[i][j];
                    } else {
                        jornadas2[i][j] = matriz2[i][j] + "-" + matriz1[i][j];
                    }
                } else {
                    jornadas2[i][j] = matriz2[i][j] + "-" + matriz1[i][j];
                }

            }
        }

        jornadaBD.insertJornadas(jornadas, jornadas2, numeroTemporada, N);

    }

    // LOCALIZA
    public static void localizarTemporadaEnJornadaBD(String tipoVentana, String numTemporada) throws Exception, TempNoExiste {
        switch (tipoVentana) {
            case "VBajaJornadas": {
                jornadaBD = new JornadaBD();
                Boolean existe = jornadaBD.localizarTemporadaEnJornadaBD(numTemporada);
               
                if (existe) {
                    vBajaJornadas.mensajeRespuesta("Existe temporada introducida");
                    vBajaJornadas.actibarBotonTrasRespuesta();
                }                 
                break;
            }
            case "VConsultarJornadas": {
                jornadaBD = new JornadaBD();
                jornadaUML = administradorBD.localizarAdministrador(nombre);
                vConsultarJornadas.rellenarCamposVentana(administradorUML.getDni(), administradorUML.getNombre(), administradorUML.getApellido());
                break;
            }
            default:
                System.err.println("Error critico en el CRUD de Jornadas");
                throw new JornadaCRUDError();
        }

        /* LOCALIZAR
    public static void localizarTemporadaEnJornadaBD(String numTemporada) {
        jornadaBD.localizarTemporadaEnJornadaBD(numTemporada);
    }*/
    
    }
}
