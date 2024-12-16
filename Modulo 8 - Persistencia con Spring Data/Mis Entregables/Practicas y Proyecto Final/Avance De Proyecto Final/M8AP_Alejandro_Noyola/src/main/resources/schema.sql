-- Eliminar tablas si existen
DROP TABLE IF EXISTS Electronicos_Proveedores;
DROP TABLE IF EXISTS laptops;
DROP TABLE IF EXISTS vendedor;
DROP TABLE IF EXISTS comprador;
DROP TABLE IF EXISTS Electronicos;
DROP TABLE IF EXISTS Categoria;
DROP TABLE IF EXISTS Marca;
DROP TABLE IF EXISTS Proveedores;

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

-- Crear tabla Electronicos
CREATE TABLE Electronicos (
    idElectronico varchar(10),
    nombreElectronico VARCHAR(255),
    precio DECIMAL(10, 2),
    existencias INT,
    codigoDeBarras BIGINT,
    precioDeVenta DECIMAL(10, 2),
    costoDeProduccion DECIMAL(10, 2),
    id_categoria INT,
    PRIMARY KEY (id_categoria)
);

-- Crear tabla Categoria
CREATE TABLE Categoria (
    id_categoria int NOT NULL,
    categoria varchar(50) DEFAULT NULL,
    abreviatura varchar(5) DEFAULT NULL,
    PRIMARY KEY (id_categoria),
    UNIQUE KEY categoria_UNIQUE (categoria),
    UNIQUE KEY abreviatura_UNIQUE (abreviatura)
);

-- Crear tabla Marca
CREATE TABLE Marca (
    id INT PRIMARY KEY AUTO_INCREMENT,
    marca varchar(30),
    StarRate integer,
    electronicos_matricula varchar(10)

);

-- Crear tabla Proveedores
CREATE TABLE Proveedores (
    id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
    nombreProveedor VARCHAR(255) NOT NULL
);

-- Crear tabla Electronicos_Proveedores
CREATE TABLE Electronicos_Proveedores (
    idElectronico INT AUTO_INCREMENT PRIMARY KEY,
    matricula varchar(10),
    id_proveedor INT,
    anio INT
);

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
