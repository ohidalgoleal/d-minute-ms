package cl.usach.dminute.service;

import cl.usach.dminute.entity.Usuario;

import java.util.List;

public interface UsuarioService {

	Usuario save(Usuario user);
    
    List<Usuario> findAll();
    
    void delete(long id);
   
    Usuario findOne(String username);

    Usuario findById(Long id);
}
