package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class TempNoExiste extends Exception{
    private static String mensaje;

    public TempNoExiste() {

    }

    /**
     * 
     * @param mensaje 
     */
    public TempNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "La temporada facilitada"
                + "\nno existe en la Base de Datos";
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
