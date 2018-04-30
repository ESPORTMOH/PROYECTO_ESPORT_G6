package Exceptions;

/**
 * @author MIGUEL
 */
public class ConexionProblemas extends Exception {

    private static String mensaje;

    public ConexionProblemas() {

    }

    public ConexionProblemas(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    public String getMensaje() {
        mensaje = "No se ha podido Establecer la Conexion"
                + "\ncon el Servidor de La Base de Datos";
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    
    
    

}
