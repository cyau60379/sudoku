package model.Sudoku;

import java.util.List;

import model.Nivel;

public class SudokuFacil extends Sudoku {

	public SudokuFacil(String pId, List<Integer> pStartCuadricula, List<Integer> pSolucion) {
		super(pId, Nivel.FACIL, pStartCuadricula, pSolucion);
	}

}
