

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `powerst_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `elektrownie`
--

CREATE TABLE `elektrownie` (
  `id` int(11) NOT NULL,
  `nazwa` varchar(30) DEFAULT NULL,
  `moc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `elektrownie`
--

INSERT INTO `elektrownie` (`id`, `nazwa`, `moc`) VALUES
(1, 'Pierwsza', 12000),
(2, 'Druga', 25000),
(3, 'trzecia', 55000),
(4, 'czwarta1', 55000),
(5, 'czwarta2', 55000),
(6, 'czwarta3', 55000),
(7, 'czwarta', 55000),
(8, 'czwarta4', 55000),
(9, 'czwarta5', 65000),
(10, 'piąta', 5000),
(11, 'szósta', 11000),
(12, 'siódma', 65000),
(13, 'ósma', 15000),
(14, 'dziewiąta', 55000),
(15, 'dziesiąta', 35000),
(16, 'jedenasta', 25000);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(3);

-- --------------------------------------------------------

--
-- Table structure for table `zdarzenia`
--

CREATE TABLE `zdarzenia` (
  `id` int(11) NOT NULL,
  `id_elektrowni` int(11) ,
  `typ_zdarzenia` varchar(35) DEFAULT NULL,
  `ubytek_mocy` int(11) DEFAULT NULL,
  `data_rozpoczecia` timestamp NULL DEFAULT NULL,
  `data_zakonczenia` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `zdarzenia`
--

INSERT INTO `zdarzenia` (`id`, `id_elektrowni`, `typ_zdarzenia`, `ubytek_mocy`, `data_rozpoczecia`, `data_zakonczenia`) VALUES
(1, 1, 'AWARIA', 500, '2020-05-17 22:00:00', '2020-05-19 22:00:00'),
(2, 2, 'AWARIA', 500, '2020-05-05 22:00:00', '2020-05-19 22:00:00'),
(3, 10, 'PRZERWA', 500, '2020-05-13 22:00:00', '2020-05-16 22:00:00'),
(4, 11, 'PRZERWA', 500, '2020-04-30 22:00:00', '2020-05-02 22:00:00'),
(5, 7, 'PRZERWA', 5000, '2020-05-09 22:00:00', '2020-05-19 22:00:00'),
(6, 3, 'AWARIA', 800, '2020-05-10 08:00:00', '2020-05-20 03:03:00'),
(7, 4, 'AWARIA', 700, '2020-05-10 10:00:00', '2020-05-19 22:00:00'),
(8, 12, 'AWARIA', 500, '2020-03-12 23:00:00', '2020-05-20 22:00:00'),
(9, 1, 'AWARIA', 6600, '2020-05-12 22:00:00', '2020-05-20 22:00:00'),
(10, 1, 'AWARIA', 77700, '2020-04-12 22:00:00', '2020-05-20 22:00:00'),
(11, 1, 'AWARIA', 77700, '2020-04-12 22:00:00', '2020-05-22 22:00:00'),
(12, 1, 'AWARIA', 733700, '2020-02-12 23:00:00', '2020-03-20 23:00:00'),
(13, 1, 'REMONT', 733700, '2020-02-12 23:00:00', '2020-03-20 23:00:00'),
(14, 1, 'REMONT', 855220, '2020-05-05 22:00:00', '2020-05-19 22:00:00'),
(15, 10, 'REMONT', 1111, '2020-05-13 22:00:00', '2020-05-16 22:00:00'),
(16, 11, 'REMONT', 511, '2020-04-30 22:00:00', '2020-05-02 22:00:00'),
(17, 7, 'REMONT', 8000, '2020-05-09 22:00:00', '2020-05-19 22:00:00'),
(18, 3, 'REMONT', 800, '2020-05-10 08:00:00', '2020-05-20 03:03:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `elektrownie`
--
ALTER TABLE `elektrownie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `zdarzenia`
--
ALTER TABLE `zdarzenia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_elektrowni` (`id_elektrowni`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `elektrownie`
--
ALTER TABLE `elektrownie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `zdarzenia`
--
ALTER TABLE `zdarzenia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `zdarzenia`
--
ALTER TABLE `zdarzenia`
  ADD CONSTRAINT `zdarzenia_ibfk_1` FOREIGN KEY (`id_elektrowni`) REFERENCES `elektrownie` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
