package ModelUML;

import java.util.ArrayList;

/**
 * @author MIGUEL
 */
public class Equipo {

    private Integer codEquipo;
    private String nombre;
    private Double presupuesto;
    private String anioFundacion;
    private String ciudad;
    private String nombreEstadio;

    // ATRIBUTO DE LA RELACION CON JUGADOR
    private ArrayList<Jugador> listaJugadores = new ArrayList<>();

    // ATRIBUTO DE LA RELACION CON DUEÑO
    private Duenio duenio;

    public Equipo() {
    }

    public Equipo(Integer codEquipo) {
        this.codEquipo = codEquipo;
    }

    public Equipo(Integer codEquipo, String nombre, Double presupuesto, String anioFundacion, String ciudad, String nombreEstadio) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.anioFundacion = anioFundacion;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
    }

    public Equipo(Integer codEquipo, String nombre, Double presupuesto, String anioFundacion, String ciudad, String nombreEstadio, Duenio duenio) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.anioFundacion = anioFundacion;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
        this.duenio = duenio;
    }

    public Equipo(String nombre, Double presupuesto, String anioFundacion, String ciudad, String nombreEstadio) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.anioFundacion = anioFundacion;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
    }

    public Equipo(String nombre, Double presupuesto, String anioFundacion, String ciudad, String nombreEstadio, Integer tipoCodDuenioEquipoDefecto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.anioFundacion = anioFundacion;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
        this.duenio = duenio;
    }

    public Equipo(String nombre, double presupuesto, String anioFundacion, String ciudad, String nombreEstadio, Duenio duenio) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.anioFundacion = anioFundacion;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
        this.duenio = duenio;
    }

    public Integer getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(Integer codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(String anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public Duenio getDuenio() {
        return duenio;
    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

}
