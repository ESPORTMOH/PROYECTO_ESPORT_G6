package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class CampoNombreVacio extends Exception{
    private static String mensaje;

    public CampoNombreVacio() {

    }

    /**
     * 
     * @param mensaje 
     */
    public CampoNombreVacio(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "El campo NOMBRE es obligatorio"
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
