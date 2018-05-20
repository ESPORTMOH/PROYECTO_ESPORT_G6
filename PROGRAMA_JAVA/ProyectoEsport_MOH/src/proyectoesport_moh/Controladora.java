package proyectoesport_moh;

import Exceptions.*;
import ModelUML.*;
import ModelBD.*;
import Views.*;
import Views.Administradores.*;
import Views.Clasificacion.*;
import Views.Duenios.*;
import Views.Equipos.*;
import Views.Jugadores.*;
import Views.Usuarios.*;
import Views.Jornada.*;
import Views.Partido.VPartido;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author MIGUEL OLMO HERNANDO
 * @proyect_name PROYECTO DAW 2017 - 2018 - GRUPO 6
 * @version Fase 4 v10
 * @since 2018
 */
public class Controladora {

    /**
     * INICIO DECLARACION DE OBJETOS PARA LAS VISTAS
     *
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
    private static VJornadas vJornadas;

    //VISTAS DUENIOS
    private static VPanelDuenios vpanelDuenios;
    private static VPanelCrudDuenios vpanelCrudDuenios;
    private static VAltaDuenios vAltaDuenios;
    private static VBajaDuenios vBajaDuenios;
    private static VEditarDuenios vEditarDuenios;
    private static VConsultaDuenios vConsultarDuenios;
    private static VUltimaJornada vultimaJornada;
    private static VUltimaClasificacion vultimaClasificacion;
    private static Duenio duenioLogeado;

    // VISTAS JUGADORES
    private static VPanelCrudJugadores vpanelCrudJugadores;
    private static VAltaJugadores vAltaJugadores;
    private static VBajaJugadores vBajaJugadores;
    private static VEditarJugadores vEditarJugadores;
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

    // VISTAS FICHAJES
    private static VFichajes vFichajes;

    // VISTAS PARTIDOS
    private static VPartido vPartido;

    // VISTAS CLASIFICACION
    private static VPanelClasificacion vpanelClasificacion;
    private static VAltaClasificacion vAltaClasificacion;
    private static VConsultaClasificacion vConsultaClasificacion;

    /**
     * INICIO DECLARACION DE OBJETOS UML / BD
     *
     */
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

    // CLASIFICACION
    private static ClasificacionBD clasificacionBD;
    private static Clasificacion clasificacionUML;

    /**
     * @param args
     */
    /// INICIO MAIN
    public static void main(String[] args) {

        /**
         * INICIO GENERICO DE LAS VENTANAS DE INICIO / RESET / SALIDA DE LA
         * APLICACION
         *
         */
        // 
        abrirHome(vHo = new VHome());
    }

    /**
     * ABRIR HOME
     *
     * @param vHome
     */
    public static void abrirHome(VHome vHome) {
        vHo.setVisible(true);
        abrirInicioSesion();
    }

    /**
     * ABRIR VISTA LOGIN
     */
    public static void abrirInicioSesion() {
        vLo = new VLogin();
        vLo.setVisible(true);
    }

    /**
     * REINICIAR VISTA LOGIN
     */
    public static void reiniciarVistaLogin() {
        vLo.dispose();
        abrirHome(vHo);
    }

    /**
     * SALIR DE LA APLICACION
     */
    public static void salirAplicacion() {
        System.exit(0);
    }

    /**
     * INICIO APERTURA DE PANELES PARA EL MENU SEGUN EL LOGEO APLICACION
     *
     * ABRIR PANEL TIPO ADMINISTRADOR - A
     *
     * @param vpanelAdministracion
     *
     */
    public static void abrirPanelAdministracion(VPanelAdministracion vpanelAdministracion) {
        vpanelAdministracion.setVisible(true);
    }

    /**
     * ABRIR PANEL TIPO USUARIO - U
     *
     * @param vpanelUsuarios
     */
    private static void abrirPanelUsuarios(VPanelUsuarios vpanelUsuarios) {
        vpanelUsuarios.setVisible(true);
    }

    /**
     * ABRIR PANEL TIPO DUENIO - D
     *
     * @param vpanelDuenios
     */
    private static void abrirPanelDuenios(VPanelDuenios vpanelDuenios) {
        vpanelDuenios.setVisible(true);
    }

    /**
     * INICIO ABRIR PANELES / CRUD > ADMINISTRADORES / USUARIOS / DUENOS /
     * JUGADORES / EQUIPOS / VISTAS VARIAS
     *
     */
    // ABRIR PANEL CRUD ADMINISTRADORES
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
        vpanelCrudJugadores = new VPanelCrudJugadores();
        vpanelCrudJugadores.setVisible(true);
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

    // ABRIR PANEL FICHAJES
    public static void abrirFichajes() {
        vFichajes = new VFichajes();
        vFichajes.setVisible(true);
    }

    public static void reiniciarVistaFichaje() {
        vFichajes.dispose();
        abrirFichajes();
    }

    // ABRIR VISTA ULTIMA JORNADA
    public static void abrirUltimaJornada() {
        vultimaJornada = new VUltimaJornada();
        vultimaJornada.setVisible(true);
    }

    // ABRIR VISTA ULTIMA CLASIFICACION
    public static void abrirUltimaClasi() {
        vultimaClasificacion = new VUltimaClasificacion();
        vultimaClasificacion.setVisible(true);
    }

    // ABRIR VISTA ULTIMA JORNADA
    public static void abrirJornadas() {
        vJornadas = new VJornadas();
        vJornadas.setVisible(true);
    }

    // ABRIR PANEL REGISTRAR PUNTOS PARTIDOS
    public static void abrirPanelPartidosPuntos() throws Exception {
        equipoBD = new EquipoBD();
        vPartido = new VPartido(equipoBD.getAllEquipos());
        vPartido.setVisible(true);
    }

    // ABRIR PANEL CLASIFICACION            
    public static void abrirPanelClasificacion() {
        vpanelClasificacion = new VPanelClasificacion();
        vpanelClasificacion.setVisible(true);
    }

    /**
     * INICIO ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION >
     * ADMINISTRADORES
     */
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

    /**
     * INICIO ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > USUARIOS
     */
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

    /**
     * INICIO ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > DUENIOS
     */
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

    /**
     * INICIO ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > JUGADORES
     */
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
        vEditarJugadores = new VEditarJugadores();
        vEditarJugadores.setVisible(true);
    }

    /**
     * INICIO ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > EQUIPOS
     *
     * ALTA EQUIPOS
     *
     * @throws java.sql.SQLException
     * @throws Exceptions.ConexionProblemas
     */
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

    /**
     * INICIO ABRIR PANELES GESTION / CALENDARIO > JORNADAS
     */
    // ALTA JORNADA
    public static void ValtaJorandas() {
        vAltaJornadas = new VAltaJornadas();
        vAltaJornadas.setVisible(true);
    }



    /**
     * FIN ABRIR PANELES GESTION / CALENDARIO > JORNADAS
     *
     */
    /**
     * INICIO ABRIR PANELES GESTION / CLASIFICACION
     *
     */
    // ABRIR ALTA CLASIFICACION            
    public static void abrirAltaClasificacion() {
        vAltaClasificacion = new VAltaClasificacion();
        vAltaClasificacion.setVisible(true);
    }

    // ABRIR CONSULTA CLASIFICACION            
    public static void abrirConsultaClasificacion() {
        vConsultaClasificacion = new VConsultaClasificacion();
        vConsultaClasificacion.setVisible(true);
    }

    /**
     * INICIO CONTROL GENERICO DE VENTANAS > CERRADO DE VENTANAS
     *
     * @param tipoVentana
     * @throws Exception
     *
     */
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
            case "VCrudJugadores": {
                vpanelCrudJugadores.dispose();
                break;
            }
            case "VAltaJugadores": {
                vAltaJugadores.dispose();
                break;
            }
            case "VBajaJugadores": {
                vBajaJugadores.dispose();
                break;
            }
            case "VConsultarJugadores": {
                vConsultarJugadores.dispose();
                break;
            }
            case "VEditarJugadores": {
                vEditarJugadores.dispose();
                break;
            }
            case "vPanelDuenios": {
                vpanelDuenios.dispose();
                break;
            }
            case "VFichajes": {
                vFichajes.dispose();
                break;
            }
            case "VUltimaJornada": {
                vultimaJornada.dispose();
                break;
            }
            case "VUltimaClasificacion": {
                vultimaClasificacion.dispose();
                break;
            }
            case "vPanelUsuarios": {
                vpanelUsuarios.dispose();
                break;
            }
            case "VJornadas": {
                vJornadas.dispose();
                break;
            }
            case "VPartidos": {
                vPartido.dispose();
                break;
            }
            case "VPanelClasificacion": {
                vpanelClasificacion.dispose();
                break;
            }
            case "VAltaClasificacion": {
                vAltaClasificacion.dispose();
                break;
            }
            case "VConsultarClasificacion": {
                vConsultaClasificacion.dispose();
                break;
            }

            default:
                System.err.println("Error critico en el cierre de las ventanas");
                throw new CierreVError();
        }
    }

    /**
     * INICIO CONTROL GENERICO DE VENTANAS > APERTURA DE VENTANAS
     *
     * @param tipoVentana
     * @throws Exception
     *
     */
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
            case "VCrudJugadores": {
                vpanelAdministracion.setVisible(true);
                break;
            }
            case "VAltaJugadores": {
                vpanelCrudJugadores.setVisible(true);
                break;
            }
            case "VBajaJugadores": {
                vpanelCrudJugadores.setVisible(true);
                break;
            }
            case "VConsultarJugadores": {
                vpanelCrudJugadores.setVisible(true);
                break;
            }

            case "VEditarJugadores": {
                vpanelCrudJugadores.setVisible(true);
                break;
            }
            case "VFichajes": {
                vpanelDuenios.setVisible(true);
                break;
            }
            case "VUltimaJornada": {
                vpanelDuenios.setVisible(true);
                break;
            }
            case "VUltimaClasificacion": {
                vpanelDuenios.setVisible(true);
                break;
            }
            case "VJornadas": {
                vpanelUsuarios.setVisible(true);
                break;
            }
            case "VClasificaciones": {
                vpanelUsuarios.setVisible(true);
                break;
            }
            case "VPartidos": {
                vpanelAdministracion.setVisible(true);
                break;
            }
            case "VAltaClasificacion": {
                vpanelClasificacion.setVisible(true);
                break;
            }
            case "VBajaClasificacion": {
                vpanelClasificacion.setVisible(true);
                break;
            }
            case "VConsultarClasificacion": {
                vpanelClasificacion.setVisible(true);
                break;
            }
            case "VPanelClasificacion": {
                vpanelAdministracion.setVisible(true);
                break;
            }
            default:
                System.err.println("Error critico en la apertura de las ventanas");
                throw new AbreVError();
        }
    }

    /**
     * INICIO CONSULTA PARA SOLICITAR ACCESO
     *
     * @param usuario
     * @param password
     * @throws Exception
     *
     */
    public static void consultarLogin(String usuario, String password) throws Exception {

        loginBD = new LoginBD();

        loginUML = new Login(usuario, password);

        Login usuarioLogeado = loginBD.validarLogin(loginUML);

        System.out.println("Acceso Login como Tipo: " + usuarioLogeado.getTipo());

        cargarPanelTipo(usuarioLogeado.getTipo(), usuarioLogeado.getCodLogin());
    }

    /**
     * INICIO MENU DE CARGA SEGUN EL TIPO DE LOGIN
     *
     * @param tipo
     * @param codLogin
     * @throws Exception
     *
     */
    public static void cargarPanelTipo(String tipo, Integer codLogin) throws Exception {

        switch (tipo.toUpperCase()) {
            case "A":
                vpanelAdministracion = new VPanelAdministracion();
                vLo.dispose();
                abrirPanelAdministracion(vpanelAdministracion);
                break;
            case "D":
                guardarDuenioEnSesion(buscarDatosDeDuenio(codLogin));
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

    /**
     * INICIO SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > ADMINISTRADOR
     *
     * ALTA
     *
     * @param dni
     * @param nombre
     * @param apellido
     * @param tipo
     * @throws Exception, SQLException, ConexionProblemas
     *
     */
    public static void altaAdministradorBD(String dni, String nombre, String apellido, String tipo) throws Exception {
        administradorBD = new AdministradorBD();
        administradorUML = new Administrador(dni, nombre, apellido);
        administradorBD.insertarAdministradorBD(administradorUML, tipo);
    }

    /**
     * LOCALIZA
     *
     * @param tipoVentana
     * @param dni
     * @throws Exception
     */
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
                vConsultarAdmins.rellenarCamposVentana(administradorUML.getDni(), administradorUML.getNombre(), administradorUML.getApellido(), administradorUML.getLogin().getUser(), administradorUML.getLogin().getPassword());
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

    /**
     * BAJA
     *
     * @param dni
     * @param codLogin
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static void eliminarAdministradorDelaBD(String dni, Integer codLogin) throws SQLException, ConexionProblemas {
        administradorBD = new AdministradorBD();
        loginBD = new LoginBD();

        administradorBD.eliminarDeLaBDAdmin(dni);
        loginBD.eliminarDeLaBDAdminLog(codLogin);
    }

    /**
     * EDITAR
     *
     * @param passwd
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static void pedirActualizarAdministrador(String passwd) throws SQLException, ConexionProblemas {
        loginUML.setPassword(passwd);
        loginBD.ejecutarModificacionLog(loginUML.getPassword(), administradorUML.getLogin().getCodLogin());
    }

    /**
     * INICIO SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > USUARIO
     *
     * ALTA
     *
     * @param dni
     * @param nombre
     * @param tipo
     * @param apellido
     * @throws Exception, SQLException, ConexionProblemas
     *
     */
    public static void altaUsuarioBD(String dni, String nombre, String apellido, String tipo) throws Exception {
        usuarioBD = new UsuarioBD();
        Usuario usuario = new Usuario(dni, nombre, apellido);
        usuarioBD.insertarUsuarioBD(usuario, tipo);
    }

    /**
     * LOCALIZA
     *
     * @param tipoVentana
     * @param dni
     * @throws Exception
     */
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

    /**
     * EDITAR
     *
     * @param passwd
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static void pedirActualizarUsuario(String passwd) throws SQLException, ConexionProblemas {
        loginUML.setPassword(passwd);
        loginBD.ejecutarModificacionLog(loginUML.getPassword(), usuarioUML.getLogin().getCodLogin());
    }

    /**
     * BAJA
     *
     * @param dni
     * @param codLogin
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static void eliminarUsuarioDelaBD(String dni, Integer codLogin) throws SQLException, ConexionProblemas {
        usuarioBD = new UsuarioBD();
        loginBD = new LoginBD();

        usuarioBD.eliminarUsuarioDelaBD(dni);
        loginBD.eliminarDeLaBDUsuarioLog(codLogin);
    }

    /**
     * INICIO SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > DUENIO
     *
     * ALTA
     *
     * @param dni
     * @param nombre
     * @param apellido
     * @parama pellido
     * @param tipo
     * @param estado
     * @throws Exception
     *
     */
    public static void altaDuenioBD(String dni, String nombre, String apellido, String tipo, Integer estado) throws Exception {
        duenioBD = new DuenioBD();
        duenioUML = new Duenio(dni, nombre, apellido, estado);
        duenioBD.insertarDuenioBD(duenioUML, tipo);
    }

    /**
     * LOCALIZA
     *
     * @param tipoVentana
     * @param dni
     * @throws Exception
     */
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
                vConsultarDuenios.rellenarCamposVentana(duenioUML.getDni(), duenioUML.getNombre(), duenioUML.getApellido(), duenioUML.getLogin().getUser(), duenioUML.getLogin().getPassword(), duenioUML.getEstado());
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

    /**
     * EDITAR
     *
     * @param passwd
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static void pedirActualizarDuenio(String passwd) throws SQLException, ConexionProblemas {
        loginUML.setPassword(passwd);
        loginBD.ejecutarModificacionLog(loginUML.getPassword(), duenioUML.getLogin().getCodLogin());
    }

    /**
     * BAJA
     *
     * @param dni
     * @param codLogin
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static void eliminarDuenioDelaBD(String dni, Integer codLogin) throws SQLException, ConexionProblemas {
        duenioBD = new DuenioBD();
        loginBD = new LoginBD();

        duenioBD.eliminarDeLaBDDuenio(dni);
        loginBD.eliminarDeLaBDDuenioLog(codLogin);
    }

    /**
     * INICIO SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > JUGADOR
     *
     * ALTA
     *
     * @param dni
     * @param nombre
     * @param apellido
     * @param sueldo
     * @param nickname
     * @param fechaNacimiento
     * @param nacionalidad
     * @param posicion
     * @param estado
     * @throws Exception
     *
     */
    public static void pedirInsertarJugadorBD(String dni, String nombre, String apellido, String nickname, String sueldo, Date fechaNacimiento, String nacionalidad, String posicion, Integer estado) throws Exception {

        jugadorBD = new JugadorBD();
        //DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        //Date fnacimiento = formatter.parse(fechaNacimiento);

        jugadorUML = new Jugador(dni, nombre, apellido, nickname, Double.parseDouble(sueldo), fechaNacimiento, nacionalidad, posicion, estado);
        jugadorBD.insertarJugadorEnBD(jugadorUML);

    }

    /**
     * LOCALIZA
     *
     * @param tipoVentana
     * @param dni
     * @throws Exception
     */
    public static void localizarJugadorEnBD(String tipoVentana, String dni) throws Exception {
        switch (tipoVentana) {
            case "VBajaJugadores": {
                jugadorBD = new JugadorBD();
                jugadorUML = jugadorBD.localizarJugador(dni);
                vBajaJugadores.rellenarCamposVentana(jugadorUML.getDni(), jugadorUML.getNombre(), jugadorUML.getApellido(), jugadorUML.getNickname(), jugadorUML.getSueldo(), jugadorUML.getFechaNacimiento(), jugadorUML.getNacionalidad(), jugadorUML.getPosicion());
                break;
            }
            case "VConsultarJugadores": {
                jugadorBD = new JugadorBD();
                jugadorUML = jugadorBD.localizarJugador(dni);
                vConsultarJugadores.rellenarCamposVentana(jugadorUML.getDni(), jugadorUML.getNombre(), jugadorUML.getApellido(), jugadorUML.getNickname(), jugadorUML.getSueldo(), jugadorUML.getFechaNacimiento(), jugadorUML.getNacionalidad(), jugadorUML.getPosicion(), jugadorUML.getEstado());
                break;
            }
            case "VEditarJugadores": {
                jugadorBD = new JugadorBD();
                jugadorUML = jugadorBD.localizarJugador(dni);
                vEditarJugadores.rellenarCamposVentana(jugadorUML.getDni(), jugadorUML.getNombre(), jugadorUML.getApellido(), jugadorUML.getNickname(), jugadorUML.getSueldo(), jugadorUML.getFechaNacimiento(), jugadorUML.getNacionalidad(), jugadorUML.getPosicion());
                break;
            }
            default:
                System.err.println("Error critico en el CRUD de Jugadores");
                throw new JugadorCRUDError();
        }
    }

    /**
     * EDITA
     *
     * @param dni
     * @param nacionalidad
     * @param posicion
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static void pedirEditarJugador(String dni, String nacionalidad, String posicion) throws SQLException, ConexionProblemas {
        jugadorBD = new JugadorBD();
        Jugador jugador = new Jugador();
        jugador.setDni(dni);
        jugador.setNacionalidad(nacionalidad);
        jugador.setPosicion(posicion);
        jugadorBD.editarJugadorEnBD(jugador);
    }

    /**
     * BAJA
     *
     * @param dni
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static void pedirEliminarJugadorDelaBD(String dni) throws SQLException, ConexionProblemas {
        jugadorBD = new JugadorBD();
        jugadorBD.eliminarJugadorDelaBD(dni);
    }

    /**
     * INICIO SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > EQUIPO
     *
     * ALTA
     *
     * @param nombre
     * @param presupuesto
     * @param nombreEstadio
     * @param ciudad
     * @param anioFundacion
     * @param dniDuenio
     * @throws Exception
     *
     */
    public static void altaEquipoBD(String nombre, String presupuesto, String anioFundacion, String ciudad, String nombreEstadio, String dniDuenio) throws Exception {
        equipoBD = new EquipoBD();
        duenioBD = new DuenioBD();
        //split
        String[] dniDue = dniDuenio.split(" ");
        Duenio duenio = duenioBD.localizarDuenio(dniDue[0]);
        equipoUML = new Equipo(nombre, Double.parseDouble(presupuesto), anioFundacion, ciudad, nombreEstadio, duenio);
        equipoBD.insertarEquipoBD(equipoUML);
        duenioBD.actualizarEstadoDuenio(duenio);
    }

    /**
     * LOCALIZA
     *
     * @param tipoVentana
     * @param nombre
     * @throws Exception
     */
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
                vConsultarEquipos.rellenarCamposVentana(equipoUML.getNombre(), equipoUML.getPresupuesto(), equipoUML.getAnioFundacion(), equipoUML.getCiudad(), equipoUML.getNombreEstadio(), equipoUML.getDuenio().getDni(), equipoUML.getDuenio().getNombre());
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

    /**
     * EDITAR
     *
     * @param nombre
     * @param ciudad
     * @param estadio
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static void pedirActualizarEquipo(String nombre, String ciudad, String estadio) throws SQLException, ConexionProblemas {
        equipoBD = new EquipoBD();
        equipoBD.ejecutarModificacionBDEquipo(nombre, ciudad, estadio);
    }

    /**
     * BAJA
     *
     * @param nombre
     * @throws SQLException
     * @throws ConexionProblemas
     * @throws Exception
     */
    public static void eliminarEquipoDelaBD(String nombre) throws SQLException, ConexionProblemas, Exception {
        equipoBD = new EquipoBD();
        duenioBD = new DuenioBD();
        Equipo equipo = equipoBD.localizarEquipo(nombre);
        Duenio duenio = new Duenio();
        duenio.setCodDuenio(equipo.getDuenio().getCodDuenio());
        duenioBD.cambiarEstadoDuenio(duenio);
        equipoBD.eliminarDeLaBDEquipo(nombre);
    }

    /**
     * FICHAJES PARA EL EQUIPO
     *
     * @return ArrayList
     * @throws SQLException
     * @throws Exceptions.ConexionProblemas
     */
    public static ArrayList<Jugador> consultarJugadoresParaCombo() throws SQLException, ConexionProblemas {
        JugadorBD jugadorBD = new JugadorBD();
        return jugadorBD.traerTodosLosJuagdoresBD();
    }

    /**
     * SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > PARTIDO
     *
     * @param temporada
     * @param jornada
     * @param fechaPartido
     * @param equipoLocal
     * @param puntosLocal
     * @param equipoVisitantendex
     * @param puntosVisitante
     * @throws java.lang.Exception
     */
    public static void registrarDatosDelPartido(String temporada, String jornada, Date fechaPartido, String equipoLocal, String puntosLocal, String equipoVisitantendex, String puntosVisitante) throws Exception {
        equipoBD = new EquipoBD();
        jornadaBD = new JornadaBD();
        partidoBD = new PartidoBD();
        clasificacionBD = new ClasificacionBD();

        Equipo local = equipoBD.localizarEquipo(equipoLocal);
        Equipo visitante = equipoBD.localizarEquipo(equipoVisitantendex);

//        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
//       Date horaInicio = sdf.parse(horaPratido);
        Partido partido = new Partido(
                fechaPartido,
                Integer.parseInt(puntosLocal),
                Integer.parseInt(puntosVisitante),
                local,
                visitante,
                jornadaBD.localizarCodJornada(temporada, jornada, local, visitante));

        partidoBD.insertarResultados(partido);
        clasificacionBD.insertarResultados(partido, temporada);

    }

    /**
     * INICIO SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > JORNADA
     *
     * ALTA
     *
     * @param numeroTemporada
     * @throws Exception
     */
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
        jornadas = new String[N - 1][N / 2]; // PRIMERA VUELTA 
        jornadas2 = new String[N - 1][N / 2]; // SEGUNDA VUELTA

        int cont = 0;
        int cont2 = N - 2;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N / 2; j++) {
                // MATRIZ 1
                matriz1[i][j] = String.valueOf(listacodEquipos[cont]);
                cont++;
                if (cont == (N - 1)) {
                    cont = 0;
                }

                //MATRIZ 2
                if (j == 0) {
                    matriz2[i][j] = String.valueOf(N);
                } else {
                    matriz2[i][j] = String.valueOf(listacodEquipos[cont2]);
                    cont2--;
                    if (cont2 == -1) {
                        cont2 = N - 2;
                    }
                }

                // ELABORO LA MATRIZ FINAL DE ENFRENTAMIENTOS POR JORNADA
                // PRIMERA VUELTA
                if (j == 0) {
                    if (i % 2 == 0) {
                        jornadas[i][j] = matriz2[i][j] + "-" + matriz1[i][j];
                    } else {
                        jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j];
                    }
                } else {
                    jornadas[i][j] = matriz1[i][j] + "-" + matriz2[i][j];
                }

                // SEGUNDA VUELTA - AL REVES
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

    /**
     * INICIO LOCALIZAR PARA CONFIRMAR SI EXISTE Y BORRAR A POSTERIORI SI SE
     * DESEA
     *
     * @param tipoVentana
     * @param numTemporada
     * @throws Exception, SQLException
     * @throws Exceptions.TempNoExiste
     */
    public static void pedirLocalizarTemporada(String tipoVentana, String numTemporada) throws Exception, TempNoExiste {
        switch (tipoVentana) {
            case "VBajaJornadas": {
                jornadaBD = new JornadaBD();
                Boolean existe = jornadaBD.localizarTemporadaEnJornadaBD(numTemporada);

                if (existe) {
                    //vBajaJornadas.mensajeRespuesta("Existe temporada introducida");
                    //vBajaJornadas.actibarBotonTrasRespuesta();
                }
                break;
            }
            case "VConsultarJornadas": {
                jornadaBD = new JornadaBD();
                //jornadaUML = jornadaBD.localizarTemporadaEnJornadaBD(numTemporada);
                //vConsultarJornadas.rellenarCamposVentana();
                break;
            }
            default:
                System.err.println("Error critico en el CRUD de Jornadas");
                throw new JornadaCRUDError();
        }

    }

    /**
     * SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > CLASIFICACION
     *
     * @param nT
     * @throws Exception
     */
    public static void crearClasificcion(String nT) throws Exception {

        equipoBD = new EquipoBD();
        ClasificacionBD clasificacionBD = new ClasificacionBD();
        ArrayList<Equipo> listaEquipos = equipoBD.getAllEquipos();
        clasificacionBD.crearClasificacion(listaEquipos, nT);

    }

    /**
     * INICIO VALIDACIONES
     *
     * VALIDAR DNI
     *
     * @param dni
     * @return booblean
     */
    public static boolean validarNIF(String dni) {
        boolean correcto = false;
        Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher matcher = pattern.matcher(dni);

        if (matcher.matches()) {
            String letra = matcher.group(2);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int index = Integer.parseInt(matcher.group(1));
            index = index % 23;
            String reference = letras.substring(index, index + 1);
            if (reference.equalsIgnoreCase(letra)) {
                correcto = true;
            } else {
                correcto = false;
            }
        } else {
            correcto = false;
        }
        return correcto;
    }

    /**
     * LOCALIZAR EN LA BD PARA EL DNI ADMIN
     *
     * @param dni String
     * @return boolean
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static boolean localizarSiexixteDniAdmin(String dni) throws SQLException, ConexionProblemas {
        administradorBD = new AdministradorBD();
        return administradorBD.localizarSiexixteDniAdmin(dni);
    }

    /**
     * LOCALIZAR EN LA BD PARA EL DNI DUENIOS
     *
     * @param dni String
     * @return boolean
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static boolean localizarSiexixteDniDuenios(String dni) throws SQLException, ConexionProblemas {
        duenioBD = new DuenioBD();
        return duenioBD.localizarSiexixteDniDuenio(dni);
    }

    /**
     * LOCALIZAR EN LA BD PARA EL DNI USUARIOS
     *
     * @param dni String
     * @return boolean
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static boolean localizarSiexixteDniUsuarios(String dni) throws SQLException, ConexionProblemas {
        usuarioBD = new UsuarioBD();
        return usuarioBD.localizarSiexixteDniUsuario(dni);
    }

    /**
     * LOCALIZAR EN LA BD PARA EL DNI JUGADOR
     *
     * @param dni String
     * @return boolean
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static boolean localizarSiexixteDniJugador(String dni) throws SQLException, ConexionProblemas {
        jugadorBD = new JugadorBD();
        return jugadorBD.localizarSiexixteDniJugador(dni);
    }

    public static ArrayList<Duenio> consultarDueniosParaCombo() throws SQLException, ConexionProblemas {
        DuenioBD duenioBD = new DuenioBD();
        return duenioBD.traerTodosLosDueniosBD();
    }

    /**
     * GUARDAR EL DUENIO EN UNA VARIABLE
     *
     * @param duenio
     */
    public static void guardarDuenioEnSesion(Duenio duenio) {
        duenioLogeado = duenio;
    }

    /**
     *
     * @return duenioLogeado
     */
    public static Duenio utilizarDuenioEnSesion() {
        return duenioLogeado;
    }

    /**
     * NOS DEVOLVERA EL DUENO LOGEADO
     *
     * @param codLogin
     * @return duenioBD.recopilarDatosDuenio(duenio);
     * @throws SQLException
     * @throws ConexionProblemas
     */
    public static Duenio buscarDatosDeDuenio(Integer codLogin) throws SQLException, ConexionProblemas {
        duenioBD = new DuenioBD();
        Duenio duenio = new Duenio();
        duenio.setLogin(new Login(codLogin));
        return duenioBD.recopilarDatosDuenio(duenio);
    }

    /**
     * REALIZAR FICHAJE Nos traemos la seleccion del combo y extraemos el dni
     * para la busqueda
     *
     * @param nombre
     * @throws Exception
     */
    public static void realizarFichaje(String nombre) throws Exception {
        jugadorBD = new JugadorBD();
        equipoBD = new EquipoBD();
        String[] partes = nombre.split(" ");
        Jugador jugador = jugadorBD.localizarJugador(partes[0]);
        Equipo equipo = equipoBD.recogerDatosEquipo(utilizarDuenioEnSesion());
        jugadorBD.actualizarDatosJugador(jugador, equipo);

    }

    public static void generarTablaClasificion(String temporada) throws SQLException, ConexionProblemas, ClasiNoExiste {
        clasificacionBD = new ClasificacionBD();
        ArrayList<Clasificacion> listaDePuntos = clasificacionBD.traerClasificacion(temporada);
        GenerarTablaClasificaciones generarTablaClasificacion = new GenerarTablaClasificaciones();
        generarTablaClasificacion.crearTabla(listaDePuntos);
        generarTablaClasificacion.pack();
        generarTablaClasificacion.setVisible(true);
        generarTablaClasificacion.setLocationRelativeTo(null);
    }

}
