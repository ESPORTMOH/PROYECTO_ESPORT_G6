package Exceptions;

/**
 * @author 1gdaw12
 */

public class AbreVError extends Exception{
    private static String mensaje;

    public AbreVError() {

    }

    public AbreVError(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Se ha producido un error al "
                + "\nabrir una de las ventanas";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
