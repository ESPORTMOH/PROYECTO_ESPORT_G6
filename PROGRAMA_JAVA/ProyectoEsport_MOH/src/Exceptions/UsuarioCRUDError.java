package Exceptions;

/**
 * @author 1gdaw12
 */

public class UsuarioCRUDError extends Exception{
    private static String mensaje;

    public UsuarioCRUDError() {

    }

    public UsuarioCRUDError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los CRUD de Usuarios";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
