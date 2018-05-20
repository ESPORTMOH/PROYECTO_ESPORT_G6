package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class EquipoNoExiste extends Exception{
    private static String mensaje;

    public EquipoNoExiste() {

    }

    /**
     * 
     * @param mensaje 
     */
    public EquipoNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "El Nombre del Equipo introducido"
              + "\nno existe en la Base de Datos";
        return mensaje;
    }

    /**
     * 
     * @param mensaje 
     */
    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }
}
