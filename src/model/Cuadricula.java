package model;

import java.util.List;

public class Cuadricula {

	private static Cuadricula mCuadricula = new Cuadricula();
	private List<Casilla> listaCasillas;

	private Cuadricula() {
		// TODO implement constructor
	}

	// getter
	public static Cuadricula getCuadricula() {
		return mCuadricula;
	}

	private void init() {
		// TODO - implement Cuadricula.init
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCasilla
	 * @param pValor
	 */
	public boolean updateCasilla(int pCasilla, int pValor) {
		// TODO - implement Cuadricula.updateCasilla
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCasilla
	 * @param pCandidatos
	 */
	public boolean updateCandidatos(int pCasilla, List<Integer> pCandidatos) {
		// TODO - implement Cuadricula.updateCandidatos
		throw new UnsupportedOperationException();
	}

}