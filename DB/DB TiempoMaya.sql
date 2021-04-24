CREATE DATABASE IF NOT EXISTS tiempomaya;
USE tiempomaya;

DROP TABLE IF EXISTS rol; 
CREATE TABLE rol (
 	id_rol INT NOT NULL AUTO_INCREMENT,
 	nombre VARCHAR (50),
 	descripcion VARCHAR (250),
 	CONSTRAINT PK_ID_ROL PRIMARY KEY (id_rol)
);

DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (
 	usuario VARCHAR (40) NOT NULL,
 	password VARCHAR (200) NOT NULL,
 	nombre VARCHAR (50) NOT NULL,
 	apellido VARCHAR (50) NOT NULL,
 	correo VARCHAR (100) NOT NULL,
 	fechaNacimiento DATE,
 	telefono BIGINT,
 	imagen  LONGTEXT,
 	id_rol  INT NOT NULL,
 	CONSTRAINT PK_USUARIO PRIMARY KEY(correo),
 	UNIQUE KEY usuario_UNIQUE (usuario),
 	CONSTRAINT FK_USUARIO_ID_ROL FOREIGN KEY (id_rol) REFERENCES rol (id_rol)
);

DROP TABLE IF EXISTS administrador;
CREATE TABLE administrador (
	password varchar(200) NOT NULL,
	correo varchar(100) NOT NULL,
	CONSTRAINT PK_ADMIN PRIMARY KEY (correo),
	CONSTRAINT FK_ADMIN_CORREO FOREIGN KEY (correo) REFERENCES usuario (correo)
);

DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria (
	nombre VARCHAR (100) NOT NULL, 
	CONSTRAINT PK_CATEGORIA PRIMARY KEY (nombre)
);

DROP TABLE IF EXISTS periodo;
CREATE TABLE periodo (
	categoria VARCHAR (100) NOT NULL,
 	-- Orden en WEB
 	orden INT DEFAULT NULL,
 	nombre  VARCHAR (50) NOT NULL,
 	fechaInicio  DATE NOT NULL,
 	fechaFin DATE NOT NULL,
 	ACInicio VARCHAR (3),
 	ACFin  VARCHAR (3),
 	descripcion VARCHAR (250),
 	htmlCodigo LONGTEXT,
 	CONSTRAINT PK_PERIODO PRIMARY KEY (nombre), 
 	CONSTRAINT FK_PERIODO_CATG FOREIGN KEY (categoria) REFERENCES categoria (nombre)
);

DROP TABLE IF EXISTS acontecimiento; 
CREATE TABLE acontecimiento (
	 id INT NOT NULL AUTO_INCREMENT,
	 titulo   VARCHAR (100) NOT NULL,
	 autor   VARCHAR (20),
	 Periodo_nombre VARCHAR (50) NOT NULL,
	 htmlCodigo MEDIUMTEXT NOT NULL,
	 categoria VARCHAR (100) NOT NULL,
	 fechaInicio  DATE NOT NULL,
	 fechaiFn  DATE NOT NULL,
	 ACInicio  VARCHAR (3),
	 ACFin   VARCHAR (3),
	 CONSTRAINT PK_HECHO_HISTORICO PRIMARY KEY (id),
	 CONSTRAINT FK_HH_ID_P FOREIGN KEY (Periodo_nombre) REFERENCES periodo (nombre),
	 CONSTRAINT FK_HH_CATG FOREIGN KEY (categoria) REFERENCES categoria (nombre),
	 CONSTRAINT FK_HH_USUARIO FOREIGN KEY (autor) REFERENCES usuario (usuario)
);

DROP TABLE IF EXISTS imagen;
CREATE TABLE imagen (
	 nombre VARCHAR (25) NOT NULL,
	 descripcion VARCHAR (45) DEFAULT NULL,
	 categoria VARCHAR (100) NOT NULL,
	 rutaEscritorio VARCHAR (250),
	 data LONGTEXT,
	 CONSTRAINT PK_IMAGEN PRIMARY KEY (nombre),
	 CONSTRAINT FK_IMAGEN_CAT FOREIGN KEY (categoria) REFERENCES categoria (nombre)
);

DROP TABLE IF EXISTS nahual;
CREATE TABLE nahual (
	 id INT NOT NULL,
	 nombre VARCHAR (20) NOT NULL,
	 nombreYucateco VARCHAR (50),
	 nombreQuiche  VARCHAR (50),
	 signigicado  VARCHAR (100) NOT NULL,
	 categoria VARCHAR (100) NOT NULL,
	 -- HTML Codigo Nahual
	 htmlCodigo  LONGTEXT,
	 fechaInicio  DATE,
	 fechaFin  DATE,
	 CONSTRAINT PK_NAHUAL PRIMARY KEY (id), 
	 CONSTRAINT FK_NAHUAL_CATG FOREIGN KEY (categoria) REFERENCES categoria (nombre)
);

DROP TABLE IF EXISTS energia;
CREATE TABLE energia (
	 id INT NOT NULL,
	 nombre   VARCHAR (25) NOT NULL,
	 significado  VARCHAR (45) NOT NULL,
	 htmlCodigo  VARCHAR (45) NOT NULL,
	 nombreYucateco VARCHAR (30) NOT NULL,
	 categoria VARCHAR (100) NOT NULL, 
	 CONSTRAINT PK_ENERGIA PRIMARY KEY (id),
	 CONSTRAINT FK_ENERGIA_CATG FOREIGN KEY (categoria) REFERENCES categoria (nombre)
);


DROP TABLE IF EXISTS uinal;
CREATE TABLE uinal (
	 id  INT NOT NULL,
	 nombre   VARCHAR (25) NOT NULL,
	 significado  VARCHAR (45) NOT NULL,
	 categoria VARCHAR (100) NOT NULL, 
	 dias INT,
	 htmlCodigo  MEDIUMTEXT,
	 CONSTRAINT PK_UINAL PRIMARY KEY (id),
	 CONSTRAINT FK_UINAL_CATG FOREIGN KEY (categoria) REFERENCES categoria (nombre)
);

DROP TABLE IF EXISTS kin;
CREATE TABLE kin (
	 id INT NOT NULL,
	 nombre VARCHAR (25),
	 significado  VARCHAR (45),
	 htmlCodigo  VARCHAR (45),
	 CONSTRAINT PK_KIN PRIMARY KEY (id)
);

DROP TABLE IF EXISTS pagina;
CREATE TABLE pagina (
	 orden  INT NOT NULL,
	 nombre  VARCHAR (30) NOT NULL,
	 categoria VARCHAR (100) NOT NULL,
	 seccion VARCHAR (45) DEFAULT NULL,
	 htmlCodigo LONGTEXT,
	 CONSTRAINT PK_PAGINA PRIMARY KEY (nombre, categoria),
	 CONSTRAINT FK_PAGINA_CATG FOREIGN KEY (categoria) REFERENCES categoria (nombre)
);

DROP TABLE IF EXISTS categoriacalendario; 
CREATE TABLE categoriacalendario (
	id_cat_calendario INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR (50),
	CONSTRAINT PK_CC PRIMARY KEY (id_cat_calendario)
);

DROP TABLE IF EXISTS informacion;
CREATE TABLE informacion (
	id_informacion INT NOT NULL AUTO_INCREMENT,
	nombre_informacion VARCHAR (45),
	id_cat_calendario INT NOT NULL,
	descripcion_web VARCHAR (500),
	descripcion_escritorio VARCHAR (500),
	CONSTRAINT PK_INF PRIMARY KEY (id_informacion), 
	CONSTRAINT FK_CC_INF FOREIGN KEY (id_cat_calendario) REFERENCES categoriacalendario (id_cat_calendario));

