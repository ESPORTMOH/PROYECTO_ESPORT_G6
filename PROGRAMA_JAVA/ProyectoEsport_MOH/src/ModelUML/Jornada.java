package ModelUML;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author MIGUEL
 */
public class Jornada {

    private Date fechaInicio;
    private Date fechaFin;
    private String numeroJornada;
    private String numeroTemporada;

    // ATRIBUTO DE LA RELACION CON PARTIDO
    private ArrayList<Jugador> listaPartidos = new ArrayList<>();

    public Jornada() {
    }

    public Jornada(Date fechaInicio, Date fechaFin, String numeroJornada, String numeroTemporada) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroJornada = numeroJornada;
        this.numeroTemporada = numeroTemporada;
    }

    public Jornada(Date fechaInicio, Date fechaFin, String numeroJornada, String numeroTemporada, ArrayList listaPartidos) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroJornada = numeroJornada;
        this.numeroTemporada = numeroTemporada;
        this.listaPartidos = listaPartidos;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNumeroJornada() {
        return numeroJornada;
    }

    public void setNumeroJornada(String numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    public String getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(String numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public ArrayList<Jugador> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(ArrayList<Jugador> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }
    
    

}
