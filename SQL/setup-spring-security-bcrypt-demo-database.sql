DROP DATABASE IF EXISTS `citizen_security`;

CREATE DATABASE IF NOT EXISTS `citizen_security`;
USE `citizen_security`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `users` (`username`,`password`,`enabled`) VALUES ('john','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);
INSERT INTO `users` (`username`,`password`,`enabled`) VALUES ('mary','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);
INSERT INTO `users` (`username`,`password`,`enabled`) VALUES ('susan','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);

INSERT INTO `authorities` (`username`,`authority`) VALUES ('john','ROLE_EMPLOYEE');
INSERT INTO `authorities` (`username`,`authority`) VALUES ('mary','ROLE_EMPLOYEE');
INSERT INTO `authorities` (`username`,`authority`) VALUES ('mary','ROLE_MANAGER');
INSERT INTO `authorities` (`username`,`authority`) VALUES ('susan','ROLE_ADMIN');
INSERT INTO `authorities` (`username`,`authority`) VALUES ('susan','ROLE_EMPLOYEE');