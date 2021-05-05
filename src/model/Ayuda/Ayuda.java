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
			List<Integer> casillaValues = ma.ayudar();
			if (casillaValues != null) {
				String message = ma.getClass().getSimpleName() + " utilizado" 
			+ "\nValor: " + casillaValues.get(0) 
			+ "\nColumna: " + casillaValues.get(1)
			+ "\nLinea: " + casillaValues.get(2)
			+ "\nRegion: " + casillaValues.get(3);
				return message;
			}
		}
		return "Imposible de aplicar ayuda aqui";
	}
}
