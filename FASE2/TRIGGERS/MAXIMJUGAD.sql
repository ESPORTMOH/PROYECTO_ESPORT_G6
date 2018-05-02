create or replace TRIGGER jugadoresMaximoEquipo
  BEFORE INSERT ON jugador
      FOR EACH ROW
        DECLARE
          v_cantidadJugadores number;
          demasiadosJugadores EXCEPTION;
          BEGIN
            SELECT count(*)
            INTO v_cantidadJugadores
            FROM jugador;
            
            IF(v_cantidadJugadores>5)THEN
              RAISE demasiadosJugadores;
            END IF;  
EXCEPTION 
WHEN demasiadosJugadores THEN 
RAISE_APPLICATION_ERROR(-20100, 'Error demasiados: '||SQLERRM);

END;