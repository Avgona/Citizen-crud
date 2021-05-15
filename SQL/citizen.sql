CREATE DATABASE  IF NOT EXISTS `citizen_directory`;
USE `citizen_directory`;

--
-- Table's structure of `citizen`
--

DROP TABLE IF EXISTS `citizen_directory`;

CREATE TABLE `citizen` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `passport_number` varchar(45) NOT NULL,
  `career` varchar(45) DEFAULT NULL,
  `apartment` int DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;




INSERT INTO `citizen` VALUES
    (7, 'Vladyslav', 'Parkhomneko', 'FN284101', 'STUDENT', '12', 'Centralna', 'Warszawa', 'Poland'),
    (8, 'John', 'Thomas', 'AM298151', 'ENTREPRENEUR', '928', 'Brightlese', 'New York City', 'USA'),
    (9, 'Knut', 'Anderson', 'RM128421', 'EMPLOYEE', '5', 'Skottler', 'Oslo', 'Norway'),
    (10, 'Svein', 'Anderson', 'OR931844', 'ENTREPRENEUR', '37', 'Klokver', 'Stockholm', 'Sweeden'),
    (11, 'Wolfgang', 'Muller', 'FM124915', 'FREELANCER', '17', 'Worischofen', 'Munchen', 'Germany');
