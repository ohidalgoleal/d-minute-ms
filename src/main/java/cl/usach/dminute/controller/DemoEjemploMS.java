package cl.usach.dminute.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.dminute.dto.Salida;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/demoEjemploMS")
public class DemoEjemploMS {
	
	@GetMapping(value="/ejemplo", produces = MediaType.APPLICATION_JSON_VALUE)	
	public Salida ejemplo() {
		if(log.isInfoEnabled()) {
			log.info("demo.ejemplo.INIT");
		}
		Salida retorno = new Salida();
		retorno.setAdministrador("Oliver Hidalgo");
		retorno.setFono("984643056");
		retorno.setDv("6");
		retorno.setRut(15928819);
		if(log.isInfoEnabled()) {
			log.info("demo.ejemplo.END: " + retorno.toString());
		}
		return retorno;
	}
}
