package cl.usach.dminute.dto;

public class Constants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*6;
    public static final String SIGNING_KEY = "devglan123r";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String OK = "OK";
	public static final String ERROR_TECNICO_MENSAJE = "Ha ocurrido un error en el sistema";
	public static final String ERROR_USUARIO_EXISTE = "El usuario que se intenta guardar ya esta registrado";
	public static final String ERROR_USUARIO_INVALIDO = "El usuario no existe o su sesion a cadicado";
	public static final String ERROR_PROYECTO_ERROR = "No ha sido posible guardar el proyecto, intenta mas tarde";
	
	public static final String ERROR_TECNICO_GENERICO_COD = "001";
	public static final String ERROR_USUARIO_EXISTE_COD = "002";
	
	
}

