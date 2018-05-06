package Exceptions;

/**
 * @author 1gdaw12
 */

public class AdminCRUDError extends Exception{
    private static String mensaje;

    public AdminCRUDError() {

    }

    public AdminCRUDError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los CRUD de Administradores";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
