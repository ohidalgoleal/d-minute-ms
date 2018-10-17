package cl.usach.dminute.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import cl.usach.dminute.configuration.JwtTokenUtil;
import cl.usach.dminute.dto.ProyectoDto;
import cl.usach.dminute.dto.SalidaDto;
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
    public ResponseEntity<?> registrar(@RequestBody ProyectoDto nuevoProyecto) {
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.nuevoProyecto.INIT");
			log.info("ProyectoController.nuevoProyecto.proyecto:" + nuevoProyecto.toString());
		}
		proyectoService.crearNuevoProyecto(nuevoProyecto);
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.nuevoProyecto.FIN");
		}		
		return ResponseEntity.ok(new SalidaDto());
	}
	
	@PostMapping(value = "/editarProyecto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editar(@RequestBody ProyectoDto nuevoProyecto, HttpServletRequest request) {
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.editarProyecto.INIT");
			log.info("ProyectoController.editarProyecto.proyecto:" + nuevoProyecto.toString());
		}
		String userName = jwtTokenUtil.getUserToken(request);
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.editarProyecto.usuario:" + userName.toString());
		}
		
		proyectoService.editarProyecto(nuevoProyecto, userName);
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.editarProyecto.FIN");
		}		
		return ResponseEntity.ok(new SalidaDto());
	}
	
	@GetMapping(value = "/eliminarProyecto/{proyectoid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable(value = "proyectoid") Long proyectoid, HttpServletRequest request) {
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.eliminar.INIT");
			log.info("ProyectoController.eliminar.proyectoid:" + proyectoid);
		}
		String userName = jwtTokenUtil.getUserToken(request);
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.eliminar.usuario:" + userName.toString());
		}
		
		proyectoService.eliminar(proyectoid, userName);
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.eliminar.FIN");
		}		
		return ResponseEntity.ok(new SalidaDto());
	}
	
	@GetMapping(value = "/listarProyectoUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProyectoDto> listarProyectoUsuario(HttpServletRequest request) {
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.listarProyectoUsuario.INIT");
		}
		
		String userName = jwtTokenUtil.getUserToken(request);
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.listarProyectoUsuario.getUsername: " + userName);
		}
		
		List<ProyectoDto> retorno = proyectoService.buscarProyectosByUsuario(userName);
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.listarProyectoUsuario.ListaProyectos: " + retorno.toString());
			log.info("ProyectoController.listarProyectoUsuario.FIN");
		}		
		return retorno;
	}	
	
	@GetMapping(value = "/proyectoid/{proyectoid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProyectoDto proyectoById(@PathVariable(value = "proyectoid") Long proyectoid, HttpServletRequest request) {
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.proyectoById.INIT");
			log.info("ProyectoController.proyectoById.proyectoid:" + proyectoid);
		}
		
		String userName = jwtTokenUtil.getUserToken(request);
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.proyectoById.getUsername: " + userName);
		}
		
		ProyectoDto proyectoDto = proyectoService.buscarProyectoById(proyectoid,userName);
		
		if(log.isInfoEnabled()) {
			log.info("ProyectoController.proyectoById.FIN");
		}		
		return proyectoDto;
	}


}
