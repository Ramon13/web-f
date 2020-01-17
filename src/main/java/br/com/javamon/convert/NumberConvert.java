package br.com.javamon.convert;

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
	
	public static Long[] stringToLong(String ... strArr){
		Long[] longArr = new Long[strArr.length];
		for (int i = 0 ; i < strArr.length ; i++){
			longArr[i] = Long.parseLong(strArr[i]);
		}
		return longArr;	
	}
	
	public static Long stringToLong(String strArr){
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
