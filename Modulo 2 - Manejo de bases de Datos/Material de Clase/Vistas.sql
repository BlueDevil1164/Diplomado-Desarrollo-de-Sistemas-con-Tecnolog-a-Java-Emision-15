USE segundabd;
SELECT * FROM prep2024p;

CREATE VIEW secciones AS
	SELECT entidad, distrito, seccion, sum(XG) XG, sum(CS) CS, SUM(JM) JM
	FROM prep2024p
	GROUP BY entidad, distrito, seccion;

# DROP VIEW secciones;

SELECT * FROM secciones WHERE JM > XG;

DROP TABLE catalogo;
CREATE TABLE catalogo (
	producto VARCHAR(100),
	precio INT,
	inicio DATE,
	fin DATE);
	
INSERT INTO catalogo VALUES ('agua',15, '2000-01-01' , '2024-12-31');
INSERT INTO catalogo VALUES  ('agua',14, '1990-01-01' , '1999-12-31');

INSERT INTO catalogo VALUES  ('pasta',25, '2000-01-01' , '2024-10-31');
INSERT INTO catalogo VALUES  ('pasta',24, '1990-01-01' , '1999-12-31');
INSERT INTO catalogo VALUES  ('jabón',24, '1990-01-01' , '2025-12-31');

CREATE VIEW productosVigentes AS
	SELECT producto, precio FROM catalogo WHERE NOW() BETWEEN inicio AND fin;


SELECT * FROM productosVigentes;

