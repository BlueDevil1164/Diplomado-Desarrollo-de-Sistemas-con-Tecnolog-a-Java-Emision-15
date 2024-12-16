USE segundabd;

DROP TABLE IF EXISTS productos;

CREATE TABLE productos(
	nombreProducto CHAR(50),
	precio DOUBLE,
	litros TINYINT,
	existencias INT,
	codigoDeBarras BIGINT,
	precioDeVenta DECIMAL(5,2),
	costoDeProduccion DOUBLE(6,3)
);

DROP TABLE IF EXISTS pruebaNumeros;

CREATE TABLE pruebaNumeros (
	entero INT,
	puntoFijo DECIMAL(8,4),
	puntoFlotante DOUBLE
);

-- Insertar valores en pruebaNumeros
INSERT INTO pruebaNumeros VALUES (123, 123.4, 123.4);

SELECT * FROM pruebaNumeros;

DROP TABLE IF EXISTS empleado;

CREATE TABLE empleado(
	rfc CHAR(13),
	curp CHAR(18),
	nombre VARCHAR(100),
	domicilio VARCHAR(150),
	fechaDeIngreso DATE,
	horaDeEntrada TIME,
	ultimaSalida DATETIME
);

-- Insertar valores en empleado
INSERT INTO empleado VALUES ('Ann','Nona98','Noyola Alejandro', 'Mikasa', '2024-06-01', '07:30', NOW());

SELECT * FROM empleado;

INSERT INTO empleado VALUES ('gall','Lalo73','Laura López', 'Mikasa', NOW(), NOW(), NOW());

SELECT * FROM empleado;