package cl.usach.dminute.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.usach.dminute.dto.ActaDto;
import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.dto.UsuarioActaDto;
import cl.usach.dminute.entity.Acta;
import cl.usach.dminute.entity.Proyecto;
import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.entity.UsuarioActa;
import cl.usach.dminute.exception.ValidacionesException;
import cl.usach.dminute.repository.ActaJpa;
import cl.usach.dminute.repository.CallStoreProcedureImpl;
import cl.usach.dminute.repository.ProyectoJpa;
import cl.usach.dminute.service.ActaService;
import cl.usach.dminute.service.TemaService;
import cl.usach.dminute.service.UsuarioActaService;
import cl.usach.dminute.service.UsuarioService;
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
	
	@Autowired
	@Qualifier("usuarioActaService")
	private UsuarioActaService usuarioActaService;
	
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@Autowired
	@Qualifier("temaService")
	private TemaService temaService;
	
	@Override
	public Acta guardarModificar(ActaDto guardar) {
		if (log.isInfoEnabled()) {
			log.info("ActaImpl.guardarModificarActa.INIT");
			log.info("ActaImpl.guardarModificarActa.acta: " + guardar.toString());
		}
		Acta acta = null;
		List<UsuarioActaDto> listaUsuario = guardar.getUsuarioActa(); 
		try {
			if (proyectoJpa.findByProyectoId(guardar.getProyectoId()) != null) {
				acta = new Acta();
				acta.setActaId(guardar.getActaId());
				acta.setCorrelativo(guardar.getCorrelativo());
				acta.setEstado(Constants.estadoActivo);
				acta.setFecha(guardar.getFecha());
				Proyecto _pry = new Proyecto();
				_pry.setProyectoId(guardar.getProyectoId());
				acta.setProyecto(_pry);
				acta.setResumen(guardar.getResumen().toUpperCase());
				acta = actaJpa.save(acta);
			}			
			if (acta == null)
				throw new Exception();
			else {
				if (log.isInfoEnabled()) {
					log.info("ActaImpl.guardarModificarActa.acta: " + acta.toString());
					log.info("ActaImpl.guardarModificarActa.eliminarUsuario");
				}
				usuarioActaService.delete(acta.getActaId());
				if (log.isInfoEnabled()) {
					log.info("ActaImpl.guardarModificarActa.recorriendoUsuarios");
				}
				for (UsuarioActaDto usuarioActaDto : listaUsuario) {
					if (log.isInfoEnabled()) {
						log.info("ActaImpl.guardarModificarActa.grabandoUsuario.INI");						
					}
					Usuario validacion = null;
					try {
						validacion = usuarioService.findOne(usuarioActaDto.getUsername());
					} catch (Exception ex) {
						if (log.isErrorEnabled()) {
							log.info("ActaImpl.guardarModificarActa.grabandoUsuario.usuarioInvalido: " + usuarioActaDto.getUsername());
						}
					}
					if (validacion != null) {
						UsuarioActa usuarioActa = new UsuarioActa();
						usuarioActa.setActa(acta);
						usuarioActa.setAsiste(usuarioActaDto.getAsiste());
						usuarioActa.setSecretario(usuarioActaDto.getSecretario());
						usuarioActa.setUsuario(validacion);
						if (log.isInfoEnabled()) {
							log.info("ActaImpl.guardarModificarActa.grabandoUsuario: " + usuarioActa);						
						}
						usuarioActaService.save(usuarioActa);
					}
					if (log.isInfoEnabled()) {
						log.info("ActaImpl.guardarModificarActa.grabandoUsuario.FIN");						
					}						
				}
			}
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
	public void eliminar(ActaDto guardar) {
		if (log.isInfoEnabled()) {
			log.info("ActaImpl.eliminarActa.INIT");
			log.info("ActaImpl.eliminarActa.acta: " + guardar.toString());
		}
		Acta acta = null;
		try {
			if (proyectoJpa.findByProyectoId(guardar.getProyectoId()) != null) {
				acta = new Acta();
				acta.setActaId(guardar.getActaId());
				acta.setCorrelativo(guardar.getCorrelativo());
				acta.setEstado(Constants.estadoBloqueado);
				acta.setFecha(guardar.getFecha());
				Proyecto _pry = new Proyecto();
				_pry.setProyectoId(guardar.getProyectoId());
				acta.setProyecto(_pry);
				acta.setResumen(guardar.getResumen());				
				acta = actaJpa.save(acta);
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
	public List<ActaDto> listarActaProyecto(long proyectoId) {
		if (log.isInfoEnabled()) {
			log.info("ActaImpl.listarActaProyecto.INIT");
			log.info("ActaImpl.listarActaProyecto.Proyecto: " + proyectoId);
		}
		List<ActaDto> listarActa = new ArrayList<ActaDto>();
		try {
			if (proyectoJpa.findByProyectoId(proyectoId) != null) {
				listarActa = callStoreProcedureImpl.buscarActasProyecto(proyectoId);
			}else {
				throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_PROYECTO_NOEXISTE, null);
			}				
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ActaImpl.listarActaProyecto.ERROR - " + ex.getMessage());
			}
			throw ex;			
		}
		if (log.isInfoEnabled()) {
			log.info("ActaImpl.listarActaProyecto.FIN");
		}
		return listarActa;
	}

		@Override
	public ActaDto getActa(long actaId) {
		if (log.isInfoEnabled()) {
			log.info("ActaImpl.getActa.INIT");
			log.info("ActaImpl.getActa.NumeroActa: " + actaId);
		}
		ActaDto actaDto = new ActaDto();
		try {
			Acta acta = actaJpa.findByActaId(actaId);
			if (acta == null) 
				throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_ACTA_ERROR, null);
			if (log.isInfoEnabled()) {
				log.info("ActaImpl.getActa.acta: " + acta.toString());
			}
			actaDto.setActaId(acta.getActaId());
			actaDto.setCorrelativo(acta.getCorrelativo());
			actaDto.setEstado(acta.getEstado());
			actaDto.setFecha(acta.getFecha());
			actaDto.setProyectoId(acta.getProyecto().getProyectoId());
			actaDto.setResumen(acta.getResumen());
			List<UsuarioActaDto> listaUsuarioActaResponse = callStoreProcedureImpl.buscarUsuarioActaProyectoAll(acta.getProyecto().getProyectoId());
			List<UsuarioActaDto> validacion = listaUsuarioActaResponse.stream().filter(a -> Objects.equals(a.getActaId(), actaDto.getActaId() )).collect(Collectors.toList());
			actaDto.setUsuarioActa(validacion);
			actaDto.setTemaActa(temaService.listarTemaActa(actaId));
			if (log.isInfoEnabled()) {
				log.info("ActaImpl.getActa.retorno:" + actaDto);
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ActaImpl.getActa.ERROR - " + ex.getMessage());
			}
			throw ex;			
		}
		if (log.isInfoEnabled()) {
			log.info("ActaImpl.getActa.FIN");
		}
		return actaDto;
	}

}
