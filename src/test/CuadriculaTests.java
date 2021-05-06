package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import model.Nivel;
import model.Cuadricula.Cuadricula;

class CuadriculaTests {

	@Test
	void updateWithoutBegin_ShouldDoNothing() {
		Cuadricula.getCuadricula().init();
		assertTrue(Cuadricula.getCuadricula().updateCasilla(0, 1) == null);
	}
	
	@Test
	void updateCandidatesWithoutBegin_ShouldDoNothing() {
		Cuadricula.getCuadricula().init();
		assertFalse(Cuadricula.getCuadricula().updateCandidatos(0, new HashSet<Integer>()));
	}
	
	@Test
	void getValuesWithoutBegin_ShouldDoNothing() {
		Cuadricula.getCuadricula().init();
		assertTrue(Cuadricula.getCuadricula().getValores() == null);
	}
	
	@Test
	void getDefaultValuesWithoutBegin_ShouldDoNothing() {
		Cuadricula.getCuadricula().init();
		assertTrue(Cuadricula.getCuadricula().getDefaultValues() == null);
	}
	
	@Test
	void getTieneErrorWithoutBegin_ShouldDoNothing() {
		Cuadricula.getCuadricula().init();
		assertTrue(Cuadricula.getCuadricula().getTieneError() == null);
	}
	
	@Test
	void getMensajeWithoutBegin() {
		Cuadricula.getCuadricula().init();
		assertTrue(Cuadricula.getCuadricula().getMensaje() == "Debe inicializar el Sudoku antes de jugar");
	}

	@Test
	void getLineasConErrorWithoutBegin_ShouldDoNothing() {
		Cuadricula.getCuadricula().init();
		assertTrue(Cuadricula.getCuadricula().getLineasConError() == null);
	}
	
	@Test
	void getColumnasConErrorWithoutBegin_ShouldDoNothing() {
		Cuadricula.getCuadricula().init();
		assertTrue(Cuadricula.getCuadricula().getColumnasConError() == null);
	}
	
	@Test
	void getRegionesConErrorWithoutBegin_ShouldDoNothing() {
		Cuadricula.getCuadricula().init();
		assertTrue(Cuadricula.getCuadricula().getRegionesConError() == null);
	}
	
	@Test
	void getCandidatosUsuarioWithoutBegin_ShouldDoNothing() {
		Cuadricula.getCuadricula().init();
		assertTrue(Cuadricula.getCuadricula().getCandidatosUsuario() == null);
	}
	
	@Test
	void getCandidatosRegionWithoutBegin_ShouldDoNothing() {
		Cuadricula.getCuadricula().init();
		assertTrue(Cuadricula.getCuadricula().getCandidatosRegion(0) == null);
	}
	
	@Test
	void getCandidatosLineaWithoutBegin_ShouldDoNothing() {
		Cuadricula.getCuadricula().init();
		assertTrue(Cuadricula.getCuadricula().getCandidatosLinea(0) == null);
	}
	
	@Test
	void getCandidatosColumnaWithoutBegin_ShouldDoNothing() {
		Cuadricula.getCuadricula().init();
		assertTrue(Cuadricula.getCuadricula().getCandidatosColumna(0) == null);
	}
	
	@Test
	void wrongSudoku() {
		try {
			List<Integer> myNumbers = new ArrayList<>();
			myNumbers.add(33);
			myNumbers.add(15);
			myNumbers.add(20);
			myNumbers.add(34);
			myNumbers.add(8);
			myNumbers.add(12);
			Cuadricula.getCuadricula().init();
			Cuadricula.getCuadricula().begin("", Nivel.FACIL, myNumbers);
			fail("Must have 81 values");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	void rightSudoku() {
		try {
			List<Integer> myNumbers = new ArrayList<>();
			for (int i = 0; i < 81; i++) {
				myNumbers.add(0);
			}
			Cuadricula.getCuadricula().init();
			Cuadricula.getCuadricula().begin("", Nivel.FACIL, myNumbers);
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
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", Nivel.FACIL, myNumbers);
		assertTrue(Cuadricula.getCuadricula().updateCasilla(0, 1) != null);
	}
	
	@Test
	void updateCasillaWithWrongValue() {
		List<Integer> myNumbers = new ArrayList<>();
		for (int i = 0; i < 81; i++) {
			myNumbers.add(0);
		}
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", Nivel.FACIL, myNumbers);
		assertFalse(Cuadricula.getCuadricula().updateCasilla(0, 99) != null);
	}

	@Test
	void updateCasillaWithOutOfBoundIndex() {
		List<Integer> myNumbers = new ArrayList<>();
		for (int i = 0; i < 81; i++) {
			myNumbers.add(0);
		}
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", Nivel.FACIL, myNumbers);
		assertFalse(Cuadricula.getCuadricula().updateCasilla(99, 0) != null);
	}
	
	@Test
	void getMensaje() {
		List<Integer> myNumbers = new ArrayList<>();
		for (int i = 0; i < 81; i++) {
			myNumbers.add(0);
		}
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", Nivel.FACIL, myNumbers);
		assertEquals("Numero de errores: 0\ncolumnas: \nlineas: \nregiones: \n", Cuadricula.getCuadricula().getMensaje());
	}
	
	@Test
	void getMensajeWithError() {
		List<Integer> myNumbers = new ArrayList<>();
		for (int i = 0; i < 81; i++) {
			myNumbers.add(0);
		}
		Cuadricula.getCuadricula().begin("", Nivel.FACIL, myNumbers);
		Cuadricula.getCuadricula().updateCasilla(0, 1);
		Cuadricula.getCuadricula().updateCasilla(1, 1);
		Cuadricula.getCuadricula().comprobarSolucion();
		assertEquals("Numero de errores: 2\ncolumnas: 0 1 \nlineas: 0 \nregiones: 0 \n", Cuadricula.getCuadricula().getMensaje());
	}
}
