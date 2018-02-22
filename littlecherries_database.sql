-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2018 at 08:31 PM
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
  `email` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `account` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`email`, `first_name`, `last_name`, `username`, `password`, `phone_number`, `account`) VALUES
('admin@littlecherries', 'Κοσμάς', 'Στεφανόπουλος', 'kostef', 'admin', '6978874512', '123-456-789');

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
(1, 'apap@gmail.com', 0, 0),
(3, 'nap@gmail.com', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `consistsof`
--

CREATE TABLE `consistsof` (
  `id` int(5) NOT NULL,
  `bucketId` int(5) NOT NULL,
  `eventId` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `eventid` int(5) NOT NULL,
  `oemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `organizer_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `event_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `event_cost` int(3) NOT NULL,
  `street_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street_number` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `town` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `postal_code` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `event_class` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `event_description` text COLLATE utf8_unicode_ci,
  `evaluation` int(3) NOT NULL DEFAULT '0',
  `isdone` int(1) NOT NULL DEFAULT '0',
  `longitude` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `latitude` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `startage` int(11) NOT NULL,
  `endage` int(11) NOT NULL,
  `duration` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`eventid`, `oemail`, `organizer_name`, `event_name`, `event_cost`, `street_name`, `street_number`, `town`, `postal_code`, `event_class`, `event_description`, `evaluation`, `isdone`, `longitude`, `latitude`, `startage`, `endage`, `duration`) VALUES
(22, 'nik@kids.gr', 'Kids', 'partyy', 12, 'Khfisias', '20', 'Athens', '14111', NULL, NULL, 0, 0, NULL, NULL, 3, 5, 0),
(32, 'nik@kids.gr', 'Kids', 'nik', 10, NULL, '0', NULL, NULL, NULL, NULL, 0, 0, NULL, NULL, 5, 8, 0);

-- --------------------------------------------------------

--
-- Table structure for table `eventinfo`
--

CREATE TABLE `eventinfo` (
  `eventinfoId` int(5) NOT NULL,
  `eventid` int(5) NOT NULL,
  `eventdate` date DEFAULT NULL,
  `availabletickets` int(5) NOT NULL DEFAULT '0',
  `starttime` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `eventinfo`
--

INSERT INTO `eventinfo` (`eventinfoId`, `eventid`, `eventdate`, `availabletickets`, `starttime`) VALUES
(110, 22, '2018-02-09', 5, '10:10:00'),
(112, 32, '2018-02-28', 4, '00:11:00');

-- --------------------------------------------------------

--
-- Table structure for table `hasattended`
--

CREATE TABLE `hasattended` (
  `id` int(5) NOT NULL,
  `pemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `eventId` int(5) NOT NULL,
  `isfavorite` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `organizer`
--

CREATE TABLE `organizer` (
  `oemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `company_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `bank_account` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `balance` int(5) NOT NULL,
  `street_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street_number` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `town` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `postal_code` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `afm` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `registration_date` date NOT NULL,
  `evaluation` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `organizer`
--

INSERT INTO `organizer` (`oemail`, `company_name`, `bank_account`, `first_name`, `last_name`, `username`, `password`, `phone_number`, `balance`, `street_name`, `street_number`, `town`, `postal_code`, `afm`, `registration_date`, `evaluation`) VALUES
('apap@threepigs.gr', 'kalispera', '839138811', 'Anna', 'Papadopoulou', 'apap', '71118', '6982181121', 0, 'Khfisias', '10', 'Athens', '15773', '18821121', '2018-02-01', 0),
('bill@allou.gr', 'Allou', '135138377313', 'Bill', 'Markou', 'bmar', '444', '6975221287', 0, 'Artakis', '5', 'Athens', '17124', '813798731', '2018-01-25', 0),
('maraki@bob.gr', 'bobomastoras', '90919212', 'Maria', 'Papakh', 'mapa', '91102', '6982181121', 0, 'Khfisias', '12', 'Athens', '15773', 'jhddd1111', '2018-02-01', 0),
('maria@papakia.com', 'Papakia', '13332411422', 'Maria', 'Papadopoulou', 'mapa', '1111', '677677776', 0, 'Sina', '20', 'Athens', '15773', '7177313', '2018-01-08', 0),
('nik@kids.gr', 'Kids', '32313131', 'Nikos', 'Babis', 'bab', '2222', '892282828', 0, 'Mesogeiwn', '12', 'Athens', '12311', '71277213', '2018-02-05', 0);

-- --------------------------------------------------------

--
-- Table structure for table `parent`
--

CREATE TABLE `parent` (
  `pemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `balance` int(5) DEFAULT NULL,
  `last_transaction_date` date DEFAULT NULL,
  `street_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `street_number` int(3) NOT NULL,
  `town` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `postal_code` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `bucketId` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `parent`
--

INSERT INTO `parent` (`pemail`, `first_name`, `last_name`, `username`, `password`, `phone_number`, `balance`, `last_transaction_date`, `street_name`, `street_number`, `town`, `postal_code`, `bucketId`) VALUES
('apap@gmail.com', 'Anna', 'Papadopoulou', 'apap', '1267', '6971235111', 0, NULL, 'Aiolou', 5, 'Athens', '17145', 1),
('nap@gmail.com', 'Nikos', 'Apostolou', 'nap', '1111', '693822111', 0, NULL, 'Khfisias', 12, 'Athens', '15773', 3);

-- --------------------------------------------------------

--
-- Table structure for table `willattend`
--

CREATE TABLE `willattend` (
  `id` int(5) NOT NULL,
  `pemail` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `eventId` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  ADD KEY `Fk_oemail` (`oemail`);

--
-- Indexes for table `eventinfo`
--
ALTER TABLE `eventinfo`
  ADD PRIMARY KEY (`eventinfoId`),
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
  ADD PRIMARY KEY (`pemail`);

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
  MODIFY `bucketid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `consistsof`
--
ALTER TABLE `consistsof`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `eventid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `eventinfo`
--
ALTER TABLE `eventinfo`
  MODIFY `eventinfoId` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=113;
--
-- AUTO_INCREMENT for table `hasattended`
--
ALTER TABLE `hasattended`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `willattend`
--
ALTER TABLE `willattend`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
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
  ADD CONSTRAINT `Fk_oemail` FOREIGN KEY (`oemail`) REFERENCES `organizer` (`oemail`) ON DELETE CASCADE;

--
-- Constraints for table `eventinfo`
--
ALTER TABLE `eventinfo`
  ADD CONSTRAINT `fk3eventid` FOREIGN KEY (`eventId`) REFERENCES `event` (`eventid`) ON DELETE CASCADE;

--
-- Constraints for table `hasattended`
--
ALTER TABLE `hasattended`
  ADD CONSTRAINT `Fk1_eventId` FOREIGN KEY (`eventId`) REFERENCES `event` (`eventid`) ON DELETE CASCADE,
  ADD CONSTRAINT `Fk1_pemail` FOREIGN KEY (`pemail`) REFERENCES `parent` (`pemail`) ON DELETE CASCADE;

--
-- Constraints for table `willattend`
--
ALTER TABLE `willattend`
  ADD CONSTRAINT `Fk_eventId` FOREIGN KEY (`eventId`) REFERENCES `event` (`eventid`) ON DELETE CASCADE,
  ADD CONSTRAINT `Fk_pemail` FOREIGN KEY (`pemail`) REFERENCES `parent` (`pemail`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
