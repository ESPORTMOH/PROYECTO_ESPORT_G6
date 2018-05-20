/*
PAQUETE 1 - ESPORT_MOH_2

ESTE CONTENDRA DOS PROCEDIMIENTO ALMACENADOS LLAMADOS 

PROCE_rellenarcomboDuenios
PROCE_rellenarcomboEquipos


POR MIGUEL OLMO HERNANDO - 11/05/2018
*/

-- INICIO CABECERA PAQUETE

CREATE OR REPLACE PACKAGE ESPORT_MOH_2 
IS
  TYPE c_cursor IS REF CURSOR;
  PROCEDURE PROCE_rellenarcomboDuenios(d_duenios OUT c_cursor);
  PROCEDURE PROCE_rellenarcomboEquipos(e_equipos OUT c_cursor);
  PROCEDURE PROCE_rellenarcomboJugadores(j_jugadores OUT c_cursor);
END;

-- FIN CABECERA DEL PAQUETE

-- INICIO CUERPO DEL PAQUETE

CREATE OR REPLACE PACKAGE BODY ESPORT_MOH_2
IS
-- PRIMER PROCEDIMIENTO
  PROCEDURE PROCE_rellenarcomboDuenios(d_duenios OUT c_cursor)
  IS
	BEGIN
		OPEN d_duenios 
			FOR
				SELECT * 
          FROM duenio
            WHERE estado = 0;
  EXCEPTION
    WHEN OTHERS THEN
      RAISE_APPLICATION_ERROR(-20100, 'ERROR INEXPERADO');
END PROCE_rellenarcomboDuenios;
-- SEGUNDO PROCEDIMIENTO
  PROCEDURE PROCE_rellenarcomboEquipos(e_equipos OUT c_cursor)
  IS 
    BEGIN
		OPEN e_equipos 
			FOR
				SELECT *
          FROM equipo
            WHERE UPPER(nombre) <> 'ALL STARS';
  EXCEPTION
    WHEN OTHERS THEN
      RAISE_APPLICATION_ERROR(-20100, 'ERROR INEXPERADO');
  END PROCE_rellenarcomboEquipos;
-- TERCER PROCEDIMIENTO
    PROCEDURE PROCE_rellenarcomboJugadores(j_jugadores OUT c_cursor)
  IS 
    BEGIN
		OPEN j_jugadores 
			FOR
				SELECT *
				FROM jugador
        WHERE estado = 0;
  EXCEPTION
    WHEN OTHERS THEN
      RAISE_APPLICATION_ERROR(-20100, 'ERROR INEXPERADO');
  END PROCE_rellenarcomboJugadores;
END ESPORT_MOH_2;

-- FIN CUERPO DEL PAQUETE