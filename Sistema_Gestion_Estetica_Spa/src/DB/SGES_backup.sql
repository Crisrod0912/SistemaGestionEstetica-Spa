CREATE DATABASE sges;

USE sges;

CREATE TABLE tb_clientes (
	codigoCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fechaNacimiento VARCHAR(20) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    identificacion VARCHAR(50) NOT NULL,
    historialServicio VARCHAR(255) NOT NULL
);

CREATE TABLE tb_empleados (
	codigoEmpleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fechaNacimiento VARCHAR(20) NOT NULL,
    identificacion VARCHAR(100) NOT NULL,
    salario DOUBLE NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    disponibilidad VARCHAR(100) NOT NULL
);

CREATE TABLE tb_personal_apoyo (
	codigoColaborador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    identificacion VARCHAR(100) NOT NULL,
    salario DOUBLE NOT NULL,
    experiencia INT NOT NULL
);

CREATE TABLE tb_espacios_atencion (
	codigoCabina INT AUTO_INCREMENT PRIMARY KEY,
    numeroCabina INT NOT NULL,
    disponible BOOLEAN NOT NULL,
    codigoPaciente INT
);

CREATE TABLE tb_reservas (
	codigoReserva INT AUTO_INCREMENT PRIMARY KEY,
    codigoEmpleado INT NOT NULL,
    codigoCliente INT NOT NULL,
    fechaReserva VARCHAR(50) NOT NULL,
    horaReserva VARCHAR(50) NOT NULL
);

CREATE TABLE tb_facturas (
	codigoFactura INT AUTO_INCREMENT PRIMARY KEY,
    codigoReserva INT NOT NULL,
    codigoCliente INT NOT NULL,
    montoFactura DOUBLE NOT NULL
);

CREATE TABLE tb_usuarios (
	codigoUsuario INT AUTO_INCREMENT PRIMARY KEY,
    idUsuario VARCHAR(100) NOT NULL UNIQUE,
    contrasenna VARCHAR(200) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    rol VARCHAR(20) NOT NULL
);

INSERT INTO tb_clientes (nombre, apellido, fechaNacimiento, direccion, telefono, correo, identificacion, historialServicio) VALUES
('Fernanda', 'Araya', '1987/04/12', 'San José', '8888-1010', 'fernanda@gmail.com', '110101010', 'Limpieza facial'),
('Mauricio', 'Quesada', '1972/09/30', 'Heredia', '8888-2020', 'mauricio@gmail.com', '120202020', 'Masaje relajante'),
('Camila', 'Pacheco', '2021/01/18', 'Alajuela', '8888-3030', 'camila@gmail.com', '130303030', 'Tratamiento infantil'),
('Roxana', 'Leiva', '1955/06/05', 'Cartago', '8888-4040', 'roxana@gmail.com', '140404040', 'Terapia eléctrica'),
('Esteban', 'Cordero', '1994/11/22', 'Escazú', '8888-5050', 'esteban@gmail.com', '150505050', 'Masaje deportivo'),
('Natalia', 'Salazar', '1989/08/14', 'Desamparados', '8888-6060', 'natalia@gmail.com', '160606060', 'Limpieza profunda');

INSERT INTO tb_empleados (nombre, apellido, fechaNacimiento, identificacion, salario, especialidad, disponibilidad) VALUES
('Andrea', 'Ríos', '1990/02/10', '211111111', 600000, 'Limpieza facial', 'Tiempo Completo'),
('Valeria', 'Montoya', '1986/07/25', '222222222', 620000, 'Masajes relajantes', 'Tiempo Parcial'),
('Daniela', 'Obando', '1992/03/14', '233333333', 580000, 'Terapia eléctrica', 'Tiempo Completo'),
('Paula', 'Zamora', '1984/12/01', '244444444', 640000, 'Masaje deportivo', 'Tiempo Parcial'),
('Melissa', 'Ureña', '1995/05/09', '255555555', 570000, 'Tratamientos corporales', 'Tiempo Completo'),
('Karina', 'Fallas', '1988/10/18', '266666666', 610000, 'Limpieza profunda', 'Tiempo Parcial');

INSERT INTO tb_personal_apoyo (nombre, edad, identificacion, salario, experiencia) VALUES
('Jonathan', 29, '311111111', 420000, 4),
('Mónica', 34, '322222222', 450000, 7),
('Ricardo', 41, '333333333', 480000, 10),
('Tatiana', 27, '344444444', 400000, 3),
('Sebastián', 36, '355555555', 460000, 8),
('Lorena', 31, '366666666', 430000, 5);

INSERT INTO tb_espacios_atencion (numeroCabina, disponible, codigoPaciente) VALUES
(1, TRUE, NULL),
(2, FALSE, 1),
(3, TRUE, NULL),
(4, FALSE, 3),
(5, TRUE, NULL),
(6, FALSE, 5);

INSERT INTO tb_reservas (codigoEmpleado, codigoCliente, fechaReserva, horaReserva) VALUES
(1, 1, '2026/02/03', '08:00'),
(2, 2, '2026/02/03', '09:00'),
(3, 3, '2026/02/03', '10:30'),
(4, 4, '2026/02/03', '13:00'),
(5, 5, '2026/02/03', '15:00'),
(6, 6, '2026/02/03', '16:30');

INSERT INTO tb_facturas (codigoReserva, codigoCliente, montoFactura) VALUES
(1, 1, 28000),
(2, 2, 32000),
(3, 3, 18000),
(4, 4, 22000),
(5, 5, 30000),
(6, 6, 26000);

INSERT INTO tb_usuarios (idUsuario, contrasenna, nombre, rol) VALUES
('admin_sges', 'admin2026', 'Administrador SGES', 'Admin'),
('empleado1', 'emp123', 'Usuario Atención', 'Usuario'),
('empleado2', 'emp456', 'Usuario Caja', 'Usuario'),
('consulta01', 'cons123', 'Usuario Consulta', 'Usuario'),
('reportes', 'rep2026', 'Usuario Reportes', 'Usuario'),
('supervisor', 'sup789', 'Supervisor General', 'Admin');
