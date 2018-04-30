/*
 * PROYECTO DAW 2017 - 2018
 */
package proyectoesport_moh;

import Views.*;
import Views.Administradores.*;
import Views.Duenios.*;
import Views.Equipos.*;
import Views.Jugadores.*;
import Views.Usuarios.*;

import ModelUML.*;
import ModelBD.*;

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
    private static VConsultaAdmins vConsultaAdmins;

    // VISTAS USUARIOS
    private static VPanelUsuarios vpanelUsuarios;
    private static VPanelCrudUsuarios vpanelCrudUsuarios;
    private static VAltaUsuarios vAltaUsuarios;
    private static VBajaUsuarios vBajaUsuarios;
    private static VEditarUsuarios vEditarUsuarios;
    private static VConsultaUsuarios vConsultaUsuarios;

    //VISTAS DUENIOS
    private static VPanelDuenios vpanelDuenios;
    private static VPanelCrudDuenios vpanelCrudDuenios;
    private static VAltaDuenios vAltaDuenios;
    private static VBajaDuenios vBajaDuenios;
    private static VEditarDuenios vEditarDuenios;
    private static VConsultaDuenios vConsultaDuenios;

    // VISTAS JUGADORES
    private static VPanelCrudJugadores vpanelJugadores;
    private static VAltaJugadores vAltaJugadores;
    private static VBajaJugadores vBajaJugadores;
    private static VEditarJugadores vEditarJugadores;
    private static VConsultaJugadores vConsultaJugadores;

    // VISTAS EQUIPOS
    private static VPanelCrudEquipos vpanelCrudEquipos;
    private static VAltaEquipos vAltaEquipos;
    private static VConsultaEquipos vBajaEquipos;
    private static VEditarEquipos vEditarEquipos;
    private static VConsultaEquipos vConsultaEquipos;

    // VISTAS PARTIDOS
    //
    private static Login loginUML;
    //
    private static AdministradorBD administradorBD;

    //
    private static LoginBD loginBD;

    //
    private static UsuarioBD usuarioBD;

    //
    private static DuenioBD duenioBD;

    //
    private static JugadorBD jugadorBD;

    //
    private static EquipoBD equipoBD;

    //
    private static PartidoBD partidoBD;

    public static void main(String[] args) {

        // INICIO MAIN
        abrirHome(vHo = new VHome());

    }

    // ABRIR HOME
    public static void abrirHome(VHome vHome) {
        vHo.setVisible(true);
        abrirInicioSesion();
    }

    // SALIR DE LA APLICACION
    public static void salirAplicacion() {
        System.exit(0);
    }

    // CERRAR VENTANA
    public static void cierraMe() {
        vpanelAdministracion.dispose();
    }

    // ABRIR VISTA LOGIN
    public static void abrirInicioSesion() {

        vLo = new VLogin();
        vLo.setVisible(true);
    }

    //REINICIAR VISTA LOGIN
    public static void reiniciarVistaLogin() {
        vLo.dispose();
        abrirInicioSesion();
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
        vConsultaAdmins = new VConsultaAdmins();
        vConsultaAdmins.setVisible(true);
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
        vConsultaUsuarios = new VConsultaUsuarios();
        vConsultaUsuarios.setVisible(true);
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
        vConsultaDuenios = new VConsultaDuenios();
        vConsultaDuenios.setVisible(true);
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
        vConsultaJugadores = new VConsultaJugadores();
        vConsultaJugadores.setVisible(true);
    }

    // MODIFICA JUGADORES
    public static void VModificaJugadores() {
        vEditarJugadores = new VEditarJugadores();
        vEditarJugadores.setVisible(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // ABRIR PANELES ALTA / BAJA / CONSULTA / MODIFICACION > EQUIPOS
    // ALTA EQUIPOS
    public static void VAltaEquipos() {
        vAltaEquipos = new VAltaEquipos();
        vAltaEquipos.setVisible(true);
    }

    // BAJA EQUIPOS
    public static void VBajaEquipos() {
        vBajaEquipos = new VConsultaEquipos();
        vBajaEquipos.setVisible(true);
    }

    // CONSULTA EQUIPOS
    public static void VConsultaEquipos() {
        vConsultaEquipos = new VConsultaEquipos();
        vConsultaEquipos.setVisible(true);
    }

    // MODIFICA EQUIPOS
    public static void VModificaEquipos() {
        vEditarEquipos = new VEditarEquipos();
        vEditarEquipos.setVisible(true);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > ADMINISTRADOR
    public static void localizarAdministradorEnBD(String dni) throws Exception {
        administradorBD = new AdministradorBD();
        Administrador administrador = administradorBD.localizaAdministrador(dni);
        vBajaAdmins.rellenarCamposVentana(administrador.getDni(), administrador.getNombre(), administrador.getApellido());
    }

    public static void eliminarAdministradorDelaBD(String dni) {

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > USUARIO
    public static void localizarUsuarioEnBD(String dni) throws Exception {
        usuarioBD = new UsuarioBD();
        Usuario usuario = usuarioBD.localizaUsuario(dni);
        vBajaUsuarios.rellenarCamposVentana(usuario.getDni(), usuario.getNombre(), usuario.getApellido());
    }

    public static void eliminarUsuarioDelaBD(String dni) {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > DUENIO
    public static void localizarDuenioEnBD(String dni) throws Exception {
        duenioBD = new DuenioBD();
        Duenio duenio = duenioBD.localizaDuenio(dni);
        vBajaDuenios.rellenarCamposVentana(duenio.getDni(), duenio.getNombre(), duenio.getApellido());
    }

    public static void eliminarDuenioDelaBD(String dni) {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > JUGADOR
    public static void localizarJugadorEnBD(String dni) throws Exception {
        jugadorBD = new JugadorBD();
        Jugador jugador = jugadorBD.localizaJugador(dni);
        vBajaJugadores.rellenarCamposVentana(jugador.getDni(), jugador.getNombre(), jugador.getApellido());
    }

    public static void eliminarJugadorDelaBD(String dni) {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > EQUIPO
    public static void localizarEquipoEnBD(String dni) throws Exception {
        equipoBD = new EquipoBD();
        Equipo equipo = equipoBD.localizaEquipo(dni);
        vBajaEquipos.rellenarCamposVentana();
    }

    public static void eliminarEquipoDelaBD(String nombre) {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // SENTENCIAS ALTA / BAJA / CONSULTA / MODIFICACION > PARTIDO
    ////////////////////////////////////////////////////////////////////////////////////////////////
}
