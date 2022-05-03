package capaDeNegocios;

import capaDeDatos.Empleador;
import capaDeDatos.TiposDeUsuarios;

public class NodoLogeoEmpleador {
	private TiposDeUsuarios usuario;
	private Empleador empleador;
	
	
	
	public NodoLogeoEmpleador(TiposDeUsuarios auxusuario, Empleador empleador) {
		super();
		this.usuario = auxusuario;
		this.empleador = empleador;
	}
	public TiposDeUsuarios getUsuario() {
		return usuario;
	}
	public Empleador getEmpleador() {
		return empleador;
	}
	
	
	
}
