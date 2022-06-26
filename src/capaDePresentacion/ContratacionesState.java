package capaDePresentacion;

import capaDeNegocios.Agencia;

public class ContratacionesState implements State {
	private UAdministrador admin;
	
	public ContratacionesState(UAdministrador admin) {
		this.admin = admin;
	}
	
	@Override
	public void gatillarRonda() {
		Agencia.getInstance().rondaContrataciones();
		this.admin.setEstadoRonda(new EncuentrosLaboralesState(admin));
	}
}