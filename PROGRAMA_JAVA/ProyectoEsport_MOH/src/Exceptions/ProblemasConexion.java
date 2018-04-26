package Exceptions;

/**
 * @author MIGUEL
 */
public class ProblemasConexion extends Exception {

    private String mensajeEstableceConexion;
    private String mensajeCierraConexion;

    public ProblemasConexion() {
    }

    public ProblemasConexion(String mensajeEstableceConexion, String mensajeCierraConexion) {
        mensajeEstableceConexion = "Problemas desconocidos al establecer la conexion";
        mensajeCierraConexion = "Problemas desconocidos al cerrar la conexion";
    }

    public ProblemasConexion(String mensajeEstableceConexion) {
        mensajeEstableceConexion = "Problemas desconocidos al establecer la conexion";
    }

    public String getMensajeEstableceConexion() {
        return mensajeEstableceConexion;
    }

    public void setMensajeEstableceConexion(String mensajeEstableceConexion) {
        this.mensajeEstableceConexion = mensajeEstableceConexion;
    }

    public String getMensajeCierraConexion() {
        return mensajeCierraConexion;
    }

    public void setMensajeCierraConexion(String mensajeCierraConexion) {
        this.mensajeCierraConexion = mensajeCierraConexion;
    }
    
    

}
