package cl.usach.dminute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.usach.dminute.entity.RolProyecto;
import cl.usach.dminute.repository.RolProyectoJpa;
import cl.usach.dminute.service.RolProyectoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("rolProyectoService")
public class RolProyectoImpl implements RolProyectoService  {

	@Autowired
	@Qualifier("rolProyectoJpa")
	private RolProyectoJpa rolProyectoJpa;
	
	@Override
	public List<RolProyecto> listAllRolProyecto() {
		if(log.isInfoEnabled()) {
			log.info("RolProyectoImpl.listAllRolProyecto.INIT");
		}
		return rolProyectoJpa.findAll();
	}

	@Override
	public void addRolProyecto(RolProyecto ingreso) {
		if(log.isInfoEnabled()) {
			log.info("RolProyectoImpl.addRolProyecto.INIT");
		}
		rolProyectoJpa.save(ingreso);
		if(log.isInfoEnabled()) {
			log.info("RolProyectoImpl.addRolProyecto.END");
		}
		
	}
}
