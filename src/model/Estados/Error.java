package model.Estados;

public class Error implements EstadoCasilla {

	private ICasillaEstado casilla;
	
	@Override
	public void verificarConActual(int pId, int pValor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reinicializarProcesado() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean tieneError() {
		// TODO Auto-generated method stub
		return false;
	}

}
