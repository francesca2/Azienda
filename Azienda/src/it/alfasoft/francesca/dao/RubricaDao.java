package it.alfasoft.francesca.dao;

import hibernateUtil.HibernateUtil;
import it.alfasoft.francesca.bean.UtenteBean;

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

import model.Rubrica;
import model.Voce;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RubricaDao {
	
	//Primo metodo-crea una nuova tebella rubrica
	public boolean creaRubrica(Rubrica r){

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
		Rubrica r =new Rubrica();
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
	
	public Rubrica trovaRubricaConId(long idRubrica)
	{
		Rubrica r=null;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		r=session.get(Rubrica.class, idRubrica);
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return r;
		
	}
	
	public Rubrica trovaRubricaConNome(String nome)
	{
		Rubrica r=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query= session.createQuery("from Rubrica where nomeRubrica=:x");
		query.setString("x", nome);
		r=(Rubrica) query.uniqueResult();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return r;
		
	}
	
	//Aggiorna rubrica
	public boolean aggiornaRubrica(Rubrica r)
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
	
	//Elimina Rubrica
	public boolean deleteUtente(Rubrica r)
	{
		boolean result=false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.delete(r);
		
		result =true;
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return result;
	}

}
