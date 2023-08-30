-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-08-2023 a las 18:25:37
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `productos_tecnologicos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos tecnológicos`
--

CREATE TABLE `productos tecnológicos` (
  `dispositivo` varchar(30) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `color` varchar(30) NOT NULL,
  `especificaciones` varchar(30) NOT NULL,
  `cantidad` int(30) NOT NULL,
  `Valor_total` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos tecnológicos`
--

INSERT INTO `productos tecnológicos` (`dispositivo`, `marca`, `color`, `especificaciones`, `cantidad`, `Valor_total`) VALUES
('celular', 'aifon', 'rojos', 'rrasd', 2, 0),
('televisor', 'sansu', 'negro', '32pulgadas', 2, 2400);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos tecnológicos`
--
ALTER TABLE `productos tecnológicos`
  ADD PRIMARY KEY (`dispositivo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
