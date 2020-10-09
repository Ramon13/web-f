package br.com.javamon.format;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class NumberFormatter {

	public static String toBrazilCurrencyPattern( String number, Locale locale ) {
		NumberFormat nf = NumberFormat.getNumberInstance( locale );
		if(StringUtils.isBlank(number)) 
			return "";
		else
			return nf.format(Double.parseDouble(number));
	}
	
	public static Double stringCurrencyToDouble( String param, Locale locale ) throws ParseException {
		NumberFormat nf = NumberFormat.getInstance(locale);
		Number number = nf.parse(param);
		return number.doubleValue();
	}
	
}
