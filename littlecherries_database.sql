-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 01, 2018 at 11:05 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `littlecherries_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `salt` blob NOT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `account` varchar(20) DEFAULT NULL,
  `restrictions` int(2) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`email`, `first_name`, `last_name`, `username`, `password`, `salt`, `phone_number`, `account`, `restrictions`) VALUES
('i.telali@hotmail.com', 'Little', 'Cherries', 'cherries_admin', '���5�A�j��U���m', 0xfafa3e0c94a5a550, '166', NULL, 6);

-- --------------------------------------------------------

--
-- Table structure for table `bucket`
--

CREATE TABLE `bucket` (
  `bucketid` int(5) NOT NULL,
  `pemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `event_card` int(3) NOT NULL,
  `overall_cost` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bucket`
--

INSERT INTO `bucket` (`bucketid`, `pemail`, `event_card`, `overall_cost`) VALUES
(106, 'marath@gmail.com', 0, 0),
(107, 'apap@gmail.com', 0, 0),
(108, 'ioannou@gmail.com', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `consistsof`
--

CREATE TABLE `consistsof` (
  `id` int(5) NOT NULL,
  `bucketId` int(5) NOT NULL,
  `eventId` int(5) NOT NULL,
  `isfavourite` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `eventid` int(5) NOT NULL,
  `oemail` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `organizer_name` varchar(20) NOT NULL,
  `event_name` varchar(20) NOT NULL,
  `event_cost` int(3) NOT NULL,
  `street_name` varchar(20) DEFAULT NULL,
  `street_number` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `town` varchar(20) DEFAULT NULL,
  `postal_code` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `event_class` varchar(40) DEFAULT NULL,
  `event_description` text,
  `evaluation` int(3) NOT NULL DEFAULT '0',
  `isdone` int(1) NOT NULL DEFAULT '0',
  `longitude` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `latitude` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `startage` int(11) NOT NULL,
  `endage` int(11) NOT NULL,
  `duration` int(11) NOT NULL DEFAULT '0',
  `tickets` int(11) NOT NULL DEFAULT '0',
  `createdat` date DEFAULT NULL,
  `hasfoto` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`eventid`, `oemail`, `organizer_name`, `event_name`, `event_cost`, `street_name`, `street_number`, `town`, `postal_code`, `event_class`, `event_description`, `evaluation`, `isdone`, `longitude`, `latitude`, `startage`, `endage`, `duration`, `tickets`, `createdat`, `hasfoto`) VALUES
(2, 'nik@kids.gr', 'Kids', ' Χιονάτη', 10, 'Μεσογείων', '67', 'Αθήνα', '15773', 'Θέατρο', 'Το πιο όμορφο παραμύθι!', 0, 0, '23.7794745', '37.9955175', 2, 5, 2, 10, '2018-03-01', 1),
(3, 'npapad@gmail.com', 'ToyStory', 'Η κοκκινοσκουφίτσα', 10, 'Πατησίων', '111', 'Αθήνα', '11256', 'Θέατρο', 'Ελάτε να γνωρίσετε την Κοκκινοσκουφίτσα', 0, 0, '23.7322042', '37.9962819', 2, 5, 2, 4, '2018-03-01', 1),
(4, 'kvol@gmail.com', 'AllForKids', 'Μπλέ Παπάκια', 20, 'Συγγρού', '100', 'Αθήνα', '11741', 'Αθλήματα', 'Πάμε στην Ποταμιά', 0, 0, '23.7246726', '37.9631817', 3, 5, 2, 0, '2018-03-01', 1);

-- --------------------------------------------------------

--
-- Table structure for table `eventinfo`
--

CREATE TABLE `eventinfo` (
  `eventinfoid` int(5) NOT NULL,
  `eventid` int(5) NOT NULL,
  `eventdate` date DEFAULT NULL,
  `availabletickets` int(5) NOT NULL DEFAULT '0',
  `starttime` time DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `eventinfo`
--

INSERT INTO `eventinfo` (`eventinfoid`, `eventid`, `eventdate`, `availabletickets`, `starttime`, `active`) VALUES
(2, 2, '2018-03-30', 10, '10:00:00', 0),
(3, 2, '2018-04-12', 1, '10:00:00', 0),
(4, 3, '2018-03-28', 10, '08:00:00', 0),
(5, 4, '2018-03-30', 5, '10:10:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `hasattended`
--

CREATE TABLE `hasattended` (
  `id` int(5) NOT NULL,
  `pemail` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `eventId` int(5) NOT NULL,
  `isfavorite` int(1) DEFAULT NULL,
  `rating` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `organizer`
--

CREATE TABLE `organizer` (
  `oemail` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `company_name` varchar(20) NOT NULL,
  `bank_account` varchar(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `salt` blob NOT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `balance` float NOT NULL,
  `street_name` varchar(20) DEFAULT NULL,
  `street_number` varchar(5) DEFAULT NULL,
  `town` varchar(20) NOT NULL,
  `postal_code` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `afm` varchar(11) NOT NULL,
  `registration_date` date NOT NULL,
  `evaluation` int(1) NOT NULL,
  `restrictions` int(2) NOT NULL DEFAULT '0',
  `hasfoto` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `organizer`
--

INSERT INTO `organizer` (`oemail`, `company_name`, `bank_account`, `first_name`, `last_name`, `username`, `password`, `salt`, `phone_number`, `balance`, `street_name`, `street_number`, `town`, `postal_code`, `afm`, `registration_date`, `evaluation`, `restrictions`, `hasfoto`) VALUES
('kvol@gmail.com', 'AllForKids', '98919911', 'Κωνσταντίνος', 'Βολιώτης', 'kvol', '�v~��	N��3Y6}Z�''&', 0x954e0a9748d2ab81, '6978198001', 0, 'Αιγαίου', '22', 'Αθήνα', '15773', '0910019922', '2018-03-01', 0, 0, 1),
('nik@kids.gr', 'Kids', '999181990-11991', 'Νίκος', 'Αθανασίου', 'nath', '	\rE�l��K�F,�\0���X', 0xd07daa504ad76ceb, '6978124567', 90, '8', '3', 'Αθήνα', '17124', '0910019911', '2018-03-01', 0, 0, 1),
('npapad@gmail.com', 'ToyStory', '02929292992', 'Νίκος', 'Παπαδόπουλος', 'npap', 'ZjL����=�\0���', 0xaac516636698c0e0, '6984194988', 36, 'Μενελάου', '5', 'Αθήνα', '17125', '90019119991', '2018-03-01', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `parent`
--

CREATE TABLE `parent` (
  `pemail` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `salt` blob NOT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `balance` float DEFAULT '0',
  `last_transaction_date` date DEFAULT NULL,
  `street_name` varchar(20) NOT NULL,
  `street_number` int(3) NOT NULL,
  `town` varchar(20) NOT NULL,
  `postal_code` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `bucketId` int(5) DEFAULT NULL,
  `restrictions` int(2) NOT NULL,
  `hasfoto` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `parent`
--

INSERT INTO `parent` (`pemail`, `first_name`, `last_name`, `username`, `password`, `salt`, `phone_number`, `balance`, `last_transaction_date`, `street_name`, `street_number`, `town`, `postal_code`, `bucketId`, `restrictions`, `hasfoto`) VALUES
('apap@gmail.com', 'Άννα', 'Παπαδοπούλου', 'apap', '�H���q9��<��A7��', 0x2a72f542c79bbe69, '6974192112', 0, '2018-03-01', 'Κηφισίας', 88, 'Αθήνα', '15124', 107, 3, 1),
('ioannou@gmail.com', 'Ελένη', 'Ιωάννου', 'elen', ' l��r������ޏ?�uW', 0x950144db0b969679, '6978198001', 10, '2018-03-01', 'Δικαιάρχου', 12, 'Αθήνα', '15773', 108, 0, 0),
('marath@gmail.com', 'Μαρία', 'Αθανασίου', 'mar', 'E,��PCi\Zq''T��rryq9', 0x11ca8a8f6b6118d2, '6974192112', 80, '2018-03-01', 'Κηφισίας', 12, 'Αθήνα', '15124', 106, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `restrictions`
--

CREATE TABLE `restrictions` (
  `rid` int(5) NOT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `renum` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restrictions`
--

INSERT INTO `restrictions` (`rid`, `description`, `renum`) VALUES
(718, 'Parent cannot buy.', 1),
(719, 'Parent cannot load his wallet.', 2),
(720, 'Parent cannot load his wallet and cannot buy ticket', 3),
(721, 'Organizer cannot create an event.', 4),
(722, 'Administrator cannot assign rights.', 5),
(723, 'Administrator cannot add another Admin', 6),
(724, 'User Locked!', 7);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(5) NOT NULL,
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `type` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `type`) VALUES
(719, 'apap@gmail.com', 0),
(720, 'ioannou@gmail.com', 0),
(721, 'marath@gmail.com', 0),
(722, 'i.telali@hotmail.com', 2),
(723, 'kvol@gmail.com', 1),
(724, 'npapad@gmail.com', 1),
(725, 'nik@kids.gr', 1);

-- --------------------------------------------------------

--
-- Table structure for table `willattend`
--

CREATE TABLE `willattend` (
  `id` int(5) NOT NULL,
  `pemail` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `eventId` int(5) NOT NULL,
  `date` date NOT NULL,
  `time` time(1) NOT NULL,
  `valid` int(1) NOT NULL DEFAULT '1',
  `tickets` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `willattend`
--

INSERT INTO `willattend` (`id`, `pemail`, `eventId`, `date`, `time`, `valid`, `tickets`) VALUES
(404, 'marath@gmail.com', 2, '2018-04-12', '10:00:00.0', 1, 5),
(405, 'apap@gmail.com', 2, '2018-04-12', '10:00:00.0', 1, 3),
(406, 'ioannou@gmail.com', 3, '2018-03-28', '08:00:00.0', 1, 2),
(407, 'ioannou@gmail.com', 2, '2018-04-12', '10:00:00.0', 1, 2),
(408, 'marath@gmail.com', 3, '2018-03-28', '08:00:00.0', 1, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `bucket`
--
ALTER TABLE `bucket`
  ADD PRIMARY KEY (`bucketid`),
  ADD KEY `Fkb_pemail` (`pemail`);

--
-- Indexes for table `consistsof`
--
ALTER TABLE `consistsof`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_bucketId` (`bucketId`),
  ADD KEY `Fk2_eventId` (`eventId`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`eventid`),
  ADD KEY `event_fk_1` (`oemail`);

--
-- Indexes for table `eventinfo`
--
ALTER TABLE `eventinfo`
  ADD PRIMARY KEY (`eventinfoid`),
  ADD KEY `fk3eventid` (`eventid`);

--
-- Indexes for table `hasattended`
--
ALTER TABLE `hasattended`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk1_pemail` (`pemail`),
  ADD KEY `Fk1_eventId` (`eventId`);

--
-- Indexes for table `organizer`
--
ALTER TABLE `organizer`
  ADD PRIMARY KEY (`oemail`);

--
-- Indexes for table `parent`
--
ALTER TABLE `parent`
  ADD PRIMARY KEY (`pemail`),
  ADD KEY `parent_fk_1` (`bucketId`);

--
-- Indexes for table `restrictions`
--
ALTER TABLE `restrictions`
  ADD PRIMARY KEY (`rid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `willattend`
--
ALTER TABLE `willattend`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk_pemail` (`pemail`),
  ADD KEY `Fk_eventId` (`eventId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bucket`
--
ALTER TABLE `bucket`
  MODIFY `bucketid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;
--
-- AUTO_INCREMENT for table `consistsof`
--
ALTER TABLE `consistsof`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `eventid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `eventinfo`
--
ALTER TABLE `eventinfo`
  MODIFY `eventinfoid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `hasattended`
--
ALTER TABLE `hasattended`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=504;
--
-- AUTO_INCREMENT for table `restrictions`
--
ALTER TABLE `restrictions`
  MODIFY `rid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=725;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=726;
--
-- AUTO_INCREMENT for table `willattend`
--
ALTER TABLE `willattend`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=409;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bucket`
--
ALTER TABLE `bucket`
  ADD CONSTRAINT `Fkb_pemail` FOREIGN KEY (`pemail`) REFERENCES `parent` (`pemail`) ON DELETE CASCADE;

--
-- Constraints for table `consistsof`
--
ALTER TABLE `consistsof`
  ADD CONSTRAINT `Fk2_eventId` FOREIGN KEY (`eventId`) REFERENCES `event` (`eventid`) ON DELETE CASCADE,
  ADD CONSTRAINT `Fk_bucketId` FOREIGN KEY (`bucketId`) REFERENCES `bucket` (`bucketid`) ON DELETE CASCADE;

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_fk_1` FOREIGN KEY (`oemail`) REFERENCES `organizer` (`oemail`) ON DELETE CASCADE;

--
-- Constraints for table `eventinfo`
--
ALTER TABLE `eventinfo`
  ADD CONSTRAINT `fk3eventid` FOREIGN KEY (`eventid`) REFERENCES `event` (`eventid`) ON DELETE CASCADE;

--
-- Constraints for table `hasattended`
--
ALTER TABLE `hasattended`
  ADD CONSTRAINT `Fk1_eventId` FOREIGN KEY (`eventId`) REFERENCES `event` (`eventid`) ON DELETE CASCADE,
  ADD CONSTRAINT `Fk1_pemail` FOREIGN KEY (`pemail`) REFERENCES `parent` (`pemail`) ON DELETE CASCADE;

--
-- Constraints for table `parent`
--
ALTER TABLE `parent`
  ADD CONSTRAINT `parent_fk_1` FOREIGN KEY (`bucketId`) REFERENCES `bucket` (`bucketid`) ON DELETE CASCADE;

--
-- Constraints for table `willattend`
--
ALTER TABLE `willattend`
  ADD CONSTRAINT `Fk_eventId` FOREIGN KEY (`eventId`) REFERENCES `event` (`eventid`) ON DELETE CASCADE,
  ADD CONSTRAINT `Fk_pemail` FOREIGN KEY (`pemail`) REFERENCES `parent` (`pemail`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
