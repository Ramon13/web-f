package br.com.javamon.validation;

import java.lang.reflect.InvocationTargetException;

import br.com.javamon.exception.ValidatorException;

/**
 * Implements the factory design pattern to provides different validators instances
 * @author Ramon
 * @version 1.0
 */
public class ValidatorFactory {

	private static ValidatorFactory instance;
	
	public ValidatorFactory(){}
	
	/**
	 * Implements singleton design pattern. Provides only one object in all cases
	 * @return a instance of ValidatorFactory.Create a new instance if 
	 * no instance was previously created
	 */
	public static ValidatorFactory getInstance(){
		if(instance == null)
			instance = new ValidatorFactory();
		return instance;
	}
	
	/**
	 * Generic class to instantiate Validator objects
	 * @param clazz - the class object
	 * @return the Validator object instantiated through reflection api
	 * @throws ValidatorException wrap thrown exceptions from reflection instantiation
	 */
	public <T extends ValidatorFactory> T getValidator(Class<T> clazz) throws ValidatorException{
		try {
			return clazz.getDeclaredConstructor().newInstance();
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
			throw new ValidatorException(e);
		}
	}
}
