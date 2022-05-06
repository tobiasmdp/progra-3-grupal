package capaDeNegocios;

import capaDeDatos.Administrador;
import capaDeDatos.EmpleadoPretenso;
import capaDePresentacion.Usuario;

public class NodoLogeoAdministrador {
	private Usuario usuario;
	private Administrador administrador;
	
	
	
	public NodoLogeoAdministrador(Usuario usuario, Administrador administrador) {
		this.usuario = usuario;
		this.administrador = administrador;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Administrador getEmpleado() {
		return administrador;
	}
	public void setEmpleado(Administrador administrador) {
		this.administrador = administrador;
	}
}
