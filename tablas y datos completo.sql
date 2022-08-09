/* create database reto5;

USE reto5; */

CREATE TABLE proveedor (
  prov_id INT PRIMARY KEY,
  prov_nombre CHAR(20),
  prov_direccion CHAR(45),
  prov_telefono CHAR(20)
);

INSERT INTO proveedor (prov_id, prov_nombre, prov_direccion, prov_telefono)
VALUES
(101, "Auteco","calle 7 No. 45-17", "05713224459"),
(102, "Hitachi", "calle 19 No. 108-26", "05714223344"),
(103, "Bosch", "carrera 68 No. 26-45", "05715678798"),
(104, "Teco", "calle 77 No. 68-33", "05712213243"),
(105, "General Electric", "calle 29 No. 26-12", "05717239919");

CREATE TABLE clientes (
	alias CHAR(20) PRIMARY KEY,
    nombre CHAR(20),
    apellido CHAR(20),
    email VARCHAR(45),
    celular CHAR(12),
    contrasena INT,
    fecha_nacimiento DATE
);

INSERT into clientes (alias, nombre, apellido, email, celular, contrasena, fecha_nacimiento)
VALUES
("lucky", "Pedro", "Perez", "pedro@gmail.com", 3161234567, 12345678, "1981-05-16"),
("malopez", "Maria", "Lopez", "maria@gmail.com", 3164513654, 12345678, "1985-05-16"),
("diva", "Ana", "Diaz", "ana@gmail.com", 3169994567, 12345678, "1991-02-16"),
("dreamer", "Luis", "Rojas", "luis@gmail.com", 3165555567, 12345678, "1981-05-16"),
("ninja", "Andres", "Cruz", "andres@gmail.com", 3166262567, 12345678, "1981-09-16"),
("neon", "Nelson",  "Ruiz", "nelson@gmail.com", 3169994567, 12345678, "1985-05-16"),
("rose", "Claudia", "Mendez", "claudia@gmail.com", 3165554567, 12345678, "1989-12-16"),
("green", "Jorge", "Rodriguez", "jorge@gmail.com", 3161565667, 12345678, "1981-05-16");

CREATE TABLE fabricantes(
	fabricante CHAR(20) PRIMARY KEY
);

INSERT INTO fabricantes (fabricante)
VALUES
("Cannondale"),
("Trek"),
("Yeti"),
("Fuji"),
("Bmc"),
("Starker"),
("Lucky Lion"),
("Be Electric"),
("Aima"),
("Mec de Colombia"),
("Atom Electric");

CREATE TABLE bicicletas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fabricante CHAR(20),
    precio_unit INT,
    ano_fab INT,
    FOREIGN KEY (fabricante) REFERENCES fabricantes(fabricante) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO bicicletas (fabricante, precio_unit, ano_fab)
VALUES
("Cannondale", 1200000, 2020),
("Trek", 1450000, 2019),
("Yeti", 2000000, 2020),
("Fuji", 950000, 2021),
("Bmc", 1950000, 1018);

CREATE TABLE motos_elec (
	id INT AUTO_INCREMENT PRIMARY KEY,
    fabricante CHAR(20),
    precio_unit INT,
    autonomia INT,
    proveedor INT,
    FOREIGN KEY (fabricante) REFERENCES fabricantes(fabricante) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (proveedor) REFERENCES proveedor(prov_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO motos_elec (fabricante, precio_unit, autonomia, proveedor)
VALUES
("Starker", 4200000, 18, 101),
("Lucky Lion", 5600000, 14, 102),
("Be Electric", 4600000, 26, 101),
("Aima", 8000000, 36, 103),
("Mec de Colombia", 5900000, 20, 104),
("Atom Electric", 4500000, 12, 105);

CREATE TABLE compras (
	id INT AUTO_INCREMENT PRIMARY KEY,
	alias CHAR(20),
    fabricante CHAR(20),
    fecha_hora TIMESTAMP,
    FOREIGN KEY (alias) REFERENCES clientes(alias) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (fabricante) REFERENCES fabricantes(fabricante) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO compras (alias, fabricante, fecha_hora)
VALUES
("lucky", "Cannondale", "2017-10-25 20:00:00"),
("lucky", "Trek", '2019-03-15 18:30:00'),
("lucky", "Starker", '2019-05-20 20:30:00'),
("malopez", "Cannondale", '2018-05-20 20:30:00'),
("malopez", "Starker", '2020-01-20 20:30:00'),
("diva", "Yeti", '2019-05-20 20:30:00'),
("diva", "Fuji", '2018-06-22 21:30:00'),
("diva", "Lucky Lion", '2020-03-17 15:30:20'),
("dreamer", "Lucky Lion", '2020-03-17 15:30:20'),
("dreamer", "Be Electric", '2020-04-10 18:30:20'),
("ninja", "Aima", '2020-02-17 20:30:20'),
("ninja", "Starker", '2020-02-20 16:30:20'),
("ninja", "Mec de Colombia", '2020-03-27 18:30:20'),
("rose", "Atom Electric", '2020-03-20 21:30:20'),
("green", "Yeti", '2020-01-10 17:30:20'),
("green", "Trek", '2020-02-15 20:30:20'),
("green", "Bmc", '2020-03-17 18:30:20');