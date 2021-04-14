package model.Estados;

public class ProcesadoError implements EstadoCasilla {

	private ICasillaEstado casilla;
	
	public ProcesadoError(ICasillaEstado pCasilla) {
		casilla = pCasilla;
	}
	
	@Override
	public boolean verificarConActual(int actId, int actValor, int pId, int pValor) {
		return true;
	}

	@Override
	public void reinicializarProcesado() {
		casilla.setEstado(new Error(casilla));
	}

	@Override
	public boolean tieneError() {
		return true;
	}

}
