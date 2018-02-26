package cl.usach.dminute.service;

import java.util.List;

import cl.usach.dminute.dto.NuevoProyecto;
import cl.usach.dminute.entity.Proyecto;
import cl.usach.dminute.entity.UsuarioProyecto;

public interface ProyectoService {
	
	public abstract Proyecto NuevoProyecto(NuevoProyecto guardar);
	
	public abstract Proyecto guardar(Proyecto guardar);
	
	public abstract Proyecto modificar(Proyecto guardar);
	
	public abstract void eliminar(Proyecto guardar);
	
	public abstract List<Proyecto> buscarProyectos();
	
	public abstract void saveUsuarioProyecto(List<UsuarioProyecto> usuarioProyecto);  
	

}
