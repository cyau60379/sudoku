package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import model.Nivel;
import model.Ayuda.Ayuda;
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
	
	@Test
	void updateCandidatos() {
		List<Integer> myNumbers = new ArrayList<>();
		for (int i = 0; i < 81; i++) {
			myNumbers.add(0);
		}
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", Nivel.FACIL, myNumbers);
		Set<Integer> set = new HashSet<>();
		set.add(1);
		assertTrue(Cuadricula.getCuadricula().updateCandidatos(5, set));
	}
	
	@Test
	void updateCandidatosWithCadidatesOutOfBound_ShouldRemoveThem() {
		List<Integer> myNumbers = new ArrayList<>();
		for (int i = 0; i < 81; i++) {
			myNumbers.add(0);
		}
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", Nivel.FACIL, myNumbers);
		Set<Integer> set = new HashSet<>();
		set.add(99);
		set.add(87897);
		set.add(5);
		Cuadricula.getCuadricula().updateCandidatos(5, set);
		assertTrue(Cuadricula.getCuadricula().getListaCasillas().get(5).getCandidatos().containsAll(Arrays.asList(5)));
	}
	
	@Test
	void updateCandidatosWithIndexOutOfBound_ShouldReturnFalse() {
		List<Integer> myNumbers = new ArrayList<>();
		for (int i = 0; i < 81; i++) {
			myNumbers.add(0);
		}
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", Nivel.FACIL, myNumbers);
		Set<Integer> set = new HashSet<>();
		set.add(1);
		assertFalse(Cuadricula.getCuadricula().updateCandidatos(999, set));
	}
	
	@Test
	void CalculatePoints_ShouldReturnTheTrueResult() {
		Ayuda.getAyuda().init();
		Integer sudokuTestUnique[] = new Integer[] {
				0, 4, 1, 5, 8, 2, 3, 7, 6,
				8, 7, 3, 4, 9, 6, 5, 2, 1,
				6, 2, 5, 1, 7, 3, 9, 8, 4,
				3, 9, 4, 8, 6, 7, 1, 5, 2,
				1, 5, 2, 3, 4, 9, 7, 6, 8,
				7, 8, 6, 2, 5, 1, 4, 3, 9,
				2, 3, 7, 9, 1, 8, 6, 4, 5,
				5, 1, 8, 6, 3, 4, 2, 9, 7,
				4, 6, 9, 7, 2, 5, 8, 1, 3,
				};
		List<Integer> myNumbers = Arrays.asList(sudokuTestUnique);
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", Nivel.FACIL, myNumbers);
		try {
			Thread.sleep(3000); // Sleep 3 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Cuadricula.getCuadricula().updateCasilla(0, 9);
		Cuadricula.getCuadricula().comprobarSolucion();
		assertTrue(Cuadricula.getCuadricula().calcularPuntos() == 10000.0);
	}
}
