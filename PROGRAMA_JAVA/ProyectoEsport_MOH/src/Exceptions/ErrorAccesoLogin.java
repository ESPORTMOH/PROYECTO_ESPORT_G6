package Exceptions;

/**
 * @author MIGUEL
 */

public class ErrorAccesoLogin extends Exception {

    private static String mensaje;

    public ErrorAccesoLogin() {

    }

    public ErrorAccesoLogin(String mensaje) {
        ErrorAccesoLogin.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Error, el Usuario y la Clave introducidos"
                + "\nno existen en nuestra Bases de Datos.";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErrorAccesoLogin.mensaje = mensaje;
    }

}
