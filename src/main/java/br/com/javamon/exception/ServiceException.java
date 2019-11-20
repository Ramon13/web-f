package br.com.javamon.exception;

/**
 * Abstract exceptions from service layer. 
 * @author Ramon (based on Carlos Tosin tutorial code. Softblue course)
 * @version 1.0
 *
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(Throwable throwable) {
		super(throwable);
	}
	
	public ServiceException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public ServiceException(String msg) {
		super(msg);
	}
}
