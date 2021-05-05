package model.Sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Cuadricula.Cuadricula;

public class ListaSudokus {

	private static ListaSudokus mListaSudokus = new ListaSudokus();
	private List<Sudoku> listaSudokus;

	private ListaSudokus() {
	}

	public static ListaSudokus getListaSudokus() {
		return mListaSudokus;
	}

	/**
	 * 
	 * @param pFicheroJuego
	 */
	public void init(String pFicheroJuego) {
		listaSudokus = new ArrayList<>();
		FileReader reader = null;
		BufferedReader table = null;
		String line = "";
		int dificulty = 0;
		String sudoku = "";
		String id = "";
		try {
			reader = new FileReader(pFicheroJuego);
			table = new BufferedReader(reader);
			while (true) {
				line = table.readLine();
				if (line == null || line.contains("S")) { // id
					if (id != "" && dificulty != 0 && sudoku != "") {
						List<Integer> startCuadricula = convertStringToList(sudoku.substring(0, sudoku.length() / 2));
						List<Integer> solucion = convertStringToList(sudoku.substring(sudoku.length() / 2));
						Sudoku newSudoku = SudokuFactory.getSudokuFactory().createSudoku(id, dificulty, startCuadricula, solucion);
						listaSudokus.add(newSudoku);
						// initialize the next sudoku
						id = line;
						dificulty = 0;
						sudoku = "";
					} else {
						id = line;
					}
					if (line == null) {
						break;
					}
				} else if (line.length() == 1) { // level
					dificulty = Integer.parseInt(line);
				} else { // matrix line
					sudoku += line;
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

	/**
	 * 
	 * @param pId
	 */
	private Sudoku getSudoku(String pId) {
		// TODO - implement ListaPartida.getSudoku
		throw new UnsupportedOperationException();
	}

	public boolean comprobarSolucion() {
		// TODO - implement ListaPartida.comprobarSolucion
		throw new UnsupportedOperationException();
	}

	private List<Integer> convertStringToList(String pString) {
		List<Integer> l = new ArrayList<>();
		String[] sTab = pString.split("");
		for (int i = 0; i < sTab.length; i++) {
			l.add(Integer.parseInt(sTab[i]));
		}
		return l;
	}

	public void begin(int pNivel) {
		try {
			List<Sudoku> sudokus = listaSudokus.stream().filter(p -> p.getNivel().getValor() == pNivel)
					.collect(Collectors.toList());
			Sudoku sudoku = sudokus.get(0); // TODO: change later if there is more that one with the same level
			Cuadricula.getCuadricula().begin(sudoku.getId(), sudoku.getStartCuadricula());	
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Wrong Level");
		}
	}

}