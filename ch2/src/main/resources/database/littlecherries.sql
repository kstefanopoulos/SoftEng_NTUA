SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";




-- Βάση: `little_database`
CREATE DATABASE IF NOT EXISTS `littlecherries_database` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `littlecherries_database`;


DROP TABLE IF EXISTS `organizer`;


CREATE TABLE IF NOT EXISTS `organizer` (
  `oemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `company_name` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `bank_account` varchar(20) NOT NULL,
  `first_name` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(50) COLLATE utf8_general_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `phone_number` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `balance` float NOT NULL,
  `street_name` varchar(20) COLLATE utf8_general_ci,
  `street_number` varchar(5) COLLATE utf8_general_ci DEFAULT NULL,
  `town` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `postal_code` varchar(5) COLLATE utf8_unicode_ci,
  `afm`  varchar(11) COLLATE utf8_general_ci NOT NULL,
  `registration_date` date NOT NULL,
  `evaluation` int(1) NOT NULL,
  `restrictions` int(2) NOT NULL DEFAULT '0', 
  PRIMARY KEY (`oemail`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ;



INSERT INTO `organizer` (`oemail`, `company_name`, `bank_account`, `first_name`, `last_name`, `username`, `password`, `phone_number`, `balance`, `street_name`, `street_number`, `town`, `postal_code`, `afm`, `registration_date`, `evaluation`, `restrictions`) VALUES
('apap@threepigs.gr', 'kalispera', '839138811', 'Anna', 'Papadopoulou', 'apap', '71118', '6982181121', 0, 'Khfisias', '10', 'Athens', '15773', '18821121', '2018-02-01', 0,0), 
('bill@allou.gr', 'Allou', '135138377313', 'Bill', 'Markou', 'bmar', '444', '6975221287', 0, 'Artakis', '5', 'Athens', '17124', '813798731', '2018-01-25', 0,0),
('maraki@bob.gr', 'bobomastoras', '90919212', 'Maria', 'Papakh', 'mapa', '91102', '6982181121', 0, 'Khfisias', '12', 'Athens', '15773', 'jhddd1111', '2018-02-01', 0,0),
('maria@papakia.com', 'Papakia', '13332411422', 'Maria', 'Papadopoulou', 'mapa', '1111', '677677776', 0, 'Sina', '20', 'Athens', '15773', '7177313', '2018-01-08', 0,0),
('nik@kids.gr', 'Kids', '32313131', 'Nikos', 'Babis', 'bab', '2222', '892282828', 0, 'Mesogeiwn', '12', 'Athens', '12311', '71277213', '2018-02-05', 0,0);


DROP TABLE IF EXISTS `event`;

CREATE TABLE IF NOT EXISTS `event` (
  `eventid` int(5) NOT NULL,
  `oemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `organizer_name` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `event_name` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `event_cost` int(3) NOT NULL,
  `street_name` varchar(20) COLLATE utf8_general_ci DEFAULT NULL,
  `street_number` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `town` varchar(20) COLLATE utf8_general_ci DEFAULT NULL,
  `postal_code` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `event_class` varchar(40) COLLATE utf8_general_ci DEFAULT NULL,
  `event_description` text COLLATE utf8_general_ci,
  `evaluation` int(3) NOT NULL DEFAULT '0',
  `isdone` int(1) NOT NULL DEFAULT '0',
  `longitude` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `latitude` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `startage` int(11) NOT NULL,
  `endage` int(11) NOT NULL,
  `duration` int(11) NOT NULL DEFAULT '0',
  `tickets` int(11) NOT NULL DEFAULT '0',
  `createdat` date DEFAULT NULL,
  PRIMARY KEY (`eventid`)
  
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ;


--
INSERT INTO `event` (`eventid`, `oemail`, `organizer_name`, `event_name`, `event_cost`, `street_name`, `street_number`, `town`, `postal_code`, `event_class`, `event_description`, `evaluation`, `isdone`, `longitude`, `latitude`, `startage`, `endage`, `duration`, `tickets`, `createdat`) VALUES
(37, 'maria@papakia.com', 'Papakia', 'psarakia', 10, 'Aiolou', '20', 'Athens', '16711', 'Sport', NULL, 2, 0, '23.7253169', '37.9760376', 2, 6, 1, 2, '2018-02-01'),
(38, 'nik@kids.gr', 'Kids', 'bob', 10, 'Khfisias', '29', 'Athens', '15773', 'Workshop', NULL, 3, 0, '23.7903351', '38.0329352', 2, 9, 1, 6, '2018-02-03'),
(39, 'maria@papakia.com', 'Papakia', 'kalispera', 20, 'Artakis', '12', 'Athens', '17124', 'Cinema', NULL, 0, 0, '23.7249493', '37.9480748', 2, 8, 2, 0, '2018-02-26');


DROP TABLE IF EXISTS `administrator`;

CREATE TABLE IF NOT EXISTS `administrator` (
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) NOT NULL,
  `phone_number` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `account` varchar(20)  COLLATE utf8_general_ci,
  `restrictions` int(2) NOT NULL DEFAULT '0', 
  PRIMARY KEY (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ;


INSERT INTO `administrator` (`email`, `first_name`, `last_name`, `username`, `password`, `phone_number`, `account`) VALUES
('admin@littlecherries.gr', 'Κοσμάς', 'Στεφανόπουλος', 'kostef', 'admin', '6978874512', '123-456-789');


DROP TABLE IF EXISTS `parent`;

CREATE TABLE IF NOT EXISTS `parent` (
  `pemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(20) COLLATE utf8_general_ci NOT NULL, 
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(20)  COLLATE utf8_unicode_ci NOT NULL,
  `balance` float DEFAULT '0',
  `last_transaction_date` date DEFAULT NULL, 
  `street_name` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `street_number` int(3) NOT NULL,
  `town` varchar(20) COLLATE utf8_general_ci NOT NULL,
  `postal_code` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `bucketId` int(5) DEFAULT NULL, 
  `restrictions` int(2) NOT NULL, 
   PRIMARY KEY(`pemail`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT INTO `parent` (`pemail`, `first_name`, `last_name`, `username`, `password`, `phone_number`, `balance`, `last_transaction_date`, `street_name`, `street_number`, `town`, `postal_code`, `bucketId`, `restrictions`) VALUES
('apap@gmail.com', 'Anna', 'Papadopoulou', 'apap', '1267', '6971235111', 0, NULL, 'Aiolou', 5, 'Athens', '17145', 1,0),
('nap@gmail.com', 'Nikos', 'Apostolou', 'nap', '1111', '693822111', 0, NULL, 'Khfisias', 12, 'Athens', '15773', 3,0);


DROP TABLE IF EXISTS `bucket`;

CREATE TABLE IF NOT EXISTS `bucket` (
  `bucketid` int(5) NOT NULL AUTO_INCREMENT,
  `pemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `event_card` int(3) NOT NULL,
  `overall_cost` int(4) NOT NULL,
  CONSTRAINT Fkb_pemail FOREIGN KEY (`pemail`) 
    REFERENCES `parent`(`pemail`) ON DELETE CASCADE,
  PRIMARY KEY (`bucketId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=106;


INSERT INTO `bucket` (`bucketid`, `pemail`, `event_card`, `overall_cost`) VALUES
(1, 'apap@gmail.com', 0, 0),
(3, 'nap@gmail.com', 0, 0);

DROP TABLE IF EXISTS `willAttend`;

CREATE TABLE IF NOT EXISTS `willAttend` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `pemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `eventId` int(5) NOT NULL,
  `date` date NOT NULL,
  `time` time(1) NOT NULL,
  `valid` int(1) NOT NULL DEFAULT '1',
  `tickets` int(11) NOT NULL DEFAULT '0',  
  CONSTRAINT Fk_pemail FOREIGN KEY (`pemail`) 
    REFERENCES `parent`(`pemail`) ON DELETE CASCADE,
  CONSTRAINT Fk_eventId FOREIGN KEY (`eventId`) 
    REFERENCES `event`(`eventId`) ON DELETE CASCADE,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=404 ;


DROP TABLE IF EXISTS `hasAttended`;

CREATE TABLE IF NOT EXISTS `hasAttended` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `pemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `eventId` int(5) NOT NULL,
  `isfavorite` int(1),
  `rating` int(11) NOT NULL DEFAULT '0',
 CONSTRAINT Fk1_pemail FOREIGN KEY (`pemail`) 
    REFERENCES parent(`pemail`) ON DELETE CASCADE,
  CONSTRAINT Fk1_eventId FOREIGN KEY (`eventId`) 
    REFERENCES event(`eventId`) ON DELETE CASCADE,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=504 ;



DROP TABLE IF EXISTS `ConsistsOf`;

CREATE TABLE IF NOT EXISTS `ConsistsOf` (
	`id`  int(5) NOT NULL AUTO_INCREMENT,
	`bucketId` int(5) NOT NULL,
	`eventId` int(5) NOT NULL,
	`isfavourite` int(1) NOT NULL DEFAULT '0',
  CONSTRAINT Fk_bucketId FOREIGN KEY (`bucketId`) 
    REFERENCES `bucket`(`bucketId`) ON DELETE CASCADE,
  CONSTRAINT Fk2_eventId FOREIGN KEY (`eventId`) 
    REFERENCES `event`(`eventId`) ON DELETE CASCADE,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci; 



DROP TABLE IF EXISTS `eventinfo`;
CREATE TABLE IF NOT EXISTS `eventinfo` ( 
  `eventinfoid` int(5) NOT NULL,
  `eventid` int(5) NOT NULL,
  `eventdate` date DEFAULT NULL,
  `availabletickets` int(5) NOT NULL DEFAULT '0',
  `starttime` time DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`eventinfoId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=100;


INSERT INTO `eventinfo` (`eventinfoid`, `eventid`, `eventdate`, `availabletickets`, `starttime`, `active`) VALUES
(119, 37, '2018-02-28', 4, '10:00:00', 0),
(120, 37, '2018-03-01', 5, '10:00:00', 0),
(121, 38, '2018-02-21', 5, '10:00:00', 0),
(122, 39, '2018-02-28', 5, '10:10:00', 0);



DROP TABLE IF EXISTS `users`;

CREATE TABLE IF NOT EXISTS `users`(
 `id`  int(5) NOT NULL AUTO_INCREMENT,
 `email`  varchar(200) COLLATE utf8_unicode_ci NOT NULL,
 `type` int(5) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=711;

INSERT INTO `users` (`email`, `type`) VALUES
('apap@gmail.com',0),
('nap@gmail.com', 0),
('admin@littlecherries.gr',2), 
('apap@threepigs.gr',1),
('bill@allou.gr',1),
('maraki@bob.gr',1), 
('maria@papakia.com',1), 
('nik@kids.gr',1); 



	DROP TABLE IF EXISTS `restrictions`;

	CREATE TABLE IF NOT EXISTS `restrictions`(
	 `rid`  int(5) NOT NULL AUTO_INCREMENT,
	 `description`  varchar(200) COLLATE utf8_unicode_ci NOT NULL,
	 `enum` int(5) NOT NULL,
	 PRIMARY KEY (`rid`)
	) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=711;

	INSERT INTO `restrictions`(`description`, `enum`) VALUES
	('Parent cannot buy.',1),
	('Parent cannot load his wallet.',2),
	('Parent cannot load his wallet and cannot buy ticket',3),
	('Organizer cannot create an event.',4),
	('Administrator cannot assign rights.',5),
	('Administrator cannot add another Admin',6),
	('User Locked!',7);


ALTER TABLE `parent`
  ADD CONSTRAINT `parent_fk_1` FOREIGN KEY (`bucketId`) REFERENCES `bucket` (`bucketId`) ON DELETE CASCADE ; 

ALTER TABLE `event`
  ADD CONSTRAINT `event_fk_1` FOREIGN KEY (`oemail`) REFERENCES `organizer` (`oemail`) ON DELETE CASCADE; 
  
ALTER TABLE `eventinfo`
	ADD CONSTRAINT `fk3eventid` FOREIGN KEY (`eventId`) REFERENCES `event`(`eventId`) ON DELETE CASCADE ; 
	  













