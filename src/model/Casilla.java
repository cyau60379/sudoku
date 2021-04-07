package model;

import java.util.ArrayList;
import java.util.List;

import model.Estados.ICasillaEstado;

public class Casilla implements ICasillaEstado{

	private int id;
	private int valor;
	private int region;
	private int linea;
	private int columna;
	private List<Integer> candidatos;
	private boolean defaultValue;
	private boolean tieneError;
	private boolean esProcesado;

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
		tieneError = false;
		esProcesado = false;
		candidatos = new ArrayList<>();
		if (pValor != 0) {
			defaultValue = true;
		} else {
			defaultValue = false;
		}

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

	public boolean esRepetido(int pValor, int pid) {
		if (esProcesado == false) {
			if (valor == pValor && id != pid && pValor!= 0) {
				esProcesado = true;
				tieneError = true;
				
				return true;
			}
			
			esProcesado = false;
			tieneError = false;
			return false;
		}
		return true;
	}

	public boolean getTieneError() {
		return tieneError;
	}

	public void setTieneError(boolean ptieneError) {
		tieneError = ptieneError;
	}

	public void setEsProcesado(boolean pEsProcesado) {
		esProcesado = pEsProcesado;
	}

	/**
	 * 
	 * @param pCandidatos
	 */
	public void setCandidatos(List<Integer> pCandidatos) {
		this.candidatos = pCandidatos;
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
	public void setEstado() {
		// TODO Auto-generated method stub
		
	}

}