package Exceptions;

/**
 * @author 1gdaw12
 */

public class JugadorCRUDError extends Exception{
    private static String mensaje;

    public JugadorCRUDError() {

    }

    public JugadorCRUDError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los CRUD de Jugadores";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
