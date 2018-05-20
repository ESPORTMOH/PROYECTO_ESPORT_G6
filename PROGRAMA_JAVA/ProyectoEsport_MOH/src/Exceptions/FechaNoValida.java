package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class FechaNoValida extends Exception{
    private static String mensaje;

    public FechaNoValida() {

    }

    /**
     * 
     * @param mensaje 
     */
    public FechaNoValida(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "La Fecha ha de ser inferior"
                + "\na la actual del Sistema";
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
