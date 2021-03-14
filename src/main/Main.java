package main;

import view.Ventana;
import model.Juego;
import model.Nivel;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego juego = Juego.getJuego();
		juego.init("src\\resources\\sudokus.txt");
		juego.begin("", Nivel.FACIL);
		
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}

}
