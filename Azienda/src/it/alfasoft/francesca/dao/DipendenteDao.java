package it.alfasoft.francesca.dao;

import hibernateUtil.HibernateUtil;
import it.alfasoft.francesca.bean.DipendenteBean;
import it.alfasoft.francesca.bean.UtenteBean;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DipendenteDao {

	public boolean createDipendente(DipendenteBean d)
	{
		boolean result=false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(d);
		
		 result=true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return result;	
	}
	
}
