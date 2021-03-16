package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
	    Throwable exception = assertThrows(
	    		NullPointerException.class, () -> {
	            	Juego.getJuego().init("");
	            }
	    );
	 
	    assertEquals("The file is untraceable.", outputStreamCaptor.toString().trim());
	}

	@Test
	void fileUntraceable() {
	    Throwable exception = assertThrows(
	    		NullPointerException.class, () -> {
	            	Juego.getJuego().init("src\\resources\\sudokus.csv");
	            }
	    );
	 
	    assertEquals("The file is untraceable.", outputStreamCaptor.toString().trim());
	}
}
