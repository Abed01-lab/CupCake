-- MySQL Workbench Forward Engineering
-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cupcakeproject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cupcakeproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cupcakeproject` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cupcakeproject` ;

-- -----------------------------------------------------
-- Table `cupcakeproject`.`bottom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakeproject`.`bottom` (
  `bottomId` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `price` INT(11) NOT NULL,
  PRIMARY KEY (`bottomId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcakeproject`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakeproject`.`customer` (
  `customerId` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `balance` INT(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`customerId`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcakeproject`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakeproject`.`orders` (
  `orderId` INT(11) NOT NULL,
  `customerId` INT(11) NOT NULL,
  PRIMARY KEY (`orderId`),
  INDEX `customerId` (`customerId` ASC) VISIBLE,
  CONSTRAINT `orders_ibfk_1`
    FOREIGN KEY (`customerId`)
    REFERENCES `cupcakeproject`.`customer` (`customerId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcakeproject`.`topping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakeproject`.`topping` (
  `toppingId` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `price` INT(11) NOT NULL,
  PRIMARY KEY (`toppingId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `cupcakeproject`.`ordersline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cupcakeproject`.`ordersline` (
  `orderlineId` INT(11) NOT NULL,
  `orderId` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL,
  `sum` INT(11) NOT NULL,
  `toppingId` INT(11) NOT NULL,
  `bottomId` INT(11) NOT NULL,
  PRIMARY KEY (`orderlineId`),
  INDEX `orderId` (`orderId` ASC) VISIBLE,
  INDEX `toppingId` (`toppingId` ASC) VISIBLE,
  INDEX `bottomId` (`bottomId` ASC) VISIBLE,
  CONSTRAINT `ordersline_ibfk_1`
    FOREIGN KEY (`orderId`)
    REFERENCES `cupcakeproject`.`orders` (`orderId`),
  CONSTRAINT `ordersline_ibfk_2`
    FOREIGN KEY (`toppingId`)
    REFERENCES `cupcakeproject`.`topping` (`toppingId`),
  CONSTRAINT `ordersline_ibfk_3`
    FOREIGN KEY (`bottomId`)
    REFERENCES `cupcakeproject`.`bottom` (`bottomId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
