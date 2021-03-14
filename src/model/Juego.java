package model;

import java.util.List;
import java.util.Observable;

public class Juego extends Observable {

	private static Juego mJuego = new Juego();
	
	private Juego() {
		// TODO implement constructor
	}

	// getter
	public static Juego getJuego() {
		return mJuego;
	}

	public void init(String pFicheroJuego) {
		// TODO - implement Juego.init
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCasilla
	 * @param pValor
	 */
	public void updateCasilla(int pCasilla, int pValor) {
		// TODO - implement Juego.updateCasilla
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCasilla
	 * @param pCanditatos
	 */
	public void updateCandidatos(int pCasilla, List<Integer> pCanditatos) {
		// TODO - implement Juego.updateCandidatos
		throw new UnsupportedOperationException();
	}

	public void comprobarSolucion() {
		// TODO - implement Juego.comprobarSolucion
		throw new UnsupportedOperationException();
	}

}