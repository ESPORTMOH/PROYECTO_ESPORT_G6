package Exceptions;

/**
 * @author 1gdaw12
 */

public class EquipoNoExiste extends Exception{
    private static String mensaje;

    public EquipoNoExiste() {

    }

    public EquipoNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "El Nombre del Equipo introducido"
              + "\nno existe en la Base de Datos";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
