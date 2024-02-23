-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: finalproject
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `cityid` int NOT NULL AUTO_INCREMENT,
  `cityname` varchar(45) DEFAULT NULL,
  `stateid` int DEFAULT NULL,
  PRIMARY KEY (`cityid`),
  KEY `fk_stateid_idx` (`stateid`),
  CONSTRAINT `fk_stateid` FOREIGN KEY (`stateid`) REFERENCES `states` (`stateid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Yavatmal',1),(2,'Pune',1),(3,'Mumbai',1),(4,'Guhagar',1),(5,'Ganpatipule',1),(6,'Hampi',2),(7,'Bangalore',2),(8,'Bhavnagar',3),(9,'Ahmedabad',3),(10,'Kochi',4),(11,'Kannur',4);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `custid` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `emailid` varchar(50) DEFAULT NULL,
  `adhar` varchar(20) NOT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`custid`),
  KEY `userid` (`userid`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Uday','Dudhe','Yavatmal','+917753750914','dudhekajal@gmail.com','123456789012',1),(2,'Onkar','Helaskar','Pune','+917977750914','onkarh93@gmail.com','456789012123',3),(3,'Shaunak','kulakarni','Sambhajinagar','+917509149777','Shaunak3@gmail.com','901212345678',2),(4,'Anikwt','Kulkarni','Pune','+919876543777','aniket@gmail.com ','1234567890',5),(5,'Deepak','Natu','Sangli','+919976543777','deepak@gmail.com ','1233567890',6),(7,'Piyusha','Joshi','Jalna','+919976599777','piyusha@gmail.com ','9933567890',8),(10,'Hetal','Vyas','Pune','9922334477','hetal@gmail.com','125560478915',20);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homestays`
--

DROP TABLE IF EXISTS `homestays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `homestays` (
  `homestayid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `emailid` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `ownerid` int DEFAULT NULL,
  `capacity` int DEFAULT NULL,
  `stateid` int DEFAULT NULL,
  `cityid` int DEFAULT NULL,
  PRIMARY KEY (`homestayid`),
  KEY `ownerid_idx` (`ownerid`),
  KEY `stateid_fkk_idx` (`stateid`),
  KEY `cityid_fk_idx` (`cityid`),
  CONSTRAINT `cityid_fk` FOREIGN KEY (`cityid`) REFERENCES `city` (`cityid`),
  CONSTRAINT `owneri` FOREIGN KEY (`ownerid`) REFERENCES `owner` (`ownerid`),
  CONSTRAINT `stateid_fkk` FOREIGN KEY (`stateid`) REFERENCES `states` (`stateid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homestays`
--

LOCK TABLES `homestays` WRITE;
/*!40000 ALTER TABLE `homestays` DISABLE KEYS */;
INSERT INTO `homestays` VALUES (1,'vrundavan','Pune','vrundavan@gmail.com','9879876543','beautiful place',2,3,NULL,NULL),(2,'Shivalay','Yavatmal','shivalay@gmail.com','9876567890','nice',2,2,NULL,NULL),(3,'hh','hh','sdkj@m.c','4545455455','h',17,5,1,2);
/*!40000 ALTER TABLE `homestays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotels`
--

DROP TABLE IF EXISTS `hotels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotels` (
  `hotelid` int NOT NULL AUTO_INCREMENT,
  `hotelname` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `emailid` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `ownerid` int DEFAULT NULL,
  `totalrooms` int DEFAULT NULL,
  `stateid` int DEFAULT NULL,
  `cityid` int DEFAULT NULL,
  PRIMARY KEY (`hotelid`),
  KEY `owner_idx` (`ownerid`),
  KEY `fk_stateid_idx` (`stateid`),
  KEY `fk_cityid_idx` (`cityid`),
  CONSTRAINT `fk_cityid` FOREIGN KEY (`cityid`) REFERENCES `city` (`cityid`),
  CONSTRAINT `owner_idx` FOREIGN KEY (`ownerid`) REFERENCES `owner` (`ownerid`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `stateid_fk` FOREIGN KEY (`stateid`) REFERENCES `states` (`stateid`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotels`
--

LOCK TABLES `hotels` WRITE;
/*!40000 ALTER TABLE `hotels` DISABLE KEYS */;
INSERT INTO `hotels` VALUES (38,'Lotus','Behind multiplex','lotus@gmail.com','0992233497','3 star hotel',17,20,1,2),(39,'Niwara','Sanjog colony','niwara@gmail.com','9988556021','Peaceful family hotel',17,10,1,3),(55,'Taj','MNP road','tajhotels@gmail.com','9960230148','5 star hotel',17,40,3,9);
/*!40000 ALTER TABLE `hotels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owner` (
  `ownerid` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `emailid` varchar(50) DEFAULT NULL,
  `userid` int DEFAULT NULL,
  `propertytype` varchar(45) DEFAULT NULL,
  `adhar` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ownerid`),
  KEY `userid` (`userid`),
  CONSTRAINT `owner_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1,'dipak','patil','Latur','+913456789012','dipak@gmail.com',1,'Hotel','1234567890'),(2,'kalyani','Satpute','Nashik','+911234789056','kalyani@gmail.com',3,'Hotel','1243567890'),(16,'Aishwarya','Jagatap','Pune','9922588550','aishwarya@gmail.com',18,'homestay','1231231234'),(17,'Riya','Choudhari','Sangli','9988778899','riya@gmail.com',19,'hotel','123123445'),(18,'Samir','Patil','Pune','0992233449','samir@gmail.com',21,'homestay','15478992362'),(19,'Sayali','Natu','Pune','8421202709','sayalin09@gmail.com',22,'hotel','178952789612');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `roleid` int NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'Owner'),(3,'Customer');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `states`
--

DROP TABLE IF EXISTS `states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `states` (
  `stateid` int NOT NULL AUTO_INCREMENT,
  `statename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stateid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `states`
--

LOCK TABLES `states` WRITE;
/*!40000 ALTER TABLE `states` DISABLE KEYS */;
INSERT INTO `states` VALUES (1,'Maharashtra'),(2,'Karnatak'),(3,'Gujarat'),(4,'Keral');
/*!40000 ALTER TABLE `states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `roleid` int DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`) ON DELETE SET NULL,
  CONSTRAINT `users_chk_1` CHECK ((`status` between 0 and 68))
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Kajal','Kajal@123',2,NULL),(2,'Aditi','Aditi@123',3,NULL),(3,'Shivani','Shivani@123',3,NULL),(4,'Shubham','Shubham@123',1,NULL),(5,'Aniket','Aniket@123',3,NULL),(6,'Deepak','Deepak@123',3,NULL),(8,'Piyusha','piyusha@123',3,NULL),(16,'Hetal','Hetal@123',3,NULL),(18,'Aishwarya','Aishwarya@123',2,NULL),(19,'Riya','Riya@123',2,NULL),(20,'Vyas','Vyas@123',3,NULL),(21,'Samir','Samir@123',2,NULL),(22,'SayaliN','Sayali@123',2,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-20 11:35:11
