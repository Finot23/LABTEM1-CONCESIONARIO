-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 07-04-2025 a las 20:11:04
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Concesionaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `userlogin`
--

CREATE TABLE `userlogin` (
  `id` int(11) NOT NULL,
  `nombre_usuario` varchar(25) NOT NULL,
  `contraseña_usuario` varchar(25) NOT NULL,
  `rol` varchar(25) NOT NULL,
  `apellido_p` varchar(100) NOT NULL,
  `apellido_M` varchar(100) NOT NULL,
  `nombres` varchar(200) NOT NULL,
  `puesto` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `userlogin`
--

INSERT INTO `userlogin` (`id`, `nombre_usuario`, `contraseña_usuario`, `rol`, `apellido_p`, `apellido_M`, `nombres`, `puesto`) VALUES
(1, 'admin', 'admin', 'Gerente', 'Salinas', 'Mata', 'Luis Antonio', 'Gerente General'),
(2, 'venta', 'venta', 'Vendedor', 'Perez', 'Alvarado', 'Adan', 'Ayudante General');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `userlogin`
--
ALTER TABLE `userlogin`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `userlogin`
--
ALTER TABLE `userlogin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2002;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
