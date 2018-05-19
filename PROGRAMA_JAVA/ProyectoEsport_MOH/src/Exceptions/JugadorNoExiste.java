package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class JugadorNoExiste extends Exception{
    private static String mensaje;

    public JugadorNoExiste() {

    }

    /**
     * 
     * @param mensaje 
     */
    public JugadorNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "El Jugador con el DNI introducido"
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
