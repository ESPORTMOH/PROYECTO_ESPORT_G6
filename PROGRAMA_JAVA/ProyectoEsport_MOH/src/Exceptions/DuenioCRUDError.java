package Exceptions;

/**
 * @author 1gdaw12
 */

public class DuenioCRUDError extends Exception{
    private static String mensaje;

    public DuenioCRUDError() {

    }

    public DuenioCRUDError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los CRUD de Dueños";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
