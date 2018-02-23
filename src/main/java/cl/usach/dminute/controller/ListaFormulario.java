package cl.usach.dminute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.dminute.entity.RolProyecto;
import cl.usach.dminute.entity.TipoElementoDialogo;
import cl.usach.dminute.service.RolProyectoService;
import cl.usach.dminute.service.TipoElementoDialogoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/listaFormulario")
public class ListaFormulario {

	@Autowired
	@Qualifier("rolProyectoService")
	private RolProyectoService rolProyectoService;
	
	@Autowired
	@Qualifier("tipoElementoDialogoService")
	private TipoElementoDialogoService tipoElementoDialogoService;
	
	@ApiOperation("Operacion que permite listar los roles que se asumen en un proyecto.")
	@GetMapping(value="/rolesProyecto", produces = MediaType.APPLICATION_JSON_VALUE)	
	public List<RolProyecto> rolesProyecto() {
		if(log.isInfoEnabled()) {
			log.info("ListaFormulario.rolesProyecto.INIT");
		}
		List<RolProyecto> listaRetorno = null;
		try {			
			listaRetorno = rolProyectoService.listAllRolProyecto();
			if(log.isInfoEnabled()) {
				log.info("ListaFormulario.rolesProyecto - " + listaRetorno.toString());
			}			
		}catch (Exception e) {
			// TODO: handle exception
			if(log.isErrorEnabled()) {
				log.info("ListaFormulario.rolesProyecto.ERROR - " +e.getMessage());			
			}			
		}
		if(log.isInfoEnabled()) {
			log.info("ListaFormulario.rolesProyecto.FIN");
		}
		
		return listaRetorno; 
	}
	
	@ApiOperation("Operacion que permite listar los tipos de elemento de dialogo de un acta.")
	@GetMapping(value="/tiposElementoDialogo", produces = MediaType.APPLICATION_JSON_VALUE)	
	public List<TipoElementoDialogo> tiposElementoDialogo() {
		if(log.isInfoEnabled()) {
			log.info("ListaFormulario.tiposElementoDialogo.INIT");
		}
		List<TipoElementoDialogo> listaRetorno = null;
		try {			
			listaRetorno = tipoElementoDialogoService.listAllTipoElementoDialogo();
			if(log.isInfoEnabled()) {
				log.info("ListaFormulario.tiposElementoDialogo - " + listaRetorno.toString());
			}			
		}catch (Exception e) {
			// TODO: handle exception
			if(log.isErrorEnabled()) {
				log.info("ListaFormulario.tiposElementoDialogo.ERROR - " +e.getMessage());			
			}			
		}
		if(log.isInfoEnabled()) {
			log.info("ListaFormulario.tiposElementoDialogo.FIN");
		}
		return listaRetorno; 
	}
}
