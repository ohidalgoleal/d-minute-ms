DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getproyectoporusuario`(IN _usuario varchar(255))
BEGIN

	select distinct usuariopro0_.proyecto_proyecto_id as id, 
		usuariopro0_.proyecto_proyecto_id, 
		usuariopro0_.rol_proyecto_cod_rol, 
        usuariopro0_.usuario_username
	from usuario_proyecto usuariopro0_ 
    inner join proyecto _proyecto
    on usuariopro0_.proyecto_proyecto_id = _proyecto.proyecto_id
    where usuariopro0_.usuario_username=_usuario
	and usuariopro0_.rol_proyecto_cod_rol is null
    order by _proyecto.fecha_inicio asc;

END$$
DELIMITER ;
