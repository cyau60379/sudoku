package model.Ayuda;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import model.Cuadricula.Cuadricula;

public class SoleCandidate implements MetodoAyuda {

	@Override
	public boolean ayudar() {
		Map<Integer, Set<Integer>> candidatos = Cuadricula.getCuadricula().getCandidatos();
		for (int key : candidatos.keySet()) {
			if (candidatos.get(key).size() == 1) {
				Iterator<Integer> iterator = candidatos.get(key).iterator();
				Cuadricula.getCuadricula().updateCasilla(key, iterator.next());
				return true;
			}
		}
		return false;
	}

}
