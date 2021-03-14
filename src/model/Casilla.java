package model;

import java.util.List;

public class Casilla {

	private int valor;
	private int region;
	private int linea;
	private int columna;
	private List<Integer> candidatos;
	private boolean defaultValue;

	/**
	 * 
	 * @param pValor
	 * @param pRegion
	 * @param pLinea
	 * @param pColumna
	 */
	public Casilla(int pValor, int pRegion, int pLinea, int pColumna) {
		// TODO implement constructor
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pValor
	 */
	public void setValor(int pValor) {
		this.valor = pValor;
	}

	/**
	 * 
	 * @param pCandidatos
	 */
	public void setCandidatos(List<Integer> pCandidatos) {
		this.candidatos = pCandidatos;
	}

}