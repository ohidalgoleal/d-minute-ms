package cl.usach.dminute.controller;

import cl.usach.dminute.entity.Usuario;
import cl.usach.dminute.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioService")
    private UsuarioService usuarioService;

    @GetMapping(value="/listaUsuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> listUser(){
    	if(log.isInfoEnabled()) {
			log.info("UsuarioController.listUser.INIT");
		}
        return usuarioService.findAll();
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario getOne(@RequestParam(value = "username", required = true) String username){
    	if(log.isInfoEnabled()) {
			log.info("UsuarioController.getOne.INIT: " + username.toString());
		}
    	Usuario retorno = usuarioService.findOne(username);
    	retorno.setPassword("");
    	return retorno;
    }
    
    @GetMapping(value="/logout", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout (HttpServletRequest request, HttpServletResponse response) {
    	if(log.isInfoEnabled()) {
			log.info("UsuarioController.logout.INIT");
		}
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        SecurityContextLogoutHandler ctxLogOut = new SecurityContextLogoutHandler();
        if( auth != null ){
        	if(log.isInfoEnabled()) {
    			log.info("UsuarioController.logout.NOTNULL: " + auth.getName());
    		}
        	ctxLogOut.logout(request, response, auth);
        	SecurityContextHolder.getContext().setAuthentication(null);
        	SecurityContextHolder.clearContext();
        }
        if(log.isInfoEnabled()) {
			log.info("UsuarioController.logout.FIN");
		}
    }
}
