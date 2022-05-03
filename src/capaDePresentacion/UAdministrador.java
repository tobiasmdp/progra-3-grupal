package capaDePresentacion;

import capaDeNegocios.Agencia;

public class UAdministrador implements IUsuario{


	public void setV1(int valor) {
		Agencia.getInstance().setV1(valor);
	}
	public void setV2(int valor) {
		Agencia.getInstance().setV2(valor);
	}
	
	public void activarRonda(){
		Agencia.getInstance().rondaEncuentrosLaborales();;
	}
	
}
