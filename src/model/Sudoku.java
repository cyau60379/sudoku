package model;

import java.util.List;

public abstract class Sudoku {

	private String id;
	private List<Integer> solucion;
	private Nivel nivel;
	private List<Integer> startCuadricula;

	/**
	 * 
	 * @param pId
	 * @param pNivel
	 * @param pStartCuadricula
	 * @param pSolucion
	 */
	public Sudoku(String pId, Nivel pNivel, List<Integer> pStartCuadricula, List<Integer> pSolucion) {
		id = pId;
		nivel = pNivel;
		solucion = pSolucion;
		startCuadricula = pStartCuadricula;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public String getId() {
		return id;
	}

	public List<Integer> getStartCuadricula() {
		return startCuadricula;
	}

}