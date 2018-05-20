package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class ClasificacionNoExiste extends Exception{
    private static String mensaje;

    public ClasificacionNoExiste() {

    }

    /**
     * 
     * @param mensaje 
     */
    public ClasificacionNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "La Clasificacion introducida no"
              + "\nexiste en la Base de Datos";
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
