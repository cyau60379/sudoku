package model.Casilla;

public class Error implements EstadoCasilla {

	private ICasillaEstado casilla;

	public Error(ICasillaEstado pCasilla) {
		casilla = pCasilla;
	}

	@Override
	public boolean verificarConActual(int actId, int actValor, int pId, int pValor) {
		return true;
	}

	@Override
	public void reinicializarProcesado() {
		casilla.setEstado(new Inicial(casilla));
	}

	@Override
	public boolean tieneError() {
		return true;
	}

}
