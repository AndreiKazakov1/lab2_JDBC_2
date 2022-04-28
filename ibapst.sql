-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               8.0.28 - MySQL Community Server - GPL
-- Операционная система:         Win64
-- HeidiSQL Версия:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Дамп структуры базы данных ibapst
CREATE DATABASE IF NOT EXISTS `ibapst` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ibapst`;

-- Дамп структуры для таблица ibapst.student
CREATE TABLE IF NOT EXISTS `student` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) DEFAULT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `mobile_no` varchar(12) DEFAULT NULL,
  `email_id` varchar(100) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `designation` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `doj` date DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `add_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile_no` (`mobile_no`),
  UNIQUE KEY `email_id` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- Дамп данных таблицы ibapst.student: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `fname`, `lname`, `address`, `mobile_no`, `email_id`, `city`, `designation`, `dob`, `doj`, `salary`, `add_date`) VALUES
	(1, 'qwe', 'qw', 'q', 'qwer', 'w', 'e', 'r', '2022-01-29', '2022-01-29', 123.00, '2022-01-29 11:38:14'),
	(3, 'z', 'x', 'c', 'v', 'b', 'n', 'm', '2021-12-14', '2022-01-15', 12234.00, '2022-01-29 13:04:57'),
	(4, 't', 'y', 'u', 'i', 'o', 'p', '[', '2021-12-25', '2022-01-15', 200.00, '2022-01-30 10:16:29'),
	(5, 'a', 'b', 'minsk', '12-20-25555', '123@utu.com', 'minsk', 'ddd', '1980-01-05', '2020-01-07', 250.00, '2022-03-21 14:20:44');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Дамп структуры для таблица ibapst.university
CREATE TABLE IF NOT EXISTS `university` (
  `universityid` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `accriditationlevel` smallint NOT NULL,
  `creationdate` date DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `numberoffaculties` int NOT NULL,
  `numberofstudents` int NOT NULL,
  PRIMARY KEY (`universityid`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;

-- Дамп данных таблицы ibapst.university: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `university` DISABLE KEYS */;
INSERT INTO `university` (`universityid`, `name`, `accriditationlevel`, `creationdate`, `address`, `phone`, `numberoffaculties`, `numberofstudents`) VALUES
	(10, 'cambrige university', 4, '1801-05-14', ' GB cambrige 1-st street', '15-123-1247', 30, 4500),
	(11, 'oxford university', 4, '1798-07-21', ' GB oxford 2-st street', '17-200-1470', 45, 4800),
	(12, 'superior normal school', 3, '2010-07-20', ' France paris 3-st street', '201-1235-520', 25, 3890),
	(14, 'a', 5, '2000-01-05', 'minsk', '123', 50, 100);
/*!40000 ALTER TABLE `university` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
