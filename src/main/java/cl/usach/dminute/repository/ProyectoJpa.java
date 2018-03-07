package cl.usach.dminute.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.usach.dminute.entity.Proyecto;

@Repository("proyectoJpa")
public interface ProyectoJpa extends JpaRepository<Proyecto, Serializable> {
	
	public abstract Proyecto findByProyectoId (long proyectoId);

}
