USE `heroku_97b21c584329283`;
DROP procedure IF EXISTS `deleteallusuariosproyecto`;

DELIMITER $$
USE `heroku_97b21c584329283`$$
CREATE PROCEDURE `deleteallusuariosproyecto`(IN _proyectoid bigint(20))
BEGIN
	
		if exists(select * from proyecto where proyecto_id =  _proyectoid) then 
        
        	delete from usuario_proyecto where proyecto_proyecto_id = _proyectoid;
        end if;
        
END$$

DELIMITER ;