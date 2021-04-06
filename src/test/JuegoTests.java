package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Juego;

class JuegoTests {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	void fileIsNotGiven() {
		Throwable exception = assertThrows(NullPointerException.class, () -> {
			Juego.getJuego().init("");
		});

		assertEquals("The file is untraceable.", outputStreamCaptor.toString().trim());
	}

	@Test
	void fileUntraceable() {
		Throwable exception = assertThrows(NullPointerException.class, () -> {
			Juego.getJuego().init("src\\resources\\sudokus.csv");
		});

		assertEquals("The file is untraceable.", outputStreamCaptor.toString().trim());
	}


	@Test
	void fileFound() {
		Juego.getJuego().init("src\\resources\\sudokus.txt");
		assertNotEquals("The file is untraceable.", outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void getNiveles() {
		List<Integer> niveles = Juego.getJuego().getNiveles();
		List<Integer> nivs = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		assertArrayEquals(niveles.toArray(), nivs.toArray());
	}
}
