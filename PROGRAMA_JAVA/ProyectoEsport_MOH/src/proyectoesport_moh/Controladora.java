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

    //VISTA LOGIN
    private static VLogin vLo;

    //VISTAS ADMINISTRADOR
    private static VPanelAdministracion vpanelAdministracion;
    private static VAltaAdmin vAltaAdmin;
    private static VBajaAdmin vBajaAdmin;
    private static VEditarAdmin vEditarAdmin;
    private static VConsultaAdmin vConsultaAdmin;

    //VISTAS DUENIOS
    private static VPanelDuenios vpanelDuenios;
    
    //VISTAS USUARIOS
    private static VPanelUsuarios vpanelUsuarios;
    
    //
    private static Login loginUML;

    //
    private static LoginBD loginBD;

    public static void main(String[] args) {

        // INICIO MAIN
        abrirHome(vHo = new VHome());
    }

    public static void abrirHome(VHome vHome) {
        vHo.setVisible(true);
        abrirInicioSesion();
    }

    //SALIR DE LA APLICACION
    public static void salirAplicacion() {
        System.exit(0);
    }

    //ABRIR VISTA LOGIN
    public static void abrirInicioSesion() {

        vLo = new VLogin();
        vLo.setVisible(true);
    }
    
    //REINICIAR VISTA LOGIN
    public static void reiniciarVistaLogin() {
        vLo.dispose();
        abrirInicioSesion();
    }

    //CONSULTA PARA SOLICITAR ACCESO
    public static void consultarLogin(String usuario, String password) throws Exception {

        loginBD = new LoginBD();

        loginUML = new Login(usuario, password);

        Login usuarioLogeado = loginBD.validarLogin(loginUML);

        System.out.println("Acceso Login como Tipo: " + usuarioLogeado.getTipo());

        cargarPanelTipo(usuarioLogeado.getTipo());

    }

    //MENU DE CARGA DE LOS DIFERENTES PANELES SEGUN TIPO DE LOGIN
    public static void cargarPanelTipo(String tipo) throws Exception {

        switch (tipo.toUpperCase()) {
            case "A":
                vpanelAdministracion = new VPanelAdministracion();
                abrirPanelAdministracion(vpanelAdministracion);
                break;
            case "D":
                vpanelDuenios = new VPanelDuenios();
                abrirPanelDuenios(vpanelDuenios);
                break;
            case "U":
                vpanelUsuarios = new VPanelUsuarios();
                abrirPanelUsuarios(vpanelUsuarios);
                break;

        }

    }
    
    //ABRIR PANEL TIPO ADMINISTRADOR
    public static void abrirPanelAdministracion(VPanelAdministracion vpanelAdministracion) {
        vpanelAdministracion.setVisible(true);
    }
    
    //ABRIR PANEL TIPO DUENIO
    private static void abrirPanelDuenios(VPanelDuenios vpanelDuenios) {
        vpanelDuenios.setVisible(true);
    }
    
    //ABRIR PANEL TIPO USUARIO
    private static void abrirPanelUsuarios(VPanelUsuarios vpanelUsuarios) {
        vpanelUsuarios.setVisible(true);
    }

    

}
