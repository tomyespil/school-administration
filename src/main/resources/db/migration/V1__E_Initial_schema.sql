CREATE DATABASE IF NOT EXISTS `school` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `school`;

CREATE TABLE IF NOT EXISTS `person` (
  `id_person` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` bigint NOT NULL,
  `birthdate` date NOT NULL,
  `gender` tinyint NOT NULL,
  `email_address` varchar(255) NOT NULL,
  PRIMARY KEY (`id_person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `employee` (
  `id_employee` int NOT NULL AUTO_INCREMENT,
  `position` varchar(50) NOT NULL,
  `employment_date` date NOT NULL,
  PRIMARY KEY (`id_employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `janitor` (
  `id_janitor` int NOT NULL AUTO_INCREMENT,
  `working_area` varchar(50) NOT NULL,
  `employee_id` int NOT NULL,
  `person_id` int NOT NULL,
  PRIMARY KEY (`id_janitor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `principal` (
  `id_principal` int NOT NULL AUTO_INCREMENT,
  `employee_id` int NOT NULL,
  `person_id` int NOT NULL,
  PRIMARY KEY (`id_principal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `student` (
  `id_student` int NOT NULL AUTO_INCREMENT,
  `person_id` int NOT NULL,
  `enroll_date` date NOT NULL,
  `graduated` tinyint NOT NULL,
  `graduation_date` date,
  PRIMARY KEY (`id_student`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `subject` (
  `id_subject` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `class_id` int NOT NULL,
  PRIMARY KEY (`id_subject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `subjects_enrollments` (
  `id_subject_enrollment` int NOT NULL AUTO_INCREMENT,
  `subject_id` int NOT NULL,
  `student_id` int NOT NULL,
  `enrollment_date` date NOT NULL,
  PRIMARY KEY (`id_subject_enrollment`),
  KEY `subject_enrollment_fk_subject_id` (`subject_id`),
  CONSTRAINT `subject_enrollment_fk_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id_subject`) ON UPDATE NO ACTION ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;