-- MySQL dump 10.13  Distrib 5.7.12, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: pk10
-- ------------------------------------------------------
-- Server version	5.7.13-0ubuntu0.16.04.2

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
-- Table structure for table `Test`
--

DROP TABLE IF EXISTS `Test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Test`
--

LOCK TABLES `Test` WRITE;
/*!40000 ALTER TABLE `Test` DISABLE KEYS */;
/*!40000 ALTER TABLE `Test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `rebate` varchar(45) DEFAULT NULL COMMENT '返点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES (1,'1','1','1');
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `betlimit`
--

DROP TABLE IF EXISTS `betlimit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `betlimit` (
  `id` int(11) NOT NULL,
  `bet_type` varchar(45) DEFAULT NULL,
  `bet_multiple` int(11) DEFAULT NULL,
  `bet_limit` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `betlimit`
--

LOCK TABLES `betlimit` WRITE;
/*!40000 ALTER TABLE `betlimit` DISABLE KEYS */;
INSERT INTO `betlimit` VALUES (1,'大小单双',10,1000),(2,'0-9',20,1000);
/*!40000 ALTER TABLE `betlimit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodname` varchar(255) DEFAULT NULL COMMENT '????',
  `price` float DEFAULT NULL COMMENT '????',
  `goodsimg` varchar(255) DEFAULT NULL COMMENT '????',
  `goodsnum` int(11) DEFAULT NULL COMMENT '??????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ucs2 COMMENT='???';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lotteryhistory`
--

DROP TABLE IF EXISTS `lotteryhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lotteryhistory` (
  `id` int(11) NOT NULL,
  `createdAt` datetime DEFAULT NULL COMMENT '????',
  `lotterynums` char(29) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lotteryhistory`
--

LOCK TABLES `lotteryhistory` WRITE;
/*!40000 ALTER TABLE `lotteryhistory` DISABLE KEYS */;
INSERT INTO `lotteryhistory` VALUES (573681,'2016-09-02 23:57:00','08,05,07,03,01,04,06,09,02,10'),(573682,'2016-09-03 09:07:00','10,03,06,02,04,08,01,09,05,07'),(573683,'2016-09-03 09:12:00','09,08,05,07,02,06,10,04,03,01'),(573684,'2016-09-03 09:17:00','07,10,03,09,05,01,04,08,06,02'),(573685,'2016-09-03 09:22:00','09,01,07,08,06,04,05,03,02,10'),(573686,'2016-09-03 09:27:00','08,01,02,03,10,04,05,06,09,07'),(573687,'2016-09-03 09:32:00','01,09,05,03,10,06,02,07,04,08'),(573688,'2016-09-03 09:37:00','08,01,06,02,03,04,05,07,10,09'),(573689,'2016-09-03 09:42:00','06,08,10,04,07,02,01,05,09,03'),(573690,'2016-09-03 09:47:00','10,02,01,05,03,07,06,09,04,08'),(573691,'2016-09-03 09:52:00','07,06,02,03,05,09,08,10,01,04'),(573692,'2016-09-03 09:57:00','06,05,03,07,02,01,04,10,08,09'),(573693,'2016-09-03 10:02:00','06,05,02,07,10,03,09,08,04,01'),(573694,'2016-09-03 10:07:00','07,04,10,02,05,01,09,03,06,08'),(573695,'2016-09-03 10:12:00','06,03,01,09,10,07,05,08,02,04'),(573696,'2016-09-03 10:17:00','04,06,09,02,07,10,03,08,05,01'),(573697,'2016-09-03 10:22:00','07,02,03,10,04,06,08,01,09,05'),(573698,'2016-09-03 10:27:00','01,04,10,05,08,07,09,03,02,06'),(573699,'2016-09-03 10:32:00','03,01,07,10,02,06,04,05,08,09'),(573700,'2016-09-03 10:37:00','09,01,06,07,10,05,03,08,04,02'),(573701,'2016-09-03 10:42:00','03,06,04,05,01,09,02,08,07,10'),(573702,'2016-09-03 10:47:00','01,08,05,02,09,10,07,03,06,04'),(573703,'2016-09-03 10:52:00','08,05,02,09,01,07,10,03,04,06'),(573704,'2016-09-03 10:57:00','05,01,02,10,09,04,06,07,03,08'),(573705,'2016-09-03 11:02:00','08,09,06,03,05,01,02,10,07,04'),(573706,'2016-09-03 11:07:00','08,05,06,01,10,07,09,03,04,02'),(573707,'2016-09-03 11:12:00','07,02,09,04,06,05,08,10,01,03'),(573708,'2016-09-03 11:17:00','02,09,07,08,05,01,03,10,06,04'),(573709,'2016-09-03 11:22:00','04,09,08,01,10,02,07,03,06,05'),(573710,'2016-09-03 11:27:00','08,01,06,07,04,09,05,10,03,02'),(573711,'2016-09-03 11:32:00','01,08,09,04,10,02,03,05,06,07'),(573712,'2016-09-03 11:37:00','06,05,02,10,07,04,08,03,09,01'),(573713,'2016-09-03 11:42:00','03,01,04,05,07,02,06,10,09,08'),(573714,'2016-09-03 11:47:00','07,01,04,06,09,05,08,02,03,10'),(573715,'2016-09-03 11:52:00','10,09,04,07,03,02,08,05,06,01');
/*!40000 ALTER TABLE `lotteryhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '??ID',
  `content` varchar(12000) CHARACTER SET utf8 DEFAULT NULL COMMENT '????',
  `title` varchar(45) CHARACTER SET utf8 DEFAULT NULL COMMENT '????',
  `createdAt` datetime DEFAULT NULL COMMENT '??????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '??ID',
  `user` varchar(255) CHARACTER SET ucs2 DEFAULT NULL COMMENT '????',
  `price` double DEFAULT NULL COMMENT '????',
  `status` varchar(45) CHARACTER SET ucs2 DEFAULT NULL COMMENT '????',
  `createdAt` datetime DEFAULT NULL COMMENT '??????',
  `userinfo_openid` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_userinfo1_idx` (`userinfo_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='???';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_has_goods`
--

DROP TABLE IF EXISTS `orders_has_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders_has_goods` (
  `order_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  KEY `fk_order_has_goods_goods1_idx` (`goods_id`),
  KEY `fk_order_has_goods_order1_idx` (`order_id`),
  CONSTRAINT `fk_order_has_goods_goods1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_has_goods_order1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_has_goods`
--

LOCK TABLES `orders_has_goods` WRITE;
/*!40000 ALTER TABLE `orders_has_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders_has_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokenconfig`
--

DROP TABLE IF EXISTS `tokenconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tokenconfig` (
  `tokenurl` varchar(200) DEFAULT NULL,
  `appid` char(18) NOT NULL,
  `appsecret` char(32) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `numberodd` double DEFAULT NULL,
  `singleodd` double DEFAULT NULL,
  `bigodd` double DEFAULT NULL,
  PRIMARY KEY (`appid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='?????';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokenconfig`
--

LOCK TABLES `tokenconfig` WRITE;
/*!40000 ALTER TABLE `tokenconfig` DISABLE KEYS */;
INSERT INTO `tokenconfig` VALUES ('https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential','wxffe190dec3271a1c','4192f1eb31b0ebf5c8fbf7fcd80a7913',10000,9,1.5,1.5);
/*!40000 ALTER TABLE `tokenconfig` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokeninfo`
--

DROP TABLE IF EXISTS `tokeninfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tokeninfo` (
  `id` varchar(100) CHARACTER SET utf8 NOT NULL,
  `tokenid` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL,
  `jsapitoken` varchar(90) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci COMMENT='??token ?????????????????';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokeninfo`
--

LOCK TABLES `tokeninfo` WRITE;
/*!40000 ALTER TABLE `tokeninfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tokeninfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userbet`
--

DROP TABLE IF EXISTS `userbet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userbet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idnum` char(14) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL COMMENT '?????? ‘??’ ‘??’ ‘??’',
  `betmoney` double DEFAULT NULL COMMENT '????',
  `mulit` int(11) DEFAULT NULL COMMENT '????',
  `betnum` varchar(10) DEFAULT NULL COMMENT '????, ???? ''single'' ''double'' ''big'' ''small'' ',
  `createdAt` datetime DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `odds` double DEFAULT NULL COMMENT '??',
  `state` int(1) NOT NULL DEFAULT '0' COMMENT '?????1 ??????0?????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userbet`
--

LOCK TABLES `userbet` WRITE;
/*!40000 ALTER TABLE `userbet` DISABLE KEYS */;
/*!40000 ALTER TABLE `userbet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) DEFAULT NULL COMMENT '??????',
  `nickname` varchar(255) DEFAULT NULL COMMENT '????',
  `money` double DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `tel` varchar(21) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `isagent` int(1) DEFAULT '0' COMMENT '是否是代理商',
  `rebate` double DEFAULT NULL COMMENT '返点',
  `ower` varchar(45) DEFAULT NULL COMMENT '此用户属于哪个代理商',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-03 11:57:11
