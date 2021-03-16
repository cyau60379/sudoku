package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	public void init(String pSudoku) {
		listaCasillas = new ArrayList<>();
		try {
			String[] casillas = pSudoku.split("");
			int region;
			int linea;
			int columna;
			for (int i = 0; i < casillas.length; i++) {
				linea = i / 9;
				columna = i % 9;
				region = 3 * (linea / 3) + (columna / 3);
				listaCasillas.add(new Casilla(i, Integer.parseInt(casillas[i]), region, linea, columna));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("The sudoku contains characters. Stop the construction");
		}
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

	public Map<Integer, Integer> getValores() {
		return listaCasillas.stream().collect(Collectors.toMap(Casilla::getId, Casilla::getValor));
	}

	public Map<Integer, Boolean> getDefaultValues() {
		return listaCasillas.stream().collect(Collectors.toMap(Casilla::getId, Casilla::getDefaultValue));
	}

}