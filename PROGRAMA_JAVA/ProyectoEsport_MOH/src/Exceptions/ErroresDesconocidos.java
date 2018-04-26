package Exceptions;

/**
 * @author MIGUEL
 */

public class ErroresDesconocidos extends Exception {

    private static String mensaje;

    public ErroresDesconocidos() {

    }

    public ErroresDesconocidos(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Error Desconocido, pongase en"
                + "\ncontacto con el SUPER USUARIO";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

}
