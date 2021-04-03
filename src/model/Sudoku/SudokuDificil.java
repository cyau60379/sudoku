package model.Sudoku;

import java.util.List;

import model.Nivel;

public class SudokuDificil extends Sudoku {

	public SudokuDificil(String pId, List<Integer> pStartCuadricula, List<Integer> pSolucion) {
		super(pId, Nivel.DIFICIL, pStartCuadricula, pSolucion);
	}

}
