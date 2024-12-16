-- Eliminar tablas si existen
DROP TABLE IF EXISTS comprador;
DROP TABLE IF EXISTS electronicos;
DROP TABLE IF EXISTS laptops;
DROP TABLE IF EXISTS vendedor;

-- Crear tabla comprador
CREATE TABLE comprador (
    idComprador INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombreComprador VARCHAR(50),
    apellidoComprador VARCHAR(50),
    edad TINYINT UNSIGNED NOT NULL CHECK (edad >= 15),
    genero CHAR(1) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    usuarioComprador VARCHAR(25) NOT NULL UNIQUE DEFAULT 'Invitado',
    contrasena VARCHAR(15) NOT NULL CHECK (usuarioComprador <> contrasena)
) AUTO_INCREMENT=13579;

-- Crear tabla electronicos
CREATE TABLE electronicos (
    idElectronico INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombreElectronico VARCHAR(50) NOT NULL,
    precio DOUBLE NOT NULL CHECK (precio >= 0),
    existencias INT NOT NULL CHECK (existencias >= 0),
    codigoDeBarras BIGINT NOT NULL UNIQUE,
    precioDeVenta DECIMAL(10,2) NOT NULL CHECK (precioDeVenta >= 0),
    costoDeProduccion DECIMAL(10,3) NOT NULL CHECK (costoDeProduccion >= 0),
    UNIQUE (nombreElectronico, precio)
) AUTO_INCREMENT=24680;

-- Crear tabla laptops
CREATE TABLE laptops (
    idLaptop INTEGER PRIMARY KEY AUTO_INCREMENT,
    modelo VARCHAR(50),
    pantalla DOUBLE NOT NULL,
    marca CHAR(8) NOT NULL,
    color VARCHAR(100) NOT NULL,
    ram DOUBLE NOT NULL
) AUTO_INCREMENT=23579;

-- Crear tabla vendedor
CREATE TABLE vendedor (
    idVendedor INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombreVendedor VARCHAR(50),
    apellidoVendedor VARCHAR(50),
    edad TINYINT UNSIGNED NOT NULL CHECK (edad >= 15),
    genero CHAR(1) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    usuarioVendedor VARCHAR(25) NOT NULL UNIQUE DEFAULT 'Invitado',
    contrasena VARCHAR(20) NOT NULL CHECK (usuarioVendedor <> contrasena)
) AUTO_INCREMENT=97531;
