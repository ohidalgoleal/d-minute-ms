package cl.usach.dminute.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.repository.UsuarioJpa;
import cl.usach.dminute.service.UsuarioService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "usuarioService")
public class UsuarioImpl implements UserDetailsService, UsuarioService {
	
	@Autowired
	@Qualifier("usuarioJpa")
	private UsuarioJpa usuarioJpa;

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Usuario user = usuarioJpa.findByUsername(userId);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<Usuario> findAll() {
		List<Usuario> list = new ArrayList<>();
		usuarioJpa.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		usuarioJpa.delete(id);
	}

	@Override
	public Usuario findOne(String username) {
		return usuarioJpa.findByUsername(username);
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioJpa.findOne(id);
	}

	@Override
    public Usuario save(Usuario user) {
        return usuarioJpa.save(user);
    }
}
