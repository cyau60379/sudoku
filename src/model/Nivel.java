package model;

public enum Nivel {
	FACIL (1),
	MEDIO (2),
	DIFICIL (3);

	private int valor;

	private Nivel(int pValor) {
		this.valor = pValor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
    public static Nivel fromInt(int pIntNivel) {
        for (Nivel niv : Nivel.values()) {
            if (niv.valor == pIntNivel) {
                return niv;
            }
        }
        return null;
    }

}