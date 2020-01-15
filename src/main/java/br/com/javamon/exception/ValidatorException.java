package br.com.javamon.exception;

/**
 * Abstract exceptions from service layer. 
 * @author Ramon (based on Carlos Tosin tutorial code. Softblue course)
 * @version 1.0
 *
 */
public class ValidatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidatorException(){};
	
	public ValidatorException(Throwable throwable) {
		super(throwable);
	}
	
	public ValidatorException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public ValidatorException(String msg) {
		super(msg);
	}
}
