package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class CampoNumTemporadaVacio extends Exception{
    private static String mensaje;

    public CampoNumTemporadaVacio() {

    }

    /**
     * 
     * @param mensaje 
     */
    public CampoNumTemporadaVacio(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "El campo Nº Temporada es obligatorio"
                + "\npara realizar la busqueda";
        return mensaje;
    }

    /**
     * 
     * @param mensaje 
     */
    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
