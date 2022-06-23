package capaDeNegocios;

import capaDeDatos.Administrador;
import capaDePresentacion.Usuario;

/**
 *<b>
 * Clase nexo entre la capa de presentacion y la capa de datos que se usa en la capa de negocios.
 */
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
	public Administrador getAdministrador() {
		return administrador;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
}
