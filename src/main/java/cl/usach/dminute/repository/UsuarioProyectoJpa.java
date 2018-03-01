package cl.usach.dminute.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.entity.UsuarioProyecto;

@Repository("usuarioProyectoJpa")
public interface UsuarioProyectoJpa extends JpaRepository<UsuarioProyecto,Serializable> {
	
	public abstract List<UsuarioProyecto> findByUsuarioUsername(Usuario userName);
	
}
