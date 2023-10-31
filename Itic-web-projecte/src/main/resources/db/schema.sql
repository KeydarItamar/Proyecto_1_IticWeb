CREATE TABLE IF NOT EXISTS libros (
id int PRIMARY KEY AUTO_INCREMENT,
nombre varchar(100) NOT NULL,
telefono varchar(100) NOT NULL,
email varchar(50) NOT NULL,
);

CREATE TABLE IF NOT EXISTS usuarios (
id int PRIMARY KEY AUTO_INCREMENT,
usuario varchar(30) NOT NULL UNIQUE,
password varchar(30) NOT NULL
);