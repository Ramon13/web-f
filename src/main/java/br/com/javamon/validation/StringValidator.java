package br.com.javamon.validation;

import org.apache.commons.lang3.StringUtils;

import br.com.javamon.exception.ValidationException;

public class StringValidator extends Validator{
	
	/**
	 * Validates if the String is a valid converted number
	 * @param str the string to be tested
	 * @param errorMsg the error message passed to the exception
	 * @throws ValidationException the exception type that will be thrown
	 */
	public static void stringToLongValidator(String str, String errorMsg) throws ValidationException{
		try {
			Long.parseLong(str);
		}catch(NumberFormatException ex) {
			ex.printStackTrace();
			throw new ValidationException(errorMsg);
		}
	}
	
	/**
	 * Validates if a string value is empty
	 * @param str the string to be tested
	 * @param errorMsg the error message passed to the exception
	 * @throws ValidationException the exception type that will be thrown
	 */
	public static void emptyValidator(String str, String errorMsg) throws ValidationException{
		if (StringUtils.isBlank(str))
			throw new ValidationException(errorMsg);
	}
	
	/**
	 * Validates if the String reached the maximum value
	 * @param str the string to be tested
	 * @param maxLen the max size of string
	 * @param errorMsg the error message passed to the exception
	 * @throws ValidationException the exception type that will be thrown
	 */
	public static void maxLengthValidator(String str, int maxLen, String errorMsg) throws ValidationException{
		if (str.length() > maxLen)
			throw new ValidationException(errorMsg);
	}
	
	public static boolean isEqualsIgnoreCase(String str1, String str2){
		return str1.equalsIgnoreCase(str2);
	}

	public static boolean isValidLen(int maxLen, String str){
		return str.length() <= maxLen;
	}
	
	public static boolean isEmpty(String str){
		return StringUtils.isBlank(str);
	}
	
	public static boolean containsZeros(String str){
		return str.equals("0");
	}
	
	public static boolean isValidLongParse(String str){
		try {
			Long.parseLong(str);
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidIntegerParse(String str) {
		try {
			Integer.parseInt(str);
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
}
