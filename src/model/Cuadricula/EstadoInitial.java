package model.Cuadricula;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Nivel;
import model.Casilla.Casilla;

public class EstadoInitial implements EstadoCuadricula {

	@Override
	public void init() {
	}

	@Override
	public void begin(String pId,Nivel nivel ,List<Integer> pSudoku) {
		Cuadricula.getCuadricula().setIdPartida(pId);
		List<Casilla> listaCasillas = new ArrayList<>();
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
		Cuadricula.getCuadricula().setNivel(nivel);
		Cuadricula.getCuadricula().setListaCasillas(listaCasillas);
		Cuadricula.getCuadricula().calcularTodosLosCandidatos();
		long startTime=System.currentTimeMillis();
		Cuadricula.getCuadricula().setTiempoInicio(startTime);
		Cuadricula.getCuadricula().setEstado(new Ongoing());
	}

	@Override
	public List<Integer> updateCasilla(int pCasilla, int pValor) {
		return null;
	}

	@Override
	public boolean updateCandidatos(int pCasilla, Set<Integer> pCandidatos) {
		return false;
	}

	@Override
	public void autoUpdateCandidatos(int pCasilla) {

	}

	@Override
	public void comprobarSolucion() {

	}

	@Override
	public Map<Integer, Integer> getValores() {
		return null;
	}

	@Override
	public Map<Integer, Boolean> getDefaultValues() {
		return null;
	}

	@Override
	public Map<Integer, Boolean> getTieneError() {
		return null;
	}

	@Override
	public String getMensaje() {
		return "Debe inicializar el Sudoku antes de jugar";
	}

	@Override
	public List<Integer> getLineasConError() {
		return null;
	}

	@Override
	public List<Integer> getColumnasConError() {
		return null;
	}

	@Override
	public List<Integer> getRegionesConError() {
		return null;
	}

	@Override
	public Map<Integer, Set<Integer>> getCandidatosUsuario() {
		return null;
	}

	@Override
	public Map<Integer, Set<Integer>> getCandidatosRegion(int pRegion) {
		return null;
	}

	@Override
	public Map<Integer, Set<Integer>> getCandidatosLinea(int pLinea) {
		return null;
	}

	@Override
	public Map<Integer, Set<Integer>> getCandidatosColumna(int pColumna) {
		return null;
	}

	@Override
	public Map<Integer, Set<Integer>> getCandidatos() {
		return null;
	}

}
