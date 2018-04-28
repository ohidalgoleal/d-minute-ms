package cl.usach.dminute.service;

import java.util.List;

import cl.usach.dminute.entity.UsuarioActa;

public interface UsuarioActaService {
	
	public abstract UsuarioActa save(UsuarioActa user);
    
	public abstract List<UsuarioActa> findAll();
    
	public abstract void delete(long idActa);
   

}
