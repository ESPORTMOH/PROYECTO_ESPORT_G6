package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class LogErrorAcceso extends Exception {

    private static String mensaje;

    public LogErrorAcceso() {

    }

    /**
     * 
     * @param mensaje 
     */
    public LogErrorAcceso(String mensaje) {
        LogErrorAcceso.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Error, el Usuario y la Clave introducidos"
                + "\nno existen en nuestra Bases de Datos.";
        return mensaje;
    }

    /**
     * 
     * @param mensaje 
     */
    public void setMensaje(String mensaje) {
        LogErrorAcceso.mensaje = mensaje;
    }

}
