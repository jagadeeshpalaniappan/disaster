-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 27, 2017 at 11:44 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `disaster_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `incident`
--

CREATE TABLE `incident` (
  `USER_ID` int(100) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `MOBILE` varchar(10) NOT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `DESCRIPTION` varchar(300) NOT NULL,
  `INCIDENT_TYPE_ID` int(100) NOT NULL,
  `LOCATION_ID` int(100) NOT NULL,
  `MESSAGE_STATUS` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `incident`
--

INSERT INTO `incident` (`USER_ID`, `NAME`, `MOBILE`, `EMAIL`, `DESCRIPTION`, `INCIDENT_TYPE_ID`, `LOCATION_ID`, `MESSAGE_STATUS`) VALUES
(1, 'sunar', '212233', '', '', 101, 122, 0),
(2, 'sundar', '1213', '', '', 101, 211, 0),
(15, 'sundadw', '1211', '', '', 101, 101, 0),
(16, 'sundadw', '1221', '', '', 101, 101, 0),
(17, 'aaa2113', '31314', '', '', 101, 101, 0),
(18, 'aaa2113', '31314', '', '', 101, 101, 0),
(19, 'saran s', '1234', '', '', 101, 101, 0),
(20, 'saran s', '1234', '', '', 101, 101, 0),
(21, 'sunadr', '131', '', '', 101, 101, 0),
(22, '121', '212', '', '', 101, 101, 0),
(23, 'sundar123', '123', '', '', 101, 101, 0),
(24, 'sundaramoorthi', '123', '', '', 101, 101, 0),
(25, 'sundar', '1234567890', '', '', 101, 101, 0),
(26, 'sunadr', '123', '', '', 101, 101, 0),
(27, 'sunadr', '123', '', '', 101, 101, 0),
(28, 'sundar', '8220190969', '', '', 101, 101, 0),
(29, 'sundar', 'sas', '', '', 101, 101, 0),
(30, 'sundar', '1234567890', '', '', 101, 101, 0),
(31, 'sundar', '34', '', '', 101, 101, 0),
(32, 'sunadr', '1213', '', 'hi guys this sundar', 101, 101, 0),
(33, 'sundar', '1243', '', 'dei nanthan da', 101, 101, 0),
(34, 'sundar', '345', '', 'vanthuru vanthuru', 101, 101, 0),
(35, 'sundar', '132', '', 'saran', 101, 101, 0),
(36, 'sundaramoorthi', '8220190969', '', 'dfggdg', 101, 102, 0),
(37, 'st', '657', '', 'hv', 101, 102, 0),
(38, 'sundar', '132', '', 'vdfdf', 101, 102, 0),
(39, 'sundar', '7657665', '', 'saran', 101, 102, 0),
(40, 'sdf', '678', '', 'saran', 101, 102, 0);

-- --------------------------------------------------------

--
-- Table structure for table `incident_incharge`
--

CREATE TABLE `incident_incharge` (
  `INCHARGE_ID` int(100) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `MOBILE` varchar(10) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `DESIGNATION` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `incident_incharge`
--

INSERT INTO `incident_incharge` (`INCHARGE_ID`, `NAME`, `MOBILE`, `EMAIL`, `DESIGNATION`) VALUES
(221, 'sundar', '8220190969', 'sundarttp@gmail.com', 'DRO'),
(222, 'saran', '8220190969', 'sundarbtechict@gmail.com', 'vao'),
(312, 'jagan', '8220190969', 'sundarttp@gmail.com', 'vao'),
(912, 'sangeth', '8220230969', 'aravind.j412@gmail.com', 'vao');

-- --------------------------------------------------------

--
-- Table structure for table `incident_mapping`
--

CREATE TABLE `incident_mapping` (
  `LOCATION_ID` int(100) NOT NULL,
  `INCIDENT_TYPE_ID` int(100) NOT NULL,
  `INCHARGE_ID` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `incident_mapping`
--

INSERT INTO `incident_mapping` (`LOCATION_ID`, `INCIDENT_TYPE_ID`, `INCHARGE_ID`) VALUES
(101, 101, 221),
(101, 101, 222),
(102, 101, 222),
(102, 101, 221),
(101, 101, 312),
(101, 101, 912);

-- --------------------------------------------------------

--
-- Table structure for table `incident_type`
--

CREATE TABLE `incident_type` (
  `INCIDENT_TYPE_ID` int(100) NOT NULL,
  `NAME` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `incident_type`
--

INSERT INTO `incident_type` (`INCIDENT_TYPE_ID`, `NAME`) VALUES
(101, 'flood');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `LOCATION_ID` int(100) NOT NULL,
  `VILLAGE` varchar(50) NOT NULL,
  `TALUK` varchar(50) NOT NULL,
  `DISTRICT` varchar(50) NOT NULL,
  `STATE` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`LOCATION_ID`, `VILLAGE`, `TALUK`, `DISTRICT`, `STATE`) VALUES
(101, 'vallam', 'thanjavur', 'thanjavur', 'tamilnadu'),
(102, 'thirumalaisamuthiram', 'thanjavur', 'thanjavur', 'tamilnadu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `incident`
--
ALTER TABLE `incident`
  ADD PRIMARY KEY (`USER_ID`),
  ADD UNIQUE KEY `USER_ID` (`USER_ID`);

--
-- Indexes for table `incident_incharge`
--
ALTER TABLE `incident_incharge`
  ADD PRIMARY KEY (`INCHARGE_ID`);

--
-- Indexes for table `incident_type`
--
ALTER TABLE `incident_type`
  ADD PRIMARY KEY (`INCIDENT_TYPE_ID`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`LOCATION_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `incident`
--
ALTER TABLE `incident`
  MODIFY `USER_ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `incident_incharge`
--
ALTER TABLE `incident_incharge`
  MODIFY `INCHARGE_ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=913;
--
-- AUTO_INCREMENT for table `incident_type`
--
ALTER TABLE `incident_type`
  MODIFY `INCIDENT_TYPE_ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;
--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `LOCATION_ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
