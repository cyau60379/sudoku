package model.Casilla;

public interface EstadoCasilla {

	public boolean verificarConActual(int actId, int actValor, int pId, int pValor);

	public void reinicializarProcesado();

	public boolean tieneError();

}
