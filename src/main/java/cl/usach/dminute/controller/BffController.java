package cl.usach.dminute.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.dminute.dto.ListarActaDialogica;
import cl.usach.dminute.dto.ProyectoDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/bff")
public class BffController {

	@Autowired
	@Qualifier("actaController")
	private ActaController actaController;
	
	@Autowired
	@Qualifier("proyectoController")
	private ProyectoController proyectoController;
	
	@GetMapping(value = "/listarMinutaProyecto/{proyectoid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ListarActaDialogica listarMinutaProyectoById(@PathVariable(value = "proyectoid") Long proyectoid, HttpServletRequest request) {
		
		if(log.isInfoEnabled()) {
			log.info("BffController.listarMinutaProyectoById.INIT");
			log.info("BffController.listarMinutaProyectoById.ProyectoId:" + proyectoid.toString());
		}
		
		ListarActaDialogica retorno = new ListarActaDialogica();
		
		ProyectoDto proyectoDto = proyectoController.proyectoById(proyectoid, request);
		
		if (proyectoDto != null){
			retorno.setProyectoDto(proyectoDto);
			
			retorno.setListaActa(actaController.listarActaProyecto(proyectoid));
			
			if (retorno.getListaActa().size()>0) {
				retorno.setActaDto(retorno.getListaActa().get(0));
			}
		}
			
		if(log.isInfoEnabled()) {
			log.info("BffController.listarMinutaProyectoById.retorno:" + retorno.toString());
			log.info("BffController.listarMinutaProyectoById.FIN");
		}
			
		return retorno;
	}
	
}
