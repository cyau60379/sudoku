package model;

import java.util.List;

public class Solucion {

	private static Solucion mSolucion = new Solucion();
	private List<Casilla> listaCasillas;

	private Solucion() {
		// TODO implement constructor
	}

	// getter
	public static Solucion getSolucion() {
		return mSolucion;
	}

	private void init() {
		// TODO - implement Solucion.init
		throw new UnsupportedOperationException();
	}

}