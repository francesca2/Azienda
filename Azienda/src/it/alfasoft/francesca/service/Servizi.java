package it.alfasoft.francesca.service;

import java.util.List;

import it.alfasoft.francesca.bean.ClienteBean;
import it.alfasoft.francesca.bean.DipendenteBean;
import it.alfasoft.francesca.bean.RubricaBean;
import it.alfasoft.francesca.bean.UtenteBean;
import it.alfasoft.francesca.bean.VoceBean;
import it.alfasoft.francesca.dao.ClienteDao;
import it.alfasoft.francesca.dao.DipendenteDao;
import it.alfasoft.francesca.dao.RubricaDao;
import it.alfasoft.francesca.dao.UtenteDao;
import it.alfasoft.francesca.dao.VoceDao;
import Utility.PasswordCodification;

public class Servizi {
	
	UtenteDao udao=new UtenteDao();
	ClienteDao cdao=new ClienteDao();
	DipendenteDao ddao=new DipendenteDao();
	RubricaDao rdao= new RubricaDao();
	VoceDao vdao= new VoceDao();
	
	//metodi per registrare gli utenti
	public boolean registraUtente(UtenteBean u) {
		boolean result=false;
		result=udao.createUtente(u);
		
		return result;
	}
	
	public boolean registraCliente(ClienteBean c) {
		boolean result=false;
		result=cdao.createCliente(c);
		
		return result;
	}
	
	public boolean registraDipendente(DipendenteBean d) {
		boolean result=false;
		result=ddao.createDipendente(d);
		
		return result;
	}
	
	//metodo per codificare la password
	public String convertiPass(String pass){
		
		return PasswordCodification.codificatePass(pass);	
	}
	
	//metodo per trovare un utente usando il suo username
	public UtenteBean getUtente(String username) {
		UtenteBean u =udao.trovaUtenteConUsername(username);
		return u;
	}
	
	//metodo per aggiungere una voce in rubrica
	public boolean registraVoce(RubricaBean r,VoceBean v) {
		boolean result= false;
		v.setRubrica(r);
		r.addVoce(v);
		boolean b=vdao.aggiungiVoce(v);
		rdao.aggiornaRubrica(r);
		
		if(b==true)
		{
			result =true;
		}
		
		return result;
		
	}
	
	//Metodo per trovare la rubrica di un utente a seconda del suo username
	public RubricaBean trovaRubrica(String username) {
		
		RubricaBean r= rdao.trovaRubricaConNome(username);
		
		return r;
	}
	
	//metodo per prendere tutte le voci di rubrica
		public List<VoceBean> getVoci(RubricaBean r)
		{
			List<VoceBean> voci= rdao.getVociRubrica(r.getNomeRubrica());
			
			return voci;
	}
		
		
		//metodo per eliminare una voce
		public boolean eliminaVoce(RubricaBean r, String nome, String cognome)
		{
			VoceBean v=vdao.trovaVoce(nome, cognome, r.getIdRubrica());
			boolean result=vdao.eliminaVoce(v);
			return result;
	}

}
