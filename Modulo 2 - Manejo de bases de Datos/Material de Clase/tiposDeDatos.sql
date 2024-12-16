USE segundabd;

DROP TABLE productos;

CREATE TABLE productos (
	nombreProducto	 CHAR(50),
	precio DOUBLE,
	litros TINYINT,
	existencias INT,
	codigoDeBarras BIGINT,
	
	precioDeVenta DECIMAL (5,2),
	costoDeProduccion double
	);
	
CREATE TABLE pruebaNumeros (
	entero INT,
	puntoFijo DECIMAL (8,4),
	puntoFlotante DOUBLE);
	
INSERT INTO pruebaNumeros VALUES (123.4, 123.4, 123.4);
SELECT * FROM pruebaNumeros;

DROP TABLE empleado;

CREATE TABLE empleado (
	rfc CHAR(13),
	nombre VARCHAR(200),
	fechaDeIngreso DATE,
	horaDeEntrada TIME,
	ultimaSalida DATETIME
	); 
	
INSERT INTO empleado VALUES ('oimc','eligio ortiz', '2024-06-01', '07:30', NOW() );
INSERT INTO empleado VALUES ('gall', 'Laura López', NOW(), NOW(), NOW());
SELECT * FROM empleado;
	