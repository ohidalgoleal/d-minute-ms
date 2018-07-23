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

import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.dto.ElementoDialogoDto;
import cl.usach.dminute.dto.SalidaDto;
import cl.usach.dminute.exception.ValidacionesException;
import cl.usach.dminute.service.ElementoDialogoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/elementoDialogo")
public class ElementoDialogoController {

	@Autowired
	@Qualifier("elementoDialogoService")
	private ElementoDialogoService elementoDialogoService;
	
	@PostMapping(value = "/guardarElementoDialogoTema", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registrar(@RequestBody ElementoDialogoDto nuevaElemento) {
		
		if(log.isInfoEnabled()) {
			log.info("ElementoDialogoController.registrar.INIT");
			log.info("ElementoDialogoController.registrar.elementoDialogo:" + nuevaElemento.toString());
		}
		elementoDialogoService.guardarModificar(nuevaElemento);
		if(log.isInfoEnabled()) {
			log.info("ElementoDialogoController.registrar.FIN");
		}		
		return ResponseEntity.ok(new SalidaDto());
	}
	
	@PostMapping(value = "/eliminarElementoDialogoTema", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@RequestBody ElementoDialogoDto deleteElemento) {
		
		if(log.isInfoEnabled()) {
			log.info("ElementoDialogoController.eliminar.INIT");
			log.info("ElementoDialogoController.eliminar.elementoDialogo:" + deleteElemento.toString());
		}
		elementoDialogoService.eliminar(deleteElemento);
		if(log.isInfoEnabled()) {
			log.info("ElementoDialogoController.eliminar.FIN");
		}		
		return ResponseEntity.ok(new SalidaDto());
	}
	
	@GetMapping(value = "/getElementoDialogoTema/{elementoid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ElementoDialogoDto getActa(@PathVariable(value = "elementoid") Long elementoid) {
		
		if(log.isInfoEnabled()) {
			log.info("ElementoDialogoController.getElemento.INIT");
			log.info("ElementoDialogoController.getElemento.elementoid:" + elementoid);
		}		
		ElementoDialogoDto retorno = elementoDialogoService.getElemento(elementoid);	
		if (retorno == null)
			throw new ValidacionesException(Constants.ERROR_TECNICO_GENERICO_COD, Constants.ERROR_ELEMENTO_NOEXISTE, null);
		
		if(log.isInfoEnabled()) {
			log.info("ElementoDialogoController.listarActaProyecto.Acta: " + retorno.toString());
			log.info("ElementoDialogoController.listarActaProyecto.FIN");
		}		
		return retorno;
	}
	
}
