-- Crear el schema clientDB
CREATE SCHEMA IF NOT EXISTS clientDB;

-- Usar el schema clientDB
USE clientDB;

-- Crear la tabla cliente
CREATE TABLE IF NOT EXISTS cliente (
    rut VARCHAR(20) PRIMARY KEY,
    nombres VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    celular VARCHAR(20)
);