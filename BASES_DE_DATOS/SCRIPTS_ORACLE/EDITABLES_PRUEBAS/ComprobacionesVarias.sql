/*
COMPROBACIONES VARIAS PARA JAVA Y ORACLE
*/

-- SIMPLES
select * from login;

select * from administrador;

select * from usuario;

select * from equipo;

select * from partido;

truncate table jugador cascade;

select * from equipo;
select * from jugador;


select * from jugador where nombre = 'Pau' and apellido;

select * from clasificacion;




select * from duenio where codLogin = 25;


select * from jornada;

select * from duenio;

-- COMPUESTAS
select j.*, e.nombre
  from jugador j, equipo e
  where j.CODEQUIPO = e.CODEQUIPO and e.CODEQUIPO = 1;

SELECT u.codUsuario, u.dni, u.nombre, u.apellido, u.codLogin, l.codLogin, l.usuario, l.passwd FROM usuario u, login l  WHERE (u.codLogin = l.codLogin) AND u.dni = ?;

SELECT a.codAdministrador, a.dni, a.nombre, a.apellido, a.codLogin, l.codLogin, l.usuario, l.passwd FROM administrador a, login l  WHERE (a.codLogin = l.codLogin) AND a.dni = ?";

/*  
COMPROBACIONES PARA LLAMAR AL PROCEDIMIENTO ALMCENADO PROCE_generarAutoUserPass
MEDIANTE UN PROCEDIMIENTO ANONIMO
*/

SET SERVEROUTPUT ON

DECLARE
  v_codlogin INTEGER;
BEGIN
  generarAutoUserPass ('12345678A', 'Miguel', 'Miguel', 'A',v_codlogin);
END;

/*
COMPROBACION TRIGGER SALARIOMINIMOTOTAL

*/

INSERT INTO jugador VALUES (DEFAULT, '32317745Y', 'Prueba1', 'Jugador1', 'PG1', 150000, TO_DATE('06/07/1985', 'dd/mm/YYYY'), 'Spain', 'F', 1);
COMMIT;
INSERT INTO jugador VALUES (DEFAULT, '32317745Y', 'Prueba1', 'Jugador1', 'PG1', 50000, TO_DATE('06/07/1985', 'dd/mm/YYYY'), 'Spain', 'F', 1);
COMMIT;

SELECT d.codDuenio, d.dni, d.nombre, d.apellido, d.codLogin, l.codLogin, l.usuario, l.passwd FROM duenio d, login l  WHERE (d.codLogin = l.codLogin) AND d.dni = '00000000C';


select * from jornada WHERE NUMEROTEMPORADA = 'T01';

select * from equipo;

SELECT * FROM PARTIDO;
desc partido
desc duenio
desc jugador

select * from duenio;
SELECT * FROM LOGIN;

SELECT * FROM JUGADOR WHERE DNI = '66718782Z';
desc clasificacion

SELECT * FROM duenio WHERE codLogin = 4;
SELECT * FROM equipo WHERE codDuenio = 4;
SELECT * FROM equipo , duenio  WHERE equipo.CODDUENIO = duenio.CODDUENIO and equipo.codDuenio = 2;

Select * from equipo, jugador where jugador.CODEQUIPO = equipo.CODEQUIPO and  CODDUENIO = 2;

select count(*) AS NUM_JUGADORES from jugador where CODEQUIPO = 10 ;

SELECT * FROM CLASIFICACION C, EQUIPO E WHERE E.CODEQUIPO = C.CODEQUIPO  ORDER BY PUNTOS DESC ;
 
SELECT puntos 
      FROM clasificacion
        WHERE CODEQUIPO = 9
          AND NUMEROTEMPORADA = 'T01';
          
ALTER TABLE partido DROP COLUMN HORAINICIO ;

select * from jornada WHERE NUMEROTEMPORADA = 'T01';

select * from equipo;

SELECT * FROM PARTIDO;
desc partido

desc clasificacion

SELECT * FROM CLASIFICACION C, EQUIPO E WHERE E.CODEQUIPO = C.CODEQUIPO  ORDER BY PUNTOS DESC ;
 
SELECT puntos 
      FROM clasificacion
        WHERE CODEQUIPO = 9
          AND NUMEROTEMPORADA = 'T01';
          
ALTER TABLE partido DROP COLUMN HORAINICIO ;
