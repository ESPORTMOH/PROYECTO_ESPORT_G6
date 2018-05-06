package Exceptions;

/**
 * @author 1gdaw12
 */

public class CampoDniVacio extends Exception{
    private static String mensaje;

    public CampoDniVacio() {

    }

    public CampoDniVacio(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "El campo DNI es obligatorio"
                + "\npara realizar la busqueda";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
