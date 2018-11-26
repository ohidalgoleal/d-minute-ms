package cl.usach.dminute.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.dto.ElementoDialogoDto;
import cl.usach.dminute.entity.ElementoDialogo;
import cl.usach.dminute.entity.Tema;
import cl.usach.dminute.entity.TipoElementoDialogo;
import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.exception.ValidacionesException;
import cl.usach.dminute.repository.CallStoreProcedureImpl;
import cl.usach.dminute.repository.ElementoDialogoJpa;
import cl.usach.dminute.service.ElementoDialogoService;
import cl.usach.dminute.service.TemaService;
import cl.usach.dminute.util.Utilitario;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("elementoDialogoService")
public class ElementoDialogoImpl implements ElementoDialogoService {
	
	@Autowired
	@Qualifier("elementoDialogoJpa")
	private ElementoDialogoJpa elementoDialogoJpa;
	
	@Autowired
	@Qualifier("temaService")
	private TemaService temaService;
	
	@Autowired
	@Qualifier("callStoreProcedureImpl")
	private CallStoreProcedureImpl callStoreProcedureImpl;
	
	@Override
	public ElementoDialogo guardarModificar(ElementoDialogoDto guardar) {
		if (log.isInfoEnabled()) {
			log.info("ElementoDialogoImpl.guardarModificarElementoDialogo.INIT");
			log.info("ElementoDialogoImpl.guardarModificarElementoDialogo.elemento: " + guardar.toString());
		}
		ElementoDialogo elementoDialogo = null;
		
		try {
			if (temaService.findByIdTema(guardar.getTemaId()) != null) {
				elementoDialogo = new ElementoDialogo();
				String cadena = "";
				if (guardar.getDescripcion() != null)
					cadena = guardar.getDescripcion();
				elementoDialogo.setDescripcion(cadena.toUpperCase());
				elementoDialogo.setTitulo(guardar.getTitulo().toUpperCase());
				elementoDialogo.setElementoDialogo(null);
				elementoDialogo.setEstado(guardar.getEstado());
				elementoDialogo.setFechaCompromiso(Utilitario.formatoFecha(guardar.getFechaCompromiso()));
				elementoDialogo.setId(guardar.getIdElemento());
				Tema tema = new Tema();
				tema.setId(guardar.getTemaId());
				elementoDialogo.setTema(tema);
				TipoElementoDialogo tipoElementoDialogo = new TipoElementoDialogo();
				tipoElementoDialogo.setCodRol(guardar.getCodRol());
				elementoDialogo.setTipoElementoDialogo(tipoElementoDialogo);
				Usuario usuario = new Usuario();
				usuario.setUsername(guardar.getUsername());
				elementoDialogo.setUsuario(usuario);
				if (log.isInfoEnabled()) {
					log.info("ElementoDialogoImpl.guardarModificarElementoDialogo.GUARDAR: " + elementoDialogo.toString());
				}
				if (elementoDialogo.getId() == 0) {
					elementoDialogo.setCorrelativo(this.contarListaAllElementoDialogoActa(guardar.getTemaId()));
				}
				elementoDialogo = elementoDialogoJpa.save(elementoDialogo);
			}			
			if (elementoDialogo == null)
				throw new Exception();
			
			if (log.isInfoEnabled()) {
					log.info("ElementoDialogoImpl.guardarModificarElementoDialogo.elementoDialogo: " + elementoDialogo.toString());
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ElementoDialogoImpl.guardarModificarElementoDialogo.ERROR - " + ex.getMessage());
			}
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_ELEMENTO_ERROR, null);
		}
		if (log.isInfoEnabled()) {
			log.info("ElementoDialogoImpl.guardarModificarElementoDialogo.FIN");
		}
		return elementoDialogo;
	}

	@Override
	public void eliminar(ElementoDialogoDto guardar) {
		if (log.isInfoEnabled()) {
			log.info("ElementoDialogoImpl.eliminar.INIT");
			log.info("ElementoDialogoImpl.eliminar.elemento: " + guardar.toString());
		}
		try {
			guardar.setEstado(Constants.estadoEliminadoElementoDialogo);
			guardarModificar(guardar);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ElementoDialogoImpl.eliminar.ERROR - " + ex.getMessage());
			}
			throw ex;
		}
		if (log.isInfoEnabled()) {
			log.info("ElementoDialogoImpl.eliminar.FIN");
		}
	}

	@Override
	public ElementoDialogoDto getElemento(long elementoId) {
		if (log.isInfoEnabled()) {
			log.info("ElementoDialogoImpl.getElemento.INIT");
			log.info("ElementoDialogoImpl.getElemento.elemento: " + elementoId);
		}
		ElementoDialogoDto elementoDialogoDto = null;
		try {
			ElementoDialogo elementoDialogo = elementoDialogoJpa.findOne(elementoId);
			if (elementoDialogo != null){
				if (log.isInfoEnabled()) {
					log.info("ElementoDialogoImpl.getElemento.elementoDialogo: " + elementoDialogo.toString());
				}
				elementoDialogoDto = new ElementoDialogoDto();
				elementoDialogoDto.setCodRol(elementoDialogo.getTipoElementoDialogo().getCodRol());
				elementoDialogoDto.setDescripcion(elementoDialogo.getDescripcion());
				elementoDialogoDto.setEstado(elementoDialogo.getEstado());
				elementoDialogoDto.setFechaCompromiso(Utilitario.formatoFecha(elementoDialogo.getFechaCompromiso()));
				elementoDialogoDto.setIdElemento(elementoId);
				elementoDialogoDto.setTemaId(elementoDialogo.getTema().getId());
				elementoDialogoDto.setUsername(elementoDialogo.getUsuario().getUsername());
				elementoDialogoDto.setTitulo(elementoDialogo.getTitulo());
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ElementoDialogoImpl.getElemento.ERROR - " + ex.getMessage());
			}
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_TECNICO_MENSAJE, null);
		}
		if (log.isInfoEnabled()) {
			log.info("ElementoDialogoImpl.getElemento.FIN");
		}
		return elementoDialogoDto;
	}

	@Override
	public List<ElementoDialogoDto> getListaAllElementoDialogoActa(long actaId) {
		if (log.isInfoEnabled()) {
			log.info("ElementoDialogoImpl.listaAllElementoDialogoActa.INIT");
			log.info("ElementoDialogoImpl.listaAllElementoDialogoActa.idActa: " + actaId);
		}
		List<ElementoDialogoDto> lista = new ArrayList<ElementoDialogoDto>();
		try {
			lista=callStoreProcedureImpl.buscarElementosDialogoTemasDeActaProyectoAll(actaId);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ElementoDialogoImpl.listaAllElementoDialogoActa.ERROR - " + ex.getMessage());
			}
			throw ex;
		}
		if (log.isInfoEnabled()) {
			log.info("ElementoDialogoImpl.listaAllElementoDialogoActa.lista: " + lista);
			log.info("ElementoDialogoImpl.listaAllElementoDialogoActa.FIN");
		}
		return lista;
	}
	
	@Override
	public List<ElementoDialogoDto> getListaAllElementoDialogoProyecto(long proyectoId) {
		if (log.isInfoEnabled()) {
			log.info("ElementoDialogoImpl.getListaAllElementoDialogoProyecto.INIT");
			log.info("ElementoDialogoImpl.getListaAllElementoDialogoProyecto.proyectoId: " + proyectoId);
		}
		List<ElementoDialogoDto> lista = new ArrayList<ElementoDialogoDto>();
		try {
			lista=callStoreProcedureImpl.buscarElementosDialogoTemasDeProyectoAll(proyectoId);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ElementoDialogoImpl.getListaAllElementoDialogoProyecto.ERROR - " + ex.getMessage());
			}
			throw ex;
		}
		if (log.isInfoEnabled()) {
			log.info("ElementoDialogoImpl.getListaAllElementoDialogoProyecto.lista: " + lista);
			log.info("ElementoDialogoImpl.getListaAllElementoDialogoProyecto.FIN");
		}
		return lista;
	}
	
	private long contarListaAllElementoDialogoActa(long temaId) {
		long actaId = this.temaService.findByIdTema(temaId).getActaId();
		return callStoreProcedureImpl.contarElementosDialogoTemasDeActaProyectoAll(actaId) + 1;
	}
}
