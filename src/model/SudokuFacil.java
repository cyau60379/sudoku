package model;

import java.util.List;

public class SudokuFacil extends Sudoku {

	public SudokuFacil(String pId, List<Integer> pStartCuadricula, List<Integer> pSolucion) {
		super(pId, Nivel.FACIL, pStartCuadricula, pSolucion);
	}

}
