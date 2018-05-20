package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class ClasiNoExiste extends Exception{
    private static String mensaje;

    public ClasiNoExiste() {

    }

    /**
     * 
     * @param mensaje 
     */
    public ClasiNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "La Clasificacion no existe";
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
