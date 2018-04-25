package cl.usach.dminute.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.usach.dminute.entity.ElementoDialogo;

public interface ElementoDialogoJpa extends JpaRepository<ElementoDialogo, Serializable> {

}
