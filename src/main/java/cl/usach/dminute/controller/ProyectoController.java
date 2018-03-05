package cl.usach.dminute.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.dminute.configuration.JwtTokenUtil;
import cl.usach.dminute.dto.NuevoProyecto;
import cl.usach.dminute.dto.Salida;
import cl.usach.dminute.entity.Proyecto;
import cl.usach.dminute.service.ProyectoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/proyecto")
public class ProyectoController {
	
	@Autowired
	@Qualifier("proyectoService")
	private ProyectoService proyectoService;
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;

	@PostMapping(value = "/nuevoProyecto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrar(@RequestBody NuevoProyecto nuevoProyecto) {
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.nuevoProyecto.INIT");
			log.info("ProyectoController.nuevoProyecto.getUsername:" + nuevoProyecto.toString());
		}
		proyectoService.crearNuevoProyecto(nuevoProyecto);
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.nuevoProyecto.FIN");
		}		
		return ResponseEntity.ok(new Salida());
	}
	
	@PostMapping(value = "/editarProyecto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editar(@RequestBody NuevoProyecto nuevoProyecto) {
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.editarProyecto.INIT");
			log.info("ProyectoController.editarProyecto.getUsername:" + nuevoProyecto.toString());
		}
		proyectoService.editarProyecto(nuevoProyecto);
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.editarProyecto.FIN");
		}		
		return ResponseEntity.ok(new Salida());
	}
	
	@GetMapping(value = "/listarProyectoUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Proyecto> listarProyectoUsuario(HttpServletRequest request) {
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.listarProyectoUsuario.INIT");
		}
		
		String userName = jwtTokenUtil.getUserToken(request);
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.listarProyectoUsuario.getUsername: " + userName);
		}
		
		List<Proyecto> retorno = proyectoService.buscarProyectosByUsuario(userName);
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.listarProyectoUsuario.ListaProyectos: " + retorno.toString());
			log.info("ProyectoController.listarProyectoUsuario.FIN");
		}		
		return retorno;
	}	

}
