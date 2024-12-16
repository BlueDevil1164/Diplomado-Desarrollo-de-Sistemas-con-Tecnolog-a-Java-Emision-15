#NULL / NOT NULL
#NULL es el default en los campos (permite nulos)

USE segundabd;

DROP DATABASE IF EXISTS segundabd;
CREATE DATABASE if not exists segundabd;
USE segundabd;
DROP TABLE If exists estudiante;
# Candidatas (nombre)
# Primaria (id) PRIMARY
# Secundaia (nombre) UNIQUE
 
CREATE TABLE estudiante(
	idEstudiante INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(60) DEFAULT 'Nameless' UNIQUE,  
	domicilio VARCHAR (126) NOT NULL DEFAULT 'Desconocido',
	genero CHAR(1) DEFAULT 'F' CHECK (genero ='N' OR genero = 'F' OR genero = 'M'), 
	edad INT DEFAULT 7 CHECK (edad >= 2 AND edad <=100),
	promedio DECIMAL (3,2),
	fechaDeNacimiento DATE 	
);

INSERT INTO estudiante (nombre, edad, domicilio ) VALUES ('Noyola', 26, 'Cerrada de perlas #51');
INSERT INTO estudiante (nombre, domicilio, genero ) VALUES ('May', 'Cerrada de perlas #52', 'N' );
INSERT INTO estudiante (nombre) VALUES ('Dante');
INSERT INTO estudiante (nombre, edad) VALUES ('Sephiroth', 20);
INSERT INTO estudiante (nombre, edad) VALUES ('Noyola Nazario',22);

INSERT INTO estudiante (nombre, edad, domicilio) VALUES ('Eligio', 99, 'Avenida A # 3');
INSERT INTO estudiante (nombre, domicilio, genero) VALUES ('Laura','Calle 3', 'N');
INSERT INTO estudiante (nombre) VALUES ('Hugo');
INSERT INTO estudiante (nombre, edad) VALUES ('Matusalen', 20);
INSERT INTO estudiante (nombre, edad) VALUES ('Eligio Ortiz', 22);

INSERT INTO estudiante (Domicilio, edad) VALUES ('Mikasa', 22);

INSERT INTO estudiante (idEstudiante, nombre, edad, domicilio) VALUES (38, 'Eligio A', 99, 'Avenida A # 3');
INSERT INTO estudiante (idEstudiante, nombre, domicilio, genero) VALUES (42,'Laura A','Calle 3', 'N');

SELECT * FROM estudiante;

#################
DROP TABLE If EXISTS estadios;
CREATE TABLE estadios (
	idEstadio INT NOT NULL,
	nombre VARCHAR (100) NOT NULL,
	ciudad VARCHAR (100) NOT NULL,
	domicilio VARCHAR(100) NOT NULL,
	capacidad INT NOT NULL,
	fechaConstruccion DATE NOT NULL CHECK (fechaConstruccion >= '1930-01-01'),
	fechaInaguracion DATE NOT NULL CHECK (fechaInaguracion > fechaConstruccion),
	
	CONSTRAINT pk_estadios PRIMARY KEY (idEstadio),
	CONSTRAINT uq_estadios_nombre UNIQUE (nombre, ciudad),
	CONSTRAINT ck_estadios_capacidad CHECK (capacidad >= 100 AND capacidad <= 120000 ), 
	CONSTRAINT ck_estadios_fechas CHECK (fechaInaguracion > fechaConstruccion)
);

INSERT INTO estadios VALUES (45, 'Azteca','CDMX','Tlalpan', 70000,'1950-01-01', '1960-01-01');

SELECT * FROM estadios;

######
DROP TABLE If EXISTS equipos;

CREATE TABLE equipos (
    idEquipo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombreEquipo VARCHAR(100) NOT NULL,
    IdEstadio INT NOT NULL,
    grupo CHAR(1) NOT NULL DEFAULT 'A' CHECK (grupo >= 'A' AND grupo <= 'F'),
    puntosAcumulados TINYINT NOT NULL DEFAULT 0 CHECK (puntosAcumulados >= 0),
    CONSTRAINT fk_estadios_equipos FOREIGN KEY (IdEstadio) REFERENCES estadios(idEstadio) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE if exists partidos;
CREATE TABLE partidos( 
	idPartido INT NOT NULL,
	idEquipo INT NOT NULL,
	fecha DATETIME,
   CONSTRAINT PK_partidos PRIMARY KEY (idPartido)
);

CREATE TABLE equipospartido( 
	idEquipo INT NOT NULL,
	idPartido INT NOT NULL,
	localVisitante CHAR(1) NOT NULL DEFAULT 'L' CHECK (localVisitante = 'L' OR localVisitante = 'V' ), 
	goles TINYINT NOT NULL DEFAULT 0 CHECK (goles >= 0),
   CONSTRAINT PK_equipospartido PRIMARY KEY (idEquipo,idPartido),
   CONSTRAINT fk_equipospartido FOREIGN KEY (idPartido) REFERENCES partidos(idPartido)
);
