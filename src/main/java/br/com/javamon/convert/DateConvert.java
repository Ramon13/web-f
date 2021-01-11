package br.com.javamon.convert;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

import br.com.javamon.exception.ConvertException;

/**
 * This class provides common statics methods to handles with date conversions
 * tasks
 * 
 * @author ramon
 * @version 1.0
 *
 */
public class DateConvert extends Convert {

	/**
	 * Convert java.time.LocalDate to java.util.Date
	 * 
	 * @param localDate the object to be converted
	 * @return the converted java.util.Date
	 * @throws ConvertException
	 */
	public static Date localDateToDate(LocalDate localDate) throws ConvertException {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Parse java.time.LocalDate to java.util.String following a specific pattern
	 * 
	 * @param localdate   the object to be parsed
	 * @param datePattern the date pattern to be applied
	 * @param locale      the Locale object to be used with datePattern
	 * @return the date formated according locale and pattern
	 * @throws ConvertException
	 */
	public static String parseLocalDateToString(LocalDate localdate, String datePattern, Locale locale)
			throws ConvertException {
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern, locale);
		return sdf.format(Date.from(localdate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}
	
	public static String parseLocalDateToString(LocalDate localdate, String datePattern)
			throws ConvertException {
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		return sdf.format(Date.from(localdate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

	public static LocalDate stringToLocalDate(String stringDate, String datePattern) throws ConvertException {
		try {
			return LocalDate.parse(stringDate, DateTimeFormatter.ofPattern(datePattern));
		} catch (DateTimeParseException e) {
			throw new ConvertException(e);
		}
	}
	
	public static boolean isValidDate(String stringDate, String datePattern) {
		try {
			LocalDate.parse(stringDate, DateTimeFormatter.ofPattern(datePattern));
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}