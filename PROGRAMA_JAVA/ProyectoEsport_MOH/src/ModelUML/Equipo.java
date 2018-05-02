package ModelUML;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author MIGUEL
 */
public class Equipo {

    private Integer codEquipo;
    private String nombre;
    private Integer presupuesto;
    private String anioFundacion;
    private String ciudad;
    private String nombreEstadio;

    // ATRIBUTO DE LA RELACION CON JUGADOR
    private ArrayList<Jugador> listaJugadores = new ArrayList<>();

    public Equipo() {
    }

    public Equipo(Integer codEquipo, String nombre, Integer presupuesto, String anioFundacion, String ciudad, String nombreEstadio) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.anioFundacion = anioFundacion;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
    }
    
    public Equipo(Integer codLogin) {
        this.codEquipo = codEquipo;
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

    public Integer getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Integer presupuesto) {
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
    
    

    
    
    

}
