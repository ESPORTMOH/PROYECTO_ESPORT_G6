package Exceptions;

/**
 * @author 1gdaw12
 */

public class DuenioNoExiste extends Exception{
    private static String mensaje;

    public DuenioNoExiste() {

    }

    public DuenioNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "El Dueño con el DNI introducido"
                + "\nno existe en la Base de Datos";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
