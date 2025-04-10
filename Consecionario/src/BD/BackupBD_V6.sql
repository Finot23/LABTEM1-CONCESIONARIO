-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-04-2025 a las 22:45:20
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `concesionaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `id` int(11) NOT NULL,
  `modelo` varchar(80) NOT NULL,
  `año_fabricacion` int(4) NOT NULL,
  `precio` int(11) NOT NULL,
  `color` varchar(100) NOT NULL,
  `estado` varchar(100) NOT NULL,
  `categoria` varchar(20) NOT NULL,
  `imagen` varchar(255) NOT NULL,
  `descripcion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`id`, `modelo`, `año_fabricacion`, `precio`, `color`, `estado`, `categoria`, `imagen`, `descripcion`) VALUES
(1, 'Audi A1', 2020, 624900, 'Amarillo', 'Nuevo', 'Hatchback', '/consecionario/Imagenes/hatchback/AudiA1.jpg', 'Un hatchback con diseño vanguardista y deportivo. Ofrece tecnología intuitiva,\r\nopciones de personalización y un motor eficiente para la vida urbana.'),
(2, 'BMW Serie1', 2004, 800000, 'Verde aqua', 'Usado', 'Hatchback', '/consecionario/Imagenes/hatchback/BMWserie1.jpg', 'Un hatchback con diseño atlético, tecnología innovadora y opciones de\r\npersonalización. Ideal para quienes buscan dinamismo y estilo.'),
(3, 'Chevrolet Aveo HB', 2002, 294600, 'Mostaza', 'Nuevo', 'Hatchback', '/consecionario/Imagenes/hatchback/AveoHB.jpg', 'Un hatchback moderno y accesible de Chevrolet, con rediseño atractivo,\r\nconectividad avanzada y sistemas de seguridad mejorados.'),
(4, 'Acura TLX', 2014, 1134900, 'Azul profundo', 'usado', 'Sedan', '/consecionario/Imagenes/sedan/AcuraTLX.jpg', 'Un sedán deportivo de lujo que combina elegancia y tecnología avanzada.\r\nOfrece modos de conducción personalizados, sistemas de seguridad de última generación y\r\nun diseño interior centrado en la comodidad.'),
(5, 'BMW M3', 2020, 2200500, 'verde Isle of Man', 'Nuevo', 'Sedan', '/consecionario/Imagenes/sedan/BMWM3.jpg', 'Un sedán deportivo de alto rendimiento con motor potente, diseño aerodinámico\r\ny tecnología derivada del mundo de la competición.'),
(6, 'Kia k4', 2024, 400000, 'Gris platinado', 'Nuevo', 'Sedan', '/consecionario/Imagenes/sedan/Kiak4.jpg', 'Un sedán elegante con opciones de motorización turbo, tecnología avanzada y\r\ndiseño aerodinámico tipo fastback. Destaca por su perfil deportivo y detalles premium'),
(7, 'Alfa Romeo tonale', 2022, 950000, 'azul marino', 'Nuevo', 'SUV', '/consecionario/Imagenes/suv/AlfaromeoTH.jpg', 'Un SUV híbrido conectable que redefine la deportividad con detalles\r\npremium, tecnología avanzada y un diseño dinámico. Ideal para quienes buscan estilo y\r\neficiencia.'),
(8, 'Audi Q8', 2018, 1739900, 'Arena', 'Nuevo', 'SUV', '/consecionario/Imagenes/suv/AUdiQ8.jpg', ' Un SUV de lujo con diseño coupé deportivo, tecnología avanzada y tracción\r\nintegral quattro. Combina potencia, elegancia y espacio generoso.'),
(9, 'BMW X6 M', 219, 979000, 'Negro', 'Usado', 'SUV', '/consecionario/Imagenes/suv/BMWX6M.jpg', ' Una SUV deportiva con ADN de competición, motor potente y diseño exclusivo.\r\nPerfecta para combinar adrenalina y confort.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(20) NOT NULL,
  `Apellido_Paterno` varchar(50) NOT NULL,
  `Apellido_Materno` varchar(50) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `telefono` int(11) NOT NULL,
  `Correo` varchar(100) NOT NULL,
  `calle` varchar(200) NOT NULL,
  `colonia` varchar(100) NOT NULL,
  `municipio` varchar(100) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  `curp` varchar(40) NOT NULL,
  `licencia` varchar(80) NOT NULL,
  `genero` varchar(50) NOT NULL,
  `edad` varchar(101) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `Apellido_Paterno`, `Apellido_Materno`, `nombre`, `telefono`, `Correo`, `calle`, `colonia`, `municipio`, `ciudad`, `curp`, `licencia`, `genero`, `edad`) VALUES
(1, 'Salinas', 'Mata', 'Luis Antonio', 562590955, 'luis.salinas.contacto@gmail.com', 'av. Coapa', 'Santa Barabara', 'Cuautitlan Izcalli ', 'Mexico', '', '', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguro`
--

CREATE TABLE `seguro` (
  `tipo_cobertura` varchar(50) NOT NULL,
  `periodo` varchar(100) NOT NULL,
  `metodo_pago` varchar(50) NOT NULL,
  `valor` varchar(100) NOT NULL,
  `prima` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

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
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `userlogin`
--
ALTER TABLE `userlogin`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `almacen`
--
ALTER TABLE `almacen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `userlogin`
--
ALTER TABLE `userlogin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2002;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
