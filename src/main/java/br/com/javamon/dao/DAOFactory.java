package br.com.javamon.dao;

import java.lang.reflect.InvocationTargetException;

import br.com.javamon.exception.DAOException;

/**
 * Implements the factory design pattern to provides different DAO's instences
 * @author Ramon (based on Carlos Tosin tutorial code. Softblue course)
 * @version 1.0
 *
 */
public class DAOFactory {

	private static DAOFactory instance;
	
	private DAOFactory(){}
	
	/**
	 * Implements singleton design pattern. Provides only one object in all cases
	 * @return a instance of DAOFactory.Create a new instance if 
	 * no instance was previously created
	 */
	public static DAOFactory getInstance(){
		if(instance == null)
			instance = new DAOFactory();
		return instance;
	}
	
	/**
	 * Generic class to instantiate DAO's objects
	 * @param clazz - the class object
	 * @return the DAO object instantiated through reflection api
	 * @throws DAOException wrap thrown exceptions from reflection instantiation
	 */
	public <T extends DAO<?>> T getDAO(Class<T> clazz) throws DAOException{
		try {
			return clazz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException |NoSuchMethodException e) {
			throw new DAOException(e);
		}
	}
	
}
