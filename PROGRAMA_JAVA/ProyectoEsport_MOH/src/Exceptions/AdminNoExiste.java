package Exceptions;

/**
 * @author 1gdaw12
 */

public class AdminNoExiste extends Exception{
    private static String mensaje;

    public AdminNoExiste() {

    }

    public AdminNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "El Admin o la Contraseña no"
                + "\nexisten en la Base de Datos";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
