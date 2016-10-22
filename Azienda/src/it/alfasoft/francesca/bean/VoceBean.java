package it.alfasoft.francesca.bean;

import java.io.Serializable;

import javax.persistence.*;

import Utility.IsValid;

@Entity
public class VoceBean implements Serializable,IsValid {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Voce;
	private String nome;
	private String cognome;
	private String telefono;
	
	@ManyToOne
	private RubricaBean rubrica;

	public VoceBean() {

	}

	public VoceBean(String nome, String cognome, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}
	
	public long getId_Voce() {
		return id_Voce;
	}

	public void setId_Voce(long id_Voce) {
		this.id_Voce = id_Voce;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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

	@Override
	public boolean isValid() {

		boolean result=false;
		
		if(!nome.isEmpty() && nome!=null && 
				!cognome.isEmpty() && cognome!=null &&
				!telefono.isEmpty() && telefono!=null) {
			result=true;
		}
		
		return result;
	}

}
