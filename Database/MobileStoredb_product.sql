-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: localhost    Database: MobileStoredb
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `productid` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `condition_id` int(11) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `manufacturer` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `product_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `unit_in_stock` int(11) NOT NULL,
  `unit_price` int(11) NOT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (30,'Apple',1,'The advancements in the camera system start with a new primary unit with a bigger sensor and a brighter lens. The ultrawide module also sports a brighter lens','iphone-13-pro-xanh-xa-1.jpeg','Apple','Iphone 13 pro max',100,1000),(31,'Apple',1,'One small reduction of the notch, one giant leap for the iPhone! That\'s the best description for the most minor iPhone upgrade yet - the Apple iPhone 13. ','iphone13xanh.jpeg','Apple','Iphone 13',200,800),(32,'Apple',2,'The 120Hz refresh rate, an upgrade to the already available 120Hz touch input, is probably one of the most anticipated additions, especially if you are a gamer.','ipad-pro-m1-129-inch-wifi-cellular--1.jpeg','Apple','Ipad pro M1 12.9 inch',50,1200),(33,'Apple',1,'Apple today introduced the new 2021 MacBook Pro. It comes in two sizes, a 16-inch model as well as a new 14-inch model, and features a raft of changes','macbook-pro-14-m1-max-2021-10-core-cpu-xam-1.jpeg','Apple','Macbook Pro 14 M1',50,1200),(34,'Apple',3,'It\'s ok good','iphone-12-pro-max-512gb-bac-1-org.jpeg','Apple','Iphone 12 pro max',200,600);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-31 22:32:08
