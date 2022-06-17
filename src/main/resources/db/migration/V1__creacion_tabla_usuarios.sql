create table usuario
(
    id_usuario        INT         NOT NULL AUTO_INCREMENT,
    nombre            varchar(65) not null,
    apellido          varchar(65) not null,
    fecha_creacion    date        not null,
    fecha_eliminacion date,
    primary key (id_usuario)
);

INSERT INTO usuario
(nombre,
 apellido,
 fecha_creacion)
VALUES ('Daniel',
        'florez',
        now());