CREATE DATABASE IF NOT EXISTS sgb;

USE sgb;

-- creo mis tablas...
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE usuarios (
	id 		INT(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    tipo 	INT(2) NOT NULL,
    usuario VARCHAR(30) NOT NULL,
    pass 	BINARY(32) NOT NULL,
    activo 	TINYINT(1) NOT NULL
)

select * from usuarios