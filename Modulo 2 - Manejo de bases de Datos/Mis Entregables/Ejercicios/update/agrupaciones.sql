-- Agrupaciones
USE segundabd;
 
 # SELECT * From tabla;
SELECT * FROM catalogogeneros; 
SELECT * FROM clientes;

-- select campos group by

SELECT cveGenero , COUNT(*) AS registros , AVG(edad) FROM clientes GROUP BY cveGenero;


SELECT edad , COUNT(*) AS registros , AVG(edad) FROM clientes GROUP BY edad;

-- Min y max valor maxico y minimo;

SELECT cveGenero, COUNT(*) AS registros, AVG(edad) AS promedio_edad, MIN(usuario) AS usuario_min, MAX(usuario) AS usuario_max 
FROM clientes 
GROUP BY cveGenero;