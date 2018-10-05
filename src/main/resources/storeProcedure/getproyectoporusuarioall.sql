USE `heroku_97b21c584329283`;
DROP procedure IF EXISTS `getproyectoporusuarioall`;

DELIMITER $$
USE `heroku_97b21c584329283`$$
CREATE PROCEDURE `getproyectoporusuarioall`(IN _usuario varchar(255))
BEGIN

	select usuariopro0_.proyecto_proyecto_id as id, 
		usuariopro0_.proyecto_proyecto_id, 
		usuariopro0_.usuario_username,
        usuario.nombre,
        usuario.apellido
	from usuario_proyecto usuariopro0_ 
    inner join proyecto _proyecto
    on usuariopro0_.proyecto_proyecto_id = _proyecto.proyecto_id
    inner join usuario 
    on usuario.username = usuariopro0_.usuario_username
    where usuariopro0_.proyecto_proyecto_id 
    in (
		select distinct usuariopro0_.proyecto_proyecto_id as id
		from usuario_proyecto usuariopro0_ 
		inner join proyecto _proyecto
		on usuariopro0_.proyecto_proyecto_id = _proyecto.proyecto_id
		where usuariopro0_.usuario_username = _usuario
		and _proyecto.estado = 'A'
    )
    order by _proyecto.proyecto_id asc;

    

END$$

DELIMITER ;

