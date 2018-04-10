package cl.usach.dminute.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.dto.ProyectoDto;
import cl.usach.dminute.dto.ProyectoUsuariosDto;
import cl.usach.dminute.entity.Proyecto;
import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.entity.UsuarioProyecto;
import cl.usach.dminute.exception.ErrorTecnicoException;
import cl.usach.dminute.exception.ValidacionesException;
import cl.usach.dminute.repository.CallStoreProcedureImpl;
import cl.usach.dminute.repository.ProyectoJpa;
import cl.usach.dminute.repository.UsuarioProyectoJpa;
import cl.usach.dminute.service.ProyectoService;
import cl.usach.dminute.service.UsuarioService;
import cl.usach.dminute.util.Utilitario;
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

	@Autowired
	@Qualifier("callStoreProcedureImpl")
	private CallStoreProcedureImpl callStoreProcedureImpl;
	
	@Override
	public Proyecto crearNuevoProyecto(ProyectoDto guardar) {
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.crearNuevoProyecto.INIT");
			log.info("ProyectoImpl.crearNuevoProyecto.proyecto: " + guardar.toString());
		}
		Proyecto proyecto = new Proyecto();
		try {
			proyecto.setDescripcion(guardar.getDescripcion());
			proyecto.setFechaFin(guardar.getFechaFin());
			proyecto.setFechaInicio(guardar.getFechaInicio());
			proyecto.setNombre(guardar.getNombre());
			proyecto.setEstado(Constants.estadoActivo);
			if (log.isInfoEnabled()) {
				log.info("ProyectoImpl.crearNuevoProyecto.grabando...: " + proyecto.toString());
			}
			if (guardar.getProyectoId() == 0)
				proyecto = this.guardar(proyecto);
			else
				proyecto = this.modificar(proyecto);
			if (log.isInfoEnabled()) {
				log.info("ProyectoImpl.crearNuevoProyecto.grabarUsuarios");
			}
			procesarUsuarioProyecto(proyecto.getProyectoId(), guardar.getUsuariosNuevoProyecto());
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ProyectoImpl.crearNuevoProyecto.ERROR - " + ex.getMessage());
			}
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_PROYECTO_ERROR, null);
		}
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.crearNuevoProyecto.FIN");
		}
		return proyecto;
	}

	@Override
	public Proyecto guardar(Proyecto guardar) {
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.save.INIT");
			log.info("ProyectoImpl.save.proyecto: " + guardar.toString());
		}
		Proyecto proyecto = new Proyecto();
		try {
			guardar.setEstado(Constants.estadoActivo);
			proyecto = proyectoJpa.save(guardar);
			if (proyecto.getProyectoId() <= 0)
				throw new ErrorTecnicoException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_TECNICO_MENSAJE);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ProyectoImpl.save.proyecto.ERROR - " + ex.getMessage());
			}
			throw ex;
		}
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.save.FIN");
		}
		return proyecto;
	}

	@Override
	public Proyecto modificar(Proyecto guardar) {
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.modificar.INIT");
			log.info("ProyectoImpl.modificar.proyecto: " + guardar.toString());
		}
		Proyecto proyecto = new Proyecto();
		try {
			guardar.setEstado(Constants.estadoActivo);
			proyecto = proyectoJpa.save(guardar);
			if (proyecto.getProyectoId() <= 0)
				throw new ErrorTecnicoException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_TECNICO_MENSAJE);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ProyectoImpl.modificar.proyecto.ERROR - " + ex.getMessage());
			}
			throw ex;
		}
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.modificar.FIN");
		}
		return proyecto;
	}

	@Override
	public void eliminar(long proyectoid, String userName) {
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.eliminar.INIT");
			log.info("ProyectoImpl.eliminar.proyectoID: " + proyectoid);
		}
		try {
			
			List<ProyectoDto> validacion = buscarProyectosByUsuario(userName).stream().filter(a -> Objects.equals(a.getProyectoId(), proyectoid)).collect(Collectors.toList());
			
			if (!validacion.isEmpty()) {
				Proyecto proyecto = proyectoJpa.findByProyectoId(proyectoid);
				if (proyecto != null) {
					if (log.isInfoEnabled()) {
						log.info("ProyectoImpl.eliminar.usuariosProyecto");
					}
					proyecto.setEstado(Constants.estadoBloqueado);
					proyecto = proyectoJpa.save(proyecto);
				} else {
					throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD,
							Constants.ERROR_PROYECTO_NOEXISTE, null);
				}
			}else {
				throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD,
						Constants.ERROR_PROYECTO_NODUENO, null);
			}
			
			
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ProyectoImpl.eliminar.proyecto.ERROR - " + ex.getMessage());
			}
			throw ex;
		}
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.eliminar.FIN");
		}
	}

	@Override
	public void saveUsuarioProyecto(UsuarioProyecto usuarioProyecto) {
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.saveUsuarioProyecto.INIT");
			log.info("ProyectoImpl.saveUsuarioProyecto.usuarios: " + usuarioProyecto.toString());
		}
		try {
			Usuario validacion = usuarioService.findOne(usuarioProyecto.getUsuario().getUsername());
			if (validacion != null)
				usuarioProyectoJpa.save(usuarioProyecto);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ProyectoImpl.saveUsuarioProyecto.ERROR - " + ex.getMessage());
			}
			throw ex;
		}
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.saveUsuarioProyecto.FIN");
		}
	}

	@Override
	public List<ProyectoDto> buscarProyectosByUsuario(String userName) {

		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.buscarProyectosByUsuario.INIT");
		}
		List<ProyectoDto> listaProyecto = null;
		List<UsuarioProyecto> listaUsuario = callStoreProcedureImpl.buscarProyectoPorUsuario(userName);
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.buscarProyectosByUsuario.listausuarios: " + listaUsuario.toString());
		}		
		List<ProyectoUsuariosDto> listaUsuarioAll = callStoreProcedureImpl.buscarProyectoPorUsuarioAll(userName);
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.buscarProyectosByUsuario.listausuariosAll: " + listaUsuarioAll.toString());
		}
		if (listaUsuario != null) {
			listaProyecto = new ArrayList<ProyectoDto>();
			Proyecto proyecto = null;
			ProyectoDto retorno = null;
			for (UsuarioProyecto usuarioProyecto : listaUsuario) {
				proyecto = proyectoJpa.findByProyectoId(usuarioProyecto.getProyecto().getProyectoId());
				if (proyecto != null) {
					retorno = new ProyectoDto();
					retorno.setDescripcion(proyecto.getDescripcion());
					retorno.setNombre(proyecto.getNombre());
					retorno.setProyectoId(proyecto.getProyectoId());
					retorno.setFechaFin(Utilitario.formatoFecha(proyecto.getFechaFin().toString()));
					retorno.setFechaInicio(Utilitario.formatoFecha(proyecto.getFechaInicio().toString()));
					long proyectoid = proyecto.getProyectoId();
					if (log.isInfoEnabled()) {
						log.info("ProyectoImpl.buscarProyectosByUsuario.BuscarUsuarios.Proyecto: " + proyectoid);
					}
					List<ProyectoUsuariosDto> validacion = listaUsuarioAll.stream().filter(a -> Objects.equals(a.getProyectoId(), proyectoid )).collect(Collectors.toList());
					retorno.setUsuariosNuevoProyecto(validacion);
					listaProyecto.add(retorno);
				}	
			}
		}
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.buscarProyectosByUsuario.proyectos: " + listaProyecto.toString());
			log.info("ProyectoImpl.buscarProyectosByUsuario.FIN");
		}
		return listaProyecto;
	}

	@Override
	public Proyecto editarProyecto(ProyectoDto guardar) {
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.editarProyecto.INIT");
			log.info("ProyectoImpl.editarProyecto.proyecto: " + guardar.toString());
		}
		Proyecto proyecto = new Proyecto();
		try {
			proyecto.setDescripcion(guardar.getDescripcion());
			proyecto.setFechaFin(guardar.getFechaFin());
			proyecto.setFechaInicio(guardar.getFechaInicio());
			proyecto.setNombre(guardar.getNombre());
			proyecto.setProyectoId(guardar.getProyectoId());
			if (log.isInfoEnabled()) {
				log.info("ProyectoImpl.editarProyecto.modificando...:" + proyecto.toString());
			}
			proyecto = this.modificar(proyecto);
			if (log.isInfoEnabled()) {
				log.info("ProyectoImpl.editarProyecto..eliminarUsuarioAll");
			}
			callStoreProcedureImpl.eliminarUsuariosProyecto(proyecto.getProyectoId());
			if (log.isInfoEnabled()) {
				log.info("ProyectoImpl.editarProyecto.grabarUsuarios");
			}
			procesarUsuarioProyecto(proyecto.getProyectoId(), guardar.getUsuariosNuevoProyecto());
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ProyectoImpl.editarProyecto.ERROR - " + ex.getMessage());
			}
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_PROYECTO_ERROR, null);
		}
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.editarProyecto.FIN");
		}
		return proyecto;
	}

	private void procesarUsuarioProyecto(long proyectoId, List<ProyectoUsuariosDto> usuariosNuevoProyecto) {
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.procesarUsuarioProyecto.INIT");
			log.info("ProyectoImpl.procesarUsuarioProyecto.proyecto: " + proyectoId);
		}
		try {
			if (proyectoId > 0 && usuariosNuevoProyecto.size() > 0) {
				if (log.isInfoEnabled()) {
					log.info("ProyectoImpl.procesarUsuarioProyecto.grabandoUsuario.iterando.INI");
				}
				for (ProyectoUsuariosDto nuevoProyectoUsuarios : usuariosNuevoProyecto) {
					UsuarioProyecto usuarioProyecto = new UsuarioProyecto();
					if (log.isInfoEnabled()) {
						log.info("ProyectoImpl.procesarUsuarioProyecto.grabandoUsuario.usuarioProyecto.INI:"
								+ nuevoProyectoUsuarios.toString());
					}
					usuarioProyecto.getUsuario().setUsername(nuevoProyectoUsuarios.getUsername());
					usuarioProyecto.getProyecto().setProyectoId(proyectoId);
					this.saveUsuarioProyecto(usuarioProyecto);
					if (log.isInfoEnabled()) {
						log.info("ProyectoImpl.procesarUsuarioProyecto.grabandoUsuario.usuarioProyecto.FIN");
					}
				}
				if (log.isInfoEnabled()) {
					log.info("ProyectoImpl.procesarUsuarioProyecto.grabandoUsuario.iterando.FIN");
				}
			} else {
				if (log.isInfoEnabled()) {
					log.info("ProyectoImpl.procesarUsuarioProyecto.sinusuarios");
				}
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ProyectoImpl.procesarUsuarioProyecto.ERROR - " + ex.getMessage());
			}
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_PROYECTO_ERROR, null);
		}
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.procesarUsuarioProyecto.FIN");
		}
	}

	@Override
	public ProyectoDto buscarProyectoById(long proyectoId, String userName) {
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.buscarProyectoById.INIT");
			log.info("ProyectoImpl.buscarProyectoById.proyectoId: " + proyectoId);
		}
		List<ProyectoDto> lista = null;
		ProyectoDto retorno = null;
		try {
			lista = this.buscarProyectosByUsuario(userName);
			if (lista == null)
				throw new ErrorTecnicoException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_PROYECTO_NOEXISTE);
			List<ProyectoDto> validacion = lista.stream().filter(a -> Objects.equals(a.getProyectoId(), proyectoId )).collect(Collectors.toList());
			retorno = validacion.get(0);
			if (retorno == null)
				throw new ErrorTecnicoException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_PROYECTO_NOEXISTE);
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.info("ProyectoImpl.buscarProyectoById.proyecto.ERROR - " + ex.getMessage());
			}
			throw ex;
		}
		if (log.isInfoEnabled()) {
			log.info("ProyectoImpl.buscarProyectoById.FIN");
		}
		return retorno;
	}

}
