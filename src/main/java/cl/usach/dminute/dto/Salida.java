package cl.usach.dminute.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Salida {

	private String retorno;
	private static final String codigo = "OK";
	
	public Salida() {
		super();
		this.retorno = codigo;
	}
	
}
