package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class LogCampoVacio extends Exception {

    private static String mensaje;

    public LogCampoVacio() {

    }

    /**
     * 
     * @param mensaje 
     */
    public LogCampoVacio(String mensaje) {
        LogCampoVacio.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Recuerda, el Usuario y Contraseña"
                + "\nson campos obligatorios. Gracias";
        return mensaje;
    }

    /**
     * 
     * @param mensaje 
     */
    public void setMensaje(String mensaje) {
        LogCampoVacio.mensaje = mensaje;
    }

}
