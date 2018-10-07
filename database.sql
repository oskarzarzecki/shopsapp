-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema shopsappdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema shopsappdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shopsappdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `shopsappdb` ;

-- -----------------------------------------------------
-- Table `shopsappdb`.`module`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`module` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `active` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`application_settings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`application_settings` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(1000) NOT NULL,
  `value` TEXT NULL DEFAULT NULL,
  `module_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `application_settings__IDX` (`module_id` ASC),
  CONSTRAINT `application_settings_module_FKv1`
    FOREIGN KEY (`module_id`)
    REFERENCES `shopsappdb`.`module` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product_type` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product_category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `product_type_id` BIGINT(20) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `product_category_product_type_FKv1` (`product_type_id` ASC),
  CONSTRAINT `product_category_product_type_FKv1`
    FOREIGN KEY (`product_type_id`)
    REFERENCES `shopsappdb`.`product_type` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`vat_rate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`vat_rate` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `value` DECIMAL(3,2) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `product_category_id` BIGINT(20) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `vat_rate_id` BIGINT(20) NULL DEFAULT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `product_product_category_FKv1` (`product_category_id` ASC),
  INDEX `product_vat_rate_FKv1` (`vat_rate_id` ASC),
  CONSTRAINT `product_product_category_FKv1`
    FOREIGN KEY (`product_category_id`)
    REFERENCES `shopsappdb`.`product_category` (`id`),
  CONSTRAINT `product_vat_rate_FKv1`
    FOREIGN KEY (`vat_rate_id`)
    REFERENCES `shopsappdb`.`vat_rate` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`auction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`auction` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `product_id` BIGINT(20) NOT NULL,
  `price_netto` DECIMAL(10,2) NOT NULL,
  `price_brutto` DECIMAL(10,2) NOT NULL,
  `date_from` DATE NOT NULL,
  `date_to` DATE NULL DEFAULT NULL,
  `promoted` INT(11) NOT NULL,
  `active` INT(11) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `auction_product_FKv1` (`product_id` ASC),
  CONSTRAINT `auction_product_FKv1`
    FOREIGN KEY (`product_id`)
    REFERENCES `shopsappdb`.`product` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`payment_option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`payment_option` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(1000) NOT NULL,
  `cod` INT(11) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`delivery_option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`delivery_option` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `payment_option_id` BIGINT(20) NOT NULL,
  `name` VARCHAR(1000) NOT NULL,
  `time_from` INT(11) NOT NULL,
  `time_to` INT(11) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `delivery_option_payment_option_FKv1` (`payment_option_id` ASC),
  CONSTRAINT `delivery_option_payment_option_FKv1`
    FOREIGN KEY (`payment_option_id`)
    REFERENCES `shopsappdb`.`payment_option` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`auction_delivery_option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`auction_delivery_option` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `auction_id` BIGINT(20) NOT NULL,
  `delivery_option_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `auction_delivery_option_auction_FKv1` (`auction_id` ASC),
  INDEX `auction_delivery_option_delivery_option_FKv1` (`delivery_option_id` ASC),
  CONSTRAINT `auction_delivery_option_auction_FKv1`
    FOREIGN KEY (`auction_id`)
    REFERENCES `shopsappdb`.`auction` (`id`),
  CONSTRAINT `auction_delivery_option_delivery_option_FKv1`
    FOREIGN KEY (`delivery_option_id`)
    REFERENCES `shopsappdb`.`delivery_option` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`country` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `continent` VARCHAR(100) NOT NULL,
  `available` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`city` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `region` VARCHAR(100) NOT NULL,
  `country_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `city_country_FKv1` (`country_id` ASC),
  CONSTRAINT `city_country_FKv1`
    FOREIGN KEY (`country_id`)
    REFERENCES `shopsappdb`.`country` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`customer_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`customer_account` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NULL DEFAULT NULL,
  `password_hash` VARCHAR(1000) NOT NULL,
  `date_from` DATE NOT NULL,
  `date_to` DATE NULL DEFAULT NULL,
  `online` INT(11) NOT NULL,
  `last_visit` DATE NOT NULL,
  `active` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`customer_adress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`customer_adress` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `customer_account_id` BIGINT(20) NOT NULL,
  `city_id` BIGINT(20) NOT NULL,
  `phone_number` VARCHAR(100) NULL DEFAULT NULL,
  `street` VARCHAR(100) NOT NULL,
  `postal_code` VARCHAR(100) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `customer_adress_city_FKv1` (`city_id` ASC),
  INDEX `customer_adress_customer_account_FKv1` (`customer_account_id` ASC),
  CONSTRAINT `customer_adress_city_FKv1`
    FOREIGN KEY (`city_id`)
    REFERENCES `shopsappdb`.`city` (`id`),
  CONSTRAINT `customer_adress_customer_account_FKv1`
    FOREIGN KEY (`customer_account_id`)
    REFERENCES `shopsappdb`.`customer_account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`customer_basket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`customer_basket` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `customer_account_id` BIGINT(20) NOT NULL,
  `history` INT(11) NOT NULL,
  `sold` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `customer_basket__IDX` (`customer_account_id` ASC),
  CONSTRAINT `customer_basket_customer_account_FKv1`
    FOREIGN KEY (`customer_account_id`)
    REFERENCES `shopsappdb`.`customer_account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`customer_basket_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`customer_basket_product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `quanity` INT(11) NOT NULL,
  `size` DECIMAL(10,4) NULL DEFAULT NULL,
  `auction_id` BIGINT(20) NOT NULL,
  `customer_basket_id` BIGINT(20) NOT NULL,
  `date_added` DATE NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `customer_basket_product_auction_FKv1` (`auction_id` ASC),
  INDEX `customer_basket_product_customer_basket_FKv1` (`customer_basket_id` ASC),
  CONSTRAINT `customer_basket_product_auction_FKv1`
    FOREIGN KEY (`auction_id`)
    REFERENCES `shopsappdb`.`auction` (`id`),
  CONSTRAINT `customer_basket_product_customer_basket_FKv1`
    FOREIGN KEY (`customer_basket_id`)
    REFERENCES `shopsappdb`.`customer_basket` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`customer_favorite_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`customer_favorite_product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `customer_account_id` BIGINT(20) NOT NULL,
  `product_id` BIGINT(20) NOT NULL,
  `date_added` DATE NOT NULL,
  `deleted` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `customer_favorite_product_customer_account_FKv1` (`customer_account_id` ASC),
  INDEX `customer_favorite_product_product_FKv1` (`product_id` ASC),
  CONSTRAINT `customer_favorite_product_customer_account_FKv1`
    FOREIGN KEY (`customer_account_id`)
    REFERENCES `shopsappdb`.`customer_account` (`id`),
  CONSTRAINT `customer_favorite_product_product_FKv1`
    FOREIGN KEY (`product_id`)
    REFERENCES `shopsappdb`.`product` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`customer_login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`customer_login` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `customer_account_id` BIGINT(20) NOT NULL,
  `date_from` DATE NOT NULL,
  `date_to` DATE NOT NULL,
  `ip` VARCHAR(100) NOT NULL,
  `browser` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `customer_login__IDX` (`customer_account_id` ASC),
  CONSTRAINT `customer_login_customer_account_FKv1`
    FOREIGN KEY (`customer_account_id`)
    REFERENCES `shopsappdb`.`customer_account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`place` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `city_id` BIGINT(20) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `phone_number` VARCHAR(100) NULL DEFAULT NULL,
  `street` VARCHAR(100) NOT NULL,
  `postal_code` VARCHAR(100) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `place_city_FKv1` (`city_id` ASC),
  CONSTRAINT `place_city_FKv1`
    FOREIGN KEY (`city_id`)
    REFERENCES `shopsappdb`.`city` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`customer_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`customer_order` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `customer_adress_id` BIGINT(20) NOT NULL,
  `delivery_option_id` BIGINT(20) NOT NULL,
  `place_id` BIGINT(20) NOT NULL,
  `customer_basket_id` BIGINT(20) NOT NULL,
  `paid` INT(11) NOT NULL,
  `price_netto` DECIMAL(10,2) NOT NULL,
  `price_brutto` DECIMAL(10,2) NOT NULL,
  `date_ordered` DATE NOT NULL,
  `date_paid` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `customer_order__IDX` (`customer_basket_id` ASC),
  INDEX `customer_order_customer_adress_FKv1` (`customer_adress_id` ASC),
  INDEX `customer_order_delivery_option_FKv1` (`delivery_option_id` ASC),
  INDEX `customer_order_place_FKv1` (`place_id` ASC),
  CONSTRAINT `customer_order_customer_adress_FKv1`
    FOREIGN KEY (`customer_adress_id`)
    REFERENCES `shopsappdb`.`customer_adress` (`id`),
  CONSTRAINT `customer_order_customer_basket_FKv1`
    FOREIGN KEY (`customer_basket_id`)
    REFERENCES `shopsappdb`.`customer_basket` (`id`),
  CONSTRAINT `customer_order_delivery_option_FKv1`
    FOREIGN KEY (`delivery_option_id`)
    REFERENCES `shopsappdb`.`delivery_option` (`id`),
  CONSTRAINT `customer_order_place_FKv1`
    FOREIGN KEY (`place_id`)
    REFERENCES `shopsappdb`.`place` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`department` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`employee` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `surname` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `phone_number` VARCHAR(100) NOT NULL,
  `identification_number` VARCHAR(100) NOT NULL,
  `city` VARCHAR(100) NOT NULL,
  `street` VARCHAR(100) NOT NULL,
  `postal_code` VARCHAR(100) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `gender` INT(11) NOT NULL,
  `hired` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`employee_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`employee_account` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `employee_id` BIGINT(20) NOT NULL,
  `login` VARCHAR(100) NOT NULL,
  `password_hash` VARCHAR(1000) NOT NULL,
  `date_from` DATE NOT NULL,
  `date_to` DATE NULL DEFAULT NULL,
  `online` INT(11) NOT NULL,
  `last_visit` DATE NOT NULL,
  `active` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `employee_account_employee_FKv1` (`employee_id` ASC),
  CONSTRAINT `employee_account_employee_FKv1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `shopsappdb`.`employee` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`employee_account_settings_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`employee_account_settings_list` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`employee_account_setting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`employee_account_setting` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(1000) NOT NULL,
  `employee_account_id` BIGINT(20) NOT NULL,
  `employee_account_settings_list_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `employee_account_setting_employee_account_FKv1` (`employee_account_id` ASC),
  INDEX `employee_account_setting_employee_account_settings_list_FK` (`employee_account_settings_list_id` ASC),
  CONSTRAINT `employee_account_setting_employee_account_FKv1`
    FOREIGN KEY (`employee_account_id`)
    REFERENCES `shopsappdb`.`employee_account` (`id`),
  CONSTRAINT `employee_account_setting_employee_account_settings_list_FK`
    FOREIGN KEY (`employee_account_settings_list_id`)
    REFERENCES `shopsappdb`.`employee_account_settings_list` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`employee_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`employee_group` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `users_number` INT(11) NOT NULL,
  `users_limit` INT(11) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`employee_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`employee_image` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `path` TEXT NOT NULL,
  `employee_id` BIGINT(20) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `employee_image__IDX` (`employee_id` ASC),
  CONSTRAINT `employee_image_employee_FKv1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `shopsappdb`.`employee` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`employee_login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`employee_login` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `date_from` DATE NOT NULL,
  `date_to` DATE NOT NULL,
  `ip` VARCHAR(100) NOT NULL,
  `browser` VARCHAR(100) NOT NULL,
  `employee_account_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_employee_login_employee_account1_idx` (`employee_account_id` ASC),
  CONSTRAINT `fk_employee_login_employee_account1`
    FOREIGN KEY (`employee_account_id`)
    REFERENCES `shopsappdb`.`employee_account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`employee_place_access`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`employee_place_access` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `employee_role_id` BIGINT(20) NOT NULL,
  `place_id` BIGINT(20) NOT NULL,
  `date_from` DATE NOT NULL,
  `date_to` DATE NULL DEFAULT NULL,
  `active` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  `employee_account_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `employee_place_acces_place_FKv1` (`place_id` ASC),
  INDEX `fk_employee_place_access_employee_account1_idx` (`employee_account_id` ASC),
  CONSTRAINT `employee_place_acces_place_FKv1`
    FOREIGN KEY (`place_id`)
    REFERENCES `shopsappdb`.`place` (`id`),
  CONSTRAINT `fk_employee_place_access_employee_account1`
    FOREIGN KEY (`employee_account_id`)
    REFERENCES `shopsappdb`.`employee_account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`employee_module_access`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`employee_module_access` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `employee_place_access_id` BIGINT(20) NOT NULL,
  `module_id` BIGINT(20) NOT NULL,
  `date_from` DATE NOT NULL,
  `date_to` DATE NULL DEFAULT NULL,
  `active` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `employee_module_acces_employee_place_acces_FKv1` (`employee_place_access_id` ASC),
  INDEX `employee_module_acces_module_FKv1` (`module_id` ASC),
  CONSTRAINT `employee_module_acces_employee_place_acces_FKv1`
    FOREIGN KEY (`employee_place_access_id`)
    REFERENCES `shopsappdb`.`employee_place_access` (`id`),
  CONSTRAINT `employee_module_acces_module_FKv1`
    FOREIGN KEY (`module_id`)
    REFERENCES `shopsappdb`.`module` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`employment_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`employment_history` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `place_id` BIGINT(20) NOT NULL,
  `department_id` BIGINT(20) NOT NULL,
  `employee_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `employment_history__IDX` (`place_id` ASC),
  UNIQUE INDEX `employment_history__IDXv1v1` (`department_id` ASC),
  INDEX `employment_history_employee_FKv1` (`employee_id` ASC),
  CONSTRAINT `employment_history_department_FKv1`
    FOREIGN KEY (`department_id`)
    REFERENCES `shopsappdb`.`department` (`id`),
  CONSTRAINT `employment_history_employee_FKv1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `shopsappdb`.`employee` (`id`),
  CONSTRAINT `employment_history_place_FKv1`
    FOREIGN KEY (`place_id`)
    REFERENCES `shopsappdb`.`place` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`group_employee_assign`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`group_employee_assign` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `employee_id` BIGINT(20) NOT NULL,
  `employee_group_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `group_employee_assign_employee_FKv1` (`employee_id` ASC),
  INDEX `group_employee_assign_employee_group_FKv1` (`employee_group_id` ASC),
  CONSTRAINT `group_employee_assign_employee_FKv1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `shopsappdb`.`employee` (`id`),
  CONSTRAINT `group_employee_assign_employee_group_FKv1`
    FOREIGN KEY (`employee_group_id`)
    REFERENCES `shopsappdb`.`employee_group` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`order_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`order_status` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(1000) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`order_status_date`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`order_status_date` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `date_changed` DATE NOT NULL,
  `order_status_id` BIGINT(20) NOT NULL,
  `customer_order_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `order_status_date_customer_order_FKv1` (`customer_order_id` ASC),
  INDEX `order_status_date_order_status_FKv1` (`order_status_id` ASC),
  CONSTRAINT `order_status_date_customer_order_FKv1`
    FOREIGN KEY (`customer_order_id`)
    REFERENCES `shopsappdb`.`customer_order` (`id`),
  CONSTRAINT `order_status_date_order_status_FKv1`
    FOREIGN KEY (`order_status_id`)
    REFERENCES `shopsappdb`.`order_status` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`place_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`place_type` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`place_type_assign`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`place_type_assign` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `place_id` BIGINT(20) NOT NULL,
  `place_type_id` BIGINT(20) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `place_type_assign_place_FKv1` (`place_id` ASC),
  INDEX `place_type_assign_place_type_FKv1` (`place_type_id` ASC),
  CONSTRAINT `place_type_assign_place_FKv1`
    FOREIGN KEY (`place_id`)
    REFERENCES `shopsappdb`.`place` (`id`),
  CONSTRAINT `place_type_assign_place_type_FKv1`
    FOREIGN KEY (`place_type_id`)
    REFERENCES `shopsappdb`.`place_type` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product_category_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product_category_image` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `path` TEXT NOT NULL,
  `product_category_id` BIGINT(20) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `product_category_image_product_category_FKv1` (`product_category_id` ASC),
  CONSTRAINT `product_category_image_product_category_FKv1`
    FOREIGN KEY (`product_category_id`)
    REFERENCES `shopsappdb`.`product_category` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product_color`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product_color` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product_variant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product_variant` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `product_id` BIGINT(20) NOT NULL,
  `product_color_id` BIGINT(20) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `product_variant_product_FKv1` (`product_id` ASC),
  INDEX `product_variant_product_color_FKv1` (`product_color_id` ASC),
  CONSTRAINT `product_variant_product_FKv1`
    FOREIGN KEY (`product_id`)
    REFERENCES `shopsappdb`.`product` (`id`),
  CONSTRAINT `product_variant_product_color_FKv1`
    FOREIGN KEY (`product_color_id`)
    REFERENCES `shopsappdb`.`product_color` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product_image` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `path` TEXT NOT NULL,
  `available` INT(11) NOT NULL,
  `product_variant_id` BIGINT(20) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `product_image_product_variant_FKv1` (`product_variant_id` ASC),
  CONSTRAINT `product_image_product_variant_FKv1`
    FOREIGN KEY (`product_variant_id`)
    REFERENCES `shopsappdb`.`product_variant` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product_type_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product_type_image` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `path` TEXT NOT NULL,
  `product_type_id` BIGINT(20) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `product_type_image_product_type_FKv1` (`product_type_id` ASC),
  CONSTRAINT `product_type_image_product_type_FKv1`
    FOREIGN KEY (`product_type_id`)
    REFERENCES `shopsappdb`.`product_type` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product_property_name`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product_property_name` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(1000) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product_property`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product_property` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  `product_property_name_id` BIGINT(20) NOT NULL,
  `product_category_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_property_product_property_name1_idx` (`product_property_name_id` ASC),
  INDEX `fk_product_property_product_category1_idx` (`product_category_id` ASC),
  CONSTRAINT `fk_product_property_product_property_name1`
    FOREIGN KEY (`product_property_name_id`)
    REFERENCES `shopsappdb`.`product_property_name` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_property_product_category1`
    FOREIGN KEY (`product_category_id`)
    REFERENCES `shopsappdb`.`product_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product_property_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product_property_image` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `path` TEXT NOT NULL,
  `property_id` BIGINT(20) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `product_property_image_property_FKv1` (`property_id` ASC),
  CONSTRAINT `product_property_image_property_FKv1`
    FOREIGN KEY (`property_id`)
    REFERENCES `shopsappdb`.`product_property` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product_property_name`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product_property_name` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(1000) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`product_property_value`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`product_property_value` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `product_id` BIGINT(20) NOT NULL,
  `property_id` BIGINT(20) NOT NULL,
  `value` VARCHAR(1000) NOT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `property_value_product_FKv1` (`product_id` ASC),
  INDEX `property_value_property_FKv1` (`property_id` ASC),
  CONSTRAINT `property_value_product_FKv1`
    FOREIGN KEY (`product_id`)
    REFERENCES `shopsappdb`.`product` (`id`),
  CONSTRAINT `property_value_property_FKv1`
    FOREIGN KEY (`property_id`)
    REFERENCES `shopsappdb`.`product_property` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`sold_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`sold_product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `customer_order_id` BIGINT(20) NOT NULL,
  `auction_id` BIGINT(20) NOT NULL,
  `quanity` INT(11) NOT NULL,
  `size` DECIMAL(10,4) NULL DEFAULT NULL,
  `price_netto` DECIMAL(10,2) NOT NULL,
  `price_brutto` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `sold_product_auction_FKv1` (`auction_id` ASC),
  INDEX `sold_product_customer_order_FKv1` (`customer_order_id` ASC),
  CONSTRAINT `sold_product_auction_FKv1`
    FOREIGN KEY (`auction_id`)
    REFERENCES `shopsappdb`.`auction` (`id`),
  CONSTRAINT `sold_product_customer_order_FKv1`
    FOREIGN KEY (`customer_order_id`)
    REFERENCES `shopsappdb`.`customer_order` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopsappdb`.`stored_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopsappdb`.`stored_product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `place_id` BIGINT(20) NOT NULL,
  `product_id` BIGINT(20) NOT NULL,
  `quanity` INT(11) NOT NULL,
  `size` DECIMAL(10,4) NULL DEFAULT NULL,
  `available` INT(11) NOT NULL,
  `deleted` INT(11) NOT NULL,
  `date_deleted` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `stored_product_place_FKv1` (`place_id` ASC),
  INDEX `stored_product_product_FKv1` (`product_id` ASC),
  CONSTRAINT `stored_product_place_FKv1`
    FOREIGN KEY (`place_id`)
    REFERENCES `shopsappdb`.`place` (`id`),
  CONSTRAINT `stored_product_product_FKv1`
    FOREIGN KEY (`product_id`)
    REFERENCES `shopsappdb`.`product` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
