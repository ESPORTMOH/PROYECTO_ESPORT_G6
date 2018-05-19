create or replace TRIGGER jugadoresMaximoEquipo
  BEFORE INSERT OR UPDATE ON jugador
      FOR EACH ROW
        DECLARE
          v_cantidadJugadores Integer;
          BEGIN
            SELECT count(codJugador)
            INTO v_cantidadJugadores
            FROM jugador
            WHERE CODEQUIPO = :new.CODEQUIPO;
            IF(v_cantidadJugadores>5)THEN
              RAISE_APPLICATION_ERROR(-20250,'Estás introduciendo mas jugadores de lo permitido');
            END IF;
END;