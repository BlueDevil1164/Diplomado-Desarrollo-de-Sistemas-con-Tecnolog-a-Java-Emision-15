# NULL / NOT NULL
# NULL es el default en los campos (permite nulos)

USE segundabd;

DROP TABLE if exists estudiante;
# Candidatas (nombre)
# Primaria (id)          PRIMARY KEY
# Secundaria (nombre)    UNIQUE

CREATE TABLE estudiante (
	idEstudiante INT NOT NULL PRIMARY KEY AUTO_INCREMENT , 
	nombre VARCHAR(60) DEFAULT 'Sin nombre' UNIQUE,
	domicilio VARCHAR (126) NOT NULL DEFAULT 'Desconocido',
	genero CHAR(1) DEFAULT 'F' CHECK (genero = 'M' OR genero = 'F' OR genero = 'N'),
	edad INT DEFAULT 6 CHECK (edad >=5 AND edad <=100 ),
	promedio DECIMAL (3,2),
	fechaDeNacimiento DATE 
);

INSERT INTO estudiante (idEstudiante, nombre, edad, domicilio) VALUES (38, 'Eligio', 99, 'Avenida A # 3');
INSERT INTO estudiante (idEstudiante, nombre, domicilio, genero) VALUES (42,'Laura','Calle 3', 'N');

INSERT INTO estudiante (nombre) VALUES ('Hugo');
INSERT INTO estudiante (nombre, edad) VALUES ('Matusalen', 20);
INSERT INTO estudiante (nombre, edad) VALUES ('Eligio Ortiz', 22);
INSERT INTO estudiante (edad,genero) VALUES (88,'M');

SELECT * FROM estudiante;



#################
DROP TABLE if EXISTS estadios;

CREATE TABLE estadios (
	idEstadio INT NOT NULL,
	nombre VARCHAR (100) NOT NULL ,
	ciudad VARCHAR (100) NOT NULL,
	domicilio VARCHAR(100) NOT NULL,
	capacidad INT NOT NULL,
	fechaConstruccion DATE NOT NULL CHECK (fechaConstruccion >= '1930-01-01'),
	fechaInauguracion DATE NOT NULL, 
	
	CONSTRAINT pk_estadios PRIMARY KEY (idEstadio),
	CONSTRAINT uq_estadios_nombre UNIQUE (nombre),
	CONSTRAINT ck_estadios_capacidad CHECK (capacidad >= 100 AND capacidad <=120000),
	CONSTRAINT ck_estadios_fechas CHECK (fechaInauguracion > fechaConstruccion)
);
# INSERT INTO estadios VALUES (45,'Azteca','CDMX','Tlalpan', 70000, '1960-01-01', '1950-01-01');
# SELECT * FROM estadios;

DROP TABLE if exists equipos ;
CREATE TABLE equipos (
	idEquipo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombreEquipo VARCHAR(100) NOT NULL,
	idEstadio INT NOT NULL,
	grupo CHAR(1) NOT NULL DEFAULT 'A' CHECK (grupo >= 'A' AND grupo <= 'F'),
	puntosAcumulados TINYINT NOT NULL DEFAULT 0 CHECK (puntosAcumulados >=0),
	
	CONSTRAINT fk_estadios_equipos FOREIGN KEY (idEstadio) REFERENCES estadios (idEstadio)
);

DROP TABLE IF EXISTS partidos;
CREATE TABLE partidos (
	idPartido INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	idEstadio INT NOT NULL REFERENCES estadios (idEstadio),
	fecha DATETIME
	
);

# Comentario
-- Comentario

DROP TABLE if EXISTS equipos_x_partido;
CREATE TABLE equipos_x_partido (
	idEquipo INT NOT NULL,
	idPartido INT NOT NULL,
	localVisitante CHAR(1) NOT NULL DEFAULT 'L' CHECK (localVisitante = 'L' OR localVisitante = 'V'),
	goles TINYINT NOT NULL DEFAULT 0 CHECK (goles >= 0),
	
	CONSTRAINT PRIMARY KEY (idEquipo, idPartido),
	CONSTRAINT fk_equipo_exp FOREIGN KEY (idEquipo) REFERENCES equipos (idEquipo),
	CONSTRAINT fk_partido_exp FOREIGN KEY (idPartido) REFERENCES partidos (idPartido)
);
