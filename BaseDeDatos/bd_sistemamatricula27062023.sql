CREATE DATABASE  IF NOT EXISTS `bd_sistemamatricula` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_sistemamatricula`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_sistemamatricula
-- ------------------------------------------------------
-- Server version	8.0.32

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

--
-- Table structure for table `tb_alumno`
--

DROP TABLE IF EXISTS `tb_alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_alumno` (
  `codigo_alum` varchar(5) NOT NULL,
  `nombre_alum` varchar(45) NOT NULL,
  `apellido_alum` varchar(45) NOT NULL,
  `numerodocumento_alum` varchar(15) NOT NULL,
  `nacionalidad_alum` varchar(45) NOT NULL,
  `correo_alum` varchar(45) NOT NULL,
  `celular_alum` varchar(15) NOT NULL,
  `fechanacimiento_alum` date NOT NULL,
  PRIMARY KEY (`codigo_alum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_alumno`
--

LOCK TABLES `tb_alumno` WRITE;
/*!40000 ALTER TABLE `tb_alumno` DISABLE KEYS */;
INSERT INTO `tb_alumno` VALUES ('A0001','Julio','Caceres','86756453','Peruana','jcaceres@gmail.com','987654321','2002-04-19'),('A0002','Sebastian','Luna','87162537','Extranjero','sluna@gmail.com','987654321','2002-04-19');
/*!40000 ALTER TABLE `tb_alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_curso`
--

DROP TABLE IF EXISTS `tb_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_curso` (
  `codigo_curso` varchar(5) NOT NULL,
  `nombre_curso` varchar(45) NOT NULL,
  `fechinicio_curso` date NOT NULL,
  `fechfin_curso` date NOT NULL,
  `codigo_prof` varchar(5) NOT NULL,
  PRIMARY KEY (`codigo_curso`),
  KEY `fk_tb_curso_tb_profesor1_idx` (`codigo_prof`),
  CONSTRAINT `fk_tb_curso_tb_profesor1` FOREIGN KEY (`codigo_prof`) REFERENCES `tb_profesor` (`codigo_prof`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_curso`
--

LOCK TABLES `tb_curso` WRITE;
/*!40000 ALTER TABLE `tb_curso` DISABLE KEYS */;
INSERT INTO `tb_curso` VALUES ('C0001','Diseño web','2023-06-21','2023-08-21','P0002'),('C0002','Arquitectura de redes','2023-06-21','2023-08-21','P0001');
/*!40000 ALTER TABLE `tb_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_matricula`
--

DROP TABLE IF EXISTS `tb_matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_matricula` (
  `codigo_matric` varchar(5) NOT NULL,
  `fecha_matric` date NOT NULL,
  `codigo_alum` varchar(5) NOT NULL,
  `codigo_curso` varchar(5) NOT NULL,
  PRIMARY KEY (`codigo_matric`),
  KEY `fk_tb_matricula_tb_alumno1_idx` (`codigo_alum`),
  KEY `fk_tb_matricula_tb_curso1_idx` (`codigo_curso`),
  CONSTRAINT `fk_tb_matricula_tb_alumno1` FOREIGN KEY (`codigo_alum`) REFERENCES `tb_alumno` (`codigo_alum`),
  CONSTRAINT `fk_tb_matricula_tb_curso1` FOREIGN KEY (`codigo_curso`) REFERENCES `tb_curso` (`codigo_curso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_matricula`
--

LOCK TABLES `tb_matricula` WRITE;
/*!40000 ALTER TABLE `tb_matricula` DISABLE KEYS */;
INSERT INTO `tb_matricula` VALUES ('M0001','2023-06-21','A0001','C0001'),('M0002','2023-06-21','A0001','C0002');
/*!40000 ALTER TABLE `tb_matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_profesor`
--

DROP TABLE IF EXISTS `tb_profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_profesor` (
  `codigo_prof` varchar(5) NOT NULL,
  `nombre_prof` varchar(45) NOT NULL,
  `apellido_prof` varchar(45) NOT NULL,
  `numerodocumento_prof` varchar(15) NOT NULL,
  `nacionalidad_prof` varchar(45) NOT NULL,
  `celular_prof` varchar(15) NOT NULL,
  `correo_prof` varchar(45) NOT NULL,
  `espe_prof` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_prof`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_profesor`
--

LOCK TABLES `tb_profesor` WRITE;
/*!40000 ALTER TABLE `tb_profesor` DISABLE KEYS */;
INSERT INTO `tb_profesor` VALUES ('P0001','Robert','Chavez','12345678','Peruana','987654321','rchavez@gmail.com','Ciberseguridad'),('P0002','Maria','Fuertes','12345678','Extranjero','987654321','mfuertes@gmail.com','Diseño grafico');
/*!40000 ALTER TABLE `tb_profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_sistemamatricula'
--

--
-- Dumping routines for database 'bd_sistemamatricula'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-21 12:10:26
