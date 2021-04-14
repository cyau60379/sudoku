package model.Estados;

public class Inicial implements EstadoCasilla {

	private ICasillaEstado casilla;
	
	public Inicial(ICasillaEstado pCasilla) {
		casilla = pCasilla;
	}

	@Override
	public boolean verificarConActual(int actId, int actValor, int pId, int pValor) {
		if (actValor == pValor && actId != pId && pValor != 0) {
			casilla.setEstado(new ProcesadoError(casilla));
			return true;
		}
		return false;
	}

	@Override
	public void reinicializarProcesado() {}

	@Override
	public boolean tieneError() {
		return false;
	}

}
