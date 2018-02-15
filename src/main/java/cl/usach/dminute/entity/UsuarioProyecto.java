package cl.usach.dminute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "usuarioProyecto")
public class UsuarioProyecto {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Proyecto Proyecto;
	@ManyToOne
	private RolProyecto rolProyecto;
	
}
