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
@Table(name = "tema")
public class Tema {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	@Column(name = "nombre", length = 60)
	private String nombre;
	@Column(name = "discusion", length = 500)
	private String discusion;
	@ManyToOne
	private Acta acta;	
	
}
