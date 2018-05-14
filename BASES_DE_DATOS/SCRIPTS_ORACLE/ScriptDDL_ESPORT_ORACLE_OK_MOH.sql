-- Oracle SQL Developer
-- Versión 4.1.1.19
--
-- Usuario Servidor: eqdaw06
-- Clave Usuario Servidor: eqdaw06
-- Nombre Host: SrvOracle
-- Puerto 1521
-- SID orcl

-- Fecha creacion del Script: 22-04-2018 a las 13:36:24
-- Fecha alteracion del Script: 11-05-2018 v3

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
  codEquipo NUMBER(4) -- RESERVADO FK
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
ALTER TABLE duenio
  ADD CONSTRAINT DU_DUCL_FK FOREIGN KEY (codLogin) REFERENCES login (codLogin) ON DELETE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla 'jugador'
--

ALTER TABLE jugador ADD (
  CONSTRAINT JU_JUEQ_FK FOREIGN KEY (codEquipo) REFERENCES equipo (codEquipo) ON DELETE CASCADE,
  CONSTRAINT JU_SUMN_CK CHECK (sueldo >= 735));
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

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, 'root','root','A');
COMMIT;

INSERT INTO administrador VALUES (DEFAULT, '00000000A', 'MIGUEL', 'OLMO', 1);
COMMIT;

-- --------------------------------------------------------

--
-- Datos para la tabla 'login' y 'duenio' -  Creacion de un duenio SUPERDUENIO
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, 'SUPER','DUENIO','D');
COMMIT;

INSERT INTO duenio VALUES (DEFAULT, '00000000C', 'SUPER', 'DUENIO', 1);
COMMIT;

-- --------------------------------------------------------

--
-- Datos para la tabla 'login' y 'usuario' -  Creacion de un usuario SUPERUSUARIO
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (DEFAULT, 'SUPER','USUARIO','U');
COMMIT;

INSERT INTO usuario VALUES (DEFAULT, '00000000E', 'SUPER', 'USUARIO', 1);
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

INSERT INTO jugador VALUES (DEFAULT, '32317743Y', 'Pau', 'Gasol', 'PauG', 10000, TO_DATE('06/07/1980', 'dd/mm/YYYY'), 'Spain', 'F', 1);
COMMIT;

INSERT INTO jugador VALUES (DEFAULT, '32317743Y', 'Michael', 'Jordan', 'Air', 15000, TO_DATE('17/02/1963', 'dd/mm/YYYY'), 'USA', 'G', 1);
COMMIT;

-- --------------------------------------------------------

--
-- Datos para la tabla 'equipo' -  Creacion de EQUIPOS VARIOS
--

INSERT INTO equipo VALUES (DEFAULT, 'LAKERS', 200000, '1947', 'Los Angeles', 'Staples Center', 1);
COMMIT;

INSERT INTO equipo VALUES (DEFAULT, 'BASKONIA', 200000, '1959', 'Vitoria', 'Buesa Arena', 1);
COMMIT;

INSERT INTO equipo VALUES (DEFAULT, 'MADRID', 200000, '1981', 'Madrid', 'Wizink Center', 1);
COMMIT;


