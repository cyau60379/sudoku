package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
import model.Cuadricula.Cuadricula;

class JuegoTests {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	Integer sudokuTest[] = new Integer[] {
			0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 7, 0, 0, 9, 0, 0, 0, 0,
			6, 0, 5, 0, 0, 3, 0, 8, 4,
			0, 0, 4, 0, 0, 0, 0, 5, 2,
			0, 5, 0, 3, 0, 0, 7, 0, 0,
			0, 0, 0, 0, 0, 1, 4, 0, 0,
			0, 3, 7, 0, 0, 8, 0, 0, 5,
			0, 0, 0, 0, 0, 4, 0, 0, 0,
			4, 0, 9, 7, 2, 0, 0, 0, 3
			};
	
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
	void getNiveles() {
		List<Integer> niveles = Juego.getJuego().getNiveles();
		List<Integer> nivs = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		assertArrayEquals(niveles.toArray(), nivs.toArray());
	}
	
	@Test
	void begin() {
		Juego.getJuego().init("src\\resources\\sudokus.txt");
		Juego.getJuego().begin("", 1);
		List<Integer> sudoku = Arrays.asList(sudokuTest);
		assertTrue(sudoku.toString().equals(Cuadricula.getCuadricula().getValores().values().toString()));
	}
	
	@Test
	void beginWithWrongLevel_ShouldReturnExceptionMessage() {
		Juego.getJuego().init("src\\resources\\sudokus.txt");
		Juego.getJuego().begin("", 99);
		assertEquals("Wrong Level", outputStreamCaptor.toString().trim());
	}
}
