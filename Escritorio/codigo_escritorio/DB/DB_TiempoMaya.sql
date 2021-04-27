--
-- Base de datos: `tiempomaya`
--
CREATE DATABASE IF NOT EXISTS `tiempomaya` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `tiempomaya`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acontecimiento`
--

DROP TABLE IF EXISTS `acontecimiento`;
CREATE TABLE `acontecimiento` (
  `id` int NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `autor` varchar(20) DEFAULT NULL,
  `Periodo_nombre` varchar(50) NOT NULL,
  `htmlCodigo` mediumtext NOT NULL,
  `fechaInicio` varchar(5) NOT NULL,
  `fechaFin` varchar(5) DEFAULT NULL,
  `ACInicio` varchar(3) NOT NULL,
  `ACFin` varchar(3) DEFAULT NULL,
  `categoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

DROP TABLE IF EXISTS `administrador`;
CREATE TABLE `administrador` (
  `password` varchar(200) NOT NULL,
  `correo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoriacalendario`
--

DROP TABLE IF EXISTS `categoriacalendario`;
CREATE TABLE `categoriacalendario` (
  `id_cat_calendario` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `energia`
--

DROP TABLE IF EXISTS `energia`;
CREATE TABLE `energia` (
  `id` int NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `significado` tinytext NOT NULL,
  `htmlCodigo` mediumtext NOT NULL,
  `nombreYucateco` varchar(30) NOT NULL,
  `categoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

DROP TABLE IF EXISTS `imagen`;
CREATE TABLE `imagen` (
  `nombre` varchar(25) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `rutaEscritorio` varchar(250) DEFAULT NULL,
  `data` longtext,
  `categoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informacion`
--

DROP TABLE IF EXISTS `informacion`;
CREATE TABLE `informacion` (
  `id_informacion` int NOT NULL,
  `nombre_informacion` varchar(45) DEFAULT NULL,
  `id_cat_calendario` int NOT NULL,
  `descripcion_web` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `descripcion_escritorio` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `kin`
--

DROP TABLE IF EXISTS `kin`;
CREATE TABLE `kin` (
  `id` int NOT NULL,
  `iddesk` int NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `significado` varchar(150) DEFAULT NULL,
  `htmlCodigo` mediumtext,
  `categoria` varchar(100) NOT NULL,
  `nombreYucateco` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nahual`
--

DROP TABLE IF EXISTS `nahual`;
CREATE TABLE `nahual` (
  `idweb` int NOT NULL,
  `iddesk` int DEFAULT NULL,
  `nombre` varchar(20) NOT NULL,
  `nombreYucateco` varchar(50) DEFAULT NULL,
  `significado` varchar(100) NOT NULL,
  `htmlCodigo` longtext,
  `categoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagina`
--

DROP TABLE IF EXISTS `pagina`;
CREATE TABLE `pagina` (
  `orden` int NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `seccion` varchar(45) DEFAULT NULL,
  `htmlCodigo` longtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo`
--

DROP TABLE IF EXISTS `periodo`;
CREATE TABLE `periodo` (
  `orden` int DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `fechaInicio` varchar(5) NOT NULL,
  `fechaFin` varchar(5) NOT NULL,
  `ACInicio` varchar(3) DEFAULT NULL,
  `ACFin` varchar(3) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `htmlCodigo` longtext,
  `categoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `id_rol` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `uinal`
--

DROP TABLE IF EXISTS `uinal`;
CREATE TABLE `uinal` (
  `idweb` int NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `significado` varchar(75) NOT NULL,
  `dias` int DEFAULT NULL,
  `htmlCodigo` mediumtext,
  `categoria` varchar(100) NOT NULL,
  `iddesk` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `usuario` varchar(40) NOT NULL,
  `password` varchar(200) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `telefono` bigint DEFAULT NULL,
  `imagen` longtext,
  `id_rol` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `acontecimiento`
--
ALTER TABLE `acontecimiento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_HH_ID_P` (`Periodo_nombre`),
  ADD KEY `FK_HH_USUARIO` (`autor`),
  ADD KEY `fk_acontecimiento_categoria1_idx` (`categoria`);

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`correo`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `categoriacalendario`
--
ALTER TABLE `categoriacalendario`
  ADD PRIMARY KEY (`id_cat_calendario`);

--
-- Indices de la tabla `energia`
--
ALTER TABLE `energia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_energia_categoria1_idx` (`categoria`);

--
-- Indices de la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `fk_imagen_categoria1_idx` (`categoria`);

--
-- Indices de la tabla `informacion`
--
ALTER TABLE `informacion`
  ADD PRIMARY KEY (`id_informacion`),
  ADD KEY `FK_CC_INF` (`id_cat_calendario`);

--
-- Indices de la tabla `kin`
--
ALTER TABLE `kin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_kin_categoria1_idx` (`categoria`);

--
-- Indices de la tabla `nahual`
--
ALTER TABLE `nahual`
  ADD PRIMARY KEY (`idweb`),
  ADD UNIQUE KEY `iddesk_UNIQUE` (`iddesk`),
  ADD KEY `fk_nahual_categoria1_idx` (`categoria`);

--
-- Indices de la tabla `pagina`
--
ALTER TABLE `pagina`
  ADD PRIMARY KEY (`nombre`,`categoria`),
  ADD KEY `FK_PAGINA_CATG` (`categoria`);

--
-- Indices de la tabla `periodo`
--
ALTER TABLE `periodo`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `fk_periodo_categoria1_idx` (`categoria`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `uinal`
--
ALTER TABLE `uinal`
  ADD PRIMARY KEY (`idweb`),
  ADD UNIQUE KEY `iddesk_UNIQUE` (`iddesk`),
  ADD KEY `fk_uinal_categoria1_idx` (`categoria`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`correo`),
  ADD UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  ADD KEY `FK_USUARIO_ID_ROL` (`id_rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `acontecimiento`
--
ALTER TABLE `acontecimiento`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `categoriacalendario`
--
ALTER TABLE `categoriacalendario`
  MODIFY `id_cat_calendario` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `informacion`
--
ALTER TABLE `informacion`
  MODIFY `id_informacion` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_rol` int NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `acontecimiento`
--
ALTER TABLE `acontecimiento`
  ADD CONSTRAINT `fk_acontecimiento_categoria1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`),
  ADD CONSTRAINT `FK_HH_ID_P` FOREIGN KEY (`Periodo_nombre`) REFERENCES `periodo` (`nombre`),
  ADD CONSTRAINT `FK_HH_USUARIO` FOREIGN KEY (`autor`) REFERENCES `usuario` (`usuario`);

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `FK_ADMIN_CORREO` FOREIGN KEY (`correo`) REFERENCES `usuario` (`correo`);

--
-- Filtros para la tabla `energia`
--
ALTER TABLE `energia`
  ADD CONSTRAINT `fk_energia_categoria1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`);

--
-- Filtros para la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD CONSTRAINT `fk_imagen_categoria1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`);

--
-- Filtros para la tabla `informacion`
--
ALTER TABLE `informacion`
  ADD CONSTRAINT `FK_CC_INF` FOREIGN KEY (`id_cat_calendario`) REFERENCES `categoriacalendario` (`id_cat_calendario`);

--
-- Filtros para la tabla `kin`
--
ALTER TABLE `kin`
  ADD CONSTRAINT `fk_kin_categoria1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`);

--
-- Filtros para la tabla `nahual`
--
ALTER TABLE `nahual`
  ADD CONSTRAINT `fk_nahual_categoria1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`);

--
-- Filtros para la tabla `pagina`
--
ALTER TABLE `pagina`
  ADD CONSTRAINT `FK_PAGINA_CATG` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`);

--
-- Filtros para la tabla `periodo`
--
ALTER TABLE `periodo`
  ADD CONSTRAINT `fk_periodo_categoria1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`);

--
-- Filtros para la tabla `uinal`
--
ALTER TABLE `uinal`
  ADD CONSTRAINT `fk_uinal_categoria1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_USUARIO_ID_ROL` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

