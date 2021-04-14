package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Casilla;

class CasillaTests {

	@Test
	public void defaultValueIsSetCorrectly() {
		Casilla casilla1 = new Casilla(0, 0, 1, 1, 1);
		Casilla casilla2 = new Casilla(0, 8, 1, 1, 1);
		assertFalse(casilla1.getDefaultValue());
		assertTrue(casilla2.getDefaultValue());
	}

	@Test
	public void idIsNegative() {
		try {
			Casilla casilla = new Casilla(-1, 0, 0, 0, 0);
			fail("Id must be a positive integer between 0 and 80");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void idIsOverTheLimitNumber() {
		try {
			Casilla casilla = new Casilla(100, 0, 0, 0, 0);
			fail("Id must be a positive integer between 0 and 80");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void valorIsNegative() {
		try {
			Casilla casilla = new Casilla(0, -1, 0, 0, 0);
			fail("valor must be a positive integer between 0 and 9");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void valorIsOverTheLimitNumber() {
		try {
			Casilla casilla = new Casilla(0, 10, 0, 0, 0);
			fail("valor must be a positive integer between 0 and 9");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void regionIsNegative() {
		try {
			Casilla casilla = new Casilla(0, 0, -1, 0, 0);
			fail("region must be a positive integer between 0 and 8");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void regionIsOverTheLimitNumber() {
		try {
			Casilla casilla = new Casilla(0, 0, 10, 0, 0);
			fail("region must be a positive integer between 0 and 8");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void lineaIsNegative() {
		try {
			Casilla casilla = new Casilla(0, 0, 0, -1, 0);
			fail("linea must be a positive integer between 0 and 8");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void lineaIsOverTheLimitNumber() {
		try {
			Casilla casilla = new Casilla(0, 0, 0, 10, 0);
			fail("linea must be a positive integer between 0 and 8");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void columnaIsNegative() {
		try {
			Casilla casilla = new Casilla(0, 0, 0, 0, -1);
			fail("columna must be a positive integer between 0 and 8");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void columnaIsOverTheLimitNumber() {
		try {
			Casilla casilla = new Casilla(0, 0, 0, 0, 10);
			fail("columna must be a positive integer between 0 and 8");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void findRepetition() {
		try {
			Casilla casilla = new Casilla(1, 3, 0, 0, 0);
			assertTrue(casilla.esRepetido(3, 80));
		} catch (IllegalArgumentException e) {
			fail("Wrong definition of Casilla: please verify your implementation");
		}
	}

	@Test
	public void doNotFindRepetitionWithDifferentValue() {
		try {
			Casilla casilla = new Casilla(1, 3, 0, 0, 0);
			assertFalse(casilla.esRepetido(1, 80));
		} catch (IllegalArgumentException e) {
			fail("Wrong definition of Casilla: please verify your implementation");
		}
	}

	@Test
	public void doNotFindRepetitionWhenProcessingCurrent() {
		try {
			Casilla casilla = new Casilla(1, 3, 0, 0, 0);
			assertFalse(casilla.esRepetido(3, 1));
		} catch (IllegalArgumentException e) {
			fail("Wrong definition of Casilla: please verify your implementation");
		}
	}

	@Test
	public void setValorWithNegativeValue() {
		try {
			Casilla casilla = new Casilla(1, 3, 0, 0, 0);
			casilla.setValor(-1);
			fail("Value must be positive");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void setValorWithOutOfBoundValue() {
		try {
			Casilla casilla = new Casilla(1, 3, 0, 0, 0);
			casilla.setValor(10);
			fail("Value must be between 0 (undefined) and 9");
		} catch (IllegalArgumentException e) {

		}
	}
}
