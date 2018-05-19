package ModelUML;

/**
 *
 * @author MIGUEL OLMO HERNANDO
 */
public class Clasificacion {
    private Integer codClasificacion;
    private Integer puntos;
    private String numeroTemporada;
    private Equipo equipo;

    public Clasificacion() {
    }

    /**
     * 
     * @param puntos
     * @param numeroTemporada
     * @param equipo 
     */
    public Clasificacion(Integer puntos, String numeroTemporada, Equipo equipo) {
        this.puntos = puntos;
        this.numeroTemporada = numeroTemporada;
        this.equipo = equipo;
    }

    /**
     * 
     * @param codClasificacion
     * @param puntos
     * @param numeroTemporada
     * @param equipo 
     */
    public Clasificacion(Integer codClasificacion, Integer puntos, String numeroTemporada, Equipo equipo) {
        this.codClasificacion = codClasificacion;
        this.puntos = puntos;
        this.numeroTemporada = numeroTemporada;
        this.equipo = equipo;
    }

    /**
     * 
     * @return codClasificacion
     */
    public Integer getCodClasificacion() {
        return codClasificacion;
    }

    /**
     * 
     * @param codClasificacion 
     */
    public void setCodClasificacion(Integer codClasificacion) {
        this.codClasificacion = codClasificacion;
    }

    /**
     * 
     * @return puntos
     */
    public Integer getPuntos() {
        return puntos;
    }

    /**
     * 
     * @param puntos 
     */
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    /**
     * numeroTemporada
     * @return 
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
    
    
}
