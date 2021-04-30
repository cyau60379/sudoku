package model.Casilla;

import java.util.HashSet;
import java.util.Set;

public class Casilla implements ICasillaEstado {

	private int id;
	private int valor;
	private int region;
	private int linea;
	private int columna;
	private Set<Integer> candidatos;
	private Set<Integer> candidatosUsuario;
	private boolean defaultValue;
	private EstadoCasilla estado;

	/**
	 * 
	 * @param pId
	 * @param pValor
	 * @param pRegion
	 * @param pLinea
	 * @param pColumna
	 */
	public Casilla(int pId, int pValor, int pRegion, int pLinea, int pColumna) {
		if (pId < 0 || pId > 80 || pValor < 0 || pValor > 9 || pRegion < 0 || pRegion > 8 || pLinea < 0 || pLinea > 8
				|| pColumna < 0 || pColumna > 8) {
			throw new IllegalArgumentException();
		}
		id = pId;
		valor = pValor;
		region = pRegion;
		linea = pLinea;
		columna = pColumna;
		candidatos = new HashSet<>();
		candidatosUsuario = new HashSet<>();
		if (pValor != 0) {
			defaultValue = true;
		} else {
			defaultValue = false;
		}
		setEstado(new Inicial(this));
	}

	/**
	 * 
	 * @param pValor
	 */
	public void setValor(int pValor) {
		if (pValor < 0 || pValor > 9) {
			throw new IllegalArgumentException();
		}
		this.valor = pValor;
	}

	public boolean esRepetido(int pValor, int pId) {
		return estado.verificarConActual(this.id, this.valor, pId, pValor);
	}

	public boolean getTieneError() {
		return estado.tieneError();
	}

	public void reinicializarProcesado() {
		estado.reinicializarProcesado();
	}

	/**
	 * 
	 * @param pCandidatos
	 */
	public void setCandidatos(Set<Integer> pCandidatos) {
		this.candidatos = pCandidatos;
	}

	public void setCandidatosUsuario(Set<Integer> listaCandidatos) {
		this.candidatosUsuario = listaCandidatos;
	}
	
	public int getValor() {
		return valor;
	}

	public int getId() {
		return id;
	}

	public boolean getDefaultValue() {
		return defaultValue;
	}

	public int getLinea() {
		return linea;
	}

	public int getColumna() {
		return columna;
	}

	public int getRegion() {
		return region;

	}

	@Override
	public void setEstado(EstadoCasilla pEstado) {
		this.estado = pEstado;

	}

	public Set<Integer> getCandidatos() {
		return candidatos;
	}

	public Set<Integer> getCandidatosUsuario() {
		return candidatosUsuario;
	}
}
