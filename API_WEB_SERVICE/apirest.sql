--
-- Base de datos:
--
--
-- Estructura de tabla para la tabla `usuarios`
--
CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL,
  `nombreapellido` varchar(45) NOT NULL,
  `alias` varchar(25) NOT NULL,
  `telefono` varchar(15) NOT NULL
) ENGINE=InnoDB;
--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `alias` (`alias`);
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;
