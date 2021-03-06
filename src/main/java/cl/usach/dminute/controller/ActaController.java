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
import cl.usach.dminute.dto.ActaDto;
import cl.usach.dminute.dto.SalidaDto;
import cl.usach.dminute.dto.UsuarioActaDto;
import cl.usach.dminute.service.ActaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/acta")
public class ActaController {

	@Autowired
	@Qualifier("actaService")
	private ActaService actaService;
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping(value = "/guardarActa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrar(@RequestBody ActaDto nuevaActa, HttpServletRequest request) {
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.registrar.INIT");
			log.info("ActaController.registrar.acta:" + nuevaActa.toString());
		}
		
		String userName = jwtTokenUtil.getUserToken(request);
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.registrar.usuario:" + userName.toString());
		}
		
		actaService.guardarModificar(nuevaActa, userName);
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.registrar.FIN");
		}		
		return ResponseEntity.ok(new SalidaDto());
	}
	
	@PostMapping(value = "/eliminarActa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@RequestBody ActaDto deleteActa, HttpServletRequest request) {
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.eliminar.INIT");
			log.info("ActaController.eliminar.acta:" + deleteActa.toString());
		}
		
		String userName = jwtTokenUtil.getUserToken(request);
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.eliminar.usuario:" + userName.toString());
		}
		
		actaService.eliminar(deleteActa, userName);
		if(log.isInfoEnabled()) {
			log.info("ActaController.eliminar.FIN");
		}		
		return ResponseEntity.ok(new SalidaDto());
	}
	
	@GetMapping(value = "/listarActaProyecto/{proyectoid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActaDto> listarActaProyecto(@PathVariable(value = "proyectoid") Long proyectoid) {
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.listarActaProyecto.INIT");
			log.info("ActaController.listarActaProyecto.proyectoid:" + proyectoid);
		}		
		List<ActaDto> retorno = actaService.listarActaProyecto(proyectoid);		
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.listarActaProyecto.ListaActa: " + retorno.toString());
			log.info("ActaController.listarActaProyecto.FIN");
		}		
		return retorno;
	}
	
	@GetMapping(value = "/getActa/{actaid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActaDto getActa(@PathVariable(value = "actaid") Long actaid) {
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.getActa.INIT");
			log.info("ActaController.getActa.actaid:" + actaid);
		}		
		ActaDto retorno = actaService.getActa(actaid);		
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.listarActaProyecto.Acta: " + retorno.toString());
			log.info("ActaController.listarActaProyecto.FIN");
		}		
		return retorno;
	}
	
	@GetMapping(value = "/getActaId/{actaid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ActaDto getActaId(@PathVariable(value = "actaid") Long actaid) {
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.getActa.INIT");
			log.info("ActaController.getActa.actaid:" + actaid);
		}		
		ActaDto retorno = actaService.getActaId(actaid);		
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.listarActaProyecto.Acta: " + retorno.toString());
			log.info("ActaController.listarActaProyecto.FIN");
		}		
		return retorno;
	}
	
	@GetMapping(value = "/getUsuariosActa/{actaid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UsuarioActaDto> getUsuarioActa(@PathVariable(value = "actaid") Long actaid) {
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.getUsuarioActa.INIT");
			log.info("ActaController.getUsuarioActa.actaid:" + actaid);
		}		
		List<UsuarioActaDto> retorno = actaService.getActa(actaid).getUsuarioActa();		
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.listarActaProyecto.Usuarios: " + retorno.toString());
			log.info("ActaController.listarActaProyecto.FIN");
		}		
		return retorno;
	}
	
}
