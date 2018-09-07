package cl.usach.dminute.dto;

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
public class ListarActaDialogica {
	
	private ProyectoDto proyectoDto;
	private List<ActaDto> listaActa;
	private ActaDto actaDto;

}
