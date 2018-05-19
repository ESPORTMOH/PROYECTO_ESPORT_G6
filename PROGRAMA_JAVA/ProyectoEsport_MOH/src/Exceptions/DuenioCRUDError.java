package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class DuenioCRUDError extends Exception{
    private static String mensaje;

    public DuenioCRUDError() {

    }

    /**
     * 
     * @param mensaje 
     */
    public DuenioCRUDError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los CRUD de Dueños";
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
