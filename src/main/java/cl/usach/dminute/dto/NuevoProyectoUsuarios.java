package cl.usach.dminute.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class NuevoProyectoUsuarios {

	@JsonIgnore
	private long proyectoId;
	private String username;
	private String codRol;
}
