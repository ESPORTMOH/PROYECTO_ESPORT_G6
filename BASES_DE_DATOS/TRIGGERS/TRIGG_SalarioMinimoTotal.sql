CREATE OR REPLACE PACKAGE ESPORT_MOH_3  as
  v_codEquipo equipo.codEquipo%type :=null;
  v_sueldo jugador.sueldo%type :=null;
END;

CREATE OR REPLACE TRIGGER jugadorMutante
  AFTER INSERT OR UPDATE ON jugador
    FOR EACH ROW
      BEGIN
        ESPORT_MOH_3 .v_codEquipo := :new.codEquipo;
END jugadorMutante;

CREATE OR REPLACE TRIGGER sueldoMutante
  AFTER INSERT OR UPDATE ON jugador
    FOR EACH ROW
      BEGIN
        ESPORT_MOH_3 .v_sueldo := :new.sueldo;
END sueldoMutante;
  
CREATE OR REPLACE TRIGGER disparadorSueldosTope
  BEFORE INSERT on jugador
    FOR EACH ROW
      DECLARE
        v_sueldosTotales NUMBER;
        v_presupuestoMaximoPorEquipo NUMBER:=200000;
        v_error EXCEPTION;
    BEGIN
      IF ESPORT_MOH_3 .v_codEquipo <> 1 THEN
        SELECT SUM(sueldo)
          INTO v_sueldosTotales
            FROM jugador 
              WHERE codEquipo = ESPORT_MOH_3 .v_codEquipo;
                v_sueldosTotales := v_sueldosTotales + ESPORT_MOH_3 .v_sueldo;
        IF(v_sueldosTotales> v_presupuestoMaximoPorEquipo) THEN
          RAISE_APPLICATION_ERROR(-20250,'Estás introduciendo un salario inferior al salario mínimo');         
          END IF;
      END IF;
END;

-- http://stevenfeuersteinonplsql.blogspot.com.es/2016/12/get-rid-of-mutating-table-trigger.html

