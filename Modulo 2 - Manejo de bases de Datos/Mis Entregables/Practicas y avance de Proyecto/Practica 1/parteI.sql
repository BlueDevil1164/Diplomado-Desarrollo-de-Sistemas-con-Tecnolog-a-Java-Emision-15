-- Crear tabla peliculas
DROP TABLE IF EXISTS peliculas;
CREATE TABLE peliculas (
    nombrePelicula VARCHAR(50) PRIMARY KEY,
    clasificacion VARCHAR(50),
    genero VARCHAR(50),
    idioma VARCHAR(50) NOT NULL DEFAULT 'Español',
    premiosGanados TINYINT UNSIGNED NOT NULL DEFAULT 0 CHECK (premiosGanados >= 0)
);

-- Insertar datos en la tabla peliculas
INSERT INTO peliculas (nombrePelicula, clasificacion, genero, idioma, premiosGanados) 
VALUES ('Avengers', '+13', 'Acción', 'Inglés', 5);

INSERT INTO peliculas (nombrePelicula, clasificacion, genero) 
VALUES ('Coco', 'PG', 'Animación');

-- Seleccionar todos los registros de peliculas
SELECT * FROM peliculas;

-- Crear tabla actores
DROP TABLE IF EXISTS actores;
CREATE TABLE actores (
    nombreActor VARCHAR(50) PRIMARY KEY,
    nacionalidad VARCHAR(50),
    edad TINYINT UNSIGNED NOT NULL DEFAULT 0 CHECK (edad >= 0),
    premiosGanados TINYINT UNSIGNED NOT NULL DEFAULT 0 CHECK (premiosGanados >= 0)
);

-- Insertar datos en la tabla actores
INSERT INTO actores (nombreActor, nacionalidad, edad, premiosGanados) 
VALUES ('Johnny Cage', 'USA', 32, 5);

INSERT INTO actores (nombreActor, nacionalidad) 
VALUES ('Sylvester Stallone', 'USA');

-- Seleccionar todos los registros de actores
SELECT * FROM actores;

-- Crear tabla reparto
DROP TABLE IF EXISTS reparto;
CREATE TABLE reparto (
    idReparto INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombrePersonaje VARCHAR(50),
    SueldoPagado DOUBLE NOT NULL DEFAULT 0.0 CHECK (SueldoPagado >= 0.0),
    Pelicula VARCHAR(50),
    Actor VARCHAR(50),
    FOREIGN KEY (Pelicula) REFERENCES peliculas(nombrePelicula),
    FOREIGN KEY (Actor) REFERENCES actores(nombreActor)
);

-- Insertar datos en la tabla reparto
INSERT INTO reparto (nombrePersonaje, SueldoPagado, Pelicula, Actor) 
VALUES ('Hawkeye', 1000000.0, 'Avengers', 'Johnny Cage'); 

-- Seleccionar todos los registros de reparto
SELECT * FROM reparto;
