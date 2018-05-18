CREATE OR REPLACE TRIGGER TRIGG_salarioMinimoTotal
  BEFORE INSERT ON jugador
    FOR EACH ROW
      DECLARE
        v_sueldosTotales NUMBER;
        v_presupuestoMaximoPorEquipo NUMBER:=200000;
        v_nuevoSueldo NUMBER;
        v_error EXCEPTION;
      BEGIN
        SELECT SUM(sueldo)
        INTO v_sueldosTotales
          FROM jugador;
            v_nuevoSueldo := :new.sueldo+v_sueldosTotales;
              IF(v_nuevoSueldo>v_presupuestoMaximoPorEquipo)THEN
                RAISE v_error;
              END IF;
           EXCEPTION
            WHEN v_error THEN
              RAISE_APPLICATION_ERROR(-20250,'Estás introduciendo un salario inferior al salario mínimo');         
END;


