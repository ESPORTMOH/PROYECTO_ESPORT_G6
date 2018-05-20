package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class UsuarioNoExiste extends Exception{
    private static String mensaje;

    public UsuarioNoExiste() {

    }

    /**
     * 
     * @param mensaje 
     */
    public UsuarioNoExiste(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "El Usuario con el DNI introducido"
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
