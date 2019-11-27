package br.com.javamon.convert;

import br.com.javamon.exception.ConvertException;
import br.com.javamon.exception.ServiceException;

/**
 * Implements the factory design pattern to provides different converters instances
 * @author Ramon
 * @version 1.0
 */
public class ConvertFactory {

	private static ConvertFactory instance;
	
	private ConvertFactory(){};

	/**
	 * Implements singleton design pattern. Provides only one object in all cases
	 * @return a instance of ConvertFactory.Create a new instance if 
	 * no instance was previously created
	 */
	public static ConvertFactory getInstance(){
		if(instance == null)
			instance = new ConvertFactory();
		return instance;
	}
	
	/**
	 * Generic class to instantiate Convert objects
	 * @param clazz - the class object
	 * @return the Service object instantiated through reflection api
	 * @throws ServiceException wrap thrown exceptions from reflection instantiation
	 */
	public <T extends Convert> T getConvert(Class<T> clazz) throws ConvertException{
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new ConvertException(e);
		}
	}
}
