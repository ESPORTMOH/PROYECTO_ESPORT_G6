package Exceptions;

/**
 * @author MIGUEL
 */

public class ErroresDesconocidos extends Exception {

    static String mensaje;

    public ErroresDesconocidos() {

    }

    public ErroresDesconocidos(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Error Desconocido, pongase en"
                + "\ncontacto con el SUPER ADMIN";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

}
