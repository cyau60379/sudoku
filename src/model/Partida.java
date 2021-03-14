package model;

import java.util.List;

public class Partida {

	private String id;
	private Nivel nivel;
	private String nombreJugador;
	private Cuadricula cuadricula;
	private Solucion solucion;

	/**
	 * 
	 * @param pId
	 * @param pNivel
	 * @param pNombreJugador
	 * @param pCuadricula
	 * @param pSolucion
	 */
	public Partida(String pId, Nivel pNivel, int pNombreJugador, Cuadricula pCuadricula, Solucion pSolucion) {
		// TODO - implement Partida.Partida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pCasilla
	 * @param pValor
	 */
	public boolean updateCasilla(int pCasilla, int pValor) {
		// TODO - implement Partida.updateCasilla
		throw new UnsupportedOperationException();
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

}