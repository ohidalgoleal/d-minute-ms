package cl.usach.dminute.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import cl.usach.dminute.dto.ActaDto;
import cl.usach.dminute.dto.ElementoDialogoDto;
import cl.usach.dminute.dto.ProyectoUsuariosDto;
import cl.usach.dminute.dto.TemaDto;
import cl.usach.dminute.dto.UsuarioActaDto;
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
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery( "deleteallusuariosproyecto" );
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
	public List<ActaDto> buscarActasProyecto(long proyectoId) {
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
		List<ActaDto> retorno = null;
		if (results != null) {
			retorno= new ArrayList<ActaDto>();
			ActaDto acta = null;
			int j = 0;
			if(log.isInfoEnabled()) {
				log.info("CallStoreProcedureImpl.buscarActasProyecto.usuaiosActa");			
			}
			for (Object[] row : results) {
				acta = new ActaDto();
				j = j + 1;
				long  _acta = Long.parseLong(row[0].toString());
				acta.setActaId(_acta);
				acta.setCorrelativo(j);
				acta.setFecha(Utilitario.formatoFecha(row[1].toString()));
				acta.setResumen(row[2].toString());
				acta.setEstado(row[3].toString());
				acta.setProyectoId(proyectoId);				
				acta.setUsuarioActa(new ArrayList<UsuarioActaDto>());
				acta.setTemaActa(new ArrayList<TemaDto>());
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
	public List<UsuarioActaDto> buscarUsuarioActaProyectoAll(long proyectoId) {
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarUsuarioActaProyectoAll.INIT");			
		}
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery( "getlistaractausuariosbyproyecto" );
		storedProcedureQuery.registerStoredProcedureParameter("_proyectoid",Long.class, ParameterMode.IN);
		storedProcedureQuery.setParameter("_proyectoid", proyectoId);
		storedProcedureQuery.execute();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarUsuarioActaProyectoAll.SpEjecutado");			
		}
		@SuppressWarnings("unchecked")		
		List<Object[]> results = storedProcedureQuery.getResultList();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarUsuarioActaProyectoAll.listaUsuarios: " + results.size());			
		}
		List<UsuarioActaDto> retorno = null;
		if (results != null) {
			retorno= new ArrayList<UsuarioActaDto>();
			for (Object[] row : results) {
				UsuarioActaDto usuarioActa = new UsuarioActaDto();
				usuarioActa.setAsiste(row[0].toString());
				usuarioActa.setSecretario(row[1].toString());
				usuarioActa.setUsername(row[2].toString());
				usuarioActa.setActaId(Long.parseLong(row[3].toString()));
				usuarioActa.setNombre(row[4].toString() + " " +  row[5].toString());
				retorno.add(usuarioActa);
			}
		}
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarUsuarioActaProyectoAll.retorno: " + retorno.toString());
			log.info("CallStoreProcedureImpl.buscarUsuarioActaProyectoAll.FIN");
		}
		return retorno;
	}
	
	@ApiOperation("Método encargado de eliminar los usuarios de un acta.")
	public void eliminarUsuariosActa(long actaId) {
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.eliminarUsuariosActa.INIT");			
		}
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery( "deleteallusuariosacta" );
		storedProcedureQuery.registerStoredProcedureParameter("_actaid",Long.class, ParameterMode.IN);
		storedProcedureQuery.setParameter("_actaid", actaId);
		storedProcedureQuery.execute();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.eliminarUsuariosActa.SpEjecutado");
			log.info("CallStoreProcedureImpl.eliminarUsuariosActa.FIN");
		}
	}
	
	@ApiOperation("Método encargado de listar todos los elementos de dialogo de un acta.")
	public List<ElementoDialogoDto> buscarElementosDialogoTemasDeActaProyectoAll(long actaId) {
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarElementosDialogoTemasDeActaProyectoAll.INIT");			
		}
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery( "getelementosdialogoacta" );
		storedProcedureQuery.registerStoredProcedureParameter("_actaid",Long.class, ParameterMode.IN);
		storedProcedureQuery.setParameter("_actaid", actaId);
		storedProcedureQuery.execute();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarElementosDialogoTemasDeActaProyectoAll.SpEjecutado");			
		}
		@SuppressWarnings("unchecked")		
		List<Object[]> results = storedProcedureQuery.getResultList();
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarElementosDialogoTemasDeActaProyectoAll.listaElementosDialogo: " + results.size());			
		}
		List<ElementoDialogoDto> retorno = null;
		if (results != null) {
			retorno= new ArrayList<ElementoDialogoDto>();
			for (Object[] row : results) {
				ElementoDialogoDto elementoDialogoDto = new ElementoDialogoDto();
				elementoDialogoDto.setCodRol(row[0].toString());
				elementoDialogoDto.setDescripcion(row[1].toString().substring(0, 50) + "...");
				elementoDialogoDto.setEstado(row[2].toString());
				elementoDialogoDto.setFechaCompromiso(Utilitario.formatoFecha(row[3].toString()));
				elementoDialogoDto.setIdElemento(Long.parseLong(row[4].toString()));
				elementoDialogoDto.setTemaId(Long.parseLong(row[5].toString()));
				elementoDialogoDto.setUsername(row[6].toString());
				retorno.add(elementoDialogoDto);
			}
		}
		if(log.isInfoEnabled()) {
			log.info("CallStoreProcedureImpl.buscarElementosDialogoTemasDeActaProyectoAll.retorno: " + retorno.toString());
			log.info("CallStoreProcedureImpl.buscarElementosDialogoTemasDeActaProyectoAll.FIN");
		}
		return retorno;
	}

}
