package br.com.javamon.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import br.com.javamon.exception.DAOException;
import br.com.javamon.util.HibernateUtil;
import br.com.javamon.validation.StringValidator;

/**
 * This class provides abstract common methods to deal with database operations
 * @author Ramon (based on Carlos Tosin tutorial code. Softblue course.)
 * @version 1.0
 * @param <T> Generic element
 */
public abstract class DAO<T> {
	
	//JPA Session object
	private Session session;
	//Generic class to use in java reflection API
	private Class<T> clazz;
	
	protected DAO(Class<T> clazz){
		session = HibernateUtil.getCurrentSession();
		this.clazz = clazz;
	}

	/**
	 * Gets the entity related to id
	 * @param id of the object id in database
	 * @return if founded in database, return the T object
	 * @throws DAOException if not found the object in database context,
	 *  wrap any other hibernate exception
	 */
	public T load(Serializable id) throws DAOException{
		try {
			return (T) session.get(clazz, id);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * Saves object in database
	 * @param obj the object to be persisted in database
	 * @throws DAOException wrap the hibernates's exceptions
	 */
	public Serializable save(T obj) throws DAOException{
		try{
			return session.save(obj);
		}catch(HibernateException e){
			throw new DAOException(e);
		}
	}
	
	/**
	 * Delete object in database
	 * @param obj the object to be deleted
	 * @throws DAOException wrap the hibernate's exceptions
	 */
	public void delete(T obj) throws DAOException{
		try{
			session.delete(obj);
		}catch(HibernateException e){
			throw new DAOException(e);
		}
	}
	
	/**
	 * List object based on hql query passed as parameter
	 * @param hql query of type "hibernate query language"
	 * @return a List of type T object
	 * @throws DAOException wrap the hibernate's exceptions
	 */
	protected List<T> list(String hql) throws DAOException{
		try{
			Query<T> query = session.createQuery(hql, clazz);
			return query.list();
		}catch(Exception e){
			throw new DAOException(e);
		}
	}
	
	public void update(T obj) throws DAOException{
		try {
			session.update(obj);
		}catch(Exception e) {
			throw new DAOException(e);
		}
	}
	
	
	protected <R> Query<R> createQuery(String hql, Class<R> clasz) throws DAOException{
		return session.createQuery(hql, clasz);
	}
	
	public Session getSession() {
		return session;
	}
}
