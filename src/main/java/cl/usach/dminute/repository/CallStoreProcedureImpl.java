package cl.usach.dminute.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import cl.usach.dminute.entity.UsuarioProyecto;

@Repository("callStoreProcedureImpl")
public class CallStoreProcedureImpl {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<UsuarioProyecto> buscarProyectoPorUsuario(String usuario) {
		StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery( "getproyectoporusuario" );
		storedProcedureQuery.registerStoredProcedureParameter("_usuario",String.class, ParameterMode.IN);
		storedProcedureQuery.setParameter("_usuario", usuario);
		storedProcedureQuery.execute();
		@SuppressWarnings("unchecked")
		
		List<Object[]> results = storedProcedureQuery.getResultList();
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
		return retorno;
	}

}
