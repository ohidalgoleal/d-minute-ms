USE `heroku_8e6f58dd6a16279`;
DROP procedure IF EXISTS `getproyectoporusuario`;

DELIMITER $$
USE `heroku_8e6f58dd6a16279`$$
CREATE PROCEDURE `getproyectoporusuario`(IN _usuario varchar(255))
BEGIN

	select distinct usuariopro0_.proyecto_proyecto_id as id, 
		usuariopro0_.proyecto_proyecto_id, 
		usuariopro0_.usuario_username
	from usuario_proyecto usuariopro0_ 
    inner join proyecto _proyecto
    on usuariopro0_.proyecto_proyecto_id = _proyecto.proyecto_id
    where usuariopro0_.usuario_username=_usuario
	and _proyecto.estado = 'A'
    order by _proyecto.fecha_inicio asc;

END$$

DELIMITER ;
