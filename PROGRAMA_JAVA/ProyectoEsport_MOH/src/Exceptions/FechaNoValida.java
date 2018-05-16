package Exceptions;

/**
 * @author 1gdaw12
 */

public class FechaNoValida extends Exception{
    private static String mensaje;

    public FechaNoValida() {

    }

    public FechaNoValida(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "La Fecha ha de ser inferior"
                + "\na la actual del Sistema";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
