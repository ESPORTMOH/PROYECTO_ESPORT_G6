package ModelUML;

import java.util.Date;

/**
 * @author MIGUEL
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

    // ATRIBUTO DE LA RELACION CON EQUIPO
    private Equipo equipo;

    public Jugador() {
    }

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

    public Integer getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(Integer codJugador) {
        this.codJugador = codJugador;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    

 
}
