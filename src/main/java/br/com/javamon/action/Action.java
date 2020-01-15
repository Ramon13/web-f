package br.com.javamon.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javamon.service.ServiceFactory;
import br.com.javamon.util.HibernateUtil;

/**
 * This super class provides common methods to deal with http request and responses operations
 * Implements the design pattern "template method", automating Hibernate transactional process (#runAction)
 * @author Ramon (based on Carlos Tosin tutorial code. Softblue course.)
 * @version 1.0
 */
public abstract class Action {

	private ServiceFactory serviceFactory;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	/**
	 * Abstract method. This method should be implemented by subclasses 
	 * @throws Exception 
	 */
	public abstract void process() throws Exception;
	
	/**
	 * Template method design pattern
	 * @throws Exception
	 */
	public void runAction() throws Exception{
		try{
			HibernateUtil.beginTransaction();
			process();
			HibernateUtil.commitTransaction();
		}catch(Exception e){
			HibernateUtil.rollbackTransaction();
			throw new Exception(e);
		}
	}
	
	/**
	 * Fowards a request
	 * @param path for the request to be sent
	 * @throws Exception
	 */
	protected void foward(String path) throws Exception{
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	/**
	 * Redirects a request
	 * @param path for the request to be sent
	 * @throws Exception
	 */
	protected void redirect(String path) throws Exception{
		String contextRoot = request.getContextPath();
		response.sendRedirect(contextRoot + "/" + path);
	}
	
	public void setRequest(HttpServletRequest request){
		this.request = request;
	}
	
	protected HttpServletRequest getRequest(){
		return request;
	}
	
	public void setResponse(HttpServletResponse response){
		this.response = response;
	}
	
	protected HttpServletResponse getResponse(){
		return response;
	}

	protected ServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
	
	public void putInSession(String arg, Object obj){
		getRequest().getSession().setAttribute(arg, obj);
	}
}
