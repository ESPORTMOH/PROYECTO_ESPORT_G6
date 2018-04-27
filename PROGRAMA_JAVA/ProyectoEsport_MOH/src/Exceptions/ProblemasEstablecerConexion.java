package Exceptions;

/**
 * @author MIGUEL
 */
public class ProblemasEstablecerConexion extends Exception {

    private static String mensaje;

    public ProblemasEstablecerConexion() {

    }

    public ProblemasEstablecerConexion(String mensaje) {
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
