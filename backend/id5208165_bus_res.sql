-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 04, 2016 at 05:28 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bus_reservation`
--

-- --------------------------------------------------------

--
-- Table structure for table `manage_payment`
--

CREATE TABLE IF NOT EXISTS `manage_payment` (
  `payment_id` int(100) NOT NULL AUTO_INCREMENT,
  `usar_id` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `zip` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `card_no` varchar(50) NOT NULL,
  `account_name` varchar(50) NOT NULL,
  `month` varchar(50) NOT NULL,
  `year` varchar(50) NOT NULL,
  `cvv_no` varchar(50) NOT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `manage_payment`
--

INSERT INTO `manage_payment` (`payment_id`, `usar_id`, `name`, `email`, `contact`, `zip`, `city`, `address`, `card_no`, `account_name`, `month`, `year`, `cvv_no`) VALUES
(1, 'android.support.v7.widget.AppCompatTextView{424c6b', 'absh', 'vvv@gmail.com', '9865326598', '858589', 'hshdjd', 'gshhs', '98656598659', 'bsbbshh', '6', '199', '546464'),
(2, 'android.support.v7.widget.AppCompatTextView{424c6b', 'absh', 'vvv@gmail.com', '9865326598', '858589', 'hshdjd', 'gshhs', '98656598659', 'bsbbshh', '6', '199', '546464'),
(3, 'android.support.v7.widget.AppCompatTextView{424c6b', '', '', '', '', '', '', '', '', '', '', ''),
(4, '107', 'kaam', 'kak@gmai.com', '9653265986', '65959', 'kdjdj', 'jdjj', '959595965959959', 'ndnnn', '6', '1999', '95966599995695995'),
(5, '108', 'lalu', 'lal@gmail.com', '9865326598', '65661', 'jfjjf', 'gdh', '656656', 'jsvvx', '6', '1999', '889956665'),
(6, '108', '', '', '', '', '', '', '', '', '', '', ''),
(7, '108', '', '', '', '', '', '', '', '', '', '', ''),
(8, '108', '', '', '', '', '', '', '', '', '', '', ''),
(9, '108', '', '', '', '', '', '', '', '', '', '', ''),
(10, '108', '', '', '', '', '', '', '', '', '', '', ''),
(11, '108', 'ndnn', 'nn@gmail.com', '989', '95959', 'ndnx', 'bdnn', '9899', 'ddnncn', '6', '1992', '9499595'),
(12, '108', 'ndnn', 'nn@gmail.com', '989', '95959', 'ndnx', 'bdnn', '9899', 'ddnncn', '6', '1992', '9499595'),
(13, '', '', '', '', '', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE IF NOT EXISTS `route` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `designation` varchar(50) NOT NULL,
  `source` varchar(50) NOT NULL,
  `range` varchar(50) NOT NULL,
  `price` varchar(50) NOT NULL,
  `departure_time` varchar(50) NOT NULL,
  `arrival_time` varchar(50) NOT NULL,
  `bus_no` varchar(50) NOT NULL,
  `day` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`id`, `designation`, `source`, `range`, `price`, `departure_time`, `arrival_time`, `bus_no`, `day`) VALUES
(1, 'Kanpur', 'Lucknow', '80', '500', '1:00 ', '3:00', 'UP78BC9221', 'sun,wed,fri'),
(2, 'Lucknow', 'Agra', '575', '1000', '9:00', '16:00', 'UP78BH6412', ''),
(3, 'Agra', 'Banda', '1100', '1800', '14:00', '22:00', 'UP32GH5487', ''),
(4, 'kanpur', 'Jhasi', '2800', '6400', '13:00', '24:00', '', ''),
(5, 'Kanpur', 'Lucknow', '80', '500', '4:00', '7:00', 'UP32AP4754', 'mon,thus,sat');

-- --------------------------------------------------------

--
-- Table structure for table `states`
--

CREATE TABLE IF NOT EXISTS `states` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `states` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `states`
--

INSERT INTO `states` (`id`, `states`) VALUES
(1, 'Kanpur'),
(2, 'Lucknow'),
(3, 'Agra'),
(4, 'Jhasi'),
(7, 'Banda'),
(8, 'Mumbai'),
(9, 'Dehradun'),
(10, 'Nainital');

-- --------------------------------------------------------

--
-- Table structure for table `travel`
--

CREATE TABLE IF NOT EXISTS `travel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `headoffice` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `emailid` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `travel`
--

INSERT INTO `travel` (`id`, `name`, `headoffice`, `phone`, `emailid`) VALUES
(1, 'Shatabdi', 'kanpur', '0512255532', 'shatabdi231@gmail.com'),
(2, 'Arora', 'Agra', '45789612552', 'arora5457@gmail.com'),
(3, 'Volvo', 'Lucknow', '9919395784', 'volvo541@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `usar_details`
--

CREATE TABLE IF NOT EXISTS `usar_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `route_id` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `age` varchar(20) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `remain_seat` varchar(50) NOT NULL,
  `booking_day` varchar(50) NOT NULL,
  `booking_date` varchar(50) NOT NULL,
  `order_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=119 ;

--
-- Dumping data for table `usar_details`
--

INSERT INTO `usar_details` (`id`, `route_id`, `email`, `mobile`, `name`, `age`, `gender`, `remain_seat`, `booking_day`, `booking_date`, `order_date`) VALUES
(1, '', '', '', '', '', '', '', '', '0000-00-00', '0000-00-00'),
(2, '', '', '', '', '', '', '', '', '0000-00-00', '0000-00-00'),
(3, '', '', '', '', '', '', '', '', '0000-00-00', '0000-00-00'),
(4, '', '', '', '', '', '', '', '', '0000-00-00', '0000-00-00'),
(5, '', '', '', '', '', '', '', '', '0000-00-00', '0000-00-00'),
(6, '', '', '', '', '', '', '', '', '0000-00-00', '0000-00-00'),
(7, '', 'a@gmail.com', '54548578', 'ashu', '23', '', '5', '', '0000-00-00', '0000-00-00'),
(8, '', 'a@gmail.com', '54548578', 'ashu', '23', '', '5', '', '0000-00-00', '0000-00-00'),
(9, '', 'a@gmail.com', '54548578', 'ashu', '23', '', '5', '', '0000-00-00', '0000-00-00'),
(10, '', 'a@gmail.com', '54548578', 'ashu', '23', '', '5', '', '0000-00-00', '0000-00-00'),
(11, '', 'a@gmail.com', '54548578', 'ashu', '23', '', '5', '', '0000-00-00', '0000-00-00'),
(12, '', 'a@gmail.com', '54548578', 'ashu', '23', '', '5', '', '0000-00-00', '0000-00-00'),
(13, '', 'a@gmail.com', '54548578', 'ashu', '23', '', '5', '', '0000-00-00', '0000-00-00'),
(14, '', 'a@gmail.com', '54548578', 'ashu', '23', '', '5', '', '0000-00-00', '0000-00-00'),
(15, '', 'a@gmail.com', '54548578', 'ashu', '23', '', '5', '', '0000-00-00', '0000-00-00'),
(16, '', 'as', '2325', 'ashu', '23', '', '3', '', '0000-00-00', '0000-00-00'),
(17, '', 'as', '2325', 'ashu', '23', '', '3', '', '0000-00-00', '0000-00-00'),
(18, '', 'a', '54645', 'atwt', '54', 'radioSexGroup', '2', '', '0000-00-00', '0000-00-00'),
(19, '', 'sfs', '212132', 'wtetye', '54', 'radioSexGroup', '2', '', '0000-00-00', '0000-00-00'),
(20, '', 'sfs', '212132', 'wtetye', '54', 'radioSexGroup', '2', '', '0000-00-00', '0000-00-00'),
(21, '', 'sfs', '212132', 'wtetye', '54', 'radioSexGroup', '2', '', '0000-00-00', '0000-00-00'),
(22, '', 'dff', '888', 'dvvvb', '5', 'Female', '2', '', '0000-00-00', '0000-00-00'),
(23, '', 'dff', '888', 'dvvvb', '5', 'Male', '2', '', '0000-00-00', '0000-00-00'),
(24, '', 'xgtcg', '88985', 'xgh', '8', 'Female', '23', '', '0000-00-00', '0000-00-00'),
(25, '', 'sgsdd', '87848', 'svzvz', '87849', 'Male', '56', '', '0000-00-00', '0000-00-00'),
(26, '', '', '', '', '', '', '', '', '0000-00-00', '0000-00-00'),
(27, '', '', '', '', '', '', '', '', '0000-00-00', '0000-00-00'),
(28, '', 'bsbvs', '94984', 'vVvz', '07887', '', '84884', '', '0000-00-00', '0000-00-00'),
(29, '', 'hshhsh', '649848', 'vzvsb', '949798', 'Female', '3164665', '', '0000-00-00', '0000-00-00'),
(30, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(31, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(32, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(33, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(34, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(35, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(36, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(37, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(38, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(39, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(40, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(41, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(42, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(43, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(44, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(45, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(46, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(47, '', '', '', '', '', 'Male', '', '', '0000-00-00', '0000-00-00'),
(48, '', 'hshhs', '9653569856965', 'as', '25', 'Male', '2', '2', '0000-00-00', '0000-00-00'),
(49, '', '', '', 'fghh', '', 'Male', '2', '2', '0000-00-00', '0000-00-00'),
(50, '', '', '', 'fgh', '', 'Male', '2', '27/3/2016', '0000-00-00', '0000-00-00'),
(51, '5', '', '', 'cvbb', '', 'Male', '2', '27/3/2016', '0000-00-00', '0000-00-00'),
(52, '5', 'ashu@gmail.com', '9580569540', 'ashu', '25', 'Male', '2', '31/3/2016', '0000-00-00', '0000-00-00'),
(53, '5', 'hsbs@gmail.com', '9580563540', 'csbsb', '52', 'Male', '1', '31/3/2016', '0000-00-00', '0000-00-00'),
(54, '5', 'amit@gmail.com', '9580569542', 'amit', '5', 'Male', '5', '31/3/2016', '0000-00-00', '2016-03-27'),
(57, '5', 'hdh@gmail.com', '8965357845', 'vsbhd', '94', 'Male', '1', '27/3/2016', '0000-00-00', '2016-03-27'),
(58, '5', 'hdhhd@gmail.com', '9865356895', 'bsbshs', '5', 'Male', 'Select Seat', '27/3/2016', '0000-00-00', '2016-03-27'),
(59, '5', 'a@gmail.com', '9868956835', 'bsbs', '6', 'Male', '1', '27/3/2016', '0000-00-00', '2016-03-27'),
(60, '', '', '', '', '', '', '', '', '0000-00-00', '2016-03-27'),
(61, '5', 'a@gmail.com', '9568659836', 'gshs', '6', 'Male', '2', 'Thursday', '0000-00-00', '2016-03-27'),
(62, '1', 'a@gmail.com', '9865986598', 'csgs', '5', 'Male', '1', 'Sun', '0000-00-00', '2016-03-27'),
(63, '1', 'a@gmail.com', '9865329865', 'vxvd', '6', 'Male', '2', 'Sun', '0000-00-00', '2016-03-27'),
(64, '1', 'a@gmail.com', '9865986598', 'ashu', '65', 'Male', '2', 'Wed', '0000-00-00', '2016-03-29'),
(65, '5', 'amit@gmail.com', '9568956896', 'gshdh', '98', 'Male', '2', 'Tue', '0000-00-00', '2016-03-29'),
(66, '5', 'amit@gmail.com', '9865986598', 'amit', '65', 'Male', '2', 'Tue', '29/3/2016', '2016-03-29'),
(67, '5', 'a@gmail.com', '9865656895', 'bshd', '6', 'Male', '2', 'Tue', '29/3/2016', '2016-03-29'),
(68, '5', 'asp@gmail.com', '9865329865', 'vsbd', '65', 'Male', '2', 'Tue', '29/3/2016', '2016-03-29'),
(69, '1', 'ni@gmail.com', '9865329865', 'bshd', '6', 'Male', '1', 'Tue', '29/3/2016', '2016-03-29'),
(70, '1', 'g@gmail.com', '9865329865', 'dj', '4', 'Male', '1', 'Tue', '29/3/2016', '2016-03-29'),
(71, '1', 'gau@gmail.com', '9865326598', 'hsh', '6', 'Male', '2', 'Tue', '29/3/2016', '2016-03-29'),
(72, '1', 'nit@gmail.com', '9865326598', 'gshs', '6', 'Male', '2', 'Tue', '29/3/2016', '2016-03-29'),
(73, '1', 'japan@gmail.com', '9865326598', 'hdhd', '6', 'Male', '2', 'Tue', '29/3/2016', '2016-03-29'),
(74, '1', 'ano@gmail.com', '9865329865', 'hsh', '6', 'Male', '2', 'Wed', '30/3/2016', '2016-03-30'),
(75, '1', 'gop@gmail.com', '9658659865', 'hdh', '6', 'Male', '2', 'Wed', '30/3/2016', '2016-03-30'),
(76, '1', 'ajeeb@gmail.com', '9632589632', 'gdh', '6', 'Male', '1', 'Wed', '30/3/2016', '2016-03-30'),
(77, '1', 'kam@gmail.com', '9658965983', 'fzg', '6', 'Male', '1', 'Wed', '30/3/2016', '2016-03-30'),
(78, '1', 'jsjdk@gmail.com', '9865326598', 'gshd', '6', 'Male', '1', 'Wed', '30/3/2016', '2016-03-30'),
(79, '5', 'han@gmail.com', '9865329865', 'hdhd', '5', 'Male', '1', 'Wed', '30/3/2016', '2016-03-30'),
(80, '5', 'jamu@gmail.com', '9632586598', 'hdhdhd', '5', 'Male', '1', 'Wed', '30/3/2016', '2016-03-30'),
(81, '1', 'mohan@gmail.com', '9632568956', 'gdhdjj', '5', 'Male', '2', 'Wed', '30/3/2016', '2016-03-30'),
(82, '5', 'janab@gmail.com', '9658326598', 'bsbdh', '6', 'Male', '1', 'Wed', '30/3/2016', '2016-03-30'),
(83, '5', 'hapan@gmail.com', '9632568953', 'vsbdb', '5', 'Male', '2', 'Wed', '30/3/2016', '2016-03-30'),
(84, '5', 'japan@gmail.com', '9658362569', 'vzbdh', '6', 'Female', '2', 'Wed', '30/3/2016', '2016-03-30'),
(85, '5', 'anannanna@gmail.com', '9689898989', 'hdjdjj', '9', 'Female', '2', 'Wed', '30/3/2016', '2016-03-30'),
(86, '5', 'hahsh@gmail.com', '9865986598', 'hdhd', '9', 'Female', '2', 'Wed', '30/3/2016', '2016-03-30'),
(87, '5', 'a@gmail.com', '9865986598', 'jdjhd', '9', 'Female', '2', 'Wed', '30/3/2016', '2016-03-30'),
(88, '1', 'japani@gmail.com', '9865329865', 'cshshsj', '65', 'Male', '2', 'Wed', '30/3/2016', '2016-03-30'),
(89, '1', 'juhi@gmail.com', '9865326598', 'hdhdd', '6', 'Male', '1', 'Wed', '30/3/2016', '2016-03-30'),
(90, '1', 'jaj@gmail.com', '9865326598', 'vshsh', '5', 'Male', '1', 'Wed', '30/3/2016', '2016-03-30'),
(91, '1', 'jagi@gmail.com', '9595659595', 'gdhdhd', '656', 'Male', '2', 'Wed', '30/3/2016', '2016-03-30'),
(92, '1', 'jagao@gmail.com', '9658659865', 'vdb', '9', 'Female', '1', 'Wed', '30/3/2016', '2016-03-30'),
(93, '1', 'jaj@gmail.com', '9898989898', 'bdb', '6', 'Female', '1', 'Wed', '30/3/2016', '2016-03-30'),
(94, '1', 'mang@gmail.com', '9632589638', 'bf', '6', 'Female', '2', 'Wed', '30/3/2016', '2016-03-30'),
(95, '1', 'kak@gmail.com', '9865326598', 'gsyd', '6', 'Male', '2', 'Wed', '30/3/2016', '2016-03-30'),
(96, '1', 'jaja@gmail.com', '9658656565', 'bdb', '9', 'Male', '1', 'Thu', '31/3/2016', '2016-03-31'),
(97, '1', 'amir@gmail.com', '9865986598', 'hdhd', '6', 'Male', '1', 'Thu', '31/3/2016', '2016-03-31'),
(98, '1', 'jaj@gmail.com', '9652365898', 'lalu', '5', 'Female', '1', 'Thu', '31/3/2016', '2016-03-31'),
(99, '1', 'jajajaj@gmail.com', '9658659865', 'gsgd', '6', 'Female', '1', 'Thu', '31/3/2016', '2016-03-31'),
(100, '1', 'mamama@gmail.com', '9865326598', 'hshh', '6', 'Male', '1', 'Thu', '31/3/2016', '2016-03-31'),
(101, '1', 'jas@gmail.com', '9632568956', 'bsh', '6', 'Female', '1', 'Thu', '31/3/2016', '2016-03-31'),
(102, '5', 'jasmin@gmail.com', '9865326598', 'jdnf', '6', 'Female', '2', 'Thu', '31/3/2016', '2016-03-31'),
(103, '1', 'juhi@gmail.com', '9632659865', 'bxbh', '6', 'Female', '2', 'Thu', '31/3/2016', '2016-03-31'),
(104, '5', 'manu@gmail.com', '9658653265', 'hdj', '4', 'Female', '2', 'Thu', '31/3/2016', '2016-03-31'),
(105, '5', 'kamu@gmail.com', '9658659865', 'jdjnd', '6', 'Female', '2', 'Thu', '31/3/2016', '2016-03-31'),
(106, '5', 'mano@gmail.com', '9655659865', 'bxbb', '6', 'Female', '2', 'Thu', '31/3/2016', '2016-03-31'),
(107, '5', 'kama@gmail.com', '9865326598', 'kak', '6', 'Male', '3', 'Thu', '31/3/2016', '2016-03-31'),
(108, '1', 'lalu@gmail.com', '9658653265', 'bdbbd', '5', 'Female', '2', 'Thu', '31/3/2016', '2016-03-31'),
(109, '1', 'jyoti@gmail.com', '9565535685', 'jykyi', '2', 'Male', '3', 'Sat', '9/4/2016', '2016-04-09'),
(110, '1', 'dbd@gmail.com', '7598659865', 'hdbbd', '9', 'Male', '1', 'Sat', '9/4/2016', '2016-04-09'),
(111, '1', 'amit@gmail.com', '9865326598', 'bxbhd', '9', 'Male', '2', 'Sat', '9/4/2016', '2016-04-09'),
(112, '1', 'a@gmail.com', '9685986598', 'hdh', '9', 'Male', '2', 'Sat', '9/4/2016', '2016-04-09'),
(113, '1', 'ash@gmail.com', '9865986532', 'bdb', '9', 'Male', '2', 'Sat', '9/4/2016', '2016-04-09'),
(114, '1', 'asnn@gmail.com', '9865986532', 'hfj', '92', 'Male', '2', 'Sat', '9/4/2016', '2016-04-09'),
(115, '1', 'ama@gmail.com', '9865326598', 'hdb', '6', 'Male', '2', 'Sat', '9/4/2016', '2016-04-09'),
(116, '1', 'heh@gmail.com', '9865326598', 'bd', '65', 'Male', '2', 'Sat', '9/4/2016', '2016-04-09'),
(117, '1', 'hsb@gmail.com', '9865326598', 'hxhx', '9', 'Male', '2', 'Sat', '9/4/2016', '2016-04-09'),
(118, '', '', '', '', '', '', '', 'Thu', '', '2016-07-01');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE IF NOT EXISTS `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) NOT NULL,
  `categary` varchar(50) NOT NULL,
  `seats` varchar(50) NOT NULL,
  `travel_id` varchar(50) NOT NULL,
  `lon` varchar(30) NOT NULL,
  `lat` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`id`, `number`, `categary`, `seats`, `travel_id`, `lon`, `lat`) VALUES
(1, 'UP78BC9221', 'AC', '2', '1', '26.478979', '80.295905'),
(2, 'UP78BH6412', 'Non AC', '45', '2', '', ''),
(3, 'UP32GH5487', 'Luxury', '55', '3', '', ''),
(4, 'UP78CD1231', 'Non AC', '65', '1', '', ''),
(5, 'UP32EG5478', 'AC', '56', '2', '', ''),
(6, 'UP32AP4754', 'Non AC', '65', '2', '', '');
