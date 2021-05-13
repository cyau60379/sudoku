package model.Cuadricula;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import model.Nivel;
import model.Casilla.Casilla;

public class Ongoing implements EstadoCuadricula {

	@Override
	public void init() {
		Cuadricula.getCuadricula().setEstado(new EstadoInitial());
	}

	@Override
	public void begin(String pId, Nivel nivel, List<Integer> pSudoku) {
	}

	@Override
	public List<Integer> updateCasilla(int pCasilla, int pValor) {
		try {
			Casilla c = Cuadricula.getCuadricula().getListaCasillas().get(pCasilla);
			c.setValor(pValor);
			Cuadricula.getCuadricula().calcularTodosLosCandidatos();
			return Arrays.asList(c.getValor(), c.getColumna(), c.getLinea(), c.getRegion());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean updateCandidatos(int pCasilla, Set<Integer> pCandidatos) {
		try {
			Casilla casilla = Cuadricula.getCuadricula().getListaCasillas().get(pCasilla);
			pCandidatos = pCandidatos.stream().filter(p -> p > 0 && p < 10).collect(Collectors.toSet());
			casilla.setCandidatosUsuario(pCandidatos);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void autoUpdateCandidatos(int pCasilla) {
		Casilla casilla = Cuadricula.getCuadricula().getListaCasillas().get(pCasilla);
		casilla.setCandidatosUsuario(Cuadricula.getCuadricula().calcularCandidatos(pCasilla));
	}

	@Override
	public void comprobarSolucion() {
		Cuadricula cuadricula = Cuadricula.getCuadricula();
		cuadricula.reinicio(cuadricula.getListaCasillas());
		cuadricula.getListaCasillas().stream().forEach(p -> cuadricula.comprobarValorCasilla(p));
		finish();
	}

	public void finish() {
		if (!getTieneError().containsValue(true) && !getValores().containsValue(0)) {
			long endTime = System.currentTimeMillis();
			Cuadricula.getCuadricula().setTiempoFinalizado(endTime);
			Cuadricula.getCuadricula().setEstado(new Finished());
		}
	}

	@Override
	public Map<Integer, Integer> getValores() {
		return Cuadricula.getCuadricula().getListaCasillas().stream()
				.collect(Collectors.toMap(Casilla::getId, Casilla::getValor));
	}

	@Override
	public Map<Integer, Boolean> getDefaultValues() {
		return Cuadricula.getCuadricula().getListaCasillas().stream()
				.collect(Collectors.toMap(Casilla::getId, Casilla::getDefaultValue));
	}

	@Override
	public Map<Integer, Boolean> getTieneError() {
		return Cuadricula.getCuadricula().getListaCasillas().stream()
				.collect(Collectors.toMap(Casilla::getId, Casilla::getTieneError));
	}

	@Override
	public String getMensaje() {
		String mensaje = "Numero de errores: " + Integer.toString(Cuadricula.getCuadricula().getErrors().size()) + "\n";
		String menCol = "columnas: ";
		for (Integer i : getColumnasConError()) {
			menCol += Integer.toString(i) + " ";
		}
		menCol += "\n";
		String menLin = "lineas: ";
		for (Integer i : getLineasConError()) {
			menLin += Integer.toString(i) + " ";
		}
		menLin += "\n";
		String menReg = "regiones: ";
		for (Integer i : getRegionesConError()) {
			menReg += Integer.toString(i) + " ";
		}
		menReg += "\n";
		return mensaje + menCol + menLin + menReg;
	}

	@Override
	public List<Integer> getLineasConError() {
		return Cuadricula.getCuadricula().getErrors().stream().map(Casilla::getLinea).distinct()
				.collect(Collectors.toList());
	}

	@Override
	public List<Integer> getColumnasConError() {
		return Cuadricula.getCuadricula().getErrors().stream().map(Casilla::getColumna).distinct()
				.collect(Collectors.toList());
	}

	@Override
	public List<Integer> getRegionesConError() {
		return Cuadricula.getCuadricula().getErrors().stream().map(Casilla::getRegion).distinct()
				.collect(Collectors.toList());
	}

	@Override
	public Map<Integer, Set<Integer>> getCandidatosUsuario() {
		return Cuadricula.getCuadricula().getListaCasillas().stream()
				.collect(Collectors.toMap(Casilla::getId, Casilla::getCandidatosUsuario));
	}

	@Override
	public Map<Integer, Set<Integer>> getCandidatos() {
		return Cuadricula.getCuadricula().getListaCasillas().stream()
				.collect(Collectors.toMap(Casilla::getId, Casilla::getCandidatos));
	}

	@Override
	public Map<Integer, Set<Integer>> getCandidatosRegion(int pRegion) {
		return Cuadricula.getCuadricula().getListaCasillas().stream().filter(p -> p.getRegion() == pRegion)
				.collect(Collectors.toMap(Casilla::getId, Casilla::getCandidatos));
	}

	@Override
	public Map<Integer, Set<Integer>> getCandidatosLinea(int pLinea) {
		return Cuadricula.getCuadricula().getListaCasillas().stream().filter(p -> p.getLinea() == pLinea)
				.collect(Collectors.toMap(Casilla::getId, Casilla::getCandidatos));
	}

	@Override
	public Map<Integer, Set<Integer>> getCandidatosColumna(int pColumna) {
		return Cuadricula.getCuadricula().getListaCasillas().stream().filter(p -> p.getColumna() == pColumna)
				.collect(Collectors.toMap(Casilla::getId, Casilla::getCandidatos));
	}

	@Override
	public boolean isFinished() {
		return false;
	}

}
