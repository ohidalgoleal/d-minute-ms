package cl.usach.dminute.service;

import java.util.List;

import cl.usach.dminute.dto.ElementoDialogoDto;
import cl.usach.dminute.entity.ElementoDialogo;

public interface ElementoDialogoService {

	public abstract ElementoDialogo guardarModificar(ElementoDialogoDto guardar);
	
	public abstract void eliminar(ElementoDialogoDto guardar);
	
	public abstract ElementoDialogoDto getElemento(long elementoId);
	
	public abstract List<ElementoDialogoDto> getListaAllElementoDialogoActa(long actaId);
	
}
