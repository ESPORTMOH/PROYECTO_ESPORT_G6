-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-04-2018 a las 13:36:24
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `esportmoh`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `codAdministrador` int(4) NOT NULL,
  `dni` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `apellido` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `codLogin` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `duenio`
--

CREATE TABLE `duenio` (
  `codDuenio` int(4) NOT NULL,
  `dni` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `apellido` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `codLogin` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `codEquipo` int(4) NOT NULL,
  `nombre` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `presupuesto` varchar(6) COLLATE latin1_spanish_ci NOT NULL,
  `anioFundacion` date NOT NULL,
  `ciudad` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `nombreEstadio` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `codDuenio` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornada`
--

CREATE TABLE `jornada` (
  `codJornada` int(4) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `numeroJornada` varchar(3) COLLATE latin1_spanish_ci NOT NULL,
  `numeroTemporada` varchar(3) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `codJugador` int(4) NOT NULL,
  `dni` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `apellido` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `nickname` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `sueldo` double(6,2) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `nacionalidad` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `posicion` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `codEquipo` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `codLogin` int(4) NOT NULL,
  `user` varchar(8) COLLATE latin1_spanish_ci NOT NULL,
  `pass` varchar(8) COLLATE latin1_spanish_ci NOT NULL,
  `tipo` varchar(1) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `codUsuario` int(4) NOT NULL,
  `dni` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `apellido` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `codLogin` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`codAdministrador`),
  ADD KEY `ADM_ADCL_FK` (`codLogin`);

--
-- Indices de la tabla `duenio`
--
ALTER TABLE `duenio`
  ADD PRIMARY KEY (`codDuenio`),
  ADD KEY `DUE_DUCL_FK` (`codLogin`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`codEquipo`),
  ADD KEY `EQ_EQDU_FK` (`codDuenio`);

--
-- Indices de la tabla `jornada`
--
ALTER TABLE `jornada`
  ADD PRIMARY KEY (`codJornada`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`codJugador`),
  ADD KEY `JUG_JUEQ_FK` (`codEquipo`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`codLogin`);

--
-- Indices de la tabla `partido`
--
ALTER TABLE `partido`
  ADD PRIMARY KEY (`codPartido`),
  ADD KEY `PA_PAJO_FK` (`codJornada`),
  ADD KEY `PA_PAEQL_FK` (`codLocal`),
  ADD KEY `PA_PAEQV_FK` (`codVisitante`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codUsuario`),
  ADD KEY `USU_USCL_FK` (`codLogin`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `codAdministrador` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `duenio`
--
ALTER TABLE `duenio`
  MODIFY `codDuenio` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `codEquipo` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `jornada`
--
ALTER TABLE `jornada`
  MODIFY `codJornada` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `codJugador` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `codLogin` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `partido`
--
ALTER TABLE `partido`
  MODIFY `codPartido` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codUsuario` int(4) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `ADM_ADCL_FK` FOREIGN KEY (`codLogin`) REFERENCES `login` (`codLogin`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `duenio`
--
ALTER TABLE `duenio`
  ADD CONSTRAINT `DUE_DUCL_FK` FOREIGN KEY (`codLogin`) REFERENCES `login` (`codLogin`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `EQ_EQDU_FK` FOREIGN KEY (`codDuenio`) REFERENCES `duenio` (`codDuenio`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD CONSTRAINT `JUG_JUEQ_FK` FOREIGN KEY (`codEquipo`) REFERENCES `equipo` (`codEquipo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `partido`
--
ALTER TABLE `partido`
  ADD CONSTRAINT `PA_PAEQL_FK` FOREIGN KEY (`codLocal`) REFERENCES `equipo` (`codEquipo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `PA_PAEQV_FK` FOREIGN KEY (`codVisitante`) REFERENCES `equipo` (`codEquipo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `PA_PAJO_FK` FOREIGN KEY (`codJornada`) REFERENCES `jornada` (`codJornada`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `USU_USCL_FK` FOREIGN KEY (`codLogin`) REFERENCES `login` (`codLogin`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
