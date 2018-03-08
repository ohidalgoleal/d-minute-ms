package cl.usach.dminute.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import cl.usach.dminute.dto.ActaResponse;
import cl.usach.dminute.dto.ProyectoUsuariosDto;
import cl.usach.dminute.dto.ActaResponse.UsuarioActaResponse;
import cl.usach.dminute.entity.UsuarioProyecto;
import cl.usach.dminute.util.Utilitario;
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
	
	@ApiOperation("Método encargado de listar los usuario del proyecto por usuario logeado.")
	public List<ProyectoUsuariosDto> buscarProyectoPorUsuarioAll(String usuario) {
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarProyectoPorUsuarioAll.INIT");			
		}
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery( "getproyectoporusuarioall" );
		storedProcedureQuery.registerStoredProcedureParameter("_usuario",String.class, ParameterMode.IN);
		storedProcedureQuery.setParameter("_usuario", usuario);
		storedProcedureQuery.execute();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarProyectoPorUsuarioAll.SpEjecutado");			
		}
		@SuppressWarnings("unchecked")		
		List<Object[]> results = storedProcedureQuery.getResultList();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarProyectoPorUsuarioAll.listaUsuarios: " + results.size());			
		}
		List<ProyectoUsuariosDto> retorno = null;
		if (results != null) {
			retorno= new ArrayList<ProyectoUsuariosDto>();
			ProyectoUsuariosDto usuarioProyecto = null;
			for (Object[] row : results) {
				usuarioProyecto = new ProyectoUsuariosDto();
				usuarioProyecto.setProyectoId(Long.parseLong(row[1].toString()));
				usuarioProyecto.setUsername(row[2].toString());
				retorno.add(usuarioProyecto);
			}
		}
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarProyectoPorUsuario.retorno: " + retorno.toString());
			log.info("CallStoreProcedureImpl.buscarProyectoPorUsuario.FIN");
		}
		return retorno;
	}
	
	@ApiOperation("Método encargado de listar las actas de un proyectos activos.")
	public List<ActaResponse> buscarActasProyecto(long proyectoId) {
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarActasProyecto.INIT");			
		}
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery( "getlistaractabyproyecto" );
		storedProcedureQuery.registerStoredProcedureParameter("_proyectoid",Long.class, ParameterMode.IN);
		storedProcedureQuery.setParameter("_proyectoid", proyectoId);
		storedProcedureQuery.execute();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarActasProyecto.SpEjecutado");			
		}
		@SuppressWarnings("unchecked")		
		List<Object[]> results = storedProcedureQuery.getResultList();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarActasProyecto.listarActas: " + results.size());			
		}
		List<ActaResponse> retorno = null;
		if (results != null) {
			retorno= new ArrayList<ActaResponse>();
			ActaResponse acta = null;
			int j = 0;
			if(log.isInfoEnabled()) {
				log.info("CallStoreProcedureImpl.buscarActasProyecto.usuaiosActa");			
			}
			List<UsuarioActaResponse> listaUsuarioActaResponse = buscarUsuarioActaProyectoAll(proyectoId);
			if(log.isInfoEnabled()) {
				log.info("CallStoreProcedureImpl.buscarActasProyecto.usuaiosActa lista: " + listaUsuarioActaResponse.toString());			
			}			
			for (Object[] row : results) {
				acta = new ActaResponse();
				j = j + 1;
				long  _acta = Long.parseLong(row[0].toString());
				acta.setActaId(_acta);
				acta.setCorrelativo(j);
				acta.setFecha(Utilitario.formatoFecha(row[1].toString()));
				acta.setResumen(row[2].toString());
				acta.setProyectoId(proyectoId);				
				List<UsuarioActaResponse> validacion = listaUsuarioActaResponse.stream().filter(a -> Objects.equals(a.getActaId(), _acta )).collect(Collectors.toList());
				acta.setUsuarioActa(validacion);
				retorno.add(acta);
			}
		}
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarActasProyecto.retorno: " + retorno.toString());
			log.info("CallStoreProcedureImpl.buscarActasProyecto.FIN");
		}
		return retorno;
	}
	
	@ApiOperation("Método encargado de listar los usuario de actas por proyecto.")
	public List<UsuarioActaResponse> buscarUsuarioActaProyectoAll(long proyectoId) {
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarUsuarioActaAll.INIT");			
		}
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery( "getlistaractausuariosbyproyecto" );
		storedProcedureQuery.registerStoredProcedureParameter("_proyectoid",Long.class, ParameterMode.IN);
		storedProcedureQuery.setParameter("_proyectoid", proyectoId);
		storedProcedureQuery.execute();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarUsuarioActaAll.SpEjecutado");			
		}
		@SuppressWarnings("unchecked")		
		List<Object[]> results = storedProcedureQuery.getResultList();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarUsuarioActaAll.listaUsuarios: " + results.size());			
		}
		List<UsuarioActaResponse> retorno = null;
		if (results != null) {
			retorno= new ArrayList<UsuarioActaResponse>();
			ActaResponse acta = new ActaResponse();
			UsuarioActaResponse usuarioActa = acta.new UsuarioActaResponse();
			for (Object[] row : results) {				
				usuarioActa.setAsiste(row[0].toString());
				usuarioActa.setSecretario(row[1].toString());
				usuarioActa.setUsername(row[2].toString());
				usuarioActa.setActaId(Long.parseLong(row[3].toString()));
				retorno.add(usuarioActa);
			}
		}
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarUsuarioActaAll.retorno: " + retorno.toString());
			log.info("CallStoreProcedureImpl.buscarUsuarioActaAll.FIN");
		}
		return retorno;
	}

}
