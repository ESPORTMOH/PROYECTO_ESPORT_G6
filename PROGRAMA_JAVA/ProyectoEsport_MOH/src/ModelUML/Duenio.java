package ModelUML;

/**
 *
 * @author MIGUEL OLMO HERNANDO
 */
public class Duenio {

    private Integer codDuenio;
    private String dni;
    private String nombre;
    private String apellido;
    private Integer estado;

    private boolean duenioEncontrado;

    // ATRIBUTO DE LA RELACION CON LOGIN
    private Login login;

    public Duenio() {
    }

    /**
     *
     * @param estado
     */
    public Duenio(Integer estado) {
        this.estado = estado;
    }

    /**
     *
     * @param dni
     * @param nombre
     * @param apellido
     */
    public Duenio(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     *
     * @param codDuenio
     * @param dni
     * @param nombre
     * @param apellido
     */
    public Duenio(Integer codDuenio, String dni, String nombre, String apellido) {
        this.codDuenio = codDuenio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     *
     * @param codDuenio
     * @param dni
     * @param nombre
     * @param apellido
     * @param login
     * @param estado
     */
    public Duenio(Integer codDuenio, String dni, String nombre, String apellido, Login login, Integer estado) {
        this.codDuenio = codDuenio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
        this.estado = estado;
    }

    /**
     *
     * @param aInt
     */
    public Duenio(int aInt) {
        this.codDuenio = aInt;
    }

    /**
     *
     * @param dni
     * @param nombre
     * @param apellido
     * @param estado
     */
    public Duenio(String dni, String nombre, String apellido, Integer estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    /**
     *
     * @return codDuenio
     */
    public Integer getCodDuenio() {
        return codDuenio;
    }

    /**
     *
     * @param codDuenio
     */
    public void setCodDuenio(Integer codDuenio) {
        this.codDuenio = codDuenio;
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
     * @return 
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

    /**
     * 
     * @return duenioEncontrado
     */
    public boolean getDuenioEncontrado() {
        return duenioEncontrado;
    }

    /**
     * 
     * @param duenioEncontrado 
     */
    public void setDuenioEncontrado(boolean duenioEncontrado) {
        this.duenioEncontrado = duenioEncontrado;
    }

    /**
     * 
     * @return estado
     */
    public Integer getEstado() {
        return estado;
    }

    /**
     * 
     * @param estado 
     */
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
