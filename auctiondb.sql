-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 26, 2023 at 02:48 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `auctiondb`
--

-- --------------------------------------------------------

--
-- Table structure for table `auctiondetailtb`
--

CREATE TABLE `auctiondetailtb` (
  `auctionId` int(255) NOT NULL,
  `auctioneerId` varchar(255) NOT NULL,
  `tornamentId` int(255) NOT NULL,
  `date` date NOT NULL,
  `eachPlayerBasePrice` bigint(255) NOT NULL,
  `bidIncrementAmount` int(255) NOT NULL,
  `totalPurse` bigint(255) NOT NULL,
  `minPlayer` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `auctioneermaster`
--

CREATE TABLE `auctioneermaster` (
  `auctioneerId` varchar(255) NOT NULL,
  `mobileNumber` bigint(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `battingtypemaster`
--

CREATE TABLE `battingtypemaster` (
  `battingTypeId` int(255) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bowlingtypemaster`
--

CREATE TABLE `bowlingtypemaster` (
  `bowlingTypeId` int(255) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `organizermaster`
--

CREATE TABLE `organizermaster` (
  `organizerId` varchar(255) NOT NULL,
  `mobileNumber` bigint(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `playermaster`
--

CREATE TABLE `playermaster` (
  `playerId` varchar(255) NOT NULL,
  `mobileNumber` bigint(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `photo` mediumblob NOT NULL,
  `bowlingType` varchar(255) NOT NULL,
  `battingType` varchar(255) NOT NULL,
  `battingPosition` varchar(255) NOT NULL,
  `age` int(255) NOT NULL,
  `isWicketkeeper` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `playermaster`
--

INSERT INTO `playermaster` (`playerId`, `mobileNumber`, `name`, `photo`, `bowlingType`, `battingType`, `battingPosition`, `age`, `isWicketkeeper`) VALUES
('raj332', 9724140616, 'raj patel', '', 'sdasda', 'asdasda', 'asdasdasda', 21, 0);

-- --------------------------------------------------------

--
-- Table structure for table `projectgroups`
--

CREATE TABLE `projectgroups` (
  `groupName` varchar(255) NOT NULL,
  `userId` varchar(255) NOT NULL,
  `groupId` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `projectusers`
--

CREATE TABLE `projectusers` (
  `userId` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `soldplayertb`
--

CREATE TABLE `soldplayertb` (
  `playerId` varchar(255) NOT NULL,
  `teamId` int(255) NOT NULL,
  `soldAmount` bigint(255) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `teammaster`
--

CREATE TABLE `teammaster` (
  `teamId` int(255) NOT NULL,
  `teamName` varchar(255) NOT NULL,
  `totalPurse` bigint(255) NOT NULL,
  `teamLogo` blob NOT NULL,
  `ownerId` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `teamownermaster`
--

CREATE TABLE `teamownermaster` (
  `ownerId` varchar(255) NOT NULL,
  `mobileNumber` bigint(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tournamentplayerslist`
--

CREATE TABLE `tournamentplayerslist` (
  `playerId` varchar(255) NOT NULL,
  `playerStatus` varchar(255) NOT NULL,
  `tournamentId` int(255) NOT NULL,
  `isApproved` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tournamenttb`
--

CREATE TABLE `tournamenttb` (
  `tournamentId` int(255) NOT NULL,
  `tournamentName` varchar(255) NOT NULL,
  `startingDate` date NOT NULL,
  `organizerId` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `unsoldplayertb`
--

CREATE TABLE `unsoldplayertb` (
  `playerId` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `tournamentId` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auctiondetailtb`
--
ALTER TABLE `auctiondetailtb`
  ADD PRIMARY KEY (`auctionId`),
  ADD KEY `fk1` (`auctioneerId`),
  ADD KEY `fk3` (`tornamentId`);

--
-- Indexes for table `auctioneermaster`
--
ALTER TABLE `auctioneermaster`
  ADD PRIMARY KEY (`auctioneerId`);

--
-- Indexes for table `battingtypemaster`
--
ALTER TABLE `battingtypemaster`
  ADD PRIMARY KEY (`battingTypeId`);

--
-- Indexes for table `bowlingtypemaster`
--
ALTER TABLE `bowlingtypemaster`
  ADD PRIMARY KEY (`bowlingTypeId`);

--
-- Indexes for table `organizermaster`
--
ALTER TABLE `organizermaster`
  ADD PRIMARY KEY (`organizerId`);

--
-- Indexes for table `playermaster`
--
ALTER TABLE `playermaster`
  ADD PRIMARY KEY (`playerId`);

--
-- Indexes for table `projectgroups`
--
ALTER TABLE `projectgroups`
  ADD PRIMARY KEY (`groupId`),
  ADD KEY `frk5` (`userId`);

--
-- Indexes for table `projectusers`
--
ALTER TABLE `projectusers`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `soldplayertb`
--
ALTER TABLE `soldplayertb`
  ADD PRIMARY KEY (`playerId`);

--
-- Indexes for table `teammaster`
--
ALTER TABLE `teammaster`
  ADD PRIMARY KEY (`teamId`),
  ADD KEY `fk9` (`ownerId`);

--
-- Indexes for table `teamownermaster`
--
ALTER TABLE `teamownermaster`
  ADD PRIMARY KEY (`ownerId`);

--
-- Indexes for table `tournamentplayerslist`
--
ALTER TABLE `tournamentplayerslist`
  ADD PRIMARY KEY (`playerId`);

--
-- Indexes for table `tournamenttb`
--
ALTER TABLE `tournamenttb`
  ADD PRIMARY KEY (`tournamentId`),
  ADD KEY `frk8` (`organizerId`);

--
-- Indexes for table `unsoldplayertb`
--
ALTER TABLE `unsoldplayertb`
  ADD PRIMARY KEY (`playerId`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `auctiondetailtb`
--
ALTER TABLE `auctiondetailtb`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`auctioneerId`) REFERENCES `auctioneermaster` (`auctioneerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk3` FOREIGN KEY (`tornamentId`) REFERENCES `tournamenttb` (`tournamentId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `projectgroups`
--
ALTER TABLE `projectgroups`
  ADD CONSTRAINT `frk5` FOREIGN KEY (`userId`) REFERENCES `projectusers` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `soldplayertb`
--
ALTER TABLE `soldplayertb`
  ADD CONSTRAINT `fk6` FOREIGN KEY (`playerId`) REFERENCES `playermaster` (`playerId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `teammaster`
--
ALTER TABLE `teammaster`
  ADD CONSTRAINT `fk9` FOREIGN KEY (`ownerId`) REFERENCES `teamownermaster` (`ownerId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tournamentplayerslist`
--
ALTER TABLE `tournamentplayerslist`
  ADD CONSTRAINT `frk9` FOREIGN KEY (`playerId`) REFERENCES `playermaster` (`playerId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tournamenttb`
--
ALTER TABLE `tournamenttb`
  ADD CONSTRAINT `frk8` FOREIGN KEY (`organizerId`) REFERENCES `organizermaster` (`organizerId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `unsoldplayertb`
--
ALTER TABLE `unsoldplayertb`
  ADD CONSTRAINT `fk` FOREIGN KEY (`playerId`) REFERENCES `playermaster` (`playerId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
