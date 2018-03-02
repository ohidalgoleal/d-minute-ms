package cl.usach.dminute.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.usach.dminute.entity.UsuarioProyecto;

@Repository("usuarioProyectoJpa")
public interface UsuarioProyectoJpa extends JpaRepository<UsuarioProyecto,Serializable> {
	
	@Query(value = "select distinct usuariopro0_.proyecto_proyecto_id as proyecto2_8_, \r\n" + 
			"usuariopro0_.rol_proyecto_cod_rol as rol_proy3_8_, usuariopro0_.usuario_username as usuario_4_8_ \r\n" + 
			"from usuario_proyecto usuariopro0_ inner join usuario usuario1_ \r\n" + 
			"on usuariopro0_.usuario_username=usuario1_.username where usuario1_.username=?1 \r\n" + 
			"and usuariopro0_.rol_proyecto_cod_rol is null\r\n", nativeQuery=true)
	public abstract Optional<UsuarioProyecto> agruparPorUsuario(String userName);
	
}
