-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 28, 2018 at 06:11 PM
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
  `createdat` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `restrictions` int(2) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `organizer`
--

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
  `restrictions` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `parent`
--

-- --------------------------------------------------------

--
-- Table structure for table `restrictions`
--

CREATE TABLE `restrictions` (
  `rid` int(5) NOT NULL,
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `enum` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restrictions`
--

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
  ADD PRIMARY KEY (`eventinfoid`);

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
  MODIFY `bucketid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;
--
-- AUTO_INCREMENT for table `consistsof`
--
ALTER TABLE `consistsof`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `eventid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `eventinfo`
--
ALTER TABLE `eventinfo`
  MODIFY `eventinfoid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `hasattended`
--
ALTER TABLE `hasattended`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=504;
--
-- AUTO_INCREMENT for table `restrictions`
--
ALTER TABLE `restrictions`
  MODIFY `rid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=718;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=719;
--
-- AUTO_INCREMENT for table `willattend`
--
ALTER TABLE `willattend`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=404;
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