package ModelUML;

/**
 *
 * @author 1gdaw12
 */
public class Clasificacion {
    private Integer codClasificacion;
    private Integer puntos;
    private String numeroTemporada;
    private Equipo equipo;

    public Clasificacion() {
    }

    public Clasificacion(Integer puntos, String numeroTemporada, Equipo equipo) {
        this.puntos = puntos;
        this.numeroTemporada = numeroTemporada;
        this.equipo = equipo;
    }

    public Clasificacion(Integer codClasificacion, Integer puntos, String numeroTemporada, Equipo equipo) {
        this.codClasificacion = codClasificacion;
        this.puntos = puntos;
        this.numeroTemporada = numeroTemporada;
        this.equipo = equipo;
    }

    public Integer getCodClasificacion() {
        return codClasificacion;
    }

    public void setCodClasificacion(Integer codClasificacion) {
        this.codClasificacion = codClasificacion;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public String getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(String numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    
}
