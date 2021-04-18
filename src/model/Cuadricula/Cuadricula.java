package model.Cuadricula;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import model.Casilla;

public class Cuadricula {

	private static Cuadricula mCuadricula = new Cuadricula();
	private List<Casilla> listaCasillas;
	private String idPartida;
	private EstadoCuadricula estado;

	private Cuadricula() {
		setEstado(new Uninitialized());
	}

	// getter
	public static Cuadricula getCuadricula() {
		return mCuadricula;
	}

	public List<Casilla> getListaCasillas() {
		return listaCasillas;
	}
	
	protected List<Casilla> getErrors() {
		return listaCasillas.stream().filter(p -> p.getTieneError() && p.getDefaultValue() == false).collect(Collectors.toList());
	}
	
	// setter
	public void setIdPartida(String pId) {
		idPartida = pId;
	}
	
	public void setListaCasillas(List<Casilla> pSudoku) {
		listaCasillas = pSudoku;
	}
	
	protected void setEstado(EstadoCuadricula pEstado) {
		estado = pEstado;
	}

	protected void comprobarValorCasilla(Casilla casilla) {
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

	protected void procesar(List<Casilla> pLista) {
		for (int i = 0; i < pLista.size(); i++) {
			Casilla c = pLista.get(i);
			pLista.stream().forEach(p -> p.esRepetido(c.getValor(), c.getId()));
		}
	}

	protected void reinicio(List<Casilla> pLista) {
		pLista.stream().forEach(Casilla::reinicializarProcesado);
	}

	protected Set<Integer> calcularCandidatos(int pCasilla) {
		Casilla casilla = listaCasillas.get(pCasilla);
		List<Integer> columnas = listaCasillas.stream().filter(p -> p.getColumna() == casilla.getColumna())
				.map(Casilla::getValor).collect(Collectors.toList());
		List<Integer> lineas = listaCasillas.stream().filter(p -> p.getLinea() == casilla.getLinea())
				.map(Casilla::getValor).collect(Collectors.toList());
		List<Integer> regiones = listaCasillas.stream().filter(p -> p.getRegion() == casilla.getRegion())
				.map(Casilla::getValor).collect(Collectors.toList());
		Set<Integer> candidatos = new HashSet<Integer>();

		for (int i = 1; i < 10; i++) {
			if (!columnas.contains(i) && !lineas.contains(i) && !regiones.contains(i)) {
				candidatos.add(i);
			}
		}
		return candidatos;
	}

	protected void calcularTodosLosCandidatos() {
		listaCasillas.stream().forEach(p -> p.setCandidatos(calcularCandidatos(p.getId())));
	}

	public void init(String pId, List<Integer> pSudoku) {
		estado.init(pId, pSudoku);
	}

	public boolean updateCasilla(int pCasilla, int pValor) {
		return estado.updateCasilla(pCasilla, pValor);
	}
	
	public void comprobarSolucion() {
		estado.comprobarSolucion();
	}

	public String getMensaje() {
		return estado.getMensaje();
	}

	public Map<Integer, Set<Integer>> getCandidatos() {
			return estado.getCandidatos();
	}

	/**
	 * 
	 * @param pCasilla
	 * @param listaCandidatos
	 */
	public boolean updateCandidatos(int pCasilla, Set<Integer> pCandidatos) {
		return estado.updateCandidatos(pCasilla, pCandidatos);
	}

	public void autoUpdateCandidatos(int pCasilla) {
		estado.autoUpdateCandidatos(pCasilla);
	}
	
	public Map<Integer, Integer> getValores() {
		return estado.getValores();
	}

	public Map<Integer, Boolean> getDefaultValues() {
		return estado.getDefaultValues();
	}

	public Map<Integer, Boolean> getTieneError() {
		return estado.getTieneError();
	}

	public List<Integer> getLineasConError() {
		return estado.getLineasConError();
	}

	public List<Integer> getColumnasConError() {
		return estado.getColumnasConError();
	}

	public List<Integer> getRegionesConError() {
		return estado.getRegionesConError();
	}

}
