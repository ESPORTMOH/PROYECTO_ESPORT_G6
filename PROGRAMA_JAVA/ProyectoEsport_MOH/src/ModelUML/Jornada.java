package ModelUML;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author MIGUEL OLMO HERNANDO
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

    /**
     * 
     * @param numeroJornada
     * @param numeroTemporada
     * @param equipoLocal
     * @param equipoVisitante 
     */
    public Jornada(String numeroJornada, String numeroTemporada, Equipo equipoLocal, Equipo equipoVisitante) {
        this.numeroJornada = numeroJornada;
        this.numeroTemporada = numeroTemporada;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    /**
     * 
     * @return codJornada
     */
    public Integer getCodJornada() {
        return codJornada;
    }

    /**
     * 
     * @param codJornada 
     */
    public void setCodJornada(Integer codJornada) {
        this.codJornada = codJornada;
    }

    /**
     * 
     * @return numeroJornada
     */
    public String getNumeroJornada() {
        return numeroJornada;
    }

    /**
     * 
     * @param numeroJornada 
     */
    public void setNumeroJornada(String numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    /**
     * 
     * @return numeroTemporada
     */
    public String getNumeroTemporada() {
        return numeroTemporada;
    }

    /**
     * 
     * @param numeroTemporada 
     */
    public void setNumeroTemporada(String numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    /**
     * 
     * @return equipoLocal
     */
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    /**
     * 
     * @param equipoLocal 
     */
    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    /**
     * 
     * @return equipoVisitante
     */
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    /**
     * 
     * @param equipoVisitante 
     */
    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    /**
     * 
     * @return listapartidos
     */
    public ArrayList<Jugador> getListaPartidos() {
        return listaPartidos;
    }

    /**
     * 
     * @param listaPartidos 
     */
    public void setListaPartidos(ArrayList<Jugador> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }
    
    

}
