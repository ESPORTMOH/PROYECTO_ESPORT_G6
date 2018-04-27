package Exceptions;

/**
 * @author 1gdaw12
 */

public class JugadorNoExiste extends Exception{
    private static String mensaje;

    public JugadorNoExiste() {

    }

    public JugadorNoExiste(String mensaje) {
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
