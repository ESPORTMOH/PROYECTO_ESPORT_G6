package Exceptions;

/**
 * @author 1gdaw12
 */

public class AdminNombreVacio extends Exception{
    private static String mensaje;

    public AdminNombreVacio() {

    }

    public AdminNombreVacio(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "El Campo Nombre es requerido"
                + "\npara su modificacion.";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
