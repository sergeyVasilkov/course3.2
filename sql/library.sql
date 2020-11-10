-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`SECTION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SECTION` (
  `SUBJECT` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`SUBJECT`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BOOK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`BOOK` (
  `ISBN` VARCHAR(45) NOT NULL,
  `AUTHOR` VARCHAR(45) NULL,
  `YEAR` INT NULL,
  `TITLE` VARCHAR(45) NULL,
  PRIMARY KEY (`ISBN`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LIBRARY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LIBRARY` (
  `ADDRESS` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ADDRESS`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`B_INSTANCE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`B_INSTANCE` (
  `idB_INSTANCE` INT NOT NULL AUTO_INCREMENT,
  `DATE_GET` DATETIME NULL,
  `DATE_RETURN` DATETIME NULL,
  `AVAILABLE` TINYINT NULL,
  `LIBRARY_ADDRESS` VARCHAR(45) NOT NULL,
  `BOOK_ISBN` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idB_INSTANCE`, `LIBRARY_ADDRESS`, `BOOK_ISBN`),
  INDEX `fk_B_INSTANCE_LIBRARY1_idx` (`LIBRARY_ADDRESS` ASC) VISIBLE,
  INDEX `fk_B_INSTANCE_BOOK1_idx` (`BOOK_ISBN` ASC) VISIBLE,
  CONSTRAINT `fk_B_INSTANCE_LIBRARY1`
    FOREIGN KEY (`LIBRARY_ADDRESS`)
    REFERENCES `mydb`.`LIBRARY` (`ADDRESS`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_B_INSTANCE_BOOK1`
    FOREIGN KEY (`BOOK_ISBN`)
    REFERENCES `mydb`.`BOOK` (`ISBN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`READER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`READER` (
  `CARD_NUM` INT NOT NULL,
  `FULL_NAME` VARCHAR(45) NULL,
  `PHONE_NUM` INT NULL,
  `LIBRARY_ADDRESS` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CARD_NUM`, `LIBRARY_ADDRESS`),
  INDEX `fk_READER_LIBRARY1_idx` (`LIBRARY_ADDRESS` ASC) VISIBLE,
  CONSTRAINT `fk_READER_LIBRARY1`
    FOREIGN KEY (`LIBRARY_ADDRESS`)
    REFERENCES `mydb`.`LIBRARY` (`ADDRESS`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`SECTION_has_BOOK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SECTION_has_BOOK` (
  `SECTION_SUBJECT` VARCHAR(45) NOT NULL,
  `BOOK_ISBN` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`SECTION_SUBJECT`, `BOOK_ISBN`),
  INDEX `fk_SECTION_has_BOOK_SECTION1_idx` (`SECTION_SUBJECT` ASC) VISIBLE,
  INDEX `fk_SECTION_has_BOOK_BOOK1_idx` (`BOOK_ISBN` ASC) VISIBLE,
  CONSTRAINT `fk_SECTION_has_BOOK_SECTION1`
    FOREIGN KEY (`SECTION_SUBJECT`)
    REFERENCES `mydb`.`SECTION` (`SUBJECT`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_SECTION_has_BOOK_BOOK1`
    FOREIGN KEY (`BOOK_ISBN`)
    REFERENCES `mydb`.`BOOK` (`ISBN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
