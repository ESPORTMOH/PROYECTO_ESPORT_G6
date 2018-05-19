package ModelUML;

import java.util.Date;

/**
 * @author MIGUEL OLMO HERNANDO
 */
public class Jugador {

    private Integer codJugador;
    private String dni;
    private String nombre;
    private String apellido;
    private String nickname;
    private Double sueldo;
    private Date fechaNacimiento;
    private String nacionalidad;
    private String posicion;
    private String estado;

    // ATRIBUTO DE LA RELACION CON EQUIPO
    private Equipo equipo;

    public Jugador() {
    }

    /**
     *
     * @param codJugador
     * @param dni
     * @param nombre
     * @param apellido
     * @param nickname
     * @param sueldo
     * @param fechaNacimiento
     * @param nacionalidad
     * @param posicion
     */
    public Jugador(Integer codJugador, String dni, String nombre, String apellido, String nickname, Double sueldo, Date fechaNacimiento, String nacionalidad, String posicion) {
        this.codJugador = codJugador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.sueldo = sueldo;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
    }

    /**
     *
     * @param codJugador
     * @param dni
     * @param nombre
     * @param apellido
     * @param nickname
     * @param sueldo
     * @param fechaNacimiento
     * @param nacionalidad
     * @param posicion
     * @param equipo
     */
    public Jugador(Integer codJugador, String dni, String nombre, String apellido, String nickname, Double sueldo, Date fechaNacimiento, String nacionalidad, String posicion, Equipo equipo) {
        this.codJugador = codJugador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.sueldo = sueldo;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
        this.equipo = equipo;
    }

    /**
     *
     * @param dni
     * @param nombre
     * @param apellido
     * @param nickname
     * @param sueldo
     * @param fechaNacimiento
     * @param nacionalidad
     * @param posicion
     */
    public Jugador(String dni, String nombre, String apellido, String nickname, Double sueldo, Date fechaNacimiento, String nacionalidad, String posicion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.sueldo = sueldo;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
    }

    /**
     *
     * @param estado
     */
    public Jugador(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @param dni
     * @param nombre
     * @param apellido
     * @param nickname
     * @param sueldo
     * @param fechaNacimiento
     * @param nacionalidad
     * @param posicion
     * @param estado
     */
    public Jugador(String dni, String nombre, String apellido, String nickname, Double sueldo, Date fechaNacimiento, String nacionalidad, String posicion, Integer estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.sueldo = sueldo;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
    }

    /**
     *
     * @return codJugador
     */
    public Integer getCodJugador() {
        return codJugador;
    }

    /**
     * 
     * @param codJugador 
     */
    public void setCodJugador(Integer codJugador) {
        this.codJugador = codJugador;
    }

    /**
     * 
     * @return  dni
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
     * @return  apellido
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
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 
     * @param nickname 
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 
     * @return sueldo
     */
    public Double getSueldo() {
        return sueldo;
    }

    /**
     * 
     * @param sueldo 
     */
    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * 
     * @return fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * 
     * @param fechaNacimiento 
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * 
     * @return nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * 
     * @param nacionalidad 
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * 
     * @return posicion
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * 
     * @param posicion 
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    /**
     * 
     * @return equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * 
     * @param equipo 
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * 
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * 
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
