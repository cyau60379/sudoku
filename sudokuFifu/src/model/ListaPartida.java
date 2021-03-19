package model;

import java.util.List;

public class ListaPartida {

	private static ListaPartida mListaPartida = new ListaPartida();
	private List<Partida> listaPartida;
	
	private ListaPartida() {
		// TODO implement constructor
	}

	// getter
	public static ListaPartida getListaPartida() {
		return mListaPartida;
	}

}