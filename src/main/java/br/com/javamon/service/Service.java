package br.com.javamon.service;

import br.com.javamon.convert.ConvertFactory;
import br.com.javamon.dao.DAOFactory;

/**
 * Super abstract class. Provides common factories to use in services classes  
 * @author Ramon (based on Carlos Tosin tutorial code. Softblue course)
 * @version 1.0
 */
public abstract class Service {

	private DAOFactory daoFactory;
	private ServiceFactory serviceFactory;
	private ConvertFactory convertFactory;
	
	public Service() {
		daoFactory = DAOFactory.getInstance();
		serviceFactory = ServiceFactory.getInstance();
		convertFactory = ConvertFactory.getInstance();
	}
	
	public DAOFactory getDaoFactory() {
		return daoFactory;
	}
	
	public ServiceFactory getServiceFactory() {
		return serviceFactory;
	}
	
	public ConvertFactory getConvertFactory() {
		return convertFactory;
	}
}
