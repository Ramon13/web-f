package br.com.javamon.convert;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import br.com.javamon.exception.ConvertException;

public class NumberConvert extends Convert{

	public static Integer stringToInteger(String str){
		return Integer.valueOf(str);
	}
	
	public static Integer[] stringToInteger(String ... strArr){
		Integer[] intArr = new Integer[strArr.length];
		for (int i = 0 ; i < strArr.length ; i++){
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		return intArr;	
	}
	
	public static Integer stringToInteger(Locale locale, String s) throws ConvertException{
		try {
			return NumberFormat.getInstance(locale).parse(s).intValue();
		} catch (ParseException e) {
			throw new ConvertException(e);
		}
	}
	
	public static Double stringToDouble(Locale locale, String s) throws ConvertException{
		try {
			NumberFormat format = NumberFormat.getInstance(locale);
			format.setMaximumFractionDigits(2);
			Number number = format.parse(s);
			return  number.doubleValue();	
		} catch (Exception e) {
			throw new ConvertException(e);
		}
	}
	
	public static Long[] stringToLong(String ... strArr) throws NumberFormatException{
		Long[] longArr = new Long[strArr.length];
		for (int i = 0 ; i < strArr.length ; i++){
			longArr[i] = Long.parseLong(strArr[i]);
		}
		return longArr;	
	}
	
	public static Long stringToLong(String strArr) throws NumberFormatException{
		return Long.parseLong(strArr);
	}
	
	public static Double[] stringToDouble(String ... strArr){
		Double[] doubleArr = new Double[strArr.length];
		for (int i = 0 ; i < strArr.length ; i++){
			doubleArr[i] = Double.parseDouble(strArr[i]);
		}
		return doubleArr;	
	}
}
