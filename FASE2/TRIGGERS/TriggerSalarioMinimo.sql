CREATE OR REPLACE TRIGGER salarioMinimoinimo
  BEFORE INSERT OR UPDATE ON jugador
      FOR EACH ROW
        DECLARE
          v_minimo tablaSalario.sueldoBase%type;
          BEGIN
            SELECT sueldo
            INTO v_minimo
            FROM tablaSalario;

            IF(:NEW.salario<v_minimo)THEN
              RAISE_APPLICATION_ERROR(-20250,'Estás introduciendo un salario inferior al salario mínimo');
            END IF;
END;