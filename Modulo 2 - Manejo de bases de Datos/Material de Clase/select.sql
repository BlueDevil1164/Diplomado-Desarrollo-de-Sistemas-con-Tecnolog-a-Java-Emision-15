# Comando SELECT
USE segundabd;

# SELECT * FROM tabla;
SELECT * FROM catalogogeneros;
SELECT * FROM clientes;

# SELECT campo1, campo2, ... campoN FROM tabla
SELECT descripcion FROM catalogogeneros;
SELECT usuario, correo, idCliente FROM clientes;

# SELECT campo1 AS alias1, campo2 alias2,... FROM tabla
SELECT usuario AS cuenta, correo AS correoElectronico FROM clientes;
SELECT idCliente id, nombre persona, correo FROM clientes;

# SELECT campo1, campo2, ... expresión campoNuevo FROM tabla
SELECT nombre, correo, 100 campoNuevo, edad+1 AS siguienteCumpleanos FROM clientes;

# SELECT ... FROM tabla ORDER BY campo1,campo2,campo3...
SELECT nombre, cveGenero,edad, usuario FROM clientes ORDER BY nombre;
SELECT nombre, cveGenero,edad, usuario FROM clientes ORDER BY cveGenero;
SELECT nombre, cveGenero,edad, usuario FROM clientes ORDER BY cveGenero, nombre;
SELECT nombre, cveGenero,edad, usuario FROM clientes ORDER BY usuario ASC;
SELECT nombre, cveGenero,edad, usuario FROM clientes ORDER BY usuario DESC;
SELECT nombre, cveGenero,edad, usuario FROM clientes ORDER BY cveGenero DESC, nombre ASC;

SELECT nombre, cveGenero, edad, usuario FROM clientes ORDER BY correo;  # correo no está en el resultado

# SELECT ... ORDER BY #columna1, #columna2,....
SELECT nombre, cveGenero, edad, usuario FROM clientes ORDER BY 4;


# SELECT ... FROM tabla ... WHERE condición
# Operadores de comparación ( >   < >=   <=  =  <>)
# Operadores lógicos (AND, OR)

SELECT * FROM clientes WHERE edad <> 21 OR cveGenero<>'F';
# BETWEEN ___ AND __
SELECT * FROM clientes WHERE edad BETWEEN 15 AND 25;   # edad >= 15 AND edad <=25

# ___ IN (lista de valores)
SELECT * FROM clientes WHERE edad IN (30,19,22,21,30); # edad=30 OR edad=19 OR edad=22 OR edad=21

SELECT * FROM clientes WHERE edad BETWEEN 18 AND 25;

SELECT * FROM clientes WHERE edad IN (18,19,20, 21, 22, 23, 24, 25);

SELECT * FROM clientes;

# ___  LIKE patrón
SELECT * FROM clientes WHERE nombre LIKE 'Hugo';
SELECT * FROM clientes WHERE nombre LIKE 'Do%';   # Que comience con Do
SELECT * FROM clientes WHERE usuario LIKE '%o';   # Que termine con o
SELECT * FROM clientes WHERE usuario LIKE 'D%s%'; # Que comience con D y luego tenga una s
SELECT * FROM clientes WHERE usuario LIKE 'D__s%'; # Que comience con D, luego UN caracter, y luego una s 

SELECT * FROM clientes WHERE nombre LIKE 'D[a]%';  ## Rango de valores

INSERT INTO clientes (nombre, cveGenero, correo, usuario, contrasena) 
           VALUES ('Mickey', 'M','mickey@diseney.com', 'mickey','mouse');
SELECT * FROM clientes;

SELECT * FROM clientes WHERE edad <> 25 OR edad IS NULL ORDER BY 3;

