package ModelUML;

import java.util.Date;

/**
 * @author MIGUEL
 */

public class Partido {

    private Integer codPartido;
    private Date horaInicio;
    private Integer puntosLocal;
    private Integer puntosVisitante;

    // ATRIBUTO DE LA RELACION CON EQUIPO
    private Equipo codLocal;
    private Equipo codVisitante;
    
    // ATRIBUTO DE LA RELACION CON JORNADA
    private Jornada codJornada;

    public Partido() {
    }

    public Partido(Integer codPartido, Date horaInicio, Integer puntosLocal, Integer puntosVisitante) {
        this.codPartido = codPartido;
        this.horaInicio = horaInicio;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
    }

    public Partido(Integer codPartido, Date horaInicio, Integer puntosLocal, Integer puntosVisitante, Equipo codLocal, Equipo codVisitante) {
        this.codPartido = codPartido;
        this.horaInicio = horaInicio;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.codLocal = codLocal;
        this.codVisitante = codVisitante;
    }

    public Partido(Integer codPartido, Date horaInicio, Integer puntosLocal, Integer puntosVisitante, Jornada codJornada) {
        this.codPartido = codPartido;
        this.horaInicio = horaInicio;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.codJornada = codJornada;
    }

    public Partido(Integer codPartido, Date horaInicio, Integer puntosLocal, Integer puntosVisitante, Equipo codLocal, Equipo codVisitante, Jornada codJornada) {
        this.codPartido = codPartido;
        this.horaInicio = horaInicio;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.codLocal = codLocal;
        this.codVisitante = codVisitante;
        this.codJornada = codJornada;
    }

    public Integer getCodPartido() {
        return codPartido;
    }

    public void setCodPartido(Integer codPartido) {
        this.codPartido = codPartido;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(Integer puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public Integer getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(Integer puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public Equipo getCodLocal() {
        return codLocal;
    }

    public void setCodLocal(Equipo codLocal) {
        this.codLocal = codLocal;
    }

    public Equipo getCodVisitante() {
        return codVisitante;
    }

    public void setCodVisitante(Equipo codVisitante) {
        this.codVisitante = codVisitante;
    }

    public Jornada getCodJornada() {
        return codJornada;
    }

    public void setCodJornada(Jornada codJornada) {
        this.codJornada = codJornada;
    }
    
    

    
    

}
