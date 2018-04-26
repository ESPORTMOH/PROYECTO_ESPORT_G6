package ModelUML;

/**
 * @author MIGUEL
 */
public class Administrador {

    private Integer codAdministrador;
    private String dni;
    private String nombre;
    private String apellido;
    
    // ATRIBUTO DE LA RELACION CON LOGIN
    private Login login;

    public Administrador() {
    }

    public Administrador(Integer codAdministrador, String dni, String nombre, String apellido) {
        this.codAdministrador = codAdministrador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Administrador(Integer codAdministrador, String dni, String nombre, String apellido, Login login) {
        this.codAdministrador = codAdministrador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
    }

    public Integer getCodAdministrador() {
        return codAdministrador;
    }

    public void setCodAdministrador(Integer codAdministrador) {
        this.codAdministrador = codAdministrador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    

}
