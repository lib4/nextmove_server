-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 17, 2014 at 01:26 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nextmove_db`
--
CREATE DATABASE IF NOT EXISTS `nextmove_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `nextmove_db`;

-- --------------------------------------------------------

--
-- Table structure for table `address_db`
--

CREATE TABLE IF NOT EXISTS `address_db` (
  `addressSeqNum` bigint(20) NOT NULL AUTO_INCREMENT,
  `addressId` varchar(20) NOT NULL,
  `userId` varchar(40) NOT NULL,
  `address` varchar(1024) NOT NULL,
  PRIMARY KEY (`addressSeqNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Store all address history' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bigitems_db`
--

CREATE TABLE IF NOT EXISTS `bigitems_db` (
  `bigItemSeqNum` bigint(20) NOT NULL AUTO_INCREMENT,
  `bigItemId` varchar(40) NOT NULL,
  `moveId` varchar(40) NOT NULL,
  `requiresDisassembly` tinyint(1) NOT NULL,
  `doesFitInElevator` tinyint(1) NOT NULL,
  `itemName` varchar(1024) NOT NULL,
  `itemDescription` varchar(1024) NOT NULL,
  `itemUrl` varchar(1024) NOT NULL,
  PRIMARY KEY (`bigItemSeqNum`),
  UNIQUE KEY `bigItemId` (`bigItemId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `bigitems_db`
--

INSERT INTO `bigitems_db` (`bigItemSeqNum`, `bigItemId`, `moveId`, `requiresDisassembly`, `doesFitInElevator`, `itemName`, `itemDescription`, `itemUrl`) VALUES
(2, 'e18520aa-bc6c-48ae-9d66-7bbb7278702c', 'd01e7efb-0733-4125-a97b-07bb030ed303', 1, 1, 'Sofa', 'VeryOld', 'http://localhost:8080/move_image/C:\\Program Files\\glassfish-4.0\\glassfish\\domains\\domain1\\docroot\\move_images\\/d01e7efb-0733-4125-a97b-07bb030ed303.jpg'),
(3, '5dffde4e-706c-463d-a0b4-8f2e1e270361', '9e84dac5-0338-4769-a1ce-0e2ad0e67774', 1, 1, 'Sofa', 'VeryOld', 'http://localhost:8080/move_image/C:\\Program Files\\glassfish-4.0\\glassfish\\domains\\domain1\\docroot\\move_images\\/9e84dac5-0338-4769-a1ce-0e2ad0e67774.jpg'),
(4, '489e09b0-b21e-4d19-af7b-69e2c2ecc306', '0fd3e8d1-45c0-475f-9759-5444c3d3723b', 1, 1, 'Sofa', 'VeryOld', 'http://localhost:8080/move_image/C:\\Program Files\\glassfish-4.0\\glassfish\\domains\\domain1\\docroot\\move_images\\/0fd3e8d1-45c0-475f-9759-5444c3d3723b.jpg'),
(5, '0141ed9c-1e23-4ea0-8d49-ac93138e1008', 'e5bd0ff6-df85-4b1c-9145-7402b993e41b', 1, 1, 'Sofa', 'VeryOld', 'http://localhost:8080/move_image/C:\\Program Files\\glassfish-4.0\\glassfish\\domains\\domain1\\docroot\\move_images\\/e5bd0ff6-df85-4b1c-9145-7402b993e41b.jpg'),
(6, '5ebc8811-43bb-498b-a3e9-7c1a34333b04', '98f1bc11-02b7-4f8c-9e68-9a5aea040d85', 1, 1, 'Sofa', 'VeryOld', 'http://localhost:8080/move_image/C:\\Program Files\\glassfish-4.0\\glassfish\\domains\\domain1\\docroot\\move_images\\/98f1bc11-02b7-4f8c-9e68-9a5aea040d85.jpg'),
(7, 'ac436271-b510-4f56-807c-c0dad695640f', '98f1bc11-02b7-4f8c-9e68-9a5aea040d85', 1, 1, 'Sofa', 'VeryOld', 'http://localhost:8080/move_image/C:\\Program Files\\glassfish-4.0\\glassfish\\domains\\domain1\\docroot\\move_images\\/98f1bc11-02b7-4f8c-9e68-9a5aea040d85.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `box_type_db`
--

CREATE TABLE IF NOT EXISTS `box_type_db` (
  `boxTypeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `boxType` int(1) NOT NULL,
  `boxDescription` varchar(1024) NOT NULL,
  PRIMARY KEY (`boxTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `moves_db`
--

CREATE TABLE IF NOT EXISTS `moves_db` (
  `moveSeqNum` bigint(20) NOT NULL AUTO_INCREMENT,
  `moveId` varchar(40) NOT NULL,
  `smallBoxCount` int(11) NOT NULL,
  `mediumBoxCount` int(11) NOT NULL,
  `largeBoxCount` int(11) NOT NULL,
  `sourceAddress` varchar(1024) NOT NULL,
  `destinationAddress` varchar(1024) NOT NULL,
  `isBigItemsPresent` tinyint(1) NOT NULL,
  `dispatchDate` varchar(50) DEFAULT NULL,
  `expectedReceiveDate` varchar(50) DEFAULT NULL,
  `userId` varchar(40) NOT NULL,
  `moveStatus` varchar(50) NOT NULL,
  `priceQuote` varchar(20) DEFAULT NULL,
  `conditions` varchar(1024) DEFAULT NULL,
  `rejectReason` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`moveSeqNum`),
  UNIQUE KEY `moveId` (`moveId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `moves_db`
--

INSERT INTO `moves_db` (`moveSeqNum`, `moveId`, `smallBoxCount`, `mediumBoxCount`, `largeBoxCount`, `sourceAddress`, `destinationAddress`, `isBigItemsPresent`, `dispatchDate`, `expectedReceiveDate`, `userId`, `moveStatus`, `priceQuote`, `conditions`, `rejectReason`) VALUES
(4, 'd01e7efb-0733-4125-a97b-07bb030ed303', 10, 10, 10, 'bangalore', 'Kerala', 1, '10-10-2014', '15-10-2014', '38bdceac-1289-4b2c-95b7-9e7572c4dc6c', 'ACCEPTED', '100$', 'nothing', '  '),
(5, '9e84dac5-0338-4769-a1ce-0e2ad0e67774', 10, 10, 10, 'bangalore', 'Kerala', 1, '10-10-2014', '15-10-2014', '38bdceac-1289-4b2c-95b7-9e7572c4dc6c', 'REJECTED', '', '', ' High cost '),
(6, '0fd3e8d1-45c0-475f-9759-5444c3d3723b', 10, 10, 10, 'bangalore', 'Kerala', 1, '10-10-2014', '15-10-2014', '38bdceac-1289-4b2c-95b7-9e7572c4dc6c', 'PENDING', '', '', ''),
(7, 'e5bd0ff6-df85-4b1c-9145-7402b993e41b', 10, 10, 10, 'bangalore', 'Kerala', 1, '10-10-2014', '15-10-2014', '38bdceac-1289-4b2c-95b7-9e7572c4dc6c', 'PENDING', '', '', ''),
(8, '98f1bc11-02b7-4f8c-9e68-9a5aea040d85', 10, 10, 10, 'bangalore', 'Kerala', 1, '10-10-2014', '15-10-2014', '38bdceac-1289-4b2c-95b7-9e7572c4dc6c', 'PENDING QUOTE', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `user_db`
--

CREATE TABLE IF NOT EXISTS `user_db` (
  `userSegNum` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(40) NOT NULL,
  `emailAddress` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `address` varchar(1024) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  `isEmailVerified` tinyint(1) NOT NULL DEFAULT '0',
  `isPhoneVerified` tinyint(1) NOT NULL DEFAULT '0',
  `name` varchar(256) NOT NULL,
  PRIMARY KEY (`userSegNum`),
  UNIQUE KEY `userId` (`userId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='User registration table' AUTO_INCREMENT=3 ;

--
-- Dumping data for table `user_db`
--

INSERT INTO `user_db` (`userSegNum`, `userId`, `emailAddress`, `password`, `address`, `phoneNumber`, `isEmailVerified`, `isPhoneVerified`, `name`) VALUES
(2, '38bdceac-1289-4b2c-95b7-9e7572c4dc6c', 'anaschaky@gmail.com', '12345678', 'India', '9886881467', 0, 0, ' John carey ');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
