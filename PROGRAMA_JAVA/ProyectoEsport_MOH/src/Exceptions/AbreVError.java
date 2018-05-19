package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class AbreVError extends Exception{
    private static String mensaje;

    public AbreVError() {

    }

    /**
     * 
     * @param mensaje 
     */
    public AbreVError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Se ha producido un error al "
                + "\nabrir una de las ventanas";
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
