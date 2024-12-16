# Taxis de aplicación

DROP TABLE IF EXISTS catalogoGeneros;
CREATE TABLE catalogoGeneros (
	cveGenero CHAR(1) NOT NULL PRIMARY KEY,
	descripcion VARCHAR (100) NOT NULL DEFAULT 'Desconocido' unique
);

# Agregar registros
# INSERT INTO tabla VALUES (valores para todos los campos);
INSERT INTO catalogoGeneros VALUES ('F', 'Femenino'), 
                                   ('N','No disponible');

# INSERT INTO tabla (campos) VALUES (valores para esos campos);
# Solo se da valor para el campo de la clave
INSERT INTO catalogogeneros (cveGenero) VALUES ('X');  
INSERT INTO catalogogeneros (descripcion, cveGenero) VALUES ('Masculino', 'M');

SELECT * FROM catalogogeneros;



# Para eliminar registros

# Elimina TODOS los registros de la tabla
# DELETE FROM tabla; 

DELETE FROM catalogogeneros;
SELECT * FROM catalogogeneros;


# DELETE FROM tabla WHERE (condición);
DELETE FROM catalogogeneros WHERE cveGenero = 'M';
SELECT * FROM catalogogeneros;

DELETE FROM catalogogeneros WHERE 1=1;
SELECT * FROM catalogogeneros;

# TRUNCATE TABLE tabla;
# Elimina toda la tabla y la vuelve a construir
TRUNCATE TABLE catalogogeneros;
SELECT * FROM catalogogeneros;

# Clientes
DROP TABLE if EXISTS clientes;
CREATE TABLE clientes (
	idCliente INT PRIMARY KEY AUTO_INCREMENT ,
	nombre VARCHAR(100) NOT NULL UNIQUE,
	edad TINYINT UNSIGNED ,
	cveGenero CHAR(1) NOT NULL REFERENCES catalogoGeneros (cveGenero),
	correo VARCHAR(100) NOT NULL UNIQUE,
	usuario CHAR(12) NOT NULL UNIQUE,
	contrasena CHAR(15) NOT NULL CHECK (usuario <> contrasena)
);

INSERT INTO clientes VALUES (1,'Hugo',19,'M','hugo@pato.com', 'hugo','hugo123');
INSERT INTO clientes VALUES (2,'Paco',20,'N','paco@pato.com', 'paco','hugo123');
INSERT INTO clientes VALUES (77,'Luis',21,'N','luis@pato.com', 'luis','hugo123');
INSERT INTO clientes VALUES (109,'Daisy',25,'F','daisy@pato.com', 'daisy','hugo123');
INSERT INTO clientes VALUES (117,'Donald',29,'M','donald@pato.com', 'donald','hugo123');


SELECT * FROM clientes;

# Para modificar registros:
# UPDATE tabla SET campo1 = nuevo valor, campo2 = nuevo valor;

UPDATE clientes SET contrasena = '123456';
UPDATE clientes SET edad = edad + 10;

UPDATE clientes SET contrasena = '98765' , edad = edad + 5;
UPDATE clientes SET contrasena = CONCAT(usuario,'12') , edad = edad -15;

SELECT * FROM clientes;

# UPDATE tabla SET ...  WHERE condición;
UPDATE clientes SET edad = 50 WHERE usuario = 'paco';

UPDATE clientes SET contrasena = 'abcde' WHERE edad >= 20;
SELECT * FROM clientes;
SELECT * FROM catalogogeneros;


DELETE FROM catalogogeneros WHERE cveGenero = 'X';
SELECT * FROM clientes;
SELECT * FROM catalogogeneros;


TRUNCATE TABLE clientes;

DELETE FROM  catalogogeneros;




