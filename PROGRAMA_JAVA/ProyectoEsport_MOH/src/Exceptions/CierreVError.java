package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class CierreVError extends Exception{
    private static String mensaje;

    public CierreVError() {

    }

    /**
     * 
     * @param mensaje 
     */
    public CierreVError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Se ha producido un error al "
                + "\ncerrar una de las ventanas";
        return mensaje;
    }

    /**
     * 
     * @param mensaje 
     */
    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
