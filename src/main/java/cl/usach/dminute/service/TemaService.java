package cl.usach.dminute.service;

import java.util.List;

import cl.usach.dminute.dto.TemaDto;

public interface TemaService {
	
	public abstract TemaDto guardarModificar(TemaDto guardar);
	
	public abstract void eliminar(TemaDto guardar);
	
	public abstract List<TemaDto> listarTemaActa(long actaId);
	
	public abstract TemaDto findByIdTema(long temaId);

}
