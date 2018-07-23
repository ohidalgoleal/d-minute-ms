package cl.usach.dminute.service.impl;

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
import cl.usach.dminute.repository.ElementoDialogoJpa;
import cl.usach.dminute.service.ElementoDialogoService;
import cl.usach.dminute.service.TemaService;
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
				elementoDialogo.setDescripcion(guardar.getDescripcion().toUpperCase());
				elementoDialogo.setElementoDialogo(null);
				elementoDialogo.setEstado(guardar.getEstado());
				elementoDialogo.setFechaCompromiso(guardar.getFechaCompromiso());
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
			if ((elementoDialogo != null) && (!elementoDialogo.getEstado().equals(Constants.estadoEliminadoElementoDialogo))) {
				if (log.isInfoEnabled()) {
					log.info("ElementoDialogoImpl.getElemento.elementoDialogo: " + elementoDialogo.toString());
				}
				elementoDialogoDto = new ElementoDialogoDto();
				elementoDialogoDto.setCodRol(elementoDialogo.getTipoElementoDialogo().getCodRol());
				elementoDialogoDto.setDescripcion(elementoDialogo.getDescripcion());
				elementoDialogoDto.setEstado(elementoDialogo.getEstado());
				elementoDialogoDto.setFechaCompromiso(elementoDialogo.getFechaCompromiso());
				elementoDialogoDto.setIdElemento(elementoId);
				elementoDialogoDto.setTemaId(elementoDialogo.getTema().getId());
				elementoDialogoDto.setUsername(elementoDialogo.getUsuario().getUsername());
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
}
