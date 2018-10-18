USE `heroku_97b21c584329283`;
DROP procedure IF EXISTS `getlistaractabyproyecto`;

DELIMITER $$
USE `heroku_97b21c584329283`$$
CREATE PROCEDURE `getlistaractabyproyecto`(IN _proyectoid bigint(20))
BEGIN
		if exists(select * from proyecto where proyecto_id =  _proyectoid and estado = 'A') then 
			select acta_id, 
				fecha,  
                resumen,
                estado,
                hora_incio,
                hora_fin,
                usuario_username
            from acta where proyecto_proyecto_id = _proyectoid
            and estado = 'A'
            order by fecha desc;
        end if;
END$$

DELIMITER ;
