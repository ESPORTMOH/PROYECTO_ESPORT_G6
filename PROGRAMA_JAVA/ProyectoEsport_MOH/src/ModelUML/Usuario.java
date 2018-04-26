package ModelUML;

/**
 * @author MIGUEL
 */
public class Usuario {

    private Integer codUsuario;
    private String dni;
    private String nombre;
    private String apellido;
    
    // ATRIBUTO DE LA RELACION CON LOGIN
    private Login login;

    public Usuario() {
    }

    public Usuario(Integer codUsuario, String dni, String nombre, String apellido) {
        this.codUsuario = codUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario(Integer codUsuario, String dni, String nombre, String apellido, Login login) {
        this.codUsuario = codUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
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
