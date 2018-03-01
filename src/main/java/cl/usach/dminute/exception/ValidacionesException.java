package cl.usach.dminute.exception;

import java.util.List;

import cl.usach.dminute.dto.ErrorValidacion;

public class ValidacionesException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final List<ErrorValidacion> erroresValidacion;
	private final String mensaje;
	private final String codigo;
	
	public List<ErrorValidacion> getErroresValidacion() { return erroresValidacion; }
	public String getMensaje() { return mensaje; }
	public String getCodigo() { return codigo; }
	  
	public ValidacionesException(String codigo, String mensaje, List<ErrorValidacion> erroresValidacion){
	    this.erroresValidacion = erroresValidacion;
	    this.mensaje = mensaje;
	    this.codigo = codigo;
	}
	  
	public ValidacionesException(String codigo, String mensaje, List<ErrorValidacion> erroresValidacion, Throwable t){
	    super(t);
	    this.erroresValidacion = erroresValidacion;
	    this.mensaje = mensaje;
	    this.codigo = codigo;
	}

}
