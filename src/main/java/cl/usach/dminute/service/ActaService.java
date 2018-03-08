package cl.usach.dminute.service;

import java.util.List;

import cl.usach.dminute.dto.ActaResponse;
import cl.usach.dminute.entity.Acta;

public interface ActaService {
	
	public abstract Acta guardarModificar(Acta guardar);
	
	public abstract void eliminar(Acta guardar);
	
	public abstract List<ActaResponse> listarActa(long proyectoId);

}
