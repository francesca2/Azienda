package it.alfasoft.francesca.dao;

import hibernateUtil.HibernateUtil;
import it.alfasoft.francesca.bean.ClienteBean;
import it.alfasoft.francesca.bean.UtenteBean;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao {
	
	public boolean createCliente(ClienteBean c)
	{
		boolean result=false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(c);
		
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
