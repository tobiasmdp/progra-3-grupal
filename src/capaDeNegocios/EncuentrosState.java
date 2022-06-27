package capaDeNegocios;

public class EncuentrosState implements IStateRonda{
	/**
	 * <br>
	 * Ejecuta la ronda de encuentros y cambia su estado a la ronda de contrataciones.
	 */
	@Override
	public void gatillarRonda() {
		Agencia.getInstance().setState(new ContratacionesState());
		Agencia.getInstance().rondaEncuentrosLaborales();;
	}

}
