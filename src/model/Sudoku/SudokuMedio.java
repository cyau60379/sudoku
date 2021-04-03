package model.Sudoku;

import java.util.List;

import model.Nivel;

public class SudokuMedio extends Sudoku {

	public SudokuMedio(String pId, List<Integer> pStartCuadricula, List<Integer> pSolucion) {
		super(pId, Nivel.MEDIO, pStartCuadricula, pSolucion);
	}

}
