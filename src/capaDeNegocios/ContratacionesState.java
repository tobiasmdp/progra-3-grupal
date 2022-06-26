package capaDeNegocios;

public class ContratacionesState implements IStateRonda{
	

	@Override
	public void gatillarRonda() {
		Agencia.getInstance().setState(new EncuentrosState());
		Agencia.getInstance().rondaContrataciones();
	}

}
