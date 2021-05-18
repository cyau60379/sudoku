package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import model.Ayuda.Ayuda;
import model.Cuadricula.Cuadricula;
import model.Sudoku.ListaSudokus;

public class Juego extends Observable {

	private static Juego mJuego = new Juego();

	private Juego() {
	}

	// getter
	public static Juego getJuego() {
		return mJuego;
	}

	public void init(String pFicheroJuego) {
		ListaSudokus.getListaSudokus().init(pFicheroJuego);
		Cuadricula.getCuadricula().init();
		Ayuda.getAyuda().init();
	}

	public void begin(String pNombre, int pNivel) {
		ListaSudokus.getListaSudokus().begin(pNivel);
		Cuadricula.getCuadricula().setNombrePartida(pNombre);
	}

	/**
	 * 
	 * @param pCasilla
	 * @param pValor
	 */
	public void updateCasilla(int pCasilla, int pValor) {
		List<Integer> casilla = Cuadricula.getCuadricula().updateCasilla(pCasilla, pValor);
		if (casilla != null) {
			Logger.getLogger().write("[GAMER MOVE] Actualizacion valor casilla " + pCasilla + ": " + casilla.get(0));
		}
		setChanged();
		notifyObservers();
		comprobarSolucion();
	}

	/**
	 * 
	 * @param pCasilla
	 * @param pCanditatos
	 */
	public void updateCandidatos(int pCasilla, Set<Integer> listaCandidatos) {
		Cuadricula.getCuadricula().updateCandidatos(pCasilla, listaCandidatos);
		setChanged();
		notifyObservers();
	}

	public void autoUpdateCandidatos(int pCasilla) {
		Cuadricula.getCuadricula().autoUpdateCandidatos(pCasilla);
		setChanged();
		notifyObservers();
	}

	public Map<Integer, Integer> getPartida() {
		return Cuadricula.getCuadricula().getValores();
	}

	public Map<Integer, Boolean> getDefaultValues() {
		return Cuadricula.getCuadricula().getDefaultValues();
	}

	public Map<Integer, Boolean> getTieneError() {
		return Cuadricula.getCuadricula().getTieneError();
	}

	public List<Integer> getLineasConError() {
		return Cuadricula.getCuadricula().getLineasConError();
	}

	public List<Integer> getColumnasConError() {
		return Cuadricula.getCuadricula().getColumnasConError();
	}

	public List<Integer> getRegionesConError() {
		return Cuadricula.getCuadricula().getRegionesConError();
	}

	public String getMensaje() {
		return Cuadricula.getCuadricula().getMensaje();
	}

	public void comprobarSolucion() {
		Cuadricula.getCuadricula().comprobarSolucion();
		if (!isFinished()) {
			setChanged();
			notifyObservers();
		} else {
			saveRanking();
		}
	}

	public List<Integer> getNiveles() {
		List<Integer> niveles = new ArrayList<>();
		for (Nivel s : Nivel.values()) {
			niveles.add(s.getValor());
		}
		return niveles;
	}

	public Map<Integer, Set<Integer>> getCandidatos() {
		return Cuadricula.getCuadricula().getCandidatosUsuario();
	}

	public String getAyuda() {
		String message = Ayuda.getAyuda().aplicarAyuda();
		setChanged();
		notifyObservers();
		Cuadricula.getCuadricula().finish();
		if (isFinished()) {
			saveRanking();
		}
		return message;
	}

	public List<Map<String, String>> getRanking(int pNivel) {
		return Ranking.getRanking().ordenarRanking(pNivel);
	}

	public void saveRanking() {
		Ranking.getRanking().saveRanking();
	}

	public boolean isFinished() {
		return Cuadricula.getCuadricula().isFinished();
	}
}
