package Exceptions;

/**
 * @author 1gdaw12
 */

public class CierreVError extends Exception{
    private static String mensaje;

    public CierreVError() {

    }

    public CierreVError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Se ha producido un error al "
                + "\ncerrar una de las ventanas";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
