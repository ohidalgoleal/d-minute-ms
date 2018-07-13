USE `heroku_8e6f58dd6a16279`;
DROP procedure IF EXISTS `deleteallusuariosproyecto`;

DELIMITER $$
USE `heroku_8e6f58dd6a16279`$$
CREATE PROCEDURE `deleteallusuariosproyecto`(IN _proyectoid bigint(20))
BEGIN
	
		if exists(select * from proyecto where proyecto_id =  _proyectoid) then 
        
        	delete from usuario_proyecto where proyecto_proyecto_id = _proyectoid;
        end if;
        
END$$

DELIMITER ;