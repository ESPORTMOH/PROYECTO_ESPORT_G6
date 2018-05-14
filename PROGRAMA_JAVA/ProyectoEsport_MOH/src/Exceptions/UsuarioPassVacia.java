package Exceptions;

/**
 * @author 1gdaw12
 */

public class UsuarioPassVacia extends Exception{
    private static String mensaje;

    public UsuarioPassVacia() {

    }

    public UsuarioPassVacia(String mensaje) {
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
