create or replace TRIGGER TRIGG_jugadoresMaximoEquipo
  BEFORE INSERT ON jugador
    FOR EACH ROW
      DECLARE
        v_cantidadJugadores NUMBER;
        v_codEquipo NUMBER;
        demasiadosJugadores EXCEPTION;
      BEGIN
      v_codEquipo := :NEW.codEquipo;
        SELECT COUNT(*)
          INTO v_cantidadJugadores
            FROM jugador
              WHERE codEquipo = v_codEquipo
              AND codEquipo <> 1;  
              IF(v_cantidadJugadores>5)THEN
                RAISE demasiadosJugadores;
              END IF;  
      EXCEPTION 
        WHEN demasiadosJugadores THEN 
          RAISE_APPLICATION_ERROR(-20100, 'Lo sentimos pero los Equipos solo pueden tener en Plantilla a 6 Jugadores'||SQLERRM);
END;