package cl.usach.dminute.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;

/** 
 * 
 * Exception Manager 
 * 
 */
@ControllerAdvice
@Slf4j
public class ExceptionManager {

	/**
	 * Metodo encargado de manejar el retorno de excepciones centralizadas
	 * 
	 * @param String
	 * @return ResponseEntity<Object>
	 */
	private ResponseEntity<Object> mensajeErrorTecnico(String mensaje,String debug) {
		ErrorDto errorDto = ErrorDto.builder()
				.codigo("500")
				.mensaje(mensaje)
				.debug(debug)
			.build();
		return new ResponseEntity<>(errorDto, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Metodo encargado de tratar excepcion de tipo ValidacionesException 
	 * (Validaciones de negocio incluidas en Service)
	 * 
	 * @param ValidacionesException
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(ValidacionesException.class)
	private ResponseEntity<Object> manageValidacionesEntradaException(ValidacionesException e){
		ErrorDto errorDto = ErrorDto.builder()
				.codigo(e.getCodigo())
				.mensaje(e.getMensaje())				
			.build();
		return new ResponseEntity<>(errorDto, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Metodo encargado de tratar excepcion de StoredProcedureException
	 * 
	 * @param ValidacionesException
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(StoredProcedureException.class)
	private ResponseEntity<ErrorDto> manageRegistroNotFoundException(StoredProcedureException e){
		ErrorDto errorDto = ErrorDto.builder()
				.codigo(e.getCodigo())
				.mensaje(e.getMensaje())
			.build();
		
		BodyBuilder bodyBuilder = ResponseEntity.status(460);
		return bodyBuilder.body(errorDto);
	}
	
	
	@ExceptionHandler(EnvioCorreoException.class)
	private ResponseEntity<Object> manageEnvioCorreoException(EnvioCorreoException e) {
		ErrorDto errorDto = ErrorDto.builder()
				.codigo(e.getCodigo())
				.mensaje(e.getMensaje())
			.build();
		
		BodyBuilder bodyBuilder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		return bodyBuilder.body(errorDto);		
	}

	/**
	 * Metodo encargado de tratar excepcion de tipo ValidacionesException 
	 * (Validaciones de negocio incluidas en Service)
	 * 
	 * @param ErrorTecnicoException
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(ErrorTecnicoException.class)
	private ResponseEntity<Object> manageAuthenticationSystemFaultException(ErrorTecnicoException e){
		log.error("ErrorTecnicoException: " , e);
		return mensajeErrorTecnico(Constants.ERROR_TECNICO_MENSAJE,"Error tecnico: " + e.getCodigo() + " Mensaje:" + e.getMessage());
	}
	
}
