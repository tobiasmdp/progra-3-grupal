package capaDeNegocios;

import capaDeDatos.Empleador;
import capaDePresentacion.Usuario;


/**
 *<b>
 * Clase nexo entre la capa de presentacion y la capa de datos que se usa en la capa de negocios.
 */
public class NodoLogeoEmpleador {
	private Usuario usuario;
	private Empleador empleador;
	
	public NodoLogeoEmpleador(Usuario auxusuario, Empleador empleador) {
		super();
		this.usuario = auxusuario;
		this.empleador = empleador;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Empleador getEmpleador() {
		return empleador;
	}
	
	
	
}
