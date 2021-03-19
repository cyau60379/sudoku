package model;

import java.util.List;
import java.util.Map;
import java.util.Observable;

public class Juego extends Observable {

	private static Juego mJuego = new Juego();

	private Juego() {
	}

	// getter
	public static Juego getJuego() {
		return mJuego;
	}

	public void init(String pFicheroJuego) {
		ListaSudokus.getListaSudokus().init(pFicheroJuego);
	}

	public void begin(String pNombre, Nivel pNivel) {
		ListaSudokus.getListaSudokus().begin(pNivel);
	}

	/**
	 * 
	 * @param pCasilla
	 * @param pValor
	 */
	public void updateCasilla(int pCasilla, int pValor) {
		Cuadricula.getCuadricula().updateCasilla(pCasilla, pValor);
		setChanged();
		notifyObservers();
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

	public Map<Integer, Integer> getPartida() {
		return Cuadricula.getCuadricula().getValores();
	}

	public Map<Integer, Boolean> getDefaultValues() {
		return Cuadricula.getCuadricula().getDefaultValues();
	}
	
}