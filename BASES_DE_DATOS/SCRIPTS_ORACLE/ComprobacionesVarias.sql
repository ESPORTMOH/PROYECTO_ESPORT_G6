/*
COMPROBACIONES VARIAS
*/

-- SIMPLES
select * from login;
select * from administrador;
select * from usuario;
select * from equipo;
select * from partido;
select * from jugador;
select * from clasificacion;
select * from jornada;

-- COMPUESTAS
select j.*, e.nombre
  from jugador j, equipo e
  where j.CODEQUIPO = e.CODEQUIPO and e.CODEQUIPO = 1;

SELECT u.codUsuario, u.dni, u.nombre, u.apellido, u.codLogin, l.codLogin, l.usuario, l.passwd FROM usuario u, login l  WHERE (u.codLogin = l.codLogin) AND u.dni = ?;

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