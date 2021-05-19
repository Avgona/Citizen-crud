DROP DATABASE IF EXISTS `citizen_repository`;

CREATE DATABASE  IF NOT EXISTS `citizen_repository`;
USE `citizen_repository`;

DROP TABLE IF EXISTS `citizen_repository`;
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

CREATE TABLE `foreign_citizenship` (
  `citizen_id` int NOT NULL,
  `citizenship` varchar(45) DEFAULT NULL,
  `citizen_order` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `citizen` (`id`,`first_name`,`last_name`,`passport_number`,`career`,`apartment`,`street`,`city`,`country`) VALUES (1,'Vladyslav','Parkhomneko','FN284101','STUDENT',12,'Centralna','Warszawa','Poland');
INSERT INTO `citizen` (`id`,`first_name`,`last_name`,`passport_number`,`career`,`apartment`,`street`,`city`,`country`) VALUES (2,'John','Thomas','AM298151','ENTREPRENEUR',928,'Brightlese','New York City','USA');
INSERT INTO `citizen` (`id`,`first_name`,`last_name`,`passport_number`,`career`,`apartment`,`street`,`city`,`country`) VALUES (3,'Knut','Anderson','RM128421','EMPLOYEE',5,'Skottler','Oslo','Norway');
INSERT INTO `citizen` (`id`,`first_name`,`last_name`,`passport_number`,`career`,`apartment`,`street`,`city`,`country`) VALUES (4,'Svein','Anderson','OR931844','ENTREPRENEUR',37,'Klokver','Stockholm','Sweeden');
INSERT INTO `citizen` (`id`,`first_name`,`last_name`,`passport_number`,`career`,`apartment`,`street`,`city`,`country`) VALUES (5,'Wolfgang','Muller','FM124915','FREELANCER',17,'Worischofen','Munchen','Germany');

