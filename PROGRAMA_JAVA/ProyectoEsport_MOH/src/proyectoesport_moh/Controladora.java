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

//import javax.swing.JProgressBar;
/**
 * @author MIGUEL OLMO HERNANDO
 * @proyect_name PROYECTO DAW 2017 - 2018 - GRUPO 6
 * @version Fase4 v10
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
    private static VClasificaciones vClasificaciones;

    //VISTAS DUENIOS
    private static VPanelDuenios vpanelDuenios;
    private static VPanelCrudDuenios vpanelCrudDuenios;
    private static VAltaDuenios vAltaDuenios;
    private static VBajaDuenios vBajaDuenios;
    private static VEditarDuenios vEditarDuenios;
    private static VConsultaDuenios vConsultarDuenios;
    private static VUltimaJornada vultimaJornada;
    private static VUltimaClasificacion vultimaClasificacion;

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
    private static VBajaJornadas vBajaJornadas;
    private static VConsultaJornadas vConsultarJornadas;

    // VISTAS FICHAJES
    private static VFichajes vFichajes;

    // VISTAS PARTIDOS
    private static VPartido vPartido;

    // VISTAS CLASIFICACION
    private static VPanelClasificacion vpanelClasificacion;
    private static VAltaClasificacion vAltaClasificacion;
    private static VBajaClasificacion vBajaClasificacion;
    private static VConsultaClasificacion vConsultaClasificacion;
    /**
     * FIN DECLARACION DE OBJETOS PARA LAS VISTAS
     *
     */

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
     * FIN DECLARACION DE OBJETOS UML / BD
     *
     */
    /// INICIO MAIN
    public static void main(String[] args) {

        /**
         * INICIO GENERICO DE LAS VENTANAS DE INICIO / RESET / SALIDA DE LA
         * APLICACION
         *
         * @param VHome vHome
         * @return all void
         *
         */
        // 
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

    //REINICIAR VISTA LOGIN
    public static void reiniciarVistaLogin() {
        vLo.dispose();
        abrirHome(vHo);
    }

    // SALIR DE LA APLICACION
    public static void salirAplicacion() {
        System.exit(0);
    }

    /**
     * FIN GENERICO DE LAS VENTANAS DE INICIO / RESET / SALIDA DE LA APLICACION
     *
     */
    /**
     * INICIO APERTURA DE PANELES PARA EL MENU SEGUN EL LOGEO APLICACION
     *
     * @param VPanelAdministracion vpanelAdministracion
     * @return void
     *
     */
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

    /**
     * FIN APERTURA DE PANELES PARA EL MENU SEGUN EL LOGEO APLICACION
     *
     */
    /**
     * INICIO ABRIR PANELES / CRUD > ADMINISTRADORES / USUARIOS / DUENOS /
     * JUGADORES / EQUIPOS / VISTAS VARIAS
     *
     * @param
     * @return all void
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

    // ABRIR VISTA ULTIMA CLASIFICACION
    public static void abrirClasificaciones() {
        vClasificaciones = new VClasificaciones();
        vClasificaciones.setVisible(true);
    }

    // ABRIR PANEL REGISTRAR PUNTOS PARTIDOS
    public static void abrirPanelPartidosPuntos() {
        vPartido = new VPartido();
        vPartido.setVisible(true);
    }

    // ABRIR PANEL CLASIFICACION            
    public static void abrirPanelClasificacion() {
        vpanelClasificacion = new VPanelClasificacion();
        vpanelClasificacion.setVisible(true);
    }

    /**
     * FIN PANELES / CRUD > ADMINISTRADORES / USUARIOS / DUENOS / JUGADORES /
     * EQUIPOS / VISTAS VARIAS
     *
     */
    /**
     * INICIO ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION >
     * ADMINISTRADORES
     *
     * @param
     * @return all void
     *
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
     * FIN ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > ADMINISTRADORES
     *
     */
    /**
     * INICIO ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > USUARIOS
     *
     * @param
     * @return all void
     *
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
     * FIN ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > USUARIOS
     *
     */
    /**
     * INICIO ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > DUENIOS
     *
     * @param
     * @return all void
     *
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
     * FIN ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > DUENIOS
     *
     */
    /**
     * INICIO ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > JUGADORES
     *
     * @param
     * @return all void
     *
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
     * FIN ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > JUGADORES
     *
     */
    /**
     * INICIO ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > EQUIPOS
     *
     * @param
     * @return all void
     * @throws SQLException, ConexionProblemas
     *
     */
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

    /**
     * FIN ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > EQUIPOS
     *
     */
    /**
     * INICIO ABRIR PANELES GESTION / CALENDARIO > JORNADAS
     *
     * @param
     * @return all void
     *
     */
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

    // CONSULTA JORNADAS
    public static void VConsultaJornadas() {
        vConsultarJornadas = new VConsultaJornadas();
        vConsultarJornadas.setVisible(true);
    }

    /**
     * FIN ABRIR PANELES GESTION / CALENDARIO > JORNADAS
     *
     */
    /**
     * INICIO ABRIR PANELES GESTION / CLASIFICACION
     *
     * @param
     * @return all void
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

    // ABRIR BAJA CLASIFICACION            
    public static void abrirBajaClasificacion() {
        vBajaClasificacion = new VBajaClasificacion();
        vBajaClasificacion.setVisible(true);
    }

    /**
     * FIN ABRIR PANELES GESTION / CLASIFICACION
     *
     */
    /**
     * INICIO CONTROL GENERICO DE VENTANAS > CERRADO DE VENTANAS
     *
     * @param String tipoVentana
     * @return all void
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
            case "VBajaJornadas": {
                vBajaJornadas.dispose();
                break;
            }
            case "VConsultarJornadas": {
                vConsultarJornadas.dispose();
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
            case "VClasificaciones": {
                vClasificaciones.dispose();
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
            case "VBajaClasificacion": {
                vBajaClasificacion.dispose();
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
     * FIN CONTROL GENERICO DE VENTANAS > CERRADO DE VENTANAS
     *
     */
    /**
     * INICIO CONTROL GENERICO DE VENTANAS > APERTURA DE VENTANAS
     *
     * @param String tipoVentana
     * @return all void
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
     * FIN CONTROL GENERICO DE VENTANAS > APERTURA DE VENTANAS
     *
     */
    /**
     * INICIO CONSULTA PARA SOLICITAR ACCESO
     *
     * @param String usuario, String password
     * @return void
     * @throws Exception
     *
     */
    public static void consultarLogin(String usuario, String password) throws Exception {

        loginBD = new LoginBD();

        loginUML = new Login(usuario, password);

        Login usuarioLogeado = loginBD.validarLogin(loginUML);

        System.out.println("Acceso Login como Tipo: " + usuarioLogeado.getTipo());

        cargarPanelTipo(usuarioLogeado.getTipo());
    }

    /**
     * FIN CONSULTA PARA SOLICITAR ACCESO
     *
     */
    /**
     * INICIO MENU DE CARGA SEGUN EL TIPO DE LOGIN
     *
     * @param String tipo
     * @return void
     * @throws Exception
     *
     */
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

    /**
     * FIN MENU DE CARGA SEGUN EL TIPO DE LOGIN
     *
     */
    /**
     * INICIO SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > ADMINISTRADOR
     *
     * @param String dni, String nombre, String apellido, String tipo
     * @return void
     * @throws Exception, SQLException, ConexionProblemas
     *
     */
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

    /**
     * FIN SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > ADMINISTRADOR
     *
     */
    /**
     * INICIO SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > USUARIO
     *
     * @param String dni, String nombre, String apellido, String tipo
     * @return void
     * @throws Exception, SQLException, ConexionProblemas
     *
     */
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
        loginBD.ejecutarModificacionLog(loginUML.getPassword(), usuarioUML.getLogin().getCodLogin());
    }

    // BAJA
    public static void eliminarUsuarioDelaBD(String dni, Integer codLogin) throws SQLException, ConexionProblemas {
        usuarioBD = new UsuarioBD();
        loginBD = new LoginBD();

        usuarioBD.eliminarUsuarioDelaBD(dni);
        loginBD.eliminarDeLaBDUsuarioLog(codLogin);
    }

    /**
     * FIN SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > USUARIO
     *
     * @param String dni, String nombre, String apellido, String tipo
     * @return void
     *
     */
    /**
     * INICIO SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > DUENIO
     *
     * @param String dni, String nombre, String apellido, String tipo
     * @return void
     * @throws Exception
     *
     */
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
                vConsultarDuenios.rellenarCamposVentana(duenioUML.getDni(), duenioUML.getNombre(), duenioUML.getApellido(), duenioUML.getLogin().getUser(), duenioUML.getLogin().getPassword());
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

    /**
     * FIN SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > DUENIO
     *
     */
    /**
     * INICIO SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > JUGADOR
     *
     * @param String dni, String nombre, String apellido, String nickname,
     * String sueldo, Date fechaNacimiento, String nacionalidad, String posicion
     * @return void
     * @throws Exception
     *
     */
    // ALTA
    public static void pedirInsertarJugadorBD(String dni, String nombre, String apellido, String nickname, String sueldo, Date fechaNacimiento, String nacionalidad, String posicion) throws Exception {

        jugadorBD = new JugadorBD();
        //DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        //Date fnacimiento = formatter.parse(fechaNacimiento);

        jugadorUML = new Jugador(dni, nombre, apellido, nickname, Double.parseDouble(sueldo), fechaNacimiento, nacionalidad, posicion);
        jugadorBD.insertarJugadorEnBD(jugadorUML);

    }
    // LOCALIZA

    public static void localizarJugadorEnBD(String dni) throws Exception {
        jugadorBD = new JugadorBD();
        Jugador jugador = jugadorBD.localizaJugador(dni);

        vBajaJugadores.rellenarCamposVentana(jugador.getDni(), jugador.getNombre(), jugador.getApellido(), jugador.getNickname(), jugador.getSueldo(), jugador.getFechaNacimiento(), jugador.getNacionalidad(), jugador.getPosicion());
    }

    // EDITA
    public static void pedirEditarJugador(String dni, String nacionalidad, String posicion) throws SQLException, ConexionProblemas {
        jugadorBD = new JugadorBD();
        Jugador jugador = new Jugador();
        jugador.setDni(dni);
        jugador.setNacionalidad(nacionalidad);
        jugador.setPosicion(posicion);
        jugadorBD.editarJugadorEnBD(jugador);
    }

    // BAJA
    public static void pedirEliminarJugadorDelaBD(String dni) throws SQLException, ConexionProblemas {
        jugadorBD = new JugadorBD();
        jugadorBD.eliminarJugadorDelaBD(dni);
    }

    /**
     * FIN SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > JUGADOR
     *
     */
    /**
     * INICIO SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > EQUIPO
     *
     * @param String nombre, String presupuesto, String anioFundacion, String
     * ciudad, String nombreEstadio, String dniDuenio
     * @return void
     * @throws Exception
     *
     */
    // ALTA
    public static void altaEquipoBD(String nombre, String presupuesto, String anioFundacion, String ciudad, String nombreEstadio, String dniDuenio) throws Exception {
        equipoBD = new EquipoBD();
        duenioBD = new DuenioBD();
        //split
        String[] dniDue = dniDuenio.split(" ");
        Duenio duenio = duenioBD.localizarDuenio(dniDue[0]);
        equipoUML = new Equipo(nombre, Double.parseDouble(presupuesto), anioFundacion, ciudad, nombreEstadio, duenio);
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

    /**
     * FICHAJES PARA EL EQUIPO
     *
     * @return ArrayList
     * @throws SQLException, ConexionProblemas
     */
    public static ArrayList<Jugador> consultarJugadoresParaCombo() throws SQLException, ConexionProblemas {
        JugadorBD jugadorBD = new JugadorBD();
        return jugadorBD.traerTodosLosJuagdoresBD();
    }

    /**
     * FIN SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > EQUIPO
     *
     */
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > PARTIDO
    ////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * INICIO SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > JORNADA
     *
     * @return all void
     * @throws Exception, SQLException, ConexionProblemas, TempNoExiste
     */
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
     * FIN SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > JORNADA
     *
     */
    /**
     * INICIO LOCALIZAR PARA CONFIRMAR SI EXISTE Y BORRAR A POSTERIORI SI SE
     * DESEA
     *
     * @return all void
     * @throws Exception, SQLException, ConexionProblemas, TempNoExiste
     */
    public static void pedirLocalizarTemporada(String tipoVentana, String numTemporada) throws Exception, TempNoExiste {
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
     * FIN LOCALIZAR PARA CONFIRMAR SI EXISTE Y BORRAR A POSTERIORI SI SE DESEA
     *
     * @return all void
     * @throws Exception, SQLException, ConexionProblemas, TempNoExiste
     */
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > CLASIFICACION
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static void localizarClasificacionEnBD() {
    }

    /**
     * INICIO VALIDACIONES
     *
     * @param String dni
     * @return boolean
     * @throws Exception, SQLException, ConexionProblemas, TempNoExiste
     */

    // PARA EL DNI
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

    public static boolean localizarSiexixteDni(String dni) throws SQLException, ConexionProblemas {
        administradorBD = new AdministradorBD();
        return administradorBD.localizarSiexixteDni(dni);
    }
    
        /**
     * FIN VALIDACIONES
     *
     */

}
