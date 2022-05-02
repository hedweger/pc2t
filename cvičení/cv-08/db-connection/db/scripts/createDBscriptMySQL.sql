-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `id_user` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `age` VARCHAR(45) NULL,
  `salary` VARCHAR(45) NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`role` (
  `id_role` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user_has_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_has_role` (
  `user_id_user` INT NOT NULL,
  `role_id_role` INT NOT NULL,
  PRIMARY KEY (`user_id_user`, `role_id_role`),
  INDEX `fk_user_has_role_role1_idx` (`role_id_role` ASC),
  INDEX `fk_user_has_role_user_idx` (`user_id_user` ASC),
  CONSTRAINT `fk_user_has_role_user`
    FOREIGN KEY (`user_id_user`)
    REFERENCES `mydb`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_role_role1`
    FOREIGN KEY (`role_id_role`)
    REFERENCES `mydb`.`role` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
