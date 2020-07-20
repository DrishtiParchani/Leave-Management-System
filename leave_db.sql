-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 22, 2018 at 05:47 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `leave_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `accept_leave_hod`
--

CREATE TABLE IF NOT EXISTS `accept_leave_hod` (
  `id` varchar(30) NOT NULL,
  `department` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `leave_type` varchar(100) NOT NULL,
  `To` varchar(50) NOT NULL,
  `from` varchar(50) NOT NULL,
  `days` varchar(30) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `doc_name` varchar(100) DEFAULT NULL,
  `allocated_cl` varchar(30) NOT NULL,
  `taken_cl` varchar(30) NOT NULL,
  `pending_cl` varchar(30) NOT NULL,
  `accept` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `accept_leave_principle`
--

CREATE TABLE IF NOT EXISTS `accept_leave_principle` (
  `id` varchar(30) NOT NULL,
  `department` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `leave_type` varchar(100) NOT NULL,
  `To` varchar(50) NOT NULL,
  `from` varchar(50) NOT NULL,
  `days` varchar(30) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `doc_name` varchar(100) DEFAULT NULL,
  `allocated_cl` varchar(30) NOT NULL,
  `taken_cl` varchar(30) NOT NULL,
  `pending_cl` varchar(30) NOT NULL,
  `accept` varchar(10) NOT NULL,
  `pri_accept` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `admin_data`
--

CREATE TABLE IF NOT EXISTS `admin_data` (
  `Id` varchar(10) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_data`
--

INSERT INTO `admin_data` (`Id`, `username`, `password`, `email`) VALUES
('VESP00041', 'admin', 'admin', 'morebhagyashree55@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `casual`
--

CREATE TABLE IF NOT EXISTS `casual` (
  `id` varchar(30) NOT NULL,
  `department` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `leave_type` varchar(100) NOT NULL,
  `To` varchar(50) NOT NULL,
  `from` varchar(50) NOT NULL,
  `days` int(30) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `doc_name` varchar(100) DEFAULT NULL,
  `allocated_cl` int(30) NOT NULL,
  `taken_cl` int(30) NOT NULL,
  `pending_cl` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `casualback`
--

CREATE TABLE IF NOT EXISTS `casualback` (
  `id` varchar(30) NOT NULL,
  `department` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `leave_type` varchar(100) NOT NULL,
  `To` varchar(50) NOT NULL,
  `from` varchar(50) NOT NULL,
  `days` int(30) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `doc_name` varchar(100) DEFAULT NULL,
  `allocated_cl` int(30) NOT NULL,
  `taken_cl` int(30) NOT NULL,
  `pending_cl` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `earn`
--

CREATE TABLE IF NOT EXISTS `earn` (
  `id` varchar(30) NOT NULL,
  `department` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `leave_type` varchar(100) NOT NULL,
  `To` varchar(50) NOT NULL,
  `from` varchar(50) NOT NULL,
  `days` int(30) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `doc_name` varchar(100) DEFAULT NULL,
  `allocated_cl` int(30) NOT NULL,
  `taken_cl` int(30) NOT NULL,
  `pending_cl` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `earnback`
--

CREATE TABLE IF NOT EXISTS `earnback` (
  `id` varchar(30) NOT NULL,
  `department` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `leave_type` varchar(100) NOT NULL,
  `To` varchar(50) NOT NULL,
  `from` varchar(50) NOT NULL,
  `days` int(30) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `doc_name` varchar(100) DEFAULT NULL,
  `allocated_cl` int(30) NOT NULL,
  `taken_cl` int(30) NOT NULL,
  `pending_cl` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hod`
--

CREATE TABLE IF NOT EXISTS `hod` (
  `id` varchar(20) NOT NULL,
  `department` varchar(50) NOT NULL,
  `fullname` varchar(500) NOT NULL,
  `mobile_no` varchar(12) NOT NULL,
  `email` varchar(100) NOT NULL,
  `add` varchar(500) NOT NULL,
  `birthday` varchar(100) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `joining_date` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `cl` int(20) NOT NULL,
  `sl` int(20) NOT NULL,
  `el` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `leave_tbl`
--

CREATE TABLE IF NOT EXISTS `leave_tbl` (
  `id` varchar(30) NOT NULL,
  `department` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `leave_type` varchar(100) NOT NULL,
  `To` varchar(50) NOT NULL,
  `from` varchar(50) NOT NULL,
  `days` int(40) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `doc_name` varchar(100) DEFAULT NULL,
  `allocated_cl` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leave_tbl`
--

INSERT INTO `leave_tbl` (`id`, `department`, `email`, `leave_type`, `To`, `from`, `days`, `description`, `doc_name`, `allocated_cl`) VALUES
('VESP000439', 'Computer Engineering', 'morebhagyashree55@gmail.com', 'Casual', '21-2-2018', '23-2-2018', 2, 'ewf', 'Hydrangeas.jpg', 10),
('VESP000417', 'Electronics & Telecommunication', 'krushikarushi55@gmail.com', 'Casual', '21-2-2018', '23-2-2018', 2, 'whw', 'Tulips.jpg', 10);

-- --------------------------------------------------------

--
-- Table structure for table `principle`
--

CREATE TABLE IF NOT EXISTS `principle` (
  `id` varchar(20) NOT NULL,
  `department` varchar(100) NOT NULL,
  `fullname` varchar(500) NOT NULL,
  `mobile_no` varchar(12) NOT NULL,
  `email` varchar(100) NOT NULL,
  `add` varchar(500) NOT NULL,
  `birthday` varchar(100) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `joining_date` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `cl` int(20) NOT NULL,
  `sl` int(20) NOT NULL,
  `el` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reject_leave_hod`
--

CREATE TABLE IF NOT EXISTS `reject_leave_hod` (
  `id` varchar(30) NOT NULL,
  `department` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `leave_type` varchar(100) NOT NULL,
  `To` varchar(50) NOT NULL,
  `from` varchar(50) NOT NULL,
  `days` int(30) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `doc_name` varchar(100) DEFAULT NULL,
  `allocated_cl` int(30) NOT NULL,
  `taken_cl` int(30) NOT NULL,
  `pending_cl` int(30) NOT NULL,
  `reject` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reject_leave_principle`
--

CREATE TABLE IF NOT EXISTS `reject_leave_principle` (
  `id` varchar(30) NOT NULL,
  `department` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `leave_type` varchar(100) NOT NULL,
  `To` varchar(50) NOT NULL,
  `from` varchar(50) NOT NULL,
  `days` varchar(30) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `doc_name` varchar(100) DEFAULT NULL,
  `allocated_cl` varchar(30) NOT NULL,
  `taken_cl` varchar(30) NOT NULL,
  `pending_cl` varchar(30) NOT NULL,
  `accept` varchar(10) NOT NULL,
  `pri_accept` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sick`
--

CREATE TABLE IF NOT EXISTS `sick` (
  `id` varchar(30) NOT NULL,
  `department` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `leave_type` varchar(100) NOT NULL,
  `To` varchar(50) NOT NULL,
  `from` varchar(50) NOT NULL,
  `days` int(30) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `doc_name` varchar(100) DEFAULT NULL,
  `allocated_cl` int(30) NOT NULL,
  `taken_cl` int(30) NOT NULL,
  `pending_cl` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sickback`
--

CREATE TABLE IF NOT EXISTS `sickback` (
  `id` varchar(30) NOT NULL,
  `department` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `leave_type` varchar(100) NOT NULL,
  `To` varchar(50) NOT NULL,
  `from` varchar(50) NOT NULL,
  `days` int(30) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `doc_name` varchar(100) DEFAULT NULL,
  `allocated_cl` int(30) NOT NULL,
  `taken_cl` int(30) NOT NULL,
  `pending_cl` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
  `id` varchar(20) NOT NULL,
  `department` varchar(50) NOT NULL,
  `fullname` varchar(500) NOT NULL,
  `mobile_no` varchar(12) NOT NULL,
  `email` varchar(100) NOT NULL,
  `add` varchar(500) NOT NULL,
  `birthday` varchar(100) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `joining_date` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `cl` int(20) NOT NULL,
  `sl` int(20) NOT NULL,
  `el` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_data`
--
ALTER TABLE `admin_data`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `hod`
--
ALTER TABLE `hod`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `principle`
--
ALTER TABLE `principle`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
