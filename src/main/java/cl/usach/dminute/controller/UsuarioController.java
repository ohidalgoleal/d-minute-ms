package cl.usach.dminute.controller;

import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioService")
    private UsuarioService usuarioService;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<Usuario> listUser(){
    	if(log.isInfoEnabled()) {
			log.info("UsuarioController.listUser.INIT");
		}
        return usuarioService.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Usuario getOne(@PathVariable(value = "id") Long id){
    	if(log.isInfoEnabled()) {
			log.info("UsuarioController.getOne.INIT: " + id.toString());
		}
        return usuarioService.findById(id);
    }

}
