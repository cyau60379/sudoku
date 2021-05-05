package model.Ayuda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.Cuadricula.Cuadricula;

public class UniqueCandidate implements MetodoAyuda {

	@Override
	public List<Integer> ayudar() {
		String[] locations = {"region", "line", "column"};
		for (String location : locations) {
			List<Integer> list = verify(location);
			if (list != null) {
				return list;
			}
		}
		return null;
	}
	
	private List<Integer> verify(String pLocation) {
		// loop on the nine regions of the table
		for (int i = 0; i < 9; i++) {
			// map containing the values from 1 to 9 and a list of the square which could contain it
			Map<Integer, List<Integer>> possibleValues = new HashMap<>();
			for (int n = 1; n < 10; n++) {
				possibleValues.put(n, new ArrayList<>());
			}

			// map with id as key and list of cadidates as value
			Map<Integer, Set<Integer>> lista;
			switch (pLocation) {
			case "region":
				lista = Cuadricula.getCuadricula().getCandidatosRegion(i);
				break;
			case "line":
				lista = Cuadricula.getCuadricula().getCandidatosLinea(i);
				break;
			case "column":
				lista = Cuadricula.getCuadricula().getCandidatosColumna(i);
				break;
			default:
				lista = new HashMap<>();
				break;
			}

			// fill the array of possible values
			for (int casilla : lista.keySet()) {
				lista.get(casilla).stream().forEach(p -> possibleValues.get(p).add(casilla));
			}

			// update the first square which respect the unique candidate condition
			for (int value : possibleValues.keySet()) {
				if (possibleValues.get(value).size() == 1) {
					return Cuadricula.getCuadricula().updateCasilla(possibleValues.get(value).get(0), value);
				}
			}
		}
		return null;
	}

}
