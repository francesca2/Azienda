package it.alfasoft.francesca.service;

import it.alfasoft.francesca.bean.UtenteBean;
import it.alfasoft.francesca.dao.UtenteDao;
import Utility.PasswordCodification;

public class Servizi {
	
	UtenteDao udao=new UtenteDao();
	
	public boolean registraUtente(UtenteBean u) {
		boolean result=false;
		result=udao.createUtente(u);
		
		return result;
	}
	
	public String convertiPass(String pass){
		
		return PasswordCodification.codificatePass(pass);	
	}
	
	public UtenteBean getUtente(String username) {
		UtenteBean u =udao.trovaUtenteConUsername(username);
		return u;
	}

}
