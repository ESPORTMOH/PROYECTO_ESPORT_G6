package Exceptions;

/**
 * @author 1gdaw12
 */

public class CampoNombreVacio extends Exception{
    private static String mensaje;

    public CampoNombreVacio() {

    }

    public CampoNombreVacio(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "El campo NOMBRE es obligatorio"
                + "\npara realizar la busqueda";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
