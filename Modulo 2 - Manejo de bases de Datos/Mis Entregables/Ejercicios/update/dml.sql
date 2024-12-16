-- Taxis de aplicación 

-- Eliminar la tabla catalogoGeneros si existe
DROP TABLE IF EXISTS catalogoGeneros;

-- Crear la tabla catalogoGeneros
CREATE TABLE catalogoGeneros (
    cveGenero CHAR(1) NOT NULL PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL DEFAULT 'UNKNOWN' UNIQUE
);

-- Agregar registros
INSERT INTO catalogoGeneros (cveGenero, descripcion) VALUES 
    ('F', 'Femenino'), 
    ('N', 'No disponible'),
    ('M', 'Masculino');

-- Solo se da valor para el campo de la clave
INSERT INTO catalogoGeneros (cveGenero) VALUES ('X');
-- INSERT INTO catalogoGeneros (cveGenero, descripcion) VALUES ('M', 'Masculino');

-- Seleccionar todos los registros de catalogoGeneros
SELECT * FROM catalogoGeneros;

-- Para eliminar registros

-- Eliminar todos los registros de catalogoGeneros
DELETE FROM catalogoGeneros;
SELECT * FROM catalogoGeneros;

-- Eliminar registros con condición
DELETE FROM catalogoGeneros WHERE cveGenero = 'M';
SELECT * FROM catalogoGeneros;

-- Eliminar todos los registros de catalogoGeneros (alternativa)
DELETE FROM catalogoGeneros WHERE 1 = 1;
SELECT * FROM catalogoGeneros;

-- Truncar la tabla catalogoGeneros
DELETE FROM catalogoGeneros; 
SELECT * FROM catalogoGeneros;

-- Clientes
DROP TABLE IF EXISTS clientes;

-- Crear la tabla clientes
CREATE TABLE clientes (
    idCliente INTEGER PRIMARY KEY AUTO_INCREMENT, -- Cambiado a AUTO_INCREMENT para MariaDB
    nombre VARCHAR(100) NOT NULL UNIQUE,
    edad TINYINT UNSIGNED NOT NULL CHECK (edad >= 18),
    cveGenero CHAR(1) NOT NULL,
    nivel TINYINT NOT NULL CHECK (nivel >= 0),
    correo VARCHAR(100) NOT NULL UNIQUE,
    usuario CHAR(12) NOT NULL UNIQUE,
    contrasena CHAR(15) NOT NULL CHECK (usuario <> contrasena),
    FOREIGN KEY (cveGenero) REFERENCES catalogoGeneros(cveGenero)
);

-- Insertar registros en clientes
INSERT INTO clientes (nombre, edad, cveGenero, nivel, correo, usuario, contrasena) 
VALUES 
    ('Hugo', 19, 'M', 1, 'hugo@pato.com', 'hugo', 'hugo123'),
    ('Paco', 19, 'N', 1, 'paco@pato.com', 'paco', 'paco123'),
    ('Luis', 19, 'N', 1, 'luis@pato.com', 'Luis', 'Luis123'),
    ('Daisy', 19, 'N', 1, 'daisy@pato.com', 'daisy', 'daisy123'),
    ('Donald', 19, 'N', 1, 'donald@pato.com', 'donald', 'donald123');

-- Seleccionar todos los registros de clientes
SELECT * FROM clientes;

-- Para modificar registros:
-- Actualizar contrasena para todos los clientes
UPDATE clientes SET contrasena = '1234';

-- Incrementar edad en 10 para todos los clientes
UPDATE clientes SET edad = edad + 10;

-- Actualizar contrasena y edad
UPDATE clientes SET contrasena = '98765', edad = edad + 5;

-- Actualizar contrasena concatenada con usuario y restar edad
UPDATE clientes SET contrasena = usuario || '12', edad = edad - 15;

-- Seleccionar todos los registros de clientes
SELECT * FROM clientes;

-- Actualizar registros con condición
UPDATE clientes SET edad = 50 WHERE usuario = 'paco';
UPDATE clientes SET contrasena = 'abcde' WHERE edad >= 20;

-- Seleccionar todos los registros de clientes
SELECT * FROM clientes;

-- Seleccionar todos los registros de catalogoGeneros
SELECT * FROM catalogoGeneros;

-- Eliminar registros de clientes con cveGenero 'X'
DELETE FROM clientes WHERE cveGenero = 'X';



-- Seleccionar todos los registros de clientes y catalogoGeneros
SELECT * FROM clientes;
SELECT * FROM catalogoGeneros;



