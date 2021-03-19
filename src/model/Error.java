package model;

public class Error {

	private int region;
	private int linea;
	private int columna;

	/**
	 * 
	 * @param pRegion
	 * @param pLinea
	 * @param pColumna
	 */
	public Error(int pRegion, int pLinea, int pColumna) {
		this.region = pRegion;
		this.linea = pLinea;
		this.columna = pColumna;
	}

	public int getRegion() {
		return this.region;
	}

	public int getLinea() {
		return this.linea;
	}

	public int getColumna() {
		return this.columna;
	}

}