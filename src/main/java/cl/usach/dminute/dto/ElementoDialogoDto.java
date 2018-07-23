package cl.usach.dminute.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ElementoDialogoDto {

	private long idElemento;
	private Date fechaCompromiso;
	private String descripcion;
	private String estado; //TODO-DOING-DONE-DEL
	private String username;
	private long temaId;
	private String codRol;	
	
}
