package cl.usach.dminute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.usach.dminute.entity.TipoElementoDialogo;
import cl.usach.dminute.repository.TipoElementoDialogoJpa;
import cl.usach.dminute.service.TipoElementoDialogoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("tipoElementoDialogoService")
public class TipoElementoDialogoImpl implements TipoElementoDialogoService {

	@Autowired
	@Qualifier("tipoElementoDialogoJpa")
	private TipoElementoDialogoJpa tipoElementoDialogoJpa;
	
	@Override
	public List<TipoElementoDialogo> listAllTipoElementoDialogo() {
		if(log.isInfoEnabled()) {
			log.info("TipoElementoDialogoImpl.listAllTipoElementoDialogo.INIT");
		}
		return tipoElementoDialogoJpa.findAll();
	}

	@Override
	public void addTipoElementoDialogo(TipoElementoDialogo ingreso) {
		if(log.isInfoEnabled()) {
			log.info("TipoElementoDialogoImpl.addTipoElementoDialogo.INIT");
		}
		tipoElementoDialogoJpa.save(ingreso);
		if(log.isInfoEnabled()) {
			log.info("TipoElementoDialogoImpl.addTipoElementoDialogo.END");
		}
	}
}
