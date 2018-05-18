package Exceptions;

/**
 * @author 1gdaw12
 */

public class JugadorNaciPosiVacia extends Exception{
    private static String mensaje;

    public JugadorNaciPosiVacia() {

    }

    public JugadorNaciPosiVacia(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Posición y Nacionalidad obligatorias"
                + "\npara poder guardarlas en la BD";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
