package Exceptions;

/**
 * @author 1gdaw12
 */

public class JornadaCRUDError extends Exception{
    private static String mensaje;

    public JornadaCRUDError() {

    }

    public JornadaCRUDError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los CRUD de Jornadas";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
