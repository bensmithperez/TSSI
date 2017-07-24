CREATE DATABASE IF NOT EXISTS sgb;

USE sgb;

-- creo mis tablas...
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE usuarios (
	id 			INT(4) 			NOT NULL PRIMARY KEY AUTO_INCREMENT,
    tipo 		INT(2) 			NOT NULL,
    usuario 	VARCHAR(30) 	NOT NULL,
    pass 		BINARY(32) 		NOT NULL,
    activo 		TINYINT(1) 		NOT NULL
);

DROP TABLE IF EXISTS `datosUsuarios`;
CREATE TABLE datosUsuarios(
	dni			VARCHAR(8) 		NOT NULL PRIMARY KEY,
    idUsuario	INT(4) 			NOT NULL,
    nombre		VARCHAR(30) 	NOT NULL,
    apellido	VARCHAR(30) 	NOT NULL,
    fechaNac	DATETIME 		NOT NULL,
    FOREIGN KEY (idUsuario) 	REFERENCES usuarios(id)
);

DROP TABLE IF EXISTS `cuentas`;
CREATE TABLE cuentas(
	numCuenta 	VARCHAR(13) 	NOT NULL PRIMARY KEY,
    monto		FLOAT 			NOT NULL,
    activo		TINYINT(1) 		NOT NULL
);

DROP TABLE IF EXISTS `cuentasPorUsuario`;
CREATE TABLE cuentasPorUsuario(
	dniUsuario 	INT(4)			NOT NULL PRIMARY KEY,
    numCuenta 	VARCHAR(13)		NOT NULL,
    activo		TINYINT(1) 		NOT NULL
);

DROP TABLE IF EXISTS `tiposTransaccion`;
CREATE TABLE tiposTransaccion(
	id 			INT(4)			NOT NULL PRIMARY KEY,
    descripcion	VARCHAR(20)		NOT NULL			
);

DROP TABLE IF EXISTS `transacciones`;
CREATE TABLE transacciones(
	id 			INT(10) 		NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idTipo		INT(4)			NOT NULL,
    fecha		DATETIME 		NOT NULL,
    numCuenta 	VARCHAR(13)		NOT NULL,
    estado 		INT(2)			NOT NULL,
    FOREIGN KEY (idTipo) 		REFERENCES tiposTransaccion(id),
    FOREIGN KEY (numCuenta) 	REFERENCES cuentas(numCuenta)
);

DROP TABLE IF EXISTS `transferencias`;
CREATE TABLE transferencias(
	id 				INT(10) 		NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idTransaccion	INT(10) 		NOT NULL,
    cuentaDestino	VARCHAR(13)		NOT NULL,
    monto			FLOAT 			NOT NULL,
    FOREIGN KEY (idTransaccion)		REFERENCES transacciones(id),
    FOREIGN KEY (cuentaDestino) 	REFERENCES cuentas(numCuenta)
);

DROP TABLE IF EXISTS `servicios`;
CREATE TABLE servicios(
	id 			INT(4)			NOT NULL PRIMARY KEY AUTO_INCREMENT,
    descripcion	VARCHAR(20)		NOT NULL,
    activo		TINYINT(1) 		NOT NULL
);

DROP TABLE IF EXISTS `pagoServicios`;
CREATE TABLE pagoServicios(
	id 				INT(10) 		NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idTransaccion	INT(10) 		NOT NULL,
    idServicio		INT(4)			NOT NULL,
    monto			FLOAT 			NOT NULL,
    FOREIGN KEY (idTransaccion)		REFERENCES transacciones(id),
    FOREIGN KEY (idServicio)		REFERENCES servicios(id)
);

DROP TABLE IF EXISTS ``;
CREATE TABLE (
);
-- ? --

select * from usuarios;
select * from datosUsuarios;
select * from cuentas;
select * from cuentasPorUsuario;
select * from transacciones;
select * from tiposTransaccion;
select * from servicios;

insert into tiposTransaccion(id,descripcion) values (0,"transferencia"),(1,"pagoServicio");

-- seleccionar datos de un usuario --
select id, usuario, nombre, apellido, fechaNac 
from usuarios 
join datosUsuarios on 
usuarios.id = datosUsuarios.idUsuario
where dni = "11111111"
and activo = 1;

delete from usuarios where id = 2;
delete from datosUsuarios where dni = "11111111";

insert into usuarios(tipo,usuario,pass,activo) values (1,"test",SHA2("123",256),1);

update usuarios set tipo = 0 where id = 1;

insert into transacciones (idTipo,fecha,numCuenta,estado) values (0,now(),1234567891212,1);

select * from transacciones where numCuenta in (select numCuenta from cuentasPorUsuario where dniUsuario = 94662331);

select numCuenta, monto from cuentas where numCuenta = 1234567891212 and activo = 1;
select count(*) as cant from cuentasPorUsuario where dniUsuario = '' and activo = 1;
select numCuenta from cuentasPorUsuario where dniUsuario = '' and activo = 1;

select numCuenta from cuentasPorUsuario where dniUsuario = and activo = 1;