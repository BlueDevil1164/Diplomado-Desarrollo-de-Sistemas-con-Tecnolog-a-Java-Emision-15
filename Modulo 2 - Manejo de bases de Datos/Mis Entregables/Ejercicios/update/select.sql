#Comado Select

USE segundabd;
 -- SELECT * From tabla;
SELECT * FROM catalogogeneros;

 SELECT * FROM clientes; 
 
 -- SELECT campo1, campo2, ... campoN From tabla
 SELECT descripcion FROM  catalogogeneros;
 SELECT usuario, correo, idCliente FROM clientes;
 
 -- SELECT campo1 AS alias1,  campo2 AS alias2, ... From tabla
 SELECT usuario AS cuenta , correo AS correoElectronico FROM clientes;
 SELECT idCliente id, nombre persona, correo FROM clientes;
 
 -- SELECT campo1, campo2, ... expresion campoNuevo From tabla
 SELECT nombre, correo, 100 campoNuevo, edad+1 AS siguienteCumpleaños FROM clientes;
 
  -- SELECT  ... FROM tabla ORDER BY campo1, campo2, campo3... 
 SELECT nombre, cveGenero, usuario FROM clientes ORDER BY nombre;
 SELECT nombre, cveGenero, usuario FROM clientes ORDER BY cveGenero;
 SELECT nombre, cveGenero, usuario FROM clientes ORDER BY cveGenero, nombre;
 SELECT nombre, cveGenero, usuario FROM clientes ORDER BY usuario ASC; 
 SELECT nombre, cveGenero, usuario FROM clientes ORDER BY usuario DESC;
 
 SELECT nombre, cveGenero, usuario FROM clientes ORDER BY correo;  --correo no esta en el resultado
 
 --Select .. ORDER BY #columna, #columna1, #columna2,....
 SELECT nombre, cveGenero, edad, usuario FROM clientes ORDER BY 4;
 
 
 -- SELECT ... FROM tabla .. Where condicion
 SELECT * FROM clientes WHERE edad > 21 AND cveGenero<>'F';
 SELECT * FROM clientes WHERE edad BETWEEN 15 AND 25;				 -- edad >= 15 and ead <=25
 SELECT * FROM clientes WHERE edad IN (30, 19, 22, 21);         -- edad=30 OR edad OR edad=22 OR edad=21
 
 SELECT * FROM clientes WHERE edad BETWEEN 15 AND 25;		
 		 
 SELECT * FROM clientes WHERE edad IN (18,19,20,21,22,23,24,25);  
 
 SELECT * FROM clientes;
 
 --___ Like patron
 SELECT * FROM clientes WHERE nombre LIKE 'Hugo';
 SELECT * FROM clientes WHERE nombre LIKE 'Do%';  -- Que comience en Do
 SELECT * FROM clientes WHERE nombre LIKE '%o';   -- Que termine en o
 SELECT * FROM clientes WHERE nombre LIKE 'D%s%'; -- Que comience en D y tenga una s
 SELECT * FROM clientes WHERE nombre LIKE 'D_s%'; -- Que comience en D, luego un caracter, y luego una s
 
 
 SELECT * FROM clientes WHERE edad IN (18, 19, 20, 21, 22, 23, 24, 25);
 				VALUES ('Mickey', 'M', 'mickey@disney.com', 'mickey', 'mouse' );
 SELECT * FROM clientes;
 
 SELECT * FROM clientes WHERE edad <> 25 OR edad IS NULL --


 