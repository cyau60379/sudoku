package main;

import view.VentanaInicial;
import model.Juego;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego juego = Juego.getJuego();
		juego.init("src\\resources\\sudokus.txt");
		VentanaInicial ventana = new VentanaInicial();
		ventana.setVisible(true);
	}

}
