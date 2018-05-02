set SERVEROUTPUT ON;

create or replace TRIGGER salarioMinimoinimo
  BEFORE INSERT OR UPDATE ON jugador
      FOR EACH ROW
        DECLARE
          v_sueldosTotales NUMBER;
          v_presupuestoMaximoPorEquipo number:=200000;
          v_error EXCEPTION;
          BEGIN
            SELECT sum(sueldo)
            INTO v_sueldosTotales
            FROM jugador;

            IF(v_sueldosTotales>v_presupuestoMaximoPorEquipo)THEN
            
              RAISE v_error;
            END IF;
           exception
           when v_error then
            RAISE_APPLICATION_ERROR(-20250,'Estás introduciendo un salario inferior al salario mínimo');
            
END;

