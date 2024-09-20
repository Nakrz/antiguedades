DROP DATABASE IF EXISTS antiguedades_db; 
CREATE DATABASE antiguedades_db;
USE antiguedades_db;


CREATE TABLE pais(
    id_pais INT(10) PRIMARY KEY NOT NULL,
    nombre_pais VARCHAR(50)
);

CREATE TABLE region (
    id_region INT PRIMARY KEY,
    nombre_region VARCHAR(100) NOT NULL,
    id_pais INT,
    FOREIGN KEY (id_pais) REFERENCES pais(id_pais)
);

CREATE TABLE ciudad(
    id_ciudad INT PRIMARY KEY,
    nombre_ciudad VARCHAR(100) NOT NULL,
    id_region INT,
    FOREIGN KEY (id_region) REFERENCES region(id_region)
);

CREATE TABLE rol(
    id_rol INT(10) PRIMARY KEY NOT NULL,
    nombre_rol VARCHAR(50)
);

CREATE TABLE disponibilidad (
    id_disponibilidad INT(10) PRIMARY KEY NOT NULL,
    nombre VARCHAR(100)
);

CREATE TABLE categorias (
    id_categoria INT(10) PRIMARY KEY NOT NULL,
    nombre_categoria VARCHAR(100)
);

CREATE TABLE administrador (
    id_administrador INT(10) PRIMARY KEY NOT NULL,
    nombre_administrador VARCHAR(50),
    apellido_administrador VARCHAR(100),
    correo VARCHAR(100)
);

CREATE TABLE empleado (
    id_empleado INT PRIMARY KEY,
    nombre_empleado VARCHAR(100),
    apellido_empleado VARCHAR(100),
    correo_empleado VARCHAR(100),
    telefono_empleado BIGINT,
    id_jefe INT,
    FOREIGN KEY (id_jefe) REFERENCES administrador(id_administrador)
);


CREATE TABLE cliente(
    id_cliente INT(10) PRIMARY KEY NOT NULL,
    nombre_cliente VARCHAR(100),
    apellido_cliente VARCHAR(100),
    correo_cliente VARCHAR(100),
    telefono_cliente BIGINT, 
    rol INT,
    id_ciudad INT,
    FOREIGN KEY (rol) REFERENCES rol(id_rol),
    FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad)
);


CREATE TABLE ranking_antiguedad (
    id_ranking INT PRIMARY KEY NOT NULL,
    valor_ranking VARCHAR(50) NOT NULL
);


CREATE TABLE epoca_antiguedad (
    id_epoca INT PRIMARY KEY NOT NULL,
    nombre_epoca VARCHAR(100) NOT NULL
);


CREATE TABLE antiguedades (
    id_antiguedad INT(10) PRIMARY KEY NOT NULL,
    nombre_antiguedad VARCHAR(250),
    id_categoria INT,
    id_disponibilidad INT,
    id_ranking INT,
    id_epoca INT,
    origen VARCHAR(100),
    estado_conservacion VARCHAR(50),
    precio DECIMAL(10, 2),
    id_administrador INT,
    FOREIGN KEY (id_administrador) REFERENCES administrador(id_administrador),
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria),
    FOREIGN KEY (id_disponibilidad) REFERENCES disponibilidad(id_disponibilidad),
    FOREIGN KEY (id_ranking) REFERENCES ranking_antiguedad(id_ranking),
    FOREIGN KEY (id_epoca) REFERENCES epoca_antiguedad(id_epoca)
);

CREATE TABLE tipo_transaccion (
    id_tipo_transaccion INT PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE metodo_pago(
    id_metodo_pago INT PRIMARY KEY NOT NULL,
    nombre_metodo_pago VARCHAR(60)
);

CREATE TABLE transacciones (
    id_transaccion INT(10) PRIMARY KEY NOT NULL,
    id_antiguedad INT,
    id_cliente INT,
    id_administrador INT,
    fecha_transaccion DATE,
    id_tipo_transaccion INT,
    id_metodo_pago INT,
    cantidad INT,
    FOREIGN KEY (id_antiguedad) REFERENCES antiguedades(id_antiguedad),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_metodo_pago) REFERENCES metodo_pago(id_metodo_pago),
    FOREIGN KEY (id_tipo_transaccion) REFERENCES tipo_transaccion(id_tipo_transaccion),
    FOREIGN KEY (id_administrador) REFERENCES administrador(id_administrador)
);


CREATE TABLE direccion_cliente (
    id_direccion INT PRIMARY KEY,
    id_cliente INT,
    direccion1 VARCHAR(255),
    direccion2 VARCHAR(255),
    id_ciudad INT,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad)
);

CREATE TABLE despachos (
    id_despacho INT(10) PRIMARY KEY,
    id_transaccion INT,
    fecha_despacho DATE,
    id_direccion INT,
    id_cliente INT,
    FOREIGN KEY (id_transaccion) REFERENCES transacciones(id_transaccion),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_direccion) REFERENCES direccion_cliente(id_direccion)
);