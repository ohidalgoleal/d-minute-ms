package cl.usach.dminute.controller;

import java.util.List;

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

import cl.usach.dminute.dto.ActaDto;
import cl.usach.dminute.dto.SalidaDto;
import cl.usach.dminute.entity.Acta;
import cl.usach.dminute.service.ActaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/acta")
public class ActaController {

	@Autowired
	@Qualifier("actaService")
	private ActaService actaService;
	
	@PostMapping(value = "/guardarActa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrar(@RequestBody Acta nuevaActa) {
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.registrar.INIT");
			log.info("ActaController.registrar.acta:" + nuevaActa.toString());
		}
		actaService.guardarModificar(nuevaActa);
		if(log.isInfoEnabled()) {
			log.info("ActaController.registrar.FIN");
		}		
		return ResponseEntity.ok(new SalidaDto());
	}
	
	@PostMapping(value = "/eliminarActa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@RequestBody Acta deleteActa) {
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.eliminar.INIT");
			log.info("ActaController.eliminar.acta:" + deleteActa.toString());
		}
		actaService.eliminar(deleteActa);
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
		
		List<ActaDto> retorno = actaService.listarActa(proyectoid);		
		
		if(log.isInfoEnabled()) {
			log.info("ActaController.listarActaProyecto.ListaActa: " + retorno.toString());
			log.info("ActaController.listarActaProyecto.FIN");
		}		
		return retorno;
	}	
	
}
