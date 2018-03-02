package cl.usach.dminute.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.dto.NuevoProyecto;
import cl.usach.dminute.dto.NuevoProyectoUsuarios;
import cl.usach.dminute.entity.Proyecto;
import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.entity.UsuarioProyecto;
import cl.usach.dminute.exception.ErrorTecnicoException;
import cl.usach.dminute.exception.ValidacionesException;
import cl.usach.dminute.repository.ProyectoJpa;
import cl.usach.dminute.repository.UsuarioProyectoJpa;
import cl.usach.dminute.service.ProyectoService;
import cl.usach.dminute.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("proyectoService")
public class ProyectoImpl implements ProyectoService {

	@Autowired
	@Qualifier("proyectoJpa")
	private ProyectoJpa proyectoJpa; 

	@Autowired
	@Qualifier("usuarioProyectoJpa")
	private UsuarioProyectoJpa usuarioProyectoJpa; 

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService; 

	@Override
	public Proyecto guardar(Proyecto guardar) {
		if(log.isInfoEnabled()) {
			log.info("ProyectoImpl.save.INIT");
			log.info("ProyectoImpl.save.proyecto: " + guardar.toString());
		}
		Proyecto proyecto = new Proyecto();
		try {
			proyecto = proyectoJpa.save(guardar);
			if (proyecto.getProyectoId()<=0)
				throw new ErrorTecnicoException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_TECNICO_MENSAJE);				
		}catch(Exception ex) {
			if(log.isErrorEnabled()) {
				log.info("ProyectoImpl.save.proyecto.ERROR - " + ex.getMessage());			
			}	
			throw ex;
		}
		return proyecto;
	}

	@Override
	public Proyecto modificar(Proyecto guardar) {
		if(log.isInfoEnabled()) {
			log.info("ProyectoImpl.modificar.INIT");
			log.info("ProyectoImpl.modificar.proyecto: " + guardar.toString());
		}
		Proyecto proyecto = new Proyecto();
		try {
			proyecto = proyectoJpa.save(guardar);
			if (proyecto.getProyectoId()>0)
				throw new ErrorTecnicoException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_TECNICO_MENSAJE);				
		}catch(Exception ex) {
			if(log.isErrorEnabled()) {
				log.info("ProyectoImpl.modificar.proyecto.ERROR - " + ex.getMessage());			
			}	
			throw ex;
		}
		return proyecto;
	}

	@Override
	public void eliminar(Proyecto guardar) {
		// TODO Auto-generated method stub

	}

	@Override	
	public void saveUsuarioProyecto(UsuarioProyecto usuarioProyecto) {
		if(log.isInfoEnabled()) {
			log.info("ProyectoImpl.saveUsuarioProyecto.INIT");
			log.info("ProyectoImpl.saveUsuarioProyecto.usuarios: " + usuarioProyecto.toString());
		}
		try {
			Usuario validacion = usuarioService.findOne(usuarioProyecto.getUsuario().getUsername()); 
			if (validacion != null)
				usuarioProyectoJpa.save(usuarioProyecto);				
		}catch(Exception ex) {
			if(log.isErrorEnabled()) {
				log.info("ProyectoImpl.saveUsuarioProyecto.ERROR - " + ex.getMessage());			
			}	
			throw ex;
		}
	}

	@Override
	public Proyecto crearNuevoProyecto(NuevoProyecto guardar) {
		if(log.isInfoEnabled()) {
			log.info("ProyectoImpl.crearNuevoProyecto.INIT");
			log.info("ProyectoImpl.crearNuevoProyecto.proyecto: " + guardar.toString());
		}
		Proyecto proyecto = new Proyecto();
		try {
			proyecto.setDescripcion(guardar.getDescripcion());
			proyecto.setFechaFin(guardar.getFechaFin());
			proyecto.setFechaInicio(guardar.getFechaInicio());
			proyecto.setNombre(guardar.getNombre());
			if(log.isInfoEnabled()) {
				log.info("ProyectoImpl.crearNuevoProyecto.grabando...:" + proyecto.toString());
			}
			if (guardar.getProyectoId() == 0)
				proyecto = this.guardar(proyecto);
			else
				proyecto = this.modificar(proyecto);
			if (proyecto.getProyectoId()> 0 && guardar.getUsuariosNuevoProyecto().size()>0) {
				if(log.isInfoEnabled()) {
					log.info("ProyectoImpl.crearNuevoProyecto.grabandoUsuario.iterando.INI:" + proyecto.toString());
				}
				for (NuevoProyectoUsuarios nuevoProyectoUsuarios : guardar.getUsuariosNuevoProyecto()) {
					UsuarioProyecto usuarioProyecto = new UsuarioProyecto();
					if(log.isInfoEnabled()) {
						log.info("ProyectoImpl.crearNuevoProyecto.grabar.usuario.INI:" + nuevoProyectoUsuarios.toString());
					}
					usuarioProyecto.getUsuario().setUsername(nuevoProyectoUsuarios.getUsername());
					usuarioProyecto.setRolProyecto(null);
					usuarioProyecto.getProyecto().setProyectoId(proyecto.getProyectoId());
					this.saveUsuarioProyecto(usuarioProyecto);
					if(log.isInfoEnabled()) {
						log.info("ProyectoImpl.crearNuevoProyecto.grabar.usuario.FIN");
					}
				}
				if(log.isInfoEnabled()) {
					log.info("ProyectoImpl.crearNuevoProyecto.grabandoUsuario.iterando.FIN:" + proyecto.toString());
				}				
			}else {
				if(log.isInfoEnabled()) {
					log.info("ProyectoImpl.crearNuevoProyecto.sin.usuarios");
				}
			}				
		}catch(Exception ex) {
			if(log.isErrorEnabled()) {
				log.info("ProyectoImpl.crearNuevoProyecto.ERROR - " + ex.getMessage());			
			}	
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_PROYECTO_ERROR, null);
		}
		return proyecto;
	}

	@Override
	public List<Proyecto> buscarProyectosByUsuario(String userName) {
		
		List<Proyecto> listaProyecto = null; 
		Usuario user = new Usuario();
		user.setUsername(userName);
		
		Optional<UsuarioProyecto> listaUsuario = usuarioProyectoJpa.agruparPorUsuario(userName.trim());
		if(log.isInfoEnabled()) {
			log.info("ProyectoImpl.buscarProyectosByUsuario.listausuarios: " + listaUsuario.toString());
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
