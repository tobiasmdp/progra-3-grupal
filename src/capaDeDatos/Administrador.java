package capaDeDatos;

import capaDeNegocios.Agencia;

public class Administrador extends TiposDeUsuarios{

	public Administrador(String nombreUsuario, String password) {
		super(nombreUsuario, password);
	}


	public void setV1(int valor) {
		Agencia.getInstance().setV1(valor);
	}
	public void setV2(int valor) {
		Agencia.getInstance().setV1(valor);
	}
	
	public void activarRonda(){
		Agencia.getInstance().rondaEncuentrosLaborales();;
	}
}