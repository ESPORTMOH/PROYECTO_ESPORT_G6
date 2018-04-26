DESC JORNADA;

CREATE OR REPLACE PROCEDURE OBTENERINFOJORNADA (
       V_CODJORNADA IN JORNADA.CODJORNADA%TYPE,
       V_FECHAINICIO IN JORNADA.FECHAINICIO%TYPE, 
       V_FECHAFIN IN JORNADA.FECHAFIN%TYPE,
       V_NUMEROJORNADA IN JORNADA.NUMEROJORNADA%TYPE,
       V_NUMEROTEMPORADA IN JORNADA.NUMEROTEMPORADA%TYPE )
IS
-- DECLARACION VARIABLES
V_TOTAL NUMBER;
  BEGIN
    V_TOTAL := 0; 
    SELECT COUNT(*) INTO V_TOTAL 
      FROM JORNADA
      WHERE CODJORNADA = V_CODJORNADA;
      
      IF V_TOTAL = 0 THEN
        INSERT INTO JORNADA VALUES (V_CODJORNADA, V_FECHAINICIO, V_FECHAFIN, V_NUMEROJORNADA, V_NUMEROTEMPORADA);
      END IF;
END OBTENERINFOJORNADA;

--COMPROBACION DE QUE FUNCIONA

BEGIN
  OBTENERINFOJORNADA();
  COMMIT;
END;

SELECT * FROM JORNADA;