-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-04-2018 a las 19:19:15
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.4
-- Puerto 8080
-- Puerto MySql 3307
-- Usuario: 	root
-- Contraseña: 	usbw

-- --------------------------------------------------------

--
-- Base de datos: `esportmoh`
--

-- --------------------------------------------------------

--
-- ESTRUCTURANDO LA BASE DE DATOS 
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `codLogin` int(4) NOT NULL,
  `usuario` varchar(8) NOT NULL,
  `passwd` varchar(8) NOT NULL,
  `tipo` varchar(1) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `codAdministrador` int(4) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `codLogin` int(4) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `codUsuario` int(4) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `codLogin` int(4) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `duenio`
--

CREATE TABLE `duenio` (
  `codDuenio` int(4) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `codLogin` int(4) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `codJugador` int(4) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `nickname` varchar(10) NOT NULL,
  `sueldo` double(6,2) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `nacionalidad` varchar(20) NOT NULL,
  `posicion` varchar(10) NOT NULL,
  `codEquipo` int(4) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `codEquipo` int(4) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `presupuesto` int(6) NOT NULL,
  `anioFundacion` int(4) NOT NULL,
  `ciudad` varchar(20) NOT NULL,
  `nombreEstadio` varchar(10) NOT NULL,
  `codDuenio` int(4) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido`
--

CREATE TABLE `partido` (
  `codPartido` int(4) NOT NULL,
  `horaInicio` time NOT NULL,
  `puntosLocal` int(3) NOT NULL,
  `puntosVisitante` int(3) NOT NULL,
  `codLocal` int(4) NOT NULL,
  `codVisitante` int(4) NOT NULL,
  `codJornada` int(4) NOT NULL
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornada`
--

CREATE TABLE `jornada` (
  `codJornada` int(4) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `numeroJornada` int(3) NOT NULL,
  `numeroTemporada` int(3) NOT NULL
);

-- --------------------------------------------------------

--
-- GENERANDO INDICES PK Y FK PARA LAS TABLAS VOLCADAS
--

-- --------------------------------------------------------

--
-- Indices de la tabla `login`
--

ALTER TABLE `login`
  ADD PRIMARY KEY `LO_CDLO_PK` (`codLogin`);

-- --------------------------------------------------------

--
-- Indices de la tabla `administrador`
--

ALTER TABLE `administrador`
  ADD PRIMARY KEY `AD_CDAD_PK` (`codAdministrador`),
  ADD KEY `AD_ADCL_FK` (`codLogin`);

-- --------------------------------------------------------

--
-- Indices de la tabla `usuario`
--

ALTER TABLE `usuario`
  ADD PRIMARY KEY `US_CDUS_PK` (`codUsuario`),
  ADD KEY `US_USCL_FK` (`codLogin`);

-- --------------------------------------------------------

--
-- Indices de la tabla `duenio`
--

ALTER TABLE `duenio`
  ADD PRIMARY KEY `DU_CDDU_PK` (`codDuenio`),
  ADD KEY `DU_DUCL_FK` (`codLogin`);
  
-- --------------------------------------------------------
  
--
-- Indices de la tabla `jugador`
--

ALTER TABLE `jugador`
  ADD PRIMARY KEY `JU_CDJU_PK` (`codJugador`),
  ADD KEY `JU_JUEQ_FK` (`codEquipo`);

-- --------------------------------------------------------  
  
--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY `EQ_CDEQ_PK` (`codEquipo`),
  ADD KEY `EQ_EQDU_FK` (`codDuenio`);

-- --------------------------------------------------------

--
-- Indices de la tabla `partido`
--

ALTER TABLE `partido`
  ADD PRIMARY KEY `PA_CDPA_PK` (`codPartido`),
  ADD KEY `PA_PEQL_FK` (`codLocal`),
  ADD KEY `PA_PEQV_FK` (`codVisitante`),
  ADD KEY `PA_PAJO_FK` (`codJornada`);

-- --------------------------------------------------------

--
-- Indices de la tabla `jornada`
--

ALTER TABLE `jornada`
  ADD PRIMARY KEY `JO_CDJO_PK` (`codJornada`);

-- --------------------------------------------------------

--
-- GENERANDO AUTO_INCREMENT DE LAS TABLAS VOLCADAS
--

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla `login`
--

ALTER TABLE `login`
  MODIFY `codLogin` int(4) NOT NULL AUTO_INCREMENT;

-- -------------------------------------------------------- 

--
-- AUTO_INCREMENT de la tabla `administrador`
--

ALTER TABLE `administrador`
  MODIFY `codAdministrador` int(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------
  
--
-- AUTO_INCREMENT de la tabla `usuario`
--

ALTER TABLE `usuario`
  MODIFY `codUsuario` int(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla `duenio`
--

ALTER TABLE `duenio`
  MODIFY `codDuenio` int(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla `jugador`
--

ALTER TABLE `jugador`
  MODIFY `codJugador` int(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla `equipo`
--

ALTER TABLE `equipo`
  MODIFY `codEquipo` int(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla `partido`
--

ALTER TABLE `partido`
  MODIFY `codPartido` int(4) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- AUTO_INCREMENT de la tabla `jornada`
--

ALTER TABLE `jornada`
  MODIFY `codJornada` int(11) NOT NULL AUTO_INCREMENT;

-- --------------------------------------------------------

--
-- RESTRICCIONES PARA LAS TABLAS VOLCADAS
--

-- --------------------------------------------------------

ALTER TABLE `login` 
  ADD CONSTRAINT `LO_LOTI_CK` CHECK (tipo IN('A','a','U','u','D','d'));

-- --------------------------------------------------------

--
-- Filtros para la tabla `administrador`
--

ALTER TABLE `administrador`
  ADD CONSTRAINT `AD_ADCL_FK` FOREIGN KEY (`codLogin`) REFERENCES `login` (`codLogin`) ON DELETE CASCADE ON UPDATE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla `usuario`
--

ALTER TABLE `usuario`
  ADD CONSTRAINT `US_USCL_FK` FOREIGN KEY (`codLogin`) REFERENCES `login` (`codLogin`) ON DELETE CASCADE ON UPDATE CASCADE;

-- --------------------------------------------------------
  
--
-- Filtros para la tabla `duenio`
--

ALTER TABLE `duenio`
  ADD CONSTRAINT `DU_DUCL_FK` FOREIGN KEY (`codLogin`) REFERENCES `login` (`codLogin`) ON DELETE CASCADE ON UPDATE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla `jugador`
--

ALTER TABLE `jugador` ADD (
  CONSTRAINT `JU_JUEQ_FK` FOREIGN KEY (`codEquipo`) REFERENCES `equipo` (`codEquipo`) ON DELETE CASCADE ON UPDATE CASCADE
  CONSTRAINT `JU_SUMN_CK` CHECK (salario >= 735,90));
  

-- --------------------------------------------------------

--
-- Filtros para la tabla `equipo`
--

ALTER TABLE `equipo`
  ADD CONSTRAINT `EQ_EQDU_FK` FOREIGN KEY (`codDuenio`) REFERENCES `duenio` (`codDuenio`) ON DELETE CASCADE ON UPDATE CASCADE;

-- --------------------------------------------------------

--
-- Filtros para la tabla `partido`
--

ALTER TABLE `partido`
  ADD CONSTRAINT `PA_PAJO_FK` FOREIGN KEY (`codJornada`) REFERENCES `jornada` (`codJornada`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `PA_PEQL_FK` FOREIGN KEY (`codLocal`) REFERENCES `equipo` (`codEquipo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `PA_PEQV_FK` FOREIGN KEY (`codVisitante`) REFERENCES `equipo` (`codEquipo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- INSERCCION PREVIA DE DATOS PARA LAS TABLAS ANTERIORMENTE VOLCADAS - ESTOS DATOS SON OBLIGATORIOS
-- POR LO TANTO SON DATOS DE CARACTER PREESTABLECIDO PARA EL FUNCIONAMIENTO INICIAL DEL PROGRAMA
--

-- --------------------------------------------------------

--
-- Datos para la tabla 'login' y 'administracion' -  Creacion del usuario SUPERAMINISTRADOR
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (1, 'root','root','A');

INSERT INTO administrador VALUES (1, '00000000A', 'Miguel', 'Olmo', 1);

-- --------------------------------------------------------

--
-- Datos para la tabla 'login' y 'duenio' -  Creacion de un duenio SUPERDUENIO
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (2, 'super','duenio','D');

INSERT INTO duenio VALUES (1, '11111111A', 'Super', 'Duenio', 2);

-- --------------------------------------------------------

--
-- Datos para la tabla 'login' y 'usuario' -  Creacion de un usuario SUPERUSUARIO
--

INSERT INTO login (codLogin, usuario, passwd, tipo) VALUES (3, 'super','usuario','U');

INSERT INTO usuario VALUES (1, '22222222A', 'Super', 'Usuario', 3);

-- --------------------------------------------------------

