package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class CampoDniVacio extends Exception{
    private static String mensaje;

    public CampoDniVacio() {

    }

    /**
     * 
     * @param mensaje 
     */
    public CampoDniVacio(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "El campo DNI es obligatorio"
                + "\npara realizar la busqueda";
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
