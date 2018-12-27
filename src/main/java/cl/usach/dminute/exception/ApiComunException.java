package cl.usach.dminute.exception;

import cl.usach.dminute.exception.type.ViajeComunErrorType;

/**
 * Clase que contiene el manejo de excepciones servicio Común del viaje Planes
 *
 * <p>
 * <B> Todos los derechos reservados por Banco de Crédito e Inveriones </B>
 * </p>
 *
 */

public class ApiComunException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ViajeComunErrorType errorType = ViajeComunErrorType.SISTEMA_ERROR;

    public ApiComunException() {
        super();
    }

    public ApiComunException(ViajeComunErrorType errorType) {
        super();
        this.errorType = errorType;
    }

    public ViajeComunErrorType getErrorType() {
        return errorType;
    }
}
