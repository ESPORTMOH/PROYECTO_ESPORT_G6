package Exceptions;

/**
 * @author MIGUEL
 */

public class LogCampoVacio extends Exception {

    private static String mensaje;

    public LogCampoVacio() {

    }

    public LogCampoVacio(String mensaje) {
        LogCampoVacio.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Recuerda, el Usuario y Contraseña"
                + "\nson campos obligatorios. Gracias";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        LogCampoVacio.mensaje = mensaje;
    }

}
