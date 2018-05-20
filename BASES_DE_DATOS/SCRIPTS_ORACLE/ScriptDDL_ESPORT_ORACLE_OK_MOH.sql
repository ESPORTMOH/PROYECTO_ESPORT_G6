-- Oracle SQL Developer
-- Versión 4.1.1.19
--
-- Usuario Servidor: eqdaw06
-- Clave Usuario Servidor: eqdaw06
-- Nombre Host: SrvOracle
-- Puerto 1521
-- SID orcl

-- Fecha creacion del Script: 22-04-2018 a las 13:36:24
-- Fecha alteracion del Script: 18-05-2018 v4

-- Proyecto DAW 2017-2018
-- Realizado por Miguel Olmo Hernando

-- --------------------------------------------------------

--
-- BASE DE DATOS: 'esportmoh'
--

-- --------------------------------------------------------

--
-- GESTION PREVIA DE CONTENIDO Y TABLAS EXISTENTES
--

-- --------------------------------------------------------

--
-- Truncado de posibles datos en tablas existentes que puedan afectar al volcado posterior
--

TRUNCATE TABLE login CASCADE;

TRUNCATE TABLE administrador CASCADE;

TRUNCATE TABLE usuario CASCADE;

TRUNCATE TABLE duenio CASCADE;

TRUNCATE TABLE jugador CASCADE;

TRUNCATE TABLE equipo CASCADE;

TRUNCATE TABLE partido CASCADE;

TRUNCATE TABLE jornada CASCADE;

TRUNCATE TABLE clasificacion CASCADE;

--
-- Borrado de posibles tablas existentes que puedan afectar al volcado posterior
--

DROP TABLE login CASCADE CONSTRAINTS;

DROP TABLE administrador CASCADE CONSTRAINTS;

DROP TABLE usuario CASCADE CONSTRAINTS;

DROP TABLE duenio CASCADE CONSTRAINTS;

DROP TABLE jugador CASCADE CONSTRAINTS;

DROP TABLE equipo CASCADE CONSTRAINTS;

DROP TABLE partido CASCADE CONSTRAINTS;

DROP TABLE jornada CASCADE CONSTRAINTS;

DROP TABLE clasificacion CASCADE CONSTRAINTS;

-- --------------------------------------------------------

--
-- Borrado de posibles paquetes, procedimientos, disparadores existentes que puedan afectar al volcado posterior
--

DROP PACKAGE ESPORT_MOH_1;
DROP PACKAGE ESPORT_MOH_2;
DROP PROCEDURE actualizarClasificacion;
DROP TRIGGER TRIGG_jugadoresMaximoEquipo;
DROP TRIGGER TRIGG_salarioMinimo;

-- --------------------------------------------------------

--
-- ESTRUCTURANDO LA BASE DE DATOS 
--

-- --------------------------------------------------------

--
-- Estructura de tabla 'login'
--

CREATE TABLE login (
  codLogin         NUMBER(4)
                   GENERATED ALWAYS AS IDENTITY 
                   MINVALUE 1 
                   MAXVALUE 9999
                   INCREMENT BY 1 
                   START WITH 1  
                   NOORDER  
                   NOCYCLE  NOT NULL ENABLE
                   CONSTRAINT LO_CDLO_PK PRIMARY KEY,
  usuario VARCHAR2(9) NOT NULL,
  passwd VARCHAR2(20) NOT NULL,
  tipo VARCHAR2(1) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla 'administrador'
--

CREATE TABLE administrador (
  codAdministrador NUMBER(4)
                   GENERATED ALWAYS AS IDENTITY 
                   MINVALUE 1 
                   MAXVALUE 9999
                   INCREMENT BY 1 
                   START WITH 1  
                   NOORDER  
                   NOCYCLE  NOT NULL ENABLE
                   CONSTRAINT AD_CDAD_PK PRIMARY KEY,
  dni VARCHAR2(9) NOT NULL,
  nombre VARCHAR2(20) NOT NULL,
  apellido VARCHAR2(20) NOT NULL,
  codLogin NUMBER(4) NOT NULL -- RESERVADO FK
);

-- --------------------------------------------------------

--
-- Estructura de tabla 'usuario'
--

CREATE TABLE usuario (
  codUsuario       NUMBER(4)
                   GENERATED ALWAYS AS IDENTITY 
                   MINVALUE 1 
                   MAXVALUE 9999
                   INCREMENT BY 1 
                   START WITH 1  
                   NOORDER  
                   NOCYCLE  NOT NULL ENABLE
                   CONSTRAINT US_CDUS_PK PRIMARY KEY,
  dni VARCHAR2(9) NOT NULL,
  nombre VARCHAR2(20) NOT NULL,
  apellido VARCHAR2(20) NOT NULL,
  codLogin NUMBER(4) NOT NULL -- RESERVADO FK
);

-- --------------------------------------------------------

--
-- Estructura de tabla 'duenio'
--

CREATE TABLE duenio (
  codDuenio        NUMBER(4)
                   GENERATED ALWAYS AS IDENTITY 
                   MINVALUE 1 
                   MAXVALUE 9999
                   INCREMENT BY 1 
                   START WITH 1  
                   NOORDER  
                   NOCYCLE  NOT NULL ENABLE
                   CONSTRAINT DU_CDDU_PK PRIMARY KEY,
  dni VARCHAR2(9) NOT NULL,
  nombre VARCHAR2(20) NOT NULL,
  apellido VARCHAR2(20) NOT NULL,
  estado NUMBER(1) NOT NULL,
  codLogin NUMBER(4) NOT NULL -- RESERVADO FK
);

-- --------------------------------------------------------

--
-- Estructura de tabla 'jugador'
--

CREATE TABLE jugador (
  codJugador       NUMBER(4)
                   GENERATED ALWAYS AS IDENTITY 
                   MINVALUE 1 
                   MAXVALUE 9999
                   INCREMENT BY 1 
                   START WITH 1  
                   NOORDER  
                   NOCYCLE  NOT NULL ENABLE
                   CONSTRAINT JU_CDJU_PK PRIMARY KEY,
  dni VARCHAR2(9) NOT NULL,
  nombre VARCHAR2(20) NOT NULL,
  apellido VARCHAR2(20) NOT NULL,
  nickname VARCHAR2(20) NOT NULL,
  sueldo NUMBER(10) NOT NULL,
  fechaNacimiento DATE NOT NULL,
  nacionalidad VARCHAR2(20) NOT NULL,
  posicion VARCHAR2(10) NOT NULL,
  estado NUMBER(1) NOT NULL,
  codEquipo NUMBER(4) -- RESERVADO FK
);

-- --------------------------------------------------------

--
-- Estructura de tabla 'equipo'
--

CREATE TABLE equipo (
  codEquipo        NUMBER(4)
                   GENERATED ALWAYS AS IDENTITY 
                   MINVALUE 1 
                   MAXVALUE 9999
                   INCREMENT BY 1 
                   START WITH 1  
                   NOORDER  
                   NOCYCLE  NOT NULL ENABLE
                   CONSTRAINT EQ_CDEQ_PK PRIMARY KEY,
  nombre VARCHAR2(20) NOT NULL,
  presupuesto NUMBER(6) NOT NULL,
  anioFundacion VARCHAR2(4) NOT NULL,
  ciudad VARCHAR2(20) NOT NULL,
  nombreEstadio VARCHAR2(20) NOT NULL,
  codDuenio NUMBER(4) -- RESERVADO FK
  -- EQUIPO COD CLASSIFICACION
);

-- --------------------------------------------------------
--
-- Estructura de tabla 'partido'
--

CREATE TABLE partido (
  codPartido       NUMBER(4)
                   GENERATED ALWAYS AS IDENTITY 
                   MINVALUE 1 
                   MAXVALUE 9999
                   INCREMENT BY 1 
                   START WITH 1  
                   NOORDER  
                   NOCYCLE  NOT NULL ENABLE
                   CONSTRAINT PA_CDPA_PK PRIMARY KEY,
  fechaPartido DATE NOT NULL,                 
  puntosLocal NUMBER(3) NOT NULL,
  puntosVisitante NUMBER(3) NOT NULL,
  codLocal NUMBER(4) NOT NULL,  -- RESERVADO FK
  codVisitante NUMBER(4) NOT NULL,  -- RESERVADO FK
  codJornada NUMBER(4) NOT NULL  -- RESERVADO FK
);

-- --------------------------------------------------------

--
-- Estructura de tabla 'jornada'
--

CREATE TABLE jornada (
  codJornada       NUMBER(4)
                   GENERATED ALWAYS AS IDENTITY 
                   MINVALUE 1 
                   MAXVALUE 9999
                   INCREMENT BY 1 
                   START WITH 1  
                   NOORDER  
                   NOCYCLE  NOT NULL ENABLE
                   CONSTRAINT JO_CDJO_PK PRIMARY KEY,
  numeroJornada VARCHAR2(3) NOT NULL,
  numeroTemporada VARCHAR2(3) NOT NULL,
  codEquipoLocal NUMBER(4) NOT NULL, -- RESERVADO FK
  codEquipoVisitante NUMBER(4) NOT NULL -- RESERVADO FK
); 
-- --------------------------------------------------------

--
-- Estructura de tabla 'clasificacion'
--

CREATE TABLE clasificacion (
  codClasificacion      NUMBER(4)
						GENERATED ALWAYS AS IDENTITY 
						MINVALUE 1 
						MAXVALUE 9999
						INCREMENT BY 1 
						START WITH 1  
						NOORDER  
						NOCYCLE  NOT NULL ENABLE
						CONSTRAINT CL_CDCL_PK PRIMARY KEY,
  puntos NUMBER(5) NOT NULL,
  numeroTemporada VARCHAR2(3) NOT NULL,
  codEquipo NUMBER(4) -- RESERVADO FK -- quitar
);

-- --------------------------------------------------------

--
-- GENERADO DE RESTRICCIONES PARA LAS TABLAS ANTERIOMENTE VOLCADAS
--

-- --------------------------------------------------------

--
-- Filtros para la tabla 'login'
--

ALTER TABLE login ADD (
  CONSTRAINT LO_LOTI_CK CHECK (tipo IN('A','a','U','u','D','d')));

-- --------------------------------------------------------

--
-- Filtros para la tabla 'administrador'
--

ALTER TABLE administrador
  ADD CONSTRAINT AD_ADCL_FK FOREIGN KEY (codLogin) REFERENCES login (codLogin) ON DELETE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla 'usuario'
--

ALTER TABLE usuario
  ADD CONSTRAINT US_USCL_FK FOREIGN KEY (codLogin) REFERENCES login (codLogin) ON DELETE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla 'duenio'
--
ALTER TABLE duenio ADD (
  CONSTRAINT DU_DUCL_FK FOREIGN KEY (codLogin) REFERENCES login (codLogin) ON DELETE CASCADE,
  CONSTRAINT DU_ESTA_CK CHECK (estado IN(0,1)));

-- --------------------------------------------------------

--
-- Filtros para la tabla 'jugador'
--

ALTER TABLE jugador ADD (
  CONSTRAINT JU_JUEQ_FK FOREIGN KEY (codEquipo) REFERENCES equipo (codEquipo) ON DELETE CASCADE,
  CONSTRAINT JU_SUMN_CK CHECK (sueldo >= 735),
  CONSTRAINT JU_ESTA_CK CHECK (estado IN(0,1)));
-- Siguiendo las referencias salariales de la siguiente pagina web: http://www.salariominimo.es/2018.html

-- --------------------------------------------------------
  
--
-- Filtros para la tabla 'equipo'
--

ALTER TABLE equipo
  ADD CONSTRAINT EQ_EQDU_FK FOREIGN KEY (codDuenio) REFERENCES duenio (codDuenio) ON DELETE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla 'partido'
--

ALTER TABLE partido ADD(
  CONSTRAINT PA_PEQL_FK FOREIGN KEY (codLocal) REFERENCES equipo (codEquipo) ON DELETE CASCADE,
  CONSTRAINT PA_PEQV_FK FOREIGN KEY (codVisitante) REFERENCES equipo (codEquipo) ON DELETE CASCADE,
  CONSTRAINT PA_PAJO_FK FOREIGN KEY (codJornada) REFERENCES jornada (codJornada) ON DELETE CASCADE);
  
-- --------------------------------------------------------

--
-- Filtros para la tabla 'clasificacion'
--

ALTER TABLE clasificacion ADD(
  CONSTRAINT CL_CLEQ_FK FOREIGN KEY (codEquipo) REFERENCES equipo (codEquipo) ON DELETE CASCADE);

-- --------------------------------------------------------

--
-- INSERCCION PREVIA DE DATOS PARA LAS TABLAS ANTERIORMENTE VOLCADAS - ESTOS DATOS SON OBLIGATORIOS
-- POR LO TANTO SON DATOS DE CARACTER PREESTABLECIDO PARA EL FUNCIONAMIENTO INICIAL DEL PROGRAMA
--

-- --------------------------------------------------------

--
-- Datos para la tabla 'login' y 'administracion' -  Creacion del usuario SUPERAMINISTRADOR
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, 'ROOT','ROOT','A');
COMMIT;

INSERT INTO administrador VALUES (DEFAULT, '31232696F', 'MIGUEL', 'OLMO', 1);
COMMIT;

-- --------------------------------------------------------

--
-- Datos para la tabla 'login' y 'duenio' -  Creacion de un duenio SUPERDUENIO
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, 'SUPER','DUENIO','D');
COMMIT;

INSERT INTO duenio VALUES (DEFAULT, '60172008Y', 'SUPER', 'DUENIO',0, 2);
COMMIT;

-- --------------------------------------------------------

--
-- Datos para la tabla 'login' y 'usuario' -  Creacion de un usuario SUPERUSUARIO - USUARIOS VARIOS PARA EL SISTEMA
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, 'SUPER','USUARIO','U');
COMMIT;

INSERT INTO usuario VALUES (DEFAULT, '81935469Q', 'SUPER', 'USUARIO', 3);
COMMIT;

--

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

/*
PARA LA PRESENTACION
INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, '97919695R','HPRO','D');
COMMIT;
INSERT INTO duenio VALUES (DEFAULT, '97919695R', 'HUAWEI', 'PRO',0, 10);
COMMIT;
*/

-- --------------------------------------------------------

--
-- Datos para la tabla 'equipo' -  Creacion de un equipo SUPEREQUIPO
--

INSERT INTO equipo VALUES (DEFAULT, 'ALL STARS', 200000, '1988', 'Vitoria', 'Mi PC', 1);
COMMIT;

-- --------------------------------------------------------

--
-- Datos para la tabla 'jugador' -  Creacion de JUGADORES VARIOS
--
--B Base
--E Escolta
--A Alero
--F Ala Pivot
--P Pivot
--


INSERT INTO jugador VALUES (DEFAULT, '32317743Y', 'Pau', 'Gasol', 'PauG', 10000, TO_DATE('06/07/1980', 'dd/mm/YYYY'), 'Spain', 'F', 0, 2);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '40576612N', 'Michael', 'Jordan', 'Air', 15000, TO_DATE('17/02/1963', 'dd/mm/YYYY'), 'USA', 'E', 0, 2);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '56777539S', 'Sergi', 'Vidal', 'Vidal', 3500, TO_DATE('06/07/1980', 'dd/mm/YYYY'), 'Spain', 'E', 0, 2);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '57797697P', 'Albert', 'Ventura', 'Ventura', 9500, TO_DATE('07/04/1992', 'dd/mm/YYYY'), 'Spain', 'E', 0, 2);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '38528433Y', 'Thomas', 'Heurtel', 'Heurtel', 95000, TO_DATE('10/04/1989', 'dd/mm/YYYY'), 'France', 'B', 0, 2);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '35827998R', 'Tornike', 'Sengelia', 'Sengelia', 42000, TO_DATE('05/10/1981', 'dd/mm/YYYY'), 'Georgia', 'P', 0, 2);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '27121811G', 'Illmane', 'Diop', 'Diop', 25500, TO_DATE('04/04/1995', 'dd/mm/YYYY'), 'Spain', 'F', 0, 3);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '94651930F', 'Corey', 'Fisher', 'Fisher', 30000, TO_DATE('08/04/1988', 'dd/mm/YYYY'), 'Georgia', 'B', 0, 3);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '29968261C', 'Thomas', 'Schreiner ', 'Schreiner' , 45000, TO_DATE('03/02/1987', 'dd/mm/YYYY'), 'Austria', 'B', 0, 3);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '85495253K', 'Alejandro', 'Barrera', 'Barrera', 15000, TO_DATE('01/04/1992', 'dd/mm/YYYY'), 'Spain', 'E', 0, 3);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '51684154A', 'Javi', 'Vega', 'Vega', 14000, TO_DATE('05/01/1988', 'dd/mm/YYYY'), 'Spain', 'F', 0, 3);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '05017893Y', 'Juan Sebastian', 'Saez', 'Saez', 25000, TO_DATE('15/07/1994', 'dd/mm/YYYY'), 'Spain', 'F', 0, 3);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '34079395L', 'Jonh Logan', 'Lekins III', 'Lekins', 60000, TO_DATE('06/05/1991', 'dd/mm/YYYY'), 'E', 'USA', 0, 4);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '92495248N', 'Eduardo', 'Martínez', 'Edu Martinez', 25000, TO_DATE('05/05/1990', 'dd/mm/YYYY'), 'A', 'Spain', 0, 4);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '80866384V', 'Deon', 'Thompson', 'Thompson', 95000, TO_DATE('16/09/1988', 'dd/mm/YYYY'), 'F', 'USA', 0, 4);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '97828482Y', 'Goran', 'Huskic', 'Huskic', 3000, TO_DATE('26/03/1992', 'dd/mm/YYYY'), 'P', 'Serbia', 0, 4);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '18354357N', 'Aléjandro', 'López', 'Alejandro López', 50000, TO_DATE('05/08/1991', 'dd/mm/YYYY'), 'E', 'Spain', 0, 4);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '14141807G', 'Fabien', 'Causeur', 'Causeur', 75000, TO_DATE('16/06/1987', 'dd/mm/YYYY'), 'Francia', 'E', 0, 4);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '59453059Z', 'Gustavo', 'Ayón', 'Ayón', 95000, TO_DATE('01/04/1984', 'dd/mm/YYYY'), 'México', 'P', 0, 5);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '64854525E', 'Walter', 'Tavares', 'Tavares', 83000, TO_DATE('22/03/1992', 'dd/mm/YYYY'), 'Cabo Verde', 'P', 0, 5);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '72893528L', 'Anthony', 'Arwin', 'Randolf', 54000, TO_DATE('15/07/1989', 'dd/mm/YYYY'), 'Eslovenia', 'F', 0, 5);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '06330343F', 'Rudy', 'Fernández', 'Rudy Fernández', 145000, TO_DATE('04/04/1985', 'dd/mm/YYYY'), 'Spain', 'A', 0, 5);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '10772493Y', 'Luka', 'Doncic', 'Doncic', 68000, TO_DATE('28/02/1999', 'dd/mm/YYYY'), 'Eslovenia', 'B', 0, 5);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '37477230H', 'Felipe', 'Reyes', 'Reyes', 150000, TO_DATE('16/03/1980', 'dd/mm/YYYY'), 'Spain', 'F', 0, 5);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '86550551X', 'Facu', 'Campazzo', 'Campazzo', 85000, TO_DATE('23/03/1991', 'dd/mm/YYYY'), 'Spain', 'B', 0, 6);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '40461975F', 'Jaycee', 'Carroll', 'Carroll', 73000, TO_DATE('16/04/1983', 'dd/mm/YYYY'), 'Azerbayan', 'E', 0, 6);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '13877448F', 'Sergio', 'Llull', 'Llull', 102000, TO_DATE('15/11/1987', 'dd/mm/YYYY'), 'Spain', 'B', 0, 6);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '80592105J', 'Howard Samuel', 'Thompkins III', 'Thompkins III', 25000, TO_DATE('29/05/1990', 'dd/mm/YYYY'), 'USA', 'F', 0, 6);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '42593461Z', 'Jeffery', 'Taylor', 'Taylor', 95000, TO_DATE('23/03/1989', 'dd/mm/YYYY'), 'Suecia', 'A', 0, 6);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '95707877R', 'Viny', 'Okouo', 'Okouo', 32000, TO_DATE('10/04/1987', 'dd/mm/YYYY'), 'Congo', 'P', 0, 6);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '71985998T', 'Ray', 'McCallum', 'McCallum', 24000, TO_DATE('12/06/1991', 'dd/mm/YYYY'), 'USA', 'B', 0, 7);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '77111030B', 'Alberto', 'Díaz', 'Alberto Díaz', 24000, TO_DATE('23/04/1994', 'dd/mm/YYYY'), 'Spain', 'B', 0, 7);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '73675890J', 'Sasu', 'Salin', 'Salin', 35000, TO_DATE('11/06/1991', 'dd/mm/YYYY'), 'Finlandia', 'E', 0, 7);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '48778797Y', 'Daniel', 'Diez', 'Diez', 18000, TO_DATE('07/04/1993', 'dd/mm/YYYY'), 'Spain', 'A', 0, 7);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '08661371P', 'Dragan', 'Milosavljevic', 'Milosavljevic', 95000, TO_DATE('11/05/1989', 'dd/mm/YYYY'), 'Serbia', 'E', 0, 7);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '78642594M', 'Nemanja', 'Nedovic', 'Nedovic', 154000, TO_DATE('16/06/1991', 'dd/mm/YYYY'), 'Serbia', 'E', 0, 7);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '95208705K', 'Giorgi', 'Shermadini', 'Shermadini', 140000, TO_DATE('02/04/1989', 'dd/mm/YYYY'), 'Georgia', 'P', 0, 8);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '75613932Y', 'Adam', 'Waczynski', 'Adam Waczynski ', 95000, TO_DATE('15/10/1989', 'dd/mm/YYYY'), 'Polonia', 'A', 0, 8);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '88520481J', 'Jeff', 'Brooks', 'Brooks', 35000, TO_DATE('12/06/1989', 'dd/mm/YYYY'), 'Italia', 'F', 0, 8);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '46951072E', 'James', 'Augustine', 'Augustine', 65000, TO_DATE('27/02/1984', 'dd/mm/YYYY'), 'USA', 'F', 0, 8);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '13905325P', 'Carlos', 'Suárez', 'Suárez', 95000, TO_DATE('23/05/1985', 'dd/mm/YYYY'), 'Spain', 'F', 0, 8);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '98801311G', 'Clevin', 'Hannah', 'Hannah', 47000, TO_DATE('15/11/1987', 'dd/mm/YYYY'), 'Senegal', 'B', 0, 8);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '45146613M', 'Ovie', 'Soko', 'Soko', 95000, TO_DATE('07/02/1991', 'dd/mm/YYYY'), 'Reino Unido', 'A', 0, 1);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '86694582S', 'Alex', 'Urtasun', 'Urtasun', 120000, TO_DATE('30/04/1984', 'dd/mm/YYYY'), 'Spain', 'E', 0, 1);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '96204145K', 'José Ángel', 'Anteló', 'Anteló', 145000, TO_DATE('07/05/1987', 'dd/mm/YYYY'), 'Spain', 'F', 0, 1);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '06525161S', 'Vitor', 'Benite', 'Benite', 54000, TO_DATE('20/02/1990', 'dd/mm/YYYY'), 'Brasil', 'E', 0, 1);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '84015569L', 'Augusto', 'Lima', 'Lima', 140000, TO_DATE('17/09/1991', 'dd/mm/YYYY'), 'Spain', 'P', 0, 1);
COMMIT;

/*
PARA LA PRESENTACION

INSERT INTO jugador VALUES (DEFAULT, '84015569L', 'Augusto', 'Lima', 'Lima', 140000, TO_DATE('17/09/1991', 'dd/mm/YYYY'), 'Spain', 'P', 0, 1);
COMMIT;
*/

-- --------------------------------------------------------

--
-- Datos para la tabla 'equipo' -  Creacion de EQUIPOS VARIOS
--.

INSERT INTO equipo VALUES (DEFAULT, 'LAKERS', 200000, '1947', 'Los Angeles', 'Staples Center', 1);
COMMIT;

INSERT INTO equipo VALUES (DEFAULT, 'BASKONIA', 200000, '1959', 'Vitoria', 'Buesa Arena', 1);
COMMIT;

INSERT INTO equipo VALUES (DEFAULT, 'MADRID', 200000, '1981', 'Madrid', 'Wizink Center', 1);
COMMIT;

INSERT INTO equipo VALUES (DEFAULT, 'BULLS', 200000, '1666', 'Chicago', 'United Center', 1);
COMMIT;

INSERT INTO equipo VALUES (DEFAULT, 'UNICAJA', 200000, '1977', 'Malaga', 'Martin Carpena', 1);
COMMIT;

INSERT INTO equipo VALUES (DEFAULT, 'CELTICS', 200000, '1946', 'Boston', 'TD Garden', 1);
COMMIT;

INSERT INTO equipo VALUES (DEFAULT, 'BARCELONA', 200000, '1926', 'Barcelona', 'Palau Blaugrana', 1);
COMMIT;

/*
PARA LA PRESENTACION
INSERT INTO equipo VALUES (DEFAULT, 'WARRIORS', 200000, '1946', 'Oakland', 'Oracle Arena', 1);
COMMIT;
*/

