package Exceptions;

/**
 * @author 1gdaw12
 */

public class CampoTempVacio extends Exception{
    private static String mensaje;

    public CampoTempVacio() {

    }

    public CampoTempVacio(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "El campo Nº Temporada es obligatorio"
                + "\npara generar la jornada.";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
