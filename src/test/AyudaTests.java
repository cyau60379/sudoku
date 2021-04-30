package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Ayuda.Ayuda;
import model.Cuadricula.Cuadricula;

class AyudaTests {

	Integer sudokuTest[] = new Integer[] {
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

	@Test
	void aplicarAyudaUniqueCandidateRightMessage() {
		List<Integer> sudoku = Arrays.asList(sudokuTest);
		Cuadricula.getCuadricula().init("", sudoku);
		assertEquals("UniqueCandidate used", Ayuda.getAyuda().aplicarAyuda());
	}

	@Test
	void aplicarAyudaUniqueCandidateUpdateIsDone() {
		List<Integer> sudoku = Arrays.asList(sudokuTest);
		Cuadricula.getCuadricula().init("", sudoku);
		sudoku.set(9, 4);
		assertTrue(sudoku.toString().equals(Cuadricula.getCuadricula().getValores().values().toString()));
	}
}
