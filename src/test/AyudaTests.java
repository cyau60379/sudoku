package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Ayuda.Ayuda;
import model.Cuadricula.Cuadricula;

class AyudaTests {

	Integer sudokuTestUnique[] = new Integer[] {
			5, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 4, 0, 0, 0,
			0, 0, 4, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 4, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0
			};

	Integer sudokuTestSole[] = new Integer[] {
			0, 0, 0, 0, 0, 1, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 6, 0, 0, 0,
			0, 0, 0, 4, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 8, 0, 0, 0, 0,
			2, 0, 9, 0, 0, 0, 0, 0, 7,
			0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 3, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0
			};
	
	Integer sudokuTestNoHelp[] = new Integer[] {
			0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 6, 0, 0, 0,
			0, 0, 0, 4, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 8, 0, 0, 0, 0,
			2, 0, 9, 0, 0, 0, 0, 0, 7,
			0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 3, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0
			};
	
	@Test
	void noHelpPossible() {
		List<Integer> sudoku = Arrays.asList(sudokuTestNoHelp);
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", sudoku);
		assertEquals("Imposible de aplicar ayuda aqui", Ayuda.getAyuda().aplicarAyuda());
	}
	
	@Test
	void noHelpPossible_ShouldNotUpdate() {
		List<Integer> sudoku = Arrays.asList(sudokuTestNoHelp);
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", sudoku);
		Ayuda.getAyuda().aplicarAyuda();
		assertTrue(sudoku.toString().equals(Cuadricula.getCuadricula().getValores().values().toString()));
	}	
	
	@Test
	void aplicarAyudaSoleCandidateRightMessage() {
		List<Integer> sudoku = Arrays.asList(sudokuTestSole);
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", sudoku);
		assertEquals("SoleCandidate utilizado\nValor: 5\nColumna: 5\nLinea: 5\nRegion: 4", Ayuda.getAyuda().aplicarAyuda());
	}

	@Test
	void aplicarAyudaSoleCandidateUpdateIsDone() {
		List<Integer> sudoku = Arrays.asList(sudokuTestSole);
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", sudoku);
		sudoku.set(50, 5);
		Ayuda.getAyuda().aplicarAyuda();
		assertTrue(sudoku.toString().equals(Cuadricula.getCuadricula().getValores().values().toString()));
	}
	
	@Test
	void aplicarAyudaUniqueCandidateRightMessage() {
		List<Integer> sudoku = Arrays.asList(sudokuTestUnique);
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", sudoku);
		assertEquals("UniqueCandidate utilizado\nValor: 4\nColumna: 0\nLinea: 1\nRegion: 0", Ayuda.getAyuda().aplicarAyuda());
	}

	@Test
	void aplicarAyudaUniqueCandidateUpdateIsDone() {
		List<Integer> sudoku = Arrays.asList(sudokuTestUnique);
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", sudoku);
		sudoku.set(9, 4);
		Ayuda.getAyuda().aplicarAyuda();
		assertTrue(sudoku.toString().equals(Cuadricula.getCuadricula().getValores().values().toString()));
	}
}
