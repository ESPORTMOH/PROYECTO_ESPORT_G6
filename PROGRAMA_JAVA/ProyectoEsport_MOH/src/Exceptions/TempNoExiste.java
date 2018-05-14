package Exceptions;

/**
 * @author 1gdaw12
 */

public class TempNoExiste extends Exception{
    private static String mensaje;

    public TempNoExiste() {

    }

    public TempNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "La temporada facilitada"
                + "\nno existe en la Base de Datos";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
