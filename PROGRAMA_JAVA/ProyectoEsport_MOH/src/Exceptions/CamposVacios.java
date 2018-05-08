package Exceptions;

/**
 * @author 1gdaw12
 */

public class CamposVacios extends Exception{
    private static String mensaje;

    public CamposVacios() {

    }

    public CamposVacios(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "Todos los campos son obligatorios";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
