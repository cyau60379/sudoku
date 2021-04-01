package main;

import view.VentanaInicial;

import java.nio.file.Paths;

import model.Juego;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego juego = Juego.getJuego();
		String path = Paths.get("src", "resources", "sudokus.txt").toString();
		juego.init(path);
		VentanaInicial ventana = new VentanaInicial();
		ventana.setVisible(true);
	}

}
