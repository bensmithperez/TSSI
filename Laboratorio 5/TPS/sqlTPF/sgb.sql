CREATE DATABASE IF NOT EXISTS sgb;

USE sgb;

-- creo mis tablas...
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE usuarios (
	id 			INT(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    tipo 		INT(2) NOT NULL,
    usuario 	VARCHAR(30) NOT NULL,
    pass 		BINARY(32) NOT NULL,
    activo 		TINYINT(1) NOT NULL
);

DROP TABLE IF EXISTS `datosUsuarios`;
CREATE TABLE datosUsuarios(
	dni			VARCHAR(8) NOT NULL PRIMARY KEY,
    idUsuario	INT(4) NOT NULL,
    nombre		VARCHAR(30) NOT NULL,
    apellido	VARCHAR(30) NOT NULL,
    fechaNac	DATETIME NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES usuarios(id)
);

DROP TABLE IF EXISTS ``;
CREATE TABLE (
);
-- ? --

select * from usuarios;
select * from datosUsuarios;