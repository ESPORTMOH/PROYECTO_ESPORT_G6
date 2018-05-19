package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class LogAccesoNoExiste extends Exception{
    private static String mensaje;

    public LogAccesoNoExiste() {

    }

    /**
     * 
     * @param mensaje 
     */
    public LogAccesoNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "El Usuario o la Contraseña no"
                + "\nexisten en la Base de Datos";
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
