-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 21 Tem 2019, 12:56:59
-- Sunucu sürümü: 10.1.34-MariaDB
-- PHP Sürümü: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `proje_ee`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

CREATE TABLE `users` (
  `uid` int(10) NOT NULL,
  `uname` varchar(255) COLLATE utf8_turkish_ci NOT NULL,
  `usurname` varchar(255) COLLATE utf8_turkish_ci NOT NULL,
  `umail` varchar(255) COLLATE utf8_turkish_ci NOT NULL,
  `upassword` varchar(255) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `users`
--

INSERT INTO `users` (`uid`, `uname`, `usurname`, `umail`, `upassword`) VALUES
(1, 'Ali', 'Bilmem', 'ali@ali.com', '12345'),
(3, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(4, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(5, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(6, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(7, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(8, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(9, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(10, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(11, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(12, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(13, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(14, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(15, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(16, 'Leyla', 'Bilki', 'leyla@mail.com', '123456'),
(17, 'Leyla', 'Bilki', 'leyla@mail.com', '123456');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`uid`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `users`
--
ALTER TABLE `users`
  MODIFY `uid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
