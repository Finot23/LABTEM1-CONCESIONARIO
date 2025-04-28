-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-04-2025 a las 00:32:50
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
  `id` int(11) UNSIGNED NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `anio_fabricacion` year(4) NOT NULL,
  `no_serie` varchar(17) NOT NULL,
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

INSERT INTO `almacen` (`id`, `marca`, `modelo`, `anio_fabricacion`, `no_serie`, `precio`, `color`, `estado`, `categoria`, `imagen`, `descripcion`, `kilometraje`) VALUES
(1, 'Audi', 'A1', '2020', '3N1AB7AP3KY215678', 624900.00, 'Amarillo', 'usado', 'hatchback', '/consecionario/Imagenes/hatchback/AudiA1.jpg', 'Un hatchback con diseño vanguardista y deportivo. Ofrece tecnología intuitiva,\r\nopciones de personalización y un motor eficiente para la vida urbana.', 12000),
(2, 'BMW', 'Serie1', '2004', '3U1AM7PP3QY215698', 800000.00, 'Verde Aqua', 'usado', 'hatchback', '/consecionario/Imagenes/hatchback/BMWserie1.jpg', 'Un hatchback con diseño atlético, tecnología innovadora y opciones de\r\npersonalización. Ideal para quienes buscan dinamismo y estilo.', 280000),
(3, 'Chevrolet', 'Aveo HB', '2002', '3Q1AN7MP3KY217478', 294600.00, 'Mostaza', 'usado', 'hatchback', '/consecionario/Imagenes/hatchback/AveoHB.jpg', 'Un hatchback moderno y accesible de Chevrolet, con rediseño atractivo,\r\nconectividad avanzada y sistemas de seguridad mejorados.', 460000),
(4, 'Acura', 'TLX', '2014', '3L1AP7AP3WY292856', 1134900.00, 'Azul Profundo', 'usado', 'sedan', '/consecionario/Imagenes/sedan/AcuraTLX.jpg', 'Un sedán deportivo de lujo que combina elegancia y tecnología avanzada.\r\nOfrece modos de conducción personalizados, sistemas de seguridad de última generación y\r\nun diseño interior centrado en la comodidad.', 270000),
(5, 'BMW', 'M3', '2024', '3V1LJ7AP3KY218294', 2200500.00, 'Verde Isle of Man', 'nuevo', 'sedan', '/consecionario/Imagenes/sedan/BMWM3.jpg', 'Un sedán deportivo de alto rendimiento con motor potente, diseño aerodinámico\r\ny tecnología derivada del mundo de la competición.', 0),
(6, 'Kia', 'k4', '2024', '3N1AB7NW3KY294637', 400000.00, 'Gris Platinado', 'nuevo', 'sedan', '/consecionario/Imagenes/sedan/Kiak4.jpg', 'Un sedán elegante con opciones de motorización turbo, tecnología avanzada y\r\ndiseño aerodinámico tipo fastback. Destaca por su perfil deportivo y detalles premium', 0),
(7, 'Alfa Romeo ', 'tonale', '2024', '3N1AB7OP3LY928365', 950000.00, 'Azul Marino', 'nuevo', 'suv', '/consecionario/Imagenes/suv/AlfaromeoTH.jpg', 'Un SUV híbrido conectable que redefine la deportividad con detalles\r\npremium, tecnología avanzada y un diseño dinámico. Ideal para quienes buscan estilo y\r\neficiencia.', 0),
(8, 'Audi', 'Q8', '2018', '3N1WB7AP3KY738104', 1739900.00, 'Arena', 'usado', 'suv', '/consecionario/Imagenes/suv/AUdiQ8.jpg', ' Un SUV de lujo con diseño coupé deportivo, tecnología avanzada y tracción\r\nintegral quattro. Combina potencia, elegancia y espacio generoso.', 86000),
(9, 'BMW', 'X6 M', '2000', '3N1OP7ZP3KY292846', 979000.00, 'Negro', 'usado', 'suv', '/consecionario/Imagenes/suv/BMWX6M.jpg', ' Una SUV deportiva con ADN de competición, motor potente y diseño exclusivo.\r\nPerfecta para combinar adrenalina y confort.', 464000);

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
(68, 'Salinas', 'Mata', 'Luis Antonio', 547133, 'luis.salinas.contacto@gmail.com', 'coap', 'Santa Barbara', 'Cuautitlan Izcalli', 'Estado Mexico', '54713', 'SAML0303', 'GA02978HS', 'Masculino', '22'),
(69, 'Salinas', 'Mata', 'Luis Antonio', 547133, 'luis.salinas.contacto@gmail.com', 'coap', 'Santa Barbara', 'Cuautitlan Izcalli', 'Estado Mexico', '54713', 'SAML0303', 'GA02978HS', 'Masculino', '22'),
(70, 'Marin', 'Sanchez', 'Jose', 5635273, 'jose.contacto', 'mkamsn', 'jkhk', 'jkh', 'kjhkj', '8798', 'JMAS89782HJ', 'GANJ278H', 'Masculino', '24'),
(71, 'jkhkj', 'khj', 'TEST', 67687, 'jkh', 'hkjhkj', 'hjkh', 'jkhjk', 'hjk', '676', 'hksahjk', 'hjkhjk', 'Masculino', '23'),
(72, 'jhjkahsk', 'jhkjash', 'TEST Segundo', 76867, 'gjhghj', 'ghjgh', 'gj', 'gjh', 'ghujgh', '6786', 'hJKH', 'ghjghj', 'Femenino', '33'),
(73, 'hjkhaskjhkjhs', 'jkhkjh', 'FINAL TEST', 6786876, 'jkhkjh', 'hjgjg', 'hjg', 'jhghj', 'gjhjgj', '565', 'JKHGHJKSHK', 'jkhkjhjk', 'Masculino', '44'),
(74, 'hjkhjkh', 'jh', 'FINAL TEST AMBOS', 67687, 'jkhkjhjk', 'hjkhk', 'kjhkjhk', 'kjhjkh', 'kjhkh', '786', 'hkjhk', 'jkhjkjh', 'Masculino', '22'),
(75, 'jhkjhkj', 'kjhjkhk', 'REAL FINAL TEST', 42424, 'hkjhjkhjk', 'jhkhjk', 'kjhkj', 'hjkhk', 'hjkhjk', '8783', 'jkljkhkjh', 'jkhkjh', 'Masculino', '22'),
(76, 'djlkajdljadkljl', 'jklkjkl', 'REALFINALFINAL TEST', 808908, 'jlkjklj', 'kljljlk', 'kjlkj', 'ljklkjl', 'ljjlk', '7878', 'jlkjklj', 'kjljlkl', 'Masculino', '76');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credito`
--

CREATE TABLE `credito` (
  `automovil` varchar(20) NOT NULL,
  `precio_auto` decimal(10,2) NOT NULL,
  `porcentaje_enganche` varchar(10) NOT NULL,
  `enganche` decimal(10,2) NOT NULL,
  `monto_credito` decimal(10,2) NOT NULL,
  `plazo` int(10) NOT NULL,
  `pago_mensual` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `credito`
--

INSERT INTO `credito` (`automovil`, `precio_auto`, `porcentaje_enganche`, `enganche`, `monto_credito`, `plazo`, `pago_mensual`) VALUES
('Serie1', 800000.00, '30%', 240000.00, 560000.00, 24, -1734.64),
('Serie1', 800000.00, '30%', 240000.00, 560000.00, 24, 27152.52),
('M3', 2200500.00, '20%', 440100.00, 1760400.00, 36, 61024.84),
('Aveo HB', 294600.00, '10%', 29460.00, 265140.00, 24, 12855.75),
('Aveo HB', 294600.00, '10%', 29460.00, 265140.00, 24, 12855.75),
('TLX', 1134900.00, '20%', 226980.00, 907920.00, 24, 44022.00),
('A1', 624900.00, '30%', 187470.00, 437430.00, 24, 21209.51),
('A1', 624900.00, '20%', 124980.00, 499920.00, 12, 45121.94),
('A1', 624900.00, '10%', 62490.00, 562410.00, 12, 50762.18),
('A1', 624900.00, '20%', 124980.00, 499920.00, 24, 24239.45),
('Aveo HB', 294600.00, '20%', 58920.00, 235680.00, 24, 11427.33),
('TLX', 1134900.00, '20%', 226980.00, 907920.00, 24, 44022.00),
('A1', 624900.00, '30%', 187470.00, 437430.00, 24, 21209.51),
('Aveo HB', 294600.00, '30%', 88380.00, 206220.00, 24, 9998.92),
('Aveo HB', 294600.00, '20%', 58920.00, 235680.00, 24, 11427.33);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_documentos`
--

CREATE TABLE `historial_documentos` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `nombre_cliente` varchar(255) DEFAULT NULL,
  `tipo_documento` varchar(50) DEFAULT NULL,
  `ruta_archivo` varchar(500) DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `historial_documentos`
--

INSERT INTO `historial_documentos` (`id`, `id_cliente`, `nombre_cliente`, `tipo_documento`, `ruta_archivo`, `fecha_registro`) VALUES
(9, 0, 'REAL FINAL TEST jhkjhkj kjhjkhk', 'Venta', 'src/consecionario/Facturas/Ventas/Resumen_Venta_REAL_FINAL_TEST.pdf', '2025-04-28 22:18:05'),
(10, 0, 'REAL FINAL TEST jhkjhkj kjhjkhk', 'Seguro', 'src/consecionario/Facturas/PolizaSeguro/Poliza_Seguro_REAL_FINAL_TEST.pdf', '2025-04-28 22:18:05'),
(11, 0, 'REAL FINAL TEST jhkjhkj kjhjkhk', 'Venta', 'src/consecionario/Facturas/Ventas/Resumen_Venta_REAL_FINAL_TEST.pdf', '2025-04-28 22:18:09'),
(12, 0, 'REAL FINAL TEST jhkjhkj kjhjkhk', 'Credito', 'src/consecionario/Facturas/ResumenCreditos/Resumen_Credito_REAL_FINAL_TEST.pdf', '2025-04-28 22:18:09'),
(13, 0, 'REALFINALFINAL TEST djlkajdljadkljl jklkjkl', 'Venta', 'src/consecionario/Facturas/Ventas/Resumen_Venta_REALFINALFINAL_TEST.pdf', '2025-04-28 22:20:32'),
(14, 0, 'REALFINALFINAL TEST djlkajdljadkljl jklkjkl', 'Seguro', 'src/consecionario/Facturas/PolizaSeguro/Poliza_Seguro_REALFINALFINAL_TEST.pdf', '2025-04-28 22:20:32'),
(15, 0, 'REALFINALFINAL TEST djlkajdljadkljl jklkjkl', 'Credito', 'src/consecionario/Facturas/ResumenCreditos/Resumen_Credito_REALFINALFINAL_TEST.pdf', '2025-04-28 22:20:37');

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
('Adan', 'Perez ', 'Audi C5 (190000), Color: Rojo, Placa: GG276', 'Amplia', 'MENSUAL', 'TRANSFERENCIA', '235334', '1078'),
('Jose Abraham', 'Marin', 'BMW Serie1 (2020), Color: Verde aqua, Placa: 3GRG4', 'Amplia', 'SEMESTRAL', 'TARJETA', '0', '0'),
('kiernan', 'Culkin', 'BMW Serie1 (2020), Color: Verde aqua, Placa: dfe42', 'Amplia', 'ANUAL', 'TARJETA', '965793.92', '48289.7'),
('Pedro', 'Pascal', 'BMW Serie1 (2020), Color: Verde aqua, Placa: 453636', 'Amplia', 'MENSUAL', 'TARJETA', '993653.36', '4554.24'),
('Primero', 'Magnus', 'BMW Serie1 (2020), Color: Verde aqua, Placa: fefrg', 'Responsabilidad Civil', 'ANUAL', 'TARJETA', '946759.97', '37870.4'),
('jgkbhln', 'fghlj', 'BMW Serie1 (2020), Color: Verde aqua, Placa: 35345', 'Amplia', 'SEMESTRAL', 'TARJETA', '901600.0', '23667.0'),
('bbugg', 'ybbiuhuh', 'BMW Serie1 (2020), Color: Verde aqua, Placa: 454534', 'Amplia', 'MENSUAL', 'TARJETA', '989794.51', '4536.56'),
('gfhjdfghjkh', 'jbknfgjhkj', 'BMW Serie1 (2020), Color: Verde aqua, Placa: 54756', 'Amplia', 'MENSUAL', 'TARJETA', '901600.0', '4132.33'),
('cyyguho', 'tupac', 'BMW Serie1 (2020), Color: Verde aqua', 'Amplia', 'MENSUAL', 'TARJETA', '901600.0', '4132.33'),
('jajaja', 'Ababa', 'BMW Serie1 (2020), Color: Verde aqua, Placa: gfdg34', 'Amplia', 'SEMESTRAL', 'TRANSFERENCIA', '1074280.32', '28199.86'),
('nsnas', 'jojo', 'Audi A1 (2020), Color: Amarillo', 'Amplia', 'MENSUAL', 'TARJETA', '669049.18', '3066.48'),
('nsnas', 'jojo', 'Audi A1 (2020), Color: Amarillo', 'Amplia', 'MENSUAL', 'TARJETA', '669049.18', '3066.48'),
('hgjsag', 'shgjhj', 'BMW M3 (2020), Color: verde Isle of Man, Placa: gf54', 'Limitada', 'ANUAL', 'TARJETA', '2298602.69', '91944.11'),
('njkn', 'nknaknjkn', 'Audi A1 (2020), Color: Amarillo, Placa: nnmsd', 'Amplia', 'MENSUAL', 'TARJETA', '744517.93', '3412.37'),
('TEST Segundo', 'jhjkahsk', 'Chevrolet Aveo HB (2002), Color: Mostaza, Placa: hjkhkj', 'Amplia', 'MENSUAL', 'TARJETA', '384545.62', '1762.5'),
('FINAL TEST AMBOS', 'hjkhjkh', 'Audi A1 (2020), Color: Amarillo, Placa: sasa', 'Amplia', 'MENSUAL', 'TARJETA', '669049.18', '3066.48'),
('REAL FINAL TEST', 'jhkjhkj', 'Chevrolet Aveo HB (2002), Color: Mostaza, Placa: adad', 'Amplia', 'MENSUAL', 'TARJETA', '422147.67', '1934.84'),
('REALFINALFINAL TEST', 'djlkajdljadkljl', 'Chevrolet Aveo HB (2002), Color: Mostaza, Placa: asdas', 'Amplia', 'MENSUAL', 'TARJETA', '399929.37', '1833.01');

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
-- Indices de la tabla `historial_documentos`
--
ALTER TABLE `historial_documentos`
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
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT de la tabla `historial_documentos`
--
ALTER TABLE `historial_documentos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `userlogin`
--
ALTER TABLE `userlogin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2002;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
