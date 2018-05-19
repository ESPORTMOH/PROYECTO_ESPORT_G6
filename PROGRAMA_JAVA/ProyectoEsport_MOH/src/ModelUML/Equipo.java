package ModelUML;

import java.util.ArrayList;

/**
 * @author MIGUEL OLMO HERNANDO
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
    
    /**
     * 
     * @param codEquipo 
     */
    public Equipo(Integer codEquipo) {
        this.codEquipo = codEquipo;
    }

    /**
     * 
     * @param codEquipo
     * @param nombre
     * @param presupuesto
     * @param anioFundacion
     * @param ciudad
     * @param nombreEstadio 
     */
    public Equipo(Integer codEquipo, String nombre, Double presupuesto, String anioFundacion, String ciudad, String nombreEstadio) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.anioFundacion = anioFundacion;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
    }

    /**
     * 
     * @param codEquipo
     * @param nombre
     * @param presupuesto
     * @param anioFundacion
     * @param ciudad
     * @param nombreEstadio
     * @param duenio 
     */
    public Equipo(Integer codEquipo, String nombre, Double presupuesto, String anioFundacion, String ciudad, String nombreEstadio, Duenio duenio) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.anioFundacion = anioFundacion;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
        this.duenio = duenio;
    }

    /**
     * 
     * @param nombre
     * @param presupuesto
     * @param anioFundacion
     * @param ciudad
     * @param nombreEstadio 
     */
    public Equipo(String nombre, Double presupuesto, String anioFundacion, String ciudad, String nombreEstadio) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.anioFundacion = anioFundacion;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
    }

    /**
     * 
     * @param nombre
     * @param presupuesto
     * @param anioFundacion
     * @param ciudad
     * @param nombreEstadio
     * @param tipoCodDuenioEquipoDefecto 
     */
    public Equipo(String nombre, Double presupuesto, String anioFundacion, String ciudad, String nombreEstadio, Integer tipoCodDuenioEquipoDefecto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.anioFundacion = anioFundacion;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
        this.duenio = duenio;
    }

    /**
     * 
     * @param nombre
     * @param presupuesto
     * @param anioFundacion
     * @param ciudad
     * @param nombreEstadio
     * @param duenio 
     */
    public Equipo(String nombre, double presupuesto, String anioFundacion, String ciudad, String nombreEstadio, Duenio duenio) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.anioFundacion = anioFundacion;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
        this.duenio = duenio;
    }

    /**
     * 
     * @return codEquipo
     */
    public Integer getCodEquipo() {
        return codEquipo;
    }

    /**
     * 
     * @param codEquipo 
     */
    public void setCodEquipo(Integer codEquipo) {
        this.codEquipo = codEquipo;
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
     * @return presupuesto
     */
    public Double getPresupuesto() {
        return presupuesto;
    }

    /**
     * 
     * @param presupuesto 
     */
    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * 
     * @return anioFundacion
     */
    public String getAnioFundacion() {
        return anioFundacion;
    }

    /**
     * 
     * @param anioFundacion 
     */
    public void setAnioFundacion(String anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    /**
     * 
     * @return ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * 
     * @param ciudad 
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * 
     * @return nombreEstadio
     */
    public String getNombreEstadio() {
        return nombreEstadio;
    }

    /**
     * 
     * @param nombreEstadio 
     */
    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    /**
     * 
     * @return listaJugadores
     */
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    /**
     * 
     * @param listaJugadores 
     */
    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    /**
     * 
     * @return duenio
     */
    public Duenio getDuenio() {
        return duenio;
    }

    /**
     * 
     * @param duenio 
     */
    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

}
