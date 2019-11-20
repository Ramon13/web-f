package br.com.javamon.exception;

/**
 * Abstract exceptions from DAO layer
 * @author Ramon (based on Carlos Tosin tutorial code. Softblue course)
 * @version 1.0
 *
 */
public class DAOException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException(){}
	
	public DAOException(String message, Throwable cause){
		super(message, cause);
	}
	
	public DAOException(String message){
		super(message);
	}
	
	public DAOException(Throwable cause){
		super(cause);
	}
}
