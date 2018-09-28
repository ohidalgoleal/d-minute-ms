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

import cl.usach.dminute.dto.SalidaDto;
import cl.usach.dminute.dto.TemaDto;
import cl.usach.dminute.service.TemaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/tema")
public class TemaController {

	@Autowired
	@Qualifier("temaService")
	private TemaService temaService;
	
	@PostMapping(value = "/guardarTema", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrar(@RequestBody TemaDto nuevaTema) {
		
		if(log.isInfoEnabled()) {
			log.info("TemaController.registrar.INIT");
			log.info("TemaController.registrar.tema:" + nuevaTema.toString());
		}
		temaService.guardarModificar(nuevaTema);
		if(log.isInfoEnabled()) {
			log.info("TemaController.registrar.FIN");
		}		
		return ResponseEntity.ok(new SalidaDto());
	}
	
	@PostMapping(value = "/eliminarTema", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@RequestBody TemaDto deleteTema) {
		
		if(log.isInfoEnabled()) {
			log.info("TemaController.eliminar.INIT");
			log.info("TemaController.eliminar.tema:" + deleteTema.toString());
		}
		temaService.eliminar(deleteTema);
		if(log.isInfoEnabled()) {
			log.info("TemaController.eliminar.FIN");
		}		
		return ResponseEntity.ok(new SalidaDto());
	}
	
	@GetMapping(value = "/listarTema/{actaid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TemaDto> listarTemaActa(@PathVariable(value = "actaid") Long actaid) {
		
		if(log.isInfoEnabled()) {
			log.info("TemaController.listarTemaActa.INIT");
			log.info("TemaController.listarTemaActa.actaid:" + actaid);
		}		
		List<TemaDto> retorno = temaService.listarTemaActa(actaid);		
		
		if(log.isInfoEnabled()) {
			log.info("TemaController.listarTemaActa.ListaActa: " + retorno.toString());
			log.info("TemaController.listarTemaActa.FIN");
		}		
		return retorno;
	}
	
	@GetMapping(value = "/getTema/{temaid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TemaDto getTema(@PathVariable(value = "temaid") Long temaid) {
		
		if(log.isInfoEnabled()) {
			log.info("TemaController.getTema.INIT");
			log.info("TemaController.getTema.temaid:" + temaid);
		}		
		
		TemaDto retorno = temaService.findByIdTema(temaid);		
		
		if(log.isInfoEnabled()) {
			log.info("TemaController.getTema.TemaDto: " + retorno.toString());
			log.info("TemaController.getTema.FIN");
		}		
		return retorno;
	}	
}
