CREATE OR REPLACE PROCEDURE actualizarClasificacion(p_pLocal in NUMBER , p_pVisitante in NUMBER, p_codLocal in NUMBER, p_codVisitante in NUMBER, p_numTemporada in VARCHAR2) AS 
  
  puntosVisitante clasificacion.puntos%TYPE;
  puntosLocal clasificacion.puntos%TYPE;
  
BEGIN 
  IF p_pLocal < p_pVisitante THEN
    SELECT puntos INTO puntosVisitante 
      FROM clasificacion
        WHERE CODEQUIPO = p_codVisitante 
          AND NUMEROTEMPORADA = p_numTemporada;
      UPDATE clasificacion
        SET puntos = (puntosVisitante+1)
          WHERE CODEQUIPO = p_codVisitante 
            AND NUMEROTEMPORADA = p_numTemporada;  
    ELSE 
      SELECT puntos INTO puntosLocal 
        FROM clasificacion
          WHERE CODEQUIPO = p_codLocal 
            AND NUMEROTEMPORADA = p_numTemporada;
      UPDATE clasificacion
      SET puntos = (puntosVisitante+1)
        WHERE CODEQUIPO = p_codLocal 
          AND NUMEROTEMPORADA = p_numTemporada; 
  END IF;
    EXCEPTION 
      WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20100, 'Error en pr_Crea_Login: '||SQLERRM);
END;
  