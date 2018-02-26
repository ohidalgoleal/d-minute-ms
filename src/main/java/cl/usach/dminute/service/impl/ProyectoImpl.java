package cl.usach.dminute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.usach.dminute.entity.Proyecto;
import cl.usach.dminute.entity.UsuarioProyecto;
import cl.usach.dminute.repository.ProyectoJpa;
import cl.usach.dminute.service.ProyectoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("proyectoService")
public class ProyectoImpl implements ProyectoService {

	@Autowired
	@Qualifier("proyectoJpa")
	private ProyectoJpa proyectoJpa; 
	
	@Override
	public Proyecto guardar(Proyecto guardar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proyecto modificar(Proyecto guardar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Proyecto guardar) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Proyecto> buscarProyectos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUsuarioProyecto(List<UsuarioProyecto> usuarioProyecto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Proyecto NuevoProyecto(cl.usach.dminute.dto.NuevoProyecto guardar) {
		// TODO Auto-generated method stub
		return null;
	}

}
