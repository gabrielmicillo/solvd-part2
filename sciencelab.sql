CREATE SCHEMA IF NOT EXISTS `gabriel_micillo` DEFAULT CHARACTER SET UTF8MB4 ;
USE `gabriel_micillo` ;

CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `exp_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Experiment_Types` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_name` VARCHAR(45) NOT NULL,
  `cost_per_hour` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Financiations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fin_origin` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Labs_Size` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lab_size` VARCHAR(45) NOT NULL,
  `square_meters` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Cities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Laboratories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `exp_capacity` INT NOT NULL,
  `labs_size_id` INT NOT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`, `labs_size_id`, `city_id`),
  CONSTRAINT `fk_Laboratories_Labs_Size1`
    FOREIGN KEY (`labs_size_id`)
    REFERENCES `gabriel_micillo`.`Labs_Size` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Laboratories_Cities1`
    FOREIGN KEY (`city_id`)
    REFERENCES `gabriel_micillo`.`Cities` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Experiments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `test_tube_usage` INT NOT NULL,
  `status_id` INT NOT NULL,
  `experiment_types_id` INT NOT NULL,
  `financiations_id` INT NOT NULL,
  `lab_id` INT NOT NULL,
  PRIMARY KEY (`id`, `status_id`, `experiment_types_id`, `financiations_id`, `lab_id`),
  CONSTRAINT `fk_Experiments_Status`
    FOREIGN KEY (`status_id`)
    REFERENCES `gabriel_micillo`.`Status` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Experiments_Experiment_Types1`
    FOREIGN KEY (`experiment_types_id`)
    REFERENCES `gabriel_micillo`.`Experiment_Types` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Experiments_Financiations1`
    FOREIGN KEY (`financiations_id`)
    REFERENCES `gabriel_micillo`.`Financiations` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Experiments_Laboratories1`
    FOREIGN KEY (`lab_id`)
    REFERENCES `gabriel_micillo`.`Laboratories` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Clients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `hours_required` INT NOT NULL,
  `experiment_id` INT NOT NULL,
  `client_id` INT NOT NULL,
  PRIMARY KEY (`id`, `experiment_id`, `client_id`),
    FOREIGN KEY (`experiment_id`)
    REFERENCES `gabriel_micillo`.`Experiments` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (`client_id`)
    REFERENCES `gabriel_micillo`.`Clients` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Phone_Numbers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phone_number` INT NOT NULL,
  `lab_id` INT NOT NULL,
  PRIMARY KEY (`id`, `lab_id`),
  CONSTRAINT `fk_Phone_Numbers_Laboratories1`
    FOREIGN KEY (`lab_id`)
    REFERENCES `gabriel_micillo`.`Laboratories` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Positions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `position_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Employees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `position_id` INT NOT NULL,
  `experiment_id` INT NOT NULL,
  PRIMARY KEY (`id`, `position_id`, `experiment_id`),
  CONSTRAINT `fk_Employees_Positions1`
    FOREIGN KEY (`position_id`)
    REFERENCES `gabriel_micillo`.`Positions` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Employees_Experiments1`
    FOREIGN KEY (`experiment_id`)
    REFERENCES `gabriel_micillo`.`Experiments` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Weekly_Shifts` (
  `lab_id` INT NOT NULL,
  `employee_id` INT NOT NULL,
  `weekly_shifts` INT NOT NULL,
  PRIMARY KEY (`lab_id`, `employee_id`),
  CONSTRAINT `fk_Laboratories_has_Employees_Laboratories1`
    FOREIGN KEY (`lab_id`)
    REFERENCES `gabriel_micillo`.`Laboratories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Laboratories_has_Employees_Employees1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `gabriel_micillo`.`Employees` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

-- Employee´s competence is a number on a scale between 0 and 9 --
CREATE TABLE IF NOT EXISTS `gabriel_micillo`.`Employees_Competences` (
  `experiment_types_id` INT NOT NULL,
  `employee_id` INT NOT NULL,
  `employee_competence` BIGINT(1) NOT NULL,
  PRIMARY KEY (`experiment_types_id`, `employee_id`),
    FOREIGN KEY (`experiment_types_id`)
    REFERENCES `gabriel_micillo`.`Experiment_Types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`employee_id`)
    REFERENCES `gabriel_micillo`.`Employees` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;