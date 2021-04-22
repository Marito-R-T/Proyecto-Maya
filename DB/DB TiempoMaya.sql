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
 	CONSTRAINT FK_USUARIO_ID_ROL FOREIGN KEY (id_rol) REFERENCES Rol (id_rol)
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
	 id_periodo  INT,
	 CONSTRAINT PK_HECHO_HISTORICO PRIMARY KEY (id_hecho_historico),
	 CONSTRAINT FR_HH_ID_P FOREIGN KEY (id_periodo) REFERENCES Periodo (id_periodo)
);

CREATE TABLE Imagen (
	 id_imagen   INT NOT NULL AUTO_INCREMENT,
	 ruta_escritorio VARCHAR (250),
	 ruta_web VARCHAR (250),
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
	 CONSTRAINT PK_NAHUAL PRIMARY KEY (id_nahual)
);

CREATE TABLE Energia (
	 id_energia  INT NOT NULL,
	 nombre   VARCHAR (25),
	 significado  VARCHAR (45),
	 html_codigo  VARCHAR (45),
	 CONSTRAINT PK_ENERGIA PRIMARY KEY (id_energia)
);

CREATE TABLE Uinal (
	 id_uinal  INT NOT NULL,
	 nombre   VARCHAR (25),
	 significado  VARCHAR (45),
	 dias   INT,
	 html_codigo  MEDIUMTEXT,
	 CONSTRAINT PK_UINAL PRIMARY KEY (id_uinal)
);

CREATE TABLE Kin (
	 id_kin   INT NOT NULL,
	 nombre   VARCHAR (25),
	 significado  VARCHAR (45),
	 html_codigo  VARCHAR (45),
	 CONSTRAINT PK_KIN PRIMARY KEY (id_kin)
);

CREATE TABLE Pagina (
	 orden  INT NOT NULL,
	 nombre  VARCHAR (30),
	 seccion VARCHAR (45),
	 html_codigo LONGTEXT,
	 CONSTRAINT PK_PAGINA PRIMARY KEY (orden)
);

CREATE TABLE CategoriaCalendario (
	id_cat_calendario INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR (50),
	CONSTRAINT PK_CC PRIMARY KEY (id_cat_calendario)
);

CREATE TABLE Informacion (
	id_informacion INT NOT NULL AUTO_INCREMENT,
	nombre_informacion VARCHAR (45),
	id_cat_calendario INT NOT NULL,
	descripcion_web VARCHAR (500),
	descripcion_escritorio VARCHAR (500),
	CONSTRAINT PK_INF PRIMARY KEY (id_informacion), 
	CONSTRAINT FK_CC_INF FOREIGN KEY (id_cat_calendario)
		REFERENCES CategoriaCalendario (id_cat_calendario)
	);

CREATE TABLE AsignacionImagen (
	id_recurso INT NOT NULL,
	nombre_tabla VARCHAR (75),	
	id_imagen INT NOT NULL,
	CONSTRAINT PK_ID_AsignacionImagen PRIMARY KEY (id_recurso, nombre_tabla),
	CONSTRAINT FK_SG_ID_RECURSO_E FOREIGN KEY (id_recurso) 
 		REFERENCES Energia (id_energia),
 	CONSTRAINT FK_SG_ID_RECURSO_K FOREIGN KEY (id_recurso)
 		REFERENCES Kin (id_kin),
 	CONSTRAINT FK_SG_ID_RECURSO_AI FOREIGN KEY (id_recurso)
 		REFERENCES Nahual (id_nahual),
 	CONSTRAINT FK_SG_ID_RECURSO_UI FOREIGN KEY (id_recurso)
 		REFERENCES Uinal (id_uinal),
 	CONSTRAINT FK_SG_ID_RECURSO_HH FOREIGN KEY (id_recurso)
 		REFERENCES HechoHistorico (id_hecho_historico),
 	CONSTRAINT FK_SG_ID_RECURSO_PAG FOREIGN KEY (id_recurso)
 		REFERENCES Pagina (orden),
 	CONSTRAINT FK_SG_ID_RECURSO_PER FOREIGN KEY (id_recurso)
 		REFERENCES Periodo (id_periodo),
 	CONSTRAINT FK_SG_ID_IMG_IMG FOREIGN KEY (id_imagen)
 		REFERENCES Imagen (id_imagen)
);


