package model.Estados;

public class Error implements EstadoCasilla {

	private ICasillaEstado casilla;
	
	public Error(ICasillaEstado pCasilla) {
		casilla = pCasilla;
	}
	
	@Override
	public boolean verificarConActual(int actId, int actValor, int pId, int pValor) {
		if (actValor == pValor && actId != pId && pValor != 0) {
			casilla.setEstado(new ProcesadoError(casilla));
			return true;
		}
		casilla.setEstado(new Inicial(casilla));
		return false;
	}

	@Override
	public void reinicializarProcesado() {}

	@Override
	public boolean tieneError() {
		return true;
	}

}
