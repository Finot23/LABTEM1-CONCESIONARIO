-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 27-04-2025 a las 02:31:05
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
(1, 'Marin', 'Sanchez', 'Jose Abraham', 55718333, 'elmarinxd@gmail.com', 'Santo Tomas ', 'Corpus Christy', 'AO', 'CDMX', '01530', 'MASA000720HDFRNBA1', '374854', 'Masculino', '25'),
(2, 'Perez ', 'ALvarado', 'Adan', 55768692, 'adanpr@cua.uam', 'Av tamaulipas 98', 'westhill', 'Cuajimalpa', 'CDMX', '01660', 'ADPX756GHGYU66', '64734857', 'Masculino', '22'),
(9, 'pruebaappelidoP', 'pruebaApellidoM', 'PruebNombre', 662614343, 'PruebaCorreo', 'pruebaCalle', 'PruebaColonia', 'PruebaMunicipio', 'PruebEstado', '727', 'PruebaCurp', 'PruebaLic', 'Masculino', '20'),
(10, 'p', 'p', 'p', 712716726, 'akskjksA', 'ajnsakns', 'asas', 'ddka', 'janska', '13131', 'p', 'ijsas', 'Femenino', '2'),
(11, 'ss', 'ss', 'ss', 111, '11asas', 'asasa', 'sasas', 'asas', 'asas', '1212', 'ss', 'asmas', 'Masculino', '12'),
(12, 'apellidopT', 'apellidoMT', 'NombreT', 77723, 'Testcorreo', 'coap', 'santabarbara', 'cuauctitaln', 'mexico', '6377', 'curpT', '1232', 'Masculino', '18'),
(13, 'js', 'jsj', 'jsajs', 72712, 'kaskaksm', 'coa', 'pmkm', 'mkmska', 'kmksa', '8384', 'jasj', '82128', 'Masculino', '28'),
(14, 'ad', 'a', 'asd', 1213, 'asasas', 'as', 'as', 'asa', 'sa', '212', 'ads2', 'aas', 'Masculino', '19'),
(15, 'nadnnd', 'daad', 'dad', 232324, 'sdsd', 'dsdsd', 'sdsdsd', 'sdsds', 'sdd', '2323', '12ds', 'jsk', 'Masculino', '12'),
(16, 'aas', 'sas', 'sas', 323232, 'sas', 'sas', 'asas', 'sas', 'sasas', '1334', 'sas', 'asa', 'Género', '21'),
(19, 'Culkin', 'Nose', 'kiernan', 657476, 'mck@test.com', 'nose euayth', 'milincovic', 'Ny', 'new york', '79622', 'JHBIHIUBS43', '4353', 'Masculino', '33'),
(21, 'Pascal', 'Pumas', 'Pedro', 24141241, 'ppp@cua.mx', 'fghkyuy', 'fuuygyuyug', 'huguu', 'iuhu', '01555', 'PPP3FJ7TGG', '34534634', 'Masculino', '55'),
(24, 'Magnus', 'Optimus', 'Primero', 58757687, 'magnus.com', 'uiuhui', 'uhuihhiuh', 'iuhihi', 'fhgfrdr', '01881', 'hihiu8545', '35253', 'Género', '22'),
(32, 'jbknfgjhkj', 'dfgjkhlgfh', 'gfhjdfghjkh', 5352534, 'fffwefewf', 'hgdfs', 'trwfds', 'trefd', 'grwef', '45355', '675rf88g', '346346', 'Masculino', '44'),
(33, 'jbknfgjhkj', 'dfgjkhlgfh', 'gfhjdfghjkh', 5352534, 'fffwefewf', 'hgdfs', 'trwfds', 'trefd', 'grwef', '45355', '675rf88g', '4646546', 'Masculino', '44'),
(34, 'jbknfgjhkj', 'dfgjkhlgfh', 'gfhjdfghjkh', 5352534, 'fffwefewf', 'hgdfs', 'trwfds', 'trefd', 'grwef', '45355', '675rf88g', '4646546', 'Masculino', '44'),
(35, 'tupac', 'tyuyoi', 'cyyguho', 4323523, 'dasbdhab', 'gwwfweg', 'wfewfwf', 'wffwef', 'wewf', '23432', '697tgg7gh', '64535255', 'Masculino', '54'),
(36, 'tupac', 'tyuyoi', 'cyyguho', 4323523, 'dasbdhab', 'gwwfweg', 'wfewfwf', 'wffwef', 'wewf', '23432', '697tgg7gh', '', 'Masculino', '54'),
(37, 'Ababa', 'dabab', 'jajaja', 3645786, 'sorreo.com', 'Pietro', 'maximof', 'hujsen', 'madrid', '81711', 'ntfghiljg', '4563523', 'Femenino', '53'),
(38, 'Ababa', 'dabab', 'jajaja', 3645786, 'sorreo.com', 'Pietro', 'maximof', 'hujsen', 'madrid', '81711', 'ntfghiljg', '574362', 'Femenino', '53'),
(39, 'Ababa', 'dabab', 'jajaja', 3645786, 'sorreo.com', 'Pietro', 'maximof', 'hujsen', 'madrid', '81711', 'ntfghiljg', '574362', 'Femenino', '53'),
(40, 'jojo', 'jojo', 'nsnas', 121313, 'jadnand', 'dada', 'adad', 'ada', 'dad1', '1212', 'CURP', 'ajsnkas', 'Masculino', '12'),
(41, 'kskks', 'kamskma', 'madkmakd', 2121313, 'dadad', 'amd ka', 'akdmkad', 'admkamd', 'amkdmak', '2121', 'CURP', 'kmsk', 'Masculino', '12'),
(42, 'asasa', 'asas', 'sasa', 213141, 'dadad', 'sdada', 'dadada', 'dadad', 'adad', '131', 'saa', 'sdd', 'Femenino', '14'),
(43, 'asadad', 'sfsf', 'ff', 21313213, 'kksdkksndks', 'ndsknskdnks', 'sdsdsd', 'nkdnsksnd', 'kdkn', '2324', 'CURP', 'skjdksdk', 'Femenino', '15'),
(44, 'shgjhj', 'hgjhhjs', 'hgjsag', 656365, 'jhdkj', 'svhdvhsd', 'hdh', 'hgjd', 'ghajd', '6623', 'gjsagj', 'hjkdh', 'Masculino', '20'),
(45, 'shgjhj', 'hgjhhjs', 'hgjsag', 656365, 'jhdkj', 'svhdvhsd', 'hdh', 'hgjd', 'ghajd', '6623', 'gjsagj', 'hjkdh', 'Masculino', '20'),
(46, 'Salinas', 'Mata', 'Luis Antonio', 56259096, 'luis.salinas.contacto@gmial.com', 'coap', 'santa barbara', 'cuautitlan izcalli', 'santa barbara', '54713', 'CURP', 'jaks', 'Masculino', '22'),
(47, 'Salinas', 'Mata', 'Luis Antonio', 56259096, 'luis.salinas.contacto@gmail.com', 'coapa', 'santa barbara', 'cuautitlan izcalli', 'estado de mexico', '54713', 'CURP', 'sas', 'Masculino', '22'),
(48, 'Salinas', 'Mata', 'Luis Antonio', 56259096, 'luis.salinas.contacto@gmail.com', 'coapa', 'santa barbara', 'cuautitlan izcalli', 'estado de mexico', '54713', 'CURP', 'sas', 'Masculino', '22'),
(49, 'Salinas ', 'Mata', 'Luis Antonio', 56259096, 'luis.salinas.contacto@gmail.com', 'coapa', 'santa barbara', 'cuautitlan izcalli', 'estado de mexico', '54713', 'CURP', 'nmmas', 'Masculino', '22'),
(50, 'jksak', 'jkasj', 'akjsk', 131414, 'mdmlmld', 'snknd', 'kdkl', 'kldk', 'ndlkn', '22424', 'CURP', 'kmlmd', 'Masculino', '22'),
(51, 'asas', 'as', 'ass', 31313, 'anlsnals', 'asknansj', 'kansaksn', 'sakld', 'anks', '423', 'jdkandad', 'kndsn', 'Masculino', '22'),
(52, 'ann', 'n', 'jn', 838383, 'nknkn', 'jsdjo', 'jdj', 'okjdok', 'jk', '3131', 'CURP', 'nndn', 'Masculino', '18'),
(53, 'j', 'jj', 'j', 382938, 'jj', 'dsd', 'nnd', 'dsd', 'dsd', '8389', 'j', 'jj', 'Femenino', '38'),
(54, 'kk', 'kk', 'kk', 82828, 'jj', 'jjj', 'jjj', 'jj', 'jj', '8289', 'kk', 'jj', 'Masculino', '20'),
(55, 'Salinas', 'Mata', 'Luis Antonio', 5471492, 'luis.salinas.contacto@gmail.com', 'Coapa', 'Santa Barara', 'Cuautitlan Izcalli', 'Estado de Mexico', '54713', 'SAML0342', 'GAJ83', 'Masculino', '22'),
(56, 'Salinas', 'Mata', 'Luis Antonio', 562590965, 'luis.salinas.contacto@gmail.com', 'copa', 'santa barabara', 'cuautitlan izcalli', 'Estado de mexico', '54713', 'DJISn', 'KKSIS293', 'Masculino', '22'),
(57, 'nnj', 'kjnj', 'knjk', 27178, 'jkljlk', 'njkbkj', 'kjb', 'kjbkjb', 'jkb', '637', 'kj', 'kllj', 'Masculino', '28'),
(58, 'nnkkn', 'kjknk', 'kk', 7878, 'kjkjk', 'njknkjn', 'jnknkjn', 'nknkjnk', 'nkjnj', '89889', 'nkn', 'jkkk', 'Femenino', '22'),
(59, 'nkJKNknkjNK', 'JNK', 'JNJK', 76675675, 'fdnjf', 'vhvgv', 'vgvh', 'gvghgh', 'ghvgh', '666', 'kmlkf', 'fkldnfd', 'Masculino', '22'),
(60, 'jnjaknsjkn', 'jnsjksnkn', 'jknknjk', 232399, 'nkjnj', 'jnknkj', 'nkjnjkn', 'njknjn', 'kjnjn', '9393', 'jknnjk', 'jnknj2', 'Masculino', '22'),
(61, 'Salinas', 'Mata', 'PruebasCredito', 929292, 'luis.salinas.contacto@gmail.com', 'coapa', 'santa barbara', 'cuautitlan izcalli', 'Estado de mexico', '54713', 'CURP', 'JSNX24', 'Masculino', '22'),
(62, 'Salinas', 'Mata', 'Luis Antonio', 562590965, 'luis.salinas.contaco@gmail.com', 'Coapa', 'Santa Barbara', 'Cuautitlan Izcalli', 'Estado de Mexico', '54713', 'CURP', 'HJSJBk', 'Género', '22'),
(63, 'nknaknjkn', 'k', 'njkn', 7867678, 'knjnkdn', 'njknkjdn', 'jbkbjk', 'bjkjkbjkb', 'kjbjkb', '7868', 'knnl', 'jknjdnk', 'Masculino', '22');

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
('A1', 624900.00, '20%', 124980.00, 499920.00, 24, 24239.45);

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
('njkn', 'nknaknjkn', 'Audi A1 (2020), Color: Amarillo, Placa: nnmsd', 'Amplia', 'MENSUAL', 'TARJETA', '744517.93', '3412.37');

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
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT de la tabla `userlogin`
--
ALTER TABLE `userlogin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2002;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
