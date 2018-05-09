package Exceptions;

/**
 * @author 1gdaw12
 */

public class EquiposCRUDError extends Exception{
    private static String mensaje;

    public EquiposCRUDError() {

    }

    public EquiposCRUDError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los CRUD de Equipos";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
