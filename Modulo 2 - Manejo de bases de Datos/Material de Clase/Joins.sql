USE sistema;

SELECT * FROM modulos;
SELECT * FROM roles;
SELECT * FROM usuarios;

SELECT U.usuario, U.estatus, R.rol
	FROM usuarios U, roles R
	WHERE U.idRol = R.idRol;
	
## Usando Joins

SELECT A.usuario, A.estatus, B.rol
	FROM usuarios A
	LEFT JOIN roles B ON A.idRol = B.idRol;
	
	
SELECT * FROM bitacora;

SELECT u.usuario, m.modulo, b.fecha
	FROM bitacora b
	LEFT JOIN usuarios u ON u.idUsuario  = b.idUsuario
	LEFT JOIN modulos m ON m.cveModulo = b.cveModulo;



USE segundabd;
SELECT * FROM a;
SELECT * FROM b;


SELECT a.*, b.* 
	FROM a
	LEFT JOIN b ON a.numero = b.numero;
	
SELECT a.*, b.* 
	FROM a
	RIGHT JOIN b ON a.numero = b.numero;
	
