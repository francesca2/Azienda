package it.alfasoft.francesca.bean;

import javax.persistence.*;

@Entity
public class DipendenteBean extends UtenteBean  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String posizione;
	private double stipendio;
	
	public DipendenteBean() {

	}
	
	
	public DipendenteBean(String nome, String cognome,
			String username, String password, char ruolo,String posizione, double stipendio) {
		super(nome,cognome,username,password,ruolo);
		this.posizione = posizione;
		this.stipendio = stipendio;
	}


	public String getPosizione() {
		return posizione;
	}


	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}


	public double getStipendio() {
		return stipendio;
	}


	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
