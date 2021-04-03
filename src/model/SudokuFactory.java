package model;

import java.util.List;

public class SudokuFactory {
	private static SudokuFactory mSudokuFactory = new SudokuFactory();

	private SudokuFactory() {
	}

	public static SudokuFactory getSudokuFactory() {
		return mSudokuFactory;
	}

	public Sudoku createSudoku(String pId, int pDificultad, List<Integer> pStart, List<Integer> pSolucion) {
		Sudoku sudoku = null;
		switch (pDificultad) {
		case 1:
			sudoku = new SudokuFacil(pId, pStart, pSolucion);
			break;
		case 2:
			sudoku = new SudokuMedio(pId, pStart, pSolucion);
			break;
		case 3:
			sudoku = new SudokuDificil(pId, pStart, pSolucion);
			break;
		}
		return sudoku;
	}
}
