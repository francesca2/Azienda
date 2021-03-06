package it.alfasoft.francesca.service;

import java.util.List;

import model.Rubrica;
import model.Voce;
import it.alfasoft.francesca.bean.AdminBean;
import it.alfasoft.francesca.bean.ClienteBean;
import it.alfasoft.francesca.bean.DipendenteBean;
import it.alfasoft.francesca.bean.UtenteBean;
import it.alfasoft.francesca.dao.AdminDao;
import it.alfasoft.francesca.dao.ClienteDao;
import it.alfasoft.francesca.dao.DipendenteDao;
import it.alfasoft.francesca.dao.RubricaDao;
import it.alfasoft.francesca.dao.UtenteDao;
import it.alfasoft.francesca.dao.VoceDao;
import Utility.PasswordCodification;

public class Servizi {

	UtenteDao udao=new UtenteDao();
	AdminDao adao= new AdminDao();
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

	//metodo per avere la lista dei clienti
	public List<ClienteBean> getClienti(){
		return cdao.getTuttiClienti();
	}
	
	
	//metodo per avere la lista dei dipendenti
	
	public List<DipendenteBean> getDipendenti(){
		return ddao.getTuttiDipendenti();
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
	
	public AdminBean getAdmin(String username) {
		AdminBean u =adao.trovaAdminConUsername(username);
		return u;
	}
	
	public ClienteBean getCliente(String username) {
		ClienteBean u =cdao.trovaClienteConUsername(username);
		return u;
	}
	
	public DipendenteBean getDipendente(String username) {
		DipendenteBean u =ddao.trovaDipendenteConUsername(username);
		return u;
	}
	
	public boolean trovaUsername(String username) {
		boolean result =false;
		UtenteBean u =udao.trovaUtenteConUsername(username);
		if(u!=null) 
		{
			result=true;
		}
		return result;
	}
	
	
	//metodo per cancellare un utente
	public boolean eliminaUtente(UtenteBean u) {
		if(u.getRuolo()=='a')
		{
			return false;
		}
		else {
			Rubrica r=rdao.trovaRubricaConNome(u.getUsername());
			if(r!=null) {
			rdao.deleteUtente(r);
			}
			return udao.deleteUtente(u);
		}
	}

	//metodo per creare una rubrica
	public boolean registraRubrica(String username)
	{
		Rubrica r= new Rubrica(username);
		boolean b= rdao.creaRubrica(r);
		return b;
	}
	
	//metodo per aggiungere una voce in rubrica
	public boolean registraVoce(Rubrica r,Voce v) {
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
	public Rubrica trovaRubrica(String username) {

		Rubrica r= rdao.trovaRubricaConNome(username);

		return r;
	}

	//metodo per prendere tutte le voci di rubrica
	public List<Voce> getVoci(Rubrica r) {
		List<Voce> lista = vdao.getVociRubrica(r);

		return lista;
	}


	//metodo per eliminare una voce
	public boolean eliminaVoce(Rubrica r, String nome, String cognome)
	{
		Voce v=vdao.trovaVoce(nome, cognome, r.getId_Rubrica());
		boolean result=vdao.eliminaVoce(v);
		return result;
	}

}
