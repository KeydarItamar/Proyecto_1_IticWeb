CREATE TABLE IF NOT EXISTS empresas (
    id int PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(100) NOT NULL,
    telefono varchar(100) NOT NULL,
    email varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS ofertas(
    id int PRIMARY KEY AUTO_INCREMENT,
    descripcion varchar(300) NOT NULL, 
    requisitos varchar(300) NOT NULL,
    salario int NOT NULL,
    id_empresa int,
    CONSTRAINT fk_oferta FOREIGN KEY (id_empresa) REFERENCES empresas (id) 
);

CREATE TABLE IF NOT EXISTS usuarios (
    id int PRIMARY KEY AUTO_INCREMENT,
    usuario varchar(30) NOT NULL UNIQUE,
    password varchar(30) NOT NULL
);
