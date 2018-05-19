package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class JugadorCRUDError extends Exception{
    private static String mensaje;

    public JugadorCRUDError() {

    }

    /**
     * 
     * @param mensaje 
     */
    public JugadorCRUDError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los CRUD de Jugadores";
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
