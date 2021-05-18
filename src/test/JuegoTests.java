package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			Juego.getJuego().init("src/resources/sudokus.csv");
		});

		assertEquals("The file is untraceable.", outputStreamCaptor.toString().trim());
	}


	@Test
	void fileFound() {
		Juego.getJuego().init("src/resources/sudokus.txt");
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
		Juego.getJuego().init("src/resources/sudokus.txt");
		Juego.getJuego().begin("", 1);
		List<Integer> sudoku = Arrays.asList(sudokuTest);
		assertTrue(sudoku.toString().equals(Cuadricula.getCuadricula().getValores().values().toString()));
	}
	
	@Test
	void beginWithWrongLevel_ShouldReturnExceptionMessage() {
		Juego.getJuego().init("src/resources/sudokus.txt");
		Juego.getJuego().begin("", 99);
		assertEquals("Wrong Level", outputStreamCaptor.toString().trim());
	}
	
	@Test
	void FinishGame_ShouldStoreRanking() {
		Integer sudokuTestUnique[] = new Integer[] {
				9, 4, 1, 5, 8, 2, 3, 7, 6,
				8, 7, 3, 4, 9, 6, 5, 2, 1,
				6, 2, 5, 1, 7, 3, 9, 8, 4,
				3, 9, 4, 8, 6, 7, 1, 5, 2,
				1, 5, 2, 3, 4, 9, 7, 6, 8,
				7, 8, 6, 2, 5, 1, 4, 3, 9,
				2, 3, 7, 9, 1, 8, 6, 4, 5,
				5, 1, 8, 6, 3, 4, 2, 9, 7,
				4, 6, 9, 7, 2, 5, 8, 1, 3,
				};
		Juego.getJuego().init("src/resources/sudokus.txt");
		Juego.getJuego().begin("Test", 1);
		for (int i = 0; i < sudokuTestUnique.length; i++) {
			Juego.getJuego().updateCasilla(i, sudokuTestUnique[i]);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Map<String, String> result = new HashMap<>();
		result.put("idPartida", "S001");
		result.put("nivel", "1");
		result.put("nombre", "Test");
		result.put("puntos", "15000.0");
		assertTrue(Juego.getJuego().getRanking(1).contains(result));
	}
}
