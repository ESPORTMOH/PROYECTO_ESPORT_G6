package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class CampoTempVacio extends Exception{
    private static String mensaje;

    public CampoTempVacio() {

    }

    /**
     * 
     * @param mensaje 
     */
    public CampoTempVacio(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "El campo Nº Temporada es obligatorio"
                + "\npara generar la jornada.";
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
