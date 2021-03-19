package test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Cuadricula;

class CuadriculaTests {
	
	@Test
	void wrongSudokuFile() {
		try {
			List<Integer> myNumbers = new ArrayList<>();
		    myNumbers.add(33);
		    myNumbers.add(15);
		    myNumbers.add(20);
		    myNumbers.add(34);
		    myNumbers.add(8);
		    myNumbers.add(12);
			Cuadricula.getCuadricula().init("", myNumbers);
			fail("Must have 81 values");
		} catch (IllegalArgumentException e) {

		}
	}
}
