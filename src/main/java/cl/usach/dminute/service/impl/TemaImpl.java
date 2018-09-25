package cl.usach.dminute.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.dto.ElementoDialogoDto;
import cl.usach.dminute.dto.TemaDto;
import cl.usach.dminute.entity.Acta;
import cl.usach.dminute.entity.Tema;
import cl.usach.dminute.exception.ValidacionesException;
import cl.usach.dminute.repository.ActaJpa;
import cl.usach.dminute.repository.TemaJpa;
import cl.usach.dminute.service.ElementoDialogoService;
import cl.usach.dminute.service.TemaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("temaService")
public class TemaImpl implements TemaService {
	
	@Autowired
	@Qualifier("temaJpa")
	private TemaJpa temaJpa;
	
	@Autowired
	@Qualifier("actaJpa")
	private ActaJpa actaJpa;
	
	@Autowired
	@Qualifier("elementoDialogoService")
	private ElementoDialogoService elementoDialogoService;
	
	@Override
	public TemaDto guardarModificar(TemaDto guardar) {
		if (log.isInfoEnabled()) {
			log.info("TemaImpl.guardarModificar.INIT");
			log.info("TemaImpl.guardarModificar.tema: " + guardar.toString());
		}
		try {
			Acta acta = actaJpa.findByActaId(guardar.getActaId());
			if (acta != null) {
				Tema nuevo = new Tema();
				nuevo.setId(guardar.getId());
				nuevo.setActa(acta);
				nuevo.setDiscusion(guardar.getDiscusion().toUpperCase());
				nuevo.setNombre(guardar.getNombre().toUpperCase());
				nuevo.setEstado(Constants.estadoActivo);
				nuevo = temaJpa.save(nuevo);
				guardar.setId(nuevo.getId());
			}else {
				throw new Exception();
			}			
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("TemaImpl.guardarModificar.ERROR - " + ex.getMessage());
			}
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_TEMA_ERROR, null);
		}
		if (log.isInfoEnabled()) {
			log.info("TemaImpl.guardarModificar.FIN");
		}	
		return guardar;
	}

	@Override
	public void eliminar(TemaDto guardar) {
		if (log.isInfoEnabled()) {
			log.info("TemaImpl.eliminar.INIT");
			log.info("TemaImpl.eliminar.tema: " + guardar.toString());
		}
		try {
			Acta acta = actaJpa.findByActaId(guardar.getActaId());
			if (acta != null) {
				Tema delete = temaJpa.findOne(guardar.getId());
				if (delete != null) {
					delete.setEstado(Constants.estadoBloqueado);
					temaJpa.save(delete);
				}	
				else
					throw new Exception();
			}else
				throw new Exception();									
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("TemaImpl.eliminar.ERROR - " + ex.getMessage());
			}
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_TEMA_DEL_ERROR, null);
		}
		if (log.isInfoEnabled()) {
			log.info("TemaImpl.eliminar.FIN");
		}		
	}

	@Override
	public List<TemaDto> listarTemaActa(long actaId) {
		if (log.isInfoEnabled()) {
			log.info("TemaImpl.listarTemaActa.INIT");
			log.info("TemaImpl.listarTemaActa.actaId: " + actaId);
		}
		List<TemaDto> lista = new ArrayList<TemaDto>();
		try {
			Acta acta = actaJpa.findByActaId(actaId);
			if (acta == null) {
				throw new Exception();
			}
			List<Tema> retorno = temaJpa.findByActaActaId(actaId);
			List<ElementoDialogoDto> listaElementos = elementoDialogoService.getListaAllElementoDialogoActa(actaId);
			if (log.isInfoEnabled()) {
				log.info("TemaImpl.findByIdTema.listaRetornoElementos: + " + listaElementos);
			}	
			
			for (Tema tema : retorno) {
				if (tema.getEstado().equalsIgnoreCase(Constants.estadoActivo)) {
					TemaDto temaDto = new TemaDto();
					temaDto.setActaId(tema.getActa().getActaId());
					temaDto.setDiscusion(tema.getDiscusion());
					temaDto.setId(tema.getId());
					temaDto.setNombre(tema.getNombre());
					if (log.isInfoEnabled()) {
						log.info("TemaImpl.findByIdTema.ObteniendoElementos.Tema: " + tema.getId());
					}	
					List<ElementoDialogoDto> validacion = listaElementos.stream().filter(a -> Objects.equals(a.getTemaId(), tema.getId())).collect(Collectors.toList());
					temaDto.setElementoDialogoDto(validacion);
					lista.add(temaDto);
				}
			}						
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("TemaImpl.listarTemaActa.ERROR - " + ex.getMessage());
			}
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_TECNICO_MENSAJE, null);
		}
		if (log.isInfoEnabled()) {
			log.info("TemaImpl.listarTemaActa.lista: " + lista.toString());
			log.info("TemaImpl.listarTemaActa.FIN");
		}		
		return lista;
	}

	@Override
	public TemaDto findByIdTema(long temaId) {
		if (log.isInfoEnabled()) {
			log.info("TemaImpl.findByIdTema.INIT");
			log.info("TemaImpl.findByIdTema.temaId: " + temaId);
		}
		TemaDto temaDto = null;
		try {
			Tema tema = temaJpa.findOne(temaId);
			if (tema != null) {
				temaDto = new TemaDto();
				temaDto.setActaId(tema.getActa().getActaId());
				temaDto.setDiscusion(tema.getDiscusion());
				temaDto.setId(tema.getId());
				temaDto.setNombre(tema.getNombre());
				if (log.isInfoEnabled()) {
					log.info("TemaImpl.findByIdTema.tema: " + temaDto.toString());
				}	
			}						
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("TemaImpl.findByIdTema.ERROR - " + ex.getMessage());
			}
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_TECNICO_MENSAJE, null);
		}
		if (log.isInfoEnabled()) {
			log.info("TemaImpl.findByIdTema.FIN");
		}		
		return temaDto;
	}

}
