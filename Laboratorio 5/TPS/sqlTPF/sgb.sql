CREATE DATABASE IF NOT EXISTS sgb;

USE sgb;

-- creo mis tablas...
CREATE TABLE usuarios (
	id 		VARCHAR(4) NOT NULL PRIMARY KEY,
    tipo 	INT(2) NOT NULL,
    usuario VARCHAR(30) NOT NULL,
    pass 	BINARY(32) NOT NULL
)