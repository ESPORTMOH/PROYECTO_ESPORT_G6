package Exceptions;

/**
 * @author MIGUEL
 */

public class LogErrorAcceso extends Exception {

    private static String mensaje;

    public LogErrorAcceso() {

    }

    public LogErrorAcceso(String mensaje) {
        LogErrorAcceso.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Error, el Usuario y la Clave introducidos"
                + "\nno existen en nuestra Bases de Datos.";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        LogErrorAcceso.mensaje = mensaje;
    }

}
