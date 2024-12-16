-- Crear tabla catalogoGeneros si no existe
DROP TABLE IF EXISTS catalogoGeneros;

CREATE TABLE catalogoGeneros (
    cveGenero CHAR(1) NOT NULL PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL UNIQUE
);

-- Agregar registros a catalogoGeneros
INSERT INTO catalogoGeneros (cveGenero, descripcion) VALUES 
    ('F', 'Femenino'), 
    ('N', 'No disponible'),
    ('M', 'Masculino');

-- Verificar los registros en catalogoGeneros
SELECT * FROM catalogoGeneros;


-- Crear tabla catalogoLaptops si no existe
DROP TABLE IF EXISTS catalogoLaptops;

CREATE TABLE catalogoLaptops (
    cveLaptop CHAR(8) NOT NULL PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL UNIQUE
);

-- Agregar registros a catalogoLaptops
INSERT INTO catalogoLaptops (cveLaptop, descripcion) VALUES 
    ('HP', 'HP'), 
    ('Len', 'Lenovo'),
    ('Acc', 'Accer');

-- Verificar los registros en catalogoLaptops
SELECT * FROM catalogoLaptops;


-- Crear tabla laptops si no existe
DROP TABLE IF EXISTS laptops;

CREATE TABLE laptops (
    idLaptop INTEGER PRIMARY KEY AUTO_INCREMENT,
    modelo VARCHAR(50),
    pantalla DOUBLE NOT NULL,
    marca CHAR(8) NOT NULL,
    color VARCHAR(100) NOT NULL,
    ram DOUBLE NOT NULL
) AUTO_INCREMENT=23579;

-- Insertar un registro en la tabla laptops
INSERT INTO laptops (modelo, pantalla, marca, color, ram) 
VALUES ('15-fa1006la', 15.6, 'HP', 'Rojo', 8.00);
INSERT INTO laptops (modelo, pantalla, marca, color, ram)
VALUES ('XPS13-9310', 13.4, 'Dell', 'Negro', 16.00);

INSERT INTO laptops (modelo, pantalla, marca, color, ram)
VALUES ('MacBook Air M1', 13.3, 'Apple', 'Plata', 8.00);

INSERT INTO laptops (modelo, pantalla, marca, color, ram)
VALUES ('ThinkPad X1 Carbon', 14.0, 'Lenovo', 'Negro', 16.00);

INSERT INTO laptops (modelo, pantalla, marca, color, ram)
VALUES ('Aspire 5 A515', 15.6, 'Acer', 'Azul', 12.00);

INSERT INTO laptops (modelo, pantalla, marca, color, ram)
VALUES ('VivoBook 15', 15.6, 'Asus', 'Gris', 8.00);

INSERT INTO laptops (modelo, pantalla, marca, color, ram)
VALUES ('Pavilion x360', 14.0, 'HP', 'Oro', 8.00);

INSERT INTO laptops (modelo, pantalla, marca, color, ram)
VALUES ('Inspiron 14 5000', 14.0, 'Dell', 'Plata', 12.00);

INSERT INTO laptops (modelo, pantalla, marca, color, ram)
VALUES ('Yoga Slim 7', 14.0, 'Lenovo', 'Gris', 16.00);

INSERT INTO laptops (modelo, pantalla, marca, color, ram)
VALUES ('ZenBook 14', 14.0, 'Asus', 'Blanco', 8.00);

-- Verificar los registros en laptops
SELECT * FROM laptops;


-- Crear tabla comprador si no existe
DROP TABLE IF EXISTS comprador;

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

-- Insertar datos en la tabla comprador
INSERT INTO comprador (nombreComprador, apellidoComprador, edad, genero, correo, usuarioComprador, contrasena) 
VALUES ('Valerie', 'Noyola', 27, 'F', 'Vale1164@gmail.com', 'GoldenEyes1164', 'Vale@r360');

-- Verificar los registros en comprador
SELECT * FROM comprador;


-- Crear tabla vendedor si no existe
DROP TABLE IF EXISTS vendedor;

CREATE TABLE vendedor (
    idVendedor INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombreVendedor VARCHAR(50),
    apellidoVendedor VARCHAR(50),
    edad TINYINT UNSIGNED NOT NULL CHECK (edad >= 15),
    genero CHAR(1) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    usuarioVendedor VARCHAR(25) NOT NULL UNIQUE DEFAULT 'Invitado',
    contrasena VARCHAR(15) NOT NULL CHECK (usuarioVendedor <> contrasena)
) AUTO_INCREMENT=97531;

-- Insertar datos en la tabla vendedor
INSERT INTO vendedor (nombreVendedor, apellidoVendedor, edad, genero, correo, usuarioVendedor, contrasena) 
VALUES ('Sylvester', 'Stallone', 64, 'M', 'Rocky7@gmail.com', 'TigerEyes1164', 'Vale@r360');

-- Verificar los registros en vendedor
SELECT * FROM vendedor;


-- Crear tabla electronicos si no existe
DROP TABLE IF EXISTS electronicos;

CREATE TABLE electronicos (
    idElectronico INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombreElectronico VARCHAR(50) NOT NULL,
    precio DOUBLE NOT NULL CHECK (precio >= 0),
    existencias INT NOT NULL CHECK (existencias >= 0),
    codigoDeBarras BIGINT NOT NULL UNIQUE,
    precioDeVenta DECIMAL(10,2) NOT NULL CHECK (precioDeVenta >= 0),
    costoDeProduccion DECIMAL(10,3) NOT NULL CHECK (costoDeProduccion >= 0),
    UNIQUE (nombreElectronico, precio)  -- Agregar índice único para las claves foráneas
) AUTO_INCREMENT=24680;

-- Insertar datos en la tabla electronicos
INSERT INTO electronicos (nombreElectronico, precio, existencias, codigoDeBarras, precioDeVenta, costoDeProduccion) 
VALUES 
    ('Smartphone', 999.99, 50, 1234567890123, 1099.99, 800.500),
    ('Laptop', 1499.99, 30, 9876543210123, 1599.99, 1200.750),
    ('Tablet', 599.99, 100, 1231231231231, 649.99, 450.400),
    ('Smartwatch', 199.99, 200, 3213213213213, 249.99, 150.300);
    ('Cámara Digital', 499.99, 80, 4567890123456, 549.99, 350.500),
        ('Televisor 4K', 799.99, 40, 6543210987654, 899.99, 600.750),
        ('Auriculares Inalámbricos', 129.99, 300, 7890123456789, 159.99, 90.250),
        ('Consola de Videojuegos', 399.99, 70, 0123456789123, 449.99, 300.700),
        ('Bocina Bluetooth', 99.99, 150, 0987654321098, 129.99, 70.200),
        ('Monitor 27 pulgadas', 299.99, 60, 2109876543210, 349.99, 220.450),
        ('Cámara de Seguridad', 199.99, 120, 3456789012345, 249.99, 140.600),
        ('Router WiFi', 89.99, 250, 5432109876543, 109.99, 60.300),
        ('Impresora Láser', 249.99, 90, 6789012345678, 299.99, 180.400),
        ('Proyector HD', 599.99, 40, 4321098765432, 649.99, 450.750);

-- Verificar los registros en electronicos
SELECT * FROM electronicos;


-- Crear tabla compras si no existe
DROP TABLE IF EXISTS compras;

CREATE TABLE compras (
    idCompra INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombreElectronico VARCHAR(50),
    -- modelo VARCHAR(50),
    -- marca CHAR(8),
    precio DOUBLE,
    usuarioComprador VARCHAR(25),
    usuarioVendedor VARCHAR(25),
    -- FOREIGN KEY (/*modelo,*/ marca) REFERENCES laptops(/*modelo,*/ marca),
    FOREIGN KEY (nombreElectronico, precio) REFERENCES electronicos(nombreElectronico, precio),
    FOREIGN KEY (usuarioComprador) REFERENCES comprador(usuarioComprador),
    FOREIGN KEY (usuarioVendedor) REFERENCES vendedor(usuarioVendedor)
) ENGINE=InnoDB AUTO_INCREMENT=98765;

-- Insertar datos en la tabla compras
INSERT INTO compras (nombreElectronico, /*modelo,marca ,*/ precio, usuarioComprador, usuarioVendedor)
VALUES ('Laptop', /*'15-fa1006la', 'HP',*/ 1499.99, 'GoldenEyes1164', 'TigerEyes1164');

-- Verificar los registros en compras
SELECT * FROM compras;


-- Crear tabla ventas si no existe
DROP TABLE IF EXISTS ventas;

CREATE TABLE ventas (
    idVenta INTEGER PRIMARY KEY AUTO_INCREMENT,
    idCompra INTEGER,
    codigoDeBarras BIGINT,
    FOREIGN KEY (idCompra) REFERENCES compras(idCompra),
    FOREIGN KEY (codigoDeBarras) REFERENCES electronicos(codigoDeBarras)
) AUTO_INCREMENT=12345;

-- Insertar datos en la tabla ventas
INSERT INTO ventas (idCompra, codigoDeBarras) 
VALUES (98765, 9876543210123);

-- Verificar los registros en ventas
SELECT * FROM ventas;