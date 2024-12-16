-- Crear tabla catalogoGeneros si no existe
DROP TABLE IF EXISTS catalogoGeneros;

CREATE TABLE catalogoGeneros (
    cveGenero CHAR(1) NOT NULL PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL DEFAULT 'UNKNOWN' UNIQUE
);

-- Agregar registros a catalogoGeneros
INSERT INTO catalogoGeneros (cveGenero, descripcion) VALUES 
    ('F', 'Femenino'), 
    ('N', 'No disponible'),
    ('M', 'Masculino');

-- Crear tabla comprador
DROP TABLE IF EXISTS comprador;

CREATE TABLE comprador (
    idComprador INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombreComprador CHAR(50),
    apellidoComprador CHAR(50),
    edad TINYINT UNSIGNED NOT NULL CHECK (edad >= 18),
    genero CHAR(1) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    usuario CHAR(12) NOT NULL UNIQUE,
    contrasena CHAR(15) NOT NULL CHECK (usuario <> contrasena),
    FOREIGN KEY (genero) REFERENCES catalogoGeneros(cveGenero)
);

-- Crear tabla administrador
DROP TABLE IF EXISTS administrador;

CREATE TABLE administrador (
    idAdministrador INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombreAdministrador CHAR(50),
    apellidoAdministrador CHAR(50),
    edad TINYINT UNSIGNED NOT NULL CHECK (edad >= 18),
    genero CHAR(1) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    usuario CHAR(12) NOT NULL UNIQUE,
    contrasena CHAR(15) NOT NULL CHECK (usuario <> contrasena),
    FOREIGN KEY (genero) REFERENCES catalogoGeneros(cveGenero)
);

-- Crear tabla vendedor
DROP TABLE IF EXISTS vendedor;

CREATE TABLE vendedor (
    idVendedor INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombreVendedor CHAR(50),
    apellidoVendedor CHAR(50),
    edad TINYINT UNSIGNED NOT NULL CHECK (edad >= 18),
    genero CHAR(1) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    usuario CHAR(12) NOT NULL UNIQUE,
    contrasena CHAR(15) NOT NULL CHECK (usuario <> contrasena),
    FOREIGN KEY (genero) REFERENCES catalogoGeneros(cveGenero)
);

-- Crear tabla electronicos
DROP TABLE IF EXISTS electronicos;

CREATE TABLE electronicos (
    idProducto INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombreElectronico CHAR(50),
    precio DOUBLE NOT NULL CHECK (precio >= 0),
    existencias INT NOT NULL CHECK (existencias >= 0),
    codigoDeBarras BIGINT NOT NULL UNIQUE,
    precioDeVenta DECIMAL(10,2) NOT NULL CHECK (precioDeVenta >= 0),
    costoDeProduccion DOUBLE(10,3) NOT NULL CHECK (costoDeProduccion >= 0)
);

-- Insertar valores en vendedor (corrección de valores)
INSERT INTO vendedor (nombreVendedor, apellidoVendedor, edad, genero, correo, usuario, contrasena) 
VALUES ('Ann', 'Smith', 30, 'F', 'ann.smith@example.com', 'annsmith', 'password123');
INSERT INTO vendedor (nombreVendedor, apellidoVendedor, edad, genero, correo, usuario, contrasena) 
VALUES ('Ana', 'Josefa', 23, 'F', 'ana.josefa@example.com', 'anajosefa', 'pass123');
INSERT INTO vendedor (nombreVendedor, apellidoVendedor, edad, genero, correo, usuario, contrasena) 
VALUES ('Alejandro', 'Noyola', 26, 'M', 'ale.noyola@gmail.com', 'noyola117', 'nona98');

-- Seleccionar todos los registros de vendedor
SELECT * FROM vendedor;

-- Insertar valores en comprador (corrección de valores)
INSERT INTO comprador (nombreComprador, apellidoComprador, edad, genero, correo, usuario, contrasena) 
VALUES ('Laura', 'Lopez', 30, 'F', 'laura.lopez@example.com', 'laurlope', 'password123');
INSERT INTO comprador (nombreComprador, apellidoComprador, edad, genero, correo, usuario, contrasena) 
VALUES ('Carlos', 'Perez', 23, 'M', 'carlos.perez@example.com', 'carlosp', 'pass123');
INSERT INTO comprador (nombreComprador, apellidoComprador, edad, genero, correo, usuario, contrasena) 
VALUES ('Mariana', 'Diaz', 26, 'F', 'mariana.diaz@gmail.com', 'mariadiaz', 'nona98');

-- Seleccionar todos los registros de comprador
SELECT * FROM comprador;

-- Insertar valores en administrador (corrección de valores)
INSERT INTO administrador (nombreAdministrador, apellidoAdministrador, edad, genero, correo, usuario, contrasena) 
VALUES ('Pedro', 'Gomez', 30, 'M', 'pedro.gomez@example.com', 'pedrogomez', 'password123');
INSERT INTO administrador (nombreAdministrador, apellidoAdministrador, edad, genero, correo, usuario, contrasena) 
VALUES ('Luisa', 'Martinez', 23, 'F', 'luisa.martinez@example.com', 'luisamart', 'pass123');
INSERT INTO administrador (nombreAdministrador, apellidoAdministrador, edad, genero, correo, usuario, contrasena) 
VALUES ('Andres', 'Ramirez', 26, 'M', 'andres.ramirez@gmail.com', 'andresram', 'nona98');

-- Seleccionar todos los registros de administrador
SELECT * FROM administrador;

-- Insertar registros en la tabla electronicos
INSERT INTO electronicos (nombreElectronico, precio, existencias, codigoDeBarras, precioDeVenta, costoDeProduccion) 
VALUES 
    ('Smartphone X', 999.99, 50, 1234567890123, 1099.99, 800.500),
    ('Laptop Pro', 1499.99, 30, 9876543210123, 1599.99, 1200.750),
    ('Tablet Y', 599.99, 100, 1231231231231, 649.99, 450.400),
    ('Smartwatch Z', 199.99, 200, 3213213213213, 249.99, 150.300);

-- Seleccionar todos los registros de la tabla electronicos
SELECT * FROM electronicos;
