-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

CREATE DATABASE IF NOT EXISTS `cupcake` ;

USE `cupcake`;

DROP TABLE IF EXISTS `useres`;
CREATE TABLE `useres` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45)  NOT NULL,
  `kode` VARCHAR(45) NOT NULL,
  `rolle` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
  );

DROP TABLE IF EXISTS `ordre`;
CREATE TABLE `ordre` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `kundeid` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`kundeid`) REFERENCES `kunder`(`id`)
  );

DROP TABLE IF EXISTS `ordrelinje`;
CREATE TABLE `ordrelinje` (
  `ordreid` INT NOT NULL,
  `topTopping` VARCHAR(45) NOT NULL,
  `bundTopping` VARCHAR(45) NOT NULL,
  `antal` VARCHAR (45) NOT NULL,
  `pris` INT NOT NULL,
  PRIMARY KEY (`ordreid`),
  FOREIGN KEY (`ordreid`) REFERENCES `ordre`(`id`)
  );


