package model.Ayuda;

import java.util.ArrayList;
import java.util.List;

public class Ayuda {
	private static Ayuda mAyuda = new Ayuda();
	private List<MetodoAyuda> listaMetodos;

	// private constructor
	private Ayuda() {
		listaMetodos = new ArrayList<>();
		listaMetodos.add(new SoleCandidate());
		listaMetodos.add(new UniqueCandidate());
		// TODO: add new help functions here
	}
	
	// getter
	public static Ayuda getAyuda() {
		return mAyuda;
	}
	
	public String aplicarAyuda() {
		for (MetodoAyuda ma : listaMetodos) {
			if (ma.ayudar()) {
				return ma.getClass().getSimpleName() + " used";
			}
		}
		return null;
	}
}
