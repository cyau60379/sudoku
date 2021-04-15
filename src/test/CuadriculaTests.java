package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Cuadricula;

class CuadriculaTests {

	@Test
	void wrongSudokuFile() {
		try {
			List<Integer> myNumbers = new ArrayList<>();
			myNumbers.add(33);
			myNumbers.add(15);
			myNumbers.add(20);
			myNumbers.add(34);
			myNumbers.add(8);
			myNumbers.add(12);
			Cuadricula.getCuadricula().init("", myNumbers);
			fail("Must have 81 values");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void rightSudokuFile() {
		try {
			List<Integer> myNumbers = new ArrayList<>();
			for (int i = 0; i < 81; i++) {
				myNumbers.add(0);
			}
			Cuadricula.getCuadricula().init("", myNumbers);
		} catch (IllegalArgumentException e) {
			fail("Must accept 0 as a value");
		}
	}

	@Test
	void updateCasillaWithRightValue() {
		List<Integer> myNumbers = new ArrayList<>();
		for (int i = 0; i < 81; i++) {
			myNumbers.add(0);
		}
		Cuadricula.getCuadricula().init("", myNumbers);
		assertTrue(Cuadricula.getCuadricula().updateCasilla(0, 1));
	}
	
	@Test
	void updateCasillaWithWrongValue() {
		List<Integer> myNumbers = new ArrayList<>();
		for (int i = 0; i < 81; i++) {
			myNumbers.add(0);
		}
		Cuadricula.getCuadricula().init("", myNumbers);
		assertFalse(Cuadricula.getCuadricula().updateCasilla(0, 99));
	}

	@Test
	void updateCasillaWithOutOfBoundIndex() {
		List<Integer> myNumbers = new ArrayList<>();
		for (int i = 0; i < 81; i++) {
			myNumbers.add(0);
		}
		Cuadricula.getCuadricula().init("", myNumbers);
		assertFalse(Cuadricula.getCuadricula().updateCasilla(99, 0));
	}
	
	@Test
	void getMensaje() {
		List<Integer> myNumbers = new ArrayList<>();
		for (int i = 0; i < 81; i++) {
			myNumbers.add(0);
		}
		Cuadricula.getCuadricula().init("", myNumbers);
		assertEquals("Numero de errores: 0\ncolumnas: \nlineas: \nregiones: \n", Cuadricula.getCuadricula().getMensaje());
	}
	
	@Test
	void getMensajeWithError() {
		List<Integer> myNumbers = new ArrayList<>();
		for (int i = 0; i < 81; i++) {
			myNumbers.add(0);
		}
		Cuadricula.getCuadricula().init("", myNumbers);
		Cuadricula.getCuadricula().updateCasilla(0, 1);
		Cuadricula.getCuadricula().updateCasilla(1, 1);
		Cuadricula.getCuadricula().comprobarSolucion();
		assertEquals("Numero de errores: 2\ncolumnas: 0 1 \nlineas: 0 \nregiones: 0 \n", Cuadricula.getCuadricula().getMensaje());
	}
}
