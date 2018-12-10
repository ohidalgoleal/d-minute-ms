package cl.usach.dminute.service;

import java.util.List;

import cl.usach.dminute.dto.TemaDto;

public interface TemaService {
	
	public abstract TemaDto guardarModificar(TemaDto guardar, String userName);
	
	public abstract void eliminar(TemaDto guardar, String userName);
	
	public abstract List<TemaDto> listarTemaActa(long actaId);
	
	public abstract TemaDto findByIdTema(long temaId);

}
