package br.com.javamon.convert;

import java.time.LocalDate;
import java.util.Date;

import br.com.javamon.exception.ConvertException;

public class DateConvertTest {

	public static void main(String[] args) throws ConvertException {
		localDateToDateTest(LocalDate.now());
	}
	
	private static void localDateToDateTest(LocalDate localDate) throws ConvertException{
		Date date = DateConvert.localDateToDate(localDate);
		System.out.println(date);
	}
}
