package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class DuenioNoExiste extends Exception{
    private static String mensaje;

    public DuenioNoExiste() {

    }

    /**
     * 
     * @param mensaje 
     */
    public DuenioNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "El Dueño con el DNI introducido"
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
