package cl.usach.dminute.service;

import java.util.List;

import cl.usach.dminute.dto.ProyectoDto;
import cl.usach.dminute.entity.Proyecto;
import cl.usach.dminute.entity.UsuarioProyecto;

public interface ProyectoService {
	
	public abstract Proyecto crearNuevoProyecto(ProyectoDto guardar);
	
	public abstract Proyecto guardar(Proyecto guardar);
	
	public abstract Proyecto modificar(Proyecto guardar);
	
	public abstract void eliminar(long proyectoid, String userName);
	
	public abstract void saveUsuarioProyecto(UsuarioProyecto usuarioProyecto);
	
	public List<ProyectoDto> buscarProyectosByUsuario(String userName);
		
	public abstract Proyecto editarProyecto(ProyectoDto guardar);
	
	public abstract ProyectoDto buscarProyectoById(long proyectoId, String userName);

}
