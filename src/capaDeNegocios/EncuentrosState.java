package capaDeNegocios;

public class EncuentrosState implements IStateRonda{
	
	@Override
	public void gatillarRonda() {
		Agencia.getInstance().setState(new ContratacionesState());
		Agencia.getInstance().rondaEncuentrosLaborales();;
	}

}
