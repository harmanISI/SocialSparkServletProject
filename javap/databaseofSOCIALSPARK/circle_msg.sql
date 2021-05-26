-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: circle
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `msg`
--

DROP TABLE IF EXISTS `msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `msg` (
  `rcpt` varchar(60) DEFAULT NULL,
  `frm` varchar(50) DEFAULT NULL,
  `msgs` varchar(200) DEFAULT NULL,
  `D` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`D`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `msg`
--

LOCK TABLES `msg` WRITE;
/*!40000 ALTER TABLE `msg` DISABLE KEYS */;
INSERT INTO `msg` VALUES ('1','hj','hh','2021-05-04 20:00:49'),('d','d','d','2021-05-04 20:33:11'),('USER@','HJ@','hello sfd','2021-05-04 20:33:42'),('2USER@','HJ@','HELLO','2021-05-06 11:03:21'),('null','HJ@','MY MSG SENDING TO ','2021-05-06 11:04:08'),('USER@','HJ@','HJ@ SENDING','2021-05-06 11:05:20'),('user2','HJ@','HELLO user2','2021-05-06 11:16:56'),('user2','HJ@','SEND MSG BY HJ@','2021-05-06 11:17:14'),('ANMI','HJ@','hello','2021-05-06 11:38:47'),('user2','HJ@','hello ','2021-05-06 11:39:40'),('null','HJ@','hello ','2021-05-06 11:39:52'),('2USER@','HJ@','kk','2021-05-06 11:40:18'),('2USER@','HJ@','first time ','2021-05-06 11:44:56'),('USER@','HJ@','HELLO ','2021-05-06 11:48:27'),('ANMI','HJ@','seending','2021-05-06 12:14:44'),('ANMI','HJ@','hhdd','2021-05-06 12:24:58'),('ANMI','HJ@','send by hj@','2021-05-06 12:26:26'),('ANMI','HJ@','123','2021-05-06 12:34:13'),('','HJ@','','2021-05-06 12:34:35'),('','HJ@','','2021-05-06 12:34:36'),('USER@','HJ@','afetr edit','2021-05-06 12:48:32'),('USER@','HJ@','good','2021-05-06 12:48:44'),('user2','HJ@','aferr','2021-05-06 12:49:05'),('user2','HJ@','fr after','2021-05-06 12:49:13'),('USER@','HJ@','zz','2021-05-06 12:49:31'),('USER@','HJ@','ss','2021-05-06 12:49:40'),('ANMI','ANMI','hello ','2021-05-06 16:35:24'),('ANMI','ANMI','bro','2021-05-06 16:35:41'),('ANMI','ANMI','hello ','2021-05-06 16:39:57'),('USER@','ANMI','hello ','2021-05-06 16:40:42'),('USER@','ANMI','bro','2021-05-06 16:40:48'),('USER@','ANMI','hello HARMAN ANMI this side ','2021-05-06 16:41:26'),('2USER@','ANMI','hello gus ','2021-05-06 16:42:14'),('2USER@','ANMI','how are you','2021-05-06 16:42:20'),('2USER@','ANMI','why you ar angry','2021-05-06 16:42:32'),('2USER@','USER@','hh','2021-05-06 16:43:25'),('2USER@','USER@','hello','2021-05-06 16:44:15'),('2USER@','USER@','kida ','2021-05-06 16:44:21'),('HJ@','USER@','HELOO  USER@ THIS SIDE','2021-05-06 16:54:55'),('HJ@','USER@','HOW ARE u','2021-05-06 16:58:59'),('ANMI','HJ@','SENT MSGS','2021-05-06 17:12:32'),('ANMI','HJ@','HGHHH','2021-05-06 17:12:50'),('USER@','HJ@','HHHHH','2021-05-06 17:14:06'),('USER@','HJ@','HH','2021-05-06 22:12:19'),('2USER@','HJ@','SENT BU AKASH','2021-05-10 13:39:37'),('2USER@','HJ@','testing akash','2021-05-10 13:46:25'),('2USER@','HJ@','dd','2021-05-10 13:47:00'),('2USER@','HJ@','HH','2021-05-10 21:10:28'),('2USER@','HJ@','HH','2021-05-10 21:27:39'),('2USER@','HJ@','454554','2021-05-10 22:25:08'),('2USER@','HJ@','vxhzx','2021-05-10 22:26:27'),('2USER@','HJ@','DXD','2021-05-11 11:45:47'),('2USER@','HJ@','DXD','2021-05-11 11:45:57'),('2USER@','HJ@','ZXC','2021-05-11 12:41:35'),('2USER@','HJ@','JJ','2021-05-11 12:42:32'),('user2','HJ@','XC','2021-05-11 12:43:10'),('user2','HJ@','XZC','2021-05-11 12:45:34'),('ANMI','HJ@','hello','2021-05-13 13:36:41');
/*!40000 ALTER TABLE `msg` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-14 22:31:39
