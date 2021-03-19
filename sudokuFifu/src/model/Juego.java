package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class Juego extends Observable {

	private static Juego mJuego = new Juego();
	private Map<Integer, String> sudokus;
	private Partida partida;

	private Juego() {
		sudokus = new HashMap<>();
	}

	// getter
	public static Juego getJuego() {
		return mJuego;
	}

	public void init(String pFicheroJuego) {
		FileReader reader = null;
		BufferedReader table = null;
		String line = "";
		int index = 0;
		String sudoku = "";
		try {
			reader = new FileReader(pFicheroJuego);
			table = new BufferedReader(reader);
			while (true) {
				line = table.readLine();
				if (line == null) {
					break;
				} else {
					if (line.contains("S")) { // id
						continue;
					} else if (line.length() == 1) { // level
						if (index != 0 && sudoku != "") {
							sudokus.put(index, sudoku);
							index = Integer.parseInt(line);
							sudoku = "";
						} else {
							index = Integer.parseInt(line);
						}
					} else { // matrix line
						sudoku += line;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("The file is untraceable.");
		} finally {
			try {
				table.close();
				reader.close();
			} catch (IOException e2) {
				e2.printStackTrace();
				System.out.println("The file is untraceable.");
			}
		}
	}

	public void begin(String pNombre, Nivel pNivel) {
		String sudoku = sudokus.get(pNivel.getValor());
		partida = new Partida(pNombre, pNivel, pNombre, sudoku);
	}

	/**
	 * 
	 * @param pCasilla
	 * @param pValor
	 */
	public void updateCasilla(int pCasilla, int pValor) {
		partida.updateCasilla(pCasilla, pValor);
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
		return partida.getValores();
	}

	public Map<Integer, Boolean> getDefaultValues() {
		return partida.getDefaultValues();
	}
	
}