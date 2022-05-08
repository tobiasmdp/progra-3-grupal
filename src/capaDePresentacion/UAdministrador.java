package capaDePresentacion;

import capaDeNegocios.Agencia;

public class UAdministrador extends Usuario{

	public UAdministrador(String usuario, String contrasenia) {
		Agencia.getInstance().registroAdministrador(usuario, contrasenia, this);
	}
	
	public void setV1(int valor) {
		Agencia.getInstance().setV1(valor);
	}
	
	public void setV2(int valor) {
		Agencia.getInstance().setV2(valor);
	}
	
	public void rondaEncuentrosLaborales(){
		Agencia.getInstance().rondaEncuentrosLaborales();
	}
	
	public void rondaContrataciones(){
		Agencia.getInstance().rondaContrataciones();
	}
	
	
}
