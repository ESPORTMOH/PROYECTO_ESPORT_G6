package Exceptions;

/**
 * @author MIGUEL
 */

public class CampoVacio extends Exception {

    private static String mensaje;

    public CampoVacio() {

    }

    public CampoVacio(String mensaje) {
        CampoVacio.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Recuerda, el Usuario y Contraseña"
                + "\nson campos obligatorios. Gracias";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        CampoVacio.mensaje = mensaje;
    }

}
