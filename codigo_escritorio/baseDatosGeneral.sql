-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema calendarioTiempoMaya
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `calendarioTiempoMaya` ;

-- -----------------------------------------------------
-- Schema calendarioTiempoMaya
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `calendarioTiempoMaya` DEFAULT CHARACTER SET latin1 ;
USE `calendarioTiempoMaya` ;

-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`Tzolqin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`Tzolqin` (
  `idTzolqin` INT(11) NOT NULL,
  `diaTzolqin` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTzolqin`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`rutaimagen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`rutaimagen` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(30) NULL DEFAULT NULL,
  `dirWeb` VARCHAR(230) NULL DEFAULT NULL,
  `dirEscritorio` VARCHAR(230) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 40
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`energia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`energia` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `idImagen` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_IDIMAGEN_ENERGIA_ID_IMAGEN` (`idImagen` ASC),
  CONSTRAINT `FK_IDIMAGEN_ENERGIA_ID_IMAGEN`
    FOREIGN KEY (`idImagen`)
    REFERENCES `calendarioTiempoMaya`.`rutaimagen` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`nahual`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`nahual` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(35) NULL DEFAULT NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFinalizacion` DATE NOT NULL,
  `idImagen` INT(11) NULL DEFAULT NULL,
  `significado` VARCHAR(100) NULL DEFAULT NULL,
  `descripcion` VARCHAR(5000) NULL DEFAULT NULL,
  `nombreSp` VARCHAR(35) NULL DEFAULT NULL,
  `nombreYucateco` VARCHAR(35) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_IDIMAGEN_NAHUAL_ID_IMAGEN` (`idImagen` ASC),
  CONSTRAINT `FK_IDIMAGEN_NAHUAL_ID_IMAGEN`
    FOREIGN KEY (`idImagen`)
    REFERENCES `calendarioTiempoMaya`.`rutaimagen` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`calendariocholqij`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`calendariocholqij` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nahual` INT(11) NOT NULL,
  `energia` INT(11) NOT NULL,
  `fecha` DATE NOT NULL,
  `descripcion` VARCHAR(5000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Id_Nagual` (`nahual` ASC),
  INDEX `FK_Id_Energia` (`energia` ASC),
  CONSTRAINT `FK_Id_Energia`
    FOREIGN KEY (`energia`)
    REFERENCES `calendarioTiempoMaya`.`energia` (`id`),
  CONSTRAINT `FK_Id_Nagual`
    FOREIGN KEY (`nahual`)
    REFERENCES `calendarioTiempoMaya`.`nahual` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 261
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`winal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`winal` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(10) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `dias` INT(11) NULL DEFAULT NULL,
  `idImagen` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_IDIMAGEN_WINAL_ID_IMAGEN` (`idImagen` ASC),
  CONSTRAINT `FK_IDIMAGEN_WINAL_ID_IMAGEN`
    FOREIGN KEY (`idImagen`)
    REFERENCES `calendarioTiempoMaya`.`rutaimagen` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`calendariohaab`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`calendariohaab` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nahual` INT(11) NOT NULL,
  `winal` INT(11) NOT NULL,
  `nombre` VARCHAR(35) NOT NULL,
  `fecha` DATE NOT NULL,
  `descripcion` VARCHAR(5000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Id_Nahual` (`nahual` ASC),
  INDEX `FK_Id_Winal` (`winal` ASC),
  CONSTRAINT `FK_Id_Nahual`
    FOREIGN KEY (`nahual`)
    REFERENCES `calendarioTiempoMaya`.`nahual` (`id`),
  CONSTRAINT `FK_Id_Winal`
    FOREIGN KEY (`winal`)
    REFERENCES `calendarioTiempoMaya`.`winal` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 366
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`cargador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`cargador` (
  `nombre` VARCHAR(10) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `rutaImagen` VARCHAR(80) NULL DEFAULT NULL,
  `id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`nombre`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`categoria` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`hechohistorico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`hechohistorico` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fechaInicio` DATE NULL DEFAULT NULL,
  `fechaFinalizacion` DATE NULL DEFAULT NULL,
  `titulo` VARCHAR(150) NULL DEFAULT NULL,
  `descripcion` VARCHAR(5000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`categorizar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`categorizar` (
  `idHechoHistorico` INT(11) NOT NULL,
  `idCategoria` INT(11) NOT NULL,
  INDEX `FK_IDCATEGORIA_CATEGORIZAR_CATEGORIA` (`idCategoria` ASC),
  INDEX `FK_IDHECHO_CATEGORIZAR_HECHOHISTORICO` (`idHechoHistorico` ASC),
  CONSTRAINT `FK_IDCATEGORIA_CATEGORIZAR_CATEGORIA`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `calendarioTiempoMaya`.`categoria` (`id`),
  CONSTRAINT `FK_IDHECHO_CATEGORIZAR_HECHOHISTORICO`
    FOREIGN KEY (`idHechoHistorico`)
    REFERENCES `calendarioTiempoMaya`.`hechohistorico` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`datosCalendarioCholqij`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`datosCalendarioCholqij` (
  `idDato` INT(11) NOT NULL,
  `titulo` VARCHAR(45) NULL DEFAULT NULL,
  `concepto` LONGTEXT NULL DEFAULT NULL,
  `urlImagen` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`idDato`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`debilidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`debilidad` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `debilidad` VARCHAR(150) NOT NULL,
  `idNahual` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_IDNAHUAL_DEBILIDAD_ID_NAHUAL` (`idNahual` ASC),
  CONSTRAINT `FK_IDNAHUAL_DEBILIDAD_ID_NAHUAL`
    FOREIGN KEY (`idNahual`)
    REFERENCES `calendarioTiempoMaya`.`nahual` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 132
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`rol` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`usuario` (
  `username` VARCHAR(40) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `apellido` VARCHAR(50) NOT NULL,
  `nacimiento` DATE NULL DEFAULT NULL,
  `telefono` VARCHAR(15) NULL DEFAULT NULL,
  `rol` INT(11) NOT NULL,
  PRIMARY KEY (`username`),
  INDEX `FK_ROL_ROLES` (`rol` ASC),
  CONSTRAINT `FK_ROL_ROLES`
    FOREIGN KEY (`rol`)
    REFERENCES `calendarioTiempoMaya`.`rol` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`edicion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`edicion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(35) NOT NULL,
  `idHechoHistorico` INT(11) NOT NULL,
  `fecha` DATE NOT NULL,
  `creacion` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_ID_TEMA` (`idHechoHistorico` ASC),
  INDEX `FK_ID_USER_R` (`username` ASC),
  CONSTRAINT `FK_ID_TEMA`
    FOREIGN KEY (`idHechoHistorico`)
    REFERENCES `calendarioTiempoMaya`.`hechohistorico` (`id`),
  CONSTRAINT `FK_ID_USER_R`
    FOREIGN KEY (`username`)
    REFERENCES `calendarioTiempoMaya`.`usuario` (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`fortaleza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`fortaleza` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fortaleza` VARCHAR(150) NOT NULL,
  `idNahual` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_IDNAHUAL_FORTALEZA_ID_NAHUAL` (`idNahual` ASC),
  CONSTRAINT `FK_IDNAHUAL_FORTALEZA_ID_NAHUAL`
    FOREIGN KEY (`idNahual`)
    REFERENCES `calendarioTiempoMaya`.`nahual` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 199
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`informacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`informacion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(50) NOT NULL,
  `descripcionEscritorio` VARCHAR(5000) NULL DEFAULT NULL,
  `descripcionWeb` VARCHAR(5000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `calendarioTiempoMaya`.`significado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `calendarioTiempoMaya`.`significado` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `significado` VARCHAR(200) NOT NULL,
  `idNahual` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_IDNAHUAL_CARACTERISTICA_ID_NAHUAL` (`idNahual` ASC),
  CONSTRAINT `FK_IDNAHUAL_CARACTERISTICA_ID_NAHUAL`
    FOREIGN KEY (`idNahual`)
    REFERENCES `calendarioTiempoMaya`.`nahual` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 94
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
