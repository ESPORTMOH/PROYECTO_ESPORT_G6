package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class UsuarioCRUDError extends Exception{
    private static String mensaje;

    public UsuarioCRUDError() {

    }

    /**
     * 
     * @param mensaje 
     */
    public UsuarioCRUDError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los CRUD de Usuarios";
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
