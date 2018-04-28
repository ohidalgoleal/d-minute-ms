package cl.usach.dminute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.usach.dminute.entity.UsuarioActa;
import cl.usach.dminute.repository.CallStoreProcedureImpl;
import cl.usach.dminute.repository.UsuarioActaJpa;
import cl.usach.dminute.service.UsuarioActaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(value = "usuarioActaService")
public class UsuarioActaImpl implements UsuarioActaService {
	
	@Autowired
	@Qualifier("usuarioActaJpa")
	private UsuarioActaJpa usuarioActaJpa;
	
	@Autowired
	@Qualifier("callStoreProcedureImpl")
	private CallStoreProcedureImpl callStoreProcedureImpl;
	
	@Override
	public UsuarioActa save(UsuarioActa user) {
		if(log.isInfoEnabled()) {
			log.info("UsuarioActaImpl.save.INIT");
			log.info("UsuarioActaImpl.save.user:" + user.toString());
		}
		UsuarioActa retorno = null;
		try {
			 retorno = usuarioActaJpa.save(user);
		}catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("UsuarioActaImpl.save.ERROR - " + ex.getMessage());
			}
		}
		if (log.isInfoEnabled()) {
			log.info("UsuarioActaImpl.save.FIN");
		}		
		return retorno;
	}

	@Override
	public List<UsuarioActa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long idActa) {
		if(log.isInfoEnabled()) {
			log.info("UsuarioActaImpl.delete.INIT");
			log.info("UsuarioActaImpl.delete.idActa: " + idActa);
		}
		try {
			callStoreProcedureImpl.eliminarUsuariosActa(idActa);
		}catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("UsuarioActaImpl.delete.ERROR - " + ex.getMessage());
			}
		}
		if (log.isInfoEnabled()) {
			log.info("UsuarioActaImpl.delete.FIN");
		}
	}

}
