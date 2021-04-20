CREATE DATABASE  IF NOT EXISTS `tiempomaya` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tiempomaya`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tiempomaya
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acontecimiento`
--

DROP TABLE IF EXISTS `acontecimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acontecimiento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `autor` varchar(20) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `Periodo_nombre` varchar(50) NOT NULL,
  `htmlCodigo` mediumtext NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `fechaInicio` varchar(4) NOT NULL,
  `ACInicio` varchar(3) NOT NULL,
  `fechaFin` varchar(4) DEFAULT NULL,
  `ACFin` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ACONTECIMIENTO_USUARIO_idx` (`autor`),
  KEY `fk_ACONTECIMIENTO_CATEGORIA1_idx` (`categoria`),
  KEY `fk_ACONTECIMIENTO_Perido1_idx` (`Periodo_nombre`),
  CONSTRAINT `fk_ACONTECIMIENTO_CATEGORIA1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`),
  CONSTRAINT `fk_ACONTECIMIENTO_Perido1` FOREIGN KEY (`Periodo_nombre`) REFERENCES `periodo` (`nombre`),
  CONSTRAINT `fk_ACONTECIMIENTO_USUARIO` FOREIGN KEY (`autor`) REFERENCES `usuario` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `password` varchar(200) NOT NULL,
  `correo` varchar(100) NOT NULL,
  PRIMARY KEY (`correo`),
  KEY `Correo_idx` (`correo`),
  CONSTRAINT `Correo` FOREIGN KEY (`correo`) REFERENCES `usuario` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `energia`
--

DROP TABLE IF EXISTS `energia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `energia` (
  `id` int NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `htmlCodigo` mediumtext NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `nombreYucateco` varchar(30) NOT NULL,
  `significado` varchar(130) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ENERGIA_CATEGORIA1_idx` (`categoria`),
  CONSTRAINT `fk_ENERGIA_CATEGORIA1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagen` (
  `nombre` varchar(25) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `categoria` varchar(100) NOT NULL,
  `data` longtext,
  PRIMARY KEY (`nombre`),
  KEY `fk_IMAGEN_CATEGORIA1_idx` (`categoria`),
  CONSTRAINT `fk_IMAGEN_CATEGORIA1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `kin`
--

DROP TABLE IF EXISTS `kin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kin` (
  `id` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `significado` varchar(45) NOT NULL,
  `htmlCodigo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nahual`
--

DROP TABLE IF EXISTS `nahual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nahual` (
  `id` int NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `significado` varchar(30) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `htmlCodigo` longtext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_NAHUAL_CATEGORIA1_idx` (`categoria`),
  CONSTRAINT `fk_NAHUAL_CATEGORIA1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pagina`
--

DROP TABLE IF EXISTS `pagina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagina` (
  `nombre` varchar(30) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `orden` int DEFAULT NULL,
  `seccion` varchar(45) DEFAULT NULL,
  `htmlCodigo` longtext,
  PRIMARY KEY (`nombre`,`categoria`),
  KEY `fk_CALENDARIO_CATEGORIA1_idx` (`categoria`),
  CONSTRAINT `fk_CALENDARIO_CATEGORIA1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo` (
  `nombre` varchar(50) NOT NULL,
  `fechaInicio` varchar(6) NOT NULL,
  `ACInicio` varchar(3) NOT NULL,
  `fechaFin` varchar(6) NOT NULL,
  `ACFin` varchar(3) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `htmlCodigo` longtext,
  `orden` int DEFAULT NULL,
  `descripcion` tinytext,
  PRIMARY KEY (`nombre`),
  KEY `fk_Perido_CATEGORIA1_idx` (`categoria`),
  CONSTRAINT `fk_Perido_CATEGORIA1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `uinal`
--

DROP TABLE IF EXISTS `uinal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uinal` (
  `id` int NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `significado` varchar(45) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `htmlCodigo` mediumtext,
  PRIMARY KEY (`id`),
  KEY `fk_WINAL_CATEGORIA1_idx` (`categoria`),
  CONSTRAINT `fk_WINAL_CATEGORIA1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `usuario` varchar(20) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `celular` varchar(10) DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `correo` varchar(75) NOT NULL,
  `imagen` longtext,
  PRIMARY KEY (`correo`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-18 21:39:39
