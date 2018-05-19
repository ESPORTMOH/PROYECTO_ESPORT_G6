package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class AdminPassVacia extends Exception{
    private static String mensaje;

    public AdminPassVacia() {

    }

    /**
     * 
     * @param mensaje 
     */
    public AdminPassVacia(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "La Constraseña es obligatoria"
                + "\npara poder guardarla en la BD";
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
