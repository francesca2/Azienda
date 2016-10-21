package it.alfasoft.francesca.bean;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class UtenteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Utente;
	
	protected String nome;
	protected String cognome;
	protected String username;
	protected String password;
	protected char ruolo;
	
	

}
