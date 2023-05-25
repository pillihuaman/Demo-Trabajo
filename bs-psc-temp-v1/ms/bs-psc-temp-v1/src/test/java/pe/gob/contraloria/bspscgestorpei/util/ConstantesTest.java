package pe.gob.contraloria.bspscgestorpei.util;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

class ConstantesTest {
	
	@Test
	void ConstantesTest() {
		Constantes Constantes = new Constantes();
		assertNotNull(Constantes);
	}
	
	@Test
	void loadConstantsTest() {
		LoadConstants loadConstants = new LoadConstants();
		assertNotNull(loadConstants);
	}
	
	@Test
	void loadMessagesTest() {
		LoadMessages loadMessages = new LoadMessages();
		assertNotNull(loadMessages);
	}
}