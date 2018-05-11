CREATE OR REPLACE TRIGGER TRIGG_jugadoresMaximoEquipo
  BEFORE INSERT ON jugador
    FOR EACH ROW
      DECLARE
        v_cantidadJugadores NUMBER;
        demasiadosJugadores EXCEPTION;
      BEGIN
        SELECT COUNT(*)
          INTO v_cantidadJugadores
            FROM jugador;  
              IF(v_cantidadJugadores>5)THEN
                RAISE demasiadosJugadores;
              END IF;  
      EXCEPTION 
        WHEN demasiadosJugadores THEN 
          RAISE_APPLICATION_ERROR(-20100, 'Lo sentimos pero los Equipos solo pueden tener en Plantilla a 6 Jugadores'||SQLERRM);
END;