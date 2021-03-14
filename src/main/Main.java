package main;

import view.Ventana;
import model.Juego;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego juego = Juego.getJuego();
		
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}

}
