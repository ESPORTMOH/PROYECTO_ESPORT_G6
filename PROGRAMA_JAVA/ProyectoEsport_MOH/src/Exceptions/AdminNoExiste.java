package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class AdminNoExiste extends Exception{
    private static String mensaje;

    public AdminNoExiste() {

    }

    /**
     * 
     * @param mensaje 
     */
    public AdminNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "El Admin con el DNI introducido"
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
