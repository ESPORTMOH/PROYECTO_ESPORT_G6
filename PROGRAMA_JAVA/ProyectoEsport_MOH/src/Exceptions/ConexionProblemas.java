package Exceptions;

/**
 * @author MIGUEL OLMO HERNANDO
 */
public class ConexionProblemas extends Exception {

    private static String mensaje;

    public ConexionProblemas() {

    }

    /**
     * 
     * @param mensaje 
     */
    public ConexionProblemas(String mensaje) {
        ErroresDesconocidos.mensaje = mensaje;
    }

    /**
     * 
     * @return mensaje
     */
    public String getMensaje() {
        mensaje = "No se ha podido Establecer la Conexion"
                + "\ncon el Servidor de La Base de Datos";
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
