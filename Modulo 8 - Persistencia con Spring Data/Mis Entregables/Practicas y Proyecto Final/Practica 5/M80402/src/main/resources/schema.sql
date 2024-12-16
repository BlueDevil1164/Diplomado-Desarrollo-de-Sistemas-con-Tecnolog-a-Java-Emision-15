DROP TABLE IF EXISTS materia;

CREATE TABLE materia (
    clave_materia VARCHAR(50) NOT NULL,
    materia VARCHAR(100) NOT NULL,
    creditos INT NOT NULL,
    horas INT NOT NULL,
    PRIMARY KEY (clave_materia)
);