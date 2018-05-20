package ModelUML;

/**
 * @author MIGUEL OLMO HERNANDO
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

    /**
     * 
     * @param dni
     * @param nombre
     * @param apellido 
     */
    public Usuario(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * 
     * @param codUsuario
     * @param dni
     * @param nombre
     * @param apellido 
     */
    public Usuario(Integer codUsuario, String dni, String nombre, String apellido) {
        this.codUsuario = codUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * 
     * @param codUsuario
     * @param dni
     * @param nombre
     * @param apellido
     * @param login 
     */
    public Usuario(Integer codUsuario, String dni, String nombre, String apellido, Login login) {
        this.codUsuario = codUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
    }

    /**
     * 
     * @return coUsuario
     */
    public Integer getCodUsuario() {
        return codUsuario;
    }

    /**
     * 
     * @param codUsuario 
     */
    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
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
     * 
     * @return nombre
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
     * 
     * @return apellido
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
