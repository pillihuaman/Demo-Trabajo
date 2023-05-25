package pe.gob.contraloria.bspscgestorpei.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Utilitarios {

	private static final Logger logger = LoggerFactory.getLogger(Utilitarios.class);

	private Utilitarios() {
		//Comentario SonarQube
	}

	public static Date getToday() {
		DateFormat format = new SimpleDateFormat(Constantes.FORM_DATE);
		Date date = new Date();
		try {
			return format.parse(format.format(date));
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public static String dateToString(java.util.Date date, String format) {
		String stringDate = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			stringDate = Constantes.BLANK;
			if (date != null) {
				stringDate = simpleDateFormat.format(date);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return stringDate;
	}

	public static Date stringToDate(String dateStr, String format) throws ParseException {
		Date date = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			date = formatter.parse(dateStr);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return date;
	}
}