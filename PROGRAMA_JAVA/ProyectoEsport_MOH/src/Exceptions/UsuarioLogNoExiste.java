package Exceptions;

/**
 * @author 1gdaw12
 */

public class UsuarioLogNoExiste extends Exception{
    private static String mensaje;

    public UsuarioLogNoExiste() {

    }

    public UsuarioLogNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "El Usuario o la Contraseña no"
                + "\nexisten en la Base de Datos";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
