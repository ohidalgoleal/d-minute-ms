package cl.usach.dminute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.dminute.dto.NuevoProyecto;
import cl.usach.dminute.dto.Salida;
import cl.usach.dminute.service.ProyectoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/proyecto")
public class ProyectoController {
	
	@Autowired
	@Qualifier("proyectoService")
	private ProyectoService proyectoService;

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
	
	@GetMapping(value = "/listarProyectoUsuario/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listarProyectoUsuario(@PathVariable(value = "userName") String userName) {
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.listarProyectoUsuario.INIT");
			log.info("ProyectoController.listarProyectoUsuario.getUsername:" + userName);
		}
		proyectoService.buscarProyectosByUsuario(userName);
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.listarProyectoUsuario.FIN");
		}		
		return ResponseEntity.ok(new Salida());
	}	

}
