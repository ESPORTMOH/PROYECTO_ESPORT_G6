package ModelUML;

/**
 *
 * @author MIGUEL
 */
public class Duenio {

    private Integer codDuenio;
    private String dni;
    private String nombre;
    private String apellido;

    // ATRIBUTO DE LA RELACION CON LOGIN
    private Login login;

    public Duenio() {
    }

    public Duenio(Integer codDuenio, String dni, String nombre, String apellido) {
        this.codDuenio = codDuenio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Duenio(Integer codDuenio, String dni, String nombre, String apellido, Login login) {
        this.codDuenio = codDuenio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
    }

    public Integer getCodDuenio() {
        return codDuenio;
    }

    public void setCodDuenio(Integer codDuenio) {
        this.codDuenio = codDuenio;
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
