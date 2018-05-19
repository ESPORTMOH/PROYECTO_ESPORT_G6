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
select * from jugador;

select * from clasificacion;

select * from equipo;

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