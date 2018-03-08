package cl.usach.dminute.dto;

import java.util.Date;
import java.util.List;

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
public class ActaResponse {
	
	private long actaId;
	private Date fecha;
	private String resumen;
	private long correlativo;	
	private String estado;
	private long proyectoId;
	private List<UsuarioActaResponse> usuarioActa;
	
	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	public class UsuarioActaResponse{
		
		private String asiste;
		private String secretario;
		private String username;
		private long actaId;
		
	}
}
