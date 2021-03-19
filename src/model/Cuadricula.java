package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cuadricula {

	private static Cuadricula mCuadricula = new Cuadricula();
	private List<Casilla> listaCasillas;
	private String idPartida;

	private Cuadricula() {
		// TODO implement constructor
	}

	// getter
	public static Cuadricula getCuadricula() {
		return mCuadricula;
	}

	public void init(String pId, List<Integer> pSudoku) {
		idPartida = pId;
		listaCasillas = new ArrayList<>();
		if (pSudoku.size() != 81) {
			throw new IllegalArgumentException();
		}
		int region;
		int linea;
		int columna;
		for (int i = 0; i < pSudoku.size(); i++) {
			linea = i / 9;
			columna = i % 9;
			region = 3 * (linea / 3) + (columna / 3);
			listaCasillas.add(new Casilla(i, pSudoku.get(i), region, linea, columna));
		}
	}

	/**
	 * 
	 * @param pCasilla
	 * @param pValor
	 */
	public boolean updateCasilla(int pCasilla, int pValor) {
		try {
			Casilla c = listaCasillas.get(pCasilla);
			c.setValor(pValor);
			return true;
		} catch (Exception e) {
			return false;
		}
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

	public Map<Integer, Integer> getValores() {
		return listaCasillas.stream().collect(Collectors.toMap(Casilla::getId, Casilla::getValor));
	}

	public Map<Integer, Boolean> getDefaultValues() {
		return listaCasillas.stream().collect(Collectors.toMap(Casilla::getId, Casilla::getDefaultValue));
	}

}