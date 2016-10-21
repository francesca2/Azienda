package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Rubrica {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Rubrica;
	
	private String nomeRubrica;
	
	@OneToMany(mappedBy="rubrica",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Voce> listaVoci= new HashSet<Voce>();
	
	public Rubrica() {
	}
	
	public Rubrica(long id_Rubrica, String nomeRubrica, Set<Voce> listaVoci) {
		this.id_Rubrica = id_Rubrica;
		this.nomeRubrica = nomeRubrica;
		this.listaVoci = listaVoci;
	}

	public long getId_Rubrica() {
		return id_Rubrica;
	}

	public void setId_Rubrica(long id_Rubrica) {
		this.id_Rubrica = id_Rubrica;
	}

	public String getNomeRubrica() {
		return nomeRubrica;
	}

	public void setNomeRubrica(String nomeRubrica) {
		this.nomeRubrica = nomeRubrica;
	}

	public Set<Voce> getListaVoci() {
		return listaVoci;
	}

	public void setListaVoci(Set<Voce> listaVoci) {
		this.listaVoci = listaVoci;
	}

}
