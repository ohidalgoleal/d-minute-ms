package cl.usach.dminute.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cl.usach.dminute.dto.Constants;
import cl.usach.dminute.dto.ErrorDto;

/** 
 * 
 * Exception Manager 
 * 
 */
@ControllerAdvice
public class ExceptionManager {

	/**
	 * Metodo encargado de tratar excepcion de tipo ValidacionesException 
	 * (Validaciones de negocio incluidas en Service)
	 * 
	 * @param ValidacionesException
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(ValidacionesException.class)
	private ResponseEntity<Object> manageValidacionesEntradaException(ValidacionesException e){
		ResponseEntity response = null;
        String mensaje = null;
        String codigo = null;
        HttpStatus status = null;

        mensaje = e.getMensaje();
        codigo = e.getCodigo();
        status = HttpStatus.PRECONDITION_REQUIRED;
        ErrorDto errorDto = ErrorDto.builder()
                .codigo(codigo)
                .mensaje(mensaje)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        response = new ResponseEntity<>(errorDto, headers, status);
        return response;
	}
	
	/**
	 * Metodo encargado de tratar excepcion de StoredProcedureException
	 * 
	 * @param ValidacionesException
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(StoredProcedureException.class)
	private ResponseEntity<Object> manageRegistroNotFoundException(StoredProcedureException e){
        ResponseEntity response = null;
        String mensaje = null;
        String codigo = null;
        HttpStatus status = null;

        mensaje = e.getMensaje();
        codigo = e.getCodigo();
        status = HttpStatus.NOT_IMPLEMENTED;
        ErrorDto errorDto = ErrorDto.builder()
                .codigo(codigo)
                .mensaje(mensaje)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        response = new ResponseEntity<>(errorDto, headers, status);
        return response;
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
		 ResponseEntity response = null;
	        String mensaje = null;
	        String codigo = null;
	        HttpStatus status = null;

	        mensaje = Constants.ERROR_INTERNAL_MENSAJE;
	        codigo = Constants.ERROR_INTERNAL;
	        status = HttpStatus.BAD_REQUEST;
	        ErrorDto errorDto = ErrorDto.builder()
	                .codigo(codigo)
	                .mensaje(mensaje)
	                .build();

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	        response = new ResponseEntity<>(errorDto, headers, status);
	        return response;
	}
	
	/**
	 * Metodo encargado de tratar excepcion de Usuario 
	 * 
	 * @param UsPersonException
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(UsPersonException.class)
	private ResponseEntity<Object> manageAuthenticationSystemFaultException(UsPersonException e){
		 ResponseEntity response = null;
	        String mensaje = null;
	        String codigo = null;
	        HttpStatus status = null;

	        mensaje = e.getMensaje();
	        codigo = e.getCodigo();
	        status = HttpStatus.PRECONDITION_REQUIRED;
	        ErrorDto errorDto = ErrorDto.builder()
	                .codigo(codigo)
	                .mensaje(mensaje)
	                .build();

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	        response = new ResponseEntity<>(errorDto, headers, status);
	        return response;
	}
	
	@ExceptionHandler({Exception.class})
    private ResponseEntity<Object> manageExceptions(Exception e) {
        ResponseEntity response = null;
        String mensaje = null;
        String codigo = null;
        HttpStatus status = null;

        mensaje = Constants.ERROR_INTERNAL_MENSAJE;
        codigo = Constants.ERROR_INTERNAL;
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDto errorDto = ErrorDto.builder()
                .codigo(codigo)
                .mensaje(mensaje)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        response = new ResponseEntity<>(errorDto, headers, status);
        return response;
    }

	
}
