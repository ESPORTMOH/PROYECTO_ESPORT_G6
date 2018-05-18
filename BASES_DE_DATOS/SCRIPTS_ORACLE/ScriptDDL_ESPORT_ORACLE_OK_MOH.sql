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
  nickname VARCHAR2(10) NOT NULL,
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
  horaInicio DATE NOT NULL, -- EN PROGRAMACION ESTE ATRIBUTO SERA TIME
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
-- Datos para la tabla 'login' y 'usuario' -  Creacion de un usuario SUPERUSUARIO
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, 'SUPER','USUARIO','U');
COMMIT;

INSERT INTO usuario VALUES (DEFAULT, '81935469Q', 'SUPER', 'USUARIO', 3);
COMMIT;

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


INSERT INTO jugador VALUES (DEFAULT, '32317743Y', 'Pau', 'Gasol', 'PauG', 10000, TO_DATE('06/07/1980', 'dd/mm/YYYY'), 'Spain', 'F', 0, 1);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '40576612N', 'Michael', 'Jordan', 'Air', 15000, TO_DATE('17/02/1963', 'dd/mm/YYYY'), 'USA', 'E', 0, 1);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '56777539S', 'Sergi', 'Vidal', 'Vidal', 3500, TO_DATE('06/07/1980', 'dd/mm/YYYY'), 'Spain', 'E', 0, 1);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '57797697P', 'Albert', 'Ventura', 'Ventura', 9500, TO_DATE('07/04/1992', 'dd/mm/YYYY'), 'Spain', 'E', 0, 1);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '38528433Y', 'Thomas', 'Heurtel', 'Heurtel', 95000, TO_DATE('10/04/1989', 'dd/mm/YYYY'), 'France', 'B', 0, 1);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '35827998R', 'Tornike', 'Sengelia', 'Sengelia', 42000, TO_DATE('05/10/1981', 'dd/mm/YYYY'), 'Georgia', 'P', 0, 1);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '27121811G', 'Illmane', 'Diop', 'Diop', 25500, TO_DATE('04/04/1995', 'dd/mm/YYYY'), 'Spain', 'F', 0, 1);
COMMIT;

-- --------------------------------------------------------

--
-- Datos para la tabla 'equipo' -  Creacion de EQUIPOS VARIOS
--.

INSERT INTO equipo VALUES (DEFAULT, 'SIN EQUIPO', 200000, '1988', 'Vitoria', 'Mi PC', 1);
COMMIT;

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

