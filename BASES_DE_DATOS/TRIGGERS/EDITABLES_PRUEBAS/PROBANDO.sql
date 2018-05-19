/*
TRABAJANDO EN ESTOS TRIGGERS
*/


// LIADA MAXIMA PORQUE ES AL ACTUALIZAR Y NO EXISTE COD JORNADA
create or replace TRIGGER resultado_clasificacion_trig
    BEFORE UPDATE ON partido  --REFERENCING OLD AS old NEW AS new
    FOR EACH ROW
DECLARE
    puntosLo     clasificacion.puntos%TYPE;
    puntosVi     clasificacion.puntos%TYPE;
    puntosVisitante clasificacion.puntos%TYPE;
    numeroTep  clasificacion.codJornada%TYPE;
BEGIN

puntosLo:= :new.puntosLocal;
puntosVi:= :new.puntosVisitante;
numeroTep := :new.codJornada;

    IF (puntosLo < puntosVi) THEN
      dbms_output.put_line('ganador visitante'); 
        SELECT puntos INTO puntosVisitante 
        FROM clasificacion
        WHERE codEquipo = :new.codVisitante AND codJornada = numeroTep;
         
        UPDATE clasificacion
        SET puntos = (puntosVisitante+3)
        WHERE codEquipo = :new.codVisitante AND codJornada = numeroTep;   
    END IF;
END;

// EL VIEJO CON LA OTRA TABLA DE RESULTADOS 

CREATE OR REPLACE TRIGGER resultado_clasificacion_trig
    BEFORE INSERT ON resultado
    FOR EACH ROW
DECLARE
    puntosLocal         clasificacion.puntos%TYPE;
    puntosVisitante     clasificacion.puntos%TYPE;
BEGIN
    IF (:NEW.puntosLocal < :NEW.puntosVisiatante) THEN
      dbms_output.put_line('ganador visitante'); 
        SELECT puntos INTO puntosVisitante 
        FROM clasificacion
        WHERE codEquipo = :NEW.codVisitante AND temporada = :NEW.temporada;
        
        UPDATE clasificacion
        SET puntos = (puntosVisitante+3)
        WHERE codEquipo = :NEW.codVisitante AND temporada = :NEW.temporada;   
    ELSIF (:NEW.puntosLocal > :NEW.puntosVisiatante) THEN
      dbms_output.put_line('ganador local');
        SELECT puntos INTO puntosLocal 
        FROM clasificacion
        WHERE codEquipo = :NEW.codLocal AND temporada = :NEW.temporada;
        
        UPDATE clasificacion
        SET puntos = (puntosLocal+3)
        WHERE codEquipo = :NEW.codLocal AND temporada = :NEW.temporada;
    ELSE 
      dbms_output.put_line('empate');
        SELECT puntos INTO puntosLocal 
        FROM clasificacion
        WHERE codEquipo = :NEW.codLocal AND temporada = :NEW.temporada;
        
        UPDATE clasificacion
        SET puntos = (puntosLocal+1)
        WHERE codEquipo = :NEW.codLocal AND temporada = :NEW.temporada;
        
        SELECT puntos INTO puntosVisitante 
        FROM clasificacion
        WHERE codEquipo = :NEW.codVisitante AND temporada = NEW.temporada;
        
        UPDATE clasificacion
        SET puntos = (puntosVisitante+1)
        WHERE codEquipo = :NEW.codVisitante AND temporada = NEW.temporada;
    END IF;
END;
