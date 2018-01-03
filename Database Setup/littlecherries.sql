SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


-- Βάση: `little_database`
CREATE DATABASE IF NOT EXISTS `littlecherries_database` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `littlecherries_database`;




DROP TABLE IF EXISTS `organizer`;


CREATE TABLE IF NOT EXISTS `organizer` (
  `oemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `company_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `bank_account` int(20) NOT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` int(20) NOT NULL,
  `phone_number` int(20) NOT NULL,
  `balance` int(5) NOT NULL,
  `street_name` varchar(20) COLLATE utf8_unicode_ci,
  `street_number` varchar(5) COLLATE utf8_unicode_ci,
  `town` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `postal_code` varchar(5) COLLATE utf8_unicode_ci,
  `afm`  varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `registrarion_date` date NOT NULL,
  `evaluation` int(1) NOT NULL,
  PRIMARY KEY (`oemail`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ;




INSERT INTO `organizer` (`oemail`,`company_name`, `bank_account`, `first_name` ,`last_name`,`username`,`password`,`phone_number`,`balance`,`street_name`, `street_number`, `town`, `postal_code`, `afm`, `registrarion_date`, `evaluation`) VALUES
('triantafyllou@kidsfun.gr', 'KidFun', '567-569-918','Γιάννης', 'Τριανταφύλλου','triantaf','organizer','6945678', 100,'Καλλιπόλεος',7,'Χαλάνδρι','45678', '416198101','2016-12-2', 9),
('papastaurou@zouzounia.gr', 'Zouzounia', '567-569-938' ,'Dimitris','Papastaurou','jimaras','organizer','69345678', 60,'Παύλου Μελά',7,'Χαιδάρι','45678', '416198101','2016-12-2', 8),
('stauropoulou@louloudakia.gr', 'Louloudakia','567-569-912'  ,'Aliki','Stauropoulou','alikaki','organizer','69452791', 180,'Παπαφλέσα',7,'Εκάλι','45178', '416198101','2016-11-2', 9),
('enels@paidakiaxaroumena.gr', 'Xaroumena Paidakia', '567-523-918' ,'Elsa','Neou','elsa','organizer','69467222', 60,'Στρατηγού',2,'Νέος Κόσμος','19820', '416198101','2016-12-2', 7),
('anna_papa@margaritoules.gr', 'Margaritoules', '567-569-917'  ,'Anna','Paulou','noula','organizer','69427181112', 50,'Ολύμπου',7,'Παλλήνη','45672', '416198101','2015-12-2', 7);


DROP VIEW IF EXISTS `organizer_view`; /* Τα στοιχεία του organizer μπορούν να τα δουν όλοι
και όταν θα θέλουμε να δείξουμε ένα προφίλ διοργανωτή τοτε θα κανουμε querie στο view του  */ 

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `organizer_view` 
AS select `organizer`.`oemail` AS `oemail`,
`organizer` .`company_name` AS `company_name`,
`organizer` .`first_name` AS `first_name`,
`organizer` .`last_name` AS `last_name`,
`organizer` .`phone_number` AS `phone_number`,
`organizer` .`street_name` AS `street_name`,
`organizer` .`street_number` AS `street_number`,
`organizer` .`town` AS `town`,
`organizer` .`postal_code` AS `postal_code`,
`organizer` .`evaluation` AS`evaluation`
from `organizer`;

-- 

DROP TABLE IF EXISTS `event`;

CREATE TABLE IF NOT EXISTS `event` (
  `eventId` int(5) NOT NULL AUTO_INCREMENT,
  `organizer_email` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `organizer_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `event_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `event_date` varchar(100) COLLATE utf8_unicode_ci,
  `start_time` varchar(100) COLLATE utf8_unicode_ci,
  `available_tickets` varchar(100) COLLATE utf8_unicode_ci,
  `event_cost` int(3) NOT NULL, 
  `street_name` varchar(20) COLLATE utf8_unicode_ci,
  `street_number` varchar(5) COLLATE utf8_unicode_ci,
  `town` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `postal_code` varchar(5) COLLATE utf8_unicode_ci,
  `ages` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `event_class` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `event_description` text COLLATE utf8_unicode_ci NOT NULL,
  `evaluation` int(3) NOT NULL,
  `isdone` int(1) NOT NULL, 
  PRIMARY KEY (`eventId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3;



INSERT INTO `event` (`eventId`,`organizer_email`,`organizer_name`,`event_name`,`event_date`,`start_time`,`available_tickets`,`event_cost`,`street_name`, `street_number`, `town`, `postal_code`, `ages`, `event_class`, `event_description`,`evaluation`,`isdone`) VALUES
(1,'papastaurou@zouzounia.gr','Ζουζούνια','Κουκλοθέατρο με τον Αη Βασίλη','2017-12-20/2017-12-22/2017-12-25','19.00/19.00/19.00','20/20/20',10,'Φιλλίπου',5,'Παγκράτι','51782','10','Παιδική Παράσταση', 'Κεφάτη Μουσικοχορευτική Παράσταση', 8, 1),
(2,'enels@paidakiaxaroumena.gr','Χαρούμενα Παιδάκια','Face Painting','2017-12-29/2018-01-2/2018-01-3','19.00/19.00/19.00','5/5/5',10,'Πέτρου',5,'Παγκράτι','51719','7','Χειροτεχνίες', 'Χειροτεχνίες και Face Painting για τους μικρούς μας φίλους', 8, 0);



DROP VIEW IF EXISTS `event_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `event_view` 
AS select `event`.`eventId` AS `eventId`,
`event`.`organizer_email` AS `organizer_email`,
`event`.`organizer_name` AS `organizer_name`,
`event`.`event_name` AS `event_name`,
`event`.`event_date` AS `event_date`,   /* event_date και event_name θέλουν parsing πριν τα βαλουμε στον front */ 
`event`.`start_time` AS `start_time`,
`event`.``available_tickets` AS `available_tickets`,
`event`.`event_cost` AS `event_cost`,
`event`.`street_name` AS `street_name`,
`event`.`street_number` AS `street_number`,
`event`.`town` AS `town`,
`event`.`postal_code` AS `postal_code`,
	`event`.`ages` AS `ages`,
`event`.`event_class` AS `event_class`,
`event`.`event_description` AS `event_description`,
`event`.`evaluation` AS `evaluation`
from `event`;


DROP TABLE IF EXISTS `administrator`;

CREATE TABLE IF NOT EXISTS `administrator` (
  `email` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) NOT NULL,
  `phone_number` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
   `account` varchar(20)  COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ;


INSERT INTO `administrator` (`email`,`first_name`,`last_name`,`username`, `password`,`phone_number`,`account`) VALUES 
('admin@littlecherries.gr','Κοσμάς','Στεφανόπουλος','kostef','admin','6978874512', '123-456-789');



DROP VIEW IF EXISTS `administrator_view`;    /* To βλέπουν μονο οι χρήστες το site */ 

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `administrator_view` 
AS select `administrator`.`email` AS `email`,
`administrator` .`first_name` AS `first_name`,
`administrator` .`last_name` AS `last_name`,
`administrator` .`phone_number` AS `phone_number`
from `administrator`;


DROP TABLE IF EXISTS `parent`;

CREATE TABLE IF NOT EXISTS `parent` (
  `pemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL, 
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(20)  COLLATE utf8_unicode_ci NOT NULL,
  `balance` int(5),
  `last_transaction_date` date, 
  `street_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `street_number` int(3) NOT NULL,
  `town` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `postal_code` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `bucketId` int(5) NOT NULL,
   PRIMARY KEY(`pemail`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT INTO `parent` (`pemail`,`first_name`,`last_name`,`username`,`password`,`phone_number`,`balance`,`last_transaction_date` ,`street_name`, `street_number`, `town`, `postal_code`, `bucketId`) VALUES
('aggelakis@gmail.com','Θοδωρής','Αγγελάκης','aggel', 'parent' , '69876578',10, '2017-12-15' ,'Μανωλάς',4,'Παγκράτη','13459',101),
('papakiroz@gmail.com','Μαρία','Καστάνη','maraki', 'parent' ,'696171892',20,'2017-12-22' ,'Κισάβου',7,'Ψυχικό','81982',102),
('trikalinos@gmail.com','Παναγιώτης','Τάσος','takis', 'parent' ,'6961829221',10, '2017-12-17','Μενελάου',4,'Άγιος Δημήτριος','17343',103),
('matinaki@gmail.com','Ματίνα','Ανάπαλη','aggel', 'parent' ,'69876578',0,'Καλλιγά',122,'2017-12-19' ,'Φιλοθέη','91822',104),
('tassvasiliki@gmail.com','Βασιλική','Τασσοπούλου','stofoz', 'parent','69876578',5,'2017-11-15','Μενελάου',4,'Άγιος Δημήτριος','17343',105);


DROP VIEW IF EXISTS `parent_view`; /* Μονο για να το βλεπει ο parent
και όταν θα θέλουμε να δείξουμε ένα προφίλ γονεα τοτε θα κανουμε querie στο view του  */ 

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `parent_view` 
AS select `parent`.`pemail` AS `pemail`,
`parent` .`first_name` AS `first_name`,
`parent` .`last_name` AS `last_name`,
`parent` .`phone_number` AS `phone_number`,
`parent` .`balance` AS `balance`,
`parent` .`last_transaction_date` AS `last_transaction_date`,
`parent` .`street_name` AS `street_name`,
`parent` .`street_number` AS `street_number`,
`parent` .`town` AS `town`,
`parent` .`postal_code` AS `postal_code`
from `parent`;



DROP TABLE IF EXISTS `bucket`;

CREATE TABLE IF NOT EXISTS `bucket` (
  `bucketId` int(5) NOT NULL AUTO_INCREMENT,
  `pemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `event_card` int(3) NOT NULL,
  `overall_cost` int(4) NOT NULL,
  CONSTRAINT Fkb_pemail FOREIGN KEY (`pemail`) 
    REFERENCES `parent`(`pemail`) ON DELETE CASCADE,
  PRIMARY KEY (`bucketId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=106;




INSERT INTO `bucket`(`bucketId`,`pemail`,`event_card`,`overall_cost`) VALUES
(101,'aggelakis@gmail.com',1, 60),
(102,'papakiroz@gmail.com',2,  10),
(103,'trikalinos@gmail.com',3, 10),
(104,'matinaki@gmail.com',4, 10),
(105,'tassvasiliki@gmail.com',5,  10);


/* Οι πληροφορίες του view θα περιλαμβανονται στο profile του χρηστη και θα τις βρισκουμε με ενα query*/
DROP VIEW IF EXISTS `bucket_view`;  /* TODO */ 

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `organizer_view` 
AS select `bucket`.`bucketId` AS `bucketId`,
`bucket` .`event_card` AS `event_card`,
`bucket` .`overall_cost` AS `overall_cost`
from `bucket`;


DROP TABLE IF EXISTS `willAttend`;

CREATE TABLE IF NOT EXISTS `willAttend` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `pemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `eventId` int(5) NOT NULL,
  `finaldate` date NOT NULL,  
  CONSTRAINT Fk_pemail FOREIGN KEY (`pemail`) 
    REFERENCES `parent`(`pemail`) ON DELETE CASCADE,
  CONSTRAINT Fk_eventId FOREIGN KEY (`eventId`) 
    REFERENCES `event`(`eventId`) ON DELETE CASCADE,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=404 ;

INSERT INTO `willAttend` (`id`,`pemail`,`eventId`) VALUES 
(401,'aggelakis@gmail.com',2),
(402,'papakiroz@gmail.com',2),
(403,'trikalinos@gmail.com',2);

/* Θέλω ενα view που θα περιέχει πληροφορίες για τα μελλοντικά events του χρήστη. Αρα θέλω : pemail, event_date, event_name 
 Τα μελλοντικά events του γονέα μπορουν να μεταφραστουν ως οι αγορες που εχει κανει.
 Αρα κάθε φορα που πραγματοποιείται μια αγορά θα εισάγεται στον πίνακα willAttend ενα entry με το Id του event που εχει αγοράσει. 
 Πληροφορία προφίλ χρηστη -> query 
 */ 
DROP VIEW IF EXISTS `futureevents_view`; /* Μελλοντικά events που θα εμφανίζονται μόνο στο προφιλ του γονέα   */ 

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER
VIEW `futureevents_view`
SELECT `parent`.`pemail` as `pemail` , `event`.`event_date`, ,UNIT_COST, SUPPLIER_COST
		FROM SAMPLECOLL.INVENTORY_LIST A, SAMPLECOLL.SUPPLIERS B
		WHERE A.ITEM_NUMBER = B.ITEM_NUMBER
		AND UNIT_COST > SUPPLIER_COST



DROP TABLE IF EXISTS `hasAttended`;

CREATE TABLE IF NOT EXISTS `hasAttended` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `pemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `eventId` int(5) NOT NULL,
  `isfavorite` int(1),
 CONSTRAINT Fk1_pemail FOREIGN KEY (`pemail`) 
    REFERENCES parent(`pemail`) ON DELETE CASCADE,
  CONSTRAINT Fk1_eventId FOREIGN KEY (`eventId`) 
    REFERENCES event(`eventId`) ON DELETE CASCADE,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=504 ;

INSERT INTO `hasAttended` (`id`,`pemail`,`eventId`, `isfavorite`) VALUES 
(500,'aggelakis@gmail.com',1,1),
(501,'papakiroz@gmail.com',1,1),
(502,'trikalinos@gmail.com',1,1);



DROP TABLE IF EXISTS `ConsistsOf`;

CREATE TABLE IF NOT EXISTS `ConsistsOf` (
	`id`  int(5) NOT NULL AUTO_INCREMENT,
	`bucketId` int(5) NOT NULL,
	`eventId` int(5) NOT NULL,
  CONSTRAINT Fk_bucketId FOREIGN KEY (`bucketId`) 
    REFERENCES `bucket`(`bucketId`) ON DELETE CASCADE,
  CONSTRAINT Fk2_eventId FOREIGN KEY (`eventId`) 
    REFERENCES `event`(`eventId`) ON DELETE CASCADE,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=605;

INSERT INTO `ConsistsOf` (`id`,`bucketId`,`eventId`) VALUES
(600, 101, 2),
(601, 102, 2),
(602, 103, 2),
(603, 104, 2),
(604, 105, 2);



DROP TABLE IF EXISTS `restrictions`;

CREATE TABLE IF NOT EXISTS `restrictions`(
 `rid`  int(5) NOT NULL AUTO_INCREMENT,
 `description`  varchar(200) COLLATE utf8_unicode_ci NOT NULL,
 PRIMARY KEY (`rid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=711;

INSERT INTO `restrictions`( `rid`,`description`) VALUES
(700,'Parent cannot buy.'),
(701,'Parent cannot load his wallet.'),
(702,'Parent cannot edit profile.'), 
(703, 'Organizer cannot create an event.'),
(704, 'Organizer cannot see monthly report.'),
(705, 'Organizer cannot edit Profile.'),
(706, 'Organizer cannot see history status.'),
(707, 'Administrator cannot assign rights.'),
(708, 'Administrator cannot view Users Information'),
(709, 'Administrator cannot add another Admin'),
(710, 'User Locked!');


DROP VIEW IF EXISTS `restrictions_view`;    /* To βλέπουν οι admin στο προφιλ τους το site */ 

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `restrictions_view` 
AS select `restrictions`.`rid` AS `rid`,
`restrictions` .`description` AS `description`
from `restrictions`;


DROP TABLE IF EXISTS `hasRestrictions`;

CREATE TABLE IF NOT EXISTS `hasRestrictions`(
	`id`  int(5) NOT NULL AUTO_INCREMENT,
	`rid` int(5) NOT NULL, 
	`email` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  CONSTRAINT Fk_rid FOREIGN KEY (`rid`) 
    REFERENCES `restrictions`(`rid`) ON DELETE CASCADE,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=10;



DROP TABLE IF EXISTS `Users`; 
CREATE TABLE IF NOT EXISTS `Users`( 
	`email` varchar(20) COLLATE utf8_unicode_ci NOT NULL
	 PRIMARY KEY (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=10;



INSERT INTO `Users` (`email`) VALUES
('aggelakis@gmail.com'),
('papakiroz@gmail.com'),
('trikalinos@gmail.com'),
('matinaki@gmail.com'),
('tassvasiliki@gmail.com');
('triantafyllou@kidsfun.gr'),
('papastaurou@zouzounia.gr'),
('stauropoulou@louloudakia.gr'),
('enels@paidakiaxaroumena.gr'),
('anna_papa@margaritoules.gr'),
('admin@littlecherries.gr');




ALTER TABLE `parent`
  ADD CONSTRAINT `parent_fk_1` FOREIGN KEY (`bucketId`) REFERENCES `bucket` (`bucketId`) ON DELETE CASCADE ; 

ALTER TABLE `event`
  ADD CONSTRAINT `event_fk_1` FOREIGN KEY (`organizer_email`) REFERENCES `organizer` (`oemail`) ON DELETE CASCADE; 
  



/* View για όλα τα αγαπημενα events του χρηστη. Θα εμφανίζονται στο profile του με ενα query */ 
/* Ομοιο με τα μελλοντικα events αλλά χωρις ημερομηνια */ 


/* Triggers */ 












