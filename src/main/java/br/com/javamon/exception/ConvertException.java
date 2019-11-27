package br.com.javamon.exception;

/**
 * Abstract exceptions from service layer. 
 * @author Ramon (based on Carlos Tosin tutorial code. Softblue course)
 * @version 1.0
 *
 */
public class ConvertException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConvertException(Throwable throwable) {
		super(throwable);
	}
	
	public ConvertException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public ConvertException(String msg) {
		super(msg);
	}
}
