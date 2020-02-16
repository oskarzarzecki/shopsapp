CREATE DATABASE  IF NOT EXISTS `shopsappdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `shopsappdb`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: shopsappdb
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `application_settings`
--

DROP TABLE IF EXISTS `application_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `application_settings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) NOT NULL,
  `value` text,
  `module_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `application_settings__IDX` (`module_id`),
  CONSTRAINT `application_settings_module_FKv1` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `auction`
--

DROP TABLE IF EXISTS `auction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `auction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `description_short` text,
  `product_id` bigint(20) NOT NULL,
  `price_netto` decimal(10,2) NOT NULL,
  `price_brutto` decimal(10,2) NOT NULL,
  `date_from` date NOT NULL,
  `date_to` date DEFAULT NULL,
  `promoted` int(11) NOT NULL,
  `active` int(11) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `auction_product_FKv1` (`product_id`),
  CONSTRAINT `auction_product_FKv1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `auction_delivery_option`
--

DROP TABLE IF EXISTS `auction_delivery_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `auction_delivery_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `auction_id` bigint(20) NOT NULL,
  `delivery_option_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `auction_delivery_option_auction_FKv1` (`auction_id`),
  KEY `auction_delivery_option_delivery_option_FKv1` (`delivery_option_id`),
  CONSTRAINT `auction_delivery_option_auction_FKv1` FOREIGN KEY (`auction_id`) REFERENCES `auction` (`id`),
  CONSTRAINT `auction_delivery_option_delivery_option_FKv1` FOREIGN KEY (`delivery_option_id`) REFERENCES `delivery_option` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `region` varchar(100) NOT NULL,
  `country_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `city_country_FKv1` (`country_id`),
  CONSTRAINT `city_country_FKv1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `continent` varchar(100) NOT NULL,
  `available` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer_account`
--

DROP TABLE IF EXISTS `customer_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `password_hash` varchar(1000) NOT NULL,
  `date_from` datetime NOT NULL,
  `date_to` datetime DEFAULT NULL,
  `online` int(11) NOT NULL,
  `last_visit` datetime NOT NULL,
  `active` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer_adress`
--

DROP TABLE IF EXISTS `customer_adress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer_adress` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_account_id` bigint(20) NOT NULL,
  `city_id` bigint(20) NOT NULL,
  `phone_number` varchar(100) DEFAULT NULL,
  `street` varchar(100) NOT NULL,
  `postal_code` varchar(100) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_adress_city_FKv1` (`city_id`),
  KEY `customer_adress_customer_account_FKv1` (`customer_account_id`),
  CONSTRAINT `customer_adress_city_FKv1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `customer_adress_customer_account_FKv1` FOREIGN KEY (`customer_account_id`) REFERENCES `customer_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer_basket`
--

DROP TABLE IF EXISTS `customer_basket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer_basket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_account_id` bigint(20) NOT NULL,
  `history` int(11) NOT NULL,
  `sold` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer_basket__IDX` (`customer_account_id`),
  CONSTRAINT `customer_basket_customer_account_FKv1` FOREIGN KEY (`customer_account_id`) REFERENCES `customer_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer_basket_product`
--

DROP TABLE IF EXISTS `customer_basket_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer_basket_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quanity` int(11) NOT NULL,
  `size` decimal(10,4) DEFAULT NULL,
  `auction_id` bigint(20) NOT NULL,
  `customer_basket_id` bigint(20) NOT NULL,
  `date_added` date NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_basket_product_auction_FKv1` (`auction_id`),
  KEY `customer_basket_product_customer_basket_FKv1` (`customer_basket_id`),
  CONSTRAINT `customer_basket_product_auction_FKv1` FOREIGN KEY (`auction_id`) REFERENCES `auction` (`id`),
  CONSTRAINT `customer_basket_product_customer_basket_FKv1` FOREIGN KEY (`customer_basket_id`) REFERENCES `customer_basket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer_favorite_product`
--

DROP TABLE IF EXISTS `customer_favorite_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer_favorite_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_account_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `date_added` date NOT NULL,
  `deleted` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_favorite_product_customer_account_FKv1` (`customer_account_id`),
  KEY `customer_favorite_product_product_FKv1` (`product_id`),
  CONSTRAINT `customer_favorite_product_customer_account_FKv1` FOREIGN KEY (`customer_account_id`) REFERENCES `customer_account` (`id`),
  CONSTRAINT `customer_favorite_product_product_FKv1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer_login`
--

DROP TABLE IF EXISTS `customer_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer_login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_account_id` bigint(20) NOT NULL,
  `date_from` date NOT NULL,
  `date_to` date NOT NULL,
  `ip` varchar(100) NOT NULL,
  `browser` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer_login__IDX` (`customer_account_id`),
  CONSTRAINT `customer_login_customer_account_FKv1` FOREIGN KEY (`customer_account_id`) REFERENCES `customer_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer_order`
--

DROP TABLE IF EXISTS `customer_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_adress_id` bigint(20) NOT NULL,
  `delivery_option_id` bigint(20) NOT NULL,
  `place_id` bigint(20) NOT NULL,
  `customer_basket_id` bigint(20) NOT NULL,
  `paid` int(11) NOT NULL,
  `price_netto` decimal(10,2) NOT NULL,
  `price_brutto` decimal(10,2) NOT NULL,
  `date_ordered` date NOT NULL,
  `date_paid` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer_order__IDX` (`customer_basket_id`),
  KEY `customer_order_customer_adress_FKv1` (`customer_adress_id`),
  KEY `customer_order_delivery_option_FKv1` (`delivery_option_id`),
  KEY `customer_order_place_FKv1` (`place_id`),
  CONSTRAINT `customer_order_customer_adress_FKv1` FOREIGN KEY (`customer_adress_id`) REFERENCES `customer_adress` (`id`),
  CONSTRAINT `customer_order_customer_basket_FKv1` FOREIGN KEY (`customer_basket_id`) REFERENCES `customer_basket` (`id`),
  CONSTRAINT `customer_order_delivery_option_FKv1` FOREIGN KEY (`delivery_option_id`) REFERENCES `delivery_option` (`id`),
  CONSTRAINT `customer_order_place_FKv1` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `delivery_option`
--

DROP TABLE IF EXISTS `delivery_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `delivery_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `payment_option_id` bigint(20) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `time_from` int(11) NOT NULL,
  `time_to` int(11) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `delivery_option_payment_option_FKv1` (`payment_option_id`),
  CONSTRAINT `delivery_option_payment_option_FKv1` FOREIGN KEY (`payment_option_id`) REFERENCES `payment_option` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(100) NOT NULL,
  `identification_number` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `street` varchar(100) NOT NULL,
  `postal_code` varchar(100) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` int(11) NOT NULL,
  `hired` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee_account`
--

DROP TABLE IF EXISTS `employee_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) NOT NULL,
  `login` varchar(100) NOT NULL,
  `password_hash` varchar(1000) NOT NULL,
  `date_from` date NOT NULL,
  `date_to` date DEFAULT NULL,
  `online` int(11) NOT NULL,
  `last_visit` date NOT NULL,
  `active` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_account_employee_FKv1` (`employee_id`),
  CONSTRAINT `employee_account_employee_FKv1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee_account_setting`
--

DROP TABLE IF EXISTS `employee_account_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_account_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` varchar(1000) NOT NULL,
  `employee_account_id` bigint(20) NOT NULL,
  `employee_account_settings_list_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_account_setting_employee_account_FKv1` (`employee_account_id`),
  KEY `employee_account_setting_employee_account_settings_list_FK` (`employee_account_settings_list_id`),
  CONSTRAINT `employee_account_setting_employee_account_FKv1` FOREIGN KEY (`employee_account_id`) REFERENCES `employee_account` (`id`),
  CONSTRAINT `employee_account_setting_employee_account_settings_list_FK` FOREIGN KEY (`employee_account_settings_list_id`) REFERENCES `employee_account_settings_list` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee_account_settings_list`
--

DROP TABLE IF EXISTS `employee_account_settings_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_account_settings_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee_group`
--

DROP TABLE IF EXISTS `employee_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `users_number` int(11) NOT NULL,
  `users_limit` int(11) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee_image`
--

DROP TABLE IF EXISTS `employee_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` text NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `employee_image__IDX` (`employee_id`),
  CONSTRAINT `employee_image_employee_FKv1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee_login`
--

DROP TABLE IF EXISTS `employee_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_login` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_from` date NOT NULL,
  `date_to` date NOT NULL,
  `ip` varchar(100) NOT NULL,
  `browser` varchar(100) NOT NULL,
  `employee_account_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_login_employee_account1_idx` (`employee_account_id`),
  CONSTRAINT `fk_employee_login_employee_account1` FOREIGN KEY (`employee_account_id`) REFERENCES `employee_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee_module_access`
--

DROP TABLE IF EXISTS `employee_module_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_module_access` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_place_access_id` bigint(20) NOT NULL,
  `module_id` bigint(20) NOT NULL,
  `date_from` date NOT NULL,
  `date_to` date DEFAULT NULL,
  `active` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_module_acces_employee_place_acces_FKv1` (`employee_place_access_id`),
  KEY `employee_module_acces_module_FKv1` (`module_id`),
  CONSTRAINT `employee_module_acces_employee_place_acces_FKv1` FOREIGN KEY (`employee_place_access_id`) REFERENCES `employee_place_access` (`id`),
  CONSTRAINT `employee_module_acces_module_FKv1` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee_place_access`
--

DROP TABLE IF EXISTS `employee_place_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_place_access` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_role_id` bigint(20) NOT NULL,
  `place_id` bigint(20) NOT NULL,
  `date_from` date NOT NULL,
  `date_to` date DEFAULT NULL,
  `active` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  `employee_account_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_place_acces_place_FKv1` (`place_id`),
  KEY `fk_employee_place_access_employee_account1_idx` (`employee_account_id`),
  CONSTRAINT `employee_place_acces_place_FKv1` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`),
  CONSTRAINT `fk_employee_place_access_employee_account1` FOREIGN KEY (`employee_account_id`) REFERENCES `employee_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employment_history`
--

DROP TABLE IF EXISTS `employment_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employment_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `place_id` bigint(20) NOT NULL,
  `department_id` bigint(20) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `employment_history__IDX` (`place_id`),
  UNIQUE KEY `employment_history__IDXv1v1` (`department_id`),
  KEY `employment_history_employee_FKv1` (`employee_id`),
  CONSTRAINT `employment_history_department_FKv1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `employment_history_employee_FKv1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `employment_history_place_FKv1` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `group_employee_assign`
--

DROP TABLE IF EXISTS `group_employee_assign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `group_employee_assign` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) NOT NULL,
  `employee_group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `group_employee_assign_employee_FKv1` (`employee_id`),
  KEY `group_employee_assign_employee_group_FKv1` (`employee_group_id`),
  CONSTRAINT `group_employee_assign_employee_FKv1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `group_employee_assign_employee_group_FKv1` FOREIGN KEY (`employee_group_id`) REFERENCES `employee_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `active` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `order_status_date`
--

DROP TABLE IF EXISTS `order_status_date`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_status_date` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_changed` date NOT NULL,
  `order_status_id` bigint(20) NOT NULL,
  `customer_order_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_status_date_customer_order_FKv1` (`customer_order_id`),
  KEY `order_status_date_order_status_FKv1` (`order_status_id`),
  CONSTRAINT `order_status_date_customer_order_FKv1` FOREIGN KEY (`customer_order_id`) REFERENCES `customer_order` (`id`),
  CONSTRAINT `order_status_date_order_status_FKv1` FOREIGN KEY (`order_status_id`) REFERENCES `order_status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `payment_option`
--

DROP TABLE IF EXISTS `payment_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payment_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) NOT NULL,
  `cod` int(11) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `place` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city_id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone_number` varchar(100) DEFAULT NULL,
  `street` varchar(100) NOT NULL,
  `postal_code` varchar(100) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `place_city_FKv1` (`city_id`),
  CONSTRAINT `place_city_FKv1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `place_type`
--

DROP TABLE IF EXISTS `place_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `place_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `place_type_assign`
--

DROP TABLE IF EXISTS `place_type_assign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `place_type_assign` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `place_id` bigint(20) NOT NULL,
  `place_type_id` bigint(20) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `place_type_assign_place_FKv1` (`place_id`),
  KEY `place_type_assign_place_type_FKv1` (`place_type_id`),
  CONSTRAINT `place_type_assign_place_FKv1` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`),
  CONSTRAINT `place_type_assign_place_type_FKv1` FOREIGN KEY (`place_type_id`) REFERENCES `place_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_category_id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text,
  `vat_rate_id` bigint(20) DEFAULT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_product_category_FKv1` (`product_category_id`),
  KEY `product_vat_rate_FKv1` (`vat_rate_id`),
  CONSTRAINT `product_product_category_FKv1` FOREIGN KEY (`product_category_id`) REFERENCES `product_category` (`id`),
  CONSTRAINT `product_vat_rate_FKv1` FOREIGN KEY (`vat_rate_id`) REFERENCES `vat_rate` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_type_id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_category_product_type_FKv1` (`product_type_id`),
  CONSTRAINT `product_category_product_type_FKv1` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_category_image`
--

DROP TABLE IF EXISTS `product_category_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_category_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` text NOT NULL,
  `product_category_id` bigint(20) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_category_image_product_category_FKv1` (`product_category_id`),
  CONSTRAINT `product_category_image_product_category_FKv1` FOREIGN KEY (`product_category_id`) REFERENCES `product_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_color`
--

DROP TABLE IF EXISTS `product_color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_color` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` text NOT NULL,
  `available` int(11) NOT NULL,
  `product_variant_id` bigint(20) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_image_product_variant_FKv1` (`product_variant_id`),
  CONSTRAINT `product_image_product_variant_FKv1` FOREIGN KEY (`product_variant_id`) REFERENCES `product_variant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_property`
--

DROP TABLE IF EXISTS `product_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available` int(11) NOT NULL,
  `show_in_category_filters` int(11) NOT NULL,
  `filter_input_manually` int(11) NOT NULL,
  `unit` varchar(100) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  `product_property_name_id` bigint(20) NOT NULL,
  `product_category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_property_product_property_name1_idx` (`product_property_name_id`),
  KEY `fk_product_property_product_category1_idx` (`product_category_id`),
  CONSTRAINT `fk_product_property_product_category1` FOREIGN KEY (`product_category_id`) REFERENCES `product_category` (`id`),
  CONSTRAINT `fk_product_property_product_property_name1` FOREIGN KEY (`product_property_name_id`) REFERENCES `product_property_name` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_property_image`
--

DROP TABLE IF EXISTS `product_property_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_property_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` text NOT NULL,
  `property_id` bigint(20) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_property_image_property_FKv1` (`property_id`),
  CONSTRAINT `product_property_image_property_FKv1` FOREIGN KEY (`property_id`) REFERENCES `product_property` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_property_name`
--

DROP TABLE IF EXISTS `product_property_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_property_name` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_property_value`
--

DROP TABLE IF EXISTS `product_property_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_property_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `property_id` bigint(20) NOT NULL,
  `value` decimal(10,6) NOT NULL,
  `description` text,
  `available` int(11) NOT NULL,
  `show_in_category_filters` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `property_value_product_FKv1` (`product_id`),
  KEY `property_value_property_FKv1` (`property_id`),
  CONSTRAINT `property_value_product_FKv1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `property_value_property_FKv1` FOREIGN KEY (`property_id`) REFERENCES `product_property` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_type`
--

DROP TABLE IF EXISTS `product_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_type_image`
--

DROP TABLE IF EXISTS `product_type_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_type_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` text NOT NULL,
  `product_type_id` bigint(20) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_type_image_product_type_FKv1` (`product_type_id`),
  CONSTRAINT `product_type_image_product_type_FKv1` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `product_variant`
--

DROP TABLE IF EXISTS `product_variant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_variant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `product_color_id` bigint(20) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_variant_product_FKv1` (`product_id`),
  KEY `product_variant_product_color_FKv1` (`product_color_id`),
  CONSTRAINT `product_variant_product_FKv1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `product_variant_product_color_FKv1` FOREIGN KEY (`product_color_id`) REFERENCES `product_color` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sold_product`
--

DROP TABLE IF EXISTS `sold_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sold_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_order_id` bigint(20) NOT NULL,
  `auction_id` bigint(20) NOT NULL,
  `quanity` int(11) NOT NULL,
  `size` decimal(10,4) DEFAULT NULL,
  `price_netto` decimal(10,2) NOT NULL,
  `price_brutto` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sold_product_auction_FKv1` (`auction_id`),
  KEY `sold_product_customer_order_FKv1` (`customer_order_id`),
  CONSTRAINT `sold_product_auction_FKv1` FOREIGN KEY (`auction_id`) REFERENCES `auction` (`id`),
  CONSTRAINT `sold_product_customer_order_FKv1` FOREIGN KEY (`customer_order_id`) REFERENCES `customer_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stored_product`
--

DROP TABLE IF EXISTS `stored_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stored_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `place_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `quanity` int(11) NOT NULL,
  `size` decimal(10,4) DEFAULT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stored_product_place_FKv1` (`place_id`),
  KEY `stored_product_product_FKv1` (`product_id`),
  CONSTRAINT `stored_product_place_FKv1` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`),
  CONSTRAINT `stored_product_product_FKv1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vat_rate`
--

DROP TABLE IF EXISTS `vat_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vat_rate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `value` decimal(3,2) NOT NULL,
  `available` int(11) NOT NULL,
  `deleted` int(11) NOT NULL,
  `date_deleted` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-16 21:57:17
