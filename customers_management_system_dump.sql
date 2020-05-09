-- MySQL dump 10.13  Distrib 5.7.29, for Win64 (x86_64)
--
-- Host: localhost    Database: customers_management_system
-- ------------------------------------------------------
-- Server version	5.7.29-log

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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adress` varchar(255) NOT NULL,
  `birth_day` varchar(255) NOT NULL,
  `birth_month` varchar(255) NOT NULL,
  `birth_year` varchar(255) NOT NULL,
  `content` longtext,
  `created_at` datetime NOT NULL,
  `family` varchar(255) NOT NULL,
  `illness` varchar(255) NOT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `purpose` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'神奈川県川崎市','04','04','1935','','2020-04-08 21:03:39','本人＋配偶者','腰痛','なし','aaaa@gmail.com','佐藤　一郎','111-1111','腰痛の解消','000-0000-0000','2020-04-18 15:35:33'),(2,'神奈川県川崎市麻生区','9','9','1940','','2020-04-09 06:51:45','couple','肩こり','なし','bbbb@gmail.com','鈴木　太郎','111-1111','肩こりの解消','000-0000-0001','2020-04-09 07:11:02'),(3,'神奈川県横須賀市','09','04','1937','','2020-04-09 07:13:30','本人＋配偶者','腰痛','佐藤　一郎','cccc@gmail.com','山田　次郎','111-1111','腰痛の解消','000-0000-0002','2020-04-17 23:31:06'),(4,'神奈川県三浦市','02','05','1986','','2020-04-17 20:36:05','単身','腰痛','','dddd@gmail.com','金子　奈々','111-1111','腰が抜けそう','000-0000-1111','2020-04-17 23:30:42');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) NOT NULL,
  `content` longtext,
  `created_at` datetime NOT NULL,
  `model_code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `stock` int(11) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'運動','','2020-04-10 00:32:31','KP','骨盤パンツ',5,'2020-04-12 23:40:08'),(2,'運動',NULL,'2020-04-12 23:40:57','BCB','BCBバンド',5,'2020-04-12 23:40:57'),(3,'睡眠',NULL,'2020-04-12 23:41:47','DCPⅡ','DCPⅡ',2,'2020-04-12 23:41:47'),(4,'栄養',NULL,'2020-04-12 23:42:25','CON','コンドロイチン',2,'2020-04-12 23:42:25'),(5,'施術','','2020-04-12 23:42:46','施術','施術',1,'2020-04-22 00:36:34');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_history`
--

DROP TABLE IF EXISTS `purchase_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `created_at` datetime NOT NULL,
  `sold_at` date NOT NULL,
  `updated_at` datetime NOT NULL,
  `customer_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi1s00v343imuq50u3tha5l1l7` (`customer_id`),
  KEY `FKsnisu83bi24lyytv2ee2iwuj9` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_history`
--

LOCK TABLES `purchase_history` WRITE;
/*!40000 ALTER TABLE `purchase_history` DISABLE KEYS */;
INSERT INTO `purchase_history` VALUES (1,'','2020-04-16 22:06:34','2020-04-16','2020-04-16 22:06:34',2,5),(2,'','2020-04-16 22:32:42','2020-04-01','2020-04-16 22:32:42',3,5),(3,'','2020-04-16 22:34:45','2020-04-01','2020-04-16 22:34:45',3,5),(4,'','2020-04-16 22:38:07','2020-04-01','2020-04-16 22:38:07',3,5),(5,'','2020-04-16 22:39:05','2020-04-01','2020-04-16 22:39:05',3,5),(6,'','2020-04-16 22:39:31','2020-04-01','2020-04-16 22:39:31',3,5),(7,'','2020-04-16 23:23:20','2020-04-16','2020-04-16 23:23:20',2,3),(8,'','2020-04-16 23:23:48','2020-04-16','2020-04-16 23:23:48',2,3),(9,'','2020-04-16 23:24:25','2020-04-16','2020-04-16 23:24:25',2,3),(10,'','2020-04-16 23:27:35','2020-04-16','2020-04-16 23:27:35',2,4),(11,'','2020-04-18 15:33:53','2020-04-18','2020-04-18 15:33:53',4,5),(13,'','2020-04-19 11:55:19','2020-04-17','2020-04-19 11:55:19',1,5);
/*!40000 ALTER TABLE `purchase_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `reserve_at` date NOT NULL,
  `updated_at` datetime NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8eccffekcj27jkdiyw2e9r8ks` (`customer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,'2020-04-16 09:50:50','2020-04-17','2020-04-16 09:50:50',3),(2,'2020-04-16 09:54:21','2020-04-17','2020-04-16 09:54:21',1),(8,'2020-04-19 09:35:00','2020-05-02','2020-04-19 09:35:00',3),(11,'2020-04-20 11:11:14','2020-04-20','2020-04-20 11:11:14',4),(12,'2020-04-20 11:13:22','2020-04-28','2020-04-20 11:13:22',1),(13,'2020-04-20 11:13:29','2020-04-25','2020-04-20 11:13:29',2);
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-24 22:21:06
