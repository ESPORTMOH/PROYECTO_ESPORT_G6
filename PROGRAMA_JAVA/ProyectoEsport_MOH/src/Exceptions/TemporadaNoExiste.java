package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class TemporadaNoExiste extends Exception{
    private static String mensaje;

    public TemporadaNoExiste() {

    }

    /**
     * 
     * @param mensaje 
     */
    public TemporadaNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "La Temporada introducida no"
              + "\nexiste en la Base de Datos";
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
