package it.alfasoft.francesca.bean;

import javax.persistence.*;

@Entity
public class ClienteBean extends UtenteBean  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ragioneSociale;
	private String pIVA;
	
	public ClienteBean() {
	}
	
	public ClienteBean(String nome, String cognome,
			String username, String password, char ruolo,String ragioneSociale, String pIVA) {
		super(nome,cognome,username,password,ruolo);
		this.ragioneSociale = ragioneSociale;
		this.pIVA = pIVA;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getpIVA() {
		return pIVA;
	}

	public void setpIVA(String pIVA) {
		this.pIVA = pIVA;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
