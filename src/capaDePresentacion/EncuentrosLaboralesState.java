package capaDePresentacion;

import capaDeNegocios.Agencia;

public class EncuentrosLaboralesState implements State {
	private UAdministrador admin;
	
	public EncuentrosLaboralesState(UAdministrador admin) {
		this.admin = admin;
	}
	
	@Override
	public void gatillarRonda() {
		Agencia.getInstance().rondaEncuentrosLaborales();
		this.admin.setEstadoRonda(new ContratacionesState(admin));
	}
}
