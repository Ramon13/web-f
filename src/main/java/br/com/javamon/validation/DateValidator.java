package br.com.javamon.validation;

import java.time.LocalDate;

public class DateValidator {

	/**
	 * Check If date Is Within Range
	 * @param startDate
	 * @param endDate
	 * @param date
	 * @return true If date Is Between startDate And endDate
	 */
	public static boolean isWithinRange(LocalDate startDate, LocalDate endDate, LocalDate date) {
		return !(date.isBefore(startDate) || date.isAfter(endDate));
	}
}
