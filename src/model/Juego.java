package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import model.Sudoku.ListaSudokus;

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

	public void begin(String pNombre, int pNivel) {
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
	public void updateCandidatos(int pCasilla, List<Integer> pCandidatos) {
		// TODO - implement Juego.updateCandidatos
		Cuadricula.getCuadricula().updateCandidatos(pCasilla, pCandidatos);
		setChanged();
		notifyObservers();
	}

	public void calcularCandidatos(int pCasilla) {
		Cuadricula.getCuadricula().calcularCandidatos(pCasilla);
		setChanged();
		notifyObservers();
	}
	public Map<Integer, Integer> getPartida() {
		return Cuadricula.getCuadricula().getValores();
	}

	public Map<Integer, Boolean> getDefaultValues() {
		return Cuadricula.getCuadricula().getDefaultValues();
	}

	public Map<Integer, Boolean> getTieneError() {
		return Cuadricula.getCuadricula().getTieneError();
	}

	public List<Integer> getLineasConError() {
		return Cuadricula.getCuadricula().getLineasConError();
	}

	public List<Integer> getColumnasConError() {
		return Cuadricula.getCuadricula().getColumnasConError();
	}

	public List<Integer> getRegionesConError() {
		return Cuadricula.getCuadricula().getRegionesConError();
	}

	public String getMensaje() {
		return Cuadricula.getCuadricula().getMensaje();
	}

	public void comprobarSolucion() {
		Cuadricula.getCuadricula().comprobarSolucion();
		setChanged();
		notifyObservers();
	}

	public List<Integer> getNiveles() {
		List<Integer> niveles = new ArrayList<>();
		for (Nivel s : Nivel.values()) {
			niveles.add(s.getValor());
		}
		return niveles;
	}

	public Map<Integer, List<Integer>> getCandidatos() {
		return Cuadricula.getCuadricula().getCandidatos();
	}

}
