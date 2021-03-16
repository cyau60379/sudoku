package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Cuadricula;

class CuadriculaTests {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	void wrongSudokuFile() {
		Cuadricula.getCuadricula().init("Hello");
	    assertEquals("The sudoku contains characters. Stop the construction", outputStreamCaptor.toString().trim());
	}

}
