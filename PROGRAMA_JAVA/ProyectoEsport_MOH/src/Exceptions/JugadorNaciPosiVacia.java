package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class JugadorNaciPosiVacia extends Exception{
    private static String mensaje;

    public JugadorNaciPosiVacia() {

    }

    /**
     * 
     * @param mensaje 
     */
    public JugadorNaciPosiVacia(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Posición y Nacionalidad obligatorias"
                + "\npara poder guardarlas en la BD";
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
