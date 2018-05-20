select * from equipo;
select * from jugador;
select * from duenio;

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, '35701895F','MJIMENEZ','D');
COMMIT;
INSERT INTO duenio VALUES (DEFAULT, '35701895F', 'MARIA', 'JIMENEZ',0, 4);
COMMIT;
--
INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, '20293875D','LFONSI','D');
COMMIT;
INSERT INTO duenio VALUES (DEFAULT, '20293875D', 'LUIS', 'FONSI',0, 5);
COMMIT;
--
INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, '82386993G','PDELAROSA','D');
COMMIT;
INSERT INTO duenio VALUES (DEFAULT, '82386993G', 'PEDRO', 'DELAROSA',0, 6);
COMMIT;
--
INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, '69622601Z','SGALAXY','D');
COMMIT;
INSERT INTO duenio VALUES (DEFAULT, '69622601Z', 'SAMSUNG', 'GALAXY',0, 7);
COMMIT;
--
INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, '62466101X','SGALAXY','D');
COMMIT;
INSERT INTO duenio VALUES (DEFAULT, '62466101X', 'SONY', 'BRAVIA',0, 8);
COMMIT;
--
INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, '38425571T','NSWITCH','D');
COMMIT;
INSERT INTO duenio VALUES (DEFAULT, '38425571T', 'NINTEDO', 'SWITCH',0, 9);
COMMIT;
--
INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, '57465781M','MWINDOWS','D');
COMMIT;
INSERT INTO duenio VALUES (DEFAULT, '57465781M', 'MICROSOFT', 'WINDOWS',0, 10);
COMMIT;
-- PARA MI
INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, '97919695R','HPRO','D');
COMMIT;
INSERT INTO duenio VALUES (DEFAULT, '97919695R', 'HUAWEI', 'PRO',0, 10);
COMMIT;


-- --------------------------------------------------------

--
-- Datos para la tabla 'login' y 'usuario' -  Creacion de un usuario SUPERUSUARIO
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, 'SUPER','USUARIO','U');
COMMIT;

INSERT INTO usuario VALUES (DEFAULT, '81935469Q', 'SUPER', 'USUARIO', 3);
COMMIT;
