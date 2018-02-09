-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Erstellungszeit: 01. Feb 2018 um 09:25
-- Server-Version: 5.7.21
-- PHP-Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `micorservice_example`
--
CREATE DATABASE IF NOT EXISTS `micorservice_example` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `micorservice_example`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `birthday` tinyblob,
  `firstname` varchar(255) NOT NULL,
  `iterations` bigint(20) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`id`, `birthday`, `firstname`, `iterations`, `mail`, `name`, `password`, `salt`, `username`) VALUES
(1, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007c3050278, 'Tim', 0, 'tim@test.de', 'Testuser', NULL, NULL, 'Timtest1'),
(2, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007ba020578, 'Tina', 0, 'tina@test.de', 'Testuser', NULL, NULL, 'tinaTest'),
(3, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007a20c1f78, 'Hans', 0, 'hans@test.de', 'Hansen', NULL, NULL, 'hansentest'),
(4, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c00007870770703000007b7060478, 'Carolina', 0, 'carolina@testuser.de', 'Maier', NULL, NULL, 'Caro8775'),
(5, 0xaced00057372000d6a6176612e74696d652e536572955d84ba1b2248b20c0000787077070300000798061678, 'Ronald', 0, 'ronald@testuser.de', 'Dump', NULL, NULL, 'rdump22');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
