# Operaciones de conjunto

# Creación de las tablas
CREATE TABLE A
  (
    numero numeric NOT NULL,
    texto char(40) NOT NULL,
	fecha datetime,
        	PRIMARY KEY (numero)	
  );

CREATE TABLE B
  (
    numero numeric NOT NULL,
    texto char(40) NOT NULL,
	fecha datetime,
        	PRIMARY KEY (numero)	
  );

  CREATE TABLE C
  (
    numero numeric NOT NULL,
    texto char(40) NOT NULL,
	fecha datetime,
        	PRIMARY KEY (numero)	
  );
  
  
INSERT INTO A VALUES ('1','UNO'   ,'2018-01-01 00:00:00.000');
INSERT INTO A VALUES ('2','DOS'   ,'2018-02-01 00:00:00.000');
INSERT INTO A VALUES ('3','TRES'  ,'2018-03-01 00:00:00.000');
INSERT INTO A VALUES ('4','CUATRO','2018-04-01 00:00:00.000');
INSERT INTO A VALUES ('5','CINCO' ,'2018-05-01 00:00:00.000');
INSERT INTO A VALUES ('6','SEIS'  ,'2018-06-01 00:00:00.000');

INSERT INTO B VALUES ('1','UNO'  ,'2018-01-01 00:00:00.000');
INSERT INTO B VALUES ('2','DOS'  ,'2018-02-02 00:00:00.000');
INSERT INTO B VALUES ('3','III'  ,'2018-03-03 00:00:00.000');
INSERT INTO B VALUES ('44','XLIV','2018-04-04 00:00:00.000');
INSERT INTO B VALUES ('54','LIV' ,'2018-05-05 00:00:00.000');
INSERT INTO B VALUES ('64','LXIV','2018-06-06 00:00:00.000');

INSERT INTO C VALUES ('11','11'  ,'2018-01-11 00:00:00.000');
INSERT INTO C VALUES ('21','21'  ,'2018-02-21 00:00:00.000');
INSERT INTO C VALUES ('31','31'  ,'2018-03-31 00:00:00.000');
INSERT INTO C VALUES ('44','XLIV','2018-04-04 00:00:00.000');
INSERT INTO C VALUES ('54','LIV' ,'2018-05-05 00:00:00.000');
INSERT INTO C VALUES ('64','LXIV','2018-06-06 00:00:00.000');


SELECT * FROM A;
SELECT * FROM B;
SELECT * FROM C;


## UNION
# Intenta hacer la "suma" de los registros de dos querys
# SELECT 1
# UNION
# SELECT 2;

SELECT * FROM A
UNION 
SELECT * FROM B;


# SELECT 1
# UNION ALL
# SELECT 2;

SELECT * FROM A
UNION ALL
SELECT * FROM B
ORDER BY 3;

SELECT numero, texto FROM A
UNION
SELECT numero, texto FROM B
UNION
SELECT numero, texto FROM C;

## Intersección de conjuntos
# SELECT 1
# INTERSECT 
# SELECT 2

SELECT numero, texto FROM A
INTERSECT
SELECT numero, texto FROM B;

## Diferencia ("resta")
# SELECT 1
# EXCEPT 
# SELECT 2

SELECT numero, texto FROM A
EXCEPT
SELECT numero, texto FROM B;

SELECT numero, texto FROM B
EXCEPT
SELECT numero, texto FROM A;