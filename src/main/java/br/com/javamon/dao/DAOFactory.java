package br.com.javamon.dao;

/**
 * Implements the factory design pattern to provides differents DAO's instences
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
	
}
