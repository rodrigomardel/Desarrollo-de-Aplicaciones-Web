-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 02-03-2009 a las 09:18:26
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `empresa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `NUM_CLIE` int(11) NOT NULL,
  `EMPRESA` varchar(20) default NULL,
  `REP_CLIE` int(11) default NULL,
  `LIMITE_CREDITO` int(11) default NULL,
  PRIMARY KEY  (`NUM_CLIE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`NUM_CLIE`, `EMPRESA`, `REP_CLIE`, `LIMITE_CREDITO`) VALUES
(2101, 'Jones Mfg.', 106, 65000),
(2102, 'Firts Corp.', 101, 65000),
(2103, 'Acme Mfg.', 105, 50000),
(2105, 'AAA Investments', 101, 45000),
(2106, 'Fred Lewis Corp.', 102, 65000),
(2107, 'Ace International', 110, 35000),
(2108, 'Holm & Landis', 109, 55000),
(2109, 'Chen Associates ', 103, 25000),
(2111, 'JCP Inc.', 103, 50000),
(2112, 'Zetacorm', 108, 50000),
(2113, 'Ian & Schmidt', 104, 20000),
(2114, 'Orion Corp', 102, 20000),
(2115, 'Smithson Corp.', 101, 20000),
(2117, 'J.P. Sinclair', 106, 35000),
(2118, 'Midwest Systems', 108, 60000),
(2119, 'Solomon Inc.', 109, 25000),
(2120, 'Rico Enterprises', 102, 50000),
(2121, 'QMA Assoc.', 103, 45000),
(2122, 'Three-Way Lines', 105, 30000),
(2123, 'Carter & Sons', 102, 40000),
(2124, 'Peter Brothers', 107, 40000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oficinas`
--

CREATE TABLE `oficinas` (
  `OFICINA` int(11) NOT NULL,
  `CIUDAD` varchar(15) default NULL,
  `REGION` varchar(10) default NULL,
  `DIR` int(11) default NULL,
  `OBJETIVO` int(11) default NULL,
  `VENTAS` int(11) default NULL,
  PRIMARY KEY  (`OFICINA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `oficinas`
--

INSERT INTO `oficinas` (`OFICINA`, `CIUDAD`, `REGION`, `DIR`, `OBJETIVO`, `VENTAS`) VALUES
(11, 'New York', 'Este', 106, 575000, 692637),
(12, 'Chicago', 'Este', 104, 800000, 735042),
(13, 'Atlanta', 'Este', 105, 350000, 367911),
(21, 'Los Angeles', 'Oeste', 108, 725000, 835915),
(22, 'Denver', 'Oeste', 108, 300000, 186042);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `NUM_PEDIDO` int(11) NOT NULL,
  `FECHA_PEDIDO` datetime default NULL,
  `CLIE` int(11) default NULL,
  `REP` int(11) default NULL,
  `FAB` varchar(3) default NULL,
  `PRODUCTO` varchar(5) default NULL,
  `CANT` int(11) default NULL,
  `IMPORTE` int(11) default NULL,
  PRIMARY KEY  (`NUM_PEDIDO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`NUM_PEDIDO`, `FECHA_PEDIDO`, `CLIE`, `REP`, `FAB`, `PRODUCTO`, `CANT`, `IMPORTE`) VALUES
(110036, '1990-01-30 00:00:00', 2107, 110, 'ACI', '4100Z', 9, 22500),
(112961, '1989-12-17 00:00:00', 2117, 106, 'REI', '2A44L', 7, 31500),
(112963, '1989-12-17 00:00:00', 2103, 105, 'ACI', '41004', 28, 3276),
(112968, '1989-10-12 00:00:00', 2102, 101, 'ACI', '41004', 34, 3978),
(112975, '1989-10-12 00:00:00', 2111, 103, 'REI', '2A44G', 6, 2100),
(112979, '1989-10-12 00:00:00', 2114, 102, 'ACI', '4100Z', 6, 15000),
(112983, '1989-12-27 00:00:00', 2103, 105, 'ACI', '41004', 6, 702),
(112987, '1989-12-31 00:00:00', 2103, 105, 'ACI', '4100Y', 11, 27500),
(112989, '1990-01-03 00:00:00', 2101, 106, 'FEA', '114', 6, 1458),
(112992, '1989-11-04 00:00:00', 2118, 108, 'ACI', '41002', 10, 760),
(112993, '1989-01-04 00:00:00', 2106, 102, 'REI', '2A45C', 24, 1896),
(112997, '1990-01-08 00:00:00', 2124, 107, 'BIC', '41003', 1, 652),
(113003, '1990-01-25 00:00:00', 2108, 109, 'IMM', '779C', 3, 5625),
(113007, '1990-01-08 00:00:00', 2112, 108, 'IMM', '773C', 3, 2925),
(113012, '1990-01-11 00:00:00', 2111, 105, 'ACI', '41003', 35, 3745),
(113013, '1990-01-14 00:00:00', 2118, 108, 'BIC', '41003', 1, 652),
(113024, '1990-01-20 00:00:00', 2114, 108, 'QSA', 'XK47', 20, 7100),
(113027, '1990-01-22 00:00:00', 2103, 105, 'ACI', '41002', 54, 4104),
(113034, '1990-01-29 00:00:00', 2107, 110, 'REI', '2A45C', 8, 632),
(113042, '1990-02-02 00:00:00', 2113, 101, 'REI', '2A44R', 5, 22500),
(113045, '1990-02-02 00:00:00', 2112, 108, 'REI', '2A44R', 10, 45000),
(113048, '1990-02-10 00:00:00', 2120, 102, 'IMM', '779C', 2, 3750),
(113049, '1990-02-10 00:00:00', 2118, 108, 'QSA', 'XK47', 2, 776),
(113051, '1990-02-10 00:00:00', 2118, 108, 'QSA', 'XK47', 4, 1420),
(113055, '1990-02-15 00:00:00', 2108, 101, 'ACI', '4100X', 6, 150),
(113057, '1990-02-18 00:00:00', 2111, 103, 'ACI', '4100X', 24, 600),
(113058, '1990-02-23 00:00:00', 2108, 109, 'FEA', '112', 10, 1480),
(113062, '1990-02-24 00:00:00', 2124, 107, 'FEA', '114', 10, 2430),
(113065, '1990-02-27 00:00:00', 2106, 102, 'QSA', 'XK47', 6, 2130),
(113069, '1990-03-02 00:00:00', 2109, 107, 'IMM', '775C', 22, 31350);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `ID_FAB` varchar(3) NOT NULL,
  `ID_PRODUCTO` varchar(5) NOT NULL,
  `DESCRIPCION` varchar(20) default NULL,
  `PRECIO` int(11) default NULL,
  `EXISTENCIAS` int(11) default NULL,
  PRIMARY KEY  (`ID_FAB`,`ID_PRODUCTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `productos`
--

INSERT INTO `productos` (`ID_FAB`, `ID_PRODUCTO`, `DESCRIPCION`, `PRECIO`, `EXISTENCIAS`) VALUES
('ACI', '41001', 'Articulo Tipo 1', 55, 277),
('ACI', '41002', 'Articulo Tipo 2', 76, 167),
('ACI', '41003', 'Articulo Tipo 3', 107, 207),
('ACI', '41004', 'Articulo Tipo 4', 117, 139),
('ACI', '4100X', 'Ajustador', 25, 37),
('ACI', '4100Y', 'Desmontador', 2750, 25),
('ACI', '4100Z', 'Montador', 2500, 28),
('BIC', '41003', 'Tirador', 652, 3),
('BIC', '41089', 'Reten', 225, 78),
('BIC', '41672', 'Placa', 180, 0),
('FEA', '112', 'Cubierta', 148, 115),
('FEA', '114', 'Bancada Motor', 243, 15),
('IMM', '773C', 'Abrazadera 300-lb', 975, 28),
('IMM', '775C', 'Abrazadera 500-lb', 1425, 5),
('IMM', '779C', 'Abrazadera 900-lb', 1875, 9),
('IMM', '887H', 'Soporte Abrazadera ', 54, 223),
('IMM', '887P', 'Perno Abrazadera', 250, 24),
('IMM', '887X', 'Reten Abrazadera', 475, 32),
('QSA', 'XK47', 'Reductor', 355, 38),
('QSA', 'XK48', 'Reductor', 134, 203),
('QSA', 'XK48A', 'Reductor', 117, 37),
('REI', '2A44G', 'Pasador Bisagra', 350, 14),
('REI', '2A44L', 'Bisagra Izqda.', 4500, 12),
('REI', '2A44R', 'Bisagra Dcha.', 4500, 12),
('REI', '2A45C', 'Union Trinquete', 79, 210);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `repventas`
--

CREATE TABLE `repventas` (
  `NUM_EMPL` int(11) NOT NULL,
  `NOMBRE` varchar(15) default NULL,
  `EDAD` int(11) default NULL,
  `OFICINA_REP` int(11) default NULL,
  `TITULO` varchar(10) default NULL,
  `CONTRATO` datetime default NULL,
  `DIRECTOR` int(11) default NULL,
  `CUOTA` int(11) default NULL,
  `VENTAS` int(11) default NULL,
  PRIMARY KEY  (`NUM_EMPL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `repventas`
--

INSERT INTO `repventas` (`NUM_EMPL`, `NOMBRE`, `EDAD`, `OFICINA_REP`, `TITULO`, `CONTRATO`, `DIRECTOR`, `CUOTA`, `VENTAS`) VALUES
(101, 'Dan Roberts', 45, 12, 'Rep Ventas', '1986-10-20 00:00:00', 104, 300000, 305673),
(102, 'Sue Smith', 48, 21, 'Rep Ventas', '1986-12-10 00:00:00', 108, 350000, 474050),
(103, 'Paul Cruz', 29, 12, 'Rep Ventas', '1989-03-01 00:00:00', 104, 275000, 286775),
(104, 'Bob Smith', 33, 12, 'Dir Ventas', '1987-05-19 00:00:00', 106, 200000, 142594),
(105, 'Bill Adams', 37, 13, 'Rep Ventas', '1988-02-12 00:00:00', 104, 350000, 367911),
(106, 'Sam Clark', 52, 11, 'VP Ventas', '1988-06-14 00:00:00', NULL, 275000, 299912),
(107, 'Nancy Angelli', 49, 22, 'Rep Ventas', '1988-11-14 00:00:00', 108, 300000, 186042),
(108, 'Larry Fitch', 62, 21, 'Dir Ventas', '1989-10-12 00:00:00', 106, 350000, 361865),
(109, 'Mary Jones', 31, 11, 'Rep Ventas', '1999-10-12 00:00:00', 106, 300000, 392725),
(110, 'Tom Snyder', 41, NULL, 'Rep Ventas', '1990-01-13 00:00:00', 101, NULL, 75985);
