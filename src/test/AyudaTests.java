package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Ayuda.Ayuda;

class AyudaTests {

	@Test
	void aplicarAyuda() {
		assertEquals(null, Ayuda.getAyuda().aplicarAyuda());
	}

}
