package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class PanelDuenios extends Exception{
    private static String mensaje;

    public PanelDuenios() {

    }

    /**
     * 
     * @param mensaje 
     */
    public PanelDuenios(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los Paneles de Duenios";
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
