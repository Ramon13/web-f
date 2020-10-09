package br.com.javamon.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * @version 1.0
 * @author Ramon (based on Carlos Tosin tutorial code. Softblue course)
 */
public class HibernateUtil {

	//Hibernate session factory
	private static SessionFactory sessionFactory;
	
	/**
	 * Inicialize hibernate session factory along with the application
	 */
	static{
		Configuration cfg = new Configuration().configure();
		HibernateUtil.sessionFactory = cfg.buildSessionFactory();
	}
	
	/**
	 * Obtains the current session.
	 * @return the Session that belongs a current thread.
	 * Caution: this method does not create a new session, recommended 
	 * in only thread for each user context
	 */
	public static Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public static void beginTransaction(){
		getCurrentSession().getTransaction().begin();
	}
	
	public static void commitTransaction(){
		getCurrentSession().getTransaction().commit();
	}
	
	public static void rollbackTransaction(){
		getCurrentSession().getTransaction().rollback();
	}
}
