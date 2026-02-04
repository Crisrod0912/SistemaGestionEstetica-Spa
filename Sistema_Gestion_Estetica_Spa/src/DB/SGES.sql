CREATE DATABASE  IF NOT EXISTS `sges` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `sges`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: sges
-- ------------------------------------------------------
-- Server version	9.5.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '2b9f1c4c-f49b-11f0-9172-18c04da8b6b8:1-103';

--
-- Table structure for table `tb_clientes`
--

DROP TABLE IF EXISTS `tb_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_clientes` (
  `codigoCliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `fechaNacimiento` varchar(20) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `identificacion` varchar(50) NOT NULL,
  `historialServicio` varchar(255) NOT NULL,
  PRIMARY KEY (`codigoCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_clientes`
--

LOCK TABLES `tb_clientes` WRITE;
/*!40000 ALTER TABLE `tb_clientes` DISABLE KEYS */;
INSERT INTO `tb_clientes` VALUES (1,'Fernanda','Araya','1987/04/12','San José','8888-1010','fernanda@gmail.com','110101010','Limpieza facial'),(2,'Mauricio','Quesada','1972/09/30','Heredia','8888-2020','mauricio@gmail.com','120202020','Masaje relajante'),(3,'Camila','Pacheco','2021/01/18','Alajuela','8888-3030','camila@gmail.com','130303030','Tratamiento infantil'),(4,'Roxana','Leiva','1955/06/05','Cartago','8888-4040','roxana@gmail.com','140404040','Terapia eléctrica'),(5,'Esteban','Cordero','1994/11/22','Escazú','8888-5050','esteban@gmail.com','150505050','Masaje deportivo'),(6,'Natalia','Salazar','1989/08/14','Desamparados','8888-6060','natalia@gmail.com','160606060','Limpieza profunda');
/*!40000 ALTER TABLE `tb_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_empleados`
--

DROP TABLE IF EXISTS `tb_empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_empleados` (
  `codigoEmpleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `fechaNacimiento` varchar(20) NOT NULL,
  `identificacion` varchar(100) NOT NULL,
  `salario` double NOT NULL,
  `especialidad` varchar(100) NOT NULL,
  `disponibilidad` varchar(100) NOT NULL,
  PRIMARY KEY (`codigoEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empleados`
--

LOCK TABLES `tb_empleados` WRITE;
/*!40000 ALTER TABLE `tb_empleados` DISABLE KEYS */;
INSERT INTO `tb_empleados` VALUES (1,'Andrea','Ríos','1990/02/10','211111111',600000,'Limpieza facial','Tiempo Completo'),(2,'Valeria','Montoya','1986/07/25','222222222',620000,'Masajes relajantes','Tiempo Parcial'),(3,'Daniela','Obando','1992/03/14','233333333',580000,'Terapia eléctrica','Tiempo Completo'),(4,'Paula','Zamora','1984/12/01','244444444',640000,'Masaje deportivo','Tiempo Parcial'),(5,'Melissa','Ureña','1995/05/09','255555555',570000,'Tratamientos corporales','Tiempo Completo'),(6,'Karina','Fallas','1988/10/18','266666666',610000,'Limpieza profunda','Tiempo Parcial');
/*!40000 ALTER TABLE `tb_empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_espacios_atencion`
--

DROP TABLE IF EXISTS `tb_espacios_atencion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_espacios_atencion` (
  `codigoCabina` int NOT NULL AUTO_INCREMENT,
  `numeroCabina` int NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  `codigoPaciente` int DEFAULT NULL,
  PRIMARY KEY (`codigoCabina`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_espacios_atencion`
--

LOCK TABLES `tb_espacios_atencion` WRITE;
/*!40000 ALTER TABLE `tb_espacios_atencion` DISABLE KEYS */;
INSERT INTO `tb_espacios_atencion` VALUES (1,1,1,NULL),(2,2,0,1),(3,3,1,NULL),(4,4,0,3),(5,5,1,NULL),(6,6,0,5);
/*!40000 ALTER TABLE `tb_espacios_atencion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_facturas`
--

DROP TABLE IF EXISTS `tb_facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_facturas` (
  `codigoFactura` int NOT NULL AUTO_INCREMENT,
  `codigoReserva` int NOT NULL,
  `codigoCliente` int NOT NULL,
  `montoFactura` double NOT NULL,
  PRIMARY KEY (`codigoFactura`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_facturas`
--

LOCK TABLES `tb_facturas` WRITE;
/*!40000 ALTER TABLE `tb_facturas` DISABLE KEYS */;
INSERT INTO `tb_facturas` VALUES (1,1,1,28000),(2,2,2,32000),(3,3,3,18000),(4,4,4,22000),(5,5,5,30000),(6,6,6,26000);
/*!40000 ALTER TABLE `tb_facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_personal_apoyo`
--

DROP TABLE IF EXISTS `tb_personal_apoyo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_personal_apoyo` (
  `codigoColaborador` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `edad` int NOT NULL,
  `identificacion` varchar(100) NOT NULL,
  `salario` double NOT NULL,
  `experiencia` int NOT NULL,
  PRIMARY KEY (`codigoColaborador`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_personal_apoyo`
--

LOCK TABLES `tb_personal_apoyo` WRITE;
/*!40000 ALTER TABLE `tb_personal_apoyo` DISABLE KEYS */;
INSERT INTO `tb_personal_apoyo` VALUES (1,'Jonathan',29,'311111111',420000,4),(2,'Mónica',34,'322222222',450000,7),(3,'Ricardo',41,'333333333',480000,10),(4,'Tatiana',27,'344444444',400000,3),(5,'Sebastián',36,'355555555',460000,8),(6,'Lorena',31,'366666666',430000,5);
/*!40000 ALTER TABLE `tb_personal_apoyo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_reservas`
--

DROP TABLE IF EXISTS `tb_reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_reservas` (
  `codigoReserva` int NOT NULL AUTO_INCREMENT,
  `codigoEmpleado` int NOT NULL,
  `codigoCliente` int NOT NULL,
  `fechaReserva` varchar(50) NOT NULL,
  `horaReserva` varchar(50) NOT NULL,
  PRIMARY KEY (`codigoReserva`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_reservas`
--

LOCK TABLES `tb_reservas` WRITE;
/*!40000 ALTER TABLE `tb_reservas` DISABLE KEYS */;
INSERT INTO `tb_reservas` VALUES (1,1,1,'2026/02/03','08:00'),(2,2,2,'2026/02/03','09:00'),(3,3,3,'2026/02/03','10:30'),(4,4,4,'2026/02/03','13:00'),(5,5,5,'2026/02/03','15:00'),(6,6,6,'2026/02/03','16:30');
/*!40000 ALTER TABLE `tb_reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuarios` (
  `codigoUsuario` int NOT NULL AUTO_INCREMENT,
  `idUsuario` varchar(100) NOT NULL,
  `contrasenna` varchar(200) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `rol` varchar(20) NOT NULL,
  PRIMARY KEY (`codigoUsuario`),
  UNIQUE KEY `idUsuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES (1,'admin_sges','admin2026','Administrador SGES','Admin'),(2,'empleado1','emp123','Usuario Atención','Usuario'),(3,'empleado2','emp456','Usuario Caja','Usuario'),(4,'consulta01','cons123','Usuario Consulta','Usuario'),(5,'reportes','rep2026','Usuario Reportes','Usuario'),(6,'supervisor','sup789','Supervisor General','Admin');
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sges'
--
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-30  9:29:19
