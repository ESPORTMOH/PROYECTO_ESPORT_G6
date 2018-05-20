package ModelUML;

/**
 * @author MIGUEL OLMO HERNANDO
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

    /**
     *
     * @param codAdministrador
     * @param dni
     * @param nombre
     * @param apellido
     * @param estado
     * @param login
     */
    public Administrador(Integer codAdministrador, String dni, String nombre, String apellido, Integer estado, Login login) {
        this.codAdministrador = codAdministrador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
    }

    /**
     * 
     * @param dni
     * @param nombre
     * @param apellido 
     */
    public Administrador(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * 
     * @param codAdministrador
     * @param dni
     * @param nombre
     * @param apellido 
     */
    public Administrador(Integer codAdministrador, String dni, String nombre, String apellido) {
        this.codAdministrador = codAdministrador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * 
     * @param codAdministrador
     * @param dni
     * @param nombre
     * @param apellido
     * @param login 
     */
    public Administrador(Integer codAdministrador, String dni, String nombre, String apellido, Login login) {
        this.codAdministrador = codAdministrador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
    }

    /**
     * 
     * @return codAdministrador
     */
    public Integer getCodAdministrador() {
        return codAdministrador;
    }

    /**
     * 
     * @param codAdministrador 
     */
    public void setCodAdministrador(Integer codAdministrador) {
        this.codAdministrador = codAdministrador;
    }

    /**
     * 
     * @return dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * 
     * @param dni 
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * apellido
     * @return 
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * 
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * 
     * @return login 
     */
    public Login getLogin() {
        return login;
    }

    /**
     * 
     * @param login 
     */
    public void setLogin(Login login) {
        this.login = login;
    }

}
