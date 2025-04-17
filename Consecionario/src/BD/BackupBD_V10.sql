-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 18-04-2025 a las 01:13:43
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
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `id` int(11) UNSIGNED NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `anio_fabricacion` year(4) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `color` varchar(30) NOT NULL,
  `estado` enum('nuevo','usado') NOT NULL,
  `categoria` enum('hatchback','sedan','suv') NOT NULL,
  `imagen` varchar(255) NOT NULL,
  `descripcion` text NOT NULL,
  `kilometraje` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`id`, `marca`, `modelo`, `anio_fabricacion`, `precio`, `color`, `estado`, `categoria`, `imagen`, `descripcion`, `kilometraje`) VALUES
(1, 'Audi', 'A1', '2020', 624900.00, 'Amarillo', 'nuevo', 'hatchback', '/consecionario/Imagenes/hatchback/AudiA1.jpg', 'Un hatchback con diseño vanguardista y deportivo. Ofrece tecnología intuitiva,\r\nopciones de personalización y un motor eficiente para la vida urbana.', 0),
(2, 'BMW', 'Serie1', '2004', 800000.00, 'Verde aqua', 'usado', 'hatchback', '/consecionario/Imagenes/hatchback/BMWserie1.jpg', 'Un hatchback con diseño atlético, tecnología innovadora y opciones de\r\npersonalización. Ideal para quienes buscan dinamismo y estilo.', 0),
(3, 'Chevrolet', 'Aveo HB', '2002', 294600.00, 'Mostaza', 'nuevo', 'hatchback', '/consecionario/Imagenes/hatchback/AveoHB.jpg', 'Un hatchback moderno y accesible de Chevrolet, con rediseño atractivo,\r\nconectividad avanzada y sistemas de seguridad mejorados.', 0),
(4, 'Acura', 'TLX', '2014', 1134900.00, 'Azul profundo', 'usado', 'sedan', '/consecionario/Imagenes/sedan/AcuraTLX.jpg', 'Un sedán deportivo de lujo que combina elegancia y tecnología avanzada.\r\nOfrece modos de conducción personalizados, sistemas de seguridad de última generación y\r\nun diseño interior centrado en la comodidad.', 0),
(5, 'BMW', 'M3', '2020', 2200500.00, 'verde Isle of Man', 'nuevo', 'sedan', '/consecionario/Imagenes/sedan/BMWM3.jpg', 'Un sedán deportivo de alto rendimiento con motor potente, diseño aerodinámico\r\ny tecnología derivada del mundo de la competición.', 0),
(6, 'Kia', 'k4', '2024', 400000.00, 'Gris platinado', 'nuevo', 'sedan', '/consecionario/Imagenes/sedan/Kiak4.jpg', 'Un sedán elegante con opciones de motorización turbo, tecnología avanzada y\r\ndiseño aerodinámico tipo fastback. Destaca por su perfil deportivo y detalles premium', 0),
(7, 'Alfa Romeo ', 'tonale', '2022', 950000.00, 'azul marino', 'nuevo', 'suv', '/consecionario/Imagenes/suv/AlfaromeoTH.jpg', 'Un SUV híbrido conectable que redefine la deportividad con detalles\r\npremium, tecnología avanzada y un diseño dinámico. Ideal para quienes buscan estilo y\r\neficiencia.', 0),
(8, 'Audi', 'Q8', '2018', 1739900.00, 'Arena', 'nuevo', 'suv', '/consecionario/Imagenes/suv/AUdiQ8.jpg', ' Un SUV de lujo con diseño coupé deportivo, tecnología avanzada y tracción\r\nintegral quattro. Combina potencia, elegancia y espacio generoso.', 0),
(9, 'BMW', 'X6 M', '2000', 979000.00, 'Negro', 'usado', 'suv', '/consecionario/Imagenes/suv/BMWX6M.jpg', ' Una SUV deportiva con ADN de competición, motor potente y diseño exclusivo.\r\nPerfecta para combinar adrenalina y confort.', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(20) NOT NULL,
  `Apellido_Paterno` varchar(50) NOT NULL,
  `Apellido_Materno` varchar(50) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `telefono` int(12) NOT NULL,
  `Correo` varchar(100) NOT NULL,
  `calle` varchar(200) NOT NULL,
  `colonia` varchar(100) NOT NULL,
  `municipio` varchar(100) NOT NULL,
  `estado` varchar(40) NOT NULL,
  `cp` varchar(5) NOT NULL,
  `curp` varchar(40) NOT NULL,
  `licencia` varchar(80) NOT NULL,
  `genero` varchar(50) NOT NULL,
  `edad` varchar(101) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `Apellido_Paterno`, `Apellido_Materno`, `nombre`, `telefono`, `Correo`, `calle`, `colonia`, `municipio`, `estado`, `cp`, `curp`, `licencia`, `genero`, `edad`) VALUES
(1, 'Marin', 'Sanchez', 'Jose Abraham', 55718333, 'elmarinxd@gmail.com', 'Santo Tomas ', 'Corpus Christy', 'AO', 'CDMX', '01530', 'MASA000720HDFRNBA1', '374854', 'Masculino', '25'),
(2, 'Perez ', 'ALvarado', 'Adan', 55768692, 'adanpr@cua.uam', 'Av tamaulipas 98', 'westhill', 'Cuajimalpa', 'CDMX', '01660', 'ADPX756GHGYU66', '64734857', 'Masculino', '22'),
(9, 'pruebaappelidoP', 'pruebaApellidoM', 'PruebNombre', 662614343, 'PruebaCorreo', 'pruebaCalle', 'PruebaColonia', 'PruebaMunicipio', 'PruebEstado', '727', 'PruebaCurp', 'PruebaLic', 'Masculino', '20'),
(10, 'p', 'p', 'p', 712716726, 'akskjksA', 'ajnsakns', 'asas', 'ddka', 'janska', '13131', 'p', 'ijsas', 'Femenino', '2'),
(11, 'ss', 'ss', 'ss', 111, '11asas', 'asasa', 'sasas', 'asas', 'asas', '1212', 'ss', 'asmas', 'Masculino', '12'),
(12, 'apellidopT', 'apellidoMT', 'NombreT', 77723, 'Testcorreo', 'coap', 'santabarbara', 'cuauctitaln', 'mexico', '6377', 'curpT', '1232', 'Masculino', '18'),
(13, 'js', 'jsj', 'jsajs', 72712, 'kaskaksm', 'coa', 'pmkm', 'mkmska', 'kmksa', '8384', 'jasj', '82128', 'Masculino', '28'),
(14, 'ad', 'a', 'asd', 1213, 'asasas', 'as', 'as', 'asa', 'sa', '212', 'ads2', 'aas', 'Masculino', '19'),
(15, 'nadnnd', 'daad', 'dad', 232324, 'sdsd', 'dsdsd', 'sdsdsd', 'sdsds', 'sdd', '2323', '12ds', 'jsk', 'Masculino', '12'),
(16, 'aas', 'sas', 'sas', 323232, 'sas', 'sas', 'asas', 'sas', 'sasas', '1334', 'sas', 'asa', 'Género', '21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguro`
--

CREATE TABLE `seguro` (
  `nombre` varchar(40) NOT NULL,
  `apellido_p` varchar(20) NOT NULL,
  `autoResumen` varchar(100) NOT NULL,
  `tipo_cobertura` varchar(50) NOT NULL,
  `periodo` varchar(100) NOT NULL,
  `metodo_pago` varchar(50) NOT NULL,
  `valor` varchar(100) NOT NULL,
  `prima` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `seguro`
--

INSERT INTO `seguro` (`nombre`, `apellido_p`, `autoResumen`, `tipo_cobertura`, `periodo`, `metodo_pago`, `valor`, `prima`) VALUES
('Luis Antonio', 'Salinas', 'VW Vento (2000), Color: Azul, Placa: GT4F1', 'Amplia', 'SEMESTRAL', 'TARJETA', '2357', '60'),
('Jose Abraham', 'Marin', 'Volkswahen Gol (20000), Color: Azul, Placa: 585hg', 'Amplia', 'MENSUAL', 'TARJETA', '25316', '115'),
('Andres', 'Mateo', 'Chevrolet Corola (150000), Color: Blanco, Placa: 6H54D', 'Amplia', 'ANUAL', 'TARJETA', '193009', '9650'),
('Jose Abraham', 'Marin', 'Lambo Gallardo  (900000), Color: Verde, Placa: 5GY99', 'Amplia', 'SEMESTRAL', 'TARJETA', '1195563', '31383'),
('Adan', 'Perez ', 'Audi C5 (190000), Color: Rojo, Placa: GG276', 'Amplia', 'MENSUAL', 'TRANSFERENCIA', '235334', '1078');

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
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
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
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `userlogin`
--
ALTER TABLE `userlogin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2002;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
