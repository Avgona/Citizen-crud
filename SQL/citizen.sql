CREATE DATABASE  IF NOT EXISTS `citizen_directory`;
USE `citizen_directory`;

--
-- Table's structure of `citizen`
--

DROP TABLE IF EXISTS `citizen_directory`;

CREATE TABLE `citizen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `passport_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `citizen` VALUES
	(1,'Vladyslav','Parkhomenko','FM12345'),
	(2,'Yana','Parkhomenko','FR54321'),
	(3,'Serdzhio','Parkhomenko','FM32145'),
	(4,'Bergen','Anderson','FA7577');

