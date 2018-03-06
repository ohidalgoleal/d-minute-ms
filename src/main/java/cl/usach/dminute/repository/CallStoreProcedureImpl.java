package cl.usach.dminute.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import cl.usach.dminute.entity.UsuarioProyecto;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("callStoreProcedureImpl")
public class CallStoreProcedureImpl {
	
	@PersistenceContext
	private EntityManager em;
	
	@ApiOperation("Método encargado de listar los proyectos de un usuario logeado.")
	public List<UsuarioProyecto> buscarProyectoPorUsuario(String usuario) {
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarProyectoPorUsuario.INIT");			
		}
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery( "getproyectoporusuario" );
		storedProcedureQuery.registerStoredProcedureParameter("_usuario",String.class, ParameterMode.IN);
		storedProcedureQuery.setParameter("_usuario", usuario);
		storedProcedureQuery.execute();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarProyectoPorUsuario.SpEjecutado");			
		}
		@SuppressWarnings("unchecked")		
		List<Object[]> results = storedProcedureQuery.getResultList();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarProyectoPorUsuario.listaUsuarios: " + results.size());			
		}
		List<UsuarioProyecto> retorno = null;
		if (results != null) {
			retorno= new ArrayList<UsuarioProyecto>();
			UsuarioProyecto usuarioProyecto = null;
			for (Object[] row : results) {
				usuarioProyecto = new UsuarioProyecto();
				usuarioProyecto.getProyecto().setProyectoId(Long.parseLong(row[1].toString()));
				retorno.add(usuarioProyecto);
			}
		}
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarProyectoPorUsuario.retorno: " + retorno.toString());
			log.info("CallStoreProcedureImpl.buscarProyectoPorUsuario.FIN");
		}
		return retorno;
	}
	
	@ApiOperation("Método encargado de listar los proyectos de un usuario logeado.")
	public void eliminarUsuariosProyecto(long proyectoId) {
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.eliminarUsuariosProyecto.INIT");			
		}
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery( "deleteallusuariosProyecto" );
		storedProcedureQuery.registerStoredProcedureParameter("_proyectoid",Long.class, ParameterMode.IN);
		storedProcedureQuery.setParameter("_proyectoid", proyectoId);
		storedProcedureQuery.execute();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.eliminarUsuariosProyecto.SpEjecutado");
			log.info("CallStoreProcedureImpl.eliminarUsuariosProyecto.FIN");
		}
	}
	
	@ApiOperation("Método encargado de eliminar las actas y elementos de dialogo.")
	public void eliminarActasElementos(long proyectoId) {
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.eliminarActasElementos.INIT");			
		}
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery( "XXXXX" );
		storedProcedureQuery.registerStoredProcedureParameter("_proyectoid",Long.class, ParameterMode.IN);
		storedProcedureQuery.setParameter("_proyectoid", proyectoId);
		storedProcedureQuery.execute();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.eliminarActasElementos.SpEjecutado");
			log.info("CallStoreProcedureImpl.eliminarActasElementos.FIN");
		}
	}

}
