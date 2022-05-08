package capaDePresentacion;

import capaDeNegocios.Agencia;
import capaDeNegocios.Contratacion;
import excepciones.LoginException;

// crear los metodos para visualizar las lista de asignaciones Usuario_puntaje

// crear clase astracta UCliente con cambiarEStadoTicket, elegirUsuario_puntaje y listaDeAsignaciones

public abstract class Usuario {
	
	public boolean login(String nombreUsuario, String contrasenia) {
		boolean resultado = true;
		try {
			Agencia.getInstance().login(nombreUsuario, contrasenia, this);
		}
		catch (LoginException e) {
			System.out.println(e.getMessage());
			resultado = false;
		}
		return resultado;
	}
	
	public void mostrarListaContrataciones() {
		for(Contratacion contratacion:Agencia.getInstance().getContrataciones()) {
			System.out.println(contratacion);
		}
	}
	
	public void logout() {
		Agencia.getInstance().logout(this); 
	}
	
	public void borrarCuenta() {
		Agencia.getInstance().borrarCuenta(this);
	}
}
