package it.alfasoft.francesca.bean;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class VoceBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Voce;
	private String nomeVoce;
	private String cognomeVoce;
	private String telefono;

	@ManyToOne
	private RubricaBean rubrica;

	public VoceBean() {
	}

	public VoceBean(String nomeVoce, String cognomeVoce, String telefono) {
		this.nomeVoce = nomeVoce;
		this.cognomeVoce = cognomeVoce;
		this.telefono = telefono;
	}

	public long getId_Voce() {
		return id_Voce;
	}

	public void setId_Voce(long id_Voce) {
		this.id_Voce = id_Voce;
	}

	public String getNomeVoce() {
		return nomeVoce;
	}

	public void setNomeVoce(String nomeVoce) {
		this.nomeVoce = nomeVoce;
	}

	public String getCognomeVoce() {
		return cognomeVoce;
	}

	public void setCognomeVoce(String cognomeVoce) {
		this.cognomeVoce = cognomeVoce;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public RubricaBean getRubrica() {
		return rubrica;
	}

	public void setRubrica(RubricaBean rubrica) {
		this.rubrica = rubrica;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
