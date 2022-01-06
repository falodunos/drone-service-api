-- MySQL dump 10.13  Distrib 8.0.27, for macos11.6 (x86_64)
--
-- Host: localhost    Database: droneservicedb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `drone`
--

DROP TABLE IF EXISTS `drone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drone` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `battery_capacity` varchar(10) NOT NULL,
  `model` varchar(30) NOT NULL,
  `serial_number` varchar(100) NOT NULL,
  `state` varchar(30) NOT NULL DEFAULT 'IDLE',
  `weight_limit` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drone`
--

LOCK TABLES `drone` WRITE;
/*!40000 ALTER TABLE `drone` DISABLE KEYS */;
INSERT INTO `drone` VALUES (1,'2022-01-05 14:30:29','2022-01-05 14:30:29','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','idle','500gr'),(2,'2022-01-05 14:31:55','2022-01-05 14:31:55','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','idle','500gr');
/*!40000 ALTER TABLE `drone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drone_history`
--

DROP TABLE IF EXISTS `drone_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drone_history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `battery_capacity` varchar(10) NOT NULL,
  `model` varchar(30) NOT NULL,
  `serial_number` varchar(100) NOT NULL,
  `weight_limit` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drone_history`
--

LOCK TABLES `drone_history` WRITE;
/*!40000 ALTER TABLE `drone_history` DISABLE KEYS */;
INSERT INTO `drone_history` VALUES (1,'2022-01-05 14:30:52','2022-01-05 14:30:52','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(2,'2022-01-05 14:31:22','2022-01-05 14:31:22','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(3,'2022-01-05 14:31:52','2022-01-05 14:31:52','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(4,'2022-01-05 14:32:23','2022-01-05 14:32:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(5,'2022-01-05 14:32:23','2022-01-05 14:32:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(6,'2022-01-05 14:32:53','2022-01-05 14:32:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(7,'2022-01-05 14:32:53','2022-01-05 14:32:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(8,'2022-01-05 14:33:23','2022-01-05 14:33:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(9,'2022-01-05 14:33:23','2022-01-05 14:33:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(10,'2022-01-05 14:33:53','2022-01-05 14:33:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(11,'2022-01-05 14:33:53','2022-01-05 14:33:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(12,'2022-01-05 14:34:23','2022-01-05 14:34:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(13,'2022-01-05 14:34:23','2022-01-05 14:34:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(14,'2022-01-05 14:34:53','2022-01-05 14:34:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(15,'2022-01-05 14:34:53','2022-01-05 14:34:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(16,'2022-01-05 14:35:23','2022-01-05 14:35:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(17,'2022-01-05 14:35:23','2022-01-05 14:35:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(18,'2022-01-05 14:35:53','2022-01-05 14:35:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(19,'2022-01-05 14:35:53','2022-01-05 14:35:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(20,'2022-01-05 14:36:23','2022-01-05 14:36:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(21,'2022-01-05 14:36:23','2022-01-05 14:36:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(22,'2022-01-05 14:36:53','2022-01-05 14:36:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(23,'2022-01-05 14:36:53','2022-01-05 14:36:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(24,'2022-01-05 14:37:23','2022-01-05 14:37:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(25,'2022-01-05 14:37:23','2022-01-05 14:37:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(26,'2022-01-05 14:37:53','2022-01-05 14:37:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(27,'2022-01-05 14:37:53','2022-01-05 14:37:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(28,'2022-01-05 14:38:23','2022-01-05 14:38:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(29,'2022-01-05 14:38:23','2022-01-05 14:38:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(30,'2022-01-05 14:38:53','2022-01-05 14:38:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(31,'2022-01-05 14:38:53','2022-01-05 14:38:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(32,'2022-01-05 14:39:23','2022-01-05 14:39:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(33,'2022-01-05 14:39:23','2022-01-05 14:39:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(34,'2022-01-05 14:39:53','2022-01-05 14:39:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(35,'2022-01-05 14:39:53','2022-01-05 14:39:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(36,'2022-01-05 14:40:23','2022-01-05 14:40:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(37,'2022-01-05 14:40:23','2022-01-05 14:40:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(38,'2022-01-05 14:40:53','2022-01-05 14:40:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(39,'2022-01-05 14:40:53','2022-01-05 14:40:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(40,'2022-01-05 14:41:23','2022-01-05 14:41:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(41,'2022-01-05 14:41:23','2022-01-05 14:41:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(42,'2022-01-05 14:41:53','2022-01-05 14:41:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(43,'2022-01-05 14:41:53','2022-01-05 14:41:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(44,'2022-01-05 14:42:23','2022-01-05 14:42:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(45,'2022-01-05 14:42:23','2022-01-05 14:42:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(46,'2022-01-05 14:42:53','2022-01-05 14:42:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(47,'2022-01-05 14:42:53','2022-01-05 14:42:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(48,'2022-01-05 14:43:23','2022-01-05 14:43:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(49,'2022-01-05 14:43:23','2022-01-05 14:43:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(50,'2022-01-05 14:43:53','2022-01-05 14:43:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(51,'2022-01-05 14:43:53','2022-01-05 14:43:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(52,'2022-01-05 14:44:23','2022-01-05 14:44:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(53,'2022-01-05 14:44:23','2022-01-05 14:44:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(54,'2022-01-05 14:44:53','2022-01-05 14:44:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(55,'2022-01-05 14:44:53','2022-01-05 14:44:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(56,'2022-01-05 14:45:23','2022-01-05 14:45:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(57,'2022-01-05 14:45:23','2022-01-05 14:45:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(58,'2022-01-05 14:45:53','2022-01-05 14:45:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(59,'2022-01-05 14:45:53','2022-01-05 14:45:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(60,'2022-01-05 14:46:23','2022-01-05 14:46:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(61,'2022-01-05 14:46:23','2022-01-05 14:46:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(62,'2022-01-05 14:46:53','2022-01-05 14:46:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(63,'2022-01-05 14:46:53','2022-01-05 14:46:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(64,'2022-01-05 14:47:23','2022-01-05 14:47:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(65,'2022-01-05 14:47:23','2022-01-05 14:47:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(66,'2022-01-05 14:47:53','2022-01-05 14:47:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(67,'2022-01-05 14:47:53','2022-01-05 14:47:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(68,'2022-01-05 14:48:23','2022-01-05 14:48:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(69,'2022-01-05 14:48:23','2022-01-05 14:48:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(70,'2022-01-05 14:48:53','2022-01-05 14:48:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(71,'2022-01-05 14:48:53','2022-01-05 14:48:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(72,'2022-01-05 14:49:23','2022-01-05 14:49:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(73,'2022-01-05 14:49:23','2022-01-05 14:49:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(74,'2022-01-05 14:49:53','2022-01-05 14:49:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(75,'2022-01-05 14:49:53','2022-01-05 14:49:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(76,'2022-01-05 14:50:23','2022-01-05 14:50:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(77,'2022-01-05 14:50:23','2022-01-05 14:50:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(78,'2022-01-05 14:50:53','2022-01-05 14:50:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(79,'2022-01-05 14:50:53','2022-01-05 14:50:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(80,'2022-01-05 14:51:23','2022-01-05 14:51:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(81,'2022-01-05 14:51:23','2022-01-05 14:51:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(82,'2022-01-05 14:51:53','2022-01-05 14:51:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(83,'2022-01-05 14:51:53','2022-01-05 14:51:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(84,'2022-01-05 14:52:23','2022-01-05 14:52:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(85,'2022-01-05 14:52:23','2022-01-05 14:52:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(86,'2022-01-05 14:52:53','2022-01-05 14:52:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(87,'2022-01-05 14:52:53','2022-01-05 14:52:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(88,'2022-01-05 14:53:23','2022-01-05 14:53:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(89,'2022-01-05 14:53:23','2022-01-05 14:53:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(90,'2022-01-05 14:53:53','2022-01-05 14:53:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(91,'2022-01-05 14:53:53','2022-01-05 14:53:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(92,'2022-01-05 14:54:23','2022-01-05 14:54:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(93,'2022-01-05 14:54:23','2022-01-05 14:54:23','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(94,'2022-01-05 14:54:53','2022-01-05 14:54:53','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(95,'2022-01-05 14:54:53','2022-01-05 14:54:53','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(96,'2022-01-05 14:55:23','2022-01-05 14:55:23','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(97,'2022-01-05 14:55:24','2022-01-05 14:55:24','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(98,'2022-01-05 14:55:54','2022-01-05 14:55:54','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(99,'2022-01-05 14:55:54','2022-01-05 14:55:54','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(100,'2022-01-05 14:56:24','2022-01-05 14:56:24','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(101,'2022-01-05 14:56:24','2022-01-05 14:56:24','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr'),(102,'2022-01-05 14:56:54','2022-01-05 14:56:54','0.3','cruiserweight','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','500gr'),(103,'2022-01-05 14:56:54','2022-01-05 14:56:54','0.8','heavyweight','TN6AG81P8375115JIJ41GK7127KG3K63V_ZSB4M6XMSZ1Q4XGR','500gr');
/*!40000 ALTER TABLE `drone_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medication`
--

DROP TABLE IF EXISTS `medication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medication` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `code` varchar(50) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `name` varchar(100) NOT NULL,
  `state` varchar(20) NOT NULL DEFAULT 'RESTING',
  `weight` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pex4ncvrjs43bnm3oucqghy42` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medication`
--

LOCK TABLES `medication` WRITE;
/*!40000 ALTER TABLE `medication` DISABLE KEYS */;
INSERT INTO `medication` VALUES (1,'2022-01-05 14:32:38','2022-01-05 14:32:38','IGG6H5E2PH1YD32RO2T1F4CVSKF628Q91QH3Z5H57OPIC5B2A6','http://localhost:8084/downloadFile/Screenshot%202021-12-06%20at%2017.33.54.png','Parastamol-1','resting','500gr'),(2,'2022-01-05 14:33:10','2022-01-05 14:33:10','0X088CS2B2407656_JAH9KX2UDD2S8GI7A5Z1J3706560E3B44','http://localhost:8084/downloadFile/Screenshot%202021-12-06%20at%2017.33.54.png','Parastamol-2','resting','500gr');
/*!40000 ALTER TABLE `medication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `drone_sn` varchar(100) NOT NULL,
  `medication_code` varchar(100) NOT NULL,
  `package_reference` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'2022-01-05 14:35:30','2022-01-05 14:35:30','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','IGG6H5E2PH1YD32RO2T1F4CVSKF628Q91QH3Z5H57OPIC5B2A6','6M31235T334EI19A696Y82668N3XVA2BXAYXI5MGGUSB888V0V'),(2,'2022-01-05 14:35:30','2022-01-05 14:35:30','8DUW02H527SD760UL6Z32016577A404GI4T11LH_LT9V38FHRQ','0X088CS2B2407656_JAH9KX2UDD2S8GI7A5Z1J3706560E3B44','6M31235T334EI19A696Y82668N3XVA2BXAYXI5MGGUSB888V0V');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-05 15:56:59
