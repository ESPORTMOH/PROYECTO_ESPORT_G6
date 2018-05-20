package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class ErroresDesconocidos extends Exception {

    static String mensaje;

    public ErroresDesconocidos() {

    }

    /**
     * 
     * @param mensaje 
     */
    public ErroresDesconocidos(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Error Desconocido, pongase en"
                + "\ncontacto con el SUPER ADMIN";
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
