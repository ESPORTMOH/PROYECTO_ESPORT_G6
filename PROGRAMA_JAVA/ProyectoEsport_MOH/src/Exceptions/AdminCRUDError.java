package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class AdminCRUDError extends Exception{
    private static String mensaje;

    public AdminCRUDError() {

    }

    /**
     * 
     * @param mensaje 
     */
    public AdminCRUDError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los CRUD de Administradores";
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
