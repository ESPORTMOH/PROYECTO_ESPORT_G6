package Exceptions;

/**
 * @author 1gdaw12
 */

public class UsuarioNoExiste extends Exception{
    private static String mensaje;

    public UsuarioNoExiste() {

    }

    public UsuarioNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "El Usuario con el DNI introducido"
                + "\nno existe en la Base de Datos";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
