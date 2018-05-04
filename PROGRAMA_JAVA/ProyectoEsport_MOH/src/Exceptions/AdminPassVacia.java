package Exceptions;

/**
 * @author 1gdaw12
 */

public class AdminPassVacia extends Exception{
    private static String mensaje;

    public AdminPassVacia() {

    }

    public AdminPassVacia(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "La Constraseña es obligatoria"
                + "\npara poder guardarla en la BD";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
