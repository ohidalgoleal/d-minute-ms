package cl.usach.dminute.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.usach.dminute.dto.ActaResponse;
import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.entity.Acta;
import cl.usach.dminute.exception.ValidacionesException;
import cl.usach.dminute.repository.ActaJpa;
import cl.usach.dminute.repository.CallStoreProcedureImpl;
import cl.usach.dminute.repository.ProyectoJpa;
import cl.usach.dminute.service.ActaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("actaService")
public class ActaImpl implements ActaService {

	@Autowired
	@Qualifier("actaJpa")
	private ActaJpa actaJpa;
	
	@Autowired
	@Qualifier("proyectoJpa")
	private ProyectoJpa proyectoJpa;
	
	@Autowired
	@Qualifier("callStoreProcedureImpl")
	private CallStoreProcedureImpl callStoreProcedureImpl;
	
	@Override
	public Acta guardarModificar(Acta guardar) {
		if (log.isInfoEnabled()) {
			log.info("ActaImpl.guardarModificarActa.INIT");
			log.info("ActaImpl.guardarModificarActa.acta: " + guardar.toString());
		}
		Acta acta = null;
		try {
			if (proyectoJpa.findByProyectoId(guardar.getProyecto().getProyectoId()) != null) {
				guardar.setEstado(Constants.estadoActivo);
				acta = actaJpa.save(guardar);
			}			
			if (acta == null)
				throw new Exception();			
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ActaImpl.guardarModificarActa.ERROR - " + ex.getMessage());
			}
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_ACTA_ERROR, null);
		}
		if (log.isInfoEnabled()) {
			log.info("ActaImpl.guardarModificarActa.FIN");
		}
		return acta;
	}

	@Override
	public void eliminar(Acta guardar) {
		if (log.isInfoEnabled()) {
			log.info("ActaImpl.eliminarActa.INIT");
			log.info("ActaImpl.eliminarActa.acta: " + guardar.toString());
		}
		Acta acta = null;
		try {
			if (proyectoJpa.findByProyectoId(guardar.getProyecto().getProyectoId()) != null) {
				guardar.setEstado(Constants.estadoBloqueado);
				acta = actaJpa.save(guardar);
			}
			if (acta == null)
				throw new Exception();			
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ActaImpl.eliminarActa.ERROR - " + ex.getMessage());
			}
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_ACTA_ERROR, null);
		}
		if (log.isInfoEnabled()) {
			log.info("ActaImpl.eliminarActa.FIN");
		}
	}

	@Override
	public List<ActaResponse> listarActa(long proyectoId) {
		if (log.isInfoEnabled()) {
			log.info("ActaImpl.listarActa.INIT");
			log.info("ActaImpl.listarActa.Proyecto: " + proyectoId);
		}
		List<ActaResponse> listarActa = new ArrayList<ActaResponse>();
		try {
			if (proyectoJpa.findByProyectoId(proyectoId) != null) {
				listarActa = callStoreProcedureImpl.buscarActasProyecto(proyectoId);
			}else {
				throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_PROYECTO_NOEXISTE, null);
			}				
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ActaImpl.listarActa.ERROR - " + ex.getMessage());
			}
			throw ex;			
		}
		if (log.isInfoEnabled()) {
			log.info("ActaImpl.listarActa.FIN");
		}
		return listarActa;
	}

}