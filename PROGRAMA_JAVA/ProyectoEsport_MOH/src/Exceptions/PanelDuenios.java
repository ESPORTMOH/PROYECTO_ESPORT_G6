package Exceptions;

/**
 * @author 1gdaw12
 */

public class PanelDuenios extends Exception{
    private static String mensaje;

    public PanelDuenios() {

    }

    public PanelDuenios(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Se ha producido un error en uno"
                + "\nde los Paneles de Duenios";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
