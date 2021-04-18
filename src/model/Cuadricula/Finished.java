package model.Cuadricula;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Finished implements EstadoCuadricula {

	@Override
	public void init(String pId, List<Integer> pSudoku) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateCasilla(int pCasilla, int pValor) {
		return false;
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
		return "Partida terminado";
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
	public Map<Integer, Set<Integer>> getCandidatos() {
		return null;
	}

}
