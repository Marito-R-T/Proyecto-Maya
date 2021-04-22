-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 19-11-2020 a las 19:35:05
-- Versión del servidor: 8.0.21
-- Versión de PHP: 7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `LineaTiempo`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`administrador`@`localhost` PROCEDURE `mostrarHechos` ()  BEGIN
SELECT * FROM (
 SELECT MAX(fecha) as fecha, idHechoHistorico as id 
 FROM LineaTiempo.Edicion 
 GROUP BY Edicion.idHechoHistorico
) a 
INNER JOIN LineaTiempo.HechoHistorico ON a.id = HechoHistorico.idHechoHistorico
GROUP BY a.id ORDER BY a.fecha ASC
;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cargador`
--

CREATE TABLE `Cargador` (
  `nombre` varchar(10) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `fechaInicio` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Categoria`
--

CREATE TABLE `Categoria` (
  `idCategoria` int NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Categoria`
--

INSERT INTO `Categoria` (`idCategoria`, `nombre`) VALUES
(1, 'Guerra'),
(2, 'Comercio'),
(3, 'Vestimenta'),
(4, 'Fundacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Categorizar`
--

CREATE TABLE `Categorizar` (
  `idHechoHistorico` int NOT NULL,
  `idCategoria` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Categorizar`
--

INSERT INTO `Categorizar` (`idHechoHistorico`, `idCategoria`) VALUES
(1, 1),
(2, 4),
(3, 1),
(4, 1),
(5, 1),
(8, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DiasCholqij`
--

CREATE TABLE `DiasCholqij` (
  `dia` int NOT NULL,
  `idNahual` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Edicion`
--

CREATE TABLE `Edicion` (
  `idEdicion` int NOT NULL,
  `username` varchar(35) NOT NULL,
  `idHechoHistorico` int NOT NULL,
  `fecha` date NOT NULL,
  `creacion` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Edicion`
--

INSERT INTO `Edicion` (`idEdicion`, `username`, `idHechoHistorico`, `fecha`, `creacion`) VALUES
(1, 'AlfredoCardona', 1, '2020-01-05', 1),
(2, 'AlfredoCardona', 2, '2020-03-09', 1),
(3, 'AliciaMorales', 3, '2020-05-22', 1),
(4, 'AliciaMorales', 2, '2020-05-08', 0),
(5, 'AlfredoCardona', 3, '2020-07-02', 0),
(6, 'AliciaMorales', 4, '2020-07-02', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `HechoHistorico`
--

CREATE TABLE `HechoHistorico` (
  `idHechoHistorico` int NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFinal` date NOT NULL,
  `titulo` varchar(150) DEFAULT NULL,
  `descripcion` varchar(5000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `HechoHistorico`
--

INSERT INTO `HechoHistorico` (`idHechoHistorico`, `fechaInicio`, `fechaFinal`, `titulo`, `descripcion`) VALUES
(1, '1007-06-15', '1007-06-15', 'fundacion de la aldea de Uxmal', 'Se dice que la ciudad de Uxmal fue fundada por la tribu de los Xiues. La ocupación del sitio se remonta al Preclásico superior a.C., sin embargo el mayor volumen de la obra constructiva se realiza durante el Clásico Tardío (600- 1000 d.C.). Tuvo una población de 20,000 habitantes aproximadamente.'),
(2, '1027-04-02', '1027-04-02', 'Comienza la Liga de Mayapán', 'Tenía propósitos militares, Integrada por los grupos o casas sacerdotales de los itzáes de Chichén Itzá; los tutul xiúes de Uxmal; y los cocomes de la ciudad de Mayapán, y otros.'),
(3, '1194-11-22', '1194-11-22', 'Complot de Hunac Ceel', 'los cocomes arrojan a los itzáes de la ciudad de Chichén Itzá Termina la Liga de Mayapán'),
(4, '1520-02-27', '1520-02-27', 'Fin de Expediciones', 'Han pasado las expediciones de Hernández de Córdoba, Grijalva y Cortés, se ha producido una epidemia de viruela que diezma a la población. Cortez.'),
(5, '1697-07-27', '1697-07-27', 'Destruccion Tayasal', 'El conquistador español Martín de Ursúa destruye Tayasal último reducto de los itzáes.'),
(8, '0902-01-01', '0902-01-01', 'Inicio Cultura Maya', 'se dice que comienza la historia de la cultura maya, por una fecha inscrita en una estela de Tikal.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Nahual`
--

CREATE TABLE `Nahual` (
  `idNahual` int NOT NULL,
  `nombre` varchar(35) NOT NULL,
  `fechaInicio` date NOT NULL,
  `significado` varchar(25) DEFAULT NULL,
  `descripcion` varchar(5000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Rol`
--

CREATE TABLE `Rol` (
  `idRol` int NOT NULL,
  `tipo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Rol`
--

INSERT INTO `Rol` (`idRol`, `tipo`) VALUES
(1, 'Editor'),
(2, 'Lector'),
(3, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Rueda1`
--

CREATE TABLE `Rueda1` (
  `idRueda` int NOT NULL,
  `nombre` varchar(35) NOT NULL,
  `nahual` int NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` varchar(5000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Rueda2`
--

CREATE TABLE `Rueda2` (
  `idRueda` int NOT NULL,
  `nahual` int NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` varchar(5000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Rueda3`
--

CREATE TABLE `Rueda3` (
  `idRueda` int NOT NULL,
  `nahual` int NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` varchar(5000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `RuedaCalendarica`
--

CREATE TABLE `RuedaCalendarica` (
  `idRuedaCalendarica` int NOT NULL,
  `idRueda1` int NOT NULL,
  `idRueda2` int NOT NULL,
  `idRueda3` int NOT NULL,
  `descripcion` varchar(5000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario`
--

CREATE TABLE `Usuario` (
  `username` varchar(40) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nacimiento` date DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `rol` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Usuario`
--

INSERT INTO `Usuario` (`username`, `password`, `email`, `nombre`, `apellido`, `nacimiento`, `telefono`, `rol`) VALUES
('AlfredoCardona', 'Alfredo123', 'alfredo_cardona@gmail.com', 'Alredo Fernando', 'Cardona Rivera', '1995-05-20', '23456543', 1),
('AliciaMorales', 'Alicia123', 'alicia_morales@gmail.com', 'Alicia Fernanda', 'Morales Cerezo', '1990-01-23', '67879809', 2),
('Angel', 'Angel.123', 'crispin_angel@gmail.com', 'Angel', 'Crispin Quispe', '1991-01-21', '36536483', 2),
('Carlos', 'Carlos.123', 'chirinos_carlos@gmail.com', 'Carlos', 'Chirinos Lacotera', '1995-09-09', '31746237', 2),
('Cesar', 'Cesar.123', 'baiocchi_cesar@gmail.com', 'Cesar', 'Baiocchi Ureta', '1989-09-08', '58668583', 1),
('Christian Nelson', 'Christian.123', 'alcala_christian@gmail.com', 'Christian Nelson', 'Alcalá Negrón', '1990-02-22', '34253565', 2),
('Cielito Mercedes', 'Cielito.123', 'calle_cielito@gmail.com', 'Cielito Mercedes', 'Calle Betancourt', '1989-09-08', '28484873', 2),
('Daniel', 'Daniel.123', 'acevedo_daniel@gmail.com', 'Daniel', 'Acevedo Jhong', '1995-09-09', '17354418', 1),
('Doris', 'Doris.123', 'cores_doris@gmail.com', 'Doris', 'Cores Moreno', '1998-03-12', '42275241', 3),
('Efraín', 'Efraín.123', 'arroyo_efrain@gmail.com', 'Efraín', 'Arroyo Ramírez', '1898-09-09', '72244573', 2),
('Estalins', 'Estalins.123', 'carrillo_estalins@gmail.com', 'Estalins', 'Carrillo Segura', '1898-09-09', '37612244', 1),
('Gizella', 'Gizella.123', 'carrera_gizella@gmail.com', 'Gizella', 'Carrera Abanto', '1989-09-08', '61444613', 2),
('Guillermo', 'Guillermo.123', 'casapia_guillermo@gmail.com', 'Guillermo', 'Casapia Valdivia', '1990-12-09', '52785554', 1),
('Isabel Florisa', 'Isabel.123', 'caraza_isabel@gmail.com', 'Isabel Florisa', 'Caraza Villegas', '1997-09-12', '62478558', 1),
('Isela Flor', 'Isela.123', 'baylon_isela@creatica.com', 'Isela Flor', 'Baylón Rojas', '1991-01-21', '75333222', 1),
('Javier', 'Javier.123', 'arevalo_javier@gmail.com', 'Javier', 'Arevalo Lopez', '1989-09-08', '73356484', 2),
('Jorge', 'Jorge.123', 'alosilla_jorge@gmail.com', 'Jorge', 'Alosilla Velazco Vera', '1998-03-12', '71473672', 2),
('Jorge Augusto', 'Jorge.123', 'carrion_jorge@gmail.com', 'Jorge Augusto', 'Carrión Neira', '1991-01-21', '67335638', 2),
('Leoncia', 'Leoncia.123', 'bedoya_leoncia@gmail.com', 'Leoncia', 'Bedoya Castillo', '1898-09-09', '28438568', 1),
('Luz', 'Luz.123', 'bedregal_luz@gmail.com', 'Luz Marina', 'Bedregal Canales', '1995-09-09', '67544552', 2),
('Marco', 'Marco.123', 'alocen_marco@gmail.com', 'Marco Tulio', 'Alocen Barrera', '1990-12-09', '58111834', 2),
('Maribel', 'Maribel.123', 'cortez_maribel@gmail.com', 'Maribel Corina', 'Cortez Lozano', '1990-02-22', '52248388', 1),
('Miguel', 'Miguel.123', 'agurto_miguel@gmail.com', 'Miguel Vicente', 'Agurto Rondoy', '1998-03-12', '72266316', 2),
('Nelson', 'Nelson.123', 'boza_nelson@gmail.com', 'Nelson', 'Boza Solis', '1997-09-12', '73583154', 2),
('Ramiro.123', 'Ramiro.123', 'bejar_ramiro@gmail.com', 'Ramiro Alberto', 'Bejar Torres', '1998-03-12', '88851134', 3),
('Raul', 'Raul.123', 'almora_raul@gmail.com', 'Raul Eduardo', 'Almora Hernandez', '1995-09-09', '42825515', 1),
('Rosario', 'Rosario.123', 'arias_rosario@gmail.com', 'Rosario', 'Arias Hernandez', '1990-12-09', '57752554', 3),
('Victor', 'Victor.123', 'alva_victor@gmail.com', 'Victor', 'Alva Campos', '1990-02-22', '42278552', 3),
('Zarita', 'Zarita.123', 'chancos_zarita@gmail.com', 'Zarita', 'Chancos Mendoza', '1989-09-08', '25531356', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Winal`
--

CREATE TABLE `Winal` (
  `numero` int NOT NULL,
  `nombre` varchar(10) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `dias` int DEFAULT NULL,
  `nombreCargador` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Cargador`
--
ALTER TABLE `Cargador`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `Categoria`
--
ALTER TABLE `Categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `Categorizar`
--
ALTER TABLE `Categorizar`
  ADD KEY `FK_IDCATEGORIA_CATEGORIZAR_CATEGORIA` (`idCategoria`),
  ADD KEY `FK_IDHECHO_CATEGORIZAR_HECHOHISTORICO` (`idHechoHistorico`);

--
-- Indices de la tabla `DiasCholqij`
--
ALTER TABLE `DiasCholqij`
  ADD PRIMARY KEY (`dia`),
  ADD KEY `FK_IdNagual` (`idNahual`);

--
-- Indices de la tabla `Edicion`
--
ALTER TABLE `Edicion`
  ADD PRIMARY KEY (`idEdicion`),
  ADD KEY `FK_ID_TEMA` (`idHechoHistorico`),
  ADD KEY `FK_ID_USER_R` (`username`);

--
-- Indices de la tabla `HechoHistorico`
--
ALTER TABLE `HechoHistorico`
  ADD PRIMARY KEY (`idHechoHistorico`);

--
-- Indices de la tabla `Nahual`
--
ALTER TABLE `Nahual`
  ADD PRIMARY KEY (`idNahual`);

--
-- Indices de la tabla `Rol`
--
ALTER TABLE `Rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `Rueda1`
--
ALTER TABLE `Rueda1`
  ADD PRIMARY KEY (`idRueda`);

--
-- Indices de la tabla `Rueda2`
--
ALTER TABLE `Rueda2`
  ADD PRIMARY KEY (`idRueda`),
  ADD KEY `FK_Id_Nagual` (`nahual`);

--
-- Indices de la tabla `Rueda3`
--
ALTER TABLE `Rueda3`
  ADD PRIMARY KEY (`idRueda`);

--
-- Indices de la tabla `RuedaCalendarica`
--
ALTER TABLE `RuedaCalendarica`
  ADD PRIMARY KEY (`idRuedaCalendarica`),
  ADD KEY `FK_R1` (`idRueda1`),
  ADD KEY `FK_R2` (`idRueda2`),
  ADD KEY `FK_R3` (`idRueda3`);

--
-- Indices de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`username`),
  ADD KEY `FK_ROL_ROLES` (`rol`);

--
-- Indices de la tabla `Winal`
--
ALTER TABLE `Winal`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `FK_NOMBRECARGADOR_WINAL_CARGADOR` (`nombreCargador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Categoria`
--
ALTER TABLE `Categoria`
  MODIFY `idCategoria` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `Edicion`
--
ALTER TABLE `Edicion`
  MODIFY `idEdicion` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `HechoHistorico`
--
ALTER TABLE `HechoHistorico`
  MODIFY `idHechoHistorico` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `Nahual`
--
ALTER TABLE `Nahual`
  MODIFY `idNahual` int NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Rueda1`
--
ALTER TABLE `Rueda1`
  MODIFY `idRueda` int NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Rueda2`
--
ALTER TABLE `Rueda2`
  MODIFY `idRueda` int NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Rueda3`
--
ALTER TABLE `Rueda3`
  MODIFY `idRueda` int NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `RuedaCalendarica`
--
ALTER TABLE `RuedaCalendarica`
  MODIFY `idRuedaCalendarica` int NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Categorizar`
--
ALTER TABLE `Categorizar`
  ADD CONSTRAINT `FK_IDCATEGORIA_CATEGORIZAR_CATEGORIA` FOREIGN KEY (`idCategoria`) REFERENCES `Categoria` (`idCategoria`),
  ADD CONSTRAINT `FK_IDHECHO_CATEGORIZAR_HECHOHISTORICO` FOREIGN KEY (`idHechoHistorico`) REFERENCES `HechoHistorico` (`idHechoHistorico`);

--
-- Filtros para la tabla `DiasCholqij`
--
ALTER TABLE `DiasCholqij`
  ADD CONSTRAINT `FK_IdNagual` FOREIGN KEY (`idNahual`) REFERENCES `Nahual` (`idNahual`);

--
-- Filtros para la tabla `Edicion`
--
ALTER TABLE `Edicion`
  ADD CONSTRAINT `FK_ID_TEMA` FOREIGN KEY (`idHechoHistorico`) REFERENCES `HechoHistorico` (`idHechoHistorico`),
  ADD CONSTRAINT `FK_ID_USER_R` FOREIGN KEY (`username`) REFERENCES `Usuario` (`username`);

--
-- Filtros para la tabla `Rueda2`
--
ALTER TABLE `Rueda2`
  ADD CONSTRAINT `FK_Id_Nagual` FOREIGN KEY (`nahual`) REFERENCES `Nahual` (`idNahual`);

--
-- Filtros para la tabla `RuedaCalendarica`
--
ALTER TABLE `RuedaCalendarica`
  ADD CONSTRAINT `FK_R1` FOREIGN KEY (`idRueda1`) REFERENCES `Rueda1` (`idRueda`),
  ADD CONSTRAINT `FK_R2` FOREIGN KEY (`idRueda2`) REFERENCES `Rueda2` (`idRueda`),
  ADD CONSTRAINT `FK_R3` FOREIGN KEY (`idRueda3`) REFERENCES `Rueda3` (`idRueda`);

--
-- Filtros para la tabla `Usuario`
--
ALTER TABLE `Usuario`
  ADD CONSTRAINT `FK_ROL_ROLES` FOREIGN KEY (`rol`) REFERENCES `Rol` (`idRol`);

--
-- Filtros para la tabla `Winal`
--
ALTER TABLE `Winal`
  ADD CONSTRAINT `FK_NOMBRECARGADOR_WINAL_CARGADOR` FOREIGN KEY (`nombreCargador`) REFERENCES `Cargador` (`nombre`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
