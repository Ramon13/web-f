package br.com.javamon.exception;

/**
 * Abstract exceptions from service layer. 
 * @author Ramon (based on Carlos Tosin tutorial code. Softblue course)
 * @version 1.0
 *
 */
public class ValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException(){};
	
	public ValidationException(Throwable throwable) {
		super(throwable);
	}
	
	public ValidationException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public ValidationException(String msg) {
		super(msg);
	}
}
