package br.com.javamon.validatior;

import org.apache.commons.lang3.StringUtils;

public class StringValidator extends Validator{

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
}
