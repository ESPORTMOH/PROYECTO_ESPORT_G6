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
    private Integer estado;

    private boolean duenioEncontrado;

    // ATRIBUTO DE LA RELACION CON LOGIN
    private Login login;

    public Duenio() {
    }

    public Duenio(Integer estado) {
        this.estado = estado;
    }

    public Duenio(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Duenio(Integer codDuenio, String dni, String nombre, String apellido) {
        this.codDuenio = codDuenio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Duenio(Integer codDuenio, String dni, String nombre, String apellido, Login login, Integer estado) {
        this.codDuenio = codDuenio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.login = login;
        this.estado = estado;
    }

    public Duenio(int aInt) {
        this.codDuenio = aInt;
    }

    public Duenio(String dni, String nombre, String apellido, Integer estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
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

    public boolean getDuenioEncontrado() {
        return duenioEncontrado;
    }

    public void setDuenioEncontrado(boolean duenioEncontrado) {
        this.duenioEncontrado = duenioEncontrado;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
