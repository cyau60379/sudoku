package model;

import java.util.ArrayList;
import java.util.List;

public class Solucion {

	private static Solucion mSolucion = new Solucion();
	private List<Casilla> listaCasillas;

	private Solucion() {
		// TODO implement constructor
	}

	// getter
	public static Solucion getSolucion() {
		return mSolucion;
	}

	public void init(String pSudoku) {
		listaCasillas = new ArrayList<>();
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
	}

}