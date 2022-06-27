package capaDeNegocios;

public class ContratacionesState implements IStateRonda{
	/**
	 * <br>
	 * Ejecuta la ronda de contrataciones y cambia su estado a la ronda de encuentros.
	 */
	public void gatillarRonda() {
		Agencia.getInstance().setState(new EncuentrosState());
		Agencia.getInstance().rondaContrataciones();
	}

}
