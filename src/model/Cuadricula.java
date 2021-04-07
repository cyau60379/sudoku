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

	public void comprobarValorCasilla(Casilla casilla) {
		List<Casilla> columnas = listaCasillas.stream().filter(p -> p.getColumna() == casilla.getColumna())
				.collect(Collectors.toList());
		List<Casilla> lineas = listaCasillas.stream().filter(p -> p.getLinea() == casilla.getLinea())
				.collect(Collectors.toList());
		List<Casilla> regiones = listaCasillas.stream().filter(p -> p.getRegion() == casilla.getRegion())
				.collect(Collectors.toList());
		procesar(columnas);
		procesar(lineas);
		procesar(regiones);
	}

	public void procesar(List<Casilla> pLista) {
		for (int i = 0; i < pLista.size(); i++) {
			Casilla c = pLista.get(i);
			pLista.stream().forEach(p -> p.esRepetido(c.getValor(), c.getId()));
		}
	}

	public void reinicio(List<Casilla> pLista) {
		pLista.stream().forEach(c -> c.setEsProcesado(false));
	}

	public void comprobarSolucion() {
		listaCasillas.stream().forEach(p -> comprobarValorCasilla(p));
		reinicio(listaCasillas);
	}

	public String getMensaje() {
		List<Casilla> errors = listaCasillas.stream().filter(p -> p.getTieneError() && p.getValor() != 0 && p.getDefaultValue()==false).collect(Collectors.toList());
		int numErrors = errors.size();
		List<Integer> columnas = errors.stream().map(Casilla::getColumna).distinct().collect(Collectors.toList());
		List<Integer> lineas = errors.stream().map(Casilla::getLinea).distinct().collect(Collectors.toList());
		List<Integer> regiones = errors.stream().map(Casilla::getRegion).distinct().collect(Collectors.toList());
		String mensaje = "Numero de errores: " + Integer.toString(numErrors) + "\n";
		String menCol = "columnas: ";
		for (Integer i : columnas) {
			menCol += Integer.toString(i) + " ";
		}
		menCol += "\n";
		String menLin = "lineas: ";
		for (Integer i : lineas) {
			menLin += Integer.toString(i) + " ";
		}
		menLin += "\n";
		String menReg = "regiones: ";
		for (Integer i : regiones) {
			menReg += Integer.toString(i) + " ";
		}
		menReg += "\n";
		return mensaje + menCol + menLin + menReg;
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

	public Map<Integer, Boolean> getTieneError() {
		return listaCasillas.stream().collect(Collectors.toMap(Casilla::getId, Casilla::getTieneError));
	}
	

}