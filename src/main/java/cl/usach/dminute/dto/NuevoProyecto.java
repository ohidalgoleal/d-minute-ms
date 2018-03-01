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
public class NuevoProyecto {
	
	private long proyectoId;
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;	
	private List<NuevoProyectoUsuarios> usuariosNuevoProyecto;
	

}
