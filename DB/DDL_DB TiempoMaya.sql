CREATE DATABASE IF NOT EXISTS TiempoMaya;
USE TiempoMaya;

CREATE TABLE Rol (
 	id_rol INT NOT NULL AUTO_INCREMENT,
 	nombre VARCHAR (50),
 	descripcion VARCHAR (250),
 	CONSTRAINT PK_ID_ROL PRIMARY KEY (id_rol)
);

CREATE TABLE Usuario (
 	usuario VARCHAR (40) NOT NULL,
 	password VARCHAR (200) NOT NULL,
 	nombre VARCHAR (50) NOT NULL,
 	apellido VARCHAR (50) NOT NULL,
 	correo VARCHAR (100) NOT NULL,
 	nacimiento DATE,
 	telefono BIGINT,
 	imagen  LONGTEXT,
 	id_rol  INT NOT NULL,
 	CONSTRAINT PK_USUARIO PRIMARY KEY(usuario),
 	CONSTRAINT FK_USUARIO_ID_ROL FOREIGN KEY (id_rol) 
 		REFERENCES Rol (id_rol)
);

CREATE TABLE Categoria (
 	id_categoria INT NOT NULL AUTO_INCREMENT,
 	nombre  VARCHAR (50),
 	descripcion VARCHAR (250),
 	CONSTRAINT PK_CATEGORIA PRIMARY KEY (id_categoria)
);

CREATE TABLE Periodo (
 	-- Orden en WEB
 	id_periodo INT NOT NULL AUTO_INCREMENT,
 	nombre  VARCHAR (50) NOT NULL,
 	fecha_inicio  DATE NOT NULL,
 	fecha_fin DATE NOT NULL,
 	ac_inicio VARCHAR (3),
 	ac_fin  VARCHAR (3),
 	descripcion VARCHAR (250),
 	html_codigo LONGTEXT,
 	CONSTRAINT PK_PERIODO PRIMARY KEY (id_periodo)
);

CREATE TABLE HechoHistorico (
	 id_hecho_historico INT NOT NULL AUTO_INCREMENT,
	 titulo   VARCHAR (150) NOT NULL,
	 autor   VARCHAR (20),
	 fecha_inicio  DATE NOT NULL,
	 fecha_fin  DATE NOT NULL,
	 ac_inicio  VARCHAR (3),
	 ac_fin   VARCHAR (3),
	 id_categoria  INT, 
	 id_periodo  INT,
	 CONSTRAINT PK_HECHO_HISTORICO PRIMARY KEY (id_hecho_historico),
	 CONSTRAINT FK_HH_ID_CTG FOREIGN KEY (id_categoria) 
	  	REFERENCES Categoria (id_categoria),
	 CONSTRAINT FR_HH_ID_P FOREIGN KEY (id_periodo)
	  	REFERENCES Periodo (id_periodo)
);

CREATE TABLE Imagen (
	 id_imagen   INT NOT NULL AUTO_INCREMENT,
	 ruta_escritorio VARCHAR (150),
	 ruta_web  VARCHAR (150),
	 data    LONGTEXT,
	 CONSTRAINT PK_IMAGEN PRIMARY KEY (id_imagen)
);

CREATE TABLE Nahual (
	 id_nahual INT NOT NULL,
	 nombre_yucateco VARCHAR (50) NOT NULL,
	 nombre_quiche  VARCHAR (50) NOT NULL,
	 signigicado  VARCHAR (100),
	 descripcion_escritorio VARCHAR (5000),
	 -- HTML Codigo Nahual
	 html_codigo  LONGTEXT,
	 fecha_inicio  DATE,
	 fecha_fin  DATE,
	 id_imagen  INT NOT NULL,
	 CONSTRAINT PK_NAHUAL PRIMARY KEY (id_nahual),
	 CONSTRAINT FK_N_ID_IMG FOREIGN KEY (id_imagen) 
	  	REFERENCES Imagen (id_imagen)
);

CREATE TABLE Energia (
	 id_energia  INT NOT NULL,
	 nombre   VARCHAR (25),
	 significado  VARCHAR (45),
	 id_imagen  INT,
	 html_codigo  VARCHAR (45),
	 CONSTRAINT PK_ENERGIA PRIMARY KEY (id_energia),
	 CONSTRAINT FK_E_ID_IMG FOREIGN KEY (id_imagen) 
	  	REFERENCES Imagen (id_imagen)
);

CREATE TABLE Uinal (
	 id_uinal  INT NOT NULL,
	 nombre   VARCHAR (25),
	 significado  VARCHAR (45),
	 dias   INT,
	 id_imagen  INT,
	 html_codigo  MEDIUMTEXT,
	 CONSTRAINT PK_UINAL PRIMARY KEY (id_uinal),
	 CONSTRAINT FK_U_ID_IMG FOREIGN KEY (id_imagen) 
	  	REFERENCES Imagen (id_imagen)
);

CREATE TABLE Kin (
	 id_kin   INT NOT NULL,
	 nombre   VARCHAR (25),
	 significado  VARCHAR (45),
	 id_imagen  INT,
	 html_codigo  VARCHAR (45),
	 CONSTRAINT PK_KIN PRIMARY KEY (id_kin),
	 CONSTRAINT FK_K_ID_IMG FOREIGN KEY (id_imagen) 
	  	REFERENCES Imagen (id_imagen)
);

CREATE TABLE Pagina (
	 orden  INT NOT NULL AUTO_INCREMENT,
	 nombre  VARCHAR (30),
	 seccion VARCHAR (45),
	 html_codigo LONGTEXT,
	 CONSTRAINT PK_PAGINA PRIMARY KEY (orden)
);
