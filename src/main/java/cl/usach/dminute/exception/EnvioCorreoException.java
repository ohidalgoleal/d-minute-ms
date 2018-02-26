package cl.usach.dminute.exception;

public class EnvioCorreoException extends RuntimeException {

	private static final long serialVersionUID = 4440969599793386067L;

	private final String codigo;
	private final String mensaje;
	
	public EnvioCorreoException(String codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getMensaje() {
		return mensaje;
	}
}
