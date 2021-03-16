package model;

import java.util.ArrayList;
import java.util.List;

public class Casilla {

	private int id;
	private int valor;
	private int region;
	private int linea;
	private int columna;
	private List<Integer> candidatos;
	private boolean defaultValue;

	/**
	 * 
	 * @param pId
	 * @param pValor
	 * @param pRegion
	 * @param pLinea
	 * @param pColumna
	 */
	public Casilla(int pId, int pValor, int pRegion, int pLinea, int pColumna) {
		if (pId < 0 || pId > 80 || pValor < 0 || pValor > 9 || pRegion < 0 || pRegion > 8 || pLinea < 0 || pLinea > 8 || pColumna < 0 || pColumna > 8) {
			throw new IllegalArgumentException();
		}
		id = pId;
		valor = pValor;
		region = pRegion;
		linea = pLinea;
		columna = pColumna;
		candidatos = new ArrayList<>();
		if (pValor != 0) {
			defaultValue = true;
		} else {
			defaultValue = false;
		}
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

	public int getValor() {
		return valor;
	}

	public int getId() {
		return id;
	}

	public boolean getDefaultValue() {
		return defaultValue;
	}
	
}