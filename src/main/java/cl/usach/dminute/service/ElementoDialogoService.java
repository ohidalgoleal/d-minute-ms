package cl.usach.dminute.service;

import java.util.List;

import cl.usach.dminute.dto.ActualizaEstadoKanban;
import cl.usach.dminute.dto.ElementoDialogoDto;
import cl.usach.dminute.entity.ElementoDialogo;

public interface ElementoDialogoService {

	public abstract ElementoDialogo guardarModificar(ElementoDialogoDto guardar);
	
	public abstract void actualizaEstadoKanban(ActualizaEstadoKanban guardar);
	
	public abstract void eliminar(ElementoDialogoDto guardar);
	
	public abstract ElementoDialogoDto getElemento(long elementoId);
	
	public abstract List<ElementoDialogoDto> getListaAllElementoDialogoActa(long actaId);
	
	public abstract List<ElementoDialogoDto> getListaAllElementoDialogoProyecto(long proyectoId);
	
	public abstract List<ElementoDialogoDto> getListaAllElementoDialogoActaPendientes(long proyectoId, long actaId);
	
}
