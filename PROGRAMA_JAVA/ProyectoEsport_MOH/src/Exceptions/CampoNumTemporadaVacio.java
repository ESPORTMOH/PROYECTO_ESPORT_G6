package Exceptions;

/**
 * @author 1gdaw12
 */

public class CampoNumTemporadaVacio extends Exception{
    private static String mensaje;

    public CampoNumTemporadaVacio() {

    }

    public CampoNumTemporadaVacio(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "El campo Nº Temporada es obligatorio"
                + "\npara realizar la busqueda";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
