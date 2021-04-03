package model;

import java.util.List;

public class SudokuFactory {
	private static SudokuFactory mSudokuFactory;
	
	private SudokuFactory() {}
	
	public SudokuFactory getSudokuFactory () {
		return mSudokuFactory;
	}
	
	public Sudoku creatSudoku(String pId, int pDificultad, List<Integer> pStart, List<Integer> pSolucion) {
		
		if (pDificultad == 1) {
			return new SudokuFacil(pId, pStart, pSolucion);
		}
		else if (pDificultad == 2) {
			return new SudokuMedio(pId, pStart, pSolucion);
		}
		else if (pDificultad == 3) {
			return new SudokuDificil(pId, pStart, pSolucion);
		}
		return null;
	}
}
