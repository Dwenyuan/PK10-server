-- MySQL dump 10.13  Distrib 5.6.22, for osx10.8 (x86_64)
--
-- Host: localhost    Database: pk10
-- ------------------------------------------------------
-- Server version	5.6.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `givenmoneyrecord`
--

DROP TABLE IF EXISTS `givenmoneyrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `givenmoneyrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `current_username` varchar(45) DEFAULT NULL,
  `opposing_username` varchar(45) DEFAULT NULL,
  `given_money` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `givenmoneyrecord`
--

LOCK TABLES `givenmoneyrecord` WRITE;
/*!40000 ALTER TABLE `givenmoneyrecord` DISABLE KEYS */;
INSERT INTO `givenmoneyrecord` VALUES (1,'7','t1',100,'2016-09-24 15:36:43'),(2,'7','t1',100,NULL),(3,'7','t1',100,'2016-09-24 15:54:18');
/*!40000 ALTER TABLE `givenmoneyrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pk10'
--

--
-- Dumping routines for database 'pk10'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-24 15:59:26
