package br.com.javamon.service;

import br.com.javamon.exception.ServiceException;

/**
 * Implements the factory design pattern to provides different services instances
 * @author Ramon (based on Carlos Tosin tutorial code. Softblue course)
 * @version 1.0
 */
public class ServiceFactory {

	private static ServiceFactory instance;
	
	public ServiceFactory(){}
	
	/**
	 * Implements singleton design pattern. Provides only one object in all cases
	 * @return a instance of ServiceFactory.Create a new instance if 
	 * no instance was previously created
	 */
	public static ServiceFactory getInstance(){
		if(instance == null)
			instance = new ServiceFactory();
		return instance;
	}
	
	/**
	 * Generic class to instantiate Service objects
	 * @param clazz - the class object
	 * @return the Service object instantiated through reflection api
	 * @throws ServiceException wrap thrown exceptions from reflection instantiation
	 */
	public <T extends Service> T getService(Class<T> clazz) throws ServiceException{
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new ServiceException(e);
		}
	}
}
