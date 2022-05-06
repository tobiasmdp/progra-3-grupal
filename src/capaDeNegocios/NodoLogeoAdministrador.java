package capaDeNegocios;

import capaDeDatos.Administrador;
import capaDeDatos.EmpleadoPretenso;
import capaDePresentacion.IUsuarios;

public class NodoLogeoAdministrador {
	private IUsuarios usuario;
	private Administrador administrador;
	
	
	
	public NodoLogeoAdministrador(IUsuarios usuario, Administrador administrador) {
		this.usuario = usuario;
		this.administrador = administrador;
	}
	public IUsuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(IUsuarios usuario) {
		this.usuario = usuario;
	}
	public Administrador getEmpleado() {
		return administrador;
	}
	public void setEmpleado(Administrador administrador) {
		this.administrador = administrador;
	}
}
