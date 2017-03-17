-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: ces
-- ------------------------------------------------------
-- Server version	5.1.72-community

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
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,1,'index.do','主页','主页','ec-pencil2',NULL,1,'T'),(2,2,'#','学院管理','菜单','ec-pencil2',NULL,1,'T'),(3,3,'instituteInfo.do','信息概览','信息概览','ec-pencil2',2,1,'T'),(4,4,'instituteList.do','学院列表','学员列表','ec-pencil2',2,1,'T'),(5,5,'#','专业管理','专业管理','ec-pencil2',NULL,1,'T'),(6,6,'majorInfo.do','信息概览','信息概览','ec-pencil2',5,1,'T'),(7,7,'majorList.do','专业列表','专业列表','ec-pencil2',5,1,'T'),(8,8,'#','教师管理','教师管理','ec-pencil2',NULL,1,'T'),(9,9,'teacherInfo.do','信息概览','信息概览','ec-pencil2',8,1,'T'),(10,10,'teacherList.do','教师列表','教师列表','ec-pencil2',8,1,'T'),(11,11,'#','学生管理','学生管理','im-paragraph-justify',NULL,1,'T'),(12,12,'studentInfo.do','信息概览','信息概览','im-paragraph-justify',11,1,'T'),(13,13,'studentList.do','学生列表','学生列表','im-paragraph-justify',11,1,'T'),(14,14,'#','消息管理','消息管理','ec-mail',NULL,1,'T'),(15,15,'inbox.do','收件箱','收件箱','ec-archive',14,1,'T'),(16,16,'outbox.do','发件箱','发件箱','br-eye',14,1,'T'),(17,17,'writeMessage.do','写邮件','写邮件','ec-pencil2',14,1,'T'),(18,18,'#','资源管理','资源管理','ec-mail',NULL,1,'T'),(19,19,'resourceInfo.do','资源概述','资源概述','ec-archive',18,1,'T'),(20,20,'imageManage.do','图片管理','图片管理','br-eye',18,1,'T'),(21,21,'#','系统管理','系统管理','ec-mail',NULL,1,'T');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-17  9:49:41
