package it.alfasoft.francesca.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class RubricaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Rubrica;
	
	private String nomeRubrica;
	@OneToMany(mappedBy="rubrica",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<VoceBean> listaVoci= new HashSet<VoceBean>();

	public RubricaBean() {

	}
	
	public RubricaBean(String nomeRubrica) {
		this.nomeRubrica = nomeRubrica;
	}

	public String getNomeRubrica() {
		return nomeRubrica;
	}

	public void setNomeRubrica(String nomeRubrica) {
		this.nomeRubrica = nomeRubrica;
	}

	public long getIdRubrica() {
		return id_Rubrica;
	}

	public void setIdRubrica(long idRubrica) {
		this.id_Rubrica = idRubrica;
	}
	
	public Set<VoceBean> getListaVoci() {
		return listaVoci;
	}

	public void setListaVoci(Set<VoceBean> listaVoci) {
		this.listaVoci = listaVoci;
	}

	public long getId_Rubrica() {
		return id_Rubrica;
	}

	public void setId_Rubrica(long id_Rubrica) {
		this.id_Rubrica = id_Rubrica;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void addVoce(VoceBean v){
		this.listaVoci.add(v);
	}

}

