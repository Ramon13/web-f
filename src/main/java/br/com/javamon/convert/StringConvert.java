package br.com.javamon.convert;

import java.util.ArrayList;
import java.util.List;

import br.com.javamon.exception.ConvertException;

public class StringConvert extends Convert {

	public static List<Long> stringArrToLongList(String[] sArr){
		List<Long> longList = new ArrayList<Long>();
		for(int i = 0 ; i < sArr.length ; i++){
			longList.add(Long.parseLong(sArr[i]));
		}
		
		return longList;
	}
	
	public static Long stringToLong(String str) throws ConvertException{
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			throw new ConvertException(e);
		}
	}
}
