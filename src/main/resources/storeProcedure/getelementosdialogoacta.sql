USE `heroku_97b21c584329283`;
DROP procedure IF EXISTS `getelementosdialogoacta`;

DELIMITER $$
USE `heroku_97b21c584329283`$$
CREATE PROCEDURE `getelementosdialogoacta`(IN _actaid bigint(20))
BEGIN
	
		if exists(select * from acta where acta_id =  _actaid) then 
        
        	 SELECT el.id,
				el.descripcion,
				el.estado,
				el.fecha_compromiso,
				el.elemento_dialogo_id,
				el.tema_id,
				el.tipo_elemento_dialogo_cod_rol,
				el.usuario_username,
                el.titulo
			FROM elemento_dialogo el
            WHERE el.tema_id in (select id from tema where acta_acta_id =  _actaid)
            AND el.estado <> "DEL"
            ORDER BY el.tema_id, el.id;

        end if;
        
END$$

DELIMITER ;

/*CALL getelementosdialogoacta(22)*/