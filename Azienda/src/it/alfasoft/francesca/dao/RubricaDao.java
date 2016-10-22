package it.alfasoft.francesca.dao;

import hibernateUtil.HibernateUtil;
import it.alfasoft.francesca.bean.RubricaBean;
import it.alfasoft.francesca.bean.VoceBean;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RubricaDao {
	
	//Primo metodo-crea una nuova tebella rubrica
	public boolean creaRubrica(RubricaBean r){

		boolean result=false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.persist(r);
		result=true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return result;
	}
	
	public boolean creaRubrica(String nome)
	{
		boolean result=false;
		RubricaBean r =new RubricaBean();
		r.setNomeRubrica(nome);
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.persist(r);
		result=true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return result;
	}

	//Secondo metodo- legge una rubrica
	
	public RubricaBean trovaRubricaConId(long idRubrica)
	{
		RubricaBean r=null;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		r=session.get(RubricaBean.class, idRubrica);
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return r;
		
	}
	
	public RubricaBean trovaRubricaConNome(String nome)
	{
		RubricaBean r=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query= session.createQuery("from RubricaBean where nomeRubrica=:x");
		query.setString("x", nome);
		r=(RubricaBean) query.uniqueResult();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return r;
		
	}
	
	//Aggiorna rubrica
	public boolean aggiornaRubrica(RubricaBean r)
	{
		boolean result=false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.update(r);
		result=true;
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return result;
		
	}

public List<VoceBean> getVociRubrica(String nome)
{
	List<VoceBean> voci= new ArrayList<VoceBean>();
	Session session =HibernateUtil.openSession();
	Transaction tx=null;

	try{
	tx=session.getTransaction();
	tx.begin();

	Query query= session.createQuery("from RubricaBean where nomeRubrica=:x");
	query.setString("x", nome);
	 voci=query.list();
	
	 tx.commit();
	}catch(Exception ex){
		tx.rollback();
	}finally{
		session.close();
	}
	return voci;
}

}
