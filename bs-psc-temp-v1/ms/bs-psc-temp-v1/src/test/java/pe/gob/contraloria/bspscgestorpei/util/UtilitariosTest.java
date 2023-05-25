package pe.gob.contraloria.bspscgestorpei.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.Test;

class UtilitariosTest {

	@Test
	void getTodayTest() {
		Date date = Utilitarios.getToday();
		assertNotNull(date);
	}

	@Test
	void dateToStringTest() {
		String date = Utilitarios.dateToString(new Date(), Constantes.FORM_DATE);
		assertNotNull(date);
	}

	@Test
	void dateToStringErrorTest() throws Exception {
		String date = Utilitarios.dateToString(new Date(), null);
		assertNull(date);
	}

	@Test
	void stringToDateTest() throws ParseException {
		Date date = Utilitarios.stringToDate("2023-03-07", Constantes.FORM_DATE);
		assertNotNull(date);
	}
}