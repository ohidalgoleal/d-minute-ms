package cl.usach.dminute.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.usach.dminute.entity.Tema;

@Repository("temaJpa")
public interface TemaJpa extends JpaRepository<Tema, Serializable> {
	
	public abstract List<Tema> findByActaActaId(long actaId); 

}
