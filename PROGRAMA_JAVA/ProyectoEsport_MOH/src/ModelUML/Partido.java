package ModelUML;

import java.util.Date;

/**
 * @author MIGUEL OLMO HERNANDO
 */

public class Partido {

    private Integer codPartido;
    private Date fechaPartido;
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

    /**
     * 
     * @param fechaPartido
     * @param horaInicio
     * @param puntosLocal
     * @param puntosVisitante
     * @param codLocal
     * @param codVisitante
     * @param codJornada 
     */
    public Partido(Date fechaPartido, Date horaInicio, Integer puntosLocal, Integer puntosVisitante, Equipo codLocal, Equipo codVisitante, Jornada codJornada) {
        this.fechaPartido = fechaPartido;
        this.horaInicio = horaInicio;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.codLocal = codLocal;
        this.codVisitante = codVisitante;
        this.codJornada = codJornada;
    }

    /**
     * 
     * @param codPartido
     * @param horaInicio
     * @param puntosLocal
     * @param puntosVisitante 
     */
    public Partido(Integer codPartido, Date horaInicio, Integer puntosLocal, Integer puntosVisitante) {
        this.codPartido = codPartido;
        this.horaInicio = horaInicio;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
    }

    /**
     * 
     * @param codPartido
     * @param horaInicio
     * @param puntosLocal
     * @param puntosVisitante
     * @param codLocal
     * @param codVisitante 
     */
    public Partido(Integer codPartido, Date horaInicio, Integer puntosLocal, Integer puntosVisitante, Equipo codLocal, Equipo codVisitante) {
        this.codPartido = codPartido;
        this.horaInicio = horaInicio;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.codLocal = codLocal;
        this.codVisitante = codVisitante;
    }

    /**
     * 
     * @param codPartido
     * @param horaInicio
     * @param puntosLocal
     * @param puntosVisitante
     * @param codJornada 
     */
    public Partido(Integer codPartido, Date horaInicio, Integer puntosLocal, Integer puntosVisitante, Jornada codJornada) {
        this.codPartido = codPartido;
        this.horaInicio = horaInicio;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.codJornada = codJornada;
    }

    /**
     * 
     * @param codPartido
     * @param horaInicio
     * @param puntosLocal
     * @param puntosVisitante
     * @param codLocal
     * @param codVisitante
     * @param codJornada 
     */
    public Partido(Integer codPartido, Date horaInicio, Integer puntosLocal, Integer puntosVisitante, Equipo codLocal, Equipo codVisitante, Jornada codJornada) {
        this.codPartido = codPartido;
        this.horaInicio = horaInicio;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.codLocal = codLocal;
        this.codVisitante = codVisitante;
        this.codJornada = codJornada;
    }

    /**
     * 
     * @return codPartido
     */
    public Integer getCodPartido() {
        return codPartido;
    }

    /**
     * 
     * @param codPartido 
     */
    public void setCodPartido(Integer codPartido) {
        this.codPartido = codPartido;
    }

    /**
     * 
     * @return horaInicio
     */
    public Date getHoraInicio() {
        return horaInicio;
    }

    /**
     * 
     * @param horaInicio 
     */
    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * 
     * @return puntosLocal
     */
    public Integer getPuntosLocal() {
        return puntosLocal;
    }

    /**
     * 
     * @param puntosLocal 
     */
    public void setPuntosLocal(Integer puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    /**
     * 
     * @return puntosVisitante
     */
    public Integer getPuntosVisitante() {
        return puntosVisitante;
    }

    /**
     * 
     * @param puntosVisitante 
     */
    public void setPuntosVisitante(Integer puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    /**
     * 
     * @return codLocal
     */
    public Equipo getCodLocal() {
        return codLocal;
    }

    /**
     * 
     * @param codLocal 
     */
    public void setCodLocal(Equipo codLocal) {
        this.codLocal = codLocal;
    }

    /**
     * 
     * @return codVisitante
     */
    public Equipo getCodVisitante() {
        return codVisitante;
    }

    /**
     * 
     * @param codVisitante 
     */
    public void setCodVisitante(Equipo codVisitante) {
        this.codVisitante = codVisitante;
    }

    /**
     * 
     * @return codJornada
     */
    public Jornada getCodJornada() {
        return codJornada;
    }

    /**
     * 
     * @param codJornada 
     */
    public void setCodJornada(Jornada codJornada) {
        this.codJornada = codJornada;
    }

    /**
     * 
     * @return fechaPartido
     */
    public Date getFechaPartido() {
        return fechaPartido;
    }

    /**
     * 
     * @param fechaPartido 
     */
    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

}
