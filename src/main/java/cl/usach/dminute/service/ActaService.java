package cl.usach.dminute.service;

import java.util.List;

import cl.usach.dminute.dto.ActaDto;
import cl.usach.dminute.entity.Acta;

public interface ActaService {
	
	public abstract Acta guardarModificar(ActaDto guardar);
	
	public abstract void eliminar(ActaDto guardar);
	
	public abstract List<ActaDto> listarActaProyecto(long proyectoId);
	
	public abstract ActaDto getActa(long actaId);

}
