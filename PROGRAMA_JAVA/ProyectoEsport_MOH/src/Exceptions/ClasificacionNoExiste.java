package Exceptions;

/**
 * @author 1gdaw12
 */

public class ClasificacionNoExiste extends Exception{
    private static String mensaje;

    public ClasificacionNoExiste() {

    }

    public ClasificacionNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "La Clasificacion introducida no"
              + "\nexiste en la Base de Datos";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
