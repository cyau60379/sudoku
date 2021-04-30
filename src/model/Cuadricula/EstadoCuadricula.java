package model.Cuadricula;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EstadoCuadricula {
	public void init();

	public void begin(String pId, List<Integer> pSudoku);

	public boolean updateCasilla(int pCasilla, int pValor);

	public boolean updateCandidatos(int pCasilla, Set<Integer> pCandidatos);

	public void autoUpdateCandidatos(int pCasilla);

	public void comprobarSolucion();

	public Map<Integer, Integer> getValores();

	public Map<Integer, Boolean> getDefaultValues();

	public Map<Integer, Boolean> getTieneError();

	public String getMensaje();

	public List<Integer> getLineasConError();

	public List<Integer> getColumnasConError();

	public List<Integer> getRegionesConError();

	public Map<Integer, Set<Integer>> getCandidatosUsuario();

	public Map<Integer, Set<Integer>> getCandidatosRegion(int pRegion);

	public Map<Integer, Set<Integer>> getCandidatosLinea(int pLinea);

	public Map<Integer, Set<Integer>> getCandidatosColumna(int pColumna);

	public Map<Integer, Set<Integer>> getCandidatos();

}
