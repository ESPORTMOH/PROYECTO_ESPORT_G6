package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class CamposVacios extends Exception{
    private static String mensaje;

    public CamposVacios() {

    }

    /**
     * 
     * @param mensaje 
     */
    public CamposVacios(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Todos los campos son obligatorios";
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
