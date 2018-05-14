package Exceptions;

/**
 * @author 1gdaw12
 */

public class TemporadaNoExiste extends Exception{
    private static String mensaje;

    public TemporadaNoExiste() {

    }

    public TemporadaNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "La Temporada introducida no"
              + "\nexiste en la Base de Datos";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
