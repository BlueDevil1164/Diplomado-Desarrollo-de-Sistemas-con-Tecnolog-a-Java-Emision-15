USE segundabd;

SELECT SUM(listaNominal) FROM prep2024p;

LOAD DATA INFILE '/Eligio/VotosPREP2024.csv'
INTO TABLE prep2024p
FIELDS TERMINATED BY ',';