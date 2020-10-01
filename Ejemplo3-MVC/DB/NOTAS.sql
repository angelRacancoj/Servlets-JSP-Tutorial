-- -----------------------------------------------------
-- Schema NOTAS
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `NOTAS` ;

-- -----------------------------------------------------
-- Schema NOTAS
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `NOTAS` DEFAULT CHARACTER SET utf8 ;
USE `NOTAS` ;

-- -----------------------------------------------------
-- Table `NOTAS`.`USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NOTAS`.`USUARIO` ;

CREATE TABLE IF NOT EXISTS `NOTAS`.`USUARIO` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `profesion` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`idUsuario`));


-- -----------------------------------------------------
-- Table `NOTAS`.`NOTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `NOTAS`.`NOTA` ;

CREATE TABLE IF NOT EXISTS `NOTAS`.`NOTA` (
  `idNota` INT NOT NULL AUTO_INCREMENT,
  `informacion` VARCHAR(100) NOT NULL,
  `fecha` DATE NOT NULL,
  `USUARIO_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idNota`),
    FOREIGN KEY (`USUARIO_idUsuario`)
    REFERENCES `NOTAS`.`USUARIO` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ---------------------------------------------------
-- Data Input
-- ---------------------------------------------------

-- ---------------------------------------------------
-- Users
-- ---------------------------------------------------

-- ---------------------------------------------------
-- Notas
-- ---------------------------------------------------
