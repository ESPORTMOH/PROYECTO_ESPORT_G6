package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */
public class JornadaCRUDError extends Exception {

    private static String mensaje;

    public JornadaCRUDError() {

    }

    /**
     *
     * @param mensaje
     */
    public JornadaCRUDError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     *
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los CRUD de Jornadas";
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
