-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2026 at 08:05 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_casacambio`
--

-- --------------------------------------------------------

--
-- Table structure for table `consumo_agua`
--

CREATE TABLE `consumo_agua` (
  `id` int(11) NOT NULL,
  `consumo` double NOT NULL,
  `monto` double NOT NULL,
  `impuesto` double NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `consumo_agua`
--

INSERT INTO `consumo_agua` (`id`, `consumo`, `monto`, `impuesto`, `total`) VALUES
(1, 15, 2.25, 0, 2.25);

-- --------------------------------------------------------

--
-- Table structure for table `historial_agua`
--

CREATE TABLE `historial_agua` (
  `id` int(11) NOT NULL,
  `kilos` double NOT NULL,
  `nivel` varchar(20) NOT NULL,
  `litros` double DEFAULT NULL,
  `fecha` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `historial_agua`
--

INSERT INTO `historial_agua` (`id`, `kilos`, `nivel`, `litros`, `fecha`) VALUES
(1, 100, 'DEMASIADO PESO', 200, '2026-04-14 16:52:11'),
(2, 120, 'DEMASIADO PESO', 240, '2026-04-15 00:34:30');

-- --------------------------------------------------------

--
-- Table structure for table `historial_operaciones`
--

CREATE TABLE `historial_operaciones` (
  `id` int(11) NOT NULL,
  `monto_soles` double DEFAULT NULL,
  `cambio_dolar` double DEFAULT NULL,
  `cambio_marco` double DEFAULT NULL,
  `total_euros` double DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `historial_operaciones`
--

INSERT INTO `historial_operaciones` (`id`, `monto_soles`, `cambio_dolar`, `cambio_marco`, `total_euros`, `fecha_registro`) VALUES
(1, 100, 100, 100, 2.18, '2026-04-14 19:31:05'),
(2, 2994, 2994, 2994, 5732, '2026-04-14 20:10:24'),
(3, 300, 300, 300, 574, '2026-04-14 20:15:00'),
(4, 200, 200, 200, 382, '2026-04-14 20:15:21'),
(5, 150, 150, 150, 2.18, '2026-04-14 20:16:20'),
(6, 999, 999, 999, 2.18, '2026-04-14 21:01:55');

-- --------------------------------------------------------

--
-- Table structure for table `planilla_empleados`
--

CREATE TABLE `planilla_empleados` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `horas` int(11) DEFAULT NULL,
  `cargo` int(11) DEFAULT NULL,
  `modalidad` int(11) DEFAULT NULL,
  `pago_hora` double DEFAULT NULL,
  `sueldo_bruto` double DEFAULT NULL,
  `bonificacion` double DEFAULT NULL,
  `sueldo_neto` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `planilla_empleados`
--

INSERT INTO `planilla_empleados` (`id`, `nombre`, `horas`, `cargo`, `modalidad`, `pago_hora`, `sueldo_bruto`, `bonificacion`, `sueldo_neto`) VALUES
(1, 'Ezry Alexandra Dorantes de Luna', 80, 2, 1, 8, 640, 32, 672),
(2, 'Alejandro Peña Nieto', 120, 2, 0, 8, 960, 192, 1152),
(3, 'Alfonso Yepeto de la Cruz', 540, 0, 0, 20, 10800, 2160, 12960);

-- --------------------------------------------------------

--
-- Table structure for table `registro_cultivos`
--

CREATE TABLE `registro_cultivos` (
  `id` int(11) NOT NULL,
  `algodon` int(11) DEFAULT NULL,
  `maiz` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `costo_algodon` double DEFAULT NULL,
  `costo_maiz` double DEFAULT NULL,
  `mas_alto` varchar(50) DEFAULT NULL,
  `costo_alto` double DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `registro_cultivos`
--

INSERT INTO `registro_cultivos` (`id`, `algodon`, `maiz`, `total`, `costo_algodon`, `costo_maiz`, `mas_alto`, `costo_alto`, `fecha`) VALUES
(1, 10, 10, 20, 30, 50, 'Maíz', 50, '2026-04-14 22:05:47'),
(2, 15, 15, 30, 45, 75, 'Maíz', 75, '2026-04-15 05:47:43');

-- --------------------------------------------------------

--
-- Table structure for table `tipos_cambio`
--

CREATE TABLE `tipos_cambio` (
  `id` int(11) NOT NULL,
  `moneda` varchar(50) NOT NULL,
  `valor_compra` decimal(10,4) NOT NULL,
  `valor_venta` decimal(10,4) NOT NULL,
  `ultima_actualizacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tipos_cambio`
--

INSERT INTO `tipos_cambio` (`id`, `moneda`, `valor_compra`, `valor_venta`, `ultima_actualizacion`) VALUES
(1, 'Dolar', 3.7500, 3.7800, '2026-04-14 19:26:25'),
(2, 'Marco', 2.0500, 2.1000, '2026-04-14 19:26:25'),
(3, 'Soles', 1.0000, 1.0000, '2026-04-14 19:26:25');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consumo_agua`
--
ALTER TABLE `consumo_agua`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `historial_agua`
--
ALTER TABLE `historial_agua`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `historial_operaciones`
--
ALTER TABLE `historial_operaciones`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `planilla_empleados`
--
ALTER TABLE `planilla_empleados`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `registro_cultivos`
--
ALTER TABLE `registro_cultivos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tipos_cambio`
--
ALTER TABLE `tipos_cambio`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consumo_agua`
--
ALTER TABLE `consumo_agua`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `historial_agua`
--
ALTER TABLE `historial_agua`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `historial_operaciones`
--
ALTER TABLE `historial_operaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `planilla_empleados`
--
ALTER TABLE `planilla_empleados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `registro_cultivos`
--
ALTER TABLE `registro_cultivos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tipos_cambio`
--
ALTER TABLE `tipos_cambio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
