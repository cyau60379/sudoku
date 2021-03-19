package model;

import java.util.List;
import java.util.Map;

public class Partida {

	private String id;
	private Nivel nivel;
	private String nombreJugador;

	/**
	 * 
	 * @param pId
	 * @param pNivel
	 * @param pNombreJugador
	 * @param pCuadricula
	 * @param pSolucion
	 */
	public Partida(String pId, Nivel pNivel, String pNombreJugador, String pSudoku) {
		id = pId;
		nivel = pNivel;
		nombreJugador = pNombreJugador;
		String cuad = pSudoku.substring(0, pSudoku.length() / 2);
		String sol = pSudoku.substring(pSudoku.length() / 2);
		Cuadricula.getCuadricula().init(cuad);
		Solucion.getSolucion().init(sol);
	}

	/**
	 * 
	 * @param pCasilla
	 * @param pValor
	 */
	public boolean updateCasilla(int pCasilla, int pValor) {
		return Cuadricula.getCuadricula().updateCasilla(pCasilla, pValor);
	}

	/**
	 * 
	 * @param pCasilla
	 * @param pCandidatos
	 */
	public boolean udpateCandidatos(int pCasilla, List<Integer> pCandidatos) {
		// TODO - implement Partida.udpateCandidatos
		throw new UnsupportedOperationException();
	}

	public void comprobarSolucion() {
		// TODO - implement Partida.comprobarSolucion
		throw new UnsupportedOperationException();
	}

	public Map<Integer, Integer> getValores() {
		return Cuadricula.getCuadricula().getValores();
	}

	public Map<Integer, Boolean> getDefaultValues() {
		return Cuadricula.getCuadricula().getDefaultValues();
	}

}