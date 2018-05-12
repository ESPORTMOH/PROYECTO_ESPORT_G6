/*
PAQUETE 1 - ESPORT_MOH_2

ESTE CONTENDRA DOS PROCEDIMIENTO ALMACENADOS LLAMADOS 

PROCE_rellenarcomboDuenios
PROCE_mostrarequiposNombre


POR MIGUEL OLMO HERNANDO - 11/05/2018
*/

-- INICIO CABECERA PAQUETE

CREATE OR REPLACE PACKAGE ESPORT_MOH_2 
IS
  TYPE c_cursor IS REF CURSOR;
  PROCEDURE PROCE_rellenarcomboDuenios(d_duenios out c_cursor);
  procedure PROCE_mostrarequiposNombre (v_nombreEntrada IN VARCHAR2, e_equipos OUT c_cursor);
END;

-- FIN CABECERA DEL PAQUETE

-- INICIO CUERPO DEL PAQUETE

CREATE OR REPLACE PACKAGE BODY ESPORT_MOH_2
IS
  PROCEDURE PROCE_rellenarcomboDuenios(d_duenios OUT c_cursor)
  IS
  BEGIN
    OPEN d_duenios FOR
      SELECT * 
        FROM duenio;
  EXCEPTION
    WHEN OTHERS THEN
      RAISE_APPLICATION_ERROR(-20100, 'ERROR INEXPERADO');
END PROCE_rellenarcomboDuenios;
-- SEGUNDO PROCEDIMIENTO
  PROCEDURE PROCE_mostrarequiposNombre (v_nombreEntrada IN VARCHAR2, e_equipos OUT c_cursor)
  IS 
    BEGIN
      OPEN e_equipos 
        FOR
          SELECT *
            FROM equipo
            WHERE UPPER(nombre) = UPPER(v_nombreEntrada);
  EXCEPTION
    WHEN OTHERS THEN
      RAISE_APPLICATION_ERROR(-20100, 'ERROR INEXPERADO');
  END PROCE_mostrarequiposNombre;
END ESPORT_MOH_2;

-- FIN CUERPO DEL PAQUETE