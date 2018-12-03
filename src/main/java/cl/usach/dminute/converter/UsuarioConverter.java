package cl.usach.dminute.converter;

import org.springframework.stereotype.Component;

import cl.usach.dminute.dto.UsuarioDto;
import cl.usach.dminute.entity.Usuario;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	public UsuarioDto entity2model(Usuario usuario) {
		UsuarioDto retorno = new UsuarioDto();
		retorno.setApellido(usuario.getApellido());
		retorno.setNombre(usuario.getNombre());
		retorno.setUsername(usuario.getUsername());
		return retorno;
	}

	public Usuario model2entity(UsuarioDto usuario) {
		Usuario retorno = new Usuario();
		retorno.setApellido(usuario.getApellido());
		retorno.setNombre(usuario.getNombre());
		retorno.setUsername(usuario.getUsername());
		return retorno;
	}
}
