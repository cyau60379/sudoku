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
	
	@Test
	void aplicarAyudaSoleCandidateRightMessage() {
		List<Integer> sudoku = Arrays.asList(sudokuTestSole);
		Cuadricula.getCuadricula().init();
		Cuadricula.getCuadricula().begin("", sudoku);
		assertEquals("SoleCandidate used", Ayuda.getAyuda().aplicarAyuda());
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
		assertEquals("UniqueCandidate used", Ayuda.getAyuda().aplicarAyuda());
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
