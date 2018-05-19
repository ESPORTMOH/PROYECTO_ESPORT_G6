package ModelUML;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author MIGUEL
 */
public class Jornada {

    private Integer codJornada;
    private String numeroJornada;
    private String numeroTemporada;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;

    // ATRIBUTO DE LA RELACION CON PARTIDO
    private ArrayList<Jugador> listaPartidos = new ArrayList<>();

    public Jornada() {
    }

    public Jornada(String numeroJornada, String numeroTemporada, Equipo equipoLocal, Equipo equipoVisitante) {
        this.numeroJornada = numeroJornada;
        this.numeroTemporada = numeroTemporada;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public Integer getCodJornada() {
        return codJornada;
    }

    public void setCodJornada(Integer codJornada) {
        this.codJornada = codJornada;
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

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public ArrayList<Jugador> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(ArrayList<Jugador> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }
    
    

}
