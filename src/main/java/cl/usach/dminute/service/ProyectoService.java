package cl.usach.dminute.service;

import java.util.List;

import cl.usach.dminute.dto.NuevoProyecto;
import cl.usach.dminute.entity.Proyecto;
import cl.usach.dminute.entity.UsuarioProyecto;

public interface ProyectoService {
	
	public abstract Proyecto crearNuevoProyecto(NuevoProyecto guardar);
	
	public abstract Proyecto guardar(Proyecto guardar);
	
	public abstract Proyecto modificar(Proyecto guardar);
	
	public abstract void eliminar(long proyectoid);
	
	public abstract void saveUsuarioProyecto(UsuarioProyecto usuarioProyecto);
	
	public abstract List<Proyecto> buscarProyectosByUsuario(String userName);
		
	public abstract Proyecto editarProyecto(NuevoProyecto guardar);

}
