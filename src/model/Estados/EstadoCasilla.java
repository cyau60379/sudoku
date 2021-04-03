package model.Estados;

public interface EstadoCasilla {
	
	public void verificarConActual(int pId, int pValor);
	public void reinicializarProcesado();
	public boolean tieneError();

}
