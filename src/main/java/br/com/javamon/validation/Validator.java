package br.com.javamon.validation;

import br.com.javamon.dao.DAOFactory;
import br.com.javamon.service.ServiceFactory;

/**
 * Super abstract class. Provides common factories to use in validator classes  
 * @author Ramon
 * @version 1.0
 */
public abstract class Validator {

	private DAOFactory daoFactory;
	private ServiceFactory serviceFactory;
	private ValidatorFactory validatorFactory;
	
	
	public Validator() {
		daoFactory = DAOFactory.getInstance();
		serviceFactory = ServiceFactory.getInstance();
	}
	
	public DAOFactory getDaoFactory() {
		return daoFactory;
	}
	
	public ServiceFactory getServiceFactory() {
		return serviceFactory;
	}
	
	public ValidatorFactory getValidatorFactory() {
		return validatorFactory;
	}
}
