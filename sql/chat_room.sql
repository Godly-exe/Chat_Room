-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2022 at 05:04 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10



/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chat_room`
--

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL,
  `user_email` varchar(30) DEFAULT NULL,
  `friend_email` varchar(30) DEFAULT NULL,
  `contact_status` int(11) DEFAULT 1 COMMENT '1: nhan tin, 2: ko nhan'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`contact_id`, `user_email`, `friend_email`, `contact_status`) VALUES
(1, 'namnam2301@gmail.com', 'client@gmail.com', 1),
(2, 'namnam2301@gmail.com', 'baobeo@gmail.com', 1),
(3, 'client@gmail.com', 'namnam2301@gmail.com', 1),
(4, 'baobeo@gmail.com', 'namnam2301@gmail.com', 1),
(5, 'namnam2301@gmail.com', 'test2@gmail.com', 2),
(6, 'test2@gmail.com', 'namnam2301@gmail.com', 1),
(11, 'test3@gmail.com', 'client@gmail.com', 1),
(12, 'client@gmail.com', 'test3@gmail.com', 1),
(13, 'namnam2301@gmail.com', 'test3@gmail.com', 1),
(14, 'test3@gmail.com', 'namnam2301@gmail.com', 1),
(15, 'namtor2301@gmail.com', 'namnam2301@gmail.com', 1),
(16, 'namnam2301@gmail.com', 'namtor2301@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `groupchat`
--

CREATE TABLE `groupchat` (
  `group_id` int(11) NOT NULL,
  `group_name` text DEFAULT NULL,
  `group_createday` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `groupchat`
--

INSERT INTO `groupchat` (`group_id`, `group_name`, `group_createday`) VALUES
(1, 'Quoc Te', '2022-10-24 17:00:00'),
(2, 'Khoa Hoc', '2022-10-25 17:00:00'),
(3, 'Toan', '2022-10-24 17:00:00'),
(4, 'LTM', '2022-10-29 10:31:32'),
(5, 'Van', '2022-10-29 10:33:43'),
(6, 'Xam Xi', '2022-11-09 05:20:04'),
(7, 'Dia Ly', '2022-11-16 14:27:40'),
(8, 'Lich Su', '2022-11-17 02:49:54'),
(9, 'Báo cáo', '2022-11-17 03:12:55');

-- --------------------------------------------------------

--
-- Table structure for table `group_member`
--

CREATE TABLE `group_member` (
  `group_member_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `user_email` varchar(30) DEFAULT NULL,
  `group_member_joinday` timestamp NULL DEFAULT NULL,
  `group_member_status` int(11) DEFAULT 1 COMMENT '1:nhan tin,2 ko nhan tin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `group_member`
--

INSERT INTO `group_member` (`group_member_id`, `group_id`, `user_email`, `group_member_joinday`, `group_member_status`) VALUES
(2, 2, 'namnam2301@gmail.com', '2022-10-25 11:38:45', 1),
(4, 3, 'baobeo@gmail.com', '2022-10-25 12:09:33', 1),
(5, 2, 'baobeo@gmail.com', '2022-10-26 03:42:26', 1),
(6, 1, 'namnam2301@gmail.com', '2022-10-28 04:54:25', 1),
(7, 2, 'client@gmail.com', '2022-10-28 05:08:48', 1),
(8, 1, 'client@gmail.com', '2022-10-29 08:59:33', 1),
(9, 1, 'baobeo@gmail.com', '2022-10-29 09:19:08', 1),
(10, 4, 'namnam2301@gmail.com', '2022-10-29 10:31:32', 2),
(11, 5, 'namnam2301@gmail.com', '2022-10-29 10:33:43', 1),
(12, 5, 'client@gmail.com', '2022-10-31 14:08:45', 1),
(13, 6, 'client@gmail.com', '2022-11-09 05:20:04', 1),
(14, 7, 'client@gmail.com', '2022-11-16 14:27:40', 1),
(16, 7, 'namnam2301@gmail.com', '2022-11-16 14:28:31', 1),
(17, 8, 'baobeo@gmail.com', '2022-11-17 02:49:54', 1),
(18, 8, 'namnam2301@gmail.com', '2022-11-17 02:50:01', 1),
(20, 9, 'baobeo@gmail.com', '2022-11-17 03:13:43', 1),
(21, 9, 'client@gmail.com', '2022-11-17 03:14:38', 1),
(22, 9, 'namnam2301@gmail.com', '2022-11-17 03:17:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `group_message`
--

CREATE TABLE `group_message` (
  `group_message_id` int(11) NOT NULL,
  `group_id` int(11) DEFAULT NULL,
  `user_sender` varchar(30) DEFAULT NULL,
  `message_time` timestamp NULL DEFAULT NULL,
  `message_content` text DEFAULT NULL,
  `message_file` text DEFAULT NULL,
  `message_fileByte` mediumblob DEFAULT NULL,
  `message_emoji` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `group_message`
--

INSERT INTO `group_message` (`group_message_id`, `group_id`, `user_sender`, `message_time`, `message_content`, `message_file`, `message_fileByte`, `message_emoji`) VALUES
(1, 2, 'namnam2301@gmail.com', '2022-10-25 11:39:28', 'hello moi nguoi', NULL, NULL, NULL),
(2, 2, 'namnam2301@gmail.com', '2022-10-25 11:39:28', 'hello moi nguoi 123', NULL, NULL, NULL),
(3, 2, 'client@gmail.com', '2022-10-25 11:39:28', 'hello moi nguoi 12345', NULL, NULL, NULL),
(4, 1, 'namnam2301@gmail.com', '2022-10-23 04:02:30', 'hihihi', NULL, NULL, NULL),
(5, 2, 'baobeo@gmail.com', '2022-10-23 04:04:41', 'hasodnasodnsaondoasndo', NULL, NULL, NULL),
(6, 2, 'namnam2301@gmail.com', '2022-10-27 12:41:52', 'hi', 'null', NULL, NULL),
(7, 2, 'namnam2301@gmail.com', '2022-10-27 12:42:04', 'minh la nam', 'null', NULL, NULL),
(8, 2, 'client@gmail.com', '2022-10-27 12:42:27', 'chao ban', 'null', NULL, NULL),
(9, 2, 'client@gmail.com', '2022-10-27 12:58:01', 'minh la client', 'null', NULL, NULL),
(10, 2, 'baobeo@gmail.com', '2022-10-27 12:58:39', 'mminh la test', 'null', NULL, NULL),
(11, 2, 'client@gmail.com', '2022-10-27 13:01:34', 'minh la client', 'null', NULL, NULL),
(12, 2, 'client@gmail.com', '2022-10-27 13:06:20', 'client day', 'null', NULL, NULL),
(13, 2, 'baobeo@gmail.com', '2022-10-27 13:07:54', 'minh la test', 'null', NULL, NULL),
(14, 2, 'baobeo@gmail.com', '2022-10-27 13:08:37', 'test ady', 'null', NULL, NULL),
(15, 2, 'namnam2301@gmail.com', '2022-10-27 13:09:34', 'namd ay', 'null', NULL, NULL),
(16, 2, 'client@gmail.com', '2022-10-27 13:09:53', 'toi la client', 'null', NULL, NULL),
(17, 2, 'namnam2301@gmail.com', '2022-10-27 13:13:43', 'toi la nam', 'null', NULL, NULL),
(18, 2, 'client@gmail.com', '2022-10-27 13:14:27', 'day ne', 'null', NULL, NULL),
(19, 2, 'namnam2301@gmail.com', '2022-10-27 13:14:32', 'j vay', 'null', NULL, NULL),
(20, 2, 'client@gmail.com', '2022-10-27 13:18:53', 'client day', 'null', NULL, NULL),
(21, 2, 'namnam2301@gmail.com', '2022-10-27 13:19:01', 'nam day', 'null', NULL, NULL),
(22, 2, 'client@gmail.com', '2022-10-27 13:32:44', 'client day', 'null', NULL, NULL),
(23, 2, 'baobeo@gmail.com', '2022-10-27 13:33:02', 'test day', 'null', NULL, NULL),
(24, 2, 'namnam2301@gmail.com', '2022-10-27 13:33:13', 'nam ne', 'null', NULL, NULL),
(25, 2, 'baobeo@gmail.com', '2022-10-27 13:33:30', 'ok nam minh la test', 'null', NULL, NULL),
(26, 2, 'baobeo@gmail.com', '2022-10-27 13:33:37', 'hihi', 'null', NULL, NULL),
(27, 2, 'namnam2301@gmail.com', '2022-10-27 13:35:01', 'nam ne', 'null', NULL, NULL),
(28, 2, 'namnam2301@gmail.com', '2022-10-28 03:18:04', 'nam day', 'null', NULL, NULL),
(29, 2, 'client@gmail.com', '2022-10-28 12:12:13', 'asaa', 'null', NULL, 'null'),
(30, 2, 'namnam2301@gmail.com', '2022-10-28 12:12:21', 'asas', 'null', NULL, 'null'),
(31, 2, 'namnam2301@gmail.com', '2022-10-28 12:12:25', 'zxxz', 'null', NULL, 'null'),
(32, 2, 'namnam2301@gmail.com', '2022-10-29 04:35:52', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png'),
(33, 2, 'namnam2301@gmail.com', '2022-10-29 04:35:56', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png'),
(34, 2, 'namnam2301@gmail.com', '2022-10-29 04:36:03', 'null', 'null', NULL, 'icons8-smiling-30.png'),
(35, 2, 'namnam2301@gmail.com', '2022-10-29 04:37:14', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png'),
(36, 2, 'client@gmail.com', '2022-10-29 04:37:28', 'null', 'null', NULL, 'icons8-loudly-crying-face-30.png'),
(37, 2, 'namnam2301@gmail.com', '2022-10-29 04:37:52', 'null', 'null', NULL, 'icons8-anime-emoji-30.png'),
(38, 2, 'namnam2301@gmail.com', '2022-10-29 09:19:32', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png'),
(39, 1, 'namnam2301@gmail.com', '2022-10-29 09:19:34', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png'),
(40, 4, 'namnam2301@gmail.com', '2022-10-29 10:31:44', 'null', 'null', NULL, 'icons8-facebook-like-30.png'),
(41, 1, 'namnam2301@gmail.com', '2022-10-29 12:39:01', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png'),
(42, 4, 'namnam2301@gmail.com', '2022-10-29 12:58:16', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png'),
(43, 1, 'namnam2301@gmail.com', '2022-10-30 10:39:25', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `message_id` int(11) NOT NULL,
  `user_sender` varchar(30) DEFAULT NULL,
  `user_receive` varchar(30) DEFAULT NULL,
  `message_time` timestamp NULL DEFAULT NULL,
  `message_content` text DEFAULT NULL,
  `message_file` text DEFAULT NULL,
  `message_fileByte` mediumblob DEFAULT NULL,
  `message_emoji` text DEFAULT NULL,
  `message_status` int(11) DEFAULT 1 COMMENT '1: da gui, 2: da xem'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`message_id`, `user_sender`, `user_receive`, `message_time`, `message_content`, `message_file`, `message_fileByte`, `message_emoji`, `message_status`) VALUES
(6, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-25 03:52:22', 'Hello ban', NULL, NULL, NULL, 2),
(14, 'client@gmail.com', 'client@gmail.com', '2022-10-26 05:32:30', 'a', NULL, NULL, NULL, 2),
(47, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-26 12:17:26', 'hello test', NULL, NULL, NULL, 2),
(48, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-26 14:28:50', 'hi nam', NULL, NULL, NULL, 2),
(49, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-26 14:29:13', 'hi cau', NULL, NULL, NULL, 2),
(64, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-27 12:39:48', 'hi test', 'null', NULL, NULL, 2),
(65, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-27 12:39:57', 'co do ko', 'null', NULL, NULL, 2),
(71, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-27 13:55:04', 'hihi', 'null', NULL, NULL, 2),
(78, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-28 03:11:50', 'yo', 'null', NULL, NULL, 2),
(84, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-28 03:32:44', 'a', 'null', NULL, NULL, 2),
(85, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-28 03:33:58', 'ok', 'null', NULL, NULL, 2),
(86, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-28 03:35:07', 's', 'null', NULL, NULL, 2),
(100, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-28 14:23:16', 'a', 'null', NULL, 'null', 2),
(111, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-29 04:18:05', 'null', 'null', NULL, 'icons8-facebook-like-30.png', 2),
(142, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-29 12:38:58', 'null', 'null', NULL, 'icons8-anime-emoji-30.png', 2),
(187, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:18', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(188, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:20', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(189, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:20', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(190, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:20', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(191, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:20', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(192, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:21', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(193, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:22', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(194, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:23', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(195, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:26', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(196, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:26', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(197, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:27', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(198, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:28', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(199, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:28', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(200, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:32', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(201, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 04:22:34', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(202, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:13', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(203, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:13', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(204, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:14', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(205, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:15', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(206, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:16', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(207, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:16', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(208, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:17', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(209, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:20', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(210, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:23', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(211, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:23', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(212, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:23', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(213, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:24', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(214, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:24', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(215, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:24', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(216, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:25', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(217, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:25', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(218, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:32', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(219, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:33', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(220, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:35', 'null', 'null', NULL, 'icons8-thinking-face-30.png', 2),
(221, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 04:23:38', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(225, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 14:13:35', 'null', 'null', NULL, 'icons8-smiling-face-with-heart-30.png', 2),
(226, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 14:13:36', 'null', 'null', NULL, 'icons8-smiling-face-with-heart-30.png', 2),
(227, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 14:13:44', 'null', 'null', NULL, 'icons8-smiling-face-with-heart-30.png', 2),
(228, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-10-31 14:13:48', 'null', 'null', NULL, 'icons8-smiling-face-with-heart-30.png', 2),
(229, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 14:14:48', 'null', 'null', NULL, 'icons8-two-hearts-30.png', 2),
(230, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 14:14:49', 'null', 'null', NULL, 'icons8-two-hearts-30.png', 2),
(231, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 14:14:52', 'null', 'null', NULL, 'icons8-vietnam-flag-30.png', 2),
(232, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 14:14:54', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(233, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 14:14:54', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(234, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 14:14:55', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(235, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 14:14:55', 'null', 'null', NULL, 'icons8-angry-30.png', 2),
(236, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 14:15:00', 'null', 'null', NULL, 'icons8-two-hearts-30.png', 2),
(237, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-10-31 14:15:05', 'null', 'null', NULL, 'icons8-anime-emoji-30.png', 2),
(245, 'client@gmail.com', 'test3@gmail.com', '2022-11-09 02:39:32', 'null', 'null', NULL, 'icons8-thinking-face-30.png', 2),
(253, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-11-09 05:13:48', 'null', 'null', NULL, 'icons8-smiling-face-with-heart-30.png', 2),
(261, 'namnam2301@gmail.com', 'test2@gmail.com', '2022-11-09 06:23:55', 'ads sdaasd', 'null', NULL, 'null', 2),
(262, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-11-09 11:28:04', 'das', 'null', NULL, 'null', 2),
(263, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-11-09 11:28:06', 'null', 'null', NULL, 'icons8-loudly-crying-face-30.png', 2),
(264, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-11-09 11:37:02', 'null', 'null', NULL, 'icons8-anime-emoji-30.png', 2),
(265, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-11-09 11:37:05', 'null', 'null', NULL, 'icons8-smiling-face-with-heart-eyes-30.png', 2),
(270, 'test2@gmail.com', 'namnam2301@gmail.com', '2022-11-09 12:16:53', 'null', 'null', NULL, 'icons8-two-hearts-30.png', 2),
(271, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-11-10 08:47:18', 'asdasd', 'null', NULL, 'null', 2),
(272, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-11-10 08:47:19', 'null', 'null', NULL, 'icons8-thinking-face-30.png', 2),
(273, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-11-10 08:47:20', 'null', 'null', NULL, 'icons8-two-hearts-30.png', 2),
(274, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-11-10 08:49:37', 'null', 'null', NULL, 'icons8-smiling-face-with-heart-30.png', 2),
(275, 'namnam2301@gmail.com', 'baobeo@gmail.com', '2022-11-10 08:49:38', 'null', 'null', NULL, 'icons8-two-hearts-30.png', 2),
(276, 'baobeo@gmail.com', 'namnam2301@gmail.com', '2022-11-10 08:59:38', 'hello', 'null', NULL, 'null', 2),
(277, 'namnam2301@gmail.com', 'test3@gmail.com', '2022-11-10 09:01:51', 'null', 'null', NULL, 'icons8-two-hearts-30.png', 2),
(278, 'test3@gmail.com', 'namnam2301@gmail.com', '2022-11-10 09:01:53', 'null', 'null', NULL, 'icons8-thinking-face-30.png', 2);


-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_email` varchar(30) NOT NULL,
  `user_password` text NOT NULL,
  `user_name` text DEFAULT NULL,
  `user_birthday` date DEFAULT '2000-01-01',
  `user_phone` text DEFAULT NULL,
  `user_gender` text NOT NULL DEFAULT 'Nam',
  `user_createday` datetime DEFAULT NULL,
  `user_status` int(11) DEFAULT 2 COMMENT '1:ol, 2:off'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_email`, `user_password`, `user_name`, `user_birthday`, `user_phone`, `user_gender`, `user_createday`, `user_status`) VALUES
(1, 'namnam2301@gmail.com', 'e35cf7b66449df565f93c607d5a81d09', 'Nam1233', '2000-12-21', '0123456712', 'Nữ', '2022-10-22 15:18:25', 2),
(2, 'baobeo@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'Bao Beo', '2000-12-21', '0123456789', 'Nam', '2022-10-22 15:18:25', 1),
(3, 'client@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'Client Ne', '2000-10-13', '0123456789', 'Nam', '2022-10-23 10:58:09', 3),
(4, 'test2@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'Van Teo', '2000-10-20', '0123444444', 'Nam', '2022-10-27 18:37:23', 2),
(5, 'test3@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'Meo Meo', '2000-10-19', '0125896325', 'Nữ', '2022-10-28 19:34:50', 2),
(6, 'test4@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'Mo Mo', '2000-10-19', '0125896325', 'Nữ', '2022-10-28 19:34:50', 3),
(7, 'test5@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'Thi No', '2000-10-19', '0125896325', 'Nữ', '2022-10-28 19:34:50', 3),
(10, 'namtor2301@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'nam132', '2000-01-01', NULL, 'Nam', '2022-11-17 00:00:00', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`contact_id`),
  ADD KEY `user_id_1` (`user_email`),
  ADD KEY `user_id_2` (`friend_email`);

--
-- Indexes for table `groupchat`
--
ALTER TABLE `groupchat`
  ADD PRIMARY KEY (`group_id`);

--
-- Indexes for table `group_member`
--
ALTER TABLE `group_member`
  ADD PRIMARY KEY (`group_member_id`),
  ADD KEY `group_id` (`group_id`),
  ADD KEY `user_email` (`user_email`);

--
-- Indexes for table `group_message`
--
ALTER TABLE `group_message`
  ADD PRIMARY KEY (`group_message_id`),
  ADD KEY `user_sender` (`user_sender`),
  ADD KEY `group_id` (`group_id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`message_id`),
  ADD KEY `user_sender` (`user_sender`),
  ADD KEY `user_receive` (`user_receive`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_email` (`user_email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `contact_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `groupchat`
--
ALTER TABLE `groupchat`
  MODIFY `group_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `group_member`
--
ALTER TABLE `group_member`
  MODIFY `group_member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `group_message`
--
ALTER TABLE `group_message`
  MODIFY `group_message_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `message_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=312;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `contact_ibfk_1` FOREIGN KEY (`user_email`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `contact_ibfk_2` FOREIGN KEY (`friend_email`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `group_member`
--
ALTER TABLE `group_member`
  ADD CONSTRAINT `group_member_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groupchat` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `group_member_ibfk_2` FOREIGN KEY (`user_email`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `group_message`
--
ALTER TABLE `group_message`
  ADD CONSTRAINT `group_message_ibfk_1` FOREIGN KEY (`user_sender`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `group_message_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `groupchat` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`user_sender`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `message_ibfk_2` FOREIGN KEY (`user_receive`) REFERENCES `user` (`user_email`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
