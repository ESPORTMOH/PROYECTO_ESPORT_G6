package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class UsuarioPassVacia extends Exception{
    private static String mensaje;

    public UsuarioPassVacia() {

    }

    /**
     * 
     * @param mensaje 
     */
    public UsuarioPassVacia(String mensaje) {
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
